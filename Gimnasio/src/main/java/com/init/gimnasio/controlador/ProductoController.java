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

import com.init.gimnasio.interfazServicio.IDetalleCompraService;
import com.init.gimnasio.interfazServicio.IProductoService;
import com.init.gimnasio.modelo.Producto;
import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.servicio.DetalleCompraService;

@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	private IProductoService service;
	
	@Autowired
	private DetalleCompraService productocliservice;
	
	@Autowired
	private IDetalleCompraService i_detallecompra;
	
	@GetMapping("/carrito")
	public String listar(Model model) {
		List<DetalleCompra>detalle_compra=i_detallecompra.listarDetalleCompra();
		model.addAttribute("detalle_compra_controller", detalle_compra);
		return "Carrito";
	}
	
	@GetMapping("/shop")
	public String agregar(Model model) {
		List<Producto>productos=service.listar();
		model.addAttribute("producto_controller", productos);
		return "Productos";
	}
	
	
	/*@PostMapping("/save")
	public String save(@Validated ProductoCliente c, Model model) {
		i_detallecompra.saveproducto(c);
		return "redirect:/carrito";
	}*/
	
	/**/
	
	@PostMapping("/save")
	public String save(@Validated DetalleCompra c, Model model) {
		i_detallecompra.saveproducto(c);
		return "redirect:/carrito";
	}
	
	/**/
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
		Optional<DetalleCompra>productoCliente = i_detallecompra.listarProductoId(id);
		model.addAttribute("producto_cliente", productoCliente);
		return "Update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		i_detallecompra.deleteproducto(id);
		return "redirect:/carrito";
	}

}