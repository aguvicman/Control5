package cl.icap.fullstack_control5.service;

import java.util.List;


import cl.icap.fullstack_control5.model.dto.NotasDto;


public interface NotasService {
	public NotasDto insert(NotasDto notasDto);
	public NotasDto get(int curso);
	public NotasDto update(NotasDto notasDto);
	public void delete (NotasDto notasDto);
	public List<NotasDto> list();

}
