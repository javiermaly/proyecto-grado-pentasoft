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
	private Tarea tarea;////////////////////////// VER PARA PONER ESTADO COMO ID COMPUESTA CON TAREA
	private Estado estado;
//	private Calendar fechaInicio;
//	private Calendar fechaFin;
	
	
	private static final long serialVersionUID = 1L;

	public Tiene() {
		super();
	}   
//	public Calendar getFechaInicio() {
//		return this.fechaInicio;
//	}
//
//	public void setFechaInicio(Calendar fechaInicio) {
//		this.fechaInicio = fechaInicio;
//	}   
//	public Calendar getFechaFin() {
//		return this.fechaFin;
//	}
//
//	public void setFechaFin(Calendar fechaFin) {
//		this.fechaFin = fechaFin;
//	}   
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
