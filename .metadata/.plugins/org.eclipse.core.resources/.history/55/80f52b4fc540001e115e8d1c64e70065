package com.init.gimnasio.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.gimnasio.interfazServicio.IDetalleCompraService;
import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.modelo.DetalleCompraCarrito;
import com.init.gimnasio.servicio.DetalleCompraService;

@Controller
@RequestMapping
public class DetalleCompraController {
		
	@Autowired
	private DetalleCompraService s_detallecompra;	
	
	@Autowired
	private IDetalleCompraService i_detallecompra;
	
	//Listado de carrito de compra funcional
	@GetMapping("/carrito")
	public String listar(Model model) {
		List<DetalleCompra>detalle_compra=i_detallecompra.listarDetalleCompra();
		model.addAttribute("detalle_compra_controller", detalle_compra);
		return "Carrito";
	}
		
	
	/*@GetMapping("/editar/{id}")
	public String editarCliente(@PathVariable int id, Model model) {
		Optional<DetalleCompra>productoCliente = i_detallecompra.listarProductoId(id);
		model.addAttribute("producto_cliente", productoCliente);
		return "Update";
	}*/
	
	@GetMapping("/carrito/{id}")
	public ResponseEntity<DetalleCompra> viewId(@PathVariable("id") int id){
		System.out.println("controllerMarco: "+id);
		List<DetalleCompraCarrito> detallecompra = s_detallecompra.listarDetalleCompraId(id);
		System.out.println("controllerMarco2: "+detallecompra);
		return new ResponseEntity(detallecompra, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/save")
	public String save(@Validated DetalleCompra c, Model model) {
		i_detallecompra.saveproducto(c);
		return "redirect:/carrito";
	}
	
	@GetMapping("/update")
	public String listarProducto(Model model) {
		return "Update";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		i_detallecompra.deleteproducto(id);
		return "redirect:/carrito";
	}
	
}
