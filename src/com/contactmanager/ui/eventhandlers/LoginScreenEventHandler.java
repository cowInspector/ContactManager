package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.LoginScreen;
import com.contactmanager.ui.MainWindow;

public class LoginScreenEventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 * String t = LoginScreen.textFieldUsername.getText();
		 * LoginScreen.textFieldUsername
		 * .setText(LoginScreen.passwordField.getText());
		 * LoginScreen.passwordField.setText(t);
		 */

		boolean userExists = DBQueryExecute.checkUserName(
				LoginScreen.textFieldUsername.getText(),
				LoginScreen.passwordField.getText());

		if (userExists) {
			LoginScreen.frame.dispose();
			//System.out.println(System.getProperty("creatorID"));
			MainWindow mw = new MainWindow();
			mw.setTitle((LoginScreen.textFieldUsername.getText()).toUpperCase() + "'s Contacts");
			mw.setVisible(true);
		} else {
			LoginScreen.textFieldUsername.setText("Invalid username or password");
			LoginScreen.passwordField.setText("");
		}

	}
}
