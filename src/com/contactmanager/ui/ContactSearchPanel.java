package com.contactmanager.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.eventhandlers.ContactSearchEventHandlers;

public class ContactSearchPanel extends JPanel {
	public static JTextField textFieldFirstName;
	public static JTextField textFieldLastName;
	public static JTextField textFieldPhoneNumber;
	public static JTable table;

	/**
	 * Create the panel.
	 */
	public ContactSearchPanel() {
		setLayout(null);

		JLabel lblSearchContacts = new JLabel("Search contacts");
		lblSearchContacts.setBounds(0, 0, 173, 27);
		lblSearchContacts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC,
				18));
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
		table.setBounds(10, 564, 321, -468);
		add(table);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 100, 730, 480);
		add(scrollPane);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ContactSearchEventHandlers());
		btnSearch.setBounds(253, 71, 89, 23);
		add(btnSearch);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textFieldFirstName.setText("");
				textFieldLastName.setText("");
				textFieldPhoneNumber.setText("");
				table.setVisible(false);
			}
		});
		btnClear.setBounds(352, 71, 89, 23);
		add(btnClear);
		final TitledBorder title;
		title = BorderFactory.createTitledBorder("Phone Details");
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 1) {
					final JTable target = (JTable) e.getSource();
					final int row = target.getSelectedRow();
					
					try {
						System.out.println(DBQueryExecute.getPhoneDetails((table.getModel()
								.getValueAt(table.convertRowIndexToModel(row),
										0)).toString()));
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});

	}
}
