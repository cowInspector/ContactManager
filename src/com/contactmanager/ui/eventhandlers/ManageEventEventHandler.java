/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.MainWindow;
import com.contactmanager.ui.ManageEventPanel;

/**
 * @author hkrishna
 * 
 */
public class ManageEventEventHandler implements ActionListener {

	public static void getEventDetailsData(String eventID) {
		try {
			populateUI(DBQueryExecute.getEventDetails(eventID));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
		if (e.getSource().toString().contains("Delete")) {
			try {
				if (DBQueryExecute.deleteEvent(System
						.getProperty("currentEventID")) > 0) {
					System.out.println("Deleted");
					CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
					cl.show(MainWindow.cards, "Contact");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

		if (e.getSource().toString().contains("Save")) {
			try {
				if (DBQueryExecute.updateEventDetails(System
							.getProperty("currentEventID")) > 0) {
					System.out.println("Updated");
					CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
					cl.show(MainWindow.cards, "Contact");
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
