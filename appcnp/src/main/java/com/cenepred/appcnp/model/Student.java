package com.cenepred.appcnp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name = "students")
public class Student {
	@Id
	private String sStudentID;
	@Column
	private String sStudentNombre;
	@Column
	private String sStudentApellido;
	@Column
	private int iStudentEdad;
	@Column
	private long lStudentCodigo;
	
	
	public String getsStudentID() {
		return sStudentID;
	}
	public void setsStudentID(String sStudentID) {
		this.sStudentID = sStudentID;
	}
	public String getsStudentNombre() {
		return sStudentNombre;
	}
	public void setsStudentNombre(String sStudentNombre) {
		this.sStudentNombre = sStudentNombre;
	}
	public String getsStudentApellido() {
		return sStudentApellido;
	}
	public void setsStudentApellido(String sStudentApellido) {
		this.sStudentApellido = sStudentApellido;
	}
	public int getiStudentEdad() {
		return iStudentEdad;
	}
	public void setiStudentEdad(int iStudentEdad) {
		this.iStudentEdad = iStudentEdad;
	}
	public long getlStudentCodigo() {
		return lStudentCodigo;
	}
	public void setlStudentCodigo(long lStudentCodigo) {
		this.lStudentCodigo = lStudentCodigo;
	}
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String sStudentID, String sStudentNombre, String sStudentApellido, int iStudentEdad,
			long lStudentCodigo) {
		super();
		this.sStudentID = sStudentID;
		this.sStudentNombre = sStudentNombre;
		this.sStudentApellido = sStudentApellido;
		this.iStudentEdad = iStudentEdad;
		this.lStudentCodigo = lStudentCodigo;
	}
	
	
}
