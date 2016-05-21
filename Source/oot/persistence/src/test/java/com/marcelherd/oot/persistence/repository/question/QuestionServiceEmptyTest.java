package com.marcelherd.oot.persistence.repository.question;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.TestDatabaseFactory;

/**
 * Tests {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService}.
 * This test uses an empty stub database.
 * 
 * @author Marcel Herd
 */
public class QuestionServiceEmptyTest {
	
	private JDBCQuestionService service;
	
	@Before
	public void setUp() {
		Database database = TestDatabaseFactory.getEmptyDatabase();
		service = JDBCQuestionServiceFactory.getInstance();
		service.setDatabase(database);
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#count()}
	 */
	@Test
	public void testCount() {
		Long count = service.count();
		assertEquals(0l, count.longValue());
	}

}
