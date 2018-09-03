package com.atc.service.seguros.movimiento;

import com.atc.connection.MovimientoEM;
import com.atc.model.Movimiento;

import java.util.List;

public class MovimientoMainService {
	
	MovimientoEM em;
	
	public MovimientoMainService() {
		em = new MovimientoEM();
	}
	
	public List<Movimiento> getAllMovimientos(){
		return this.em.getAll();
	}

}
