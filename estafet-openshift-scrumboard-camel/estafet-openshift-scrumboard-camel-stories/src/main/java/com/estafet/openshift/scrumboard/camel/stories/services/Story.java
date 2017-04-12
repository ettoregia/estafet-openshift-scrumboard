package com.estafet.openshift.scrumboard.camel.stories.services;

import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
      "title","description","storypoints", "acceptancecriterias", "ownedby", "assignedto"
})
public class Story {
	
	private int id;
	@JsonProperty("title")
	private String title;
	@JsonProperty("description")
	private String description;
	@JsonProperty("storypoints")
	private String storypoints;
	@JsonProperty("acceptancecriterias")
	private String acceptancecriterias;
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
	@JsonProperty("storypoints")
	public String getStorypoints() {
		return storypoints;
	}
	@JsonProperty("storypoints")
	public void setStorypoints(String storypoints) {
		this.storypoints = storypoints;
	}
	@JsonProperty("acceptancecriterias")
	public String getAcceptancecriterias() {
		return acceptancecriterias;
	}
	@JsonProperty("acceptancecriterias")
	public void setAcceptancecriterias(String acceptancecriterias) {
		this.acceptancecriterias = acceptancecriterias;
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
		return "Story [id=" + id + ", title=" + title + ", description=" + description + ", storypoints=" + storypoints
				+ ", acceptancecriterias=" + acceptancecriterias + ", ownedby=" + ownedby + ", assignedto=" + assignedto
				+ "]";
	}
}
