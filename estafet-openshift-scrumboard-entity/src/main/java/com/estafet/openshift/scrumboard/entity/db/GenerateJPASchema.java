package com.estafet.openshift.scrumboard.entity.db;

import javax.persistence.Persistence;

public class GenerateJPASchema {

	public static void main(String[] args) {
	    Persistence.generateSchema("com.estafet.openshift.scrumboard.jpa", null);
	  }
	
}
