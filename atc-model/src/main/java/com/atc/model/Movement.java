package com.atc.model;
import javax.persistence.*;
import java.util.Date;

@Entity
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private int id;
    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
    private Date date;
    private String type;
    private int quantity;
    private String numeration;
    private String factVida;
    private Date payVida;
    private String recibo;
    private String remRCE;
    private String factRCE;
    private Date payRCE;
    private String remTransporte;
    private String factTransp;
    private Date payTransporte;

    public Movement() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getNumeration() {
        return numeration;
    }

    public void setNumeration(String numeration) {
        this.numeration = numeration;
    }

    public String getFactVida() {
        return factVida;
    }

    public void setFactVida(String factVida) {
        this.factVida = factVida;
    }

    public Date getPayVida() {
        return payVida;
    }

    public void setPayVida(Date payVida) {
        this.payVida = payVida;
    }

    public String getRecibo() {
        return recibo;
    }

    public void setRecibo(String recibo) {
        this.recibo = recibo;
    }

    public String getRemRCE() {
        return remRCE;
    }

    public void setRemRCE(String remRCE) {
        this.remRCE = remRCE;
    }

    public String getFactRCE() {
        return factRCE;
    }

    public void setFactRCE(String factRCE) {
        this.factRCE = factRCE;
    }

    public Date getPayRCE() {
        return payRCE;
    }

    public void setPayRCE(Date payRCE) {
        this.payRCE = payRCE;
    }

    public String getRemTransporte() {
        return remTransporte;
    }

    public void setRemTransporte(String remTransporte) {
        this.remTransporte = remTransporte;
    }

    public String getFactTransp() {
        return factTransp;
    }

    public void setFactTransp(String factTransp) {
        this.factTransp = factTransp;
    }

    public Date getPayTransporte() {
        return payTransporte;
    }

    public void setPayTransporte(Date payTransporte) {
        this.payTransporte = payTransporte;
    }
}
