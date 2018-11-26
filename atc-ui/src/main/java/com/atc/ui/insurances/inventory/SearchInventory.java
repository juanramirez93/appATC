package com.atc.ui.insurances.inventory;
import com.atc.model.Inventory;
import com.atc.service.InventoryService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.ui.abstractUI.SearchAbstract;

import java.util.List;

public class SearchInventory extends SearchAbstract<Inventory> {
    public SearchInventory(MainAbstract<Inventory> parent) {
        super(parent);
    }

    @Override
    public void search() {
        List<Inventory> inventories;
        if(searchField.getText().equals("") || searchField.getText().isEmpty()) {
            inventories = InventoryService.INSTANCE.getAll();
        } else {
            String str = searchField.getText();
            inventories = InventoryService.INSTANCE.search(str);
        }
        if(filterPanel != null) {
            inventories = filter(inventories);
        }
        parent.refreshTable(inventories);
    }

    @Override
    protected void setFilterPanel() {
    }

    @Override
    public List<Inventory> filter(List<Inventory> inventories) {
        return null;
    }
}
