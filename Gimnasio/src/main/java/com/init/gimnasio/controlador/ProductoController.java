package com.init.gimnasio.controlador;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.init.gimnasio.interfazServicio.IDetalleCompraService;
import com.init.gimnasio.interfazServicio.IProductoService;
import com.init.gimnasio.modelo.Producto;
import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.servicio.DetalleCompraService;
import com.init.gimnasio.servicio.ProductoService;

@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	private ProductoService s_producto;
	
	@Autowired
	private IProductoService i_productoservice;
	
	@Autowired
	private DetalleCompraService productocliservice;
	
	
	@GetMapping("/shop")
	public String agregar(Model model) {
		List<Producto>productos=i_productoservice.listar();
		/*Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		auth.getName();
		System.out.println("prueba: "+auth.getPrincipal());*/
		model.addAttribute("producto_controller", productos);
		return "Productos";
	}
	
	
	
	
	/*@PostMapping("/save")
	public String save(@Validated ProductoCliente c, Model model) {
		i_detallecompra.saveproducto(c);
		return "redirect:/carrito";
	}*/
	
	
	/*Mediante los name del input, enviamos cada registro ingresado para luego enviarlo a la funcion de Producto Service*/
	
	@PostMapping("/saveproducto")
	public String guardarProductoCliente(
			@RequestParam("txtidproducto") int producto,
			@RequestParam("txtprecio_uni_producto") double precio_unitario
			)
	{
		productocliservice.guardarDetalleCompra(1, producto, 1, precio_unitario, "");
		return "redirect:/carrito";
	}
	/**/
	/*@GetMapping("/shop")
	public String agregar(Model model) {
		model.addAttribute("producto", new Producto());
		return "Productos";
	}*/
	
	@PostMapping("/shop")
	public String save(@Validated Producto p, Model model) {
		i_productoservice.save(p);
		return "redirect:/shop";
	}
	
}