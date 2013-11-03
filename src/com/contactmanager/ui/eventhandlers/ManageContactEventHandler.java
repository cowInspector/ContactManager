/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.sql.SQLException;
import java.util.Vector;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.MainWindow;
import com.contactmanager.ui.ManageContactPanel;

/**
 * @author hkrishna
 *
 */
public class ManageContactEventHandler {
	
	public static Vector<Object> setContactDetails(String contactID) {
		Vector<Object> contactData = new Vector<>();
		try {
			contactData = DBQueryExecute.getContactDetails(contactID);
			/*if (contactData.size() > 0) {
				//MainWindow.manageContactPanel.textFieldPrefix.setText(contactData.get(0).toString());
				System.out.println(contactData.get(0)==null?"":contactData.get(0).toString());
				//MainWindow.manageContactPanel.textFieldFirstName.setText(contactData.get(1).toString());
				System.out.println(contactData.get(1)==null?"":contactData.get(1).toString());
				//MainWindow.manageContactPanel.textFieldMiddleName.setText(contactData.get(2).toString());
				System.out.println(contactData.get(2)==null?"":contactData.get(2).toString());
				//MainWindow.manageContactPanel.textFieldLastName.setText(contactData.get(3).toString());
				System.out.println(contactData.get(3)==null?"":contactData.get(3).toString());
				//MainWindow.manageContactPanel.textFieldSuffix.setText(contactData.get(4).toString());
				System.out.println(contactData.get(4)==null?"":contactData.get(4).toString());
				//MainWindow.manageContactPanel.textFieldNickName.setText(contactData.get(5).toString());
				System.out.println(contactData.get(5)==null?"":contactData.get(5).toString());
				//MainWindow.manageContactPanel.comboBoxRelationship.setSelectedItem(contactData.get(6).toString());
				System.out.println(contactData.get(6)==null?"":contactData.get(6).toString());
				//MainWindow.manageContactPanel.formattedTextFieldFirstMet.setText(contactData.get(7).toString());
				System.out.println(contactData.get(7)==null?"":contactData.get(7).toString());
			}*/
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return contactData;
	}
	
}
