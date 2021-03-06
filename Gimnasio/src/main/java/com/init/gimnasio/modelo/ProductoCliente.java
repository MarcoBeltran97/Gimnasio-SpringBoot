package com.init.gimnasio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto_cliente")
public class ProductoCliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproductocliente;
	private String tipo_producto;
	private String nombre_producto;
	private String descripcion;
	private double precio_uni;
	
	public ProductoCliente() {
		super();
	}
	
	public ProductoCliente(int idproductocliente, String tipo_producto, String nombre_producto, String descripcion,
			double precio_uni) {
		super();
		this.idproductocliente = idproductocliente;
		this.tipo_producto = tipo_producto;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.precio_uni = precio_uni;
	}
	
	public int getIdproducto() {
		return idproductocliente;
	}
	public void setIdproducto(int idproductocliente) {
		this.idproductocliente = idproductocliente;
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
}
