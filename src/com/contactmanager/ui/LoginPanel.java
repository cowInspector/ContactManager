package com.contactmanager.ui;

import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import com.contactmanager.ui.eventhandlers.LoginScreenEventHandler;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPanel extends JPanel {
	public static JTextField textFieldUsername;
	public static JPasswordField passwordField;
	public static JLabel lblErrormsglabel;
	public static JTextField textFieldNewUserName;
	public static JPasswordField passwordFieldNewUser;
	public static JLabel lblNewUserMsg;

	/**
	 * Create the panel.
	 */
	public LoginPanel() {
		setLayout(null);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(212, 79, 81, 27);
		add(lblUsername);
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		textFieldUsername.setBounds(345, 84, 126, 20);
		add(textFieldUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(212, 128, 81, 14);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(345, 127, 126, 20);
		add(passwordField);
		
		JButton buttonLogin = new JButton("Login");
		buttonLogin.addActionListener(new LoginScreenEventHandler());
		buttonLogin.setBounds(249, 170, 89, 23);
		add(buttonLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldUsername.setText("");
				passwordField.setText("");
				LoginPanel.lblErrormsglabel.setVisible(false);
			}
		});
		btnClear.setBounds(382, 170, 89, 23);
		add(btnClear);
		
		lblErrormsglabel = new JLabel("ErrorMsgLabel");
		lblErrormsglabel.setBounds(249, 37, 233, 36);
		lblErrormsglabel.setVisible(false);
		add(lblErrormsglabel);
		
		JPanel panelNewUser = new JPanel();
		panelNewUser.setBounds(105, 236, 523, 172);
		add(panelNewUser);

		TitledBorder newUserTitle = BorderFactory.createTitledBorder("New User");
		panelNewUser.setBorder(newUserTitle);
		panelNewUser.setLayout(null);
		
		JLabel lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(118, 27, 62, 26);
		panelNewUser.add(lblUsername_1);
		
		textFieldNewUserName = new JTextField();
		textFieldNewUserName.setBounds(220, 30, 151, 20);
		panelNewUser.add(textFieldNewUserName);
		textFieldNewUserName.setColumns(10);
		
		JLabel lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(118, 64, 62, 14);
		panelNewUser.add(lblPassword_1);
		
		passwordFieldNewUser = new JPasswordField();
		passwordFieldNewUser.setBounds(220, 61, 151, 20);
		panelNewUser.add(passwordFieldNewUser);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.addActionListener(new LoginScreenEventHandler());
		btnCreateUser.setBounds(118, 103, 108, 23);
		panelNewUser.add(btnCreateUser);
		
		lblNewUserMsg = new JLabel("New label");
		lblNewUserMsg.setVisible(false);
		lblNewUserMsg.setBounds(118, 137, 295, 24);
		panelNewUser.add(lblNewUserMsg);
		
		JButton btnClearNewUser = new JButton("Clear");
		btnClearNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNewUserName.setText("");
				passwordFieldNewUser.setText("");
				lblNewUserMsg.setText("");
				lblNewUserMsg.setVisible(false);
			}
		});
		btnClearNewUser.setBounds(282, 103, 89, 23);
		panelNewUser.add(btnClearNewUser);
		
	}
}
