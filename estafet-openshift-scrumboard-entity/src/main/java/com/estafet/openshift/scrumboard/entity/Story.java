package com.estafet.openshift.scrumboard.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STORY")
public class Story {

	@Id
	@SequenceGenerator(name = "story_id_seq", sequenceName = "story_id_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "story_id_seq")
	@Column(name = "STORY_ID")
	private int id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "STORY_POINTS")
	private int storypoints;

	@OneToMany(mappedBy = "criterionStory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<AcceptanceCriterion> acceptancecriteria;

	@OneToMany(mappedBy = "taskStory", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Task> tasks;

	@ManyToOne
	@JoinColumn(name = "SPRINT_ID", referencedColumnName = "SPRINT_ID")
	private Sprint storySprint;

	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
	private Project storyProject;

	@Column(name = "STATUS")
	private StoryStatus status;
	
	Story() { }
			

	public Story(String title, String description) {
		this.title = title;
		this.description = description;
		status = StoryStatus.PLANNING;
	}
	
	public Story addAcceptanceCriterion(String criterion) {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion();
		acceptanceCriterion.setCriterionStory(this);
		if (acceptancecriteria == null) {
			acceptancecriteria = new HashSet<AcceptanceCriterion>();
		}
		acceptancecriteria.add(acceptanceCriterion);
		return this;
	}
	
	public Story addTask(Task task) {
		task.setTaskStory(this);
		if (tasks == null) {
			tasks = new HashSet<Task>();
		}
		tasks.add(task);
		return this;
	}

	public Story setStorypoints(int storypoints) {
		this.storypoints = storypoints;
		return this;
	}

	public Story setStorySprint(Sprint storySprint) {
		this.storySprint = storySprint;
		return this;
	}

	public StoryStatus getStatus() {
		return status;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public int getStorypoints() {
		return storypoints;
	}

	public int getId() {
		return id;
	}

	public Set<AcceptanceCriterion> getAcceptancecriteria() {
		return acceptancecriteria;
	}

}
