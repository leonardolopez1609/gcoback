package com.gco.app.back.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import com.gco.app.back.models.entity.Solicitud;

public interface ISolicitudDao extends JpaRepository<Solicitud, Long> {
	
	
	public List <Solicitud> findByPaciente_idpacienteAndEstadoSolicitud_idestadosolicitud(Long idp,long ide);
	@Query("select u from Solicitud u where (u.estadoSolicitud=4 or u.estadoSolicitud=2) and u.paciente.idpaciente= :id")
	public List <Solicitud> findByHistorial(@RequestParam ("id") Long id);
}
 