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
import javax.swing.table.TableModel;

import com.contactmanager.ui.AddEventDetails;
import com.contactmanager.ui.EventPanel;
import com.contactmanager.ui.ManageContactPanel;
import com.contactmanager.ui.ManageEventPanel;

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

	public static boolean getUserName(String userName) {
		boolean result = false;
		Connection conn = DBUtilFactory.getConnection();

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt
					.executeQuery("SELECT * FROM USERS WHERE username = '"
							+ userName + "'");
			if (rs.next()) {
				System.setProperty("creatorID",
						((Integer) rs.getInt(1)).toString());
				result = true;
			} else
				result = false;
			conn.close();
		} catch (SQLException e) {
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
				.executeQuery("SELECT phonedetailsID, phonenumber, phonetype from phonedetails where contactID = "
						+ contactID);
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Phone Details ID");
		columnNames.add("Phone No.");
		columnNames.add("Phone Type");
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			row.add(rs.getString(1));
			row.add(rs.getString(2));
			row.add(rs.getString(3));
			data.add(row);
		}

		conn.close();

		return new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
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
				+ Integer.parseInt(System.getProperty("creatorID")) + ")";

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
					+ "City, State, PostalCode, Country, AddressType) values ("
					+ contactID
					+ ", '"
					+ rowData.get(0)
					+ "', '"
					+ rowData.get(1)
					+ "', '"
					+ rowData.get(2)
					+ "', '"
					+ rowData.get(3)
					+ "', '"
					+ rowData.get(4)
					+ "', '"
					+ rowData.get(5)
					+ "', '"
					+ rowData.get(6)
					+ "', '"
					+ rowData.get(7) + "')";
			result += stmt.executeUpdate(insertAddressDataQuery);
		}

		conn.close();

		return result;
	}

	public static Vector<Object> getContactDetails(String contactID)
			throws SQLException {
		Vector<Object> contactData = new Vector<Object>();

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		String contactQuery = "Select prefix, firstname, middlename, lastname, "
				+ "suffix, nickname, relationship, firstmet from contacts where contactid = "
				+ contactID
				+ " and creatorID = "
				+ System.getProperty("creatorID");

		ResultSet rs = stmt.executeQuery(contactQuery);

		while (rs.next()) {
			for (int count = 1; count <= 8; count++) {
				contactData.add(rs.getString(count));
			}
		}

		conn.close();

		return contactData;
	}

	public static int createNewUser(String userName, String password)
			throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();

		String createUserSQL = "INSERT INTO USERS (UserName, Password) values ('"
				+ userName + "', '" + password + "')";

		int result = stmt.executeUpdate(createUserSQL);

		return result;
	}

	public static Vector<Object> getContactList() throws SQLException {

		Vector<Object> rowData = new Vector<>();

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();

		String getContactsSQL = "SELECT CONTACTID, FirstName, LastName "
				+ "from Contacts where ActiveFlag = '1' and CreatorID = "
				+ System.getProperty("creatorID");

		ResultSet rs = stmt.executeQuery(getContactsSQL);

		while (rs.next()) {
			rowData.add(rs.getString(2) + " " + rs.getString(3));
		}

		return rowData;
	}

	public static int createEvent() throws SQLException {

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();

		String insertEventSQL = "INSERT INTO EVENTS (EventName, EventDescription, EventStartDate,"
				+ " EventEndDate, EventStartTime, EventEndTime, EventType, CreatorID) values('"
				+ AddEventDetails.textFieldEventName.getText()
				+ "', '"
				+ AddEventDetails.textAreaEventDescription.getText()
				+ "', '"
				+ AddEventDetails.formattedTextFieldStartDate.getText()
				+ "', '"
				+ AddEventDetails.formattedTextFieldEndDate.getText()
				+ "', '"
				+ AddEventDetails.textFieldStartHrs.getText()
				+ ":"
				+ AddEventDetails.textFieldStartMins.getText()
				+ "', '"
				+ AddEventDetails.textFieldEndHrs.getText()
				+ ":"
				+ AddEventDetails.textFieldEndMins.getText()
				+ "', '"
				+ AddEventDetails.comboBoxEventType.getSelectedItem()
						.toString()
				+ "', "
				+ System.getProperty("creatorID")
				+ ")";

		int result = stmt.executeUpdate(insertEventSQL);

		return result;

	}

	public static DefaultTableModel searchEvent() throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();

		String searchEventSQL = "SELECT eventID, eventname, eventstartdate, eventstarttime,"
				+ " eventenddate, eventendtime, eventtype from events where creatorid = "
				+ System.getProperty("creatorID")
				+ " and eventname like '%"
				+ EventPanel.textFieldEventName.getText()
				+ "%' and eventstartdate = '"
				+ EventPanel.textFieldEventDate.getText()
				+ "' and eventtype like '%"
				+ EventPanel.comboBoxEventType.getSelectedItem().toString()
				+ "%'";

		ResultSet rs = stmt.executeQuery(searchEventSQL);

		Vector<String> columnNames = new Vector<String>();
		columnNames.add("EventID");
		columnNames.add("Event Name");
		columnNames.add("Event Start Date");
		columnNames.add("Event Start Time");
		columnNames.add("Event End Date");
		columnNames.add("Event End Time");
		columnNames.add("Event Type");

		Vector<Vector<Object>> searchData = new Vector<Vector<Object>>();

		while (rs.next()) {
			Vector<Object> rowData = new Vector<Object>();
			for (int count = 1; count <= 7; count++) {
				rowData.add(rs.getObject(count));
			}
			searchData.add(rowData);
		}

		return new DefaultTableModel(searchData, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
	}

	public static int updateContactDetails(String contactID)
			throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();

		String updateContactSQL = "UPDATE CONTACTS SET PREFIX = '"
				+ ManageContactPanel.textFieldPrefix.getText()
				+ "', FirstName = '"
				+ ManageContactPanel.textFieldFirstName.getText()
				+ "', LastName = '"
				+ ManageContactPanel.textFieldLastName.getText()
				+ "', MiddleName = '"
				+ ManageContactPanel.textFieldMiddleName.getText()
				+ "', Suffix = '"
				+ ManageContactPanel.textFieldSuffix.getText()
				+ "', Nickname = '"
				+ ManageContactPanel.textFieldNickName.getText()
				+ "', Relationship = '"
				+ ManageContactPanel.comboBoxRelationship.getSelectedItem()
						.toString() + "', FirstMet = '"
				+ ManageContactPanel.formattedTextFieldFirstMet.getText()
				+ "' where contactID = " + contactID + " and creatorID = "
				+ System.getProperty("creatorID");

		int result = stmt.executeUpdate(updateContactSQL);

		return result;
	}

	public static DefaultTableModel getAddressDetails(String contactID)
			throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT addressdetailsid, addressline1, addressline2, addressline3, city"
						+ ", state, postalcode, country, addresstype from addressdetails where contactID = "
						+ contactID);
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("Address Details ID");
		columnNames.add("Address Line 1");
		columnNames.add("Address Line 2");
		columnNames.add("Address Line 3");
		columnNames.add("City");
		columnNames.add("State");
		columnNames.add("Postal Code");
		columnNames.add("Country");
		columnNames.add("Address Type");

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			for (int count = 1; count <= 9; count++) {
				row.add(rs.getObject(count));
			}
			data.add(row);
		}

		conn.close();

		return new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
	}

	public static TableModel getEmailDetails(String contactID)
			throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt
				.executeQuery("SELECT emaildetailsID, emailID, emailtype from emaildetails where contactID = "
						+ contactID);
		Vector<String> columnNames = new Vector<String>();
		columnNames.add("EmailDetailsID");
		columnNames.add("EmailID");
		columnNames.add("EmailType");

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		while (rs.next()) {
			Vector<Object> row = new Vector<Object>();
			for (int count = 1; count <= 3; count++) {
				row.add(rs.getObject(count));
			}
			data.add(row);
		}

		conn.close();

		return new DefaultTableModel(data, columnNames) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return true;
			}
		};
	}

	public static int deleteEvent(String eventID) throws SQLException {

		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();

		String deleteEventSQL = "DELETE FROM EVENTS where creatorID = "
				+ System.getProperty("creatorID") + " and eventID = " + eventID;

		int result = stmt.executeUpdate(deleteEventSQL);

		conn.close();

		return result;

	}

	public static Vector<Object> getEventDetails(String eventID)
			throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();
		Vector<Object> rowData = new Vector<Object>();

		String eventDetailsSQL = "select EventName, EventDescription, EventStartDate,"
				+ " EventEndDate, EventStartTime, EventEndTime, EventType from events where eventID = "
				+ eventID;

		ResultSet rs = stmt.executeQuery(eventDetailsSQL);

		while (rs.next()) {
			for (int count = 1; count <= 7; count++) {
				rowData.add(rs.getObject(count));
			}
		}

		return rowData;
	}

	public static int updateEventDetails(String eventID) throws SQLException {
		Connection conn = DBUtilFactory.getConnection();
		Statement stmt = conn.createStatement();

		String updatedEventSQL = "update events set eventname = '"
				+ ManageEventPanel.textFieldEventName.getText()
				+ "', eventdescription = '"
				+ ManageEventPanel.textAreaEventDescription.getText()
				+ "', eventstartdate = '"
				+ ManageEventPanel.formattedTextFieldStartDate.getText()
				+ "', eventenddate = '"
				+ ManageEventPanel.formattedTextFieldEndDate.getText()
				+ "', eventstarttime = '"
				+ ManageEventPanel.textFieldStartHrs.getText()
				+ ":"
				+ ManageEventPanel.textFieldStartMins.getText()
				+ "', eventendtime = '"
				+ ManageEventPanel.textFieldEndHrs.getText()
				+ ":"
				+ ManageEventPanel.textFieldEndMins.getText()
				+ "', eventtype = '"
				+ ManageEventPanel.comboBoxEventType.getSelectedItem()
						.toString() + "' where eventID = " + eventID
				+ " and creatorID = " + System.getProperty("creatorID");
		
		int result = stmt.executeUpdate(updatedEventSQL);
		
		conn.close();
		
		return result;
	}
}
