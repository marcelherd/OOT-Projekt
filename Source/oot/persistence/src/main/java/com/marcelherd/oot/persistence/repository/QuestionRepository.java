package com.marcelherd.oot.persistence.repository;

import java.util.List;

import com.marcelherd.oot.persistence.entity.Question;
import com.marcelherd.oot.persistence.entity.Question.Difficulty;

/**
 * This interface defines the methods to interact with the question
 * domain type on the database.
 * 
 * @author Marcel Herd
 */
public interface QuestionRepository extends Repository<Question, Long> {
	
	/**
	 * Returns all questions with the given difficulty.
	 * 
	 * @param difficulty - difficulty of the questions
	 * @return all questions with the given difficulty
	 */
	List<Question> findByDifficulty(Difficulty difficulty);
	
}
