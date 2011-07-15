package beans;

import java.io.Serializable;
import java.lang.String;

import java.util.Calendar;

import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tarea
 *
 */
@Entity

public class Tarea implements Serializable {

	   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private @Temporal(TemporalType.DATE) Calendar fechaApertura;
	private @Temporal(TemporalType.DATE) Calendar fechaCierre;
	//private @Temporal(TemporalType.TIMESTAMP) Calendar horaInicio;
	private @Temporal(TemporalType.DATE) Calendar fechaComprometida;
	@ManyToOne
	private Tipo tipo;	
	@OneToMany(mappedBy="tarea")
	private List<Realiza> listRealiza;	
	@ManyToOne
	private Cliente cliente;
	
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
	
	
	public Calendar getFechaApertura() {
		return fechaApertura;
	}
	public void setFechaApertura(Calendar fechaApertura) {
		this.fechaApertura = fechaApertura;
	}
	public Calendar getFechaCierre() {
		return fechaCierre;
	}
	public void setFechaCierre(Calendar fechaCierre) {
		this.fechaCierre = fechaCierre;
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
	public void setListRealiza(List<Realiza> listRealiza) {
		this.listRealiza = listRealiza;
	}
	public List<Realiza> getListRealiza() {
		return listRealiza;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Cliente getCliente() {
		return cliente;
	}
   
	
}
