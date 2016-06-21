package com.marcelherd.oot.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

public class SetupView extends JPanel{
	
	
	private JTextField nameField = new JTextField(20);
	private JButton startButton = new JButton("Start");
	public SetupView(GameWindow parent){
		startButton.setEnabled(false);
		setLayout(new GridBagLayout());
		JPanel panel = new JPanel();
		panel.add(new JLabel("Your name: "));
		panel.add(nameField);
		panel.add(startButton);
		setBackground(SystemColor.white);
		panel.setBackground(SystemColor.white);
		add(panel, new GridBagConstraints());

		nameField.requestFocusInWindow();
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					parent.setView(new PlayView(parent, nameField.getText()));
			}
		});
		
		nameField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
					if(!nameField.getText().equals(""))
						startButton.setEnabled(true);
					else
						startButton.setEnabled(false);
			}
		});
		
	}
	
	
}
