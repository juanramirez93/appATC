package com.atc.service.afiliacion;

import com.atc.connection.AfiliacionEM;
import com.atc.model.Afiliacion;

import java.util.List;

public class MainAfiliadoService {

	AfiliacionEM afiliacionEM;

	public MainAfiliadoService() {
		afiliacionEM = new AfiliacionEM();
	}

	public List<Afiliacion> getAllAfiliaciones() {
		return this.afiliacionEM.getAll();
	}

	public List<Afiliacion> getProximosAVencer() {
				return this.afiliacionEM.getProximosAVencer();
	}
	
	public void update(Afiliacion afiliacion) {
		afiliacionEM.update(afiliacion);
	}

}
