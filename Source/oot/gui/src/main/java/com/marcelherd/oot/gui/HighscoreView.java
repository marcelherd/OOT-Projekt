package com.marcelherd.oot.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.SystemColor;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;

/**
 * @author Richard Vladimirskij
 * 
 * HighscoreView - displays a JPanel with the current top ten winners of the WWM game.
 * 
 * */


@SuppressWarnings("serial")
public class HighscoreView extends JPanel {

	@SuppressWarnings("unused")
	private JFrame parent;
	private JLabel title;
	private JTable table;
	private JButton backButton;
	private JPanel centerPanel;
	private JPanel topPanel;
	private JPanel basePanel;
	private JPanel tablePanel;

	/**
	 * Create the Panel.
	 */
	public HighscoreView(GameWindow parent) {
		this.parent = parent;
		setSize(parent.getSize());
		setLayout(new BorderLayout(0, 0));
		
		topPanel = new JPanel();
		topPanel.setBackground(new Color(255, 255, 255));
		add(topPanel, BorderLayout.NORTH);
		title = new JLabel("Highscores");
		topPanel.add(title);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		centerPanel = new JPanel();
		centerPanel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) centerPanel.getLayout();
		flowLayout_1.setAlignOnBaseline(true);
		flowLayout_1.setVgap(10);
		flowLayout_1.setHgap(10);
		add(centerPanel, BorderLayout.CENTER);
		
		tablePanel = new JPanel();
		tablePanel.setBackground(SystemColor.white);
		FlowLayout flowLayout_3 = (FlowLayout) tablePanel.getLayout();
		flowLayout_3.setAlignOnBaseline(true);
		centerPanel.add(tablePanel);
		table = new JTable(new HighscoreController());
		table.setRowSelectionAllowed(false);
		table.setShowVerticalLines(false);
		table.setBorder(null);
		
		JScrollPane scrollPane = new JScrollPane();
		tablePanel.add(scrollPane);
		scrollPane.setEnabled(false);
		scrollPane.setPreferredSize(new Dimension(400, 183));
		scrollPane.setViewportView(table);
		
		basePanel = new JPanel();
		basePanel.setBackground(new Color(255, 255, 255));
		add(basePanel, BorderLayout.SOUTH);
		backButton = new JButton("Main menu");
		basePanel.add(backButton);
		backButton.setBackground(UIManager.getColor("Button.darkShadow"));
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parent.setView(new MainMenuView(parent));
			}
		});
	}
}
