<<<<<<< HEAD
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.init.gimnasio.modelo.Login;
import com.init.gimnasio.servicio.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService loginservicio;
	
	/**/
	@GetMapping("/login")
	public String login (Model model) {
		model.addAttribute("usuario", new Login());
		return "login";
	}
	
	/*@PostMapping("/login")
	public ModelAndView Resultado(@ModelAttribute("usuario") Login usuario) {
		ModelAndView nav = new ModelAndView("Productos");
		nav.addObject("usuario",usuario);
		return nav;		
	}*/
	
	@PostMapping("/login")
	public String login(
			@RequestParam(name="idusuario", required = false) String idusuario,			
			@RequestParam(name="username", required = false) String username, Model model,
			@ModelAttribute("usuario") Login usuario) {
		Login loginuser = loginservicio.loginusuario(usuario.getUsername(), usuario.getPassword());
		
		if(Objects.nonNull(loginuser)) {
			System.out.print("loginuser usuario id: "+loginuser.getIdusuario()+"\n");
			System.out.print("loginuser correo: "+loginuser.getUsername()+"\n");
			
			model.addAttribute("idusuario", loginuser.getIdusuario());
			model.addAttribute("username", loginuser.getUsername());
			return "redirect:/shop";
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
=======
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.init.gimnasio.modelo.Login;
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
	
	/*Envio de la solicitud mediante el request para la obtencion del input*/
	/*@GetMapping("/portada")
	public String logeo(HttpServletRequest request, Model model) {
		String usuariologeo = request.getParameter("txtusuario");
		model.addAttribute("usuariologin", usuariologeo);
		return "Portada";
	}*/	
	
	@PostMapping("/login")
	public String login(@RequestParam(name="username", required = false) String usuariologeo, Model model, @ModelAttribute("usuario") Login usuario) {
		Login loginuser = loginservicio.login(usuario.getUsername(), usuario.getPassword());
<<<<<<< HEAD
		model.addAttribute("usuariologin", usuariologeo);
		System.out.print(loginuser);
		
		if(Objects.nonNull(loginuser)) {
			return "redirect:/shop";
=======
		model.addAttribute("usuariologin", "Bienvenido: "+usuariologeo);
		System.out.print(loginuser);
		
		if(Objects.nonNull(loginuser)) {
			return "Portada";
>>>>>>> d169ce6bc648b3c3dd6fd124ca7415afcfd9745d
		}
		else{
			return "redirect:/login";
		}
	}
	
	
	/*Validacion de Inicio de Sesion normal, sin enviar un atributo*/
	/*@PostMapping("/login")
	public String login(@ModelAttribute("usuario") Login usuario) {
		Login loginuser = loginservicio.login(usuario.getUsername(), usuario.getPassword());
		
		System.out.print(loginuser);
		
		if(Objects.nonNull(loginuser)) {
			return "redirect:/portada";
		}
		else{
			return "redirect:/login";
		}
<<<<<<< HEAD
=======
	}*/
	
	
	/*@GetMapping("/portada/{id}")
	public String inicio(@PathVariable int id, Model model) {
		Optional<Login>cliente = clienteservicio.listarId(id);
		model.addAttribute("cliente", cliente);
		return "Portada";
>>>>>>> d169ce6bc648b3c3dd6fd124ca7415afcfd9745d
	}*/
	
	
	@RequestMapping(value = {"/logout"}, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {
		return "redirect:/login";		
	}

}
>>>>>>> a233689389d1144e4f7249b103394cf42e7c7698
