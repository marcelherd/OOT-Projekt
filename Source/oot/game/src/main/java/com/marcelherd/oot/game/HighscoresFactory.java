package com.marcelherd.oot.game;

/**
 * This class is a factory for Highscores.
 * 
 * @author Marcel Herd
 */
public class HighscoresFactory {
	
	private static Highscores instance = null;
	
	/**
	 * Returns a new instance of Highscores.
	 * 
	 * @return a new instance of Highscores
	 */
	public static Highscores getInstance() {
		if (instance == null) {
			instance = new WWMHighscores();
		}
		
		return instance;
	}

}
