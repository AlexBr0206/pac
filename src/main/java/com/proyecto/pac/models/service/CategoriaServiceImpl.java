package com.proyecto.pac.models.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyecto.pac.models.entity.Categoria;
import com.proyecto.pac.models.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Override
	public List<Categoria> listaCategoria() {
		return (List<Categoria>) categoriaRepository.findAll();
	}

}
