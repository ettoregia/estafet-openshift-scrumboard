package com.estafet.openshift.scrumboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "story")
public class Task {
	
	@Id
    @SequenceGenerator(name = "task_id_seq", sequenceName = "task_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "task_id_seq")
    @Column(name = "id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "storypoints")
	private String storypoints;
	@Column(name = "acceptancecriterias")
	private String acceptancecriterias;
	@Column(name = "ownedby")
	private String ownedby;
	@Column(name = "assignedto")
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
