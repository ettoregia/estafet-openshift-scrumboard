package com.estafet.openshift.scrumboard.camel.tasks.api;

import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tasks")
public interface TaskService {
	
	@POST
	@Path("/claimTask/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	void claimTask(TaskOperationParameters parameters);
	
	@POST
	@Path("/claimTask/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	void completeTask(TaskOperationParameters parameters);
	
	@POST
	@Path("/claimTask/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	void resetTask(TaskOperationParameters parameters);
	
	@DELETE
	@Path("/deleteTaskById")
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteTask(int taskId);
	
	
}
