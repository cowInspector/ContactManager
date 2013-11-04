package com.contactmanager.ui;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;

import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.contactmanager.ui.eventhandlers.ManageEventEventHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class ManageEventPanel extends JPanel {
	public static JTextField textFieldEventName;
	public static JTextField textFieldStartHrs;
	public static JTextField textFieldStartMins;
	public static JTextField textFieldEndHrs;
	public static JTextField textFieldEndMins;
	public static JTextArea textAreaEventDescription;
	public static JFormattedTextField formattedTextFieldStartDate;
	public static JFormattedTextField formattedTextFieldEndDate;
	public static JComboBox comboBoxEventType;

	/**
	 * Create the panel.
	 */
	public ManageEventPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 49, 639, 188);
		add(panel);
		
		TitledBorder panelTitle = BorderFactory.createTitledBorder("Event Details");
		panel.setBorder(panelTitle);
		
		JLabel label = new JLabel("Event Name");
		label.setBounds(10, 28, 72, 14);
		panel.add(label);
		
		textFieldEventName = new JTextField();
		textFieldEventName.setColumns(10);
		textFieldEventName.setBounds(109, 25, 137, 20);
		panel.add(textFieldEventName);
		
		JLabel label_1 = new JLabel("Event Description");
		label_1.setBounds(10, 60, 91, 14);
		panel.add(label_1);
		
		textAreaEventDescription = new JTextArea();
		textAreaEventDescription.setBounds(109, 57, 137, 120);
		panel.add(textAreaEventDescription);
		
		JLabel label_2 = new JLabel("Start Date");
		label_2.setBounds(256, 28, 72, 14);
		panel.add(label_2);
		
		formattedTextFieldStartDate = new JFormattedTextField();
		formattedTextFieldStartDate.setToolTipText("YYYY-MM-DD");
		formattedTextFieldStartDate.setBounds(322, 25, 109, 20);
		panel.add(formattedTextFieldStartDate);
		
		JLabel label_3 = new JLabel("End Date");
		label_3.setBounds(256, 60, 46, 14);
		panel.add(label_3);
		
		formattedTextFieldEndDate = new JFormattedTextField();
		formattedTextFieldEndDate.setToolTipText("YYYY-MM-DD");
		formattedTextFieldEndDate.setBounds(322, 57, 109, 20);
		panel.add(formattedTextFieldEndDate);
		
		JLabel label_4 = new JLabel("Start Time");
		label_4.setBounds(466, 26, 56, 14);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("HH");
		label_5.setBounds(532, 11, 22, 14);
		panel.add(label_5);
		
		textFieldStartHrs = new JTextField();
		textFieldStartHrs.setColumns(10);
		textFieldStartHrs.setBounds(532, 23, 22, 20);
		panel.add(textFieldStartHrs);
		
		JLabel label_6 = new JLabel("MM");
		label_6.setBounds(564, 11, 22, 14);
		panel.add(label_6);
		
		textFieldStartMins = new JTextField();
		textFieldStartMins.setColumns(10);
		textFieldStartMins.setBounds(564, 23, 22, 20);
		panel.add(textFieldStartMins);
		
		JLabel label_7 = new JLabel("End Time");
		label_7.setBounds(466, 64, 56, 14);
		panel.add(label_7);
		
		textFieldEndHrs = new JTextField();
		textFieldEndHrs.setColumns(10);
		textFieldEndHrs.setBounds(532, 61, 22, 20);
		panel.add(textFieldEndHrs);
		
		textFieldEndMins = new JTextField();
		textFieldEndMins.setColumns(10);
		textFieldEndMins.setBounds(564, 61, 22, 20);
		panel.add(textFieldEndMins);
		
		JLabel label_8 = new JLabel("Event Type");
		label_8.setBounds(256, 104, 56, 14);
		panel.add(label_8);
		
		comboBoxEventType = new JComboBox();
		comboBoxEventType.setModel(new DefaultComboBoxModel(new String[] {"BIRTHDAY", "ANNIVERSARY", "MEETING", "OTHER"}));
		comboBoxEventType.setBounds(322, 101, 109, 20);
		panel.add(comboBoxEventType);
		
		JLabel labelManageEvent = new JLabel("Manage event");
		labelManageEvent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		labelManageEvent.setBounds(10, 11, 173, 27);
		add(labelManageEvent);
		
		JButton buttonSave = new JButton("Save");
		buttonSave.addActionListener(new ManageEventEventHandler());
		buttonSave.setBounds(10, 259, 89, 23);
		add(buttonSave);
		
		JButton buttonDelete = new JButton("Delete");
		buttonDelete.addActionListener(new ManageEventEventHandler());
		buttonDelete.setBounds(128, 259, 89, 23);
		add(buttonDelete);
		
		JButton buttonBack = new JButton("Back");
		buttonBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "Contact");
			}
		});
		buttonBack.setBounds(245, 259, 89, 23);
		add(buttonBack);

	}

}
