package com.marcelherd.oot.persistence.repository.question;

import java.util.List;

import com.marcelherd.oot.persistence.domain.Question;
import com.marcelherd.oot.persistence.domain.Question.Difficulty;
import com.marcelherd.oot.persistence.repository.Repository;

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
