package com.estafet.openshift.scrumboard.camel.stories.processors;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Header;

import com.estafet.openshift.scrumboard.camel.stories.services.api.AddAcceptanceCriteriaParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.AssignStoryPointsParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.AssignTaskToStoryParameters;
import com.estafet.openshift.scrumboard.camel.stories.services.api.ChangeStoryDetailsParameters;
import com.estafet.openshift.scrumboard.dao.api.StoryDAO;
import com.estafet.openshift.scrumboard.entity.Story;

public class StoryProcessor {

	private StoryDAO storyDAO;


	public int createStory(@Body Story story) {
		return storyDAO.saveStory(story);
	}

	public Story getStory(@Header("") int storyId, Exchange exchange) {
		exchange.getContext();
		return storyDAO.getStory(storyId);
	}
	
	public void assignStorypointsToStoryById(@Body Story story) {
		//TODO To be implemented in the DAO
	}

	public void assignStoryPoints(AssignStoryPointsParameters parameters) {
		//TODO To be implemented in the DAO
	}

	public void changeStoryDetails(ChangeStoryDetailsParameters parameters) {
		//TODO To be implemented in the DAO
	}

	public void deleteStory(int storyId) {
	}

	public void addAcceptanceCriteria(AddAcceptanceCriteriaParameters parameters){
		//TODO To be implemented in the DAO
	}

	public void removeAcceptanceCriteria(int acceptanceCriteriaId){
		//TODO To be implemented in the DAO
	}

	public void assignTaskToStory(AssignTaskToStoryParameters parameters){
		//TODO To be implemented in the DAO
	}

	public StoryDAO getStoryDAO() {
		return storyDAO;
	}

	public void setStoryDAO(StoryDAO storyDAO) {
		this.storyDAO = storyDAO;
	}
	
	
}
