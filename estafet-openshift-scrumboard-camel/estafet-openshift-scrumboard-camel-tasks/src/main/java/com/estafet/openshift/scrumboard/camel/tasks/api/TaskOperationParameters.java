package com.estafet.openshift.scrumboard.camel.tasks.api;

public class TaskOperationParameters {
	public String userId;
	public int taskId;

	public TaskOperationParameters(String userId, int taskId) {
		this.userId = userId;
		this.taskId = taskId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	
}