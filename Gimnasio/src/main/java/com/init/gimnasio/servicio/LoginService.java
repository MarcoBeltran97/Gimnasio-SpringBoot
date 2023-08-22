package com.init.gimnasio.servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.ILogin;
import com.init.gimnasio.modelo.Login;
import com.init.gimnasio.modelo.RolUsuario;

@Service
public class LoginService implements UserDetailsService {
	
	@Autowired
	private ILogin repo;
	
	public Login loginusuario(String usu, String pass) {
		Login usuarioservice = repo.findByUsernameAndPassword(usu, pass);
		return usuarioservice;
	}
		
	public LoginService(ILogin repo) {
		super();
		this.repo = repo;
	}	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login appUser = repo.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("No existe usuario"));
		List grantList = new ArrayList();
		for (RolUsuario autorizacion: appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(autorizacion.getNombre());
			grantList.add(grantedAuthority);
		}
		System.out.println("servicionull9: "+username);
		UserDetails user = (UserDetails) new User(appUser.getUsername(), appUser.getPassword(), grantList);
		System.out.println("servicionull10: "+appUser.getIdusuario());
		System.out.println("servicionull10: "+appUser.getUsername());
		System.out.println("servicionull11: "+appUser.getPassword());
		System.out.println("servicionull12: "+grantList);
		System.out.println("servicionull12: "+user);
		return user;
	}
}