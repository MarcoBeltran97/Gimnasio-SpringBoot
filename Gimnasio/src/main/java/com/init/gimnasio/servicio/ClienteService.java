package com.init.gimnasio.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.ICliente;
import com.init.gimnasio.interfazServicio.IClienteService;
import com.init.gimnasio.modelo.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ICliente icliente;

	@Override
	public List<Cliente> listar() {
		return (List<Cliente>)icliente.findAll();
	}

	@Override
	public Optional<Cliente> listarcliente(String username) {
		return icliente.findById(username);
	}

	@Override
	public int savecliente(Cliente c) {
		int resp = 0;
		Cliente cliente = icliente.save(c);
		if(!cliente.equals(null)) {
			resp = 1;			
		}
		return resp;
	}

	@Override
	public void deletecliente(String username) {
		icliente.deleteById(username);		
	}
	
}
