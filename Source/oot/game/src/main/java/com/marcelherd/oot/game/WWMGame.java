package com.marcelherd.oot.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

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
		start();
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
		for(int i = index-1; i>=0; i--){
			if(QuestionTier.values()[i].isCheckpoint()){
				return QuestionTier.values()[i].getPrize();
			}
		}
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
	public void start() {
		// TODO Auto-generated method stub
		Random r = new Random();
		questions = new LinkedList<Question>();
		
		// Removes Questions from Catalog to prevent getting equal questions.
		
		for(int i = 0; i<5; i++){
			questions.add(catalog.getEasyQuestions().remove(r.nextInt(catalog.getEasyQuestions().size())));
		}
		for(int i = 0; i<5; i++){
			questions.add(catalog.getMediumQuestions().remove(r.nextInt(catalog.getMediumQuestions().size())));
		}
		for(int i = 0; i<4; i++){
			questions.add(catalog.getHardQuestions().remove(r.nextInt(catalog.getHardQuestions().size())));
		}			
		questions.add(catalog.getVeryHardQuestions().remove(r.nextInt(catalog.getVeryHardQuestions().size())));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean answer(String guess) {
		return questions.get(index).getCorrectAnswer().equals(guess);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public double forfeit() {
		if(index==0)return 0;
		return QuestionTier.values()[index-1].getPrize();
	}
	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getIndex() {
		return index;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void incrementIndex() {
		index++;
	}

}
