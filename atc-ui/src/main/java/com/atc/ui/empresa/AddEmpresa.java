package com.atc.ui.empresa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.atc.app.DialogAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class AddEmpresa extends DialogAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8336420173700572247L;
	private JButton guardarButton;

	private JPanel buttonPanel;
	private DataPanelEmpresa dataPanel;

	private MainEmpresa parentM;

	public AddEmpresa(MainEmpresa parent) {
		super(parent, StringsConstants.AGREGAR_EMPRESA);
		this.parentM = parent;
		initializeVariables();
		initializeLayout();
		setSize(NumberConstants.COMPANY_WIDTH, NumberConstants.COMPANY_HEIGHT);
		setLocationRelativeTo(null);
		setAlwaysOnTop(true);
	}

	private void initializeVariables() {

		buttonPanel = new JPanel();
		guardarButton = new JButton(StringsConstants.SAVE);
		dataPanel = new DataPanelEmpresa();

	}

	private void initializeLayout() {
		setLayout(new BorderLayout());
		

		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(guardarButton);

		add(dataPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);

		guardarButton.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		Object event = e.getSource();

		if (event == guardarButton) {
			guardarEmpresa();

		}

	}

	private void guardarEmpresa() {
		dataPanel.guardarEmpresa();
		if (parentM != null) {
			parentM.refreshTable();
		}
		this.dispose();
	}
}
