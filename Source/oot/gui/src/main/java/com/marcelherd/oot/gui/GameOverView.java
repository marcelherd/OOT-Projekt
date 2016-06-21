package com.marcelherd.oot.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOverView extends JPanel{
	
	private JLabel winnerLabel;
	private JButton replay;
	private JButton highscore;
	private JButton quit;
	private GameWindow parent;
	
	public GameOverView(GameWindow parent, double prize, String playerName){
		this.parent = parent;
		gameOverController controller = new gameOverController();
		setLayout(new BorderLayout());
		winnerLabel = new JLabel("Congratulations, " + playerName + "! You won: " + prize + "€");
		winnerLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		replay = new JButton("Play Again");
		highscore = new JButton("Highscore");
		quit = new JButton("Quit");
		replay.addActionListener(controller);
		highscore.addActionListener(controller);
		quit.addActionListener(controller);
		
		JPanel footerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 80, 0));
		footerPanel.add(replay);
		footerPanel.add(highscore);
		footerPanel.add(quit);
		
		JPanel upperPanel = new JPanel();
		upperPanel.add(winnerLabel);
		
		add(upperPanel, BorderLayout.NORTH);
		add(new JPanel(), BorderLayout.CENTER);
		add(footerPanel, BorderLayout.SOUTH);
		
		setBackground(SystemColor.white);
		for(Component c : getComponents()){
			c.setBackground(SystemColor.white);
		}
	}
	
	private class gameOverController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == replay){
				parent.setView(new SetupView(parent));
			}else if(e.getSource() == highscore){
				parent.setView(new HighscoreView(parent));
			}else if(e.getSource() == quit){
				System.exit(0);
			}
		}
		
	}

}
