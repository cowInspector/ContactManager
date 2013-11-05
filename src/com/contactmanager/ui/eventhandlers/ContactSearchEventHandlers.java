package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.ContactSearchPanel;

/**
 * @author Yogeshwara Krishnan
 * 
 * Event Handler class for ContactSearchPanel class.
 * Calls required DB level function to retrieve the search results.
 * 
 */
public class ContactSearchEventHandlers implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {

		try {
			ContactSearchPanel.table.setModel(
					DBQueryExecute.getContactSearchResults(
							ContactSearchPanel.textFieldFirstName.getText(),
							ContactSearchPanel.textFieldLastName.getText(),
							ContactSearchPanel.textFieldPhoneNumber.getText()));
			ContactSearchPanel.table.removeColumn(ContactSearchPanel.table.getColumnModel().getColumn(0));
			ContactSearchPanel.table.setVisible(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
