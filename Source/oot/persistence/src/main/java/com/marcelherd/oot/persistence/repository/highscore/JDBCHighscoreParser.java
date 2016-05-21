package com.marcelherd.oot.persistence.repository.highscore;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.marcelherd.oot.persistence.domain.Highscore;

/**
 * This class provides helper methods to create Highscore objects
 * from the ResultSet obtained by the database.
 * 
 * @author Marcel Herd
 */
public class JDBCHighscoreParser {
	
	/**
	 * Returns the Highscore obtained by the resultSet.
	 * 
	 * @param resultSet - query result from the database
	 * @return the Highscore obtained the the resultSet
	 */
	public static Highscore parseOne(ResultSet resultSet) {
		try {
			Long id = resultSet.getLong("id");
			String name = resultSet.getString("name");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = dateFormat.parse(resultSet.getString("date"));
			int sum = resultSet.getInt("sum");
			return new Highscore(id, name, date, sum);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Returns all Highscores obtained by the resultSet.
	 * 
	 * @param resultSet - query result from the database
	 * @return all Highscores obtained by the resultSet
	 */
	public static List<Highscore> parseAll(ResultSet resultSet) {
		try {
			List<Highscore> highscores = new ArrayList<Highscore>();
			while (resultSet.next()) {
				highscores.add(parseOne(resultSet));
			}
			return highscores;
		} catch (SQLException e) {
			return null;
		}
	}

}
