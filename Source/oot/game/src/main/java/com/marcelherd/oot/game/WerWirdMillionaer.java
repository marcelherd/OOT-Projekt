package com.marcelherd.oot.game;

import com.marcelherd.oot.game.Game.Difficulty;
import com.marcelherd.oot.persistence.domain.Question;

/**
 * TODO
 * 
 * @author Marcel Herd
 */
public interface WerWirdMillionaer {
	
	/**
	 * Starts the game with the given difficulty and returns the first question.
	 * 
	 * @param difficulty - determines the difficulty of the game
	 * @return the first question
	 */
	Question start(Difficulty difficulty);
	
	/**
	 * Returns the current question or null if the game hasn't started yet.
	 * 
	 * @return the current question or null if the game hasn't started yet
	 */
	Question currentQuestion();
	
	/**
	 * Returns true if answer is the correct answer.
	 * The game will end if the wrong answer is given.
	 * 
	 * @param answer - given answer to the current question
	 * @return true if answer is the correct answer
	 */
	boolean answer(String answer);
	
	/**
	 * Returns true if the game is not finished yet.
	 * 
	 * @return true if the game is not finished yet
	 */
	boolean playing();

}
