package com.marcelherd.oot.game.joker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		Random random = new Random();
		
		//simulate 75% chance of joker returning the right answer
		if(0!=random.nextInt(3)){
			//return right answer
			return "I think that " + question.getCorrectAnswer() + " is the right answer.";
		}else{
			//return wrong answer
			
			List<String> list = new ArrayList<String>();
			String answer = question.getCorrectAnswer();
			
			//add all wrong answers to list
			if(question.getAnswerA()!=answer)
				list.add(question.getAnswerA());
			if(question.getAnswerB()!=answer)
				list.add(question.getAnswerB());
			if(question.getAnswerC()!=answer)
				list.add(question.getAnswerC());
			if(question.getAnswerD()!=answer)
				list.add(question.getAnswerD());
			
			//delete two wrong answers at random
			list.remove(random.nextInt(3));
			list.remove(random.nextInt(2));
			
			return "I think that " + list.get(0) + " is the right answer.";
		}
	}
	
	

}
