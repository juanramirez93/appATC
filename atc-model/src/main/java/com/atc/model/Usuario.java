package com.atc.model;

import javax.persistence.*;

@Entity
@Table(name = "USUARIO")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@Column(name = "ID_USUARIO")
	private int id;
	private String user;
	private String password;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_EMPLEADO")
	private Empleado empleado;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_PERMISOS")
	private Permisos permisos;

	public Usuario(String user, String password, Empleado empleado) {
		super();
		this.user = user;
		this.password = password;
		this.empleado = empleado;
	}

	public Usuario() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	public Permisos getPermisos() {
		return permisos;
	}

	public void setPermisos(Permisos permisos) {
		this.permisos = permisos;
	}
	
	@Override
	public String toString() {
		return getUser();
	}
}
