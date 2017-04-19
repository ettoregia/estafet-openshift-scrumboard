package com.estafet.openshift.scrumboard.dao.api;

import java.util.List;

import com.estafet.openshift.scrumboard.entity.Task;

public interface TaskDAO {

	int saveTask(Task task);
	
	void deleteTask(Task task);
	
	Task getTask(Integer id);
	
	List<Task> findTask();
		
}
