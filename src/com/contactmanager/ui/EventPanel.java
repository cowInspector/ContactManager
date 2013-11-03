package com.contactmanager.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.contactmanager.ui.eventhandlers.EventSearchEventHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventPanel extends JPanel {
	public static JTextField textFieldEventName;
	public static JTextField textFieldEventDate;
	public static JTextField textFieldContact;
	public static JTable table;
	public static JComboBox comboBoxEventType;

	/**
	 * Create the panel.
	 */
	public EventPanel() {
		setLayout(null);
		
		JLabel lblSearchEvents = new JLabel("Search Events");
		lblSearchEvents.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSearchEvents.setBounds(10, 11, 137, 22);
		add(lblSearchEvents);
		
		JLabel lblEventName = new JLabel("Event Name");
		lblEventName.setBounds(10, 48, 73, 14);
		add(lblEventName);
		
		textFieldEventName = new JTextField();
		textFieldEventName.setBounds(81, 44, 137, 20);
		add(textFieldEventName);
		textFieldEventName.setColumns(10);
		
		JLabel lblEventDate = new JLabel("Event Date");
		lblEventDate.setBounds(228, 48, 73, 14);
		add(lblEventDate);
		
		textFieldEventDate = new JTextField();
		textFieldEventDate.setBounds(295, 45, 137, 20);
		add(textFieldEventDate);
		textFieldEventDate.setColumns(10);
		
		JLabel lblEventType = new JLabel("Event Type");
		lblEventType.setBounds(442, 48, 73, 14);
		add(lblEventType);
		
		comboBoxEventType = new JComboBox();
		comboBoxEventType.setModel(new DefaultComboBoxModel(new String[] {"BIRTHDAY", "ANNIVERSARY", "MEETING", "OTHER"}));
		comboBoxEventType.setBounds(513, 45, 137, 20);
		add(comboBoxEventType);
		
		JLabel lblAssociatedContact = new JLabel("Associated Contact");
		lblAssociatedContact.setBounds(10, 86, 106, 14);
		add(lblAssociatedContact);
		
		textFieldContact = new JTextField();
		textFieldContact.setBounds(118, 83, 137, 20);
		add(textFieldContact);
		textFieldContact.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new EventSearchEventHandler());
		btnSearch.setBounds(295, 82, 89, 23);
		add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldContact.setText("");
				textFieldEventDate.setText("");
				textFieldEventName.setText("");
				comboBoxEventType.setSelectedIndex(0);
				table.setVisible(false);
			}
		});
		btnClear.setBounds(394, 82, 89, 23);
		add(btnClear);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.setBounds(493, 82, 89, 23);
		add(btnAddEvent);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 777, 2);
		add(separator);
		
		table = new JTable();
		table.setBounds(10, 426, 558, -300);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 492, 777, -366);
		add(scrollPane);
		//add(table);

	}
}
