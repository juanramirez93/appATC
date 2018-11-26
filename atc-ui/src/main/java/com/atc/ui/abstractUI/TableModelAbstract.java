package com.atc.ui.abstractUI;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public abstract class TableModelAbstract<T> extends AbstractTableModel {

    private int colCount;
    protected List<T> tList;
    private String[] columns;

    public TableModelAbstract(String[] columns) {
        this.columns = columns;
        this.colCount = columns.length;
        tList = new ArrayList<>();
    }

    public abstract void setList(List<T> ts);

    public abstract Object getValueAt(int rowIndex, int columnIndex);

    public void updateTable() {
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    public T getSelected(int selectedRow) {
        return tList.get(selectedRow);
    }

    @Override
    public int getRowCount() {
        return tList.size();
    }

    public List<T> getList() {
        return tList;
    }
}
