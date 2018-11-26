package com.atc.model;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Empresa empresa;
    private String modality;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Policy> policies = new ArrayList<>();
    private int urbanRCE;
    private int sellVida;
    private int urbanVida;
    private int sellUrbVida;
    @ManyToMany(fetch = FetchType.LAZY)
    private List<Empleado> middlemen = new ArrayList<>();

    public Product() {
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public List<Policy> getPolicies() {
        return policies;
    }

    public void setPolicies(List<Policy> policies) {
        this.policies = policies;
    }

    public int getId() {
        return id;
    }

    public String getModality() {
        return modality;
    }

    public void setModality(String modality) {
        this.modality = modality;
    }

    public int getUrbanRCE() {
        return urbanRCE;
    }

    public void setUrbanRCE(int urbanRCE) {
        this.urbanRCE = urbanRCE;
    }

    public int getSellVida() {
        return sellVida;
    }

    public void setSellVida(int sellVida) {
        this.sellVida = sellVida;
    }

    public int getUrbanVida() {
        return urbanVida;
    }

    public void setUrbanVida(int urbanVida) {
        this.urbanVida = urbanVida;
    }

    public int getSellUrbVida() {
        return sellUrbVida;
    }

    public void setSellUrbVida(int sellUrbVida) {
        this.sellUrbVida = sellUrbVida;
    }

    public Policy getRCE() {
        if(!policies.isEmpty()) {
            for(Policy policy : getPolicies()) {
                if(policy.getBranch().equals("RCE")) {
                    return policy;
                }
            }
        }
        return null;
    }

    public Policy getVida() {
        if(!policies.isEmpty()) {
            for(Policy policy : getPolicies()) {
                if(policy.getBranch().equals("Vida")) {
                    return policy;
                }
            }
        }
        return null;
    }

    public Policy getTransporte() {
        if(!policies.isEmpty()) {
            for(Policy policy : getPolicies()) {
                if(policy.getBranch().equals("Transporte")) {
                    return policy;
                }
            }
        }
        return null;
    }

    public void addPolicy(Policy policy) {
        policies.add(policy);
    }

    public void removePolicy(Policy policy) {
        policies.remove(policy);
    }

    public void addMiddlemen(Empleado empleado) {
        middlemen.add(empleado);
    }

    public void removeMiddlemen(Empleado empleado) {
        middlemen.remove(empleado);
    }

    @Override
    public String toString() {
        return getEmpresa().getNombre() + " (" + getModality() + ")";
    }
}
