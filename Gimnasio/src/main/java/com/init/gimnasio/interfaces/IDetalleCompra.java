package com.init.gimnasio.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.modelo.DetalleCompraCarrito;

@Repository
public interface IDetalleCompra extends CrudRepository<DetalleCompra, Integer> {	
	
}