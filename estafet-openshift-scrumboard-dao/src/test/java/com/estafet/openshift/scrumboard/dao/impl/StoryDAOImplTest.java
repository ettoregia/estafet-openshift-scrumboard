package com.estafet.openshift.scrumboard.dao.impl;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.estafet.openshift.scrumboard.entity.Story;
import com.estafet.openshift.scrumboard.entity.Task;

public class StoryDAOImplTest extends BaseDAOTest {

	StoryDAOImpl storyDAO;

	@Before
	public void before() throws Exception {
		cleanDB();
		storyDAO = new StoryDAOImpl();
		storyDAO.setEntityManager(entityManager);
	}

	@BeforeClass
	public static void beforeClass() throws Exception {
		initEntityManager("story-dao.xml");
	}

	@AfterClass
	public static void afterClass() throws Exception {
		closeEntityManager();
	}

	@Test
	public void testSaveStory() {
		Story story = new Story("new story", "this is a new story");
		story.setStorypoints(30)
			 .addAcceptanceCriterion("When I'm finished")
			 .addTask(new Task("new task for story", "another new task", 12));
		int storyId = storyDAO.saveStory(story);
		Story newStory = storyDAO.getStory(storyId);
		assertEquals("new story", newStory.getTitle());
		//assertEquals("When I'm finished", newStory.getAcceptancecriteria().iterator().next().getDescription());
		assertEquals("new task for story", newStory.getTasks().iterator().next().getTitle());
	}

	@Test
	public void testDeleteStory() {
		assertNotNull(storyDAO.getStory(1));
		storyDAO.deleteStory(1);
		assertNull(storyDAO.getStory(1));
	}

	@Test
	public void testGetStory() {
		Story story = storyDAO.getStory(1);
		assertEquals(1, story.getId());
		assertEquals("test story", story.getDescription());
		assertEquals("test task", story.getTasks().iterator().next().getDescription());
	}

}
