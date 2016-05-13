package com.marcelherd.oot.persistence.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.marcelherd.oot.persistence.entity.Question.Difficulty;

public class QuestionParser {
	
	public static Question parseOne(ResultSet resultSet) {
		try {
			Long id = resultSet.getLong("id");
			String question = resultSet.getString("question");
			String answerA = resultSet.getString("answerA");
			String answerB = resultSet.getString("answerB");
			String answerC = resultSet.getString("answerC");
			String answerD = resultSet.getString("answerD");
			String correctAnswer = resultSet.getString("correctAnswer");
			String difficultyString = resultSet.getString("difficulty");
			Difficulty difficulty = null;
			switch (difficultyString) {
			case "EASY":
				difficulty = Difficulty.EASY;
				break;
			case "MEDIUM":
				difficulty = Difficulty.MEDIUM;
				break;
			case "HARD":
				difficulty = Difficulty.HARD;
				break;
			case "VERY_HARD":
				difficulty = Difficulty.VERY_HARD;
				break;
			}
			return new Question(id, question, answerA, answerB, answerC, answerD, correctAnswer, difficulty);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<Question> parseAll(ResultSet resultSet) {
		try {
			List<Question> questions = new ArrayList<Question>();
			while (resultSet.next()) {
				questions.add(parseOne(resultSet));
			}
			return questions;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

}
