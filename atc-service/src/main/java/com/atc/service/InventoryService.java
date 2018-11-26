package com.atc.service;
import com.atc.connection.InventoryEM;
import com.atc.model.Inventory;

import java.util.List;

public enum InventoryService {
    INSTANCE;

    InventoryEM inventoryEM = new InventoryEM();

    public String calculateNumeration(Object selectedItem, int parseInt) {
        return inventoryEM.getNumeration((String) selectedItem, parseInt);
    }

    public void update(Inventory data) {
        inventoryEM.update(data);
    }

    public List<Inventory> getAll() {
        return inventoryEM.getAll();
    }

    public List<Inventory> search(String str) {
        return inventoryEM.search(str);
    }
}
