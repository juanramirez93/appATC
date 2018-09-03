package com.atc.service.empleado;

import com.atc.connection.EmpleadoEM;
import com.atc.model.Empleado;

import java.util.List;

public class MainEmpleadoService {

EmpleadoEM empleadoEM;
	
	public MainEmpleadoService() {
		this.empleadoEM = new EmpleadoEM();
	}

	public List<Empleado> getAllEmpleados() {
		return this.empleadoEM.getAll();
	}

	

}
