package com.init.gimnasio.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.IProducto;
import com.init.gimnasio.interfazServicio.IProductoService;
import com.init.gimnasio.modelo.Producto;

@Service
public class ProductoService implements IProductoService {
	
	@Autowired
	private IProducto iproducto;

	@Override
	public List<Producto> listar() {
		return (List<Producto>)iproducto.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		return iproducto.findById(id);
	}

	@Override
	public int save(Producto p) {
		int res = 0;
		Producto producto = iproducto.save(p);
		if(!producto.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		iproducto.deleteById(id);
	}

}
