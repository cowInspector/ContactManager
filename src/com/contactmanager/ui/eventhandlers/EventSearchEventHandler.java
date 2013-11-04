/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.EventPanel;

/**
 * @author hkrishna
 *
 */
public class EventSearchEventHandler implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().toString().contains("Search")) {
			try {
				EventPanel.table.setModel(DBQueryExecute.searchEvent());
				EventPanel.table.setVisible(true);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
