package com.marcelherd.oot.persistence.repository;

/**
 * This class is a factory for QuestionServices.
 * 
 * @author Marcel Herd
 */
public class QuestionServiceFactory {
	
	private static QuestionService instance;
	
	/**
	 * Returns an instance of QuestionService.
	 * 
	 * @return an instance of QuestionService
	 */
	public static QuestionService getInstance() {
		if (instance == null) {
			instance = new QuestionService();
		}
		
		return instance;
	}

}
