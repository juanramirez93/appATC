package com.atc.ui.afiliacion;
import com.atc.model.Afiliacion;
import com.atc.service.AfiliacionService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import java.awt.event.ActionEvent;
import java.util.List;

public class MainAfiliacion extends MainAbstract<Afiliacion> {

    public MainAfiliacion() {
        super(StringsConstants.AFILICIONES_PANEL);
        refreshTable(AfiliacionService.INSTANCE.getAll());
        setSize(NumberConstants.MAINAFILIACIONES_WIDTH, NumberConstants.MAINAFILIACIONES_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setTable() {
        table = new TableAfiliacion();
    }

    @Override
    protected void setSearch() {
        search = new SearchAfiliacion(this);
    }

    @Override
    public void refreshTable(List<Afiliacion> t) {
        this.table.setList(t);
        this.table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
