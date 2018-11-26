package com.atc.ui.insurances.inventory;
import com.atc.model.Inventory;
import com.atc.service.InventoryService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainInventory extends MainAbstract<Inventory> {
    public MainInventory() {
        super(StringsConstants.MAININVENTARY_TITULO);
        initialize();
    }

    private void initialize() {
        refreshTable(InventoryService.INSTANCE.getAll());
        setSize(NumberConstants.MAININVENTORY_WIDTH, NumberConstants.MAININVENTORY_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setTable() {
        table = new TableInventory();
    }

    @Override
    protected void setSearch() {
        search = new SearchInventory(this);
    }

    @Override
    public void refreshTable(List<Inventory> t) {
        table.setList(t);
        table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addButton)) {
            if(userSession.getPermisos().getStock() % ADD == 0) {
                ceFrame = new CEInventory(this, null);
                ceFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        }
    }
}
