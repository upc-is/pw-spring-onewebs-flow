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
	
	@Column(name = "dni", length = 8, nullable = false)
	private String dni;
	
	@Column(name = "apellidos", length = 50, nullable = false)
	private String apellidos;
	
	@Column(name = "nombres", length = 30, nullable = false)
	private String nombres;
	
	@Column(name = "fecha_nacimiento", nullable = false)
	@Temporal(value = TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "distrito", length = 40, nullable = false)
	private String distrito;
	
	// mappedBy: El objeto de relaci�n
	// fetch: 
	@OneToMany(mappedBy = "detenido", fetch = FetchType.LAZY)
	private List<Multa> multas;
	
	// joinColumns: Son los atributos de la clase Origen (actual)
	// inverseJoinColumns: Son los atributos de la clase Destino (a relacionarme)
	@ManyToMany
	@JoinTable(name = "detenido_comisaria", 
		joinColumns = { @JoinColumn(name = "detenido_id", referencedColumnName = "id") },
		inverseJoinColumns = { @JoinColumn(name = "comisaria_id", referencedColumnName = "id") } )
	private List<Comisaria> comisarias;
	
	public Detenido() {
		multas =  new ArrayList<>();
		comisarias = new ArrayList<>();
	}
}

