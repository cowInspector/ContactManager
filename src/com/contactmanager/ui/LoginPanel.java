package com.contactmanager.ui;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.contactmanager.ui.eventhandlers.LoginScreenEventHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	public static JTextField textFieldUsername;
	public static JPasswordField passwordField;
	public static JLabel lblErrormsglabel;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(105, 79, 81, 27);
		add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(212, 84, 126, 20);
		add(textFieldUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(105, 128, 81, 14);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(212, 127, 126, 20);
		add(passwordField);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new LoginScreenEventHandler());
		buttonLogin.setBounds(107, 170, 89, 23);
		add(buttonLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldUsername.setText("");
				passwordField.setText("");
				LoginPanel.lblErrormsglabel.setVisible(false);
			}
		});
		btnClear.setBounds(212, 170, 89, 23);
		add(btnClear);
		
		lblErrormsglabel = new JLabel("ErrorMsgLabel");
		lblErrormsglabel.setBounds(105, 32, 233, 36);
		lblErrormsglabel.setVisible(false);
		add(lblErrormsglabel);

	}

}
