package com.atc.ui.seguros.poliza;

import com.atc.model.Poliza;
import com.atc.service.seguros.poliza.SearchPolizaService;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class SearchPoliza extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2264274632530207541L;
	JLabel buscarLabel;
	JTextField buscarField;
	JButton buscarButton;
	JButton deleteButton;
	SearchPolizaService service;
	MainPoliza parent;

	public SearchPoliza(MainPoliza parent) {
		initializeVariables();
		this.parent = parent;
		initializeLayout();
	}

	private void initializeLayout() {
		setLayout(new FlowLayout());
		add(buscarLabel);
		add(buscarField);
		add(buscarButton);
		add(deleteButton);
	}

	private void initializeVariables() {
		service = new SearchPolizaService();
		buscarLabel = new JLabel(StringsConstants.SEARCH);
		buscarField = new JTextField(NumberConstants.POLICY_FIELD);
		buscarButton = new JButton(StringsConstants.SEARCH);
		buscarButton.addActionListener(this);
		deleteButton = new JButton("X");
		deleteButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == buscarButton) {
			List<Poliza> polizas;
			if (buscarField.getText() == "" || buscarField.getText().isEmpty()) {
				parent.refreshTable();
			} else {
				String str = buscarField.getText();
				polizas = service.search(str);
				parent.refreshTable(polizas);
			}

		}else if(e.getSource() == deleteButton) {
			buscarField.setText("");
			parent.refreshTable();
		}
	}

}
