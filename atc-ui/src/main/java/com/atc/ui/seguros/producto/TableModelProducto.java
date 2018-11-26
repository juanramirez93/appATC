package com.atc.ui.seguros.producto;

import com.atc.model.Producto;
import com.atc.util.StringsConstants;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelProducto extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = -2540503637089672579L;
    private List<Producto> productos;
    private String[] columns = StringsConstants.PRODUCT_FIELDS;

    public TableModelProducto() {
        this.productos = new ArrayList<>();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public int getRowCount() {
        return this.productos.size();
    }

    public Object getValueAt(int arg0, int arg1) {
        Producto producto = productos.get(arg0);
        switch(arg1) {
            case 0:
                return producto.getEmpresa().getNombre();
            case 1:
                return producto.getModalidad();
            case 2:
                return producto.getTipo();
            case 3:
                return producto.getState();
        }
        return null;
    }

    public void setProductoList(List<Producto> productos) {
        this.productos = productos;
    }

    public void updateTable() {
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int arg0) {
        return this.columns[arg0];
    }

    public Producto getSelected(int selectedRow) {
        return productos.get(selectedRow);
    }
}
