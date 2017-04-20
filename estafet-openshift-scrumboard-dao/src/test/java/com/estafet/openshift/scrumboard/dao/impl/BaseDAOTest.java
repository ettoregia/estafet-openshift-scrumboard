package com.estafet.openshift.scrumboard.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.ext.postgresql.PostgresqlDataTypeFactory;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.internal.SessionImpl;

public abstract class BaseDAOTest {

	static EntityManagerFactory entityManagerFactory;
	static EntityManager entityManager;
	static IDatabaseConnection connection;
	static IDataSet dataSet;

	protected void cleanDB() throws Exception {
        entityManager.clear();
        DatabaseOperation.CLEAN_INSERT.execute(connection, dataSet);
    }
	
	protected static void initEntityManager(String dataFileName) throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("test");
        entityManager = entityManagerFactory.createEntityManager();

        connection = wrapDatabaseConnection(entityManager);
        dataSet = loadBaseDataSet(dataFileName);
    }
	protected static void closeEntityManager() throws Exception {
        DatabaseOperation.DELETE_ALL.execute(connection, dataSet);
        entityManager.close();
        entityManagerFactory.close();
    }
	
	private static IDataSet loadBaseDataSet(String baseDataSet) throws Exception {
		FlatXmlDataSetBuilder flatXmlDataSetBuilder = new FlatXmlDataSetBuilder();
		flatXmlDataSetBuilder.setColumnSensing(true);
		IDataSet dataset = flatXmlDataSetBuilder
				.build(Thread.currentThread().getContextClassLoader().getResourceAsStream(baseDataSet));
		return dataset;
	}

	private static IDatabaseConnection wrapDatabaseConnection(EntityManager entityManager) throws Exception {
		IDatabaseConnection connection = null;
		connection = new DatabaseConnection(entityManager.unwrap(SessionImpl.class).connection());
		connection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new PostgresqlDataTypeFactory());
		return connection;
	}

}
