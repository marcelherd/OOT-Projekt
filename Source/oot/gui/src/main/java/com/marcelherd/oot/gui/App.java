package com.marcelherd.oot.gui;

import com.marcelherd.oot.game.WerWirdMillionaer;
import com.marcelherd.oot.game.WerWirdMillionaer.Difficulty;
import com.marcelherd.oot.game.WerWirdMillionaerFactory;
import com.marcelherd.oot.persistence.entity.Question;

public class App {

	public static void main(String[] args) {
		WerWirdMillionaer game = WerWirdMillionaerFactory.newInstance();
		Difficulty difficulty = Difficulty.MEDIUM;
		game.restart(difficulty);
		
		Question firstQuestion = game.currentQuestion();
		System.out.println(firstQuestion);
		Question nextQuestion = game.next();
		System.out.println(nextQuestion);
		System.out.println("Current question: " + game.currentQuestion());
	}

}
