package com.estafet.openshift.scrumboard.camel.tasks.processors;

import com.estafet.openshift.scrumboard.camel.tasks.api.TaskOperationParameters;
import com.estafet.openshift.scrumboard.dao.api.TaskDAO;

public class TaskProcessor {
	
	private TaskDAO taskDAO;
	
	public void claimTask(TaskOperationParameters parameters){}
	
	public void completeTask(TaskOperationParameters parameters){}
	
	public void resetTask(TaskOperationParameters parameters){}
	
	public void deleteTask(int taskId){}

	public TaskDAO getTaskDAO() {
		return taskDAO;
	}

	public void setTaskDAO(TaskDAO taskDAO) {
		this.taskDAO = taskDAO;
	}
	
	
}
