package com.contactmanager.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JButton;

public class ContactSearchPanel extends JPanel {
	public static JTextField textFieldFirstName;
	public static JTextField textFieldLastName;
	public static JTextField textFieldPhoneNumber;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public ContactSearchPanel() {
		setLayout(null);
		
		JLabel lblSearchContacts = new JLabel("Search contacts");
		lblSearchContacts.setBounds(0, 0, 173, 27);
		lblSearchContacts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		add(lblSearchContacts);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(10, 35, 55, 14);
		add(lblFirstName);
		
		textFieldFirstName = new JTextField();
		textFieldFirstName.setBounds(75, 32, 149, 20);
		add(textFieldFirstName);
		textFieldFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setBounds(253, 35, 78, 14);
		add(lblLastName);
		
		textFieldLastName = new JTextField();
		textFieldLastName.setBounds(316, 32, 149, 20);
		add(textFieldLastName);
		textFieldLastName.setColumns(10);
		
		JLabel lblPhoneNo = new JLabel("Phone No.:");
		lblPhoneNo.setBounds(10, 75, 55, 14);
		add(lblPhoneNo);
		
		textFieldPhoneNumber = new JTextField();
		textFieldPhoneNumber.setBounds(75, 72, 149, 20);
		add(textFieldPhoneNumber);
		textFieldPhoneNumber.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 100, 850, 24);
		add(separator);
		
		table = new JTable();
		table.setBounds(10, 564, 321, -428);
		add(table);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(253, 71, 89, 23);
		add(btnSearch);

	}
}
