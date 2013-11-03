/**
 * 
 */
package com.contactmanager.ui.eventhandlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import com.contactmanager.ui.EventPanel;

/**
 * @author hkrishna
 *
 */
public class EventSearchEventHandler implements ActionListener {

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Vector<String> columnNames = new Vector<String>();
		
		columnNames.add("Col1");
		columnNames.add("Col2");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		Vector<Object> row = new Vector<Object>();
		row.add("Row data1");
		row.add("Row data2");
		data.add(row);
		
		EventPanel.table.setModel(new DefaultTableModel(data, columnNames));
		
		System.out.println(e.getSource());
	}

}
