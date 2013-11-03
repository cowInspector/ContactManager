package com.contactmanager.ui;

/**
 * 
 * MainWindow.java
 *
 **/
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainWindow {
    public static JPanel cards; //a panel that uses CardLayout
    //public static ManageContactPanel manageContactPanel;
    
    public void addComponentToPane(Container pane) {
        
        //Create the panel that contains the "cards".
        cards = new JPanel(new CardLayout());
        LoginPanel loginPanel = new LoginPanel();
        loginPanel.setBorder(null);
        cards.add(loginPanel,"Login");
        loginPanel.setBounds(100, 0, 15, 100);
        ContactPanel contactPanel = new ContactPanel();
        cards.add(contactPanel,"Contact");
        AddContactPanel addContactPanel = new AddContactPanel();
        cards.add(addContactPanel,"AddContact");
        //manageContactPanel = new ManageContactPanel();
        //cards.add(manageContactPanel, "ManageContact");
        AddEventDetails addEventDetails = new AddEventDetails();
        cards.add(addEventDetails, "AddEvent");
        pane.add(cards, BorderLayout.CENTER);
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Contact Manager");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create and set up the content pane.
        MainWindow demo = new MainWindow();
        demo.addComponentToPane(frame.getContentPane());
        
        //Display the window.
        frame.setSize(792, 750);;
        frame.setVisible(true);
    }
    
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
        
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}
