package com.gco.app.back.models.services;

import java.util.List;


import com.gco.app.back.models.entity.Paciente;

public interface IPacienteService{

	public List <Paciente> findAll();
	public Paciente findById(Long id);
	public Paciente save(Paciente paciente);
	public Paciente findOneByCorreo(String correo);
	public Paciente findByCorreoAndByContrasenia(String correo, String contrasenia);
	
	
}
