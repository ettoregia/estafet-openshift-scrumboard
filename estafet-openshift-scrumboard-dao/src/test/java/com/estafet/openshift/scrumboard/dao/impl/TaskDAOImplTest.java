package com.estafet.openshift.scrumboard.dao.impl;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.estafet.openshift.scrumboard.entity.Task;
import com.estafet.openshift.scrumboard.entity.TaskStatus;

public class TaskDAOImplTest extends BaseDAOTest {

    TaskDAOImpl taskDAO;
    
	@Before
    public void before() throws Exception {
        cleanDB();
        taskDAO = new TaskDAOImpl();
        taskDAO.setEntityManager(entityManager);
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
    	initEntityManager("task-dao.xml");
    }

    @AfterClass
    public static void afterClass() throws Exception {
    	closeEntityManager();
    }
	
	@Test
	public void testSaveTask() {
		Task task = new Task("new task", "this is a new task", 40);
		int taskId = taskDAO.saveTask(task);
		Task newTask = taskDAO.getTask(taskId);
		assertEquals("new task", newTask.getTitle());
		assertEquals("this is a new task", newTask.getDescription());
		assertEquals(40, newTask.getInitialHours());
		assertEquals(TaskStatus.UNCLAIMED, newTask.getStatus());
	}

	@Test
	public void testDeleteTask() {
		assertNotNull(taskDAO.getTask(1));
		taskDAO.deleteTask(1);
		assertNull(taskDAO.getTask(1));
	}

	@Test
	public void testGetTask() {
		Task task = taskDAO.getTask(1);
		assertEquals(1, task.getId());
		assertEquals("test task", task.getDescription());
	}

}
