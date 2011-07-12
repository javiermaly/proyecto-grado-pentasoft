package beans;

import java.io.Serializable;
import java.lang.String;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tarea
 *
 */
@Entity

public class Tarea implements Serializable {

	   
	@Id
	private int id;
	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private @Temporal(TemporalType.DATE) Calendar fechaInicio;
	private @Temporal(TemporalType.TIMESTAMP) Calendar fechaFin;
	private @Temporal(TemporalType.TIMESTAMP) Calendar horaInicio;
	private @Temporal(TemporalType.DATE) Calendar fechaComprometida;
	private Tipo tipo;
	
	
	private static final long serialVersionUID = 1L;

	public Tarea() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public boolean getEsExterna() {
		return this.esExterna;
	}

	public void setEsExterna(boolean esExterna) {
		this.esExterna = esExterna;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
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
	public Calendar getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Calendar horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Calendar getFechaComprometida() {
		return fechaComprometida;
	}
	public void setFechaComprometida(Calendar fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
   
	
}
