package com.marcelherd.oot.gui;

import javax.swing.table.AbstractTableModel;
import java.util.List;

import com.marcelherd.oot.game.*;
import com.marcelherd.oot.persistence.domain.Highscore;

public class ScoreBoard extends AbstractTableModel {
	private String[] names;
	private String[] dates;
	private String[] scores;
	private int columnCount = 4;
	private int rowCount = 11;
	private String data[][] = new String[columnCount][rowCount];
	private Highscores highscores = new WWMHighscores();
	private List<Highscore> topTen = highscores.getTopTen();
	
	public ScoreBoard() {
		names = getAllNames();
		dates = getAllDates();
		scores = getAllScores();
	}
	

	public String getColumnName(int col) {	
		String name = data[col][0];
		return name;
	}	
	
	@Override
	public int getColumnCount() {
		return columnCount;
	}

	@Override
	public int getRowCount() {
		return rowCount;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return null;
	}
	
	/**@return - always false, as the scoreboard's cells can only be populated and not changed*/
	public boolean isCellEditable(int row, int col) {
		return false;
	}
	
	
	/**
	 * @return an ordered set of the top ten winner's names as an array of Strings.
	 * */
	private String[] getAllNames() {
		Highscore h;
		String[] names = new String[10];
		for(int i = 0; i < 10; i++) {
			h = topTen.get(i);
			names[i] = h.getName();
		}
		return names;
	}
	
	/**
	 * @return an ordered set of the top ten winning dates as an array of Strings.
	 * */
	private String[] getAllDates() {
		Highscore h;
		String[] dates = new String[10];
		for(int i = 0; i < 10; i++) {
			h = topTen.get(i);
			dates[i] = h.getDate() + "";
		}
		return dates;
	}
	
	/**
	 * @return an ordered set of the top ten winner's names as an array of Strings.
	 * */
	private String[] getAllScores() {
		Highscore h;
		String[] scores = new String[10];
		String sum = "";
		for(int i = 0; i < 10; i++) {
			h = topTen.get(i);
			sum = h.getSum() + "";
			scores[i] = getSumDisplay(sum);
		}
		return scores;
	}
	
	/**
	 * @return - a formatted output of a winning sum including decimal point separation for thousands and million as well as a currency symbol at the end
	 * @param sum - an unformatted sum eg. "1000" as a String.
	 * */
	private String getSumDisplay(String sum) {
		if(sum.length() >= 4) {
			String newSum = "";
			for(int i = sum.length()-1, k = 0; i >= 0 && k <= sum.length()-1; i--, k++){
				if(k == 3 || k== 7)
					newSum += ".";
				newSum += sum.charAt(i);
			}
			sum = newSum;
		}
		sum += " €";
		return sum;
	}
	
}
