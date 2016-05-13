package com.marcelherd.oot.persistence;

import java.util.List;

import com.marcelherd.oot.persistence.model.Question;
import com.marcelherd.oot.persistence.model.Question.Difficulty;

/**
 * TODO javadoc
 * 
 * @author Marcel Herd
 */
public class QuestionService implements QuestionRepository {

	public void save(Question entity) {
		// TODO Auto-generated method stub
		
	}

	public void save(Iterable<Question> entities) {
		// TODO Auto-generated method stub
		
	}

	public Question findOne(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Question> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Question> findByDifficulty(Difficulty difficulty) {
		// TODO Auto-generated method stub
		return null;
	}

	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Question entity) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Iterable<Question> entities) {
		// TODO Auto-generated method stub
		
	}

}
