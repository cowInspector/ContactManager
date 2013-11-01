package com.contactmanager.ui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

import com.contactmanager.ui.eventhandlers.AddContactEventHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddContactPanel extends JPanel {
	public static JTextField textFieldFirstName;
	public static JTextField textFieldMidName;
	public static JTextField textFieldLastName;
	public static JTextField textFieldNickame;
	public static JTextField textFieldPrefix;
	public static JTextField textFieldSuffix;
	public static JTextField textFieldPhNo;
	public static JTextField textFieldExtension;
	public static JTextField textFieldAddrLine1;
	public static JTextField textFieldAddrLine2;
	public static JTextField textFieldAddrLine3;
	public static JTextField textFieldCity;
	public static JTextField textFieldState;
	public static JTextField textFieldCountry;
	public static JTextField textFieldPostalCode;
	public static JTextField textFieldEmailID;
	public static JComboBox comboBoxPhType;
	public static JComboBox comboBoxAddrType;
	public static JComboBox comboBoxEmailType;
	public static JComboBox comboBoxRelationship;
	public static JFormattedTextField formattedTextFieldDateMet;

	/**
	 * Create the panel.
	 */
	public AddContactPanel() {
		setLayout(null);
		
		JLabel lblAddContacts = new JLabel("Add contacts");
		lblAddContacts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblAddContacts.setBounds(10, 11, 173, 27);
		add(lblAddContacts);
		
		JPanel panelContact = new JPanel();
		panelContact.setBounds(10, 49, 234, 353);
		add(panelContact);
		panelContact.setLayout(null);
		
		TitledBorder contactTitle;
		contactTitle = BorderFactory.createTitledBorder("Basic Contact Details");
		panelContact.setBorder(contactTitle);
		
		JLabel lblFirstname = new JLabel("First Name *");
		lblFirstname.setBounds(10, 68, 66, 14);
		panelContact.add(lblFirstname);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(10, 110, 66, 14);
		panelContact.add(lblMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 151, 57, 14);
		panelContact.add(lblLastName);
		
		JLabel lblPrefix = new JLabel("Prefix");
		lblPrefix.setBounds(10, 26, 46, 14);
		panelContact.add(lblPrefix);
		
		JLabel lblSuffix = new JLabel("Suffix");
		lblSuffix.setBounds(10, 194, 46, 14);
		panelContact.add(lblSuffix);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setBounds(10, 236, 46, 14);
		panelContact.add(lblNickname);
		
		JLabel lblFirstMeOn = new JLabel("First Met On");
		lblFirstMeOn.setBounds(10, 328, 66, 14);
		panelContact.add(lblFirstMeOn);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(104, 65, 115, 20);
		panelContact.add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		textFieldMidName = new JTextField();
		textFieldMidName.setBounds(104, 107, 115, 20);
		panelContact.add(textFieldMidName);
		textFieldMidName.setColumns(10);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(104, 148, 115, 20);
		panelContact.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		textFieldNickame = new JTextField();
		textFieldNickame.setBounds(104, 233, 115, 20);
		panelContact.add(textFieldNickame);
		textFieldNickame.setColumns(10);
		
		formattedTextFieldDateMet = new JFormattedTextField();
		formattedTextFieldDateMet.setBounds(104, 325, 115, 20);
		panelContact.add(formattedTextFieldDateMet);
		
		textFieldPrefix = new JTextField();
		textFieldPrefix.setBounds(104, 23, 115, 20);
		panelContact.add(textFieldPrefix);
		textFieldPrefix.setColumns(10);
		
		textFieldSuffix = new JTextField();
		textFieldSuffix.setBounds(104, 191, 115, 20);
		panelContact.add(textFieldSuffix);
		textFieldSuffix.setColumns(10);
		
		JLabel lblRelationship = new JLabel("Relationship");
		lblRelationship.setBounds(10, 282, 66, 14);
		panelContact.add(lblRelationship);
		
		comboBoxRelationship = new JComboBox();
		comboBoxRelationship.setModel(new DefaultComboBoxModel(new String[] {"SPOUSE", "SIBLING", "FATHER", "MOTHER", "PROFESSIONAL"}));
		comboBoxRelationship.setBounds(104, 279, 115, 20);
		panelContact.add(comboBoxRelationship);
		
		JPanel panelPhoneDetails = new JPanel();
		panelPhoneDetails.setBounds(10, 413, 234, 172);
		add(panelPhoneDetails);
		
		TitledBorder phoneDetailsTitle;
		phoneDetailsTitle = BorderFactory.createTitledBorder("Phone Details");
		panelPhoneDetails.setBorder(phoneDetailsTitle);
		panelPhoneDetails.setLayout(null);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number *");
		lblPhoneNumber.setBounds(10, 24, 79, 14);
		panelPhoneDetails.add(lblPhoneNumber);
		
		textFieldPhNo = new JTextField();
		textFieldPhNo.setBounds(99, 21, 125, 20);
		panelPhoneDetails.add(textFieldPhNo);
		textFieldPhNo.setColumns(10);
		
		JLabel lblExtension = new JLabel("Extension");
		lblExtension.setBounds(10, 60, 79, 14);
		panelPhoneDetails.add(lblExtension);
		
		textFieldExtension = new JTextField();
		textFieldExtension.setBounds(99, 57, 86, 20);
		panelPhoneDetails.add(textFieldExtension);
		textFieldExtension.setColumns(10);
		
		JLabel lblPhoneType = new JLabel("Phone Type");
		lblPhoneType.setBounds(10, 104, 79, 14);
		panelPhoneDetails.add(lblPhoneType);
		
		comboBoxPhType = new JComboBox();
		comboBoxPhType.setModel(new DefaultComboBoxModel(new String[] {"HOME", "OFFICE", "MOBILE", "OTHER"}));
		comboBoxPhType.setBounds(99, 101, 86, 20);
		panelPhoneDetails.add(comboBoxPhType);
		
		JButton btnAddPhoneNumber = new JButton("Add Another Phone Number");
		btnAddPhoneNumber.addActionListener(new AddContactEventHandler());
		btnAddPhoneNumber.setBounds(10, 142, 175, 23);
		panelPhoneDetails.add(btnAddPhoneNumber);
		
		JPanel panelAddressDetails = new JPanel();
		panelAddressDetails.setBounds(254, 49, 572, 250);
		add(panelAddressDetails);
		
		TitledBorder addressDetailsTitle;
		addressDetailsTitle = BorderFactory.createTitledBorder("Address Details");
		panelAddressDetails.setBorder(addressDetailsTitle);
		panelAddressDetails.setLayout(null);
		
		JLabel lblAddressLine = new JLabel("Address Line 1 *");
		lblAddressLine.setBounds(10, 24, 89, 14);
		panelAddressDetails.add(lblAddressLine);
		
		textFieldAddrLine1 = new JTextField();
		textFieldAddrLine1.setBounds(109, 21, 453, 20);
		panelAddressDetails.add(textFieldAddrLine1);
		textFieldAddrLine1.setColumns(10);
		
		JLabel lblAddressLine_1 = new JLabel("Address Line 2");
		lblAddressLine_1.setBounds(10, 55, 89, 14);
		panelAddressDetails.add(lblAddressLine_1);
		
		textFieldAddrLine2 = new JTextField();
		textFieldAddrLine2.setBounds(109, 52, 453, 20);
		panelAddressDetails.add(textFieldAddrLine2);
		textFieldAddrLine2.setColumns(10);
		
		JLabel lblAddressLine_2 = new JLabel("Address Line 3 *");
		lblAddressLine_2.setBounds(10, 89, 89, 14);
		panelAddressDetails.add(lblAddressLine_2);
		
		textFieldAddrLine3 = new JTextField();
		textFieldAddrLine3.setBounds(109, 86, 453, 20);
		panelAddressDetails.add(textFieldAddrLine3);
		textFieldAddrLine3.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 129, 46, 14);
		panelAddressDetails.add(lblCity);
		
		textFieldCity = new JTextField();
		textFieldCity.setBounds(53, 126, 98, 20);
		panelAddressDetails.add(textFieldCity);
		textFieldCity.setColumns(10);
		
		JLabel lblState = new JLabel("State");
		lblState.setBounds(190, 129, 46, 14);
		panelAddressDetails.add(lblState);
		
		textFieldState = new JTextField();
		textFieldState.setBounds(235, 126, 98, 20);
		panelAddressDetails.add(textFieldState);
		textFieldState.setColumns(10);
		
		JLabel lblCountry = new JLabel("Country");
		lblCountry.setBounds(10, 167, 46, 14);
		panelAddressDetails.add(lblCountry);
		
		textFieldCountry = new JTextField();
		textFieldCountry.setBounds(53, 164, 126, 20);
		panelAddressDetails.add(textFieldCountry);
		textFieldCountry.setColumns(10);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setBounds(358, 129, 72, 14);
		panelAddressDetails.add(lblPostalCode);
		
		textFieldPostalCode = new JTextField();
		textFieldPostalCode.setBounds(436, 126, 126, 20);
		panelAddressDetails.add(textFieldPostalCode);
		textFieldPostalCode.setColumns(10);
		
		JLabel lblAddressType = new JLabel("Address Type");
		lblAddressType.setBounds(190, 167, 72, 14);
		panelAddressDetails.add(lblAddressType);
		
		comboBoxAddrType = new JComboBox();
		comboBoxAddrType.setModel(new DefaultComboBoxModel(new String[] {"HOME", "OFFICE", "OTHER"}));
		comboBoxAddrType.setBounds(272, 164, 89, 20);
		panelAddressDetails.add(comboBoxAddrType);
		
		JButton btnAddAnotherAddress = new JButton("Add Another Address");
		btnAddAnotherAddress.addActionListener(new AddContactEventHandler());
		btnAddAnotherAddress.setBounds(10, 207, 153, 23);
		panelAddressDetails.add(btnAddAnotherAddress);
		
		JPanel panelEmailDetails = new JPanel();
		panelEmailDetails.setBounds(254, 310, 297, 136);
		add(panelEmailDetails);
		panelEmailDetails.setLayout(null);
		
		TitledBorder emailDetailsTitle;
		emailDetailsTitle = BorderFactory.createTitledBorder("Email Details");
		panelEmailDetails.setBorder(emailDetailsTitle);
		
		JLabel lblEmailId = new JLabel("Email ID *");
		lblEmailId.setBounds(10, 25, 57, 14);
		panelEmailDetails.add(lblEmailId);
		
		textFieldEmailID = new JTextField();
		textFieldEmailID.setBounds(77, 22, 210, 20);
		panelEmailDetails.add(textFieldEmailID);
		textFieldEmailID.setColumns(10);
		
		JLabel lblEmailType = new JLabel("Email Type");
		lblEmailType.setBounds(10, 63, 64, 14);
		panelEmailDetails.add(lblEmailType);
		
		comboBoxEmailType = new JComboBox();
		comboBoxEmailType.setModel(new DefaultComboBoxModel(new String[] {"PERSONAL", "WORK"}));
		comboBoxEmailType.setBounds(77, 60, 77, 20);
		panelEmailDetails.add(comboBoxEmailType);
		
		JButton btnAddAnotherEmail = new JButton("Add Another Email Address");
		btnAddAnotherEmail.addActionListener(new AddContactEventHandler());
		btnAddAnotherEmail.setBounds(10, 103, 210, 23);
		panelEmailDetails.add(btnAddAnotherEmail);
		
		JButton btnSaveAll = new JButton("Save All");
		btnSaveAll.addActionListener(new AddContactEventHandler());
		btnSaveAll.setBounds(254, 467, 89, 23);
		add(btnSaveAll);
		
		JButton btnClearAll = new JButton("Clear All");
		btnClearAll.addActionListener(new AddContactEventHandler());
		btnClearAll.setBounds(353, 467, 89, 23);
		add(btnClearAll);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "Contact");
			}
		});
		btnBack.setBounds(452, 467, 89, 23);
		add(btnBack);
		
		JLabel lblFieldsMarked = new JLabel("Fields marked * are required");
		lblFieldsMarked.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblFieldsMarked.setBounds(254, 501, 297, 27);
		add(lblFieldsMarked);
	}
}
