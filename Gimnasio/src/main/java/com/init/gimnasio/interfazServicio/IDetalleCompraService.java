package com.init.gimnasio.interfazServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.modelo.DetalleCompraCarrito;

public interface IDetalleCompraService {
	public List<DetalleCompra> listarDetalleCompra();
	public List<DetalleCompraCarrito> listarDetalleCompraId(int id);
	Optional<DetalleCompraCarrito> listarEditDetalleCompraId(int id);
	public int saveproducto(DetalleCompra p);
	public void deleteproducto(int id);
	
	/*Metodo para guardar los valores con la imagen, enviando todos los parametros*/
	public void guardarDetalleCompra(int usuario, int producto, int cantidad, double monto_total, String fecha);


}