package com.init.gimnasio.modelo;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idusuario;
	private String username;
	private String password;
	
	/*Anidamos la llave primaria*/
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "usuarios_roles",
			joinColumns = @JoinColumn(name = "idusuariorol", referencedColumnName = "idusuario"),
			inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "idrol"))
	
	private Collection<RolUsuario> roles;
	
	public Login() {
		super();
	}
	
	public Login(Long idusuario, String username, String password) {
		super();
		this.idusuario = idusuario;
		this.username = username;
		this.password = password;
	}
	
	public Long getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(Long idusuario) {
		this.idusuario = idusuario;
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

	public Collection<RolUsuario> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RolUsuario> roles) {
		this.roles = roles;
	}
		
}