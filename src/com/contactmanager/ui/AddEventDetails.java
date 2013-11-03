package com.contactmanager.ui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddEventDetails extends JPanel {
	private JTextField textFieldEventName;
	private JTextField textFieldStartHrs;
	private JTextField textFieldStartMins;
	private JTextField textFieldEndHrs;
	private JTextField textFieldEndMins;

	/**
	 * Create the panel.
	 */
	public AddEventDetails() {
		setLayout(null);
		
		JLabel labelTitle = new JLabel("Add event");
		labelTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelTitle.setBounds(10, 11, 173, 27);
		add(labelTitle);
		
		JPanel panelEventDetails = new JPanel();
		panelEventDetails.setBounds(10, 49, 639, 188);
		add(panelEventDetails);
		
		TitledBorder eventTitle = BorderFactory.createTitledBorder("Event Details");
		panelEventDetails.setBorder(eventTitle);
		panelEventDetails.setLayout(null);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(10, 28, 72, 14);
		panelEventDetails.add(lblEventName);
		
		textFieldEventName = new JTextField();
		textFieldEventName.setBounds(109, 25, 137, 20);
		panelEventDetails.add(textFieldEventName);
		textFieldEventName.setColumns(10);
		
		JLabel lblEventDescription = new JLabel("Event Description");
		lblEventDescription.setBounds(10, 60, 91, 14);
		panelEventDetails.add(lblEventDescription);
		
		final JTextArea textAreaEventDescription = new JTextArea();
		textAreaEventDescription.setBounds(109, 57, 137, 120);
		panelEventDetails.add(textAreaEventDescription);
		
		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(256, 28, 72, 14);
		panelEventDetails.add(lblStartDate);
		
		final JFormattedTextField formattedTextFieldStartDate = new JFormattedTextField();
		formattedTextFieldStartDate.setToolTipText("YYYY-MM-DD");
		formattedTextFieldStartDate.setBounds(322, 25, 109, 20);
		panelEventDetails.add(formattedTextFieldStartDate);
		
		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(256, 60, 46, 14);
		panelEventDetails.add(lblEndDate);
		
		final JFormattedTextField formattedTextFieldEndDate = new JFormattedTextField();
		formattedTextFieldEndDate.setToolTipText("YYYY-MM-DD");
		formattedTextFieldEndDate.setBounds(322, 57, 109, 20);
		panelEventDetails.add(formattedTextFieldEndDate);
		
		JLabel lblStartTime = new JLabel("Start Time");
		lblStartTime.setBounds(466, 26, 56, 14);
		panelEventDetails.add(lblStartTime);
		
		JLabel lblHh = new JLabel("HH");
		lblHh.setBounds(532, 11, 22, 14);
		panelEventDetails.add(lblHh);
		
		textFieldStartHrs = new JTextField();
		textFieldStartHrs.setBounds(532, 23, 22, 20);
		panelEventDetails.add(textFieldStartHrs);
		textFieldStartHrs.setColumns(10);
		
		JLabel lblMm = new JLabel("MM");
		lblMm.setBounds(564, 11, 22, 14);
		panelEventDetails.add(lblMm);
		
		textFieldStartMins = new JTextField();
		textFieldStartMins.setBounds(564, 23, 22, 20);
		panelEventDetails.add(textFieldStartMins);
		textFieldStartMins.setColumns(10);
		
		JLabel lblEndTime = new JLabel("End Time");
		lblEndTime.setBounds(466, 64, 56, 14);
		panelEventDetails.add(lblEndTime);
		
		textFieldEndHrs = new JTextField();
		textFieldEndHrs.setBounds(532, 61, 22, 20);
		panelEventDetails.add(textFieldEndHrs);
		textFieldEndHrs.setColumns(10);
		
		textFieldEndMins = new JTextField();
		textFieldEndMins.setBounds(564, 61, 22, 20);
		panelEventDetails.add(textFieldEndMins);
		textFieldEndMins.setColumns(10);
		
		TitledBorder reminderTitle = BorderFactory.createTitledBorder("Add Reminder");
		
		JPanel panelAssociateContact = new JPanel();
		panelAssociateContact.setBounds(10, 249, 325, 107);
		add(panelAssociateContact);
		
		TitledBorder contactsTitle = BorderFactory.createTitledBorder("Associate Contact");
		panelAssociateContact.setBorder(contactsTitle);
		panelAssociateContact.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contact Name");
		lblNewLabel.setBounds(10, 31, 78, 14);
		panelAssociateContact.add(lblNewLabel);
		
		final JComboBox comboBoxContact = new JComboBox();
		comboBoxContact.setBounds(98, 28, 217, 20);
		panelAssociateContact.add(comboBoxContact);
		
		JButton btnAddAnotherContact = new JButton("Add Another Contact");
		btnAddAnotherContact.setBounds(10, 67, 144, 23);
		panelAssociateContact.add(btnAddAnotherContact);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(10, 367, 89, 23);
		add(btnSave);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEventName.setText("");
				textFieldEndHrs.setText("");
				textFieldEndMins.setText("");
				textFieldStartHrs.setText("");
				textFieldStartMins.setText("");
				textAreaEventDescription.setText("");
				formattedTextFieldStartDate.setText("");
				formattedTextFieldEndDate.setText("");
				ComboBoxModel<Object> cbModel = comboBoxContact.getModel();
				if (cbModel.getSize() > 0)
				comboBoxContact.setSelectedIndex(0);
			}
		});
		btnClear.setBounds(127, 367, 89, 23);
		add(btnClear);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "Contact");
			}
		});
		btnBack.setBounds(246, 367, 89, 23);
		add(btnBack);

	}
}
