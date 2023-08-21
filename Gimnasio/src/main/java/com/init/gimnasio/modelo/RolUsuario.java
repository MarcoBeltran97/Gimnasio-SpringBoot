package com.init.gimnasio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "rol")
public class RolUsuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idrol;
	private String nombre;
	
	public RolUsuario() {
	}
	
	public RolUsuario(int idrol, String nombre) {
		super();
		this.idrol = idrol;
		this.nombre = nombre;
	}
	
	public RolUsuario(String nombre) {
		super();
		this.nombre = nombre;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
		
}
