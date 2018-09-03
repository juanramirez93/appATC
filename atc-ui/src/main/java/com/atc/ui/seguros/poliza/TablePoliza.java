package com.atc.ui.seguros.poliza;

import com.atc.model.Poliza;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class TablePoliza extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9082596838928975107L;
	private JTable polizaTable;
	private TableModelPoliza model;

	public TablePoliza() {
		initialize();

	}

	private void initialize() {
		this.model = new TableModelPoliza();
		this.polizaTable = new JTable(model);
		this.polizaTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(15, 15, 15, 15));
		add(new JScrollPane(polizaTable), BorderLayout.CENTER);
	}

	public void setTableModel(List<Poliza> polizas) {
		this.model.setPolizaList(polizas);
	}
	
	public Poliza getSelected() {
		if(polizaTable.getSelectedRow() == -1) {
			return null;
		}
		return model.getSelected(polizaTable.getSelectedRow());
	}
	
	public void updateTable() {
		this.model.updateTable();
	}
	
}
