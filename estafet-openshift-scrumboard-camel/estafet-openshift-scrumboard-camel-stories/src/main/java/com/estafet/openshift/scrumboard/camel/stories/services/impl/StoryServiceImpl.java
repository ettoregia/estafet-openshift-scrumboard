package com.estafet.openshift.scrumboard.camel.stories.services.impl;

import javax.ws.rs.Path;

import com.estafet.openshift.scrumboard.camel.stories.services.api.AddAcceptanceCriteriaParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.AssignStoryPointsParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.AssignTaskToStoryParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.ChangeStoryDetailsParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.StoryService;

@Path("/")
public class StoryServiceImpl implements StoryService {

	@Override
	public void assignStoryPoints(AssignStoryPointsParameters parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignTaskToStory(AssignTaskToStoryParameters parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteStoryById(int storyId) {
		// TODO Auto-generated method stub

	}

	@Override
	public com.estafet.openshift.scrumboard.entity.Story getStory(int storyId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public com.estafet.openshift.scrumboard.entity.Story createStory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void changeStoryDetails(ChangeStoryDetailsParameters parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addAcceptanceCriteria(AddAcceptanceCriteriaParameters parameters) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeAcceptanceCriteria(int acceptanceCriteriaId) {
		// TODO Auto-generated method stub

	}

}
