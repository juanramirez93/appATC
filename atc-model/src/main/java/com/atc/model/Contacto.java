package com.atc.model;

import javax.persistence.*;

@Entity
@Table(name = "CONTACTOS")
public class Contacto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@Column(name = "ID_CONTACTO")
	private int id;
	private String cedula;
	private String nombres;
	private String apellidos;
	private String telefono;
	private String celular;
	private String otroTel;
	private String email;

	public Contacto() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getOtroTel() {
		return otroTel;
	}

	public void setOtroTel(String otroTel) {
		this.otroTel = otroTel;
	}
}
