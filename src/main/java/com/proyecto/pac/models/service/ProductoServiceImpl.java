package com.proyecto.pac.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.pac.models.entity.Productos;
import com.proyecto.pac.models.repository.ProductoRepository;


@Service
public class ProductoServiceImpl implements IProductoService {
	
	@Autowired
	private ProductoRepository productoRepository;
	
	
	@Override
	public List<Productos> listarTodos() {
		return (List<Productos>) productoRepository.findAll();
	}

	@Override
	public void guardar(Productos productos) {
		productoRepository.save(productos);

	}

	@Override
	public Productos buscarPorId(Integer idproductos) {		
		return productoRepository.findById(idproductos).orElse(null);
	}

	@Override
	public void eliminar(Integer idproductos) {
		productoRepository.deleteById(idproductos);

	}

}
