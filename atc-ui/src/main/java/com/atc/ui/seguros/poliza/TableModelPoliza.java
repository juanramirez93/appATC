package com.atc.ui.seguros.poliza;

import com.atc.model.Poliza;
import com.atc.util.StringsConstants;

import javax.swing.table.AbstractTableModel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class TableModelPoliza extends AbstractTableModel {

    /**
     *
     */
    private static final long serialVersionUID = -1617666233866562943L;
    private DecimalFormat formatMoney = new DecimalFormat("$#,###");

    private List<Poliza> polizas;
    private String[] columns = StringsConstants.POLICIES_TABLE_FIELDS;

    public TableModelPoliza() {
        this.polizas = new ArrayList<>();
    }

    public int getColumnCount() {
        return columns.length;
    }

    public int getRowCount() {
        return this.polizas.size();
    }

    public Object getValueAt(int arg0, int arg1) {
        Poliza poliza = polizas.get(arg0);
        switch(arg1) {
            case 0:
                return poliza.getNumero();
            case 1:
                return poliza.getRamo();
            case 2:
                return formatMoney.format(poliza.getValor());
            case 3:
                return poliza.getState();
        }
        return null;
    }

    public void setPolizaList(List<Poliza> polizas) {
        this.polizas = polizas;
    }

    public void updateTable() {
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int arg0) {
        return this.columns[arg0];
    }

    public Poliza getSelected(int selectedRow) {
        return polizas.get(selectedRow);
    }
}
