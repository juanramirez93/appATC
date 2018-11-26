package com.atc.ui.insurances.product;
import com.atc.model.Product;
import com.atc.service.ProductService;
import com.atc.ui.abstractUI.CEAbstract;
import com.atc.ui.abstractUI.MainAbstract;
import com.atc.util.NumberConstants;
import com.atc.util.StringsConstants;

public class CEProduct extends CEAbstract<Product> {
    ProductService productService;

    public CEProduct(MainAbstract<Product> parent, Product product) {
        super(parent, StringsConstants.PRODUCT_MENU, product);
        productService = new ProductService();
        setSize(NumberConstants.VECPRODUCT_WIDTH, NumberConstants.VECPRODUCT_HEIGHT);
        setLocationRelativeTo(null);
    }

    @Override
    public void setDataPanel() {
        dataPanel = new DataPanelProduct(t);
    }

    @Override
    public void save() {
        if(dataPanel.saveData()) {
            if(parent != null) {
                parent.refreshTable(productService.getAll());
            }
            this.setVisible(false);
        }
    }
}
