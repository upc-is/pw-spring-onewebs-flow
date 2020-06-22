package pe.edu.upc.onewebs.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upc.onewebs.model.entity.Detenido;
import pe.edu.upc.onewebs.service.DetenidoService;

@RestController
@RequestMapping("/onewebs/api/detainees")
public class DetenidoRestController {
	
	@Autowired
	private DetenidoService detenidoService; 
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Detenido> > start() {
		try {
			List<Detenido> detenidos = detenidoService.readAll();
			return new ResponseEntity< List<Detenido> >(detenidos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Detenido > fetchById( @PathVariable("id") Integer id ) {
		try {
			Optional<Detenido> optional = detenidoService.findById(id);
			if( optional.isPresent() ) {
				return new ResponseEntity< Detenido >( optional.get(), HttpStatus.OK);
			}
			else {
				return new ResponseEntity< Detenido >( HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< Detenido >( HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Detenido > saveDetainee( @RequestBody Detenido detenido ) {
		try {
			Detenido newDetenido = detenidoService.create(detenido);
			return new ResponseEntity< Detenido >(newDetenido, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Detenido >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
}
