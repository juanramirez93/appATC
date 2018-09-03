package com.atc.service.seguros.poliza;

import com.atc.connection.PolizaEM;
import com.atc.model.Poliza;

import java.util.List;

public class SearchPolizaService {

	PolizaEM em;

	public SearchPolizaService() {
		em = new PolizaEM();
	}

	public List<Poliza> search(String str) {
		return em.search(str);
	}
}
