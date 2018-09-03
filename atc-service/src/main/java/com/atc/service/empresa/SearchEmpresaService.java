package com.atc.service.empresa;

import com.atc.connection.EmpresaEM;
import com.atc.model.Empresa;

import java.util.List;

public class SearchEmpresaService {

	EmpresaEM empresaEM;
	
	public SearchEmpresaService() {
		empresaEM = new EmpresaEM();
	}
	
	public List<Empresa> search(String str) {
		return empresaEM.search(str);
	}
	
}
