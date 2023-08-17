package com.init.gimnasio.servicio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.init.gimnasio.interfaces.IDetalleCompra;
import com.init.gimnasio.interfazServicio.IDetalleCompraService;
import com.init.gimnasio.modelo.Detalle_Compra;

@Service
public class DetalleCompraService implements IDetalleCompraService {

	@Autowired
	private IDetalleCompra iproductocliente;

	
	@Override
	public List<Detalle_Compra> listarProducto() {
		return (List<Detalle_Compra>)iproductocliente.findAll();
	}

	@Override
	public Optional<Detalle_Compra> listarProductoId(int id) {
		return iproductocliente.findById(id);
	}

	@Override
	public int saveproducto(Detalle_Compra p) {
		int res = 0;
		Detalle_Compra producto = iproductocliente.save(p);
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
		
		Detalle_Compra p = new Detalle_Compra();
		
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

}