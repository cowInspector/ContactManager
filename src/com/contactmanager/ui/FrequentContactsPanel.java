package com.contactmanager.ui;

import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.contactmanager.db.DBQueryExecute;

public class FrequentContactsPanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public FrequentContactsPanel() {
		String[] columnNames = { "Name" };

		//Object[] data = DBQueryExecute.getFrequentContacts();
		setLayout(null);
		try {
			table = new JTable(DBQueryExecute.getFrequentContacts());
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 134, 590);
		add(scrollPane);

		//scrollPane.setRowHeaderView(table);

		//scrollPane.add(table);
	}
}
