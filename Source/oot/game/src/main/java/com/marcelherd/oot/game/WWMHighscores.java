package com.marcelherd.oot.game;

import java.util.List;

import com.marcelherd.oot.persistence.domain.Highscore;
import com.marcelherd.oot.persistence.repository.highscore.HighscoreRepository;
import com.marcelherd.oot.persistence.repository.highscore.JDBCHighscoreServiceFactory;

/**
 * Wer Wird Millionaer Highscores implementation
 * 
 * @author Marcel Herd
 */
public class WWMHighscores implements Highscores {
	
	private HighscoreRepository highscoreRepository;
	
	public WWMHighscores() {
		this.highscoreRepository = JDBCHighscoreServiceFactory.getInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Highscore> getTopTen() {
		return highscoreRepository.findTopTen();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Highscore highscore) {
		highscoreRepository.save(highscore);
	}

}
