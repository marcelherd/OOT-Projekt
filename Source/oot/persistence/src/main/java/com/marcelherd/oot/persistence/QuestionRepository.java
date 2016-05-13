package com.marcelherd.oot.persistence;

import java.util.List;

import com.marcelherd.oot.persistence.model.Question;
import com.marcelherd.oot.persistence.model.Question.Difficulty;

/**
 * TODO javadoc
 * 
 * @author Marcel Herd
 */
public interface QuestionRepository extends Repository<Question, Long> {
	
	List<Question> findByDifficulty(Difficulty difficulty);
	
}
