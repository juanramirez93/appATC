package com.atc.ui.seguros.commission;
import com.atc.model.ComisionSeguros;
import com.atc.ui.abstractUI.CEAbstract;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class CECommission extends CEAbstract<ComisionSeguros> {

    public CECommission(MainAbstract<ComisionSeguros> parent, ComisionSeguros comisionSeguros) {
        super(parent, StringsConstants.COMMISSION, comisionSeguros);
        setSize(NumberConstants.VECPRODUCT_WIDTH, NumberConstants.VECPRODUCT_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel() {
        dataPanel = new DataPanelCommission(t, (MainCommission) getParent());
    }

    @Override
    public void save() {
        if(dataPanel.saveData()) {
            if(parent != null) {
                MainCommission mainCommission = (MainCommission) parent;
                parent.refreshTable(mainCommission.getProducto().getComisiones());
            }
            this.setVisible(false);
        }
    }
}
