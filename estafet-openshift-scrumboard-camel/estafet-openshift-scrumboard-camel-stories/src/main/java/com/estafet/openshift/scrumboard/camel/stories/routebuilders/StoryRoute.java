package com.estafet.openshift.scrumboard.camel.stories.routebuilders;

import org.apache.camel.ExchangePattern;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;

import com.estafet.openshift.scrumboard.entity.Story;

public class StoryRoute extends RouteBuilder{
	
	/*@PropertyInject(value = "nxp.batch.processing.file.pattern")
    private String reportFileName;

    @PropertyInject(value = "nxp.batch.processing.file.batch.completion.timeout")
    private long completionTimeout;*/

    private void configureGlobalErrorHandling() {

        onException(Throwable.class)
            .handled(true)
            .log(LoggingLevel.ERROR, "${exception.message}\n${exception.stacktrace}");
    }

    public void configure() throws Exception {
        configureGlobalErrorHandling();

        from("cxfrs:http://localhost:8183/stories?"
        		+ "bindingStyle=SimpleConsumer&"
        		+ "resourceClasses=com.estafet.openshift.scrumboard.camel.stories.services.impl.StoryServiceImpl")
        .routeId("com.estafet.openshift.scrumboard.camel.stories")
        .streamCaching()
        
        .log(LoggingLevel.INFO, "${header.CamelHttpMethod}")
        .log(LoggingLevel.INFO, "Operation Name: ${header.operationName}")
		.choice()
			.when(simple("${header.operationName} =~ 'createStory'"))
				.unmarshal().json(JsonLibrary.Jackson)
				.bean("storyProcessor", "createStory")
			.when(simple("${header.operationName} =~ 'deleteStory'"))
				.unmarshal().json(JsonLibrary.Jackson)
				.bean("storyProcessor", "deleteStory")
			.when(simple("${header.operationName} =~ 'assignStoryPoints'"))
				.unmarshal().json(JsonLibrary.Jackson)
				.bean("storyProcessor", "assignStoryPoints")
			.when(simple("${header.operationName} =~ 'changeStoryDetails'"))
				.unmarshal().json(JsonLibrary.Jackson)	
				.bean("storyProcessor", "changeStoryDetails")		
			.when(simple("${header.operationName} =~ 'addAcceptanceCriteria'"))
				.unmarshal().json(JsonLibrary.Jackson)
				.bean("storyProcessor", "changeStoryDetails")
			.when(simple("${header.operationName} =~ 'removeAcceptanceCriteria'"))
				.unmarshal().json(JsonLibrary.Jackson)
				.bean("storyProcessor", "addAcceptanceCriteria")
			.when(simple("${header.operationName} =~ 'assignTaskToStory'"))
				.unmarshal().json(JsonLibrary.Jackson)
				.bean("storyProcessor", "assignTaskToStory")
			.when(simple("${header.operationName} =~ 'getStory'"))
				.bean("storyProcessor", "getStory")
				.marshal().json(JsonLibrary.Jackson, Story.class)
				.log("${body}")
				
				
		.end()
		.setBody(simple(""));	
    }

}
