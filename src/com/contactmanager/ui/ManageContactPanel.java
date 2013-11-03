package com.contactmanager.ui;

import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

import com.contactmanager.ui.eventhandlers.ManageContactEventHandler;

public class ManageContactPanel extends JPanel {
	public static JTextField textFieldFirstName;
	public static JTextField textFieldMiddleName;
	public static JTextField textFieldLastName;
	public static JTextField textFieldNickName;
	public static JTextField textFieldPrefix;
	public static JTextField textFieldSuffix;
	public static JTable tableAddressTable;
	public static JTable tablePhoneDetails;
	public static JTable tableEmail;
	public static JComboBox comboBoxRelationship;
	public static JFormattedTextField formattedTextFieldFirstMet;

	/**
	 * Create the panel.
	 */
	public ManageContactPanel() {
		setLayout(null);

		JPanel panelContactDetails = new JPanel();
		panelContactDetails.setLayout(null);
		panelContactDetails.setBounds(10, 44, 234, 353);
		add(panelContactDetails);

		TitledBorder contactTitle = BorderFactory
				.createTitledBorder("Contact Details");
		panelContactDetails.setBorder(contactTitle);

		JLabel labelFirstName = new JLabel("First Name *");
		labelFirstName.setBounds(10, 68, 66, 14);
		panelContactDetails.add(labelFirstName);

		JLabel labelMiddleName = new JLabel("Middle Name");
		labelMiddleName.setBounds(10, 110, 66, 14);
		panelContactDetails.add(labelMiddleName);

		JLabel labelLastName = new JLabel("Last Name");
		labelLastName.setBounds(10, 151, 57, 14);
		panelContactDetails.add(labelLastName);

		JLabel labelPrefix = new JLabel("Prefix");
		labelPrefix.setBounds(10, 26, 46, 14);
		panelContactDetails.add(labelPrefix);

		JLabel labelSuffix = new JLabel("Suffix");
		labelSuffix.setBounds(10, 194, 46, 14);
		panelContactDetails.add(labelSuffix);

		JLabel labelNickName = new JLabel("Nickname");
		labelNickName.setBounds(10, 236, 46, 14);
		panelContactDetails.add(labelNickName);

		JLabel labelFirstMet = new JLabel("First Met On");
		labelFirstMet.setBounds(10, 328, 66, 14);
		panelContactDetails.add(labelFirstMet);

		textFieldFirstName = new JTextField();
		textFieldFirstName.setColumns(10);
		textFieldFirstName.setBounds(104, 65, 115, 20);
		panelContactDetails.add(textFieldFirstName);

		textFieldMiddleName = new JTextField();
		textFieldMiddleName.setColumns(10);
		textFieldMiddleName.setBounds(104, 107, 115, 20);
		panelContactDetails.add(textFieldMiddleName);

		textFieldLastName = new JTextField();
		textFieldLastName.setColumns(10);
		textFieldLastName.setBounds(104, 148, 115, 20);
		panelContactDetails.add(textFieldLastName);

		textFieldNickName = new JTextField();
		textFieldNickName.setColumns(10);
		textFieldNickName.setBounds(104, 233, 115, 20);
		panelContactDetails.add(textFieldNickName);

		formattedTextFieldFirstMet = new JFormattedTextField();
		formattedTextFieldFirstMet.setBounds(104, 325, 115, 20);
		panelContactDetails.add(formattedTextFieldFirstMet);

		textFieldPrefix = new JTextField();
		textFieldPrefix.setColumns(10);
		textFieldPrefix.setBounds(104, 23, 115, 20);
		panelContactDetails.add(textFieldPrefix);

		textFieldSuffix = new JTextField();
		textFieldSuffix.setColumns(10);
		textFieldSuffix.setBounds(104, 191, 115, 20);
		panelContactDetails.add(textFieldSuffix);

		JLabel labelRelationship = new JLabel("Relationship");
		labelRelationship.setBounds(10, 282, 66, 14);
		panelContactDetails.add(labelRelationship);

		comboBoxRelationship = new JComboBox();
		comboBoxRelationship.setModel(new DefaultComboBoxModel(new String[] {
				"SPOUSE", "SIBLING", "FATHER", "MOTHER", "PROFESSIONAL" }));
		comboBoxRelationship.setBounds(104, 279, 115, 20);
		panelContactDetails.add(comboBoxRelationship);

		JLabel labelManageContact = new JLabel("Manage Contact");
		labelManageContact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				18));
		labelManageContact.setBounds(10, 6, 173, 27);
		add(labelManageContact);

		JPanel panelPhoneDetails = new JPanel();
		panelPhoneDetails.setBounds(10, 409, 352, 329);
		add(panelPhoneDetails);
		TitledBorder phoneDetailsTitle = BorderFactory
				.createTitledBorder("Phone Details");
		panelPhoneDetails.setBorder(phoneDetailsTitle);
		panelPhoneDetails.setLayout(null);

		tablePhoneDetails = new JTable();
		tablePhoneDetails.setBounds(10, 24, 332, 294);
		// panelPhoneDetails.add(tablePhoneDetails);

		JScrollPane scrollPanePhDetails = new JScrollPane(tablePhoneDetails);
		scrollPanePhDetails.setBounds(10, 309, 332, -296);
		panelPhoneDetails.add(scrollPanePhDetails);

		JPanel panelAddressDetails = new JPanel();
		panelAddressDetails.setBounds(254, 44, 682, 353);
		add(panelAddressDetails);
		TitledBorder addrDetailsTitle = BorderFactory
				.createTitledBorder("Address Details");
		panelAddressDetails.setBorder(addrDetailsTitle);
		panelAddressDetails.setLayout(null);

		tableAddressTable = new JTable();
		tableAddressTable.setBounds(20, 24, 652, 307);
		// panelAddressDetails.add(tableAddressTable);

		JScrollPane scrollPaneAddrDetails = new JScrollPane(tableAddressTable);
		scrollPaneAddrDetails.setBounds(10, 342, 662, -329);
		panelAddressDetails.add(scrollPaneAddrDetails);

		JPanel panelEmail = new JPanel();
		panelEmail.setBounds(372, 409, 564, 329);
		add(panelEmail);
		TitledBorder emailTitle = BorderFactory
				.createTitledBorder("Email Details");
		panelEmail.setBorder(emailTitle);
		panelEmail.setLayout(null);

		tableEmail = new JTable();
		tableEmail.setBounds(22, 309, 532, -289);
		panelEmail.add(tableEmail);
		JScrollPane scrollPaneEmail = new JScrollPane(tableEmail);
		scrollPaneEmail.setBounds(548, 11, -536, 307);
		panelEmail.add(scrollPaneEmail);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(254, 11, 89, 23);
		add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(353, 11, 89, 23);
		add(btnDelete);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(452, 11, 89, 23);
		add(btnBack);

		populateUIElements(ManageContactEventHandler.setContactDetails(System
				.getProperty("currentContactID")));
	}

	private void populateUIElements(Vector<Object> contactData) {
		//MainWindow.manageContactPanel.textFieldPrefix.setText(contactData.get(0).toString());
		ManageContactPanel.textFieldPrefix.setText(contactData.get(0)==null?"":contactData.get(0).toString());
		//MainWindow.manageContactPanel.textFieldFirstName.setText(contactData.get(1).toString());
		ManageContactPanel.textFieldFirstName.setText(contactData.get(1)==null?"":contactData.get(1).toString());
		//MainWindow.manageContactPanel.textFieldMiddleName.setText(contactData.get(2).toString());
		ManageContactPanel.textFieldMiddleName.setText(contactData.get(2)==null?"":contactData.get(2).toString());
		//MainWindow.manageContactPanel.textFieldLastName.setText(contactData.get(3).toString());
		ManageContactPanel.textFieldLastName.setText(contactData.get(3)==null?"":contactData.get(3).toString());
		//MainWindow.manageContactPanel.textFieldSuffix.setText(contactData.get(4).toString());
		ManageContactPanel.textFieldSuffix.setText(contactData.get(4)==null?"":contactData.get(4).toString());
		//MainWindow.manageContactPanel.textFieldNickName.setText(contactData.get(5).toString());
		ManageContactPanel.textFieldNickName.setText(contactData.get(5)==null?"":contactData.get(5).toString());
		//MainWindow.manageContactPanel.comboBoxRelationship.setSelectedItem(contactData.get(6).toString());
		ManageContactPanel.comboBoxRelationship.setSelectedItem(contactData.get(6)==null?"SPOUSE":contactData.get(6).toString());
		//MainWindow.manageContactPanel.formattedTextFieldFirstMet.setText(contactData.get(7).toString());
		ManageContactPanel.formattedTextFieldFirstMet.setText(contactData.get(7)==null?"":contactData.get(7).toString());
	}

}
