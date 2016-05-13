package com.marcelherd.oot.persistence.repository;

import java.util.List;

import com.marcelherd.oot.persistence.entity.Question;
import com.marcelherd.oot.persistence.entity.Question.Difficulty;

/**
 * TODO javadoc
 * 
 * @author Marcel Herd
 */
public interface QuestionRepository extends Repository<Question, Long> {
	
	List<Question> findByDifficulty(Difficulty difficulty);
	
}
