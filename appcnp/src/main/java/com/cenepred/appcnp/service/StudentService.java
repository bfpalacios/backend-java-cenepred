package com.cenepred.appcnp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cenepred.appcnp.dto.model.StudentDTO;


public interface StudentService {
	public StudentDTO create(StudentDTO obj);
	public StudentDTO update(StudentDTO obj);
	public boolean delete(String id);
	public List<StudentDTO> listStudents();
	public StudentDTO get(String id);
}
