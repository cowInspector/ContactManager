package com.contactmanager.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;

public class ContactSearchPanel extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public ContactSearchPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{178, 83, 0};
		gridBagLayout.rowHeights = new int[]{32, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblSearchContacts = new JLabel("Search contacts");
		lblSearchContacts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		GridBagConstraints gbc_lblSearchContacts = new GridBagConstraints();
		gbc_lblSearchContacts.insets = new Insets(0, 0, 5, 5);
		gbc_lblSearchContacts.fill = GridBagConstraints.BOTH;
		gbc_lblSearchContacts.gridx = 0;
		gbc_lblSearchContacts.gridy = 0;
		add(lblSearchContacts, gbc_lblSearchContacts);
		
		JLabel lblFirstName = new JLabel("First Name:");
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 1;
		add(lblFirstName, gbc_lblFirstName);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		add(lblNewLabel, gbc_lblNewLabel);

	}

}
