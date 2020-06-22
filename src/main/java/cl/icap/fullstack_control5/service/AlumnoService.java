package cl.icap.fullstack_control5.service;

import java.util.List;

import cl.icap.fullstack_control5.model.dto.AlumnoDto;



public interface AlumnoService {

	public AlumnoDto insert(AlumnoDto alumnoDto);
	public AlumnoDto get(int rut);
	public AlumnoDto update(AlumnoDto alumnoDto);
	public void delete (AlumnoDto alumnoDto);
	public List<AlumnoDto> list();
	
}
