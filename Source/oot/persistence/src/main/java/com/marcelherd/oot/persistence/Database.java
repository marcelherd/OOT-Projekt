package com.marcelherd.oot.persistence;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class Database {

	private static BasicDataSource dataSource;

	static {
		dataSource = new BasicDataSource();
		dataSource.setDriverClassName("org.sqlite.JDBC");
		dataSource.setUrl("jdbc:sqlite::resource:database.sqlite");
	}

	public static Connection getConnection() {
		try {
			dataSource.setUrl("jdbc:sqlite::resource:database.sqlite");
			return dataSource.getConnection();
		} catch (SQLException e) {
			return null;
		}
	}

}
