package com.cenepred.appcnp.dto.mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cenepred.appcnp.dto.model.StudentDTO;
import com.cenepred.appcnp.model.Student;


@Component
public class StudentMapper {

	public static StudentDTO toStudentDTO(Student student) {
		StudentDTO dto = new StudentDTO();
		dto.setId(student.getsStudentID());
		dto.setNombre(student.getsStudentNombre());
		dto.setApellido(student.getsStudentApellido());
		dto.setCodigoStudent(student.getlStudentCodigo());
		dto.setEdad(student.getiStudentEdad());
		
		return dto;
	}
	public static Student toStudent(StudentDTO dto) {
		Student student = new Student();
		student.setsStudentID(dto.getId());
		student.setsStudentNombre(dto.getNombre());
		student.setsStudentApellido(dto.getApellido());
		student.setlStudentCodigo(dto.getCodigoStudent());
		student.setiStudentEdad(dto.getEdad());
		
		return student;
	}
	
	public static List<StudentDTO> toStudentDTO(List<Student> list) {
		StudentDTO dto;
		List<StudentDTO> listDTO = new ArrayList<>();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Student student = (Student) iterator.next();
			dto = new StudentDTO();
			dto.setId(student.getsStudentID());
			dto.setNombre(student.getsStudentNombre());
			dto.setApellido(student.getsStudentApellido());
			dto.setCodigoStudent(student.getlStudentCodigo());
			dto.setEdad(student.getiStudentEdad());
			listDTO.add(dto);
		}
		
		
		return listDTO;
	}
	
	
}
