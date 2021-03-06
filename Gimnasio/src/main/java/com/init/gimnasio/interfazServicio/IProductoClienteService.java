package com.init.gimnasio.interfazServicio;

import java.util.List;
import java.util.Optional;


import com.init.gimnasio.modelo.ProductoCliente;

public interface IProductoClienteService {
	public List<ProductoCliente> listarProducto();
	public Optional<ProductoCliente> listarProductoId(int id);
	public int saveproducto(ProductoCliente p);
	public void deleteproducto(int id);
	
	/*Metodo para guardar los valores con la imagen, enviando todos los parametros*/
	public void guardarProductoCliente(String tipo_producto, String nombre_producto, String descripcion, double precio_uni);


}
