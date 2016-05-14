package com.marcelherd.oot.game;

import com.marcelherd.oot.persistence.entity.Question.Difficulty;
import com.marcelherd.oot.persistence.repository.QuestionService;
import com.marcelherd.oot.persistence.repository.QuestionServiceFactory;

public class WerWirdMillionaerFactory {
	
	public static WerWirdMillionaer newInstance() {
		QuestionService questionService = QuestionServiceFactory.getInstance();
		MillionaerQuestionCatalog catalog = new MillionaerQuestionCatalog(questionService.findByDifficulty(Difficulty.EASY),
				questionService.findByDifficulty(Difficulty.MEDIUM),
				questionService.findByDifficulty(Difficulty.HARD),
				questionService.findByDifficulty(Difficulty.VERY_HARD));

		return new WerWirdMillionaer(catalog);
	}

}
