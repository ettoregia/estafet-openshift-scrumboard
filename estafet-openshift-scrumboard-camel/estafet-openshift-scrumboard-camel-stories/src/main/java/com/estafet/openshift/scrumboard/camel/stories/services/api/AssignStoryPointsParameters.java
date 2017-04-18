package com.estafet.openshift.scrumboard.camel.stories.services.api;

public class AssignStoryPointsParameters {
	public int points;
	public int storyId;

	public AssignStoryPointsParameters(int points, int storyId) {
		this.points = points;
		this.storyId = storyId;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getStoryId() {
		return storyId;
	}

	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	
	
	
	
}