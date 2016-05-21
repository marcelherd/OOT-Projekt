package com.marcelherd.oot.persistence.repository.highscore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.TestDatabaseFactory;
import com.marcelherd.oot.persistence.domain.Highscore;

/**
 * Tests {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService}.
 * This test uses an empty stub database.
 * 
 * @author Marcel Herd
 */
public class HighscoreServiceEmptyTest {
	
	private JDBCHighscoreService service;
	
	@Before
	public void setUp() {
		Database database = TestDatabaseFactory.getEmptyDatabase();
		service = JDBCHighscoreServiceFactory.getInstance();
		service.setDatabase(database);
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findOne(Long)}
	 */
	@Test
	public void testFindOne() {
		Highscore highscore = service.findOne(-1l);
		assertNull(highscore);
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findAll()}
	 */
	@Test
	public void testFindAll() {
		List<Highscore> highscores = service.findAll();
		assertEquals(0, highscores.size());
	}

	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#count()}
	 */
	@Test
	public void testCount() {
		Long count = service.count();
		assertEquals(0l, count.longValue());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findTopTen()}
	 */
	@Test
	public void testFindTopTen() {
		List<Highscore> highscores = service.findTopTen();
		assertTrue(highscores.isEmpty());
	}

}
