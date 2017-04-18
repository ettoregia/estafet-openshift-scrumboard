package com.estafet.openshift.scrumboard.camel.stories.services.api;

import com.estafet.openshift.scrumboard.entity.Task;

public class AssignTaskToStoryParameters {
	public Task task;
	public int storyId;

	public AssignTaskToStoryParameters(Task task, int storyId) {
		this.task = task;
		this.storyId = storyId;
	}
}