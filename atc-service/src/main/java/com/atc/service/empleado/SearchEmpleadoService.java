package com.atc.service.empleado;

import com.atc.connection.EmpleadoEM;
import com.atc.model.Empleado;

import java.util.List;

public class SearchEmpleadoService {

EmpleadoEM empleadoEM;
	
	public SearchEmpleadoService() {
		empleadoEM = new EmpleadoEM();
	}
	
	public List<Empleado> search(String str) {
		return empleadoEM.search(str);
	}
	
}
