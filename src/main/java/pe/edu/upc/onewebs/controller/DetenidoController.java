package pe.edu.upc.onewebs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.onewebs.model.entity.Detenido;
import pe.edu.upc.onewebs.service.DetenidoService;

@Controller
@RequestMapping("onewebs/detainee")
public class DetenidoController {
	
	@Autowired
	private DetenidoService detenidoService; 
	
	@GetMapping
	public String start(Model model) {		
		try {
			List<Detenido> detenidos = detenidoService.readAll();
			model.addAttribute("detenidos", detenidos);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		
		return "/detenido/start";
	}
}
