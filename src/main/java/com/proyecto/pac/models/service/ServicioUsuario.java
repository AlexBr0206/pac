package com.proyecto.pac.models.service;

import java.security.MessageDigest;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.pac.models.entity.Empleado;
import com.proyecto.pac.models.repository.EmpleadoRepository;

@Service
public class ServicioUsuario {
	
	@Autowired
	private EmpleadoRepository repoEmpleado;
	private String Mensaje;
	
	public String getMensaje() {
		return Mensaje;
	}
	
	public boolean validar(String correoe, String clave, HttpSession sesion) {
		Empleado usr = repoEmpleado.validar(correoe, encriptar(clave));
		if (usr != null) {
			sesion.setAttribute("iduser", usr.getIdempleado());
			Mensaje = usr.getNombre() + " - " + usr.getCorreoe();
			return true;
		}
		Mensaje = "Datos de acceso incorrectos.";
		return false;
	}
	
	private byte[] encriptar(String clave) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-1");
			digest.reset();
			digest.update(clave.getBytes("utf8"));
			return digest.digest();
		}catch (Exception e) {
			return null;
		}
	}
	
	public boolean agregar(Empleado u, String clave, HttpSession sesion) {
		try {
			u.setClaveacceso(encriptar(clave));
			repoEmpleado.save(u);
			sesion.setAttribute("iduser", u.getIdempleado());
			this.Mensaje = "Datos del usuario almacenados con éxito.";
			return true;
		}catch(Exception e){
			this.Mensaje = "Error al registar al usuario.";
			return false;
		}
	}
	
	public Empleado buscar(int id) {
		try {
			Empleado empleado = repoEmpleado.findById(id).get();
			return empleado == null ? new Empleado() : empleado;
		} catch (Exception e) {
			this.Mensaje = "No se pudo realizar la búsqueda del usuario.";
			return null;
		}
	}
}
