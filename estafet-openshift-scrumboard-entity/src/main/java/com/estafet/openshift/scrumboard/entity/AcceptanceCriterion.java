package com.estafet.openshift.scrumboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ACCEPTANCE_CRITERION")
public class AcceptanceCriterion {

	@Id
	@SequenceGenerator(name = "ACCEPTANCE_CRITERION_ID_SEQ", sequenceName = "ACCEPTANCE_CRITERION_ID_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCEPTANCE_CRITERION_ID_SEQ")
	@Column(name = "ACCEPTANCE_CRITERION_ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "STORY_ID", referencedColumnName = "STORY_ID")
	private Story criterionStory;

	@Column(name = "DESCRIPTION")
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Story getCriterionStory() {
		return criterionStory;
	}

	public void setCriterionStory(Story criterionStory) {
		this.criterionStory = criterionStory;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
