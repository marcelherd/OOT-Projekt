package com.marcelherd.oot.persistence.repository.question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.TestDatabaseFactory;
import com.marcelherd.oot.persistence.domain.Question;
import com.marcelherd.oot.persistence.domain.Question.Difficulty;

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
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findOne(Long)}
	 */
	@Test
	public void testFindOne() {
		Question question = service.findOne(-1l);
		assertNull(question);
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findAll()}
	 */
	@Test
	public void testFindAll() {
		List<Question> questions = service.findAll();
		assertTrue(questions.isEmpty());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#count()}
	 */
	@Test
	public void testCount() {
		Long count = service.count();
		assertEquals(0l, count.longValue());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findByDifficulty(Difficulty)}
	 */
	@Test
	public void testFindByDifficulty() {
		Difficulty difficulty = Difficulty.HARD;
		List<Question> questions = service.findByDifficulty(difficulty);
		assertTrue(questions.isEmpty());
	}

}
