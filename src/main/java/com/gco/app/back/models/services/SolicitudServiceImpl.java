package com.gco.app.back.models.services;


import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gco.app.back.models.dao.ISolicitudDao;
import com.gco.app.back.models.entity.Paciente;
import com.gco.app.back.models.entity.Solicitud;
import com.gco.app.back.models.entity.TipoSolicitud;

import jakarta.transaction.Transactional;

@Service
public class SolicitudServiceImpl implements ISolicitudService {

	@Autowired
	private ISolicitudDao solicitudDao;

	@Override
	public List<Solicitud> findByPacienteAndTipoSolicitud(Long idpaciente, Long ide) {
		// TODO Auto-generated method stub
		return solicitudDao.findByPaciente_idpacienteAndEstadoSolicitud_idestadosolicitud(idpaciente, ide);
		
	}



	@Override
	public List<Solicitud> findByPacienteAndHistorial(Long id) {
		return solicitudDao.findByHistorial(id);
	}

}
