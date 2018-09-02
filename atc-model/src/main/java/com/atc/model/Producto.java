package com.atc.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@Column(name = "ID_PRODUCTO")
	private int id;
	protected String modalidad;
	protected int urbanos;
	@ManyToOne
	@JoinColumn(name = "ID_EMPRESA")
	protected Empresa empresa;
	protected String tipo;
	protected int urbanoVida;
	protected int urbanoRCE;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<ComisionRCE> comisionRCE;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<ComisionVida> comisionVida;
	@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
	protected List<ComisionTransporte> comisionTransporte;

	public int getUrbanoVida() {
		return urbanoVida;
	}

	public void setUrbanoVida(int urbanoVida) {
		this.urbanoVida = urbanoVida;
	}

	public int getUrbanoRCE() {
		return urbanoRCE;
	}

	public void setUrbanoRCE(int urbanoRCE) {
		this.urbanoRCE = urbanoRCE;
	}

	public Producto() {
	}

	public Producto(String modalidad, int urbanos, Empresa empresa, String tipo) {
		this.modalidad = modalidad;
		this.urbanos = urbanos;
		this.empresa = empresa;
		this.tipo = tipo;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public int getUrbanos() {
		return urbanos;
	}

	public void setUrbanos(int urbanos) {
		this.urbanos = urbanos;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String nombre;
		if (empresa.getSiglas().isEmpty()) {
			nombre = empresa.getRazonSocial();
		} else {
			nombre = empresa.getSiglas();
		}
		return nombre + " (" + tipo + ")";
	}

	public List<ComisionRCE> getComisionRCE() {
		return comisionRCE;
	}

	public void setComisionRCE(List<ComisionRCE> comisionRCE) {
		this.comisionRCE = comisionRCE;
	}

	public List<ComisionVida> getComisionVida() {
		return comisionVida;
	}

	public void setComisionVida(List<ComisionVida> comisionVida) {
		this.comisionVida = comisionVida;
	}

	public List<ComisionTransporte> getComisionTransporte() {
		return comisionTransporte;
	}

	public void setComisionTransporte(List<ComisionTransporte> comisionTransporte) {
		this.comisionTransporte = comisionTransporte;
	}

	
}
