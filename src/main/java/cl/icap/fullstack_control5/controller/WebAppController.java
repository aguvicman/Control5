package cl.icap.fullstack_control5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class WebAppController {

	 @RequestMapping("/")
	    public String getHome() {
	        return "index";
	    }
	   
	    @RequestMapping("/notas_page")
	    public String getNotaspage() {
	        return "notas";
	    }
	

	    @RequestMapping("/alumno_page")
	    public String getAlumnopage() {
	        return "alumno";
	    }
}
