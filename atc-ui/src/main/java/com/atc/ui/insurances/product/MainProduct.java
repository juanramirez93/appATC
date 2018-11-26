package com.atc.ui.insurances.product;
import com.atc.model.Product;
import com.atc.service.ProductService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class MainProduct extends MainAbstract<Product> {

    ProductService productService;

    public MainProduct() {
        super(StringsConstants.PRODUCT_MENU);
        initialize();
    }

    private void initialize() {
        this.productService = new ProductService();
        refreshTable(productService.getAll());
        setSize(NumberConstants.MAINPRODUCT_WIDTH, NumberConstants.MAINPRODUCT_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    protected void setTable() {
        table = new TableProduct();
    }

    @Override
    protected void setSearch() {
        search = new SearchProduct(this);
    }

    @Override
    public void refreshTable(List<Product> t) {
        this.table.setList(t);
        this.table.updateTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(addButton)) {
            if(userSession.getPermisos().getPoliza() % ADD == 0) {
                ceFrame = new CEProduct(this, null);
                ceFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, StringsConstants.NOT_PERMIT);
            }
        }
    }
}
