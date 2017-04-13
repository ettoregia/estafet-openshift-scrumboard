package com.estafet.openshift.scrumboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.scrumboard.dao.api.TaskDAO;
import com.estafet.openshift.scrumboard.entity.Task;

public class TaskDAOImpl implements TaskDAO {

	public void saveTask(Task task) {
		// TODO Auto-generated method stub

	}

	public void deleteTask(Task task) {
		// TODO Auto-generated method stub

	}

	public Task getTask(Integer id) {
		Task task = new Task();
		task.setAcceptancecriterias("ssksksksks");
		task.setAssignedto("ddddd");
		task.setDescription("sskssks");
		task.setOwnedby("dsddkd");
		task.setStorypoints("23");
		task.setTitle("4444");
		return task;
	}

	public List<Task> findTask() {
		List<Task> tasks = new ArrayList<Task>();
		for (int i=0; i < 10; i++) {
			Task task = new Task();
			task.setAcceptancecriterias("ssksksksks");
			task.setAssignedto("ddddd");
			task.setDescription("sskssks");
			task.setOwnedby("dsddkd");
			task.setStorypoints("23");
			task.setTitle("4444");
			tasks.add(task);
		}
		return tasks;
	}

}
