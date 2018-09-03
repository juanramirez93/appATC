package com.atc.service.stock;

import com.atc.connection.StockEM;
import com.atc.model.Stock;

import java.util.List;

public class MainStockService {
	StockEM stockEM;

	public MainStockService() {
		this.stockEM = new StockEM();
	}

	public List<Stock> getAllInventario() {
		return this.stockEM.getAll();
	}
}
