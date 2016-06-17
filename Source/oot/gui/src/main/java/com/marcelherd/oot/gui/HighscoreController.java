package com.marcelherd.oot.gui;

import javax.swing.table.AbstractTableModel;

import java.text.SimpleDateFormat;
import java.util.List;

import com.marcelherd.oot.game.*;
import com.marcelherd.oot.persistence.domain.Highscore;

/**
 * @author Richard Vladimirskij
 * 
 * HighscoreController - controls the output of the highscore table for the WWM game.
 * The controller outputs the current placing of each player, the player by name, their score/win and the date the game was played on
 * within a two-dimensional array. 
 * */

@SuppressWarnings("serial")
public class HighscoreController extends AbstractTableModel {
	private String[] names;
	private String[] dates;
	private String[] scores;
	private String[] colHeadings = {"Place", "Name", "Score", "Date"};
	private int columnCount;
	private int rowCount = 10;
	private String data[][];
	private Highscores highscores = new WWMHighscores();
	private List<Highscore> topTen = highscores.getTopTen();
	
	public HighscoreController() {
		names = getAllNames();
		dates = getAllDates();
		scores = getAllScores();
		columnCount = colHeadings.length;
		data = new String[rowCount][columnCount];
		buildTable();
	}
	

	public String getColumnName(int col) {	
		String name = colHeadings[col];
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
	public String getValueAt(int row, int col) {
		return data[row][col];
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
		String[] dates = new String[10];
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
		for (int i = 0; i < topTen.size(); i++) {
			dates[i] = sdf.format(topTen.get(i).getDate());
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
			scores[i] = formatSum(sum);
		}
		return scores;
	}
	
	/**
	 * @return - a formatted output of a winning sum including decimal point separation for thousands and million as well as a currency symbol at the end
	 * @param sum - an unformatted sum eg. "1000" as a String.
	 * */
	private String formatSum(String sum) {
		String newSum = "";
		
		//Accurately set dividing points by building the sum back-to-front
		for(int i = sum.length()-1, k = 0; i >= 0 && k <= sum.length()-1; i--, k++){
				if(k == 3 || k== 7)
					newSum += ".";
				newSum += sum.charAt(i);
			}
		newSum += " €";
		
		//Reverse the sum to have it facing the right way
		sum = ""; //reset sum
		for(int i = newSum.length()-1; i >= 0; i--)
			sum += newSum.charAt(i);
		
		return sum;
	}
	
	/**
	 * Builds up the the table contents before it is returned as an object
	 * */
	private void buildTable() {
		for(int i = 0; i < rowCount; i++) {
			//Insert positions
			data[i][0] = (i+1) + "";
			//Insert names
			data[i][1] = names[i];
			//Insert scores
			data[i][2] = scores[i];
			//Insert dates
			data[i][3] = dates[i];
		}
	}
	
}
