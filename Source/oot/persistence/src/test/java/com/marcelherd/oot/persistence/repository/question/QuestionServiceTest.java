package com.marcelherd.oot.persistence.repository.question;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.TestDatabaseFactory;

/**
 * Tests {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService}.
 * This test uses a stub database.
 * 
 * @author Marcel Herd
 */
public class QuestionServiceTest {
	
	private JDBCQuestionService service;
	
	@Before
	public void setUp() {
		Database database = TestDatabaseFactory.getTestDatabase();
		service = JDBCQuestionServiceFactory.getInstance();
		service.setDatabase(database);
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#count()}
	 */
	@Test
	public void testCount() {
		Long count = service.count();
		assertEquals(4l, count.longValue());
	}

}
