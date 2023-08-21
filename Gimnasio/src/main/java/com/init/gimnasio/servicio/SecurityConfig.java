package com.init.gimnasio.servicio;

import javax.activation.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

//Clase de configuracion para Spring Security.
@Configuration
//Aqui vamos a configurar la seguridad de nuestra aplicacion.
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	String[] recursos = new String[] {
			"/CSS/**","/JS/**","/img/**"
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests().antMatchers(recursos).permitAll() //Permite sin autorizacion del logeo
		.antMatchers("/","/index").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/shop").failureUrl("/login?error=true")
		.and()
		.logout().permitAll().logoutSuccessUrl("/login?logout");
	}	
	
	//Encriptacion de contraseña	
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		//El numero 4 indica el nivel de seguridad, del rango de 4 a 31.
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		
		return bCryptPasswordEncoder;
	}
	
	

}
