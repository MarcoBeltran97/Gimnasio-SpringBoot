package com.init.gimnasio.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.gimnasio.modelo.ProductoCliente;

@Repository
public interface IProductoCliente extends CrudRepository<ProductoCliente, Integer> {

}
