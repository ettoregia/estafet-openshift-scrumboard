package com.estafet.openshift.scrumboard.camel.stories.services.api;

public class ChangeStoryDetailsParameters {
	public String title;
	public String description;
	public int storyId;

	public ChangeStoryDetailsParameters(String title, String description, int storyId) {
		this.title = title;
		this.description = description;
		this.storyId = storyId;
	}
}