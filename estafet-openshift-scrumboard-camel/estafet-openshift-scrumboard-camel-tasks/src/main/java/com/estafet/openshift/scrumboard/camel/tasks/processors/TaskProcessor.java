package com.estafet.openshift.scrumboard.camel.tasks.processors;

import org.apache.camel.Exchange;

import com.estafet.openshift.scrumboard.entity.Task;

public class TaskProcessor {
	
	public void searchTask(Exchange exchange) throws Exception {
        // get the id of the input
        //ClaimInput input = exchange.getIn().getBody(ClaimInput.class);
		String json = "  \"ID\": +taskId \"\n" +
        "  \"title\": \"Define a REST API\",\n" +
        "  \"description\": \"All the operations are clearly defined with URLs and Message Structure\",\n" +
        "  \"hours\": \"20\",\n" +
        "  \"DoD\": \"A Google Doc describing the APIs\",\n" +
        "  \"ownedby\": \"Ettore\",\n" +
        "  \"assignedto\": \"Dennis\"\n" +
        "}\n" ;
		Task task = new Task();
		//task.setAssignedto("Dennis");
		//task.setId(111);
		task.setTitle("Define a REST API");
		exchange.getIn().setBody(task);
//        System.out.println("Searched task:" +taskId);
//        return json;
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
