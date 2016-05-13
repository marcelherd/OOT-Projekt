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
	
	protected QuestionService() {
		
	}

	@Override
	public void save(Question entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question findOne(Long primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Question> findAll(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Question> findByDifficulty(Difficulty difficulty) {
		// TODO Auto-generated method stub
		return null;
	}

}
