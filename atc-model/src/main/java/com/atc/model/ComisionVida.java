package com.atc.model;

import javax.persistence.*;

@Entity
@Table(name = "COMISION_VIDA")
public class ComisionVida extends ComisionSeguros {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@Column(name = "ID_COM_VIDA")
	private int id;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto producto;
	
	public ComisionVida() {
		super();
		setRamo("VIDA");
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
