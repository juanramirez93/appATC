package com.atc.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MOVIMIENTO")
public class Movimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@Column(name = "ID_MOVIMIENTO")
	private int id;

	private Date fecha;
	@ManyToOne
	@JoinColumn(name = "ID_PRODUCTO")
	private Producto producto;
	private int cantidad;
	private String numeracion;
	private int mesFechaReporte;
	private int anioFechaReporte;
	private int factVida;
	private Date pagoVida;
	private int reciboPago;
	private int remRCE;
	private String factAllianzRCE;
	private Date pagoRCE;
	private int remTransporte;
	private String factAllianzTransporte;
	private Date pagoTransporte;

	public Movimiento() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getNumeracion() {
		return numeracion;
	}

	public void setNumeracion(String numeracion) {
		this.numeracion = numeracion;
	}

	public int getMesFechaReporte() {
		return mesFechaReporte;
	}

	public void setMesFechaReporte(int mesFechaReporte) {
		this.mesFechaReporte = mesFechaReporte;
	}

	public int getAnioFechaReporte() {
		return anioFechaReporte;
	}

	public void setAnioFechaReporte(int anioFechaReporte) {
		this.anioFechaReporte = anioFechaReporte;
	}

	public int getFactVida() {
		return factVida;
	}

	public void setFactVida(int factVida) {
		this.factVida = factVida;
	}

	public Date getPagoVida() {
		return pagoVida;
	}

	public void setPagoVida(Date pagoVida) {
		this.pagoVida = pagoVida;
	}

	public int getReciboPago() {
		return reciboPago;
	}

	public void setReciboPago(int reciboPago) {
		this.reciboPago = reciboPago;
	}

	public int getRemRCE() {
		return remRCE;
	}

	public void setRemRCE(int remRCE) {
		this.remRCE = remRCE;
	}

	public String getFactAllianzRCE() {
		return factAllianzRCE;
	}

	public void setFactAllianzRCE(String factAllianzRCE) {
		this.factAllianzRCE = factAllianzRCE;
	}

	public Date getPagoRCE() {
		return pagoRCE;
	}

	public void setPagoRCE(Date pagoRCE) {
		this.pagoRCE = pagoRCE;
	}

	public int getRemTransporte() {
		return remTransporte;
	}

	public void setRemTransporte(int remTransporte) {
		this.remTransporte = remTransporte;
	}

	public String getFactAllianzTransporte() {
		return factAllianzTransporte;
	}

	public void setFactAllianzTransporte(String factAllianzTransporte) {
		this.factAllianzTransporte = factAllianzTransporte;
	}

	public Date getPagoTransporte() {
		return pagoTransporte;
	}

	public void setPagoTransporte(Date pagoTransporte) {
		this.pagoTransporte = pagoTransporte;
	}

}
