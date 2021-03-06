package com.init.gimnasio.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.IProductoCliente;
import com.init.gimnasio.interfazServicio.IProductoClienteService;
import com.init.gimnasio.modelo.ProductoCliente;

@Service
public class ProductoClienteService implements IProductoClienteService {

	@Autowired
	private IProductoCliente iproductocliente;

	
	@Override
	public List<ProductoCliente> listarProducto() {
		return (List<ProductoCliente>)iproductocliente.findAll();
	}

	@Override
	public Optional<ProductoCliente> listarProductoId(int id) {
		return iproductocliente.findById(id);
	}

	@Override
	public int saveproducto(ProductoCliente p) {
		int res = 0;
		ProductoCliente producto = iproductocliente.save(p);
		if(!producto.equals(null)) {
			res = 1;
		}
		return res;
	}

	@Override
	public void deleteproducto(int id) {
		iproductocliente.deleteById(id);
	}
	
	/*Empezamos a implementar el metodo donde recogeremos y enviaremos por parametro cada valor de la interfaz del producto servicio*/
	public void guardarProductoCliente(String tipo_producto, String nombre_producto, String descripcion, double precio_uni) {
		
		ProductoCliente p = new ProductoCliente();
		
		p.setTipo_producto(tipo_producto);
		p.setNombre_producto(nombre_producto);
		p.setDescripcion(descripcion);
		p.setPrecio_uni(precio_uni);
		
		iproductocliente.save(p);

	}

}
