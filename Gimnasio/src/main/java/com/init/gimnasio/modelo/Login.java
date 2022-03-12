package com.init.gimnasio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	private String nombre_completo;
	private String apellidos;
	private String dni;
	private String direccion;
	private String ciudad;
	private String celular;
	private String username;
	private String password;
	
	public Login() {
		super();
	}
	
	public Login(Long idusuario, String nombre_completo, String apellidos, String dni, String direccion, String ciudad,
			String celular, String username, String password) {
		super();
		this.idusuario = idusuario;
		this.nombre_completo = nombre_completo;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.celular = celular;
		this.username = username;
		this.password = password;
	}
	
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getCelular() {
		return celular;
	}
	public void setCelular(String celular) {
		this.celular = celular;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}	
		
}
