package com.atc.service.afiliacion;

import com.atc.connection.AfiliacionEM;
import com.atc.model.Afiliacion;

import java.util.List;

public class SearchAfiliadoService {

	AfiliacionEM afiliacionEM;

	public SearchAfiliadoService() {
		afiliacionEM = new AfiliacionEM();
	}

	public List<Afiliacion> search(String str) {
		if(str.isEmpty()) {
			return afiliacionEM.getAll();
		}
		return afiliacionEM.search(str);
	}


}
