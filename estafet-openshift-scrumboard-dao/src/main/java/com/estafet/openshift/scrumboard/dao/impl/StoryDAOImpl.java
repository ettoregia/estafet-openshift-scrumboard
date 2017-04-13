package com.estafet.openshift.scrumboard.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.estafet.openshift.scrumboard.dao.api.StoryDAO;
import com.estafet.openshift.scrumboard.entity.Story;

public class StoryDAOImpl implements StoryDAO {

	public void saveStory(Story story) {
		// TODO Auto-generated method stub

	}

	public void deleteStory(Story story) {
		// TODO Auto-generated method stub

	}

	public Story getStory(Integer id) {
		Story story = new Story();
		story.setAssignedto("ssjsjsjs");
		story.setAcceptancecriterias("ddkdkdkdkd");
		story.setDescription("ffkfkffkfkf");
		story.setOwnedby("ffkfkfkf");
		story.setStorypoints("444");
		story.setTitle("44554");
		return story;
	}

	public List<Story> findStory() {
		List<Story> stories = new ArrayList<Story>();
		for (int i = 0; i < 10; i++) {
			Story story = new Story();
			story.setAssignedto("ssjsjsjs");
			story.setAcceptancecriterias("ddkdkdkdkd");
			story.setDescription("ffkfkffkfkf");
			story.setOwnedby("ffkfkfkf");
			story.setStorypoints("444");
			story.setTitle("44554");
			stories.add(story);
		}
		return stories;
	}

}
