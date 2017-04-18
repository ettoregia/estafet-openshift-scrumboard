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
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/tasks")
public interface TaskService {
	
	@POST
	@Path("/createTask")
	@Consumes({"application/json" })
	public void createTask();
	
	@PUT
	@Path("/assignTask")
	@Produces(MediaType.APPLICATION_JSON)
	public void assignTask();
	
	@PUT
	@Path("/addDoDToTask/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public void addDoDToTask();
	
	@DELETE
	@Path("/deleteTaskById")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteTaskById();
	
	@GET
	@Path("/findTaskById")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findTaskById();
	
}
