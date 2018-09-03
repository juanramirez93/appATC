package com.atc.service.empresa;

import com.atc.connection.EmpresaEM;
import com.atc.model.Empresa;

import java.util.List;

public class EmpresaService {
	EmpresaEM empresaEM;

	public EmpresaService() {
		empresaEM = new EmpresaEM();
	}

	public void addEmpresa(Empresa empresa) {
		empresaEM.save(empresa);
	}

	public boolean existEmpresa(long nit) {
		return empresaEM.exist(nit);
	}

	public void updateEmpresa(Empresa empresa) {
		empresaEM.update(empresa);
	}
	
	public List<Empresa> getAllEmpresas() {
		return this.empresaEM.getAll();
	}

}
