/**
 * 
 */
package com.contactmanager.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author hkrishna
 * 
 */
public class DBUtilFactory {
	static Connection conn = null;
	
	public static Connection getConnection() {
		try {
			conn = DriverManager.getConnection(getConnectionURL());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private static String getConnectionURL() {
		return "jdbc:mysql://localhost/contactmanager?user=root&password=lakers";
	}
}
