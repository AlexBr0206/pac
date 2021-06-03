package com.proyecto.pac.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.proyecto.pac.models.entity.Empleado;

public interface EmpleadoRepository extends CrudRepository<Empleado, Integer> {
		@Query(value = "SELECT * FROM empleado WHERE correoe = ?1 AND claveacceso = ?2 ", nativeQuery = true)
		Empleado validar(String correoe, byte[] claveacceso);
}


