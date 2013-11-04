/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.ManageContactPanel;

/**
 * @author hkrishna
 * 
 */
public class ManageContactEventHandler implements ActionListener {

	public static Vector<Object> setContactDetails(String contactID) {
		Vector<Object> contactData = new Vector<>();
		try {
			contactData = DBQueryExecute.getContactDetails(contactID);
			populateUIElements(contactData);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactData;
	}

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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().toString().contains("Save")) {
			try {
				if (DBQueryExecute.updateContactDetails(System
						.getProperty("currentContactID")) > 0) {
					System.out.println("Updated");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
