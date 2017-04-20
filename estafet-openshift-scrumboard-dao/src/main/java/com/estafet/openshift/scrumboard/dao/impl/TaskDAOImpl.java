package com.estafet.openshift.scrumboard.dao.impl;

import javax.persistence.EntityManager;

import com.estafet.openshift.scrumboard.dao.api.TaskDAO;
import com.estafet.openshift.scrumboard.entity.Task;

public class TaskDAOImpl implements TaskDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public int saveTask(Task task) {
		return ((Task)entityManager.merge(task)).getId();
	}

	public void deleteTask(int taskId) {
		entityManager.remove(getTask(taskId));
	}

	public Task getTask(int id) {
		return entityManager.find(Task.class, id);
	}

}
