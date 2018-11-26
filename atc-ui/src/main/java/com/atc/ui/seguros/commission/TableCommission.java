package com.atc.ui.seguros.commission;
import com.atc.model.ComisionSeguros;
import com.atc.model.Producto;
import com.atc.ui.abstractUI.TableAbstract;
import com.atc.util.StringsConstants;

import java.util.List;

public class TableCommission extends TableAbstract<ComisionSeguros> {
    private Producto producto;

    public TableCommission(Producto producto) {
        super();
        this.producto = producto;
    }

    @Override
    protected void setModel() {
        model = new TableModelComission(StringsConstants.COMMISSION_INSURANCE_TABLE_FIELDS,
                producto);
        table.setModel(model);
    }

    @Override
    public void setList(List<ComisionSeguros> comisionSeguros) {
        model.setList(comisionSeguros);
    }

    @Override
    protected void setColumnLayout() {
    }
}
