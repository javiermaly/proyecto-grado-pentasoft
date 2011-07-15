package beans;

import beans.Encargado;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Grupo
 *
 */
@Entity

public class Grupo implements Serializable {

	   
	@Id
	private int id;
	private String descripcion;
	@OneToOne
	private Encargado enc;	
	@OneToMany
	private List<Tecnico> colTecnicos= new ArrayList<Tecnico>();
	
	private static final long serialVersionUID = 1L;
	
	public Grupo() {
		super();
	}   
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}   
	public Encargado getEnc() {
		return this.enc;
	}

	public void setEnc(Encargado enc) {
		this.enc = enc;
	}
	public void setColTecnicos(List<Tecnico> colTecnicos) {
		this.colTecnicos = colTecnicos;
	}
	public List<Tecnico> getColTecnicos() {
		return colTecnicos;
	}
   
}
