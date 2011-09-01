package beans;

import java.io.Serializable;
import java.lang.String;

import java.util.ArrayList;
import java.util.Calendar;

import java.util.List;

import javax.persistence.*;

public class Tarea implements Serializable {

	   
	
	private int id;
	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private Calendar fechaApertura;
	private Calendar fechaComprometida;
	private Calendar fechaCierre;
	
	private Tipo tipo;	
	
	private List<Realiza> listRealiza=new ArrayList<Realiza>();	

	private Cliente cliente;	

	private List<Tiene> colTiene=new ArrayList<Tiene>();	
	
	int prioridad;
	
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

	public List<Tiene> getColTiene() {
		return colTiene;
	}

	

	public int getPrioridad() {
		return prioridad;
	}


	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}


	public void setColTiene(List<Tiene> colTiene) {
		this.colTiene = colTiene;
	}
   
	public boolean agregarRealiza(Realiza r){
		boolean retorno;
		if(listRealiza.add(r)){
			retorno=true;
		}
		else{
			retorno=false;
		}
		
		return retorno;
	}
	
	public boolean agregarTiene(Tiene tiene){
		boolean retorno;
		if(colTiene.add(tiene)){
			retorno=true;
		}
		else{
			retorno=false;
		}
		
		return retorno;
	}
	
}
