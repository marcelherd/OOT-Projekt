package com.marcelherd.oot.game;

import java.util.List;
import java.util.Map;

import com.marcelherd.oot.game.joker.AudienceJoker;
import com.marcelherd.oot.game.joker.FiftyFiftyJoker;
import com.marcelherd.oot.game.joker.JokerType;
import com.marcelherd.oot.game.joker.TelephoneJoker;
import com.marcelherd.oot.persistence.domain.Question;

/**
 * Wer Wird Millionaer Game implementation
 * 
 * @author Marcel Herd
 */
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public QuestionTier getCurrentTier() {
		return QuestionTier.getTier(index + 1);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPotentialPrize() {
		return getCurrentTier().getPrize();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double getPrize() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Question getCurrentQuestion() {
		return questions.get(index);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAvailable(JokerType joker) {
		switch (joker) {
			case FIFTY_FIFTY: return fiftyFiftyJoker.isAvailable();
			case AUDIENCE: return audienceJoker.isAvailable();
			case TELEPHONE: return telephoneJoker.isAvailable();
			default: return false;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<String> useFiftyFiftyJoker() {
		return fiftyFiftyJoker.execute(getCurrentQuestion());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Double> useAudienceJoker() {
		return audienceJoker.execute(getCurrentQuestion());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String useTelephoneJoker() {
		return telephoneJoker.execute(getCurrentQuestion());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Question start() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean answer(String guess) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double forfeit() {
		// TODO Auto-generated method stub
		return 0;
	}

}
