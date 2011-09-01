package beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.*;


public class Tiene implements Serializable {

	private int id;
	private Calendar fechaInicio;
	private Calendar fechaFin;	
	
	
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
	
	
   
}


