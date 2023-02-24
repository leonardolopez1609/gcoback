package com.gco.app.back.models.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="tipo_solicitud")
public class TipoSolicitud implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idtipo_solicitud")
	private Long idtiposolicitud;
	
	private String nombre;
	private String descripcion;
	public Long getIdtiposolicitud() {
		return idtiposolicitud;
	}
	public void setIdtiposolicitud(Long idtiposolicitud) {
		this.idtiposolicitud = idtiposolicitud;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public TipoSolicitud(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public TipoSolicitud() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
