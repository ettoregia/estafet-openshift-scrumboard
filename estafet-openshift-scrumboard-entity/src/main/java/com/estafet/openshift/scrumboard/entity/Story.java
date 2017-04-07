package com.estafet.openshift.scrumboard.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class Story {
	
	private String title;
	private String description;
	private String storypoints;
	private String acceptancecriterias;
	private String ownedby;
	private String assignedto;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStorypoints() {
		return storypoints;
	}
	public void setStorypoints(String storypoints) {
		this.storypoints = storypoints;
	}
	public String getAcceptancecriterias() {
		return acceptancecriterias;
	}
	public void setAcceptancecriterias(String acceptancecriterias) {
		this.acceptancecriterias = acceptancecriterias;
	}
	public String getOwnedby() {
		return ownedby;
	}
	public void setOwnedby(String ownedby) {
		this.ownedby = ownedby;
	}
	public String getAssignedto() {
		return assignedto;
	}
	public void setAssignedto(String assignedto) {
		this.assignedto = assignedto;
	}
}
