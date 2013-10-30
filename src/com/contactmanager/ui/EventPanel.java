package com.contactmanager.ui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

public class EventPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public EventPanel() {
		setLayout(null);
		
		JLabel lblSearchEvents = new JLabel("Search Events");
		lblSearchEvents.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblSearchEvents.setBounds(10, 11, 137, 22);
		add(lblSearchEvents);

	}
}
