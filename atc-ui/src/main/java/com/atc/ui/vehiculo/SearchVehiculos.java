package com.atc.ui.vehiculo;

import com.atc.model.Vehiculo;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.ui.abstractUI.SearchAbstract;

import javax.swing.*;
import java.util.List;

public class SearchVehiculos extends SearchAbstract<Vehiculo> {

    public SearchVehiculos(MainAbstract<Vehiculo> parent) {
        super(parent);
    }

    @Override
    public void search() {

    }

    @Override
    protected void setFilterPanel() {

    }

    @Override
    public List<Vehiculo> filter(List<Vehiculo> vehiculos) {
        return null;
    }
}
