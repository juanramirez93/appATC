package com.atc.service;
import com.atc.connection.PolizaEM;
import com.atc.model.Poliza;

import java.util.List;

public enum PolizaService {
    INSTANCE;

    private PolizaEM polizaEM = new PolizaEM();

    public List<Poliza> getAllPolizas() {
        return polizaEM.getAll();
    }
}
