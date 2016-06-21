package com.marcelherd.oot.gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Displays the Main Menu
 * @author Manuel Schwalm
 *
 */


public class MainMenuView extends JPanel {

	private JButton playButton = new JButton("Play");
	private JButton highscoresButton = new JButton("Highscores");
	private JButton quitButton = new JButton("Quit");
	private GameWindow parent;

	public MainMenuView(GameWindow parent) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.parent = parent;
		
		MainMenuController controller = new MainMenuController();
		playButton.addActionListener(controller);
		highscoresButton.addActionListener(controller);
		quitButton.addActionListener(controller);
		
		playButton.setAlignmentX(CENTER_ALIGNMENT);
		highscoresButton.setAlignmentX(CENTER_ALIGNMENT);
		quitButton.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel centerPanel = new JPanel();
		
		
		add(new JPanel());
		add(centerPanel);
		add(new JPanel());
		setBackground(SystemColor.white);
		for (Component c : getComponents()) {
			c.setBackground(SystemColor.white);
		}
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.add(playButton);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
		centerPanel.add(highscoresButton);
		centerPanel.add(Box.createRigidArea(new Dimension(0, 50)));
		centerPanel.add(quitButton);
	}

	private class MainMenuController implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == playButton){
				parent.setView(new SetupView(parent));
			}else if(e.getSource() == highscoresButton){
				parent.setView(new HighscoreView(parent));
			}else if(e.getSource() == quitButton){
				System.exit(0);
			}

		}

	}

}
