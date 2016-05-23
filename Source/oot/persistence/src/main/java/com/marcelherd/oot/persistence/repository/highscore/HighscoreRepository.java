package com.marcelherd.oot.persistence.repository.highscore;

import java.util.List;

import com.marcelherd.oot.persistence.domain.Highscore;
import com.marcelherd.oot.persistence.repository.Repository;

/**
 * This interface defines the methods to interact with the highscore
 * domain type on the database.
 * 
 * @author Marcel Herd
 */
public interface HighscoreRepository extends Repository<Highscore, Long> {
	
	/**
	 * Returns the top 10 highscores.
	 * 
	 * @return the top 10 highscores
	 */
	List<Highscore> findTopTen();

}
