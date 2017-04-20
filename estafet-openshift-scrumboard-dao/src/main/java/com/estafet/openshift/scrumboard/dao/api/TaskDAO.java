package com.estafet.openshift.scrumboard.dao.api;

import com.estafet.openshift.scrumboard.entity.Task;

public interface TaskDAO {

	int saveTask(Task task);
	
	void deleteTask(int taskId);
	
	Task getTask(int id);
	
		
}
