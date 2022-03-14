package com.init.gimnasio.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.gimnasio.interfazServicio.IProductoService;
import com.init.gimnasio.modelo.Producto;

@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@GetMapping("/carrito")
	public String listar(Model model) {
		List<Producto>productos=service.listar();
		model.addAttribute("productos", productos);
		return "Carrito";
	}
	
	@GetMapping("/shop")
	public String agregar(Model model) {
		List<Producto>productos=service.listar();
		model.addAttribute("productos", productos);
		return "Productos";
	}
	
	/*@GetMapping("/shop")
	public String agregar(Model model) {
		model.addAttribute("producto", new Producto());
		return "Productos";
	}*/
	
	@PostMapping("/shop")
	public String save(@Validated Producto p, Model model) {
		service.save(p);
		return "redirect:/shop";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Producto>producto = service.listarId(id);
		model.addAttribute("producto", producto);
		return "Productos";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/carrito";
	}

}
