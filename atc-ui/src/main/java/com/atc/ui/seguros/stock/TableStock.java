package com.atc.ui.seguros.stock;

import com.atc.model.Stock;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class TableStock extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8649660192973287610L;
	private JTable stockTable;
	private TableModelStock model;

	public TableStock() {
		initialize();

	}

	private void initialize() {
		this.model = new TableModelStock();
		this.stockTable = new JTable(model);
		this.stockTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		setLayout(new BorderLayout());
		setBorder(new EmptyBorder(15, 15, 15, 15));
		add(new JScrollPane(stockTable), BorderLayout.CENTER);
	}

	public void setTableModel(List<Stock> stock) {
		this.model.setStockList(stock);
	}

	public void updateTable() {
		this.model.updateTable();
	}

	public Stock getSelected() {
		if (stockTable.getSelectedRow() == -1) {
			return null;
		}
		return model.getSelected(stockTable.getSelectedRow());
	}
}
