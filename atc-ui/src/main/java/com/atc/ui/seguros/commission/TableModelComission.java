package com.atc.ui.seguros.commission;
import com.atc.model.ComisionSeguros;
import com.atc.model.Producto;
import com.atc.ui.abstractUI.TableModelAbstract;

import java.util.List;

public class TableModelComission extends TableModelAbstract<ComisionSeguros> {
    Producto producto;

    public TableModelComission(String[] columns, Producto producto) {
        super(columns);
        this.producto = producto;
    }

    @Override
    public void setList(List<ComisionSeguros> comisionSeguros) {
        tList = comisionSeguros;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ComisionSeguros comisionSeguros = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return comisionSeguros.getAsesor().getAbreviatura();
            case 1:
                return comisionSeguros.getRamo();
            case 2:
                return comisionSeguros.getComision();
        }
        return null;
    }
}
