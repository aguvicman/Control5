package cl.icap.fullstack_control5.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.icap.fullstack_control5.model.dto.NotasDto;
import cl.icap.fullstack_control5.repository.NotasRepository;


@Service
public class NotasServiceImp implements NotasService {
	
	@Autowired
	NotasRepository notasRepository;
	
	@Override
	public List<NotasDto> list(){
		return notasRepository.findAll();
	}

	@Override
	public NotasDto insert(NotasDto notasDto) {
		return notasRepository.save(notasDto);
	}

	@Override
	public NotasDto get(int curso) {
		return notasRepository.getOne(curso);
	}

	@Override
	public NotasDto update(NotasDto notasDto) {
		return notasRepository.save(notasDto);
	}

	@Override
	public void delete(NotasDto notasDto) {
		 notasRepository.delete(notasDto);
	}
	

}
