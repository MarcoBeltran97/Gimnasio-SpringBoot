package com.init.gimnasio.controlador;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.init.gimnasio.modelo.Login;
import com.init.gimnasio.modelo.Producto;
import com.init.gimnasio.servicio.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginservicio;
	
	@GetMapping("/login")
	public ModelAndView Login() {
		ModelAndView login = new ModelAndView("login");
		login.addObject("usuario", new Login());
		return login;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("usuario") Login usuario) {
		Login loginuser = loginservicio.login(usuario.getUsername(), usuario.getPassword());
		//Login userindex = loginservicio.inicio(usuario.getUsername());
		
		System.out.print(loginuser);
		//System.out.print(userindex);
		
		if(Objects.nonNull(loginuser)) {
			return "redirect:/index";
		}
		else{
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login";		
	}

}
