package com.estafet.openshift.scrumboard.camel.stories.services.api;

import com.estafet.openshift.scrumboard.entity.AcceptanceCriteria;

public class AddAcceptanceCriteriaParameters {
	public AcceptanceCriteria acceptanceCriteria;
	public int storyId;

	public AddAcceptanceCriteriaParameters(AcceptanceCriteria acceptanceCriteria, int storyId) {
		this.acceptanceCriteria = acceptanceCriteria;
		this.storyId = storyId;
	}
}