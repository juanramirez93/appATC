package com.atc.ui.afiliacion;
import com.atc.model.Afiliacion;
import com.atc.ui.abstractUI.TableModelAbstract;

import java.util.Date;
import java.util.List;

public class TableModelAfiliacion extends TableModelAbstract<Afiliacion> {
    public TableModelAfiliacion(String[] columns) {
        super(columns);
    }

    @Override
    public void setList(List<Afiliacion> afiliaciones) {
        tList = afiliaciones;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Afiliacion afiliacion = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return afiliacion.getFechaAfiliacion();
            case 1:
                return afiliacion.getAfiliado().getIdentificacion();
            case 2:
                return afiliacion.getAfiliado().getNombre();
            case 3:
                return afiliacion.getEstado();
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0) return Date.class;
        return Object.class;
    }
}
