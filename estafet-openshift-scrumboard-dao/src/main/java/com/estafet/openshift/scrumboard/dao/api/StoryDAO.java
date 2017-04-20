package com.estafet.openshift.scrumboard.dao.api;

import java.util.List;

import com.estafet.openshift.scrumboard.entity.Story;

public interface StoryDAO {

	int saveStory(Story story);
	
	void deleteStory(Story story);
	
	Story getStory(Integer id);
	
	List<Story> findStory();
	
}
