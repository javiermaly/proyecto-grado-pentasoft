package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Realiza
 *
 */
@Entity
public class Realiza implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;//?????
	private @Temporal(TemporalType.DATE) Calendar fechaInicio;
	private @Temporal(TemporalType.DATE) Calendar fechaFin;
	private Usuario usu;
	
	//@OneToMany(mappedBy="realiza", cascade=CascadeType.ALL)// consulta en mappedBy realiza o usuario?
	private List<Tarea> colTareas= new ArrayList<Tarea>();;
	
	private static final long serialVersionUID = 1L;

	
	public Realiza() {
		super();
	}   
	public Calendar getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}   
	public Calendar getFechaFin() {
		return this.fechaFin;
	}

	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}   
	public Usuario getUsu() {
		return this.usu;
	}

	public void setUsu(Usuario usu) {
		this.usu = usu;
	}   
	
	
   
}
