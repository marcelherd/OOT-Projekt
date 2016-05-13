package com.marcelherd.oot.persistence.entity;

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
	
	public Question() {
		
	}

	public Question(Long id, String question, String answerA, String answerB, String answerC, String answerD,
			String correctAnswer, Difficulty difficulty) {
		super();
		setId(id);
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.correctAnswer = correctAnswer;
		this.difficulty = difficulty;
	}

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

	@Override
	public String toString() {
		return "Question [question=" + question + ", answerA=" + answerA + ", answerB=" + answerB + ", answerC="
				+ answerC + ", answerD=" + answerD + ", correctAnswer=" + correctAnswer + ", difficulty=" + difficulty
				+ "]";
	}

}