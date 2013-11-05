/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.ContactSearchPanel;
import com.contactmanager.ui.MainWindow;
import com.contactmanager.ui.ManageContactPanel;

/**
 * @author Yogeshwara Krishnan
 * 
 *         Event Handler class for ManageContactPanel class. Calls appropriate
 *         functions to modify and delete contact details.
 * 
 */
public class ManageContactEventHandler implements ActionListener {

	/**
	 * @param contactID
	 * @return Gets the contact details which will be used to populate the UI
	 *         elements in ManageContactPanel.
	 */
	public static Vector<Object> setContactDetails(String contactID) {
		Vector<Object> contactData = new Vector<>();
		try {
			// Get the contact details.
			contactData = DBQueryExecute.getContactDetails(contactID);
			populateUIElements(contactData);
			setPhoneDetails(contactID);
			setAddressDetails(contactID);
			setEmailDetails(contactID);
			ManageContactPanel.lblStatusMessage.setVisible(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactData;
	}

	/**
	 * @param contactID
	 *            Get the phone details of the selected contact. Show it as a
	 *            table.
	 */
	private static void setEmailDetails(String contactID) {
		try {
			ManageContactPanel.tableEmailDetails.setModel(DBQueryExecute
					.getEmailDetails(contactID));
			ManageContactPanel.tableEmailDetails
					.removeColumn(ManageContactPanel.tableEmailDetails
							.getColumnModel().getColumn(0));
		} catch (Exception se) {
			se.printStackTrace();
		}
	}

	/**
	 * @param contactID
	 *            Get the address details of the selected contact. Show it as a
	 *            table.
	 */
	private static void setAddressDetails(String contactID) {
		try {
			ManageContactPanel.tableAddrDetails.setModel(DBQueryExecute
					.getAddressDetails(contactID));
			ManageContactPanel.tableAddrDetails
					.removeColumn(ManageContactPanel.tableAddrDetails
							.getColumnModel().getColumn(0));
		} catch (SQLException se) {
			se.printStackTrace();
		}
	}

	/**
	 * @param contactID
	 *            Get the phone details of the selected contact. Show it as a
	 *            table.
	 */
	private static void setPhoneDetails(String contactID) {
		try {
			ManageContactPanel.tablePhoneDetails.setModel(DBQueryExecute
					.getPhoneDetails(contactID));
			ManageContactPanel.tablePhoneDetails
					.removeColumn(ManageContactPanel.tablePhoneDetails
							.getColumnModel().getColumn(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param contactData
	 *            Populate the contact details from the vector which was built
	 *            earlier.
	 */
	public static void populateUIElements(Vector<Object> contactData) {
		ManageContactPanel.textFieldPrefix
				.setText(contactData.get(0) == null ? "" : contactData.get(0)
						.toString());
		ManageContactPanel.textFieldFirstName
				.setText(contactData.get(1) == null ? "" : contactData.get(1)
						.toString());
		ManageContactPanel.textFieldMiddleName
				.setText(contactData.get(2) == null ? "" : contactData.get(2)
						.toString());
		ManageContactPanel.textFieldLastName
				.setText(contactData.get(3) == null ? "" : contactData.get(3)
						.toString());
		ManageContactPanel.textFieldSuffix
				.setText(contactData.get(4) == null ? "" : contactData.get(4)
						.toString());
		ManageContactPanel.textFieldNickName
				.setText(contactData.get(5) == null ? "" : contactData.get(5)
						.toString());
		ManageContactPanel.comboBoxRelationship.setSelectedItem(contactData
				.get(6) == null ? "SPOUSE" : contactData.get(6).toString());
		ManageContactPanel.formattedTextFieldFirstMet.setText(contactData
				.get(7) == null ? "" : contactData.get(7).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Save any modifcations to the contact to DB.
		if (e.getSource().toString().contains("Save")) {
			try {
				if (DBQueryExecute.updateContactDetails(System
						.getProperty("currentContactID")) > 0) {
					System.out.println("Updated");
					ManageContactPanel.lblStatusMessage.setVisible(true);
					ManageContactPanel.lblStatusMessage
							.setText("Contact Updated");
					renderAddrModel();
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Delete the contact. Since ON DELETE CASCADE has been set, respective
		// phone, email, address, event details are deleted.
		if (e.getSource().toString().contains("Delete")) {
			try {
				if (DBQueryExecute.deleteContact(System
						.getProperty("currentContactID")) > 0) {
					CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
					cl.show(MainWindow.cards, "Contact");
					ContactSearchPanel.lblStatusMessage.setVisible(true);
					ContactSearchPanel.lblStatusMessage
							.setText("Contact Deleted");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * This function determines which rows in the address table must be updated or added.
	 */
	public static void renderAddrModel() {
		DefaultTableModel model = (DefaultTableModel) ManageContactPanel.tableAddrDetails
				.getModel();
		Vector<Vector<Object>> data = model.getDataVector();

		for (int i = 0; i < data.size(); i++) {
			Vector<Object> row = data.elementAt(i);
			if (row.elementAt(0).toString().length() == 0)
				try {
					DBQueryExecute.addNewAddressDetails(row);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}

}
