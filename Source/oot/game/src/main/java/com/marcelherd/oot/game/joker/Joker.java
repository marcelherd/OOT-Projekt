package com.marcelherd.oot.game.joker;

import com.marcelherd.oot.persistence.domain.Question;

/**
 * This interface defines a Joker as it is used in
 * the game Wer Wird Millionaer.
 * 
 * @author Marcel Herd
 * 
 * @param <T> - Result type of the joker operation
 */
public interface Joker<T> {
	
	/**
	 * Returns true if the joker is available for use.
	 * 
	 * @return true if the joker is available for use
	 */
	boolean isAvailable();

	/**
	 * Returns the result of the joker operation.
	 * 
	 * @param question - Question, that the joker is operating on
	 * @return the result of the joker operation
	 */
	T execute(Question question);
	
}
