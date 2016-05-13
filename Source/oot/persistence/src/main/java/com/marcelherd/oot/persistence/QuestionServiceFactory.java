package com.marcelherd.oot.persistence;

/**
 * TODO javadoc
 * 
 * @author Marcel Herd
 */
public class QuestionServiceFactory {
	
	private static QuestionService instance;
	
	public static QuestionService getInstance() {
		if (instance == null) {
			instance = new QuestionService();
		}
		
		return instance;
	}

}
