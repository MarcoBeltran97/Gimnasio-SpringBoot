package com.init.gimnasio.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DetalleCompraCarrito {
	@Id
	private int iddetallecompra;
	private int idusuario;
	private String tipo_producto;
	private String nombre_producto;
	private String descripcion;
	private double precio_uni;
	private int cantidad;
	private double monto_total;
	private String fecha;
		
	public DetalleCompraCarrito() {
		super();
	}

	public DetalleCompraCarrito(int iddetallecompra, int idusuario, String tipo_producto, String nombre_producto,
			String descripcion, double precio_uni, int cantidad, double monto_total, String fecha) {
		super();
		this.iddetallecompra = iddetallecompra;
		this.idusuario = idusuario;
		this.tipo_producto = tipo_producto;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.precio_uni = precio_uni;
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

	public String getTipo_producto() {
		return tipo_producto;
	}

	public void setTipo_producto(String tipo_producto) {
		this.tipo_producto = tipo_producto;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio_uni() {
		return precio_uni;
	}

	public void setPrecio_uni(double precio_uni) {
		this.precio_uni = precio_uni;
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