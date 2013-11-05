package com.contactmanager.ui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;

/**
 * @author Yogeshwara Krishnan
 * 
 * UI Class to modify contact details, delete contact and related tables like
 * Email details, Address details, Phone details.
 *
 */
public class ManageContactPanel extends JPanel {
	public static JTextField textFieldFirstName;
	public static JTextField textFieldMiddleName;
	public static JTextField textFieldLastName;
	public static JTextField textFieldNickName;
	public static JTextField textFieldPrefix;
	public static JTextField textFieldSuffix;
	public static JComboBox comboBoxRelationship;
	public static JFormattedTextField formattedTextFieldFirstMet;
	public static JTable tableAddrDetails;
	public static JTable tablePhoneDetails;
	public static JTable tableEmailDetails;
	public static JLabel lblStatusMessage;

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
		add(tablePhoneDetails);
		JScrollPane scrollPanePhoneDetails = new JScrollPane(tablePhoneDetails);
		scrollPanePhoneDetails.setBounds(10, 23, 336, 261);
		panelPhoneDetails.add(scrollPanePhoneDetails);
		
		JButton btnAddPhoneNumber = new JButton("Add Phone Number");
		btnAddPhoneNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tablePhoneDetails.getModel();
				model.addRow(new Object[]{"","","",""});
			}
		});
		btnAddPhoneNumber.setBounds(10, 295, 136, 23);
		panelPhoneDetails.add(btnAddPhoneNumber);
		
		JButton btnDeleteSelectedPhone = new JButton("Delete Selected Phone Number");
		btnDeleteSelectedPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tablePhoneDetails.getModel();
				model.removeRow(tablePhoneDetails.getSelectedRow());
			}
		});
		btnDeleteSelectedPhone.setBounds(156, 295, 190, 23);
		panelPhoneDetails.add(btnDeleteSelectedPhone);

		JPanel panelAddressDetails = new JPanel();
		panelAddressDetails.setBounds(254, 44, 682, 353);
		add(panelAddressDetails);
		TitledBorder addrDetailsTitle = BorderFactory
				.createTitledBorder("Address Details");
		panelAddressDetails.setBorder(addrDetailsTitle);
		panelAddressDetails.setLayout(null);
		
		tableAddrDetails = new JTable();
		add(tableAddrDetails);
		JScrollPane scrollPaneAddrDetails = new JScrollPane(tableAddrDetails);
		scrollPaneAddrDetails.setBounds(10, 24, 662, 267);
		panelAddressDetails.add(scrollPaneAddrDetails);
		
		JButton btnAddAddress = new JButton("Add Address");
		btnAddAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableAddrDetails.getModel();
				model.addRow(new Object[]{"","","","","","","","",""});
			}
		});
		btnAddAddress.setBounds(10, 302, 122, 23);
		panelAddressDetails.add(btnAddAddress);
		
		JButton btnDeleteSelectedAddress = new JButton("Delete Selected Address");
		btnDeleteSelectedAddress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableAddrDetails.getModel();
				model.removeRow(tableAddrDetails.getSelectedRow());
			}
		});
		btnDeleteSelectedAddress.setBounds(142, 302, 149, 23);
		panelAddressDetails.add(btnDeleteSelectedAddress);

		JPanel panelEmail = new JPanel();
		panelEmail.setBounds(372, 409, 564, 329);
		add(panelEmail);
		TitledBorder emailTitle = BorderFactory
				.createTitledBorder("Email Details");
		panelEmail.setBorder(emailTitle);
		panelEmail.setLayout(null);
		
		tableEmailDetails = new JTable();
		add(tableEmailDetails);
		
		JScrollPane scrollPaneEmail = new JScrollPane(tableEmailDetails);
		scrollPaneEmail.setBounds(10, 18, 544, 259);
		panelEmail.add(scrollPaneEmail);
		
		JButton btnAddEmail = new JButton("Add Email");
		btnAddEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableEmailDetails.getModel();
				model.addRow(new Object[]{"","",""});
			}
		});
		btnAddEmail.setBounds(10, 295, 89, 23);
		panelEmail.add(btnAddEmail);
		
		JButton btnDeleteSelectedEmail = new JButton("Delete Selected Email");
		btnDeleteSelectedEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel model = (DefaultTableModel) tableEmailDetails.getModel();
				model.removeRow(tableEmailDetails.getSelectedRow());
			}
		});
		btnDeleteSelectedEmail.setBounds(133, 295, 135, 23);
		panelEmail.add(btnDeleteSelectedEmail);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ManageContactEventHandler());
		btnSave.setBounds(254, 11, 89, 23);
		add(btnSave);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(353, 11, 89, 23);
		btnDelete.addActionListener(new ManageContactEventHandler());
		add(btnDelete);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "Contact");
			}
		});
		btnBack.setBounds(452, 11, 89, 23);
		add(btnBack);
		
		lblStatusMessage = new JLabel("StatusMessage");
		lblStatusMessage.setVisible(false);
		lblStatusMessage.setBounds(551, 15, 385, 14);
		add(lblStatusMessage);
	}
}
