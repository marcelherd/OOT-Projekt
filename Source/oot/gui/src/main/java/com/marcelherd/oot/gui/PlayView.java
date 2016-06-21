package com.marcelherd.oot.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import com.marcelherd.oot.game.Game;
import com.marcelherd.oot.game.GameFactory;

public class PlayView extends JPanel {

	private GameWindow parent;
	private Game game;
	private String playerName;
	private JLabel potentialPrize;
	private JLabel questionCounter;
	private JLabel question;

	private JButton answerA, answerB, answerC, answerD;
	private JButton forfeit;
	private JButton audienceJoker, fiftyFiftyJoker, telephoneJoker;

	public PlayView(GameWindow parent, String playerName) {
		PlayController controller = new PlayController();
		this.parent = parent;
		this.playerName = playerName;
		this.game = GameFactory.newInstance();
		setLayout(new BorderLayout());

		JPanel upperPanel = new JPanel();

		potentialPrize = new JLabel();
		potentialPrize.setFont(new Font("Tahoma", Font.BOLD, 30));
		upperPanel.add(potentialPrize);
		upperPanel.setBorder(new LineBorder(Color.black));

		questionCounter = new JLabel();
		question = new JLabel();
		question.setBorder(new LineBorder(Color.BLACK));

		answerA = new JButton();
		answerB = new JButton();
		answerC = new JButton();
		answerD = new JButton();
		answerA.addActionListener(controller);
		answerB.addActionListener(controller);
		answerC.addActionListener(controller);
		answerD.addActionListener(controller);

		JPanel questionPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		questionPanel.add(answerA);
		questionPanel.add(answerB);
		questionPanel.add(answerC);
		questionPanel.add(answerD);

		JPanel jokerPanel = new JPanel();
		audienceJoker = new JButton("Audience");
		fiftyFiftyJoker = new JButton("Fifty Fifty");
		telephoneJoker = new JButton("Telephone");
		audienceJoker.addActionListener(controller);
		fiftyFiftyJoker.addActionListener(controller);
		telephoneJoker.addActionListener(controller);
		jokerPanel.add(audienceJoker);
		jokerPanel.add(fiftyFiftyJoker);
		jokerPanel.add(telephoneJoker);

		JPanel footerPanel = new JPanel(new GridLayout(1, 2));
		forfeit = new JButton("Forfeit");
		forfeit.addActionListener(controller);
		footerPanel.add(jokerPanel);
		footerPanel.add(forfeit);

		JPanel gamePanel = new JPanel(new GridLayout(4, 1, 10, 10));
		gamePanel.add(questionCounter);
		gamePanel.add(question);
		gamePanel.add(questionPanel);
		gamePanel.add(footerPanel);

		add(upperPanel, BorderLayout.NORTH);
		add(gamePanel, BorderLayout.CENTER);

		setBackground(SystemColor.white);
		questionPanel.setBackground(SystemColor.white);
		footerPanel.setBackground(SystemColor.white);
		jokerPanel.setBackground(SystemColor.white);
		for (Component c : getComponents()) {
			c.setBackground(SystemColor.white);
		}

		update();
	}

	private void update() {
		potentialPrize.setText("next Prize: " + game.getPotentialPrize() + "€");
		questionCounter.setText("Question " + (game.getIndex() + 1) + "/15");
		question.setText(game.getCurrentQuestion().getQuestion());
		answerA.setText(game.getCurrentQuestion().getAnswerA());
		answerB.setText(game.getCurrentQuestion().getAnswerB());
		answerC.setText(game.getCurrentQuestion().getAnswerC());
		answerD.setText(game.getCurrentQuestion().getAnswerD());
		answerA.setEnabled(true);
		answerB.setEnabled(true);
		answerC.setEnabled(true);
		answerD.setEnabled(true);
	}





	private class PlayController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == answerA || e.getSource() == answerB || e.getSource() == answerC
					|| e.getSource() == answerD) {
				if (game.answer(((JButton) e.getSource()).getText().split(" - ")[0])) {
					if (game.getIndex() == 14) {
						gameOver(game.getPotentialPrize());
					}
					game.incrementIndex();
					update();
				} else {
					gameOver(game.getPrize());
				}
			} else if (e.getSource() == forfeit) {
				gameOver(game.forfeit());
			}else if(e.getSource() == audienceJoker){
				useAudienceJoker();
			}else if(e.getSource() == telephoneJoker){
				useTelephoneJoker();
			}else if(e.getSource() == fiftyFiftyJoker){
				useFiftyFiftyJoker();
			}
		}
		
		private void gameOver(double prize) {
			parent.setView(new GameOverView(parent, prize, playerName));
		}
		
		private void useTelephoneJoker(){
			JDialog telephoneDialog = new JDialog();
			telephoneDialog.setLayout(new FlowLayout());
			JLabel answerLabel = new JLabel(game.useTelephoneJoker());
			answerLabel.setFont(new Font("Tahama", Font.BOLD, 16));
			telephoneDialog.add(answerLabel);
			telephoneDialog.setSize(400, 80);
			telephoneDialog.setLocationRelativeTo(null);
			telephoneDialog.setVisible(true);
			telephoneJoker.setEnabled(false);
		}
		
		private void useAudienceJoker() {
			Map<String, Double> audienceMap = game.useAudienceJoker();
			answerA.setText(game.getCurrentQuestion().getAnswerA() + " - "
					+ (int)(audienceMap.get(game.getCurrentQuestion().getAnswerA())*100)/100 + "%");
			answerB.setText(game.getCurrentQuestion().getAnswerB() + " - "
					+ (int)(audienceMap.get(game.getCurrentQuestion().getAnswerB())*100)/100 + "%");
			answerC.setText(game.getCurrentQuestion().getAnswerC() + " - "
					+ (int)(audienceMap.get(game.getCurrentQuestion().getAnswerC())*100)/100 + "%");
			answerD.setText(game.getCurrentQuestion().getAnswerD() + " - "
					+ (int)(audienceMap.get(game.getCurrentQuestion().getAnswerD())*100)/100 + "%");
			audienceJoker.setEnabled(false);
		}
		
		private void useFiftyFiftyJoker() {
			List<String> wrongAnswers = game.useFiftyFiftyJoker();
			for(String wrongAnswer : wrongAnswers){
				if(wrongAnswer.equals(answerA.getText().split(" - ")[0])){
					answerA.setEnabled(false);
				}else if(wrongAnswer.equals(answerB.getText().split(" - ")[0])){
					answerB.setEnabled(false);
				}else if(wrongAnswer.equals(answerC.getText().split(" - ")[0])){
					answerC.setEnabled(false);
				}else if(wrongAnswer.equals(answerD.getText().split(" - ")[0])){
					answerD.setEnabled(false);
				}
			}
			fiftyFiftyJoker.setEnabled(false);
		}

	}

}
