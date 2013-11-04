/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.AddEventDetails;

/**
 * @author hkrishna
 * 
 */
public class AddEventEventHandler implements ActionListener {

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
				if (DBQueryExecute.createEvent() > 0) {
					System.out.println("Success");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
