package com.estafet.openshift.scrumboard.db;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class GenerateJPASchema {

	public static void main(String[] args) {
	    //Persistence.generateSchema("com.estafet.openshift.scrumboard.jpa", null);
		final String persistenceUnitName = "com.estafet.openshift.scrumboard.jpa";

	    EntityManager em = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
	    em.close();
	    em.getEntityManagerFactory().close();
	  }
	
}
