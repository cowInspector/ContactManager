package com.contactmanager.ui;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;

/**
 * @author Yogeshwara Krishnan
 * 
 * This UI class is a container for ContactSearchPanel and EventsPanel.
 *
 */
public class ContactPanel extends JPanel {

	/**
	 * Create the panel. Add ContactSearchPanel and EventsPanel.
	 */
	public ContactPanel() {
		setPreferredSize(new Dimension(900, 700));
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(296, 0, 89, 23);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "Login");
			}
		});
		setLayout(null);
		add(btnLogout);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBounds(10, 42, 890, 647);
		add(tabbedPane);
		
		ContactSearchPanel csp = new ContactSearchPanel();
		tabbedPane.addTab("Contact Search", null, csp, null);
		EventPanel ep = new EventPanel();
		tabbedPane.addTab("Events", null, ep, null);
	}
}
