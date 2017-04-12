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
public class TaskService {
	
	
	@POST
	@Path("/task/")
	@Consumes({"application/json" })
	public void createtask(String taskPayload){
	}
	
	@PUT
	@Path("/taskId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void amendtask(@PathParam("id") String taskId, String taskPayload){
		
	}
	
	@DELETE
	@Path("/taskId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteTask(@PathParam("id") String taskId){
		
	}
	
	@GET
	@Path("/task/{id}/")
	public int searchTask(@PathParam("id") String taskId){
		System.out.println("task searched");
		return 0;
		
	}
	
	/*@POST
	@Path("/taskId/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public int assigntask(int taskId, String assignee);
*/
}
