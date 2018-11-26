package com.atc.service.seguros.producto;

import com.atc.connection.ProductoEM;
import com.atc.model.Producto;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProductoMainService {

    ProductoEM em;

    public ProductoMainService() {
        em = new ProductoEM();
    }

    public List<Producto> getAllPolizas() {
        List<Producto> productos = em.getAll();
        Collections.sort(productos, new Comparator<Producto>() {
            public int compare(Producto o1, Producto o2) {
                return Boolean.compare(!o1.isActive(new Date()), !o2.isActive(new Date()));
            }
        });
        return productos;
    }
}
