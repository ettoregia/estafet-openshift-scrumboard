package com.estafet.openshift.scrumboard.entity;

import java.util.List;

public class Project {

	private String title;

	private String description;

	private List<Story> backlog;

	private List<Sprint> sprints;

	public List<Story> getStories() {
		return backlog;
	}

	public void setStories(List<Story> backlog) {
		this.backlog = backlog;
	}
	
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

	public List<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(List<Sprint> sprints) {
		this.sprints = sprints;
	}

}
