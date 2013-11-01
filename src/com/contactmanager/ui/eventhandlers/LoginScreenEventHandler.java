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

		boolean userExists = DBQueryExecute.checkUserName(
				LoginPanel.textFieldUsername.getText(),
				LoginPanel.passwordField.getText());

		if (userExists) {
			//LoginScreen.frame.dispose();
			LoginPanel.textFieldUsername.setText("");
			LoginPanel.passwordField.setText("");
			CardLayout cl = (CardLayout) MainWindow.cards.getLayout();
			cl.show(MainWindow.cards, "Contact");
			LoginPanel.lblErrormsglabel.setVisible(false);
		} else {
			LoginPanel.lblErrormsglabel.setText("Invalid username or password");
			LoginPanel.lblErrormsglabel.setVisible(true);
			LoginPanel.passwordField.setText("");
		}

	}
}
