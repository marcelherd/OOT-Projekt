package com.marcelherd.oot.game;

import java.util.List;

import com.marcelherd.oot.persistence.entity.Question;

/**
 * This class acts as a container for questions for the
 * game "Wer Wird Millionär", grouped by their difficulty.
 * 
 * @author Marcel Herd
 */
public class QuestionCatalog {

	private List<Question> easyQuestions;
	private List<Question> mediumQuestions;
	private List<Question> hardQuestions;
	private List<Question> veryHardQuestions;
	
	public QuestionCatalog(List<Question> easyQuestions, List<Question> mediumQuestions,
			List<Question> hardQuestions, List<Question> veryHardQuestions) {
		this.easyQuestions = easyQuestions;
		this.mediumQuestions = mediumQuestions;
		this.hardQuestions = hardQuestions;
		this.veryHardQuestions = veryHardQuestions;
	}

	public List<Question> getEasyQuestions() {
		return easyQuestions;
	}

	public void setEasyQuestions(List<Question> easyQuestions) {
		this.easyQuestions = easyQuestions;
	}

	public List<Question> getMediumQuestions() {
		return mediumQuestions;
	}

	public void setMediumQuestions(List<Question> mediumQuestions) {
		this.mediumQuestions = mediumQuestions;
	}

	public List<Question> getHardQuestions() {
		return hardQuestions;
	}

	public void setHardQuestions(List<Question> hardQuestions) {
		this.hardQuestions = hardQuestions;
	}

	public List<Question> getVeryHardQuestions() {
		return veryHardQuestions;
	}

	public void setVeryHardQuestions(List<Question> veryHardQuestions) {
		this.veryHardQuestions = veryHardQuestions;
	}

}
