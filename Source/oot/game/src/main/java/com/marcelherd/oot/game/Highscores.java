package com.marcelherd.oot.game;

import java.util.List;

import com.marcelherd.oot.persistence.domain.Highscore;

/**
 * Wer Wird Millionaer highscores interface
 * 
 * @author Marcel Herd
 */
public interface Highscores {
	
	/**
	 * Returns the top ten highscores.
	 * 
	 * @return the top ten highscores
	 */
	List<Highscore> getTopTen();
	
	
	/**
	 * Saves the given highscore.
	 * 
	 * @param highscore - Highscore to save.
	 */
	void save(Highscore highscore);	

}
