package com.atc.service;
import com.atc.connection.ProductoEM;
import com.atc.connection.StockEM;
import com.atc.model.Producto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public enum ProductoService {
    INSTANCE;

    private ProductoEM productoEM = new ProductoEM();
    private StockEM stockEM = new StockEM();

    public void update(Producto producto) {
        productoEM.update(producto);
    }

    public Producto[] getAllProductosActivos(Date date) {
        List<Producto> productos = productoEM.getAll();
        List<Producto> prod = new ArrayList<Producto>();
        for(Producto producto : productos) {
            if(producto.isActive(date)) {
                prod.add(producto);
            }
        }
        Producto[] prodArray = new Producto[prod.size()];
        prodArray = prod.toArray(prodArray);
        System.out.println(Arrays.toString(prodArray));
        return prodArray;
    }

    public String calcularNumeracion(String selectedItem, int parseInt) {
        return stockEM.verNumeracion(selectedItem, parseInt);
    }
}
