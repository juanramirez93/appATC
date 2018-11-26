package com.atc.ui.insurances.product;
import com.atc.model.Product;
import com.atc.ui.abstractUI.TableAbstract;
import com.atc.util.StringsConstants;

import javax.swing.table.TableColumnModel;
import java.util.List;

public class TableProduct extends TableAbstract<Product> {

    @Override
    protected void setColumnLayout() {
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(190);
        columnModel.getColumn(2).setPreferredWidth(100);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(20);
        columnModel.getColumn(5).setPreferredWidth(20);
    }

    @Override
    protected void setModel() {
        model = new TableModelProduct(StringsConstants.PRODUCT_TABLE_FIELDS);
        table.setModel(model);
    }

    @Override
    public void setList(List<Product> products) {
        model.setList(products);
    }
}
