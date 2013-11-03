package com.contactmanager.ui.eventhandlers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import com.contactmanager.db.DBQueryExecute;
import com.contactmanager.ui.LoginPanel;
import com.contactmanager.ui.MainWindow;

public class LoginScreenEventHandler implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().toString().contains("Login")) {
			boolean userExists = DBQueryExecute.checkUserName(
					LoginPanel.textFieldUsername.getText(),
					LoginPanel.passwordField.getText());
			if (userExists) {
				// LoginScreen.frame.dispose();
				LoginPanel.textFieldUsername.setText("");
				LoginPanel.passwordField.setText("");
				CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
				cl.show(MainWindow.cards, "Contact");
				LoginPanel.lblErrormsglabel.setVisible(false);
			} else {
				LoginPanel.lblErrormsglabel
						.setText("Invalid username or password");
				LoginPanel.lblErrormsglabel.setVisible(true);
				LoginPanel.passwordField.setText("");
			}
		} else if (e.getSource().toString().contains("Create User")) {
			boolean userExists = DBQueryExecute
					.getUserName(LoginPanel.textFieldNewUserName.getText());
			if (!userExists) {
				try {
					int result = DBQueryExecute.createNewUser(
							LoginPanel.textFieldNewUserName.getText(),
							LoginPanel.passwordFieldNewUser.getText());
					if (result > 0) {
						LoginPanel.lblNewUserMsg.setVisible(true);
						LoginPanel.lblNewUserMsg.setText("User created successfully");
						LoginPanel.textFieldUsername.setFocusable(true);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				LoginPanel.lblNewUserMsg.setText("User name exists.");
				LoginPanel.textFieldNewUserName.setFocusable(true);
			}
		}

	}
}
