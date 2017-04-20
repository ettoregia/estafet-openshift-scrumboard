package com.estafet.openshift.scrumboard.camel.tasks.routebuilders;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class TaskRoute extends RouteBuilder{
	
    private void configureGlobalErrorHandling() {
        onException(Throwable.class)
            .handled(true)
            .log(LoggingLevel.ERROR, "${exception.message}\n${exception.stacktrace}");
    }

    public void configure() throws Exception {
        configureGlobalErrorHandling();

        from("cxfrs:http://localhost:8183/tasks?"
        		+ "bindingStyle=SimpleConsumer&"
        		+ "resourceClasses=com.estafet.openshift.scrumboard.camel.tasks.impl.TaskServiceImpl")
        .routeId("com.estafet.openshift.scrumboard.camel.tasks")
        .streamCaching()
        
        .log(LoggingLevel.INFO, "${header.CamelHttpMethod}")
        .log(LoggingLevel.INFO, "Operation Name: ${header.operationName}")
		.choice()
			.when(simple("${header.operationName} =~ 'claimTask'"))
				.bean("taskProcessor", "claimTask")
			.when(simple("${header.operationName} =~ 'completeTask'"))
				.bean("taskProcessor", "completeTask")
			.when(simple("${header.operationName} =~ 'resetTask'"))
				.bean("taskProcessor", "resetTask")
			.when(simple("${header.operationName} =~ 'deleteTask'"))
				.bean("taskProcessor", "deleteTask")
		.end();
    }
}
