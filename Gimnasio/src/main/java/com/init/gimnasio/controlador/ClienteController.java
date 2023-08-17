<<<<<<< HEAD
package com.init.gimnasio.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.gimnasio.interfazServicio.IClienteService;
import com.init.gimnasio.modelo.Cliente;

@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	private IClienteService service;
		
	@GetMapping("/index")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Cliente());
		return "Index";
	}
	
	@PostMapping("/index")
	public String save(@Validated Cliente c, Model model) {
		service.savecliente(c);
		return "redirect:/shop";
	}
	
	@GetMapping("/editarcliente/{id}")
	public String editar(@PathVariable String username, Model model) {
		Optional<Cliente>cliente = service.listarcliente(username);
		model.addAttribute("cliente", cliente);
		return "Cliente";
	}	

}
=======
package com.init.gimnasio.controlador;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.init.gimnasio.interfazServicio.IClienteService;
import com.init.gimnasio.modelo.Cliente;

@Controller
@RequestMapping
public class ClienteController {
	
	@Autowired
	private IClienteService service;
		
	@GetMapping("/index")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Cliente());
		return "Index";
	}
	
	@PostMapping("/index")
	public String save(@Validated Cliente c, Model model) {
		service.savecliente(c);
		return "redirect:/shop";
	}
	
	@GetMapping("/editarcliente/{id}")
	public String editar(@PathVariable String username, Model model) {
		Optional<Cliente>cliente = service.listarcliente(username);
		model.addAttribute("cliente", cliente);
		return "Cliente";
	}	

}
>>>>>>> a233689389d1144e4f7249b103394cf42e7c7698
