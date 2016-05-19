package com.marcelherd.oot.persistence.repository.question;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.marcelherd.oot.persistence.Database;
import com.marcelherd.oot.persistence.DatabaseFactory;
import com.marcelherd.oot.persistence.domain.Question;
import com.marcelherd.oot.persistence.domain.Question.Difficulty;

/**
 * This service class implements methods to look up question domain types in a
 * database using JDBC.
 * 
 * @author Marcel Herd
 */
public class JDBCQuestionService implements QuestionRepository {

	private Database database;

	protected JDBCQuestionService() {
		database = DatabaseFactory.getInstance();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(Question entity) {
		String sql = null;
		
		if (findOne(entity.getId()) != null) { // update
			sql = String.format(
					"UPDATE `questions` SET `question`='%s', `answerA`='%s', `answerB`='%s', `answerC`='%s', `answerD`='%s', `correctAnswer`='%s', `difficulty`='%s' WHERE `id`=%d",
					entity.getQuestion(), entity.getAnswerA(), entity.getAnswerB(), entity.getAnswerC(),
					entity.getAnswerD(), entity.getCorrectAnswer(), entity.getDifficulty().name(), entity.getId());
		} else { // create
			sql = String.format(
					"INSERT INTO `questions` (`question`, `answerA`, `answerB`, `answerC`, `answerD`, `correctAnswer`, `difficulty`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s')",
					entity.getQuestion(), entity.getAnswerA(), entity.getAnswerB(), entity.getAnswerC(),
					entity.getAnswerD(), entity.getCorrectAnswer(), entity.getDifficulty().name());
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
	public Question findOne(Long id) {
		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM questions WHERE id = " + id)) {
			return JDBCQuestionParser.parseOne(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Question> findAll() {
		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM questions")) {
			return JDBCQuestionParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Question> findAll(Iterable<Long> ids) {
		String joined = StreamSupport.stream(ids.spliterator(), false).map(l -> Long.toString(l))
				.collect(Collectors.joining(","));

		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM questions WHERE id IN ( " + joined + ")")) {
			return JDBCQuestionParser.parseAll(resultSet);
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
				ResultSet resultSet = statement.executeQuery("SELECT count(id) AS count FROM questions")) {
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
	public List<Question> findByDifficulty(Difficulty difficulty) {
		try (Connection connection = database.getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement
						.executeQuery("SELECT * FROM questions WHERE difficulty='" + difficulty.name() + "'")) {
			return JDBCQuestionParser.parseAll(resultSet);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}