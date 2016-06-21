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
		setTitle("Who Wants To Be A Millionaire?");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		setLocationRelativeTo(null);
		add(new MainMenuView(this));
	}
	
	public void setView(JPanel view) {
		getContentPane().removeAll();
		add(view);
		revalidate();
	}

}
