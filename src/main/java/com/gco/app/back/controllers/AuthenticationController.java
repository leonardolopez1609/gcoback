package com.gco.app.back.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gco.app.back.models.entity.JwtRequest;
import com.gco.app.back.models.entity.JwtResponse;
import com.gco.app.back.models.entity.Paciente;
import com.gco.app.back.models.services.IPacienteService;
@RestController
@RequestMapping("/gco")
@CrossOrigin(origins= {"*"})
public class AuthenticationController {

      @Autowired
      IPacienteService pacienteService;
	
	@PostMapping("/login")
	public ResponseEntity<?> generarToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		Paciente paciente = null;
		Map<String,Object> response = new HashMap<>();
		 try {
			 paciente=pacienteService.findByCorreoAndByContrasenia(jwtRequest.getCorreo(), jwtRequest.getContrasenia());
		 }catch(DataAccessException e){
			 response.put("mensaje", "Error al conectarse en la base de datos");
			 response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 if(paciente==null) {
			 response.put("mensaje", "* Correo o contraseña inválidos! *");
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		 }
		return  new ResponseEntity <Paciente> (paciente, HttpStatus.OK);
	}
	
	

}
