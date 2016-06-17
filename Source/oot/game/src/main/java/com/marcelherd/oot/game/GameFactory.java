package com.marcelherd.oot.game;

import com.marcelherd.oot.persistence.domain.Question.Difficulty;
import com.marcelherd.oot.persistence.repository.question.JDBCQuestionServiceFactory;
import com.marcelherd.oot.persistence.repository.question.QuestionRepository;

/**
 * This class is a factory for Games.
 * 
 * @author Marcel Herd
 */
public class GameFactory {
	
	/**
	 * Returns a new instance of Game.
	 * 
	 * @return a new instance of Game
	 */
	public static Game newInstance() {
		QuestionRepository questionRepository = JDBCQuestionServiceFactory.getInstance();
		QuestionCatalog catalog = new QuestionCatalog(questionRepository.findByDifficulty(Difficulty.EASY),
				questionRepository.findByDifficulty(Difficulty.MEDIUM),
				questionRepository.findByDifficulty(Difficulty.HARD),
				questionRepository.findByDifficulty(Difficulty.VERY_HARD));

		return new WWMGame(catalog);
	}

}
