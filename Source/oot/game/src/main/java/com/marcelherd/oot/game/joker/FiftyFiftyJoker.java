package com.marcelherd.oot.game.joker;

import java.util.List;

import com.marcelherd.oot.persistence.domain.Question;

/**
 * This class implements the Wer Wird Millionaer fifty-fifty joker.
 * 
 * @author Marcel Herd
 */
public class FiftyFiftyJoker implements Joker<List<String>> {
	
	private boolean available = true;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Returns two randomly selected answers, that are wrong.
	 * 
	 * This will create the correct result, even if the joker is not available for use.
	 *
	 * @return two randomly selected answers, that are wrong
	 */
	@Override
	public List<String> execute(Question question) {
		available = false;
		
		return null;
	}

}
