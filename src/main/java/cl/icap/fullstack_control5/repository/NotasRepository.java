package cl.icap.fullstack_control5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.icap.fullstack_control5.model.dto.NotasDto;

public interface NotasRepository extends JpaRepository<NotasDto, Integer> {

}
