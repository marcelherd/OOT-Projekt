package com.marcelherd.oot.game.joker;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.marcelherd.oot.persistence.domain.Question;

/**
 * This class implements the Wer Wird Millionaer audience joker.
 * 
 * @author Marcel Herd
 */
public class AudienceJoker implements Joker<Map<String, Double>> {
	
	private boolean available = true;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAvailable() {
		return available;
	}

	/**
	 * Returns a mapping between answer and percentage of the question being right.
	 *
	 * This will create the correct result, even if the joker is not available for use.
	 * 
	 * @return a mapping between answer and percentage of the question being right 
	 */
	@Override
	public Map<String, Double> execute(Question question) {
		available = false;
		
		Map<String, Double> map = new HashMap<String, Double>();
		Random random = new Random();
		
//		divide 50% of votes among 4 answers
		double sumPercentageFirstTwoAnswers = random.nextDouble()*50;
		double percentageA = random.nextDouble()*sumPercentageFirstTwoAnswers,
				percentageB = sumPercentageFirstTwoAnswers-percentageA,
				percentageC =  random.nextDouble()*(50-sumPercentageFirstTwoAnswers),
				percentageD = 50-percentageC-sumPercentageFirstTwoAnswers;

		
//		add 50% of votes to correct answer
		if(question.getAnswerA().equals(question.getCorrectAnswer()))
			percentageA += 50;
		if(question.getAnswerB().equals(question.getCorrectAnswer()))
			percentageB += 50;
		if(question.getAnswerC().equals(question.getCorrectAnswer()))
			percentageC += 50;
		if(question.getAnswerD().equals(question.getCorrectAnswer()))
			percentageD += 50;
		System.out.println(percentageA + " " + question.getAnswerA());
		System.out.println(percentageB + " " + question.getAnswerB());
		System.out.println(percentageC + " " + question.getAnswerC());
		System.out.println(percentageD + " " + question.getAnswerD());
		System.out.println(question.getCorrectAnswer());
		
//		map answers and percentages
		map.put(question.getAnswerA(), percentageA);
		map.put(question.getAnswerB(), percentageB);
		map.put(question.getAnswerC(), percentageC);
		map.put(question.getAnswerD(), percentageD);
		
		return map;
	}

}
