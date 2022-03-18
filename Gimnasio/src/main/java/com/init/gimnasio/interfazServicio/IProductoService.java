package com.init.gimnasio.interfazServicio;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.init.gimnasio.modelo.Producto;

public interface IProductoService {
	
	public List<Producto> listar();
	public Optional<Producto> listarId(int id);
	public int save(Producto p);
	public void delete(int id);
	
	/*Metodo para guardar los valores con la imagen, enviando todos los parametros*/
	public void guardarProductoBD(MultipartFile file, String tipo_producto, String nombre_producto, String descripcion, double precio_uni);

}
