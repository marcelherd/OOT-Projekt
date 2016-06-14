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
	
	QuestionTier getCurrentTier();
	
	double getPotentialPrize();
	
	double getPrize();
	
	Question getCurrentQuestion();
	
	boolean isAvailable(JokerType joker);
	
	List<String> useFiftyFiftyJoker();
	
	Map<String, Double> useAudienceJoker();
	
	String useTelephoneJoker();
	
	Question start();
	
	boolean answer(String guess);
	
	double forfeit();

}
