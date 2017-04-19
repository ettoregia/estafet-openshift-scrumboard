package com.estafet.openshift.scrumboard.camel.stories.processors;

import com.estafet.openshift.scrumboard.camel.stories.services.api.AddAcceptanceCriteriaParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.AssignStoryPointsParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.AssignTaskToStoryParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.ChangeStoryDetailsParameters;
import com.estafet.openshift.scrumboard.dao.api.StoryDAO;
import com.estafet.openshift.scrumboard.entity.Story;

public class StoryProcessor {

	private StoryDAO storyDAO;


	public int createStory(Story story) {
		return 0;
	}

	public void assignStorypointsToStoryById(Story story) {
	}

	public Story getStory(int storyId) {
		return null;
	}

	public void assignStoryPoints(AssignStoryPointsParameters parameters) {
	}

	public void changeStoryDetails(ChangeStoryDetailsParameters parameters) {
	}

	public void deleteStory(int storyId) {
	}

	public void addAcceptanceCriteria(AddAcceptanceCriteriaParameters parameters){}

	public void removeAcceptanceCriteria(int acceptanceCriteriaId){}

	public void assignTaskToStory(AssignTaskToStoryParameters parameters){}
}
