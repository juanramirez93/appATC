package com.atc.service.seguros.producto;

import com.atc.connection.ProductoEM;
import com.atc.model.Producto;

import java.util.List;

public class SearchProductoService {

	ProductoEM em;

	public SearchProductoService() {
		em = new ProductoEM();
	}

	public List<Producto> search(String str) {
		return em.search(str);
	}

}
