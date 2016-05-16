package com.marcelherd.oot.game;

import com.marcelherd.oot.persistence.entity.Question.Difficulty;
import com.marcelherd.oot.persistence.repository.QuestionRepository;
import com.marcelherd.oot.persistence.repository.JDBCQuestionServiceFactory;

public class GameFactory {
	
	public static Game newInstance() {
		QuestionRepository questionRepository = JDBCQuestionServiceFactory.getInstance();
		QuestionCatalog catalog = new QuestionCatalog(questionRepository.findByDifficulty(Difficulty.EASY),
				questionRepository.findByDifficulty(Difficulty.MEDIUM),
				questionRepository.findByDifficulty(Difficulty.HARD),
				questionRepository.findByDifficulty(Difficulty.VERY_HARD));

		return new Game(catalog);
	}

}
