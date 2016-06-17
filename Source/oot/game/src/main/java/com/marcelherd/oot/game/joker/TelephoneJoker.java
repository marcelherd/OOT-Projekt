package com.marcelherd.oot.game.joker;

import com.marcelherd.oot.persistence.domain.Question;

/**
 * This class implements the Wer Wird Millionaer telephone joker.
 * 
 * @author Marcel Herd
 */
public class TelephoneJoker implements Joker<String> {
	
	private boolean available;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Returns the called party's guess.
	 * 
	 * This will create the correct result, even if the joker is not available for use.
	 * 
	 * @return the called party's guess
	 */
	@Override
	public String execute(Question question) {
		available = false;
		
		return "I think that " + question.getAnswerA() + " is the right answer.";
	}
	
	

}
