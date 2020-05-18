package pe.edu.upc.onewebs.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "multas")
@Getter
@Setter
public class Multa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "detenido_id")
	private Detenido detenido;
	
	@Column(name = "fecha_detencion", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaDetencion;
	
	@Column(name = "direccion", length = 40, nullable = false)
	private String direccion;
	
	@Column(name = "infraccion", length = 10, nullable = false)
	private String infraccion;
	
	@Column(name = "monto", nullable = false )
	private double monto;
	
}










