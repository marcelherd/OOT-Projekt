package com.marcelherd.oot.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.marcelherd.oot.game.joker.JokerType;

public class WWMGameTest {

	Game game;

	@Before
	public void setUp() {
		this.game = GameFactory.newInstance();
	}

	/**
	 * Tests if the prize money (by failing the next question) is 0
	 */
	@Test
	public void getPrizeZero() {
		assertEquals(0, (int) game.getPrize());
	}

	/**
	 * Tests if the prize money (by failing the next question) is 50
	 */
	@Test
	public void getPrize50() {
		for (int i = 0; i < 4; i++) {
			game.incrementIndex();
		}
		assertEquals(50, (int) game.getPrize());
	}

	/**
	 * Tests if the prize money (by failing the next question) is 500
	 */
	@Test
	public void getPrize500() {
		for (int i = 0; i < 9; i++) {
			game.incrementIndex();
		}
		assertEquals(500, (int) game.getPrize());
	}

	/**
	 * Tests if the prize money (by failing the next question) is 16000
	 */
	@Test
	public void getPrize16000() {
		for (int i = 0; i < 14; i++) {
			game.incrementIndex();
		}
		assertEquals(16000, (int) game.getPrize());
	}

	/**
	 * Tests if the prize money when you answer the next question is 50
	 */
	@Test
	public void getPotentialPrize50() {
		assertEquals(50, (int) game.getPotentialPrize());
	}

	/**
	 * Tests if the prize money when you answer the next question is 1000000
	 */
	@Test
	public void getPotentialPrize1000000() {
		for (int i = 0; i < 14; i++) {
			game.incrementIndex();
		}
		assertEquals(1000000, (int) game.getPotentialPrize());
	}

	/**
	 * Tests if getCurrentTier works for all possible index numbers
	 */
	@Test
	public void getCurrentTierTestWorking() {
		for (int i = 0; i < 15; i++) {
			game.getCurrentTier();
			game.incrementIndex();
		}
	}

	/**
	 * Tests if getCurrentQuestion works for all possible index numbers
	 */
	@Test
	public void getCurrentQuestionTestWorking() {
		for (int i = 0; i < 15; i++) {
			game.getCurrentQuestion();
			game.incrementIndex();
		}
	}

	/**
	 * Tests the availability before and after using a joker
	 */
	@Test
	public void isAvailableTest() {
		assertTrue(game.isAvailable(JokerType.AUDIENCE));
		assertTrue(game.isAvailable(JokerType.FIFTY_FIFTY));
		assertTrue(game.isAvailable(JokerType.TELEPHONE));
		game.useAudienceJoker();
		game.useFiftyFiftyJoker();
		game.useTelephoneJoker();
		assertTrue(!game.isAvailable(JokerType.AUDIENCE));
		assertTrue(!game.isAvailable(JokerType.FIFTY_FIFTY));
		assertTrue(!game.isAvailable(JokerType.TELEPHONE));
	}

	/**
	 * Uses the fiftyFiftyJoker and tests, if the returned List is correctly
	 */
	@Test
	public void useFiftyFiftyJokerTestCorrectness() {
		String correctAnswer = game.getCurrentQuestion().getCorrectAnswer();
		List<String> wrongAnswers = game.useFiftyFiftyJoker();
		assertEquals(wrongAnswers.size(), 2);
		assertTrue(!(wrongAnswers.get(0).equals(correctAnswer) && wrongAnswers.get(1).equals(correctAnswer)));
	}

	/**
	 * Uses the audienceJoker and chekcs if the correct answer has more than 50%
	 */
	@Test
	public void useAudienceJokerTestCorrectness() {
		Map<String, Double> map = game.useAudienceJoker();
		String answerA = game.getCurrentQuestion().getAnswerA();
		String answerB = game.getCurrentQuestion().getAnswerB();
		String answerC = game.getCurrentQuestion().getAnswerC();
		String answerD = game.getCurrentQuestion().getAnswerD();
		String correctAnswer = game.getCurrentQuestion().getCorrectAnswer();
		assertTrue(map.get(answerA) >= 50 && answerA.equals(correctAnswer)
				|| map.get(answerB) >= 50 && answerB.equals(correctAnswer)
				|| map.get(answerC) >= 50 && answerC.equals(correctAnswer)
				|| map.get(answerD) >= 50 && answerD.equals(correctAnswer));
	}

	/**
	 * Tests if the Correct Answer (a, b, c or d) is correct, and the other
	 * incorrect by using answer(String answer)
	 */
	@Test
	public void answerTest() {
		for (int i = 0; i < 15; i++) {
			if (game.getCurrentQuestion().getAnswerA().equals(game.getCurrentQuestion().getCorrectAnswer())) {
				assertTrue(game.answer(game.getCurrentQuestion().getAnswerA()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerB()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerC()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerD()));
			} else if (game.getCurrentQuestion().getAnswerB().equals(game.getCurrentQuestion().getCorrectAnswer())) {
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerA()));
				assertTrue(game.answer(game.getCurrentQuestion().getAnswerB()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerC()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerD()));
			} else if (game.getCurrentQuestion().getAnswerC().equals(game.getCurrentQuestion().getCorrectAnswer())) {
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerA()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerB()));
				assertTrue(game.answer(game.getCurrentQuestion().getAnswerC()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerD()));
			} else if (game.getCurrentQuestion().getAnswerD().equals(game.getCurrentQuestion().getCorrectAnswer())) {
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerA()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerB()));
				assertTrue(!game.answer(game.getCurrentQuestion().getAnswerC()));
				assertTrue(game.answer(game.getCurrentQuestion().getAnswerD()));
			}
			game.incrementIndex();
		}
	}

	/**
	 * Tests if you get 0 prize Money when you forfeit at question 0
	 */
	@Test
	public void forfeitTest0() {
		assertEquals((int) game.forfeit(), 0);
	}

	/**
	 * Tests if you get 50 prize Money when you forfeit at question 1
	 */
	@Test
	public void forfeitTest50() {
		game.incrementIndex();
		assertEquals((int) game.forfeit(), 50);
	}

	/**
	 * Tests if you get 500000 prize Money when you forfeit at question 14
	 */
	@Test
	public void forfeitTest500000() {
		for (int i = 0; i < 14; i++) {
			game.incrementIndex();
		}
		assertEquals((int) game.forfeit(), 500000);
	}
}
