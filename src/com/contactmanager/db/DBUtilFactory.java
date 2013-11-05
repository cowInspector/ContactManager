/**
 * This is a factory class used to instantiate connections to the DB.
 * Do not modify the connection URLs unless required.
 */
package com.contactmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Yogeshwara Krishnan
 * 
 */
public class DBUtilFactory {
	static Connection conn = null;
	
	/**
	 * @return connection object.
	 */
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(getConnectionURL());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * @return connection url for the DB.
	 */
	private static String getConnectionURL() {
		return "jdbc:mysql://localhost/contactmanager?user=root&password=lakers";
	}
}
