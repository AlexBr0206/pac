package com.proyecto.pac.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.proyecto.pac.models.entity.Empleado;
import com.proyecto.pac.models.service.ServicioUsuario;

@Controller
public class EmpleadoController {
	@Autowired
	ServicioUsuario servicioUsuario; 
	
	@GetMapping(path = {"/empleado/validar"})
	public String validar() {
		return "empleado/validar";
	}
	
	@PostMapping("/empleado/validar")
	public String agregar(@RequestParam("username") String correoe,
			@RequestParam("password") String claveacceso,
			Model modelo) {
			return "redirect:/productos/";
	}
	
	@GetMapping("/empleado/agregar")
	public String agregar(Model model) {
		model.addAttribute("usuario", new Empleado());
		return "empleado/agregar";
	}
	
	@PostMapping("/empleado/agregar")
	public String agregar (Model modelo, @ModelAttribute Empleado user,
			@RequestParam("clave") String clave, HttpSession sesion) {
		boolean res = servicioUsuario.agregar(user, clave, sesion);
		if(res) {
			return "redirect:/empleado/agregar";
		}
		modelo.addAttribute("error", servicioUsuario.getMensaje());
		return "empleado/agregar";
	}
	
	@GetMapping("/empleado/salir")
	public String salir(HttpSession sesion) {
		SecurityContextHolder.clearContext();
		sesion.invalidate();
		return "redirect:/";
	}
}
