package com.marcelherd.oot.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * This class provides access to a database connection using JDBC.
 * Connections are stored within a connection pool.
 * 
 * @author Marcel Herd
 */
public class Database {

	private static BasicDataSource dataSource;

	static {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.sqlite.JDBC");
		dataSource.setUrl("jdbc:sqlite::resource:database.sqlite");
	}

	/**
	 * Returns the connection to the database.
	 * 
	 * @return the connection to the database
	 */
	public static Connection getConnection() {
		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}

}
