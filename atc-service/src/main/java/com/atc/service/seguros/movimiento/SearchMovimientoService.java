package com.atc.service.seguros.movimiento;

import com.atc.connection.MovimientoEM;
import com.atc.model.Movimiento;

import java.util.List;

public class SearchMovimientoService {

	MovimientoEM movimientoEM;

	public SearchMovimientoService() {
		movimientoEM = new MovimientoEM();
	}

	public List<Movimiento> search(String str) {
		return movimientoEM.search(str);
	}

}
