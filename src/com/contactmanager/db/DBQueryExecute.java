/**
 * 
 */
package com.contactmanager.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author hkrishna
 * 
 */
public class DBQueryExecute {

	public static boolean checkUserName(String userName, String password) {
		boolean result = false;
		Connection conn = DBUtilFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM USERS WHERE username = '"
							+ userName + "' and password = '" + password + "'");
			if (rs.next()) {
				System.setProperty("creatorID", ((Integer)rs.getInt(1)).toString());
				result = true;
			} else
				result = false;
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

}
