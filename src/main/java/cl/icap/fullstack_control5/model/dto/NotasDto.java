package cl.icap.fullstack_control5.model.dto;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="notas")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class NotasDto {
	
	@Id
	private int curso;
	private int alumno;
	private int numero_modulo;
	private int numero_evaluacion;
	private int nota;
	public int getCurso() {
		return curso;
	}
	public void setCurso(int curso) {
		this.curso = curso;
	}
	public int getAlumno() {
		return alumno;
	}
	public void setAlumno(int alumno) {
		this.alumno = alumno;
	}
	public int getNumero_modulo() {
		return numero_modulo;
	}
	public void setNumero_modulo(int numero_modulo) {
		this.numero_modulo = numero_modulo;
	}
	public int getNumero_evaluacion() {
		return numero_evaluacion;
	}
	public void setNumero_evaluacion(int numero_evaluacion) {
		this.numero_evaluacion = numero_evaluacion;
	}
	public int getNota() {
		return nota;
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	
	

}
