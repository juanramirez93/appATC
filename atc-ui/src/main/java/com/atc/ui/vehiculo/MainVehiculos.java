package com.atc.ui.vehiculo;

import com.atc.model.Vehiculo;
import com.atc.service.vehiculo.VehiculoService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import java.awt.event.ActionEvent;
import java.util.List;

public class MainVehiculos extends MainAbstract<Vehiculo> {

    private VehiculoService service;

    public MainVehiculos() {
        super(StringsConstants.VEHICLES);
        initialize();
        initializeVariables();
        refreshTable(service.getAllVehiculos());
        setVisible(true);
    }

    protected void initialize() {
        setSize(NumberConstants.MAINVEHICULOS_WIDTH, NumberConstants.MAINVEHICULOS_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void initializeVariables() {
        super.initializeVariables();
        service = new VehiculoService();
    }

    @Override
    protected void setTable() {
        table = new TableVehiculos();
    }

    @Override
    protected void setSearch() {
        search = new SearchVehiculos(this);
    }

//    @Override
//    public void refreshTable() {
//        List<Vehiculo> vehiculos = service.getAllVehiculos();
//        this.table.setList(vehiculos);
//        this.table.updateTable();
//    }

    @Override
    public void refreshTable(List<Vehiculo> vehiculos) {
        this.table.setList(vehiculos);
        this.table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
