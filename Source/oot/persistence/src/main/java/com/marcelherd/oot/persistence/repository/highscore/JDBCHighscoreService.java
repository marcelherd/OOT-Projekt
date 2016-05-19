package com.marcelherd.oot.persistence.repository.highscore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.DatabaseFactory;
import com.marcelherd.oot.persistence.domain.Highscore;

public class JDBCHighscoreService implements HighscoreRepository {

	private Database database;

	protected JDBCHighscoreService() {
		database = DatabaseFactory.getInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Highscore entity) {
		String sql = null;

		if (findOne(entity.getId()) != null) { // update
			sql = String.format("UPDATE `highscores` SET `name`='%s', `date`='%t', `sum`='%d' WHERE `id`=%d",
					entity.getName(), entity.getDate(), entity.getSum(), entity.getId());
		} else { // create
			sql = String.format("INSERT INTO `highscores` (`name`, `date`, `sum`) VALUES ('%s', '%t', '%d')",
					entity.getName(), entity.getDate(), entity.getSum(), entity.getId());
		}

		try (Connection connection = database.getConnection(); Statement statement = connection.createStatement()) {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Highscore findOne(Long id) {
		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM highscores WHERE id = " + id)) {
			return JDBCHighscoreParser.parseOne(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Highscore> findAll() {
		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM highscores")) {
			return JDBCHighscoreParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Highscore> findAll(Iterable<Long> ids) {
		String joined = StreamSupport.stream(ids.spliterator(), false).map(l -> Long.toString(l))
				.collect(Collectors.joining(","));

		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM highscores WHERE id IN ( " + joined + ")")) {
			return JDBCHighscoreParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Long count() {
		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT count(id) AS count FROM highscores")) {
			return resultSet.getLong("count");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Highscore> findTopTen() {
		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM highscores ORDER BY sum DESC LIMIT 10")) {
			return JDBCHighscoreParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}
