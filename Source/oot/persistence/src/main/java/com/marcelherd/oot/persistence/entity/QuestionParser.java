package com.marcelherd.oot.persistence.entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.marcelherd.oot.persistence.entity.Question.Difficulty;

/**
 * This class provides helper methods to create Question objects
 * from the ResultSet obtained by the database.
 * 
 * @author Marcel Herd
 */
public class QuestionParser {
	
	/**
	 * Returns the Question obtained by the resultSet.
	 * 
	 * @param resultSet - query result from the DBMS.
	 * @return the Question obtained the the resultSet
	 */
	public static Question parseOne(ResultSet resultSet) {
		try {
			Long id = resultSet.getLong("id");
			String question = resultSet.getString("question");
			String answerA = resultSet.getString("answerA");
			String answerB = resultSet.getString("answerB");
			String answerC = resultSet.getString("answerC");
			String answerD = resultSet.getString("answerD");
			String correctAnswer = resultSet.getString("correctAnswer");
			Difficulty difficulty = Difficulty.valueOf(resultSet.getString("difficulty"));
			return new Question(id, question, answerA, answerB, answerC, answerD, correctAnswer, difficulty);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns all Questions obtained by the resultSet.
	 * 
	 * @param resultSet - query result from the DBMS.
	 * @return all Questions obtained by the resultSet
	 */
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
