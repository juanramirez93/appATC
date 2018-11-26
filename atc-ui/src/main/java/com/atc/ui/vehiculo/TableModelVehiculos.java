package com.atc.ui.vehiculo;

import com.atc.model.Vehiculo;
import com.atc.ui.abstractUI.TableModelAbstract;

import java.util.ArrayList;
import java.util.List;

public class TableModelVehiculos extends TableModelAbstract<Vehiculo> {

    public TableModelVehiculos(String[] columns) {
        super(columns);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Vehiculo vehiculo = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return vehiculo.getPlaca();
        }
        return null;
    }

    @Override
    public Vehiculo getSelected(int selectedRow) {
        return tList.get(selectedRow);
    }

    @Override
    public void setList(List<Vehiculo> vehiculos) {
        tList = vehiculos;
    }

}
