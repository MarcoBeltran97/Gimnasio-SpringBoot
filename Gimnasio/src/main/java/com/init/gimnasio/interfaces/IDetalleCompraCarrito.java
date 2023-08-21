package com.init.gimnasio.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.init.gimnasio.modelo.DetalleCompraCarrito;

public interface IDetalleCompraCarrito extends CrudRepository<DetalleCompraCarrito, Integer> {
	//Listar por ID
	@Query(value = "{CALL sp_detalle_compra_idcli (:idusu)}", nativeQuery = true)
	List<DetalleCompraCarrito> detallecompraListarIdSP(@Param("idusu") int idusu);
}