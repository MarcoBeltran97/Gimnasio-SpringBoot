package com.init.gimnasio.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.init.gimnasio.modelo.Producto;
import com.init.gimnasio.servicio.ProductoService;

@Controller
public class Mant_ProductoController {	
	
	@Autowired
	private ProductoService productoservice;
	
	@GetMapping("/mantproducto")
	public String agregar(Model model) {
		model.addAttribute("producto", new Producto());
		return "Mant_Producto";
	}
	
	/*@PostMapping("/mantproducto")
	public String saveMantProducto(@Validated Producto p, Model model) {
		iproducto.save(p);
		return "redirect:/mantproducto";
	}*/
	
	
	/*Mediante los name del input, enviamos cada registro ingresado para luego enviarlo a la funcion de Producto Service*/
	
	@PostMapping("/mantproducto")
	public String guardarProducto(@RequestParam("file") MultipartFile file,
			@RequestParam("txttipo_producto") String tipo_producto,
			@RequestParam("txtnombre_producto") String nombre_producto,
			@RequestParam("txtdescripcion") String descripcion,
			@RequestParam("txtprecio_uni") double precio_uni			
			)
	{
		productoservice.guardarProductoBD(file, tipo_producto, nombre_producto, descripcion, precio_uni);
		return "redirect:/shop";
	}

}
