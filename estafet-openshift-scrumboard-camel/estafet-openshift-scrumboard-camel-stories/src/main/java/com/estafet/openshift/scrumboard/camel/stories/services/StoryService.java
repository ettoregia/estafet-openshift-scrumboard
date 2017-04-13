package com.estafet.openshift.scrumboard.camel.stories.services;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class StoryService {
	
	
	@POST
	@Path("/storyId/")
	@Consumes({"application/json" })
	public int createStory(String storyPayload){
		return 0;
	}
	
	@PUT
	@Path("/storyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void amendStory(@PathParam("id") String storyId, String storyPayload){
		
	}
	
	@DELETE
	@Path("/storyId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteStory(@PathParam("id") String storyId){
		
	}
	
	@GET
	@Path("/story/{id}/")
	public int searchStory(@PathParam("id") String storyId){
		System.out.println("Story searched");
		return 0;
		
	}
	
}
