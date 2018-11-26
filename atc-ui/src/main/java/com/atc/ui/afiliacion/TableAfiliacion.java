package com.atc.ui.afiliacion;
import com.atc.model.Afiliacion;
import com.atc.ui.abstractUI.TableAbstract;
import com.atc.util.StringsConstants;

import java.util.List;

public class TableAfiliacion extends TableAbstract<Afiliacion> {
    @Override
    protected void setModel() {
        model = new TableModelAfiliacion(StringsConstants.AFILIACION_TABLE_FIELDS);
        table.setModel(model);
    }

    @Override
    public void setList(List<Afiliacion> afiliacions) {
        model.setList(afiliacions);
    }

    @Override
    protected void setColumnLayout() {

    }

}
