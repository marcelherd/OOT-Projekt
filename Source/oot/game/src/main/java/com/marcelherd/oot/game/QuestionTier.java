package com.marcelherd.oot.game;

/**
 * This enumeration contains all the question tiers,
 * that the game Wer Wird Millionaer defines.
 * 
 * @author Marcel Herd
 */
public enum QuestionTier {

	QUESTION_1(50, true),
	QUESTION_2(100, false),
	QUESTION_3(200, false),
	QUESTION_4(300, false),
	QUESTION_5(500, true),
	QUESTION_6(1000, false),
	QUESTION_7(2000, false),
	QUESTION_8(4000, false),
	QUESTION_9(8000, false),
	QUESTION_10(16000, true),
	QUESTION_11(32000, false),
	QUESTION_12(64000, false),
	QUESTION_13(125000, false),
	QUESTION_14(500000, false),
	QUESTION_15(1000000, false);
	
	private double prize;
	private boolean checkpoint;
	
	private QuestionTier(double prize, boolean checkpoint) {
		this.prize = prize;
		this.checkpoint = checkpoint;
	}

	public double getPrize() {
		return prize;
	}

	public boolean isCheckpoint() {
		return checkpoint;
	}
	
	public static QuestionTier getTier(int number) {
		return QuestionTier.values()[number - 1];
	}

}
