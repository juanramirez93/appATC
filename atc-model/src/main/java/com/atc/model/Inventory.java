package com.atc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;

    private Date date;
    private String product;
    private String detail;
    private int start;
    private int end;
    private int next;
    private int remaining;

    public Inventory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date fecha) {
        this.date = fecha;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String producto) {
        this.product = producto;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detalle) {
        this.detail = detalle;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int inicio) {
        this.start = inicio;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int fin) {
        this.end = fin;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int proximo) {
        this.next = proximo;
    }

    public int getRemaining() {
        return remaining;
    }

    public void setRemaining(int restantes) {
        this.remaining = restantes;
    }
}
