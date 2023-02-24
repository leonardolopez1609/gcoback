package com.gco.app.back.models.entity;

import java.io.Serializable;

import jakarta.persistence.*;

@Entity
@Table(name="multa")
public class Multa implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmulta;
	
	private String monto;

	public Long getIdmulta() {
		return idmulta;
	}

	public void setIdmulta(Long idmulta) {
		this.idmulta = idmulta;
	}

	public String getMonto() {
		return monto;
	}

	public void setMonto(String monto) {
		this.monto = monto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Multa(String monto) {
		super();
		this.monto = monto;
	}

	public Multa() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
