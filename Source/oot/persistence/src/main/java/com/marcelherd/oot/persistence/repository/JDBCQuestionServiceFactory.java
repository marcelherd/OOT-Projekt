package com.marcelherd.oot.persistence.repository;

/**
 * This class is a factory for JDBCQuestionServices.
 * 
 * @author Marcel Herd
 */
public class JDBCQuestionServiceFactory {
	
	private static JDBCQuestionService instance;
	
	/**
	 * Returns an instance of JDBCQuestionService.
	 * 
	 * @return an instance of JDBCQuestionService
	 */
	public static JDBCQuestionService getInstance() {
		if (instance == null) {
			instance = new JDBCQuestionService();
		}
		
		return instance;
	}

}
