package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ComboBoxModel;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.AddEventDetails;

/**
 * @author Yogeshwara Krishnan
 * 
 *         Event Handler class for AddEventDetails class.
 * 
 */
public class AddEventEventHandler implements ActionListener {

	/**
	 * @param creatorID
	 *            A contact is associated with a person. This method populates
	 *            the table with all the contacts of the user.
	 */
	public static void populateContact(String creatorID) {
		try {
			AddEventDetails.tableContacts.setModel(DBQueryExecute
					.getAllContactsForUser(creatorID));
			AddEventDetails.tableContacts
					.removeColumn(AddEventDetails.tableContacts
							.getColumnModel().getColumn(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource().toString().contains("Save")) {
			try {
				if (DBQueryExecute.createNewEvent() > 0) {
					System.out.println("Success adding event");
					System.out.println(DBQueryExecute
							.addIndividualEventParticipant(System
									.getProperty("participantID")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
