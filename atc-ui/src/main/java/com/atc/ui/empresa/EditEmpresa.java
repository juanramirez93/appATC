package com.atc.ui.empresa;

import com.atc.app.DialogAbstract;
import com.atc.model.Empresa;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditEmpresa extends DialogAbstract implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5808008066208794203L;
	private JButton guardarButton;

	private DataPanelEmpresa dataPanel;
	private JPanel buttonPanel;

	private MainEmpresa parentM;

	private Empresa empresa;

	public EditEmpresa(MainEmpresa parent, Empresa empresa) {
		super(parent, StringsConstants.EDITAR_AFILIACION);
		this.parentM = parent;
		this.empresa = empresa;
		initializeVariables();
		initializeLayout();
		setSize(NumberConstants.COMPANY_WIDTH, NumberConstants.COMPANY_HEIGHT);
		setLocationRelativeTo(parent);
	}

	private void initializeVariables() {
		buttonPanel = new JPanel();
		guardarButton = new JButton(StringsConstants.SAVE);
		dataPanel = new DataPanelEmpresa(empresa);
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
