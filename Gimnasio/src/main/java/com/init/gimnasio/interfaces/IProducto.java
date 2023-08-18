package com.init.gimnasio.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.gimnasio.modelo.Producto;

@Repository
public interface IProducto extends CrudRepository<Producto, Integer> {

}