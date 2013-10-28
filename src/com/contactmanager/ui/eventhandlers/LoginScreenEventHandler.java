package com.contactmanager.ui.eventhandlers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.LoginPanel;
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
		
		System.out.println(e.getSource());
		
		boolean userExists = DBQueryExecute.checkUserName(
				LoginPanel.textFieldUsername.getText(),
				LoginPanel.passwordField.getText());

		if (userExists) {
			//LoginScreen.frame.dispose();
			LoginPanel.textFieldUsername.setText("");
			LoginPanel.passwordField.setText("");
			CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
			cl.show(MainWindow.cards, "Contact");
			//MainWindow.cards.
			/*MainWindow mw = new MainWindow();
			mw.setTitle((LoginScreen.textFieldUsername.getText()).toUpperCase() + "'s Contacts");
			mw.setVisible(true);*/
		} else {
			LoginPanel.textFieldUsername.setText("Invalid username or password");
			LoginPanel.passwordField.setText("");
		}

	}
}
