package com.marcelherd.oot.persistence.repository.highscore;

/**
 * This class is a factory for JDBCHighscoreServices.
 * 
 * @author Marcel Herd
 */
public class JDBCHighscoreServiceFactory {

	private static JDBCHighscoreService instance;
	
	/**
	 * Returns an instance of JDBCHighscoreService.
	 * 
	 * @return an instance of JDBCHighscoreService
	 */
	public static JDBCHighscoreService getInstance() {
		if (instance == null) {
			instance = new JDBCHighscoreService();
		}
		
		return instance;
	}
	
}