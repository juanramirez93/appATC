package com.atc.ui.insurances.inventory;
import com.atc.model.Inventory;
import com.atc.service.InventoryService;
import com.atc.ui.abstractUI.CEAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class CEInventory extends CEAbstract<Inventory> {
    public CEInventory(MainInventory parent, Inventory inventory) {
        super(parent, StringsConstants.MAININVENTARY_TITULO, inventory);
        setSize(NumberConstants.CEINVENTORY_WIDTH, NumberConstants.CEINVENTORY_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel() {
        dataPanel = new DataPanelInventory(t);
    }

    @Override
    public void save() {
        if(dataPanel.saveData()) {
            if(parent != null) {
                parent.refreshTable(InventoryService.INSTANCE.getAll());
            }
            this.setVisible(false);
        }
    }
}
