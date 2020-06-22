package cl.icap.fullstack_control5.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cl.icap.fullstack_control5.model.dto.AlumnoDto;
import cl.icap.fullstack_control5.service.AlumnoService;

@RestController
@RequestMapping(value="/alumno")
public class AlumnoController {
	
	
	@Autowired
	AlumnoService alumnoService;
	
	@RequestMapping(value="/list")
	public List<AlumnoDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		return alumnoService.list();
	}

	@RequestMapping(value="/get")
	public @ResponseBody AlumnoDto ajaxGet(HttpServletRequest req, HttpServletResponse res) {

		return alumnoService.get(Integer.parseInt(req.getParameter("rut"))); 
		
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			AlumnoDto valoresDto = gson.fromJson(requestData, AlumnoDto.class);
			valoresDto = alumnoService.insert(valoresDto);
			
			if(valoresDto != null) {
				
				rows=1;
				
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rows;
			
		}	
		
	
	@RequestMapping(value="/update")
	public @ResponseBody int ajaxUpdate(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			AlumnoDto alumnoDto = gson.fromJson(requestData, AlumnoDto.class);
			alumnoDto = alumnoService.update(alumnoDto);
			
			if(alumnoDto == null) {
				rows=0;	
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
			return rows;
			
		}	
		
		
	@RequestMapping(value="/delete")
	public @ResponseBody int ajaxDelete(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		
		try {
			AlumnoDto alumnoDto = new AlumnoDto();
			alumnoDto.setRut(Integer.parseInt(req.getParameter("rut")));
			alumnoService.delete(alumnoDto);
			rows=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return rows;
			
		}	
		
	
	

}
