package com.atc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "COMISION_RCE")
public class ComisionRCE extends ComisionSeguros {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@Column(name = "ID_COM_RCE")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto producto;
	public ComisionRCE() {
		super();
		setRamo("RCE");
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}