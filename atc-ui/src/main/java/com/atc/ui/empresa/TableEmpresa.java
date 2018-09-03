package com.atc.ui.empresa;

import com.atc.model.Empresa;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.List;

public class TableEmpresa extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2944990787637616726L;
	private JTable empresasTable;
	private TableModelEmpresa model;
	private JLabel countLabel;
	
	public TableEmpresa() {
		initialize();
	}

	private void initialize() {
		this.model = new TableModelEmpresa();
		this.empresasTable = new JTable(model);
		this.empresasTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.countLabel = new JLabel();
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(15, 15, 15, 15));
		add(new JScrollPane(empresasTable), BorderLayout.CENTER);
		add(countLabel, BorderLayout.SOUTH);
		setColumnLayout();
	}

	private void setColumnLayout() {
		TableColumnModel columnModel = empresasTable.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(250);
		columnModel.getColumn(1).setPreferredWidth(100);
	}

	public void setTableModel(List<Empresa> empresas) {
		this.model.setEmpresaList(empresas);
		this.countLabel.setText("Total registros: " + empresas.size());
	}

	public void updateTable() {
		this.model.updateTable();
	}

	public Empresa getSelected() {
		if (empresasTable.getSelectedRow() == -1) {
			return null;
		}
		return model.getSelected(empresasTable.getSelectedRow());
	}
}
