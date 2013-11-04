package com.contactmanager.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.contactmanager.ui.eventhandlers.AddEventEventHandler;
import com.contactmanager.ui.eventhandlers.EventSearchEventHandler;
import com.contactmanager.ui.eventhandlers.ManageEventEventHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.Component;

public class EventPanel extends JPanel {
	public static JTextField textFieldEventName;
	public static JTextField textFieldEventDate;
	public static JComboBox comboBoxEventType;
	public static JTable table;

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
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new EventSearchEventHandler());
		btnSearch.setBounds(10, 82, 89, 23);
		add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEventDate.setText("");
				textFieldEventName.setText("");
				comboBoxEventType.setSelectedIndex(0);
				table.setVisible(false);
			}
		});
		btnClear.setBounds(109, 82, 89, 23);
		add(btnClear);
		
		JButton btnAddEvent = new JButton("Add Event");
		btnAddEvent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "AddEvent");
				AddEventEventHandler.populateContact(System.getProperty("creatorID"));
			}
		});
		btnAddEvent.setBounds(208, 82, 89, 23);
		add(btnAddEvent);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 111, 638, 2);
		add(separator);
		
		table = new JTable();
		add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 116, 638, 373);
		add(scrollPane);
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 2) {
					final JTable target = (JTable) e.getSource();
					final int row = target.getSelectedRow();
					
					try {
						System.setProperty("currentEventID", table.getModel()
								.getValueAt(table.convertRowIndexToModel(row),
										0).toString());
						CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
						cl.show(MainWindow.cards, "ManageEvent");
						ManageEventEventHandler.getEventDetailsData(System.getProperty("currentEventID"));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
}
