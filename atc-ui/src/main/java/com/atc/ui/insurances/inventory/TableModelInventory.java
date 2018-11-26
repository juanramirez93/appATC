package com.atc.ui.insurances.inventory;
import com.atc.model.Inventory;
import com.atc.ui.abstractUI.TableModelAbstract;

import java.util.List;

public class TableModelInventory extends TableModelAbstract<Inventory> {
    public TableModelInventory(String[] columns) {
        super(columns);
    }

    @Override
    public void setList(List<Inventory> inventories) {
        tList = inventories;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Inventory inventory = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return inventory.getDate();
            case 1:
                return inventory.getProduct();
            case 2:
                return inventory.getStart();
            case 3:
                return inventory.getEnd();
            case 4:
                return inventory.getNext();
            case 5:
                return inventory.getRemaining();
        }
        return null;
    }
}
