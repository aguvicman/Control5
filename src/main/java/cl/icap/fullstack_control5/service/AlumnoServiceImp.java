package cl.icap.fullstack_control5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.icap.fullstack_control5.model.dto.AlumnoDto;
import cl.icap.fullstack_control5.repository.AlumnoRepository;




@Service
public class AlumnoServiceImp implements AlumnoService {

	@Autowired
	AlumnoRepository alumnoRepository;
	
	@Override
	public List<AlumnoDto> list(){
		return alumnoRepository.findAll();
	}

	@Override
	public AlumnoDto insert(AlumnoDto alumnoDto) {
		return alumnoRepository.save(alumnoDto);
	}

	@Override
	public AlumnoDto get(int rut) {
		return alumnoRepository.getOne(rut);
	}

	@Override
	public AlumnoDto update(AlumnoDto alumnoDto) {
		return alumnoRepository.save(alumnoDto);
	}

	@Override
	public void delete(AlumnoDto notasDto) {
		alumnoRepository.delete(notasDto);
	}
	

}
