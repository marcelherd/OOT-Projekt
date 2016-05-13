package com.marcelherd.oot.persistence.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.entity.Question;
import com.marcelherd.oot.persistence.entity.Question.Difficulty;
import com.marcelherd.oot.persistence.entity.QuestionParser;

/**
 * TODO javadoc
 * 
 * @author Marcel Herd
 */
public class QuestionService implements QuestionRepository {

	protected QuestionService() {

	}
	
	@Override
	public Question findOne(Long id) {
		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM questions WHERE id = " + id)) {
			return QuestionParser.parseOne(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Question> findAll() {
		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM questions")) {
			return QuestionParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Question> findAll(Iterable<Long> ids) {
		String joined = StreamSupport.stream(ids.spliterator(), false).map(l -> Long.toString(l))
				.collect(Collectors.joining(","));

		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM questions WHERE id IN ( " + joined + ")")) {
			return QuestionParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Long count() {
		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT count(id) AS count FROM questions")) {
			return resultSet.getLong("count");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Question> findByDifficulty(Difficulty difficulty) {
		try (Connection connection = Database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM questions WHERE difficulty='" + difficulty.name() + "'")) {
			return QuestionParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}