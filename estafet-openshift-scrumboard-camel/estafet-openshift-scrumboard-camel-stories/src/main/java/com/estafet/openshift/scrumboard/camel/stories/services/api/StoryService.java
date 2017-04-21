package com.estafet.openshift.scrumboard.camel.stories.services.api;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.estafet.openshift.scrumboard.entity.Story;


@Path("/")
public interface StoryService {
	
	@POST
	@Path("/createStory/")
	@Consumes({MediaType.APPLICATION_JSON })
	@Produces({MediaType.TEXT_PLAIN })
	int createStory(@BeanParam Story story);
		
	@DELETE
	@Path("/deleteStory/{id}")
	void deleteStory(@PathParam("id") int storyId);
	
	@GET
	@Path("/getStory/{id}/")
	@Produces({MediaType.APPLICATION_JSON })
	Story getStory(@PathParam("id") int storyId);
	
	@POST
	@Path("/assignStoryPoints/")
	@Produces(MediaType.APPLICATION_JSON)
	void assignStoryPoints(AssignStoryPointsParameters parameters);
	
	@POST
	@Path("/changeStoryDetails/")
	@Produces(MediaType.APPLICATION_JSON)
	void changeStoryDetails(ChangeStoryDetailsParameters parameters);
	
	@POST
	@Path("/addAcceptanceCriteria/")
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
