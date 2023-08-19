package com.init.gimnasio.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.gimnasio.modelo.DetalleCompra;

@Repository
public interface IDetalleCompra extends CrudRepository<DetalleCompra, Integer> {

}