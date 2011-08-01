package beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tiene
 *
 */
@Entity

//@IdClass(TieneId.class) // problemas con los objetos???? con int funciono bien.

public class Tiene implements Serializable {

	@EmbeddedId
	private TieneId id;
	
	private Tarea tarea;////////////////////////// VER PARA PONER ESTADO COMO ID COMPUESTA CON TAREA y fechaini
	
	
	private @Temporal(TemporalType.DATE) Calendar fechaInicio;
	private @Temporal(TemporalType.DATE) Calendar fechaFin;	
	
	
	private Estado estado;
	
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


	public Tarea getTarea() {
		return this.tarea;
	}

	public void setTarea(Tarea tarea) {
		this.tarea = tarea;
	}   
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
   
}


