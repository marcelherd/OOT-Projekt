package com.marcelherd.oot.persistence;

/**
 * This class is a factory for stub Databases.
 * 
 * @author Marcel Herd
 */
public class TestDatabaseFactory {
	
	private static Database testDatabase;
	private static Database emptyDatabase;
	
	/**
	 * Returns a database that contains test data.
	 * 
	 * @return a database that contains test data
	 */
	public static Database getTestDatabase() {
		if (testDatabase == null) {
			testDatabase = new Database("org.sqlite.JDBC", "jdbc:sqlite::resource:testdatabase.sqlite");
		}
		
		return testDatabase;
	}
	
	/**
	 * Returns a database that contains only the schema and no actual data.
	 * 
	 * @return a database that contains only the schema and no actual data
	 */
	public static Database getEmptyDatabase() {
		if (emptyDatabase == null) {
			emptyDatabase = new Database("org.sqlite.JDBC", "jdbc:sqlite::resource:emptydatabase.sqlite");
		}
		
		return emptyDatabase;
	}

}
