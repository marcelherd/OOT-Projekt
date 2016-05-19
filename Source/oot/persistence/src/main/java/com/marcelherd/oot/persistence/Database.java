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
	
	private BasicDataSource dataSource;
	
	protected Database(String driverClassName, String url) {
		this(driverClassName, url, null, null);
	}
	
	protected Database(String driverClassName, String url, String username, String password) {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		if (username != null) dataSource.setUsername(username);
		if (password != null) dataSource.setPassword(password);
	}

	/**
	 * Returns the connection to the database.
	 * 
	 * @return the connection to the database
	 * @throws SQLException - if connection could not be established
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
