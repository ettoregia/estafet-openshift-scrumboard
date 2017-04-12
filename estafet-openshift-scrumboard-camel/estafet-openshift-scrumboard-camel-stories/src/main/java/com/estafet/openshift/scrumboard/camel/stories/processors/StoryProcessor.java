package com.estafet.openshift.scrumboard.camel.stories.processors;

import com.estafet.openshift.scrumboard.camel.stories.services.Story;

public class StoryProcessor {
	
	public void process(Story story) throws Exception {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
	
	public void createStory(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
	
	public void amendStory(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
	
	public void deleteStory(Story story) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(story);
    }
}
