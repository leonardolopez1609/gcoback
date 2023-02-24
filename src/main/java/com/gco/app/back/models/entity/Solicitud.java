package com.gco.app.back.models.entity;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="solicitud")
public class Solicitud implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idsolicitud;
	
	private String fecha;
	private String observaciones;
	
	@ManyToOne
	@JoinColumn(name="idpaciente")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name="idconsultorio")
	private Consultorio consultorio;
	
	@ManyToOne
	@JoinColumn(name="idhorario")
	private Horario horario;
	
	@ManyToOne
	@JoinColumn(name="idtipo_solicitud")
	private TipoSolicitud tipoSolicitud;
	
	@ManyToOne
	@JoinColumn(name="idestado_solicitud")
	private EstadoSolicitud estadoSolicitud;
	
	@ManyToOne
	@JoinColumn(name="idmulta")
	private Multa multa;

	public Long getIdsolicitud() {
		return idsolicitud;
	}

	public void setIdsolicitud(Long idsolicitud) {
		this.idsolicitud = idsolicitud;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Consultorio getConsultorio() {
		return consultorio;
	}

	public void setConsultorio(Consultorio consultorio) {
		this.consultorio = consultorio;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}

	public TipoSolicitud getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(TipoSolicitud tipoSolicitud) {
		this.tipoSolicitud = tipoSolicitud;
	}

	public EstadoSolicitud getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(EstadoSolicitud estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public Multa getMulta() {
		return multa;
	}

	public void setMulta(Multa multa) {
		this.multa = multa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Solicitud(String fecha, String observaciones, Paciente paciente, Consultorio consultorio, Horario horario,
			TipoSolicitud tipoSolicitud, EstadoSolicitud estadoSolicitud, Multa multa) {
		super();
		this.fecha = fecha;
		this.observaciones = observaciones;
		this.paciente = paciente;
		this.consultorio = consultorio;
		this.horario = horario;
		this.tipoSolicitud = tipoSolicitud;
		this.estadoSolicitud = estadoSolicitud;
		this.multa = multa;
	}

	public Solicitud() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
