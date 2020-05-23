package pe.edu.upc.onewebs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("onewebs")
public class DetenidoController {
	
	@GetMapping
	public String cualquierMetodo() {
		return "cualquierarchivo";
	}
}
