package com.estafet.openshift.scrumboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TASK")
public class Task {

	@Id
	@SequenceGenerator(name = "TASK_ID_SEQ", sequenceName = "TASK_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TASK_ID_SEQ")
	@Column(name = "TASK_ID")
	private int id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "INITIAL_HOURS")
	private Integer initialHours;

	@Column(name = "REMAINING_HOURS")
	private Integer remainingHours;

	@OneToOne
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
	private User assigned;

	@Column(name = "STATUS")
	private TaskStatus status;

	@ManyToOne
	@JoinColumn(name = "STORY_ID", referencedColumnName = "STORY_ID")
	private Story taskStory;

	Task() { }

	public Task(String title, String description, Integer initialHours) {
		this.title = title;
		this.description = description;
		this.initialHours = initialHours;
		status = TaskStatus.UNCLAIMED;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getInitialHours() {
		return initialHours;
	}

	public int getRemainingHours() {
		return remainingHours;
	}

	public User getAssigned() {
		return assigned;
	}

	public TaskStatus getStatus() {
		return status;
	}

	void setTaskStory(Story taskStory) {
		this.taskStory = taskStory;
	}
	
	

}
