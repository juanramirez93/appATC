package com.atc.service;
import com.atc.connection.AfiliacionEM;
import com.atc.model.Afiliacion;

import java.util.List;

public enum AfiliacionService {
    INSTANCE;

    private AfiliacionEM afiliacionEM = new AfiliacionEM();

    public List<Afiliacion> search(String str) {
        return afiliacionEM.search(str);
    }

    public List<Afiliacion> getAll() {
        return afiliacionEM.getAll();
    }
}
