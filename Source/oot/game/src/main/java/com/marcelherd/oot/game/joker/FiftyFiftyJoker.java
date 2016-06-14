package com.marcelherd.oot.game.joker;

import java.util.List;

import com.marcelherd.oot.persistence.domain.Question;

public class FiftyFiftyJoker implements Joker<List<String>> {
	
	private boolean available = true;

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public List<String> execute(Question question) {
		available = false;
		
		return null;
	}

}
