package beans;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;


public class Tipo implements Serializable {

	   
	
	private int id;
	private String descripcion;
	private static final long serialVersionUID = 1L;

	
	public Tipo() {
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
   
}
