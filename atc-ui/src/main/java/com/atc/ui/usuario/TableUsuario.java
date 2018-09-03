package com.atc.ui.usuario;

import com.atc.model.Usuario;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class TableUsuario extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1118636575068416995L;
	private JTable usuarioTable;
	private TableModelUsuario model;

	public TableUsuario() {
		initialize();

	}

	private void initialize() {
		this.model = new TableModelUsuario();
		this.usuarioTable = new JTable(model);
		this.usuarioTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(15, 15, 15, 15));
		add(new JScrollPane(usuarioTable), BorderLayout.CENTER);
	}

	public void setTableModel(List<Usuario> usuarios) {
		this.model.setUsuarioList(usuarios);
	}
	
	public void updateTable() {
		this.model.updateTable();
	}
	
	public Usuario getSelected() {
		if (usuarioTable.getSelectedRow() == -1) {
			return null;
		}
		return model.getSelected(usuarioTable.getSelectedRow());
	}
}
