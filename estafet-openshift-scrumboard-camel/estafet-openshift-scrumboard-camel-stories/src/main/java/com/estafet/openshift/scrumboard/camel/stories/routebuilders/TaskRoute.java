package com.estafet.openshift.scrumboard.camel.stories.routebuilders;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Predicate;
import org.apache.camel.PropertyInject;
import org.apache.camel.ValidationException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.estafet.openshift.scrumboard.camel.stories.services.Task;

public class TaskRoute extends RouteBuilder{
	
	/*@PropertyInject(value = "nxp.batch.processing.file.pattern")
    private String reportFileName;

    @PropertyInject(value = "nxp.batch.processing.file.batch.completion.timeout")
    private long completionTimeout;*/

    private void configureGlobalErrorHandling() {

        /*onException(InvalidNXPBatchFileNameException.class)
            .setHeader(ExchangeConstants.CHM_ERROR)
                .constant("Invalid NXP batch file name format: ${exception.message}")
            .setHeader(ExchangeConstants.CHM_ERROR_CODE)
                .constant(NXPExceptionCodes.INVALID_FILENAME.getErrorCode())

            .log(LoggingLevel.ERROR, "Invalid NXP batch file name format : ${exception.message}")
            .log(LoggingLevel.ERROR, "Sending error to error message queue and notifying splunk and siem")

            .to(ExchangePattern.InOnly, "direct:processing.nxp.batch.processing.error.handling.route")
            .handled(true);

        onException(ValidationException.class)
            .setHeader(ExchangeConstants.CHM_ERROR)
                .constant("XML Schema error : ${exception.message}")
            .log(LoggingLevel.ERROR, "XML Schema error: ${exception.message}")
            .setHeader(ExchangeConstants.CHM_ERROR_CODE)
                .constant(NXPExceptionCodes.INVALID_XML.getErrorCode())

            .log(LoggingLevel.ERROR, "Sending error to error to nxp failure route")
            .to(ExchangePattern.InOnly, "direct:processing.nxp.batch.processing.error.handling.route")
            .handled(true);

        onException(Throwable.class)
            .handled(true)
            .log(LoggingLevel.ERROR, "${exception.message}\n${exception.stacktrace}")
            .to(ExchangePattern.InOnly, "direct:processing.nxp.batch.processing.error.handling.route");*/
    }

    public void configure() throws Exception {
        configureGlobalErrorHandling();

        from("cxfrs:http://localhost:8183/tasks?"
        		//+ "httpMethodRestrict=POST&"
        		+ "bindingStyle=SimpleConsumer&"
        		+ "resourceClasses=com.estafet.openshift.scrumboard.camel.stories.services.TaskService")
        .routeId("com.estafet.openshift.scrumboard.camel.tasks")
        .streamCaching()
        
        .log(LoggingLevel.INFO, "${header.CamelHttpMethod}")
        .log(LoggingLevel.INFO, "Operation Name: ${header.operationName}")
		.choice()
			.when(simple("${header.CamelHttpMethod} =~ 'GET'"))
				.bean("taskProcessor", "searchTask")
//				.marshal().json(JsonLibrary.Jackson)
			.when(simple("${header.CamelHttpMethod} =~ 'POST'"))
				.unmarshal().json(JsonLibrary.Jackson, Task.class)
				.bean("taskProcessor", "createTask")
			.when(simple("${header.CamelHttpMethod} =~ 'PUT'"))
				.unmarshal().json(JsonLibrary.Jackson, Task.class)
				.bean("taskProcessor", "amendTask")
			.when(simple("${header.CamelHttpMethod} =~ 'DELETE'"))
				.unmarshal().json(JsonLibrary.Jackson, Task.class)
				.bean("taskProcessor", "deleteTask")
		.end();
//		.setBody(simple(""));	
                /*.streamCaching()*/
//                .log(LoggingLevel.INFO, "Entry route to accept task creation started: ${routeId}\n Request ${body}");
        
//        Polling Route
        /*from("{{nxp.batch.processing.polling.uri}}")ok sure
         * 
                .routeId("com.arqiva.chm.processing.csr.nxp.poll")
                .streamCaching()
                .log(LoggingLevel.INFO, "Started scheduled polling route ${routeId}.")

                .idempotentConsumer(header(Exchange.FILE_NAME_ONLY))
                .messageIdRepositoryRef("nxpCsrBatchPollingMessageIdRepository")
                .removeOnFailure(false)
                .id("id_idempotent_consumer")

                .log(LoggingLevel.DEBUG, "New File Received: ${header.CamelFileNameOnly}")
                .choice()
                    .when(header(Exchange.FILE_NAME_ONLY).regex(reportFileName))
                        .log(LoggingLevel.DEBUG, "Routing NXP csr batch report file to validation route...")
                        .to(ExchangePattern.InOut, "direct:processing.nxp.batch.processing.file.validation")
                        .log(LoggingLevel.DEBUG, "routing to validation route")
                    .otherwise()
                        .log(LoggingLevel.WARN, "Not a NXP batch processing file, skipping process")
                .end()

                .log(LoggingLevel.DEBUG, "Route ${routeId} ended. Body at route end: ${body}");

//        Validation route
        from("direct:processing.nxp.batch.processing.file.validation")
                .routeId("com.arqiva.chm.processing.csr.nxp.file.validation")
                .log(LoggingLevel.DEBUG, "Route started: ${routeId}")

                .log(LoggingLevel.DEBUG, "Valid nxp batch file name : ${headers.CamelFileName}")
                .beanRef("nxpCsrBatchFileValidationProcessor", "validateNXPCsrFileName")

                .to("validator:xml/schema/batchedDeviceCSRWebServiceSchema.xsd")

                .log(LoggingLevel.DEBUG, "Valid nxp batch processing xml file: ${headers.CamelFileNameOnly}")

                .beanRef("nxpCsrBatchFileValidationProcessor", "getJobRequestId")

                .split().tokenizeXML("DeviceCSR", "*")
                    .streaming()

                    .aggregate(constant(true), batchAggregationStrategy)
                            //When the list of certificates reaches a certain number a new aggregation is started.
                            //If this condition was not satisfied for the remaining messages that have aggregate
                            //size less than the batch required size completion timeout predicate
                            //will be used to finish the route.
                            //The completion timeout depends on this batch size.
                    .completionPredicate(batchSizePredicate)
                    .completionTimeout(completionTimeout)

                    .beanRef("recordCSRBatchProcessor", "updateReportCsrAndPersistCSRs")

                    .end()
                .end()

                //delaying the sending to SMKI because of the aggregation strategy completion timeout predicate
                .delay(completionTimeout * 2).asyncDelayed()

                .beanRef("recordCSRBatchProcessor","finishPersistingCsrReport")

                .to(ExchangePattern.InOnly, "activemq:queue:{{csr.nxp.valid.processing.queue}}").id("endToId")

                .log(LoggingLevel.DEBUG, "Route ${routeId} ended!");

//        Error Route
        from("direct:processing.nxp.batch.processing.error.handling.route")
                .routeId("com.arqiva.chm.processing.csr.nxp.poll.error")
                .log(LoggingLevel.ERROR, "Exception! Sending to error queue")

                .beanRef("nxpCsrBatchFileValidationProcessor", "createJobRequestOnFailure")

                .setHeader(ExchangeConstants.CHM_MESSAGE_TYPE)
                    .constant(MessageTypeValue.REQUEST_RECEIVED.getId())
                .setHeader(ExchangeConstants.CHM_SYSTEM_ID)
                    .constant(RequestStatusSystemValue.NXP.getId())
                .to(ExchangePattern.InOnly, "activemq:queue:{{nxp.csr.batch.request.processing.failure.queue}}")

                .log(LoggingLevel.ERROR, "Route ${routeId} ended!\nBody at route end: \n${body}");*from("{{nxp.batch.processing.polling.uri}}")
                .routeId("com.arqiva.chm.processing.csr.nxp.poll")
                .streamCaching()
                .log(LoggingLevel.INFO, "Started scheduled polling route ${routeId}.")

                .idempotentConsumer(header(Exchange.FILE_NAME_ONLY))
                .messageIdRepositoryRef("nxpCsrBatchPollingMessageIdRepository")
                .removeOnFailure(false)
                .id("id_idempotent_consumer")

                .log(LoggingLevel.DEBUG, "New File Received: ${header.CamelFileNameOnly}")
                .choice()
                    .when(header(Exchange.FILE_NAME_ONLY).regex(reportFileName))
                        .log(LoggingLevel.DEBUG, "Routing NXP csr batch report file to validation route...")
                        .to(ExchangePattern.InOut, "direct:processing.nxp.batch.processing.file.validation")
                        .log(LoggingLevel.DEBUG, "routing to validation route")
                    .otherwise()
                        .log(LoggingLevel.WARN, "Not a NXP batch processing file, skipping process")
                .end()

                .log(LoggingLevel.DEBUG, "Route ${routeId} ended. Body at route end: ${body}");

//        Validation route
        from("direct:processing.nxp.batch.processing.file.validation")
                .routeId("com.arqiva.chm.processing.csr.nxp.file.validation")
                .log(LoggingLevel.DEBUG, "Route started: ${routeId}")

                .log(LoggingLevel.DEBUG, "Valid nxp batch file name : ${headers.CamelFileName}")
                .beanRef("nxpCsrBatchFileValidationProcessor", "validateNXPCsrFileName")

                .to("validator:xml/schema/batchedDeviceCSRWebServiceSchema.xsd")

                .log(LoggingLevel.DEBUG, "Valid nxp batch processing xml file: ${headers.CamelFileNameOnly}")

                .beanRef("nxpCsrBatchFileValidationProcessor", "getJobRequestId")

                .split().tokenizeXML("DeviceCSR", "*")
                    .streaming()

                    .aggregate(constant(true), batchAggregationStrategy)
                            //When the list of certificates reaches a certain number a new aggregation is started.
                            //If this condition was not satisfied for the remaining messages that have aggregate
                            //size less than the batch required size completion timeout predicate
                            //will be used to finish the route.
                            //The completion timeout depends on this batch size.
                    .completionPredicate(batchSizePredicate)
                    .completionTimeout(completionTimeout)

                    .beanRef("recordCSRBatchProcessor", "updateReportCsrAndPersistCSRs")

                    .end()
                .end()

                //delaying the sending to SMKI because of the aggregation strategy completion timeout predicate
                .delay(completionTimeout * 2).asyncDelayed()

                .beanRef("recordCSRBatchProcessor","finishPersistingCsrReport")

                .to(ExchangePattern.InOnly, "activemq:queue:{{csr.nxp.valid.processing.queue}}").id("endToId")

                .log(LoggingLevel.DEBUG, "Route ${routeId} ended!");

//        Error Route
        from("direct:processing.nxp.batch.processing.error.handling.route")
                .routeId("com.arqiva.chm.processing.csr.nxp.poll.error")
                .log(LoggingLevel.ERROR, "Exception! Sending to error queue")

                .beanRef("nxpCsrBatchFileValidationProcessor", "createJobRequestOnFailure")

                .setHeader(ExchangeConstants.CHM_MESSAGE_TYPE)
                    .constant(MessageTypeValue.REQUEST_RECEIVED.getId())
                .setHeader(ExchangeConstants.CHM_SYSTEM_ID)
                    .constant(RequestStatusSystemValue.NXP.getId())
                .to(ExchangePattern.InOnly, "activemq:queue:{{nxp.csr.batch.request.processing.failure.queue}}")

                .log(LoggingLevel.ERROR, "Route ${routeId} ended!\nBody at route end: \n${body}");*/
    
    }

}
