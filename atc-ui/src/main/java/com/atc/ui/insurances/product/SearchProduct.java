package com.atc.ui.insurances.product;
import com.atc.model.Product;
import com.atc.service.ProductService;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.ui.abstractUI.SearchAbstract;

import java.util.ArrayList;
import java.util.List;

public class SearchProduct extends SearchAbstract<Product> {

    ProductService productService;

    public SearchProduct(MainAbstract<Product> parent) {
        super(parent);
        productService = new ProductService();
    }

    @Override
    public void search() {
        List<Product> products;
        if(searchField.getText().equals("") || searchField.getText().isEmpty()) {
            products = productService.getAll();
        } else {
            String str = searchField.getText();
            products = productService.search(str);
        }
        if(filterPanel != null) {
            products = filter(products);
        }
        parent.refreshTable(products);
    }

    @Override
    protected void setFilterPanel() {
        filterPanel = new FilterProduct(this);
    }

    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> newProducts = new ArrayList<>();
        for(Product product : products) {
            if(filterPanel.getCheckBoxes().get(0).isSelected() && product.getVida() != null) {
                newProducts.add(product);
            }
            if(filterPanel.getCheckBoxes().get(1).isSelected() && product.getRCE() != null) {
                newProducts.add(product);
            }
            if(filterPanel.getCheckBoxes().get(2).isSelected() && product.getTransporte() != null) {
                newProducts.add(product);
            }
        }
        return newProducts;
    }
}
