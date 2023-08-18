package com.init.gimnasio.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.init.gimnasio.modelo.Cliente;

@Repository
public interface ICliente extends CrudRepository<Cliente, String> {

}