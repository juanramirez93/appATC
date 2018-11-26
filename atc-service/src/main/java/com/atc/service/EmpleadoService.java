package com.atc.service;
import com.atc.connection.EmpleadoEM;
import com.atc.model.Empleado;

import java.util.List;

public enum EmpleadoService {
    INSTANCE;

    EmpleadoEM empleadoEM = new EmpleadoEM();

    public List<Empleado> getAll() {
        return empleadoEM.getAll();
    }

    public Empleado[] getAllEmpleados() {
        Empleado[] empleados = new Empleado[getAll().size()];
        empleados = getAll().toArray(empleados);
        return empleados;
    }
}
