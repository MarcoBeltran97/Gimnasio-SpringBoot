package com.init.gimnasio.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {
	/*Indicamos como parametro que el id de la tabla cliente*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idproducto;
	private String tipo_producto;
	/*Indicamos el tipo de volumen de datos para la imagen*/
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private String imagen_producto;
	private String nombre_producto;
	private String descripcion;
	private int cantidad;
	private double precio_uni;
	
	public Producto() {
		super();
	}
	
	public Producto(int idproducto, String tipo_producto, String imagen_producto, String nombre_producto,
			String descripcion, int cantidad, double precio_uni) {
		super();
		this.idproducto = idproducto;
		this.tipo_producto = tipo_producto;
		this.imagen_producto = imagen_producto;
		this.nombre_producto = nombre_producto;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.precio_uni = precio_uni;
	}
	
	public int getIdproducto() {
		return idproducto;
	}
	public void setIdproducto(int idproducto) {
		this.idproducto = idproducto;
	}
	public String getTipo_producto() {
		return tipo_producto;
	}
	public void setTipo_producto(String tipo_producto) {
		this.tipo_producto = tipo_producto;
	}
	public String getImagen_producto() {
		return imagen_producto;
	}
	public void setImagen_producto(String imagen_producto) {
		this.imagen_producto = imagen_producto;
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
	
}
