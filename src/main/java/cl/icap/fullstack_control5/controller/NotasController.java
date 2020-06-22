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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import cl.icap.fullstack_control5.model.dto.NotasDto;
import cl.icap.fullstack_control5.service.NotasService;



@Controller
@RequestMapping(value="/notas")
public class NotasController {
	@Autowired
	NotasService notasService;
	
	@RequestMapping(value="/list")
	public @ResponseBody List<NotasDto> ajaxList(HttpServletRequest req, HttpServletResponse res) {
		return notasService.list();
	}

	@RequestMapping(value="/get")
	public @ResponseBody NotasDto ajaxGet(HttpServletRequest req, HttpServletResponse res) {

		return notasService.get(Integer.parseInt(req.getParameter("curso"))); 
		
	}
	
	@RequestMapping(value="/insert")
	public @ResponseBody int ajaxInsert(HttpServletRequest req, HttpServletResponse res) {
		int rows=0;
		
		String requestData;
		try {
			requestData = req.getReader().lines().collect(Collectors.joining());
			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
			NotasDto notasDto = gson.fromJson(requestData, NotasDto.class);
			notasDto = notasService.insert(notasDto);
			
			if(notasDto != null) {
				
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
			NotasDto notasDto = gson.fromJson(requestData, NotasDto.class);
			notasDto = notasService.update(notasDto);
			
			if(notasDto == null) {
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
			NotasDto notasDto = new NotasDto();
			notasDto.setCurso(Integer.parseInt(req.getParameter("curso")));
			notasService.delete(notasDto);
			rows=1;
		} catch (Exception e) {
			e.printStackTrace();
		}
			return rows;
			
		}	
		
		
	
	

}
