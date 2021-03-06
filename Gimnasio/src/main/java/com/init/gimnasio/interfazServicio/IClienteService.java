package com.init.gimnasio.interfazServicio;

import java.util.List;
import java.util.Optional;

import com.init.gimnasio.modelo.Cliente;

public interface IClienteService {
	public List<Cliente> listar();
	public Optional<Cliente> listarcliente(String username);
	public int savecliente(Cliente c);
	public void deletecliente(String username);

}
