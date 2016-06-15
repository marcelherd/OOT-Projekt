package com.marcelherd.oot.gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;

public class HighscoreView extends JFrame {

	private JPanel contentPane;
	private JLabel title;
	private JTable scores;
	private JButton btnExitGame;
	private JButton btnMainMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HighscoreView frame = new HighscoreView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HighscoreView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelTop = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTop.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		title = new JLabel("Highscores");
		panelTop.add(title);
		contentPane.add(panelTop, BorderLayout.NORTH);
		
		JPanel panelCenter = new JPanel();
		scores = new JTable(new ScoreBoard());
		
		panelCenter.add(scores);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		
		JPanel panelBase = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBase.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		/**Main Menu button actions*/
		btnMainMenu = new JButton("Main Menu");
		btnMainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Main Menu Clicked");
			}
		});
		panelBase.add(btnMainMenu);
		
		/**Exit Game button actions*/
		btnExitGame = new JButton("Exit Game");
		btnExitGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit Game Clicked");
			}
		});
		
		
		panelBase.add(btnExitGame);
		contentPane.add(panelBase, BorderLayout.SOUTH);
		
	}

}
