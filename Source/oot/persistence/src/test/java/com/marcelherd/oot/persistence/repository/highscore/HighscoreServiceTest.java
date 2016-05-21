package com.marcelherd.oot.persistence.repository.highscore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.TestDatabaseFactory;
import com.marcelherd.oot.persistence.domain.Highscore;

/**
 * Tests {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService}.
 * This test uses a stub database.
 * 
 * @author Marcel Herd
 */
public class HighscoreServiceTest {
	
	private JDBCHighscoreService service;
	
	@Before
	public void setUp() {
		Database database = TestDatabaseFactory.getTestDatabase();
		service = JDBCHighscoreServiceFactory.getInstance();
		service.setDatabase(database);
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#save(Highscore)}
	 */
	@Test
	@Ignore("Test database is read-only by definition")
	public void testSave() { }
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findOne(Long)}
	 */
	@Test
	public void testFindOne() {
		Highscore highscore = service.findOne(2l);
		assertEquals(2l, highscore.getId().longValue());
		assertEquals("Marcel", highscore.getName());
		assertEquals(500000, highscore.getSum());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findAll()}
	 */
	@Test
	public void testFindAll() {
		List<Highscore> highscores = service.findAll();
		assertEquals(12, highscores.size());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findAll(Iterable)}
	 */
	@Test
	public void testFindAllWithIds() {
		List<Highscore> highscores = service.findAll(Arrays.asList(1l, 2l));
		assertEquals(2, highscores.size());
		
		Highscore highscore = highscores.get(1); // spot-check
		assertEquals(2l, highscore.getId().longValue());
		assertEquals("Marcel", highscore.getName());
		assertEquals(500000, highscore.getSum());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findAll(Iterable)}
	 */
	@Test
	public void testFindAllWithIdsEmpty() {
		List<Highscore> highscores = service.findAll(Arrays.asList());
		assertTrue(highscores.isEmpty());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findAll(Iterable)}
	 */
	@Test
	public void testFindAllWithIdsNotExistent() {
		List<Highscore> highscores = service.findAll(Arrays.asList(1l, 2l, -1l));
		assertEquals(2, highscores.size());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#count()}
	 */
	@Test
	public void testCount() {
		Long count = service.count();
		assertEquals(12l, count.longValue());
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreService#findTopTen()}
	 */
	@Test
	public void testFindTopTen() {
		List<Highscore> highscores = service.findTopTen();
		assertEquals(10, highscores.size());
		
		int previous = highscores.get(0).getSum();
		for (Highscore highscore : highscores) {
			if (highscore.getSum() > previous) {
				fail("Top ten was not in order");
			} else {
				previous = highscore.getSum();
			}
		}
	}

}
