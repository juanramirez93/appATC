package com.atc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RCEProduct")
public class RCEProduct extends Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_RCEProduct")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_RCE")
    private RCE rce;

    public RCEProduct() {
    }

    public RCEProduct(String modalidad, int urbanos, Empresa empresa, RCE rce) {
        super(modalidad, urbanos, empresa, "RCE");
        this.rce = rce;
    }

    public RCE getRce() {
        return rce;
    }

    public void setRce(RCE rce) {
        this.rce = rce;
    }

    @Override
    public String getState() {
        if(rce.getState().equals("Activa")) {
            return "Activo";
        } else {
            return "Inactivo";
        }
    }

    @Override
    public boolean isActive(Date date) {
        return rce.getFin().after(date);
    }
}
