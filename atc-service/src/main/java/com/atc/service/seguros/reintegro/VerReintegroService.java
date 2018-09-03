package com.atc.service.seguros.reintegro;

import com.atc.connection.EmpleadoEM;
import com.atc.model.Empleado;

import java.util.List;

public class VerReintegroService {

	EmpleadoEM empleadoEM;

	public VerReintegroService() {
		empleadoEM = new EmpleadoEM();
	}

	public Empleado[] getAll() {
		List<Empleado> empleados = empleadoEM.getAll();
		Empleado[] empleadosArray = new Empleado[empleados.size()];
		empleadosArray = empleados.toArray(empleadosArray);
		return empleadosArray;
	}

}
