package com.marcelherd.oot.game.joker;

import java.util.Map;

import com.marcelherd.oot.persistence.domain.Question;

/**
 * This class implements the Wer Wird Millionaer audience joker.
 * 
 * @author Marcel Herd
 */
public class AudienceJoker implements Joker<Map<String, Double>> {
	
	private boolean available = true;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Returns a mapping between answer and percentage of the question being right.
	 *
	 * This will create the correct result, even if the joker is not available for use.
	 * 
	 * @return a mapping between answer and percentage of the question being right
	 */
	@Override
	public Map<String, Double> execute(Question question) {
		available = false;
		
		return null;
	}

}
