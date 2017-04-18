package com.estafet.openshift.scrumboard.camel.stories.services.api;

public class AssignStoryPointsParameters {
	public int points;
	public int storyId;

	public AssignStoryPointsParameters(int points, int storyId) {
		this.points = points;
		this.storyId = storyId;
	}
}