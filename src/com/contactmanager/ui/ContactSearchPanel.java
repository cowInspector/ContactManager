package com.contactmanager.ui;

import java.awt.CardLayout;
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
import com.contactmanager.ui.eventhandlers.ManageContactEventHandler;

/**
 * @author Yogeshwara Krishnan
 * 
 *         This UI class is for Contact Search feature.
 * 
 */
public class ContactSearchPanel extends JPanel {
	public static JTextField textFieldFirstName;
	public static JTextField textFieldLastName;
	public static JTextField textFieldPhoneNumber;
	public static JTable table;
	public static JLabel lblStatusMessage;

	/**
	 * Create the panel. Initialize UI elements.
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

		JButton btnAddContact = new JButton("Add Contact");
		btnAddContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "AddContact");
			}
		});
		btnAddContact.setBounds(451, 71, 106, 23);
		add(btnAddContact);

		lblStatusMessage = new JLabel("Status Message");
		lblStatusMessage.setVisible(false);
		lblStatusMessage.setBounds(10, 591, 730, 14);
		add(lblStatusMessage);
		final TitledBorder title;
		title = BorderFactory.createTitledBorder("Phone Details");

		// Add Mouse Listener to the table rows. On double click, the contact in
		// the search results table is selected for modification.
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(final MouseEvent e) {
				if (e.getClickCount() == 2) {
					final JTable target = (JTable) e.getSource();
					final int row = target.getSelectedRow();

					try {
						System.setProperty(
								"currentContactID",
								table.getModel()
										.getValueAt(
												table.convertRowIndexToModel(row),
												0).toString());
						CardLayout cl = (CardLayout) MainWindow.cards
								.getLayout();
						cl.show(MainWindow.cards, "ManageContact");
						ManageContactEventHandler.setContactDetails(System
								.getProperty("currentContactID"));

					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

	}

}
