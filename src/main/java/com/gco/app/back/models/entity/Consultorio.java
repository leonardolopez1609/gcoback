package com.gco.app.back.models.entity;

import java.io.Serializable;
import jakarta.persistence.*;


@Entity
@Table(name="consultorio")
public class Consultorio implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idconsultorio;
	
	private String nombre;
	private String direccion;
	private String telefono;
	
	@Column(name="user_login")
	private String userlogin;
	
	private String contrasenia;

	public Long getIdconsultorio() {
		return idconsultorio;
	}

	public void setIdconsultorio(Long idconsultorio) {
		this.idconsultorio = idconsultorio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUserlogin() {
		return userlogin;
	}
 
	public void setUserlogin(String userlogin) {
		this.userlogin = userlogin;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Consultorio(String nombre, String direccion, String telefono, String userlogin, String contrasenia) {
		super();
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.userlogin = userlogin;
		this.contrasenia = contrasenia;
	}

	public Consultorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
