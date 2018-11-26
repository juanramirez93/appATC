package com.atc.service;
import com.atc.connection.MovimientoEM;
import com.atc.connection.StockEM;
import com.atc.model.Movimiento;
import com.atc.model.Producto;

public enum MovimientoService {
    INSTANCE;

    private MovimientoEM movimientoEM = new MovimientoEM();
    private StockEM stockEM = new StockEM();

    public void updateMovimiento(Movimiento movimiento) {
        movimientoEM.update(movimiento);
    }

    public void setStockNew(Producto selectedItem, int cantidad) {
        stockEM.setNumeracion(selectedItem.getTipo(), cantidad);
    }
}
