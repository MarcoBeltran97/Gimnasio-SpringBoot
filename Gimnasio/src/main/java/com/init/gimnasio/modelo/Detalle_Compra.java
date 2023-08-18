package com.init.gimnasio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_compra")
public class Detalle_Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int iddetallecompra;
	private int idusuario;
	private int idproducto;
	private int cantidad;
	private double monto_total;
	private String fecha;

	public Detalle_Compra() {
		super();
	}

	public Detalle_Compra(int idproductocliente, int idusuario, int idproducto, int cantidad, double monto_total, String fecha) {
		super();
		this.iddetallecompra = idproductocliente;
		this.idusuario = idusuario;
		this.idproducto = idproducto;
		this.cantidad = cantidad;
		this.monto_total = monto_total;
		this.fecha = fecha;
	}

	public int getIddetallecompra() {
		return iddetallecompra;
	}

	public void setIddetallecompra(int iddetallecompra) {
		this.iddetallecompra = iddetallecompra;
	}		

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}

	public int getIdproducto() {
		return idproducto;
	}

	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getMonto_total() {
		return monto_total;
	}

	public void setMonto_total(double monto_total) {
		this.monto_total = monto_total;
	}

	public String getFecha() {
		return fecha;
	}
	
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
}