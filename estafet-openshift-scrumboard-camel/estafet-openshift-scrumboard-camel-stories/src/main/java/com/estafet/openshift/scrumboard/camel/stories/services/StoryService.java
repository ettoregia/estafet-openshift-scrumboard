package com.estafet.openshift.scrumboard.camel.stories.services;

import java.util.List;
import com.estafet.openshift.scrumboard.entity;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/stories")
public interface StoryService {
	
	@POST
	@Path("/createStory/")
	@Consumes({"application/json" })
	public void createStory();
	
	@PUT
	@Path("/assignStorypointsToStoryById")
	@Produces(MediaType.APPLICATION_JSON)
	public void assignStorypointsToStoryById();
	
	@PUT
	@Path("/assignTaskToStoryById")
	@Produces(MediaType.APPLICATION_JSON)
	public void assignTaskToStory();
	
	@DELETE
	@Path("/deleteStoryById/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStoryById();
	
	@GET
	@Path("/findStoryById/{id}/")
	public List<Story> findStoryById();
	
	
	
}
