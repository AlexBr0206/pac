package com.proyecto.pac.models.service;

import java.util.List;

import com.proyecto.pac.models.entity.Productos;

public interface IProductoService {
	public List<Productos> listarTodos();
	public void guardar(Productos productos);
	public Productos buscarPorId(Integer idproductos);
	public void eliminar(Integer idproductos);
}
