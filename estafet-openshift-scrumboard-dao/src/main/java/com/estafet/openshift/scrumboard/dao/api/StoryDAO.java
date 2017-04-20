package com.estafet.openshift.scrumboard.dao.api;

import com.estafet.openshift.scrumboard.entity.Story;

public interface StoryDAO {

	int saveStory(Story story);
	
	void deleteStory(int storyId);
	
	Story getStory(int id);
	
	
}
