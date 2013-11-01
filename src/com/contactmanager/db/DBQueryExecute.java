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

	public static DefaultTableModel getFrequentContacts() throws SQLException {

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM frequentcontacts;");

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("ContactID");
		columnNames.add("Name");

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getInt(1));
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

	public static DefaultTableModel getContactSearchResults(String firstName,
			String lastName, String phoneNumber) throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT contactID, CONCAT_WS(' ', firstname, lastname) as name from contacts where CreatorID = "
						+ System.getProperty("creatorID")
						+ " and (contactID in (SELECT distinct contactID from phonedetails where phonenumber like '%"
						+ phoneNumber
						+ "%') and (firstname like '%"
						+ firstName
						+ "%' and lastname like '%"
						+ lastName
						+ "%'))");

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("ContactID");
		columnNames.add("Name");

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getInt(1));
			vector.add(rs.getObject(2).toString());
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

	public static DefaultTableModel getPhoneDetails(String contactID)
			throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT phonenumber, phonetype from phonedetails where contactID = "
						+ contactID);
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Phone No.");
		columnNames.add("Phone Type");
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			data.add(row);
		}

		conn.close();

		return new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

	}

	public static int addNewContact(Vector<String> contactVector)
			throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		String insertContactQuery = "INSERT INTO CONTACTS (Prefix, FirstName, MiddleName, LastName, Suffix"
				+ ", Nickname, Relationship, FirstMet, ActiveFlag, FrequencyCounter, CreatorID) values ('"
				+ contactVector.get(0)
				+ "', '"
				+ contactVector.get(1)
				+ "', '"
				+ contactVector.get(2)
				+ "', '"
				+ contactVector.get(3)
				+ "', '"
				+ contactVector.get(4)
				+ "', '"
				+ contactVector.get(5)
				+ "', '"
				+ contactVector.get(6)
				+ "', '"
				+ contactVector.get(7)
				+ "', '1', 1, "
				+ Integer.parseInt(System.getProperty("creatorID"))
				+ ")";

		int result = stmt.executeUpdate(insertContactQuery);

		conn.close();

		return result;
	}

	public static int addPhoneDetails(Vector<Vector<String>> phoneDetailsVector)
			throws SQLException {

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		int contactID = 0;
		int result = 0;

		String getLatestContactQuery = "SELECT MAX(CONTACTID) FROM CONTACTS WHERE CREATORID = "
				+ Integer.parseInt(System.getProperty("creatorID"));

		ResultSet rs = stmt.executeQuery(getLatestContactQuery);

		if (rs.next()) {
			contactID = rs.getInt(1);
		}

		for (int count = 0; count < phoneDetailsVector.size(); count++) {
			Vector<String> rowData = phoneDetailsVector.get(count);
			String insertPhoneDetailsQuery = "INSERT INTO PHONEDETAILS (ContactID, PhoneNumber,  Extension, PhoneType) values (";
			insertPhoneDetailsQuery += contactID + ", '" + rowData.get(0)
					+ "', '" + rowData.get(1) + "', '" + rowData.get(2) + "');";
			result += stmt.executeUpdate(insertPhoneDetailsQuery);
		}

		conn.close();

		return result;
	}

	public static int addEmailDetails(Vector<Vector<String>> emailDetailsVector)
			throws SQLException {

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		int contactID = 0;
		int result = 0;

		String getLatestContactQuery = "SELECT MAX(CONTACTID) FROM CONTACTS WHERE CREATORID = "
				+ Integer.parseInt(System.getProperty("creatorID"));

		ResultSet rs = stmt.executeQuery(getLatestContactQuery);

		if (rs.next()) {
			contactID = rs.getInt(1);
		}

		for (int count = 0; count < emailDetailsVector.size(); count++) {
			Vector<String> rowData = emailDetailsVector.get(count);
			String insertEmailDetailsQuery = "INSERT INTO EMAILDETAILS (ContactID, EMailID, EmailType) values (";
			insertEmailDetailsQuery += contactID + ", '" + rowData.get(0)
					+ "', '" + rowData.get(1) + "');";
			result += stmt.executeUpdate(insertEmailDetailsQuery);
		}

		conn.close();

		return result;
	}

	public static int addAddressDetails(
			Vector<Vector<String>> addressDetailsVector) throws SQLException {

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		int contactID = 0;
		int result = 0;

		String getLatestContactQuery = "SELECT MAX(CONTACTID) FROM CONTACTS WHERE CREATORID = "
				+ Integer.parseInt(System.getProperty("creatorID"));

		ResultSet rs = stmt.executeQuery(getLatestContactQuery);

		if (rs.next()) {
			contactID = rs.getInt(1);
		}

		for (int count = 0; count < addressDetailsVector.size(); count++) {
			Vector<String> rowData = addressDetailsVector.get(count);
			String insertAddressDataQuery = "INSERT INTO ADDRESSDETAILS (CONTACTID, AddressLine1, AddressLine2, AddressLine3, "
					+ "City, State, PostalCode, Country, AddressType) values (" + contactID + ", '"
					+ rowData.get(0) + "', '"
					+ rowData.get(1) + "', '"
					+ rowData.get(2) + "', '"
					+ rowData.get(3) + "', '"
					+ rowData.get(4) + "', '"
					+ rowData.get(5) + "', '"
					+ rowData.get(6) + "', '"
					+ rowData.get(7) + "')";
			result += stmt.executeUpdate(insertAddressDataQuery);
		}

		conn.close();
		
		return result;
	}
}
