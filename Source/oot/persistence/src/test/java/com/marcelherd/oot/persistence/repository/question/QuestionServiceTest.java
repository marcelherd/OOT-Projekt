package com.marcelherd.oot.persistence.repository.question;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.TestDatabaseFactory;
import com.marcelherd.oot.persistence.domain.Question;
import com.marcelherd.oot.persistence.domain.Question.Difficulty;

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
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#save(Question)}
	 */
	@Test
	@Ignore("Test database is read-only by definition")
	public void testSave() { }
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findOne(Long)}
	 */
	@Test
	public void testFindOne() {
		Question question = service.findOne(2l);
		assertEquals(2l, question.getId().longValue());
		assertEquals("Frage 2?", question.getQuestion());
		assertEquals("A", question.getAnswerA());
		assertEquals("B", question.getAnswerB());
		assertEquals("C", question.getAnswerC());
		assertEquals("D", question.getAnswerD());
		assertEquals("B", question.getCorrectAnswer());
		assertEquals(Difficulty.HARD, question.getDifficulty());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findOne(Long)}
	 */
	@Test
	public void testFindOneNotExistent() {
		Question question = service.findOne(-1l);
		assertNull(question);
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findAll()}
	 */
	@Test
	public void testFindAll() {
		List<Question> questions = service.findAll();
		assertEquals(4, questions.size());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findAll(Iterable)}
	 */
	@Test
	public void testFindAllWithIds() {
		List<Question> questions = service.findAll(Arrays.asList(1l, 2l));
		assertEquals(2, questions.size());
		
		Question question = questions.get(1); // spot-check
		assertEquals(2l, question.getId().longValue());
		assertEquals("Frage 2?", question.getQuestion());
		assertEquals("A", question.getAnswerA());
		assertEquals("B", question.getAnswerB());
		assertEquals("C", question.getAnswerC());
		assertEquals("D", question.getAnswerD());
		assertEquals("B", question.getCorrectAnswer());
		assertEquals(Difficulty.HARD, question.getDifficulty());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findAll(Iterable)}
	 */
	@Test
	public void testFindAllWithIdsEmpty() {
		List<Question> questions = service.findAll(Arrays.asList());
		assertTrue(questions.isEmpty());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findAll(Iterable)}
	 */
	@Test
	public void testFindAllWithIdsNotExistent() {
		List<Question> questions = service.findAll(Arrays.asList(1l, 2l, -1l));
		assertEquals(2, questions.size());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#count()}
	 */
	@Test
	public void testCount() {
		Long count = service.count();
		assertEquals(4l, count.longValue());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.question.JDBCQuestionService#findByDifficulty(Difficulty)}
	 */
	@Test
	public void testFindByDifficulty() {
		Difficulty difficulty = Difficulty.HARD;
		List<Question> questions = service.findByDifficulty(difficulty);
		assertEquals(1, questions.size());
		
		Question question = questions.get(0);
		assertEquals(2l, question.getId().longValue());
		assertEquals("Frage 2?", question.getQuestion());
		assertEquals("A", question.getAnswerA());
		assertEquals("B", question.getAnswerB());
		assertEquals("C", question.getAnswerC());
		assertEquals("D", question.getAnswerD());
		assertEquals("B", question.getCorrectAnswer());
		assertEquals(Difficulty.HARD, question.getDifficulty());
	}

}
