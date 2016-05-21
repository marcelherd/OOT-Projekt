package com.marcelherd.oot.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests {@link com.marcelherd.oot.persistence.Database}
 * 
 * @author Marcel Herd
 */
public class DatabaseTest {
	
	private Database database;
	
	@Before
	public void setUp() {
		database = DatabaseFactory.getInstance();
	}
	
	/**
	 * Test method for {@link com.marcelherd.oot.persistence.Database#getConnection()}
	 * 
	 * @throws SQLException - if connection failed
	 */
	@Test
	public void testConnection() throws SQLException {
		Connection connection = database.getConnection();
		connection.close();
	}
	
	/**
	 * Tests whether the provided database has a valid structure (i.e.
	 * whether the database contains all necessary tables).
	 * 
	 * @throws SQLException - if any table is missing
	 */
	@Test
	public void testDatabaseValid() throws SQLException {
		try (Connection connection = database.getConnection()) {
			try (Statement statement = connection.createStatement()) {
				statement.executeQuery("SELECT * FROM questions");
			}
			try (Statement statement = connection.createStatement()) {
				statement.executeQuery("SELECT * FROM highscores");
			}
		}
	}

}
