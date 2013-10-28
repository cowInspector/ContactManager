package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.contactmanager.ui.LoginScreen;
import com.contactmanager.ui.MainWindow;

public class MainWindowEventListeners implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().toString().contains("Logout")) {
			
			new LoginScreen().setVisible(true);
		}
		//System.out.println(e.getSource());
	}

}
