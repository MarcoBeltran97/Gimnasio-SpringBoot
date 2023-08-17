package com.init.gimnasio.interfazServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.init.gimnasio.modelo.Detalle_Compra;

public interface IDetalleCompraService {
	public List<Detalle_Compra> listarProducto();
	public Optional<Detalle_Compra> listarProductoId(int id);
	public int saveproducto(Detalle_Compra p);
	public void deleteproducto(int id);
	
	/*Metodo para guardar los valores con la imagen, enviando todos los parametros*/
	public void guardarDetalleCompra(int usuario, int producto, int cantidad, double monto_total, String fecha);


}