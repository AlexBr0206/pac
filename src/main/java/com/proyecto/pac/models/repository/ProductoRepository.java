package com.proyecto.pac.models.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.pac.models.entity.Productos;


@Repository
public interface ProductoRepository extends CrudRepository<Productos, Integer> {

}
