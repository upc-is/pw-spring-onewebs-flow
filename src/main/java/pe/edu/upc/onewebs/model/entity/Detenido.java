package pe.edu.upc.onewebs.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "detenidos")
@Getter
@Setter
public class Detenido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 8, max = 8, message = "El DNI debe ser de 8 digitos")
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Size(min = 2, message = "El Apellido debe ser como minimo de 2 caracteres")
	@Column(name = "apellidos", length = 50, nullable = false)
	private String apellidos;
	
	@NotBlank(message = "No se aceptan nombres vacios")
	@Column(name = "nombres", length = 30, nullable = false)
	private String nombres;
	
	@Past(message = "La fecha de nacimiento debe ser una fecha pasada")
	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date fechaNacimiento;
	
	@NotBlank(message = "Por favor, ingrese el distrito")
	@Column(name = "distrito", length = 40, nullable = false)
	private String distrito;
	
	// mappedBy: El objeto de relaci�n
	// fetch: 
	@NotEmpty(message = "Un detenido debe tener un multa")
	@OneToMany(mappedBy = "detenido", fetch = FetchType.LAZY)
	private List<Multa> multas;
	
	// joinColumns: Son los atributos de la clase Origen (actual)
	// inverseJoinColumns: Son los atributos de la clase Destino (a relacionarme)
	@NotEmpty(message = "Por favor, especifique la comisaria")
	@ManyToMany
	@JoinTable(name = "detenido_comisaria", 
		joinColumns = { @JoinColumn(name = "detenido_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "comisaria_id", referencedColumnName = "id") } )
	private List<Comisaria> comisarias;
	
	public Detenido() {
		multas =  new ArrayList<>();
		comisarias = new ArrayList<>();
	}
	public void addComisaria(Comisaria comisaria) {
		comisarias.add(comisaria);
	}
	public void addMulta(Multa multa) {
		multas.add(multa);
	}
}

