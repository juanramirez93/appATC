package com.atc.ui.insurances.product;
import com.atc.model.Product;
import com.atc.ui.abstractUI.TableModelAbstract;

import java.util.List;

public class TableModelProduct extends TableModelAbstract<Product> {
    public TableModelProduct(String[] columns) {
        super(columns);
    }

    @Override
    public void setList(List<Product> products) {
        tList = products;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = tList.get(rowIndex);
        switch(columnIndex) {
            case 0:
                return product.getEmpresa().getNit();
            case 1:
                return product.getEmpresa().getNombre();
            case 2:
                return product.getModality();
            case 3:
                return product.getVida() != null;
            case 4:
                return product.getRCE() != null;
            case 5:
                return product.getTransporte() != null;
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 3 || columnIndex == 4 || columnIndex == 5) return Boolean.class;
        return Object.class;
    }
}
