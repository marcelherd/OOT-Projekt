package com.marcelherd.oot.gui;




import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
	
	
	private JTextField nameField = new JTextField(15);
	private JButton startButton = new JButton("Start");
	public SetupView(GameWindow parent){
		warning.setForeground(SystemColor.RED);
		warning.setVisible(false);
		startButton.setEnabled(false);
		setLayout(new GridBagLayout());
		
		JPanel fieldPanel = new JPanel();
		fieldPanel.add(new JLabel("Your name: "));
		fieldPanel.add(nameField);
		
		JPanel panel = new JPanel(new GridLayout(2,2,10,10));
		panel.add(fieldPanel);
		panel.add(startButton);
		panel.add(warning);
		
		add(panel, new GridBagConstraints());
		
		panel.setBackground(SystemColor.white);
		setBackground(SystemColor.white);
		fieldPanel.setBackground(SystemColor.white);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					parent.setView(new PlayView(parent, nameField.getText()));
			}
		});
		
		nameField.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				
						warning.setVisible(true);
						startButton.setEnabled(false);
					}else if(!nameField.getText().equals("")){
						warning.setVisible(false);
						startButton.setEnabled(true);
					} else{
						startButton.setEnabled(false);
					}
			}
		});
		
	}
	
	
}
