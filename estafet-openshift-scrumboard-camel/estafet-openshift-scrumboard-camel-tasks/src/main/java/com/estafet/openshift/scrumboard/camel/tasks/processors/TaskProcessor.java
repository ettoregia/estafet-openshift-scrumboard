package com.estafet.openshift.scrumboard.camel.tasks.processors;

import com.estafet.openshift.scrumboard.camel.tasks.api.TaskOperationParameters;

public class TaskProcessor {
	
	public void claimTask(TaskOperationParameters parameters){}
	
	public void completeTask(TaskOperationParameters parameters){}
	
	public void resetTask(TaskOperationParameters parameters){}
	
	public void deleteTask(int taskId){}
}
