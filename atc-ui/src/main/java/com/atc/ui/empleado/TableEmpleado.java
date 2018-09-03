package com.atc.ui.empleado;

import com.atc.model.Empleado;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class TableEmpleado extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2864251508767304165L;
	private JTable empleadoTable;
	private TableModelEmpleado model;

	public TableEmpleado() {
		initialize();

	}

	private void initialize() {
		this.model = new TableModelEmpleado();
		this.empleadoTable = new JTable(model);
		this.empleadoTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(15, 15, 15, 15));
		add(new JScrollPane(empleadoTable), BorderLayout.CENTER);
	}

	public void setTableModel(List<Empleado> empleados) {
		this.model.setEmpleadoList(empleados);
	}
	
	public void updateTable() {
		this.model.updateTable();
	}
	
	public Empleado getSelected() {
		if (empleadoTable.getSelectedRow() == -1) {
			return null;
		}
		return model.getSelected(empleadoTable.getSelectedRow());
	}
}
