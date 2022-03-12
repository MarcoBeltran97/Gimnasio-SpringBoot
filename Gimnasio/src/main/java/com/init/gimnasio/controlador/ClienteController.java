package com.init.gimnasio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.gimnasio.interfazServicio.IClienteService;
import com.init.gimnasio.modelo.Login;

@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	private IClienteService service;
	
	
	
	/*@GetMapping("/carrito")
	public String listar(Model model) {
		List<Login>productos=service.listar();
		model.addAttribute("productos", productos);
		return "Carrito";
	}*/
	
	@GetMapping("/index")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Login());
		return "Index";
	}
	
	/*@PostMapping("/index")
	public String save(@Validated Login c, Model model) {
		service.save(c);
		return "redirect:/shop";
	}*/
	
	/*@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Login>producto = service.listarId(id);
		model.addAttribute("producto", producto);
		return "Productos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/carrito";
	}*/

}
