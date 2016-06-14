package com.marcelherd.oot.game.joker;

import com.marcelherd.oot.persistence.domain.Question;

public class TelephoneJoker implements Joker<String> {
	
	private boolean available;

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public String execute(Question question) {
		available = false;
		
		return "I think that " + question.getAnswerA() + " is the right answer."; // TODO
	}
	
	

}
