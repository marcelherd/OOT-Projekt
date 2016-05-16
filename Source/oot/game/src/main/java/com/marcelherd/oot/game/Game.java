package com.marcelherd.oot.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.marcelherd.oot.persistence.entity.Question;

public class Game {
	
	private static final int MAX_QUESTIONS = 15;
	
	private QuestionCatalog questionCatalog;

	private List<Question> questions;
	
	private int currentQuestion = 0;
	
	public Game(QuestionCatalog questionCatalog) {
		this.questionCatalog = questionCatalog;
	}

	public void restart(Difficulty difficulty) {
		questions = new ArrayList<Question>();
		shuffleQuestionCatalog();
		initializeQuestions(difficulty);
	}

	public Question currentQuestion() {
		if (questions == null) return null;
		return questions.get(currentQuestion);
	}
	
	public Question next() {
		if (currentQuestion == MAX_QUESTIONS - 1) { // Game won
			return null;
		} else {
			currentQuestion++;
			return currentQuestion();
		}
	}
	
	private void shuffleQuestionCatalog() {
		Collections.shuffle(questionCatalog.getEasyQuestions());
		Collections.shuffle(questionCatalog.getMediumQuestions());
		Collections.shuffle(questionCatalog.getHardQuestions());
		Collections.shuffle(questionCatalog.getVeryHardQuestions());
	}
	
	private void initializeQuestions(Difficulty difficulty) {
		questionCatalog.getEasyQuestions().stream().limit(difficulty.easyQuestions).forEach(q -> questions.add(q));
		questionCatalog.getMediumQuestions().stream().limit(difficulty.mediumQuestions).forEach(q -> questions.add(q));
		questionCatalog.getHardQuestions().stream().limit(difficulty.hardQuestions).forEach(q -> questions.add(q));
		questionCatalog.getVeryHardQuestions().stream().limit(difficulty.veryHardQuestions).forEach(q -> questions.add(q));
	}
	
	public enum Difficulty {

    	EASY(10, 4, 1, 0),
    	MEDIUM(6, 5, 3, 1),
    	HARD(4, 4, 5, 2);

    	protected final int easyQuestions;
    	protected final int mediumQuestions;
    	protected final int hardQuestions;
    	protected final int veryHardQuestions;
    	
    	Difficulty(int easyQuestions, int mediumQuestions, int hardQuestions, int veryHardQuestions) {
    		this.easyQuestions = easyQuestions;
    		this.mediumQuestions = mediumQuestions;
    		this.hardQuestions = hardQuestions;
    		this.veryHardQuestions = veryHardQuestions;
    	}
    	
    }

}
