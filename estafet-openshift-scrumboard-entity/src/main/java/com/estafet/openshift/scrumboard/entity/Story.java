package com.estafet.openshift.scrumboard.entity;

import java.util.Collection;
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

	public Project getStoryProject() {
		return storyProject;
	}

	public void setStoryProject(Project storyProject) {
		this.storyProject = storyProject;
	}

	public Sprint getStorySprint() {
		return storySprint;
	}

	public void setStorySprint(Sprint storySprint) {
		this.storySprint = storySprint;
	}

	public StoryStatus getStatus() {
		return status;
	}

	public void setStatus(StoryStatus status) {
		this.status = status;
	}

	public Collection<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public void setAcceptancecriteria(Set<AcceptanceCriterion> acceptancecriteria) {
		this.acceptancecriteria = acceptancecriteria;
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

	public int getStorypoints() {
		return storypoints;
	}

	public void setStorypoints(int storypoints) {
		this.storypoints = storypoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Collection<AcceptanceCriterion> getAcceptancecriteria() {
		return acceptancecriteria;
	}

	public void setAcceptancecriterias(Set<AcceptanceCriterion> acceptancecriteria) {
		this.acceptancecriteria = acceptancecriteria;
	}

	public void addAcceptanceCriterion(String criterion) {
		AcceptanceCriterion acceptanceCriterion = new AcceptanceCriterion();
		acceptanceCriterion.setCriterionStory(this);
		acceptancecriteria.add(acceptanceCriterion);
	}
	
}
