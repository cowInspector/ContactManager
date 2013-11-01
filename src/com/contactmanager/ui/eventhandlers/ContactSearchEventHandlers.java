/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.ContactSearchPanel;

/**
 * @author hkrishna
 * 
 */
public class ContactSearchEventHandlers implements ActionListener {

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
