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
	
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy="grupo", cascade=CascadeType.ALL)
	private List<Tecnico> colTecnicos= new ArrayList<Tecnico>();
	
	
	
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
   
}
