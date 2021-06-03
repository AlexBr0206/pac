package com.proyecto.pac;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

		@Override
		protected void configure(HttpSecurity http) throws Exception{
			http.authorizeRequests().antMatchers( //Rutas con acceso libre
					"/",
					"/css/**",
					"/js/**",
					"/home/**",
					"/ubicanos/**",
					"/images/**",
					"/productos/verproductos/**",
					"/verproductos/**",
					"/empleado/**",
					"/empleado/validar"
					).permitAll()
			.anyRequest().authenticated() //Cualquier otra ruta es con token
			.and()
			.formLogin()
			.loginPage("/empleado/validar") //Esta ruta se usa para validar al usuario
			.successForwardUrl("/empleado/validar")
			.permitAll()
			.and()
			.logout()
			.permitAll();
		}
}
