package com.estafet.openshift.scrumboard.camel.stories.services;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
        "title","description","hours", "DoD", "ownedby", "assignedto"
})
public class Task {
	
	private int id;
	
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@JsonProperty("hours")
	private String hours;
	@JsonProperty("DoD")
	private String DoD;
	@JsonProperty("ownedby")
	private String ownedby;
	@JsonProperty("assignedto")
	private String assignedto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty("title")
	public String getTitle() {
		return title;
	}
	@JsonProperty("title")
	public void setTitle(String title) {
		this.title = title;
	}
	@JsonProperty("description")
	public String getDescription() {
		return description;
	}
	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}
	@JsonProperty("hours")
	public String getHours() {
		return hours;
	}
	@JsonProperty("hours")
	public void setHours(String hours) {
		this.hours = hours;
	}
	@JsonProperty("DoD")
	public String getDoD() {
		return DoD;
	}
	@JsonProperty("DoD")
	public void setDoD(String DoD) {
		this.DoD = DoD;
	}
	@JsonProperty("ownedby")
	public String getOwnedby() {
		return ownedby;
	}
	@JsonProperty("ownedby")
	public void setOwnedby(String ownedby) {
		this.ownedby = ownedby;
	}
	@JsonProperty("assignedto")
	public String getAssignedto() {
		return assignedto;
	}
	@JsonProperty("assignedto")
	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", hours=" + hours
				+ ", DoD=" + DoD + ", ownedby=" + ownedby + ", assignedto=" + assignedto
				+ "]";
	}
	
	
}
