package com.marcelherd.oot.game.joker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		List<String> list = new ArrayList<String>();
		
		//add all wrong answers to list
		if(question.getAnswerA()!=question.getCorrectAnswer())
			list.add(question.getAnswerA());
		if(question.getAnswerB()!=question.getCorrectAnswer())
			list.add(question.getAnswerB());
		if(question.getAnswerC()!=question.getCorrectAnswer())
			list.add(question.getAnswerC());
		if(question.getAnswerD()!=question.getCorrectAnswer())
			list.add(question.getAnswerD());
		
		//delete a wrong answer at random
		list.remove(new Random().nextInt(3));
		
		return list;
	}
}
