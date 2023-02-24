package com.gco.app.back.models.entity;

import lombok.Data;

@Data
public class JwtRequest {

	private String correo;
	private String contrasenia;
	
	public JwtRequest() {
	}

	public JwtRequest(String correo, String contrasenia) {
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	
	
	
}
