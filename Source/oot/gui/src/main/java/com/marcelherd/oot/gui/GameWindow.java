package com.marcelherd.oot.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Color;

public class GameWindow extends JFrame {
	JPanel view;
	
	

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(10);
		borderLayout.setHgap(10);
		setForeground(Color.WHITE);
		getContentPane().setBackground(new Color(255, 255, 255));
		setBackground(SystemColor.text);
		setTitle("Who Wants To Be A Millionaire?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		HighscoreView hsv = new HighscoreView(this);
		hsv.setBounds(0, 0, 584, 363);
		hsv.setBackground(SystemColor.desktop);
		getContentPane().add(hsv, BorderLayout.CENTER);
	}
	
	public void setView(JPanel view) {
		getContentPane().add(view);
	}

}
