package com.atc.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    private String number;
    private String branch;
    private int cost;
    private int urbanCost;
    private Date startValidity;
    private Date endValidity;
    private int atcCommission;

    @ManyToMany(mappedBy = "policies")
    private Collection<Product> products;

    public Policy() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getUrbanCost() {
        return urbanCost;
    }

    public void setUrbanCost(int urbanCost) {
        this.urbanCost = urbanCost;
    }

    public Date getStartValidity() {
        return startValidity;
    }

    public void setStartValidity(Date startValidity) {
        this.startValidity = startValidity;
    }

    public Date getEndValidity() {
        return endValidity;
    }

    public void setEndValidity(Date endValidity) {
        this.endValidity = endValidity;
    }

    public int getAtcCommission() {
        return atcCommission;
    }

    public void setAtcCommission(int atcCommission) {
        this.atcCommission = atcCommission;
    }

    public String getState() {
        Date now = new Date();
        if(endValidity != null) {
            if(endValidity.before(now)) {
                return "Inactiva";
            } else {
                return "Activa";
            }
        } else {
            return "Indeterminada";
        }
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return number;
    }
}
