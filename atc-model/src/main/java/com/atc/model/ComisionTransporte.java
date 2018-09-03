package com.atc.model;

import javax.persistence.*;

@Entity
@Table(name = "COMISION_TRANSPORTE")
public class ComisionTransporte extends ComisionSeguros {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@Column(name = "ID_COM_TRANSPORTE")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto producto;
	
	public ComisionTransporte() {
		super();
		setRamo("TRANSPORTE");
	}

	

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}

}
