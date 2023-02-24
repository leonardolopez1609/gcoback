package com.gco.app.back.models.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="paciente")
public class Paciente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idpaciente;
	
	private String nombre;
	private String apellido;
	
	@Column(name="tipo_documento")
	private String tipoDocumento;
	
	@Column(nullable=false , unique=true)
	private String documento;
	private String telefono;
	
	@Column(nullable=false , unique=true)
	private String correo;
	private String contrasenia;
	public Long getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(Long idpaciente) {
		this.idpaciente = idpaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public Paciente(String nombre, String apellido, String tipoDocumento, String documento, String telefono,
			String correo, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDocumento = tipoDocumento;
		this.documento = documento;
		this.telefono = telefono;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	public Paciente() {
		super();
	}
	
	
	

}
