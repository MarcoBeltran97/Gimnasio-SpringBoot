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
