package com.marcelherd.oot.gui;

import com.marcelherd.oot.game.Game;
import com.marcelherd.oot.game.GameFactory;
import com.marcelherd.oot.game.Highscores;
import com.marcelherd.oot.game.WWMHighscores;

public class App {

	public static void main(String[] args) {
		Game game = GameFactory.newInstance();
		Highscores highscores = new WWMHighscores();
	}

}
