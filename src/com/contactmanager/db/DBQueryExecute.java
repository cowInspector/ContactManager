/**
 * 
 */
package com.contactmanager.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

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
				System.setProperty("creatorID",
						((Integer) rs.getInt(1)).toString());
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

	public static DefaultTableModel getFrequentContacts()
			throws SQLException {

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM frequentcontacts;");

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Name");

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getObject(2).toString() + " "
					+ rs.getObject(3).toString());
			data.add(vector);
		}

		conn.close();

		return new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

}
