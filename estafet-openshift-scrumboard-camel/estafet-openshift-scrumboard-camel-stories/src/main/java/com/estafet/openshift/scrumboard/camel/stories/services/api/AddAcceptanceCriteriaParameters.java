package com.estafet.openshift.scrumboard.camel.stories.services.api;

import com.estafet.openshift.scrumboard.entity.AcceptanceCriterion;

public class AddAcceptanceCriteriaParameters {
	public AcceptanceCriterion acceptanceCriteria;
	public int storyId;

	public AddAcceptanceCriteriaParameters(AcceptanceCriterion acceptanceCriteria, int storyId) {
		this.acceptanceCriteria = acceptanceCriteria;
		this.storyId = storyId;
	}
}