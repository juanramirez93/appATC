package com.atc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RCETRANSPORTE")
public class RCEyTransporte extends Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_RCETRANSPORTE")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_RCE")
    private RCE rce;
    @ManyToOne
    @JoinColumn(name = "ID_TRANSPORTE")
    private Transporte transporte;

    public RCEyTransporte() {
    }

    public RCEyTransporte(String modalidad, int urbanos, Empresa empresa, RCE rce,
                          Transporte transporte) {
        super(modalidad, urbanos, empresa, "RCE y transporte");
        this.rce = rce;
        this.transporte = transporte;
    }

    public RCE getRce() {
        return rce;
    }

    public void setRce(RCE rce) {
        this.rce = rce;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    @Override
    public String getState() {
        if(rce.getState().equals("Activa") &&
                transporte.getState().equals("Activa")) {
            return "Activo";
        } else {
            return "Inactivo";
        }
    }

    @Override
    public boolean isActive(Date date) {
        return rce.getFin().after(date) && transporte.getFin().after(date);
    }
}
