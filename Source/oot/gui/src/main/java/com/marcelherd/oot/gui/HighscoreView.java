package com.marcelherd.oot.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

import java.awt.FlowLayout;
import java.awt.Font;

/**
 * @author Richard Vladimirskij
 * 
 * HighscoreView - displays a JPanel with the current top ten winners of the WWM game.
 * 
 * */


@SuppressWarnings("serial")
public class HighscoreView extends JPanel {

	private JFrame parent;
	private JPanel contentPanel;
	private JLabel title;
	private JTable table;
	private JButton backButton;

	/**
	 * Create the Panel.
	 */
	public HighscoreView(JFrame parent) {
		this.parent = parent;
		contentPanel = new JPanel();
		
		//Top of the panel for the title
		JPanel panelTop = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panelTop.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		title = new JLabel("Highscores");
		panelTop.add(title);
		contentPanel.add(panelTop, BorderLayout.NORTH);
		
		//Center of the panel for the table
		JPanel panelCenter = new JPanel();
		table = new JTable(new HighscoreController());
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
//		contentPane.add(scrollPane, BorderLayout.EAST);
//		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(table);
		panelCenter.add(scrollPane);
		contentPanel.add(panelCenter, BorderLayout.WEST);
		
		//Bottom of the panel for the return to menu button
		JPanel panelBase = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelBase.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		
		/**Main Menu button actions*/
		backButton = new JButton("Back to main menu");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setView(new MainMenuView());
			}
		});
		panelBase.add(backButton);

		contentPanel.add(panelBase, BorderLayout.SOUTH);
	}

}
