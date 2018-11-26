package com.atc.model;

import javax.persistence.*;

@Entity
@Table(name = "COMISION_SEGUROS")
@Inheritance(strategy = InheritanceType.JOINED)
public class ComisionSeguros {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @Column(name = "ID_COMISION")
    private int id;
    @ManyToOne
    @JoinColumn(name = "ID_EMPLEADO")
    private Empleado asesor;
    private int comision;
    private String ramo;
    @ManyToOne
    private Producto producto;

    public ComisionSeguros() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Empleado getAsesor() {
        return asesor;
    }

    public void setAsesor(Empleado asesor) {
        this.asesor = asesor;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getRamo() {
        return ramo;
    }

    public void setRamo(String ramo) {
        this.ramo = ramo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
