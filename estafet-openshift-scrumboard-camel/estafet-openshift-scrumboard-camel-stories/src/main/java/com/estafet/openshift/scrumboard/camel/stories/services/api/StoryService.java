package com.estafet.openshift.scrumboard.camel.stories.services.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.estafet.openshift.scrumboard.entity.Story;


@Path("/stories")
public interface StoryService {
	
	@POST
	@Path("/createStory/")
	@Consumes({"application/json" })
	int createStory(Story story);
		
	@DELETE
	@Path("/deleteStory/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	void deleteStory(int storyId);
	
	@GET
	@Path("/getStory/{id}/")
	Story getStory(int storyId);
	
	@POST
	@Path("/assignStoryPoints/")
	@Produces(MediaType.APPLICATION_JSON)
	void assignStoryPoints(AssignStoryPointsParameters parameters);
	
	@POST
	@Path("/changeStoryDetails/")
	@Produces(MediaType.APPLICATION_JSON)
	void changeStoryDetails(ChangeStoryDetailsParameters parameters);
	
	@POST
	@Path("/changeStoryDetails/")
	@Produces(MediaType.APPLICATION_JSON)
	void addAcceptanceCriteria(AddAcceptanceCriteriaParameters parameters);
	
	@POST
	@Path("/removeAcceptanceCriteria/")
	@Produces(MediaType.APPLICATION_JSON)
	void removeAcceptanceCriteria(int acceptanceCriteriaId);
	
	@POST
	@Path("/assignTaskToStory/")
	@Produces(MediaType.APPLICATION_JSON)
	void assignTaskToStory(AssignTaskToStoryParameters parameters);
	
}
