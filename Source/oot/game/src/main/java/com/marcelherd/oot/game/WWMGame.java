package com.marcelherd.oot.game;

import java.util.List;
import java.util.Map;

import com.marcelherd.oot.game.joker.AudienceJoker;
import com.marcelherd.oot.game.joker.FiftyFiftyJoker;
import com.marcelherd.oot.game.joker.JokerType;
import com.marcelherd.oot.game.joker.TelephoneJoker;
import com.marcelherd.oot.persistence.domain.Question;

public class WWMGame implements Game {
	
	private QuestionCatalog catalog;
	
	private List<Question> questions;
	
	private FiftyFiftyJoker fiftyFiftyJoker;
	private AudienceJoker audienceJoker;
	private TelephoneJoker telephoneJoker;
	
	private int index = 0;
	
	public WWMGame(QuestionCatalog catalog) {
		this.catalog = catalog;
		this.fiftyFiftyJoker = new FiftyFiftyJoker();
		this.audienceJoker = new AudienceJoker();
		this.telephoneJoker = new TelephoneJoker();
	}

	@Override
	public QuestionTier getCurrentTier() {
		return QuestionTier.getTier(index + 1);
	}

	@Override
	public double getPotentialPrize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getPrize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Question getCurrentQuestion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAvailable(JokerType joker) {
		switch (joker) {
			case FIFTY_FIFTY: return fiftyFiftyJoker.isAvailable();
			case AUDIENCE: return audienceJoker.isAvailable();
			case TELEPHONE: return telephoneJoker.isAvailable();
			default: return false;
		}
	}

	@Override
	public List<String> useFiftyFiftyJoker() {
		return fiftyFiftyJoker.execute(getCurrentQuestion());
	}

	@Override
	public Map<String, Double> useAudienceJoker() {
		return audienceJoker.execute(getCurrentQuestion());
	}

	@Override
	public String useTelephoneJoker() {
		return telephoneJoker.execute(getCurrentQuestion());
	}

	@Override
	public Question start() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean answer(String guess) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double forfeit() {
		// TODO Auto-generated method stub
		return 0;
	}

}
