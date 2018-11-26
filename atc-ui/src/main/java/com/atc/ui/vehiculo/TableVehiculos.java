package com.atc.ui.vehiculo;

import com.atc.model.Vehiculo;
import com.atc.ui.abstractUI.TableAbstract;

import java.util.List;

public class TableVehiculos extends TableAbstract<Vehiculo> {

    @Override
    public Vehiculo getSelected() {
        if(table.getSelectedRow() == -1) {
            return null;
        }
        return (Vehiculo) model.getSelected(table.getSelectedRow());
    }

    @Override
    protected void setModel() {
        model = new TableModelVehiculos(new String[]{
                "Placa"
        });
        table.setModel(model);
    }

    @Override
    public void setList(List<Vehiculo> vehiculos) {
        model.setList(vehiculos);
    }

    @Override
    protected void setColumnLayout() {
    }
}
