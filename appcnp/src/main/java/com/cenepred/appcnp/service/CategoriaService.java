package com.cenepred.appcnp.service;

import java.util.List;

import com.cenepred.appcnp.dto.model.CategoriaDTO; 

public interface CategoriaService {

	
	public CategoriaDTO create(CategoriaDTO obj);
	public CategoriaDTO update(CategoriaDTO obj);
	public boolean delete(int id);
	public List<CategoriaDTO> listCategoria();
	public CategoriaDTO get(int id);
} 
