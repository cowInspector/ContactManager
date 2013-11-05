/**
 * EventHandler class for ManageEventPanel screen
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.AddEventDetails;
import com.contactmanager.ui.MainWindow;
import com.contactmanager.ui.ManageContactPanel;
import com.contactmanager.ui.ManageEventPanel;

/**
 * @author Yogeshwara Krishnan 
 * Event Handler for ManageEventPanel class. Calls
 *         appropriate DB level methods to modify or delete events.
 */
public class ManageEventEventHandler implements ActionListener {

	/**
	 * @param eventID
	 *            Gets the relevant data to populate the fields of
	 *            ManageEventPanel screen on load.
	 */
	public static void getEventDetailsData(String eventID) {
		try {
			populateUI(DBQueryExecute.getEventDetails(eventID));
			ManageEventPanel.textFieldParticipant.setText(DBQueryExecute
					.getEventParticipant(eventID));
			populateContact(System.getProperty("creatorID"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param eventDetails
	 *            Populates the fields of ManageEventPanel screen on load.
	 */
	private static void populateUI(Vector<Object> eventDetails) {
		ManageEventPanel.textFieldEventName
				.setText(eventDetails.get(0) == null ? "" : eventDetails.get(0)
						.toString());
		ManageEventPanel.textAreaEventDescription
				.setText(eventDetails.get(1) == null ? "" : eventDetails.get(1)
						.toString());
		ManageEventPanel.formattedTextFieldStartDate.setText(eventDetails
				.get(2) == null ? "" : eventDetails.get(2).toString());
		ManageEventPanel.formattedTextFieldEndDate
				.setText(eventDetails.get(3) == null ? "" : eventDetails.get(3)
						.toString());
		ManageEventPanel.textFieldStartHrs
				.setText(eventDetails.get(4) == null ? "" : eventDetails.get(4)
						.toString().substring(0, 2));
		ManageEventPanel.textFieldStartMins
				.setText(eventDetails.get(4) == null ? "" : eventDetails.get(4)
						.toString().substring(3, 5));
		ManageEventPanel.textFieldEndHrs
				.setText(eventDetails.get(5) == null ? "" : eventDetails.get(5)
						.toString().substring(0, 2));
		ManageEventPanel.textFieldEndMins
				.setText(eventDetails.get(5) == null ? "" : eventDetails.get(5)
						.toString().substring(3, 5));
		ManageEventPanel.comboBoxEventType
				.setSelectedItem(eventDetails.get(6) == null ? ""
						: eventDetails.get(6).toString());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Delete the event.
		if (e.getSource().toString().contains("Delete")) {
			try {
				if (DBQueryExecute.deleteEvent(System
						.getProperty("currentEventID")) > 0) {
					CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
					cl.show(MainWindow.cards, "Contact");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		// Update the changes made to the event.
		if (e.getSource().toString().contains("Save")) {
			try {
				if (DBQueryExecute.updateEventDetails(System
						.getProperty("currentEventID")) > 0) {
					DBQueryExecute.updateParticipantDetails(System
							.getProperty("participantID"), System
							.getProperty("currentEventID"));
					CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
					cl.show(MainWindow.cards, "Contact");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * @param creatorID
	 *            A contact is associated with a person. This method populates
	 *            the table with all the contacts of the user.
	 */
	public static void populateContact(String creatorID) {
		try {
			ManageEventPanel.tableContact.setModel(DBQueryExecute
					.getAllContactsForUser(creatorID));
			ManageEventPanel.tableContact
					.removeColumn(ManageEventPanel.tableContact
							.getColumnModel().getColumn(0));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
