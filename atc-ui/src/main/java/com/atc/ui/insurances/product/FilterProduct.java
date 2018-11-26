package com.atc.ui.insurances.product;
import com.atc.model.Product;
import com.atc.service.ProductService;
import com.atc.ui.abstractUI.FilterAbstract;
import com.atc.ui.abstractUI.SearchAbstract;
import com.atc.util.StringsConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class FilterProduct extends FilterAbstract<Product> {

    private ProductService productService;

    public FilterProduct(SearchAbstract<Product> mainParent) {
        super(mainParent);
        productService = new ProductService();
    }

    @Override
    protected void setCheckBoxes() {
        for(String option : StringsConstants.FILTER_OPTIONS_PRODUCT) {
            JCheckBox checkBox = new JCheckBox(option);
            checkBox.setSelected(true);
            checkBoxes.add(checkBox);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        mainParent.search();
    }
}
