package com.cenepred.appcnp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cenepred.appcnp.dto.mapper.StudentMapper;
import com.cenepred.appcnp.dto.model.StudentDTO;
import com.cenepred.appcnp.model.Student;
import com.cenepred.appcnp.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repository;
	
	@Override
	public StudentDTO create(StudentDTO dto) {
		return StudentMapper.toStudentDTO(repository.save(StudentMapper.toStudent(dto)));
	}

	@Override
	public StudentDTO update(StudentDTO dto) {
		return StudentMapper.toStudentDTO(repository.save(StudentMapper.toStudent(dto)));
	}

	@Override
	public boolean delete(String id) {
		repository.deleteById(id);
		return true;
	}

	@Override
	public List<StudentDTO> listStudents() {
		return StudentMapper.toStudentDTO(repository.findAll());
	}

	@Override
	public StudentDTO get(String id) {
		Optional<Student> opt = repository.findById(id);
		return StudentMapper.toStudentDTO(opt.get());
	}

}
