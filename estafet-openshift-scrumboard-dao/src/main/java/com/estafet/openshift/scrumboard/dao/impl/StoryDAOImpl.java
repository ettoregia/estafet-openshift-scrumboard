package com.estafet.openshift.scrumboard.dao.impl;

import javax.persistence.EntityManager;

import com.estafet.openshift.scrumboard.dao.api.StoryDAO;
import com.estafet.openshift.scrumboard.entity.Story;

public class StoryDAOImpl implements StoryDAO {

	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public int saveStory(Story story) {
		return ((Story)entityManager.merge(story)).getId();
	}

	public void deleteStory(int storyId) {
		entityManager.remove(entityManager.find(Story.class, storyId));

	}

	public Story getStory(int id) {
		return entityManager.find(Story.class, id);
	}

}
