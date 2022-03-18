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
import org.springframework.web.bind.annotation.RequestParam;

import com.init.gimnasio.interfazServicio.IProductoClienteService;
import com.init.gimnasio.interfazServicio.IProductoService;
import com.init.gimnasio.modelo.Producto;
import com.init.gimnasio.modelo.ProductoCliente;
import com.init.gimnasio.servicio.ProductoClienteService;

@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@Autowired
	private ProductoClienteService productocliservice;
	
	@Autowired
	private IProductoClienteService productoclienteservice;
	
	@GetMapping("/carrito")
	public String listar(Model model) {
		List<ProductoCliente>productos=productoclienteservice.listarProducto();
		model.addAttribute("productoscliente", productos);
		return "Carrito";
	}
	
	@GetMapping("/shop")
	public String agregar(Model model) {
		List<Producto>productos=service.listar();
		model.addAttribute("productos", productos);
		return "Productos";
	}
	
	
	/*@PostMapping("/save")
	public String save(@Validated ProductoCliente c, Model model) {
		productoclienteservice.saveproducto(c);
		return "redirect:/carrito";
	}*/
	
	/**/
	
	@PostMapping("/save")
	public String save(@Validated ProductoCliente c, Model model) {
		productoclienteservice.saveproducto(c);
		return "redirect:/carrito";
	}
	
	/**/
	/*Mediante los name del input, enviamos cada registro ingresado para luego enviarlo a la funcion de Producto Service*/
	
	@PostMapping("/saveproducto")
	public String guardarProductoCliente(
			@RequestParam("txttipo_productocliente") String tipo_producto,
			@RequestParam("txtnombre_productocliente") String nombre_producto,
			@RequestParam("txtdescripcionproducto") String descripcion,
			@RequestParam("txtprecio_uni_producto") double precio_uni			
			)
	{
		productocliservice.guardarProductoCliente(tipo_producto, nombre_producto, descripcion, precio_uni);
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
		service.save(p);
		return "redirect:/shop";
	}
	
	/**/
	@GetMapping("/update")
	public String listarProducto(Model model) {
		return "Update";
	}
	
	@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable int id, Model model) {
		Optional<ProductoCliente>productoCliente = productoclienteservice.listarProductoId(id);
		model.addAttribute("producto_cliente", productoCliente);
		return "Update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		productoclienteservice.deleteproducto(id);
		return "redirect:/carrito";
	}

}
