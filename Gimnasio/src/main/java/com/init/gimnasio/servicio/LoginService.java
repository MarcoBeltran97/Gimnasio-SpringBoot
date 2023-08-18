package com.init.gimnasio.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.ILogin;
import com.init.gimnasio.modelo.Login;

@Service
public class LoginService {
	
	@Autowired
	private ILogin repo;
	
	public Login loginusuario(String usu, String pass) {
		Login usuarioservice = repo.findByUsernameAndPassword(usu, pass);
		return usuarioservice;
	}
	
}