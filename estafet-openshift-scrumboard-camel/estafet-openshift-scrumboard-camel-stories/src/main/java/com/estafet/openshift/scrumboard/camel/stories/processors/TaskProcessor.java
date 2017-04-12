package com.estafet.openshift.scrumboard.camel.stories.processors;

import org.apache.camel.Exchange;

import com.estafet.openshift.scrumboard.camel.stories.services.Task;

public class TaskProcessor {
	
	public void searchTask(String taskId) throws Exception {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println("Searched task:" +taskId);
    }
	
	public void createTask(Task task) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println(task);
    }
	
	public void amendTask(Exchange exchange) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
		Task task = exchange.getIn().getBody(Task.class);
        System.out.println(task.toString());
    }
	
	public void deleteTask(String taskId) {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
        System.out.println("Deleted task:" +taskId);
    }
	
}
