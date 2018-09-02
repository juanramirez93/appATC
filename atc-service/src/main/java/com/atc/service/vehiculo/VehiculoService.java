package com.atc.service.vehiculo;

import java.util.List;

import com.atc.connection.VehiculoEM;
import com.atc.model.Vehiculo;

public class VehiculoService {
	private VehiculoEM vehiculoEM;
	
	public VehiculoService() {
		vehiculoEM = new VehiculoEM();
	}
	
	public void addVehiculo(Vehiculo vehiculo) {
		vehiculoEM.save(vehiculo);
	}
	
	public List<Vehiculo> getAllVehiculos(){
		return vehiculoEM.getAll();
	}
	
	public Vehiculo getVehiculo(String placa) {
		List<Vehiculo> vehiculos = getAllVehiculos();
		for(Vehiculo vehiculo: vehiculos) {
			if(vehiculo.getPlaca().equals(placa)) {
				return vehiculo;
			}
		}
		return null;
	}
	
	public boolean existVehiculo(String placa) {
		return getVehiculo(placa) != null;
	}
	
}
