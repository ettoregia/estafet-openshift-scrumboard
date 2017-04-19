package com.estafet.openshift.scrumboard.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TEAM_MEMBER")
public class User {

	@Id
	@Column(name = "USER_ID")
	private String userId;

	@Column(name = "FIRST_AND_LASTNAME")
	private String name;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
