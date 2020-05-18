package pe.edu.upc.onewebs.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "comisarias")
@Getter
@Setter
public class Comisaria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "denominacion", length = 30, nullable = false)	
	private String denominacion;
	
	@Column(name = "distrito", length = 35, nullable = false)
	private String distrito;
	
	@Column(name = "direccion", length = 40, nullable = false)
	private String direccion; 
	
	// mappedBy: El objeto de relaci�n 
	@ManyToMany(mappedBy = "comisarias")
	private List<Detenido> detenidos;	
	
	public Comisaria() {
		detenidos = new ArrayList<>();
	}
	
}












