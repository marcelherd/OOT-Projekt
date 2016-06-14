package com.marcelherd.oot.game.joker;

import com.marcelherd.oot.persistence.domain.Question;

public interface Joker<T> {
	
	boolean isAvailable();

	T execute(Question question);
	
}
