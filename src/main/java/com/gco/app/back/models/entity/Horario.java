package com.gco.app.back.models.entity;

import java.io.Serializable;
import jakarta.persistence.*;
@Entity
@Table(name="horario")
public class Horario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idhorario;
	
	private String hora;
	private int capacidad;
	public Long getIdhorario() {
		return idhorario;
	}
	public void setIdhorario(Long idhorario) {
		this.idhorario = idhorario;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Horario(String hora, int capacidad) {
		super();
		this.hora = hora;
		this.capacidad = capacidad;
	}
	public Horario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
