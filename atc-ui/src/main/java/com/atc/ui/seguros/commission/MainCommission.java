package com.atc.ui.seguros.commission;
import com.atc.model.ComisionSeguros;
import com.atc.model.Producto;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import java.awt.event.ActionEvent;
import java.util.List;

public class MainCommission extends MainAbstract<ComisionSeguros> {
    private Producto producto;

    public MainCommission(Producto producto) {
        super(StringsConstants.COMMISSION);
        this.producto = producto;
        initialize();
    }

    private void initialize() {
        refreshTable(producto.getComisiones());
        setSize(NumberConstants.MAINCOMMISSION_WIDTH, NumberConstants.MAINCOMMISSION_HEIGHT);
        setLocationRelativeTo(null);
    }

    public Producto getProducto() {
        return producto;
    }

    @Override
    protected void setTable() {
        table = new TableCommission(producto);
    }

    @Override
    protected void setSearch() {
    }

    @Override
    public void refreshTable(List<ComisionSeguros> t) {
        this.table.setList(t);
        this.table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addButton)) {
            if(ceFrame != null) {
                ceFrame.dispose();
            }
            ceFrame = new CECommission(this, null);
            ceFrame.setVisible(true);
        }
    }
}
