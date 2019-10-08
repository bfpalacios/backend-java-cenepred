package com.cenepred.appcnp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenepred.appcnp.dto.model.CategoriaDTO; 
import com.cenepred.appcnp.service.CategoriaService; 

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/cenepred/categoria/v1")
public class CategoriaRestController {

	@Autowired
	private CategoriaService categoriaService;
	
	
	@GetMapping
	public  ResponseEntity<List<CategoriaDTO>> getAll(){
		System.out.println("Request list of Categorias.");
		List<CategoriaDTO> list = categoriaService.listCategoria();
		if(list ==null) {
			return new ResponseEntity<List<CategoriaDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<CategoriaDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoria){
		System.out.println("Create Categoria" + categoria.getNombre());
		
		CategoriaDTO dto = categoriaService.create(categoria);
		if (dto == null) {
			return new ResponseEntity<CategoriaDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaDTO>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping
	public  ResponseEntity<CategoriaDTO> update(@RequestBody CategoriaDTO categoria){
		System.out.println("Update categoria" + categoria.getNombre());
		
		CategoriaDTO dto = categoriaService.update(categoria);
		if (dto == null) {
			return new ResponseEntity<CategoriaDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<CategoriaDTO>(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<CategoriaDTO> update(@PathVariable("id") int id){
		categoriaService.delete(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<CategoriaDTO> get(@PathVariable("id") int id){
		CategoriaDTO dto = categoriaService.get(id);
		return new ResponseEntity<CategoriaDTO>( dto, HttpStatus.OK);
	}
}

