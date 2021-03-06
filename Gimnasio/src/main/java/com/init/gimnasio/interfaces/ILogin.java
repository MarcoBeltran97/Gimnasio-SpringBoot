package com.init.gimnasio.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.init.gimnasio.modelo.Login;

@Repository
public interface ILogin extends JpaRepository<Login, Long> {
	Login findByUsernameAndPassword(String usuario, String pass);
}
