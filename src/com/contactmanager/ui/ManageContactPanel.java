package com.contactmanager.ui;

import java.awt.Font;

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

public class ManageContactPanel extends JPanel {
	private JTextField textFieldFirstName;
	private JTextField textFieldMiddleName;
	private JTextField textFieldLastName;
	private JTextField textFieldNickName;
	private JTextField textFieldPrefix;
	private JTextField textFieldSuffix;
	private JTable tablePhoneDetails;

	/**
	 * Create the panel.
	 */
	public ManageContactPanel() {
		setLayout(null);
		
		JPanel panelContactDetails = new JPanel();
		panelContactDetails.setLayout(null);
		panelContactDetails.setBounds(10, 44, 234, 353);
		add(panelContactDetails);
		
		TitledBorder contactTitle = BorderFactory.createTitledBorder("Contact Details");
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
		
		JFormattedTextField formattedTextFieldFirstMet = new JFormattedTextField();
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
		
		JComboBox comboBoxRelationship = new JComboBox();
		comboBoxRelationship.setModel(new DefaultComboBoxModel(new String[] {"SPOUSE", "SIBLING", "FATHER", "MOTHER", "PROFESSIONAL"}));
		comboBoxRelationship.setBounds(104, 279, 115, 20);
		panelContactDetails.add(comboBoxRelationship);
		
		JLabel labelManageContact = new JLabel("Manage Contact");
		labelManageContact.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelManageContact.setBounds(10, 6, 173, 27);
		add(labelManageContact);
		
		JPanel panelPhoneDetails = new JPanel();
		panelPhoneDetails.setBounds(10, 409, 352, 329);
		add(panelPhoneDetails);
		TitledBorder phoneDetailsTitle = BorderFactory.createTitledBorder("Phone Details");
		panelPhoneDetails.setBorder(phoneDetailsTitle);
		panelPhoneDetails.setLayout(null);
		
		tablePhoneDetails = new JTable();
		tablePhoneDetails.setBounds(10, 309, 427, -296);
		add(tablePhoneDetails);

		JScrollPane scrollPane = new JScrollPane(tablePhoneDetails);
		scrollPane.setBounds(10, 309, 332, -296);
		panelPhoneDetails.add(scrollPane);
		
		JPanel panelAddressDetails = new JPanel();
		panelAddressDetails.setBounds(254, 44, 682, 353);
		add(panelAddressDetails);
		TitledBorder addrDetailsTitle = BorderFactory.createTitledBorder("Address Details");
	}

}
