package com.marcelherd.oot.game;

import java.util.List;
import java.util.Map;

import com.marcelherd.oot.game.joker.JokerType;
import com.marcelherd.oot.persistence.domain.Question;

/**
 * Wer Wird Millionaer game interface
 * 
 * @author Marcel Herd
 */
public interface Game {
	
	/**
	 * Returns the question tier, that the game is currently on.
	 * 
	 * @return the question tier that the game is currently on
	 */
	QuestionTier getCurrentTier();
	
	/**
	 * Returns the prize, that the player would receive if he answers the current question correctly.
	 * 
	 * @return the prize, that the player would receive if he answers the current question correctly
	 */
	double getPotentialPrize();
	
	/**
	 * Returns the actual prize money, that the player will receive after the game.
	 * 
	 * @return the actual prize money, that the player will receive after the game
	 */
	double getPrize();
	
	/**
	 * Returns the question, that the game is currently on.
	 * 
	 * @return the question, that the game is currently on
	 */
	Question getCurrentQuestion();
	
	/**
	 * Returns true, if the joker is available for use.
	 * 
	 * @param joker - The joker, whose availability is being checked
	 * @return true, if the joker is available for use
	 */
	boolean isAvailable(JokerType joker);
	
	/**
	 * Returns two randomly selected answers, that are wrong.
	 * 
	 * @return two randomly selected answers, that are wrong
	 */
	List<String> useFiftyFiftyJoker();
	
	/**
	 * Returns a mapping between answer and percentage of the question being right.
	 * 
	 * @return a mapping between answer and percentage of the question being right
	 */
	Map<String, Double> useAudienceJoker();
	
	/**
	 * Returns the called party's guess.
	 * 
	 * @return the called party's guess
	 */
	String useTelephoneJoker();
	
	/**
	 * Starts the Wer Wird Millionaer game and returns the first question.
	 * 
	 * Starting the game is defined as randomly selecting 15 questions
	 * with increasing difficulty.
	 * 
	 * @return the first question
	 */
	Question start();
	
	/**
	 * Returns true, if guess is the correct answer to the current question.
	 * 
	 * @param guess - guessed answer
	 * @return true, if guess is the correct answer to the current question
	 */
	boolean answer(String guess);
	
	/**
	 * Ends the game and returns the actually won prize money.
	 * 
	 * @return the actually won prize money
	 */
	double forfeit();

}
