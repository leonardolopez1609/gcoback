package com.gco.app.back.models.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gco.app.back.models.dao.IPacienteDao;
import com.gco.app.back.models.entity.Paciente;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteDao pacienteDao;

	@Override
	public List<Paciente> findAll() {
		// TODO Auto-generated method stub
		return (List<Paciente>) pacienteDao.findAll();
	}

	@Override
	public Paciente findById(Long id) {
		// TODO Auto-generated method stub
		return pacienteDao.findById(id).orElse(null);
	}

	

	@Override
	public Paciente save(Paciente paciente) {
		// TODO Auto-generated method stub
		return pacienteDao.save(paciente);
	}
	
	
	
   

	@Override
	public Paciente findOneByCorreo(String correo) {
		// TODO Auto-generated method stub
		return pacienteDao.findOneByCorreo(correo);
	}

	@Override
	public Paciente findByCorreoAndByContrasenia(String correo, String contrasenia) {
		
		return pacienteDao.findByCorreoAndContrasenia(correo, contrasenia);
	}



	

	

}
