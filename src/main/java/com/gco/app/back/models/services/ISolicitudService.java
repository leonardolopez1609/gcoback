package com.gco.app.back.models.services;

import java.util.List;

import com.gco.app.back.models.entity.Solicitud;

public interface ISolicitudService {

	public List <Solicitud> findByPacienteAndTipoSolicitud(Long id,Long ids);
    public List <Solicitud> findByPacienteAndHistorial(Long id);
    
    
	
	
}
