package com.atc.ui.insurances.inventory;
import com.atc.model.Inventory;
import com.atc.ui.abstractUI.TableAbstract;
import com.atc.util.StringsConstants;

import javax.swing.table.TableColumnModel;
import java.util.List;

public class TableInventory extends TableAbstract<Inventory> {
    @Override
    protected void setModel() {
        model = new TableModelInventory(StringsConstants.INVENTORY_TABLE_FIELD);
        table.setModel(model);
    }

    @Override
    public void setList(List<Inventory> inventories) {
        model.setList(inventories);
    }

    @Override
    protected void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(100);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(30);
        columnModel.getColumn(3).setPreferredWidth(30);
        columnModel.getColumn(4).setPreferredWidth(30);
    }
}
