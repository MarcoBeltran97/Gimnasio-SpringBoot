package com.init.gimnasio.interfaces;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.init.gimnasio.modelo.DetalleCompra;
import com.init.gimnasio.modelo.DetalleCompraCarrito;

public interface IDetalleCompraCarrito extends CrudRepository<DetalleCompraCarrito, Integer> {
	//Listar detalle de compra por ID cliente
	@Query(value = "{CALL sp_detalle_compra_idcli (:idusu)}", nativeQuery = true)
	List<DetalleCompraCarrito> detallecompraListarIdSP(@Param("idusu") int idusu);
	
	//Listar ID detalle de compra para editar
	@Query(value = "{CALL sp_editar_compra_idcli (:iddetalle)}", nativeQuery = true)
	Optional<DetalleCompraCarrito> editarcompraListarIdSP(@Param("iddetalle") int iddetalle);
	
	
	//Falta revisar
	@Query(value = "{CALL sp_monto_total_compra_idcli (:idusu)}", nativeQuery = true)
	Optional<DetalleCompraCarrito> montototalcompraclienteIdSP(@Param("idusu") int idusu);
}
