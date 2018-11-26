package com.atc.service.empresa;

import com.atc.connection.EmpresaEM;
import com.atc.model.Empresa;

import java.util.ArrayList;
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

    public List<String> getNits() {
        List<String> list = new ArrayList<String>();
        for(Empresa empresa : getAllEmpresas()
        ) {
            list.add(String.valueOf(empresa.getNit()));
        }
        return list;
    }

    public String[] getAllNits() {
        List<Empresa> empresas = getAllEmpresas();
        String[] nits = new String[empresas.size()];
        int i = 0;
        for(Empresa empresa : empresas) {
            nits[i] = String.valueOf(empresa.getNit());
            i++;
        }
        return nits;
    }

    public Empresa findByNit(long nit) {
        return empresaEM.getEmpresaByNit(nit);
    }
}
