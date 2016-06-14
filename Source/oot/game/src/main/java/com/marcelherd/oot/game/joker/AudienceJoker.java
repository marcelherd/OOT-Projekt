package com.marcelherd.oot.game.joker;

import java.util.Map;

import com.marcelherd.oot.persistence.domain.Question;

public class AudienceJoker implements Joker<Map<String, Double>> {
	
	private boolean available = true;

	@Override
	public boolean isAvailable() {
		return available;
	}

	@Override
	public Map<String, Double> execute(Question question) {
		available = false;
		
		return null;
	}

}
