package com.estafet.openshift.scrumboard.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PROJECT")
public class Project {

	@Id
	@SequenceGenerator(name = "PROJECT_ID_SEQ", sequenceName = "PROJECT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROJECT_ID_SEQ")
	@Column(name = "PROJECT_ID")
	private int id;
	
	@Column(name = "TITLE")
	private String title;

	@OneToMany(mappedBy = "storyProject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)	
	private Set<Story> backlog;

	@OneToMany(mappedBy = "sprintProject", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Sprint> sprints;

	public Set<Story> getStories() {
		return backlog;
	}

	public void setStories(Set<Story> backlog) {
		this.backlog = backlog;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Sprint> getSprints() {
		return sprints;
	}

	public void setSprints(Set<Sprint> sprints) {
		this.sprints = sprints;
	}

}
