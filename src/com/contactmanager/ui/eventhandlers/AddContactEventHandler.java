package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.AddContactPanel;

/**
 * @author Yogeshwara Krishnan This class has function which handles events from
 *         AddContactPanel class.
 */
/**
 * @author hkrishna
 *
 */
public class AddContactEventHandler implements ActionListener {

	// The user has an option to add multiple phone nos, address, emails at
	// once. These vectors are used to store the respective data temporarily
	// until they are committed to the DB.
	static Vector<Vector<String>> phoneNumberData = new Vector<Vector<String>>();
	static Vector<Vector<String>> addressDetailsData = new Vector<Vector<String>>();
	static Vector<Vector<String>> emailDetailsData = new Vector<Vector<String>>();
	static Vector<String> contactDetailsData = new Vector<String>();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().toString().contains("Phone Number")) {
			buildPhoneNumberVector();
		}

		if (e.getSource().toString().contains("Address")) {
			buildAddressDetailVector();
		}

		if (e.getSource().toString().contains("Email")) {
			buildEmailDetailVector();
		}

		if (e.getSource().toString().contains("Clear All")) {
			clearAddContactPanelFields();
		}

		if (e.getSource().toString().contains("Save All")) {
			bundleContactData();
			buildAddressDetailVector();
			buildEmailDetailVector();
			buildPhoneNumberVector();
			try {
				if (DBQueryExecute.addNewContact(contactDetailsData) != 0) {
					DBQueryExecute.addPhoneDetails(phoneNumberData);
					DBQueryExecute.addAddressDetails(addressDetailsData);
					DBQueryExecute.addEmailDetails(emailDetailsData);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

	/**
	 * Bundles the user entered contact data from the screen into a Vector.
	 */
	private void bundleContactData() {
		contactDetailsData.add(AddContactPanel.textFieldPrefix.getText());
		contactDetailsData.add(AddContactPanel.textFieldFirstName.getText());
		contactDetailsData.add(AddContactPanel.textFieldMidName.getText());
		contactDetailsData.add(AddContactPanel.textFieldLastName.getText());
		contactDetailsData.add(AddContactPanel.textFieldSuffix.getText());
		contactDetailsData.add(AddContactPanel.textFieldNickame.getText());
		contactDetailsData.add(AddContactPanel.comboBoxRelationship
				.getSelectedItem().toString());
		contactDetailsData.add(AddContactPanel.formattedTextFieldDateMet
				.getText());
	}

	/**
	 * Clear the form.
	 */
	private void clearAddContactPanelFields() {

		phoneNumberData.removeAllElements();
		addressDetailsData.removeAllElements();
		emailDetailsData.removeAllElements();

		AddContactPanel.textFieldAddrLine1.setText("");
		AddContactPanel.textFieldAddrLine2.setText("");
		AddContactPanel.textFieldAddrLine3.setText("");
		AddContactPanel.textFieldCity.setText("");
		AddContactPanel.textFieldState.setText("");
		AddContactPanel.textFieldPostalCode.setText("");
		AddContactPanel.textFieldCountry.setText("");
		AddContactPanel.comboBoxAddrType.setSelectedIndex(0);

		AddContactPanel.textFieldEmailID.setText("");
		AddContactPanel.comboBoxEmailType.setSelectedIndex(0);

		AddContactPanel.textFieldPhNo.setText("");
		AddContactPanel.textFieldExtension.setText("");
		AddContactPanel.comboBoxPhType.setSelectedIndex(0);

		AddContactPanel.textFieldPrefix.setText("");
		AddContactPanel.textFieldFirstName.setText("");
		AddContactPanel.textFieldMidName.setText("");
		AddContactPanel.textFieldLastName.setText("");
		AddContactPanel.textFieldSuffix.setText("");
		AddContactPanel.textFieldNickame.setText("");
		AddContactPanel.comboBoxRelationship.setSelectedIndex(0);
		AddContactPanel.formattedTextFieldDateMet.setText("");
	}

	/**
	 * Users have an option to add multiple email ids at one go. This method
	 * builds a vector and stores all the email ids of the contact to be
	 * created.
	 */
	private void buildEmailDetailVector() {
		Vector<String> emailRowData = new Vector<String>();
		emailRowData.add(AddContactPanel.textFieldEmailID.getText());
		emailRowData.add(AddContactPanel.comboBoxEmailType.getSelectedItem()
				.toString());
		emailDetailsData.add(emailRowData);

		AddContactPanel.textFieldEmailID.setText("");
		AddContactPanel.comboBoxEmailType.setSelectedIndex(0);
	}

	
	/**
	 * Users have an option to add multiple addresses at one go. This method
	 * builds a vector and stores all the addresses of the contact to be
	 * created.
	 */
	private void buildAddressDetailVector() {
		Vector<String> addrRowData = new Vector<String>();
		addrRowData.add(AddContactPanel.textFieldAddrLine1.getText());
		addrRowData.add(AddContactPanel.textFieldAddrLine2.getText());
		addrRowData.add(AddContactPanel.textFieldAddrLine3.getText());
		addrRowData.add(AddContactPanel.textFieldCity.getText());
		addrRowData.add(AddContactPanel.textFieldState.getText());
		addrRowData.add(AddContactPanel.textFieldPostalCode.getText());
		addrRowData.add(AddContactPanel.textFieldCountry.getText());
		addrRowData.add(AddContactPanel.comboBoxAddrType.getSelectedItem()
				.toString());
		addressDetailsData.add(addrRowData);

		AddContactPanel.textFieldAddrLine1.setText("");
		AddContactPanel.textFieldAddrLine2.setText("");
		AddContactPanel.textFieldAddrLine3.setText("");
		AddContactPanel.textFieldCity.setText("");
		AddContactPanel.textFieldState.setText("");
		AddContactPanel.textFieldPostalCode.setText("");
		AddContactPanel.textFieldCountry.setText("");
		AddContactPanel.comboBoxAddrType.setSelectedIndex(0);
	}

	/**
	 * Users have an option to add multiple phone nos. at one go. This method
	 * builds a vector and stores all the phone nos. of the contact to be
	 * created.
	 */
	private void buildPhoneNumberVector() {
		Vector<String> phoneDetailsData = new Vector<String>();
		phoneDetailsData.add(AddContactPanel.textFieldPhNo.getText());
		phoneDetailsData.add(AddContactPanel.textFieldExtension.getText());
		phoneDetailsData.add(AddContactPanel.comboBoxPhType.getSelectedItem()
				.toString());
		phoneNumberData.add(phoneDetailsData);

		AddContactPanel.textFieldPhNo.setText("");
		AddContactPanel.textFieldExtension.setText("");
		AddContactPanel.comboBoxPhType.setSelectedIndex(0);
	}
}
