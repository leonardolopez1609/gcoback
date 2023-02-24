package com.gco.app.back.models.dao;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gco.app.back.models.entity.Paciente;

public interface IPacienteDao extends JpaRepository<Paciente, Long> {

	  //
	Paciente findOneByCorreo(String correo);
	Paciente findByCorreoAndContrasenia(String correo, String Contrasenia);
	
}
