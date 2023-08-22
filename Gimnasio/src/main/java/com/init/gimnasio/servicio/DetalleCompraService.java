package com.init.gimnasio.servicio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.IDetalleCompra;
import com.init.gimnasio.interfaces.IDetalleCompraCarrito;
import com.init.gimnasio.interfazServicio.IDetalleCompraService;
import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.modelo.DetalleCompraCarrito;

@Service
public class DetalleCompraService implements IDetalleCompraService {
	
	private DetalleCompraCarrito dcc;
	
	@Autowired
	private IDetalleCompra iproductocliente;
	
	@Autowired
	private IDetalleCompraCarrito i_dcc;
	
	@Override
	public List<DetalleCompra> listarDetalleCompra() {
		return (List<DetalleCompra>)iproductocliente.findAll();
	}
	
	//Listar por ID
	public List<DetalleCompraCarrito> listarDetalleCompraId(int id) {
		System.out.println("servicioMarco: "+id);
		return i_dcc.detallecompraListarIdSP(id);
	}

	@Override
	public int saveproducto(DetalleCompra p) {
		int res = 0;
		DetalleCompra producto = iproductocliente.save(p);
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
	public void guardarDetalleCompra(int usuario, int producto, int cantidad, double monto_total, String fecha) {
		
		DetalleCompra p = new DetalleCompra();
		
		p.setIdusuario(1);
		p.setIdproducto(producto);
		p.setCantidad(1);
		p.setMonto_total(monto_total);
		
		String dateTime = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss a").format(LocalDateTime.now());
		p.setFecha(dateTime);
		
		if (dateTime == null || dateTime.equals("")) {
			dateTime = "Error al obtener la fecha";
		}
		
		iproductocliente.save(p);

	}

	/*@Override
	public Optional<DetalleCompra> listarProductoId(int id) {
		return iproductocliente.findById(id);
	}*/
	
	@Override
	public Optional<DetalleCompraCarrito> listarEditDetalleCompraId(int id) {
		System.out.println("DetalleCompraEdit "+id);
		return i_dcc.editarcompraListarIdSP(id);
	}

}