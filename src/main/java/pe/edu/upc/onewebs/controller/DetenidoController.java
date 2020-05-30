package pe.edu.upc.onewebs.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.onewebs.model.entity.Detenido;
import pe.edu.upc.onewebs.service.DetenidoService;

@Controller
@RequestMapping("onewebs/detainee")
@SessionAttributes("detenido")
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
	
	@GetMapping("/new")
	public String nuevo(Model model) {
		Detenido detenido = new Detenido();
		model.addAttribute("detenido", detenido);
		return "/detenido/nuevo";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("detenido") Detenido detenido, Model model, SessionStatus status) {
		try {
			detenidoService.create(detenido);
			status.setComplete();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return "redirect:/onewebs/detainee";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				model.addAttribute("detenido", optional.get());
			}
			else {
				return "redirect:/onewebs/detainee";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/detenido/edit";
	}
	@GetMapping("/del/{id}")
	public String del(@PathVariable("id") Integer id,  Model model) {
		try {
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				detenidoService.deleteById(id);
			}
			else {
				return "redirect:/onewebs/detainee";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/onewebs/detainee";
	}
	
	
	
	
	
	
	
	
	
}
