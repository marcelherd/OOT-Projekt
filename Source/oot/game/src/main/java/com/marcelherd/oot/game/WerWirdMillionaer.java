package com.marcelherd.oot.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.marcelherd.oot.persistence.entity.Question;

public class WerWirdMillionaer {
	
	private static final int MAX_QUESTIONS = 15;
	
	private MillionaerQuestionCatalog questionCatalog;

	private List<Question> questions;
	
	private int currentQuestion = 0;
	
	public WerWirdMillionaer(MillionaerQuestionCatalog questionCatalog) {
		this.questionCatalog = questionCatalog;
	}

	public void restart(Difficulty difficulty) {
		shuffleQuestions();
		questions = new ArrayList<Question>();
		questionCatalog.getEasyQuestions().stream().limit(difficulty.easyQuestions).forEach(q -> questions.add(q));
		questionCatalog.getMediumQuestions().stream().limit(difficulty.mediumQuestions).forEach(q -> questions.add(q));
		questionCatalog.getHardQuestions().stream().limit(difficulty.hardQuestions).forEach(q -> questions.add(q));
		questionCatalog.getVeryHardQuestions().stream().limit(difficulty.veryHardQuestions).forEach(q -> questions.add(q));
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
	
	private void shuffleQuestions() {
		Collections.shuffle(questionCatalog.getEasyQuestions());
		Collections.shuffle(questionCatalog.getMediumQuestions());
		Collections.shuffle(questionCatalog.getHardQuestions());
		Collections.shuffle(questionCatalog.getVeryHardQuestions());
	}
	
	public enum Difficulty {

    	EASY(10, 4, 1, 0),
    	MEDIUM(6, 5, 3, 1),
    	HARD(4, 4, 5, 2);

    	final int easyQuestions;
    	final int mediumQuestions;
    	final int hardQuestions;
    	final int veryHardQuestions;
    	
    	Difficulty(int easyQuestions, int mediumQuestions, int hardQuestions, int veryHardQuestions) {
    		this.easyQuestions = easyQuestions;
    		this.mediumQuestions = mediumQuestions;
    		this.hardQuestions = hardQuestions;
    		this.veryHardQuestions = veryHardQuestions;
    	}
    	
    }

}
