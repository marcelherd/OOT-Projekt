package com.marcelherd.oot.persistence.entity;

/**
 * This domain type defines a question, as it is
 * used in the game "Wer Wird Millionär".
 * 
 * @author Marcel Herd
 */
public class Question extends Entity {

	private static final long serialVersionUID = 2979062653214998432L;

	private String question;
	
	private String answerA;
	private String answerB;
	private String answerC;
	private String answerD;
	
	private String correctAnswer;
	
	private Difficulty difficulty;
	
	public Question() {
		super();
	}

	public Question(Long id, String question, String answerA, String answerB, String answerC, String answerD,
			String correctAnswer, Difficulty difficulty) {
		this.id = id;
		this.question = question;
		this.answerA = answerA;
		this.answerB = answerB;
		this.answerC = answerC;
		this.answerD = answerD;
		this.correctAnswer = correctAnswer;
		this.difficulty = difficulty;
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public Difficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Difficulty difficulty) {
		this.difficulty = difficulty;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Question [question=");
		builder.append(question);
		builder.append(", answerA=");
		builder.append(answerA);
		builder.append(", answerB=");
		builder.append(answerB);
		builder.append(", answerC=");
		builder.append(answerC);
		builder.append(", answerD=");
		builder.append(answerD);
		builder.append(", correctAnswer=");
		builder.append(correctAnswer);
		builder.append(", difficulty=");
		builder.append(difficulty);
		builder.append(", id=");
		builder.append(id);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * This enumeration lists all possible difficulties that questions can have.
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