package com.cenepred.appcnp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cenepred.appcnp.dto.model.StudentDTO;
import com.cenepred.appcnp.service.StudentService;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/cenepred/students/v1")
public class StudentRestController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping
	public  ResponseEntity<List<StudentDTO>> getAll(){
		System.out.println("Request list of Students.");
		List<StudentDTO> list = service.listStudents();
		if(list ==null) {
			return new ResponseEntity<List<StudentDTO>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<StudentDTO>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public  ResponseEntity<StudentDTO> create(@RequestBody StudentDTO student){
		System.out.println("Create Student" + student.getNombre());
		
		StudentDTO dto = service.create(student);
		if (dto == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.CREATED);
	}
	
	@PutMapping
	public  ResponseEntity<StudentDTO> update(@RequestBody StudentDTO student){
		System.out.println("Update Student" + student.getNombre());
		
		StudentDTO dto = service.update(student);
		if (dto == null) {
			return new ResponseEntity<StudentDTO>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<StudentDTO>(dto, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/{id}")
	public  ResponseEntity<StudentDTO> update(@PathVariable("id") String id){
		service.delete(id);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public  ResponseEntity<StudentDTO> get(@PathVariable("id") String id){
		StudentDTO dto = service.get(id);
		return new ResponseEntity<StudentDTO>( dto, HttpStatus.OK);
	}
}
