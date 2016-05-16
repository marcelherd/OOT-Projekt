package com.marcelherd.oot.gui;

import com.marcelherd.oot.game.Game;
import com.marcelherd.oot.game.Game.Difficulty;
import com.marcelherd.oot.game.GameFactory;
import com.marcelherd.oot.persistence.entity.Question;

public class App {

	public static void main(String[] args) {
		Game game = GameFactory.newInstance();
		Difficulty difficulty = Difficulty.MEDIUM;
		game.restart(difficulty);
		
		Question firstQuestion = game.currentQuestion();
		System.out.println(firstQuestion);
		Question nextQuestion = game.next();
		System.out.println(nextQuestion);
		System.out.println("Current question: " + game.currentQuestion());
	}

}
