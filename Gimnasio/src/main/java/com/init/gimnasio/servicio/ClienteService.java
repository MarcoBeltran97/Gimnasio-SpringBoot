package com.init.gimnasio.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.ICliente;
import com.init.gimnasio.interfazServicio.IClienteService;
import com.init.gimnasio.modelo.Login;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ICliente icliente;
	
	@Override
	public List<Login> listar() {
		return (List<Login>)icliente.findAll();
	}

	@Override
	public Optional<Login> listarId(int id) {
		return icliente.findById(id);
	}

	@Override
	public int save(Login c) {
		int res = 0;
		Login login = icliente.save(c);
		if(!login.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		icliente.deleteById(id);
	}
	

}
