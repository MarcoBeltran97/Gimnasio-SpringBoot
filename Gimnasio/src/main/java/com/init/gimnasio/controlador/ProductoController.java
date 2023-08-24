package com.init.gimnasio.controlador;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.init.gimnasio.interfaces.ILogin;
import com.init.gimnasio.interfazServicio.IDetalleCompraService;
import com.init.gimnasio.interfazServicio.IProductoService;
import com.init.gimnasio.modelo.Producto;
import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.modelo.Login;
import com.init.gimnasio.servicio.DetalleCompraService;
import com.init.gimnasio.servicio.LoginService;
import com.init.gimnasio.servicio.ProductoService;

@Controller
@RequestMapping
public class ProductoController {
	
	@Autowired
	private ILogin repo;
	
	@Autowired
	private LoginService loginservicio;
	
	@Autowired
	private ProductoService s_producto;
	
	@Autowired
	private IProductoService i_productoservice;
	
	@Autowired
	private DetalleCompraService productocliservice;
	
	
	@GetMapping("/shop")
	public String agregar(Model model, Login usuario) {
		List<Producto>productos=i_productoservice.listar();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Login appUser = repo.findByUsername(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No existe usuario")); //Usar
		auth.getName();
		System.out.println("prueba4: "+appUser.getIdusuario());
		System.out.println("prueba5: "+auth.getPrincipal());
		System.out.println("prueba6: "+auth.getName());
		System.out.println("prueba7: "+auth.getDetails());
		model.addAttribute("producto_controller", productos);
		System.out.println("map: /shop");
		return "Productos";
	}	
	
	/*Mediante los name del input, enviamos cada registro ingresado para luego enviarlo a la funcion de Producto Service*/
	
	@PostMapping("/saveproducto")
	public String guardarProductoCliente(
			@RequestParam("txtidproducto") int producto,
			@RequestParam("txtprecio_uni_producto") double precio_unitario
			)
	{		
		System.out.println("saveproductoController");
		productocliservice.guardarDetalleCompra(1, producto, 1, precio_unitario, "");
		return "redirect:/carrito";
	}
	
	@PostMapping("/shop")
	public String save(@Validated Producto p, Model model) {
		i_productoservice.save(p);
		return "redirect:/shop";
	}
	
}