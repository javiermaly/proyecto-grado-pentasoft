package beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tiene
 *
 */
@Entity

public class Tiene implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private @Temporal(TemporalType.DATE) Calendar fechaInicio;
	private @Temporal(TemporalType.DATE) Calendar fechaFin;	
	@ManyToOne		//ACA NO SERIA ONE TO MANY????
	private Estado estado;
	
	@ManyToOne
	private Tarea tarea;
	
	private static final long serialVersionUID = 1L;

	public Tiene() {
		super();
	}   
  
	
	public Calendar getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Calendar fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Calendar getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Calendar fechaFin) {
		this.fechaFin = fechaFin;
	}



	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Tarea getTarea() {
		return tarea;
	}


	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}
	
	
   
}


