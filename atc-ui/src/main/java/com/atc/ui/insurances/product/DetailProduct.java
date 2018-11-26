package com.atc.ui.insurances.product;
import com.atc.model.Product;
import com.atc.ui.abstractUI.DetailAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class DetailProduct extends DetailAbstract<Product> {

    public DetailProduct(MainProduct mainProduct, Product product) {
        super(mainProduct, StringsConstants.PRODUCT_MENU);
        setSize(NumberConstants.DETAILPRODUCT_WIDTH, NumberConstants.DETAILPRODUCT_HEIGHT);
        setLocationRelativeTo(null);
        data = product;
        setLabelArray();
        setComponentArray();
        setDataPanel();
    }

    @Override
    public void setLabelArray() {
        labelArray = StringsConstants.PRODUCT_FIELDS;
    }

    @Override
    public void setComponentArray() {
        componentArray.add(String.valueOf(data.getEmpresa().getNit()));
        componentArray.add(data.getEmpresa().getNombre());
        componentArray.add(data.getModality());
        componentArray.add(data.getPolicies().toString());
    }

    @Override
    public void edit() {
    }
}
