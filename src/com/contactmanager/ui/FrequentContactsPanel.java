package com.contactmanager.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.contactmanager.db.DBQueryExecute;

/**
 * @author Yogeshwara Krishnan
 * 
 * THIS CLASS IS USED NOWHERE. DON'T BOTHER YOURSELVES.
 *
 */
public class FrequentContactsPanel extends JPanel {
	private JTable table;
	private JTextField textFieldPhNo;
	private JTextField textFieldPhType;

	/**
	 * Create the panel.
	 */
	public FrequentContactsPanel() {
		String[] columnNames = { "Name" };

		// Object[] data = DBQueryExecute.getFrequentContacts();
		setLayout(null);
		try {
			table = new JTable(DBQueryExecute.getFrequentContacts());
			table.removeColumn(table.getColumnModel().getColumn(0));
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(final MouseEvent e) {
					if (e.getClickCount() == 1) {
						final JTable target = (JTable) e.getSource();
						final int row = target.getSelectedRow();
						System.setProperty("FrequentContactID", (table
								.getModel().getValueAt(
								table.convertRowIndexToModel(row), 0))
								.toString());
					}
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
		}

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 134, 590);
		add(scrollPane);
		
		JPanel panelPhoneDetails = new JPanel();
		TitledBorder title;
		title = BorderFactory.createTitledBorder("Phone Details");
		panelPhoneDetails.setBorder(title);
		panelPhoneDetails.setBounds(144, 22, 491, 250);
		add(panelPhoneDetails);
		panelPhoneDetails.setLayout(null);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(10, 24, 82, 14);
		panelPhoneDetails.add(lblPhoneNumber);
		
		textFieldPhNo = new JTextField();
		textFieldPhNo.setEditable(false);
		textFieldPhNo.setBounds(102, 21, 144, 20);
		panelPhoneDetails.add(textFieldPhNo);
		textFieldPhNo.setColumns(10);
		
		JLabel lblPhoneType = new JLabel("Phone Type");
		lblPhoneType.setBounds(256, 24, 71, 14);
		panelPhoneDetails.add(lblPhoneType);
		
		textFieldPhType = new JTextField();
		textFieldPhType.setEditable(false);
		textFieldPhType.setBounds(337, 21, 86, 20);
		panelPhoneDetails.add(textFieldPhType);
		textFieldPhType.setColumns(10);
	}
}
