package com.contactmanager.ui;

import javax.naming.PartialResultException;
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

import com.contactmanager.ui.eventhandlers.AddEventEventHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

import java.awt.Component;

import javax.swing.JTable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * @author Yogeshwara Krishnan
 * 
 * This is a UI class for adding events and corresponding details.
 *
 */
public class AddEventDetails extends JPanel {
	public static JTextField textFieldEventName;
	public static JTextField textFieldStartHrs;
	public static JTextField textFieldStartMins;
	public static JTextField textFieldEndHrs;
	public static JTextField textFieldEndMins;
	public static JTextArea textAreaEventDescription;
	public static JFormattedTextField formattedTextFieldStartDate;
	public static JFormattedTextField formattedTextFieldEndDate;
	public static JComboBox comboBoxEventType;
	public static JTable tableContacts;
	private JTextField textFieldParticipant;

	/**
	 * Create the panel. UI Initialization takes place here.
	 */
	public AddEventDetails() {
		setLayout(null);

		JLabel labelTitle = new JLabel("Add event");
		labelTitle.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelTitle.setBounds(10, 11, 173, 27);
		add(labelTitle);

		JPanel panelEventDetails = new JPanel();
		panelEventDetails.setBounds(10, 49, 639, 454);
		add(panelEventDetails);

		TitledBorder eventTitle = BorderFactory
				.createTitledBorder("Event Details");
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

		textAreaEventDescription = new JTextArea();
		textAreaEventDescription.setBounds(109, 57, 137, 120);
		panelEventDetails.add(textAreaEventDescription);

		JLabel lblStartDate = new JLabel("Start Date");
		lblStartDate.setBounds(256, 28, 72, 14);
		panelEventDetails.add(lblStartDate);

		formattedTextFieldStartDate = new JFormattedTextField();
		formattedTextFieldStartDate.setToolTipText("YYYY-MM-DD");
		formattedTextFieldStartDate.setBounds(322, 25, 109, 20);
		panelEventDetails.add(formattedTextFieldStartDate);

		JLabel lblEndDate = new JLabel("End Date");
		lblEndDate.setBounds(256, 60, 46, 14);
		panelEventDetails.add(lblEndDate);

		formattedTextFieldEndDate = new JFormattedTextField();
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

		JLabel lblEventType = new JLabel("Event Type");
		lblEventType.setBounds(256, 104, 56, 14);
		panelEventDetails.add(lblEventType);

		comboBoxEventType = new JComboBox();
		comboBoxEventType.setModel(new DefaultComboBoxModel(new String[] {
				"BIRTHDAY", "ANNIVERSARY", "MEETING", "OTHERS" }));
		comboBoxEventType.setBounds(322, 101, 109, 20);
		panelEventDetails.add(comboBoxEventType);

		JPanel panelContacts = new JPanel();
		panelContacts.setBounds(10, 197, 619, 246);
		panelEventDetails.add(panelContacts);

		TitledBorder reminderTitle = BorderFactory
				.createTitledBorder("Add Reminder");

		TitledBorder contactsTitle = BorderFactory
				.createTitledBorder("Associate Contact");
		panelContacts.setBorder(contactsTitle);
		panelContacts.setLayout(null);

		JScrollPane scrollPaneContacts = new JScrollPane(tableContacts);
		scrollPaneContacts.setBounds(10, 23, 599, 212);
		panelContacts.add(scrollPaneContacts);

		tableContacts = new JTable();
		// Add MouseListener to the table. On double click of a row, the contact is selected.
		tableContacts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					final JTable target = (JTable) e.getSource();
					final int row = target.getSelectedRow();
					System.setProperty(
							"participantID",
							tableContacts
									.getModel()
									.getValueAt(
											tableContacts
													.convertRowIndexToModel(row),
											0).toString());
					
					textFieldParticipant.setText(tableContacts
							.getModel()
							.getValueAt(
									tableContacts
											.convertRowIndexToModel(row),
									1).toString());
				}
			}
		});
		scrollPaneContacts.setColumnHeaderView(tableContacts);

		JLabel lblParticipant = new JLabel("Participant");
		lblParticipant.setBounds(256, 146, 72, 14);
		panelEventDetails.add(lblParticipant);

		textFieldParticipant = new JTextField();
		textFieldParticipant.setEditable(false);
		textFieldParticipant.setBounds(322, 143, 171, 20);
		panelEventDetails.add(textFieldParticipant);
		textFieldParticipant.setColumns(10);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new AddEventEventHandler());
		btnSave.setBounds(10, 514, 89, 23);
		add(btnSave);

		JButton btnClear = new JButton("Clear");
		// Clear the UI.
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
				comboBoxEventType.setSelectedIndex(0);
				textFieldParticipant.setText("");
			}
		});
		btnClear.setBounds(133, 514, 89, 23);
		add(btnClear);

		JButton btnBack = new JButton("Back");
		// Navigate back.
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "Contact");
			}
		});
		btnBack.setBounds(255, 514, 89, 23);
		add(btnBack);
	}
}
