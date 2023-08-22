package com.init.gimnasio.controlador;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.init.gimnasio.interfaces.ILogin;
import com.init.gimnasio.interfazServicio.IDetalleCompraService;
import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.modelo.DetalleCompraCarrito;
import com.init.gimnasio.modelo.Login;
import com.init.gimnasio.servicio.DetalleCompraService;

@Controller
@RequestMapping
public class DetalleCompraController {
	
	@Autowired
	private ILogin repo;
	
	@Autowired
	private DetalleCompraService s_detallecompra;	
	
	@Autowired
	private IDetalleCompraService i_detallecompra;
	
	//Listado de carrito de compra funcional
	/*@GetMapping("/carrito")
	public String listar(Model model) {
		List<DetalleCompra>detalle_compra=i_detallecompra.listarDetalleCompra();
		model.addAttribute("detalle_compra_controller", detalle_compra);
		return "Carrito";
	}*/
		
	
	@GetMapping("/editar/{id}")
	public String editarCompra(@PathVariable int id, Model model) {
		System.out.println("DetalleCompraControllerEdit "+id);
		Optional<DetalleCompraCarrito>editarcompra = s_detallecompra.listarEditDetalleCompraId(id);
		System.out.println("DetalleCompraControllerEdit2 "+id);
		model.addAttribute("editar_compra_controller", editarcompra);
		System.out.println("controllerMarco4: "+editarcompra.get().getIddetallecompra());
		System.out.println("controllerMarco4: "+editarcompra.get().getIdusuario());
		System.out.println("controllerMarco4: "+editarcompra.get().getTipo_producto());
		System.out.println("controllerMarco4: "+editarcompra.get().getNombre_producto());
		System.out.println("controllerMarco4: "+editarcompra.get().getDescripcion());
		System.out.println("controllerMarco4: "+editarcompra.get().getPrecio_uni());
		System.out.println("controllerMarco4: "+editarcompra.get().getCantidad());
		System.out.println("controllerMarco4: "+editarcompra.get().getMonto_total());
		System.out.println("controllerMarco4: "+editarcompra.get().getFecha());
		return "Update";
	}
	
	
	/*FUNCIONAL JSON*/
	//@GetMapping("/carrito")
	//public ResponseEntity<DetalleCompra> viewId(){
		//System.out.println("controllerMarco");
		//Obtendremos el id del cliente
		//Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		//Login appUser = repo.findByUsername(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No existe usuario")); //Usar
		//auth.getName();
		//System.out.println("pruebadcc: "+auth.getName());
		//List<DetalleCompraCarrito> detallecompra = s_detallecompra.listarDetalleCompraId(appUser.getIdusuario());		
		//System.out.println("controllerMarco3: "+detallecompra);
		//return new ResponseEntity(detallecompra, HttpStatus.OK);
	//}
	
	@GetMapping("/carrito")
	public String Listar (Model model){
		System.out.println("controllerMarco");		
		//Obtendremos el id del cliente
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Login appUser = repo.findByUsername(auth.getName()).orElseThrow(() -> new UsernameNotFoundException("No existe usuario")); //Usar
		auth.getName();
		System.out.println("pruebadcc: "+auth.getName());
		List<DetalleCompraCarrito> detallecompra = s_detallecompra.listarDetalleCompraId(appUser.getIdusuario());		
		model.addAttribute("detalle_compra_controller", detallecompra);
		System.out.println("controllerMarco3: "+detallecompra.get(0).getIddetallecompra());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getIdusuario());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getTipo_producto());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getNombre_producto());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getDescripcion());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getPrecio_uni());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getCantidad());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getMonto_total());
		System.out.println("controllerMarco3: "+detallecompra.get(0).getFecha());
		return "Carrito";
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
