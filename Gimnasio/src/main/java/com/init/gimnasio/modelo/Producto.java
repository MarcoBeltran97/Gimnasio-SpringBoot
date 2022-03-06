package com.init.gimnasio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	/*Indicamos como parametro que el id de la tabla cliente*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int cliente;
	private String tipo_producto;
	private String nombre_producto;
	private String descripcion;
	private int cantidad;
	private double precio_uni;
	private double precio_total;
	
	public Producto() {
		super();
	}
	
	public Producto(int id, int cliente, String tipo_producto, String nombre_producto, String descripcion, int cantidad,
			double precio_uni, double precio_total) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.tipo_producto = tipo_producto;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio_uni = precio_uni;
		this.precio_total = precio_total;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCliente() {
		return cliente;
	}
	public void setCliente(int cliente) {
		this.cliente = cliente;
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
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio_uni() {
		return precio_uni;
	}
	public void setPrecio_uni(double precio_uni) {
		this.precio_uni = precio_uni;
	}
	public double getPrecio_total() {
		return precio_total;
	}
	public void setPrecio_total(double precio_total) {
		this.precio_total = precio_total;
	}
	
}
