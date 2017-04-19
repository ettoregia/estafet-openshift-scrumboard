package com.estafet.openshift.scrumboard.entity;

import java.util.Calendar;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SPRINT")
public class Sprint {

	@Id
	@SequenceGenerator(name = "SPRINT_ID_SEQ", sequenceName = "SPRINT_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPRINT_ID_SEQ")
	@Column(name = "SPRINT_ID")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Calendar startDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "START_DATE")
	private Calendar endDate;

	@Column(name = "SPRINT_NUMBER")
	private int sprintNumber;

	@OneToMany(mappedBy = "storySprint", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<Story> stories;
	
	@ManyToOne
	@JoinColumn(name = "PROJECT_ID", referencedColumnName = "PROJECT_ID")
	private Project sprintProject;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public int getSprintNumber() {
		return sprintNumber;
	}

	public void setSprintNumber(int sprintNumber) {
		this.sprintNumber = sprintNumber;
	}

	public Set<Story> getStories() {
		return stories;
	}

	public void setStories(Set<Story> stories) {
		this.stories = stories;
	}

}
