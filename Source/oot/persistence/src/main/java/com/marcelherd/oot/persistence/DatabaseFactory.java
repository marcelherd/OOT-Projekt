package com.marcelherd.oot.persistence;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class is a factory for Databases.
 * 
 * @author Marcel Herd
 */
public class DatabaseFactory {
	
	/**
	 * Offline SQLite database
	 */
	private static Database local;
	
	/**
	 * Remote MariaDB database - requires internet connection
	 */
	private static Database remote;
	
	static {
		local = new Database("org.sqlite.JDBC", "jdbc:sqlite::resource:database.sqlite");
		remote = new Database("org.mariadb.jdbc.Driver", "jdbc:mariadb://shishigami.eu:3306/millionaer", "millionaer", "123qwe123qwe");
	}
	
	/**
	 * Returns true if a connection to the remote database could be established.
	 * 
	 * @return true if a connection to the remote database could be established
	 */
	private static boolean hasInternet() {
		try (Connection connection = remote.getConnection()) {
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	/**
	 * Returns an instance of Database.
	 * 
	 * @return an instance of Database
	 */
	public static Database getInstance() {
		if (hasInternet()) return remote;
		return local;
	}

}
