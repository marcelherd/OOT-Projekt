package com.marcelherd.oot.persistence.model;

/**
 * TODO javadoc
 * 
 * @author Marcel Herd
 */
public class Question extends Entity {
	
	private String question;
	
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	
	private String correctAnswer; // referenz of A/B/C/D
	
	private Difficulty difficulty;
	
	/**
	 * TODO javadoc
	 * 
	 * @author Marcel Herd
	 */
	public enum Difficulty {
		
		EASY,
		MEDIUM,
		HARD,
		VERY_HARD

	}

}
