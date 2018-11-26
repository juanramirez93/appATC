package com.atc.ui.afiliacion;
import com.atc.model.Afiliacion;
import com.atc.service.AfiliacionService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.ui.abstractUI.SearchAbstract;

import java.util.List;

public class SearchAfiliacion extends SearchAbstract<Afiliacion> {
    public SearchAfiliacion(MainAbstract<Afiliacion> parent) {
        super(parent);
    }

    @Override
    public void search() {
        List<Afiliacion> afiliaciones;
        if(searchField.getText().equals("") || searchField.getText().isEmpty()) {
            afiliaciones = AfiliacionService.INSTANCE.getAll();
        } else {
            String str = searchField.getText();
            afiliaciones = AfiliacionService.INSTANCE.search(str);
        }
        if(filterPanel != null) {
            afiliaciones = filter(afiliaciones);
        }
        parent.refreshTable(afiliaciones);
    }

    @Override
    protected void setFilterPanel() {
        filterPanel = new FilterAfiliacion(this);
    }

    @Override
    public List<Afiliacion> filter(List<Afiliacion> afiliacions) {
        return null;
    }
}
