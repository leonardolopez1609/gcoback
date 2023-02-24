package com.gco.app.back.models.entity;

import lombok.Data;

@Data
public class JwtResponse {

	
	private String token;

	public JwtResponse(String token) {
		this.token = token;
	}

	public JwtResponse() {
	}
	
	
	
	
}
