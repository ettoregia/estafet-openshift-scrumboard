package com.estafet.openshift.scrumboard.camel.stories.processors;

import com.estafet.openshift.scrumboard.camel.stories.services.Story;

public class StoryProcessor {
	
	public void createStory(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
	
	public void assignStorypointsToStoryById(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
	
	public void assignTaskToStory(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
	
	public void findStoryById(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
	
	public void deleteStoryById(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
}
