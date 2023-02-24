package com.gco.app.back.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gco.app.back.models.entity.Paciente;
import com.gco.app.back.models.services.IPacienteService;

@RestController
@RequestMapping("/gco")
@CrossOrigin(origins= {"*"})
public class PacienteRestController {

	@Autowired
	private IPacienteService pacienteService;
	
	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/pacientes")
	public List<Paciente> getPacientes(){
		return pacienteService.findAll();
	}
	
	
	@GetMapping("/pacientes/{id}")
	public ResponseEntity<?> getPaciente(@PathVariable Long id){
		Paciente paciente = null;
		Map<String,Object> response = new HashMap<>();
		 try {
			 paciente=pacienteService.findById(id);
		 }catch(DataAccessException e){
			 response.put("mensaje", "Error al conectarse en la base de datos");
			 response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 if(paciente==null) {
			 response.put("mensaje", "El Paciente de ID ".concat(id.toString().concat(" no existe en la base de datos!")));
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		 }
		return  new ResponseEntity <Paciente> (paciente, HttpStatus.OK);
	}
	
	
	@PutMapping("/pacientes/{id}")
	public ResponseEntity<?> updatePaciente(@RequestBody Paciente paciente,@PathVariable Long id){
		Paciente pacienteActual = pacienteService.findById(id);
		Paciente pacienteNuevo = null;
		
		Map<String,Object> response = new HashMap<>();
		
		if(pacienteActual==null) {
			 response.put("mensaje", "Error al editar, el paciente a editar no existe!");	
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		}
		 try {
			 pacienteActual.setNombre(paciente.getNombre());
			 pacienteActual.setApellido(paciente.getApellido());
			 pacienteActual.setTipoDocumento(paciente.getTipoDocumento());
			 pacienteActual.setDocumento(paciente.getDocumento());
			 pacienteActual.setTelefono(paciente.getTelefono());
			 pacienteActual.setCorreo(paciente.getCorreo());
			 
			 pacienteNuevo= pacienteService.save(pacienteActual);
			 
			 
		 }catch(DataAccessException e){
			 response.put("mensaje", "Error al actualizar en la base de datos");
			 response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 
		 response.put("mensaje", "Paciente actualizado con éxito!");
		 response.put("paciente",pacienteNuevo);
		return  new  ResponseEntity <Map<String, Object>> (response, HttpStatus.CREATED);
	}
	
	  @GetMapping("/pacientescorreo/{co}")
	   public Paciente getCorreo(@PathVariable String co){
		return pacienteService.findOneByCorreo(co);
	       }
	
	
}
