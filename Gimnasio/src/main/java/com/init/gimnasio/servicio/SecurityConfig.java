package com.init.gimnasio.servicio;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//Clase de configuracion para Spring Security.
@Configuration
//Aqui vamos a configurar la seguridad de nuestra aplicacion.
@EnableWebSecurity
public class SecurityConfig {
	
	/*@Bean
	public SecurityFilterChain filtroCadena(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeHttpRequests((requests) -> requests
				.requestMatchers(new AntPathRequestMatcher("/shop")).permitAll()
				.anyRequest().authenticated()) //otras URL solo se permiten a usuarios autenticados
				.httpBasic();
		return httpSecurity.build();
	}*/
	

}
