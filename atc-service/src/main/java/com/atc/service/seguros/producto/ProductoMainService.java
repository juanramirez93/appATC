package com.atc.service.seguros.producto;

import com.atc.connection.ProductoEM;
import com.atc.model.Producto;

import java.util.List;

public class ProductoMainService {

	ProductoEM em;
	
	public ProductoMainService() {
		em = new ProductoEM();
	}
	
	public List<Producto> getAllPolizas() {
		return em.getAll();
	}

}
