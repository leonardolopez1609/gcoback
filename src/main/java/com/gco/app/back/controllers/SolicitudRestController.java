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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.gco.app.back.models.entity.Solicitud;
import com.gco.app.back.models.services.ISolicitudService;

@RestController
@RequestMapping("/gco")
@CrossOrigin(origins= {"*"})
public class SolicitudRestController {

	@Autowired
	private ISolicitudService solicitudService;
	
	
	@GetMapping("/solicitudes/{type}/{id}")
	public ResponseEntity<?> findActByPaciente(@PathVariable Long id,@PathVariable String type ) {
		long ids=0;
		List<Solicitud> solicitudesAct = null;
	
		Map<String,Object> response = new HashMap<>();
		String txt="";
		 try {
			 switch (type) {
			case "activas": {
				ids=3;
				 solicitudesAct=solicitudService.findByPacienteAndTipoSolicitud(id,ids);
				break;
			}
		
			case "pendientes": {
				ids=1;
				solicitudesAct=solicitudService.findByPacienteAndTipoSolicitud(id,ids);
				break;
			}
			case "historial": {
				solicitudesAct=solicitudService.findByPacienteAndHistorial(id);
				txt="en ";
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + type);
			}
			 
			
		 }catch(DataAccessException e){
			 response.put("mensaje", "Error al conectarse en la base de datos");
			 response.put("error",e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.INTERNAL_SERVER_ERROR);
		 }
		 if(solicitudesAct.isEmpty()) {
			 response.put("mensaje", "El Paciente no posee citas "+txt+ type);
			 return new ResponseEntity <Map<String, Object>> (response, HttpStatus.NOT_FOUND);
		 }
		return new ResponseEntity <List<Solicitud>> (solicitudesAct, HttpStatus.OK);
	}
	
	
	
	
}
