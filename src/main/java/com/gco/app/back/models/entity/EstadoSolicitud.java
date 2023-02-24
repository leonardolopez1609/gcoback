package com.gco.app.back.models.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="estado_solicitud")
public class EstadoSolicitud implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idestado_solicitud")
	private Long idestadosolicitud;
	
	private String nombre;
	private String descripcion;
	public Long getIdestadosolicitud() {
		return idestadosolicitud;
	}
	public void setIdestadosolicitud(Long idestadosolicitud) {
		this.idestadosolicitud = idestadosolicitud;
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
	public EstadoSolicitud(String nombre, String descripcion) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	public EstadoSolicitud() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
