package com.marcelherd.oot.game;

import java.util.List;

import com.marcelherd.oot.persistence.domain.Highscore;

public interface Highscores {
	
	List<Highscore> getTopTen();

}
