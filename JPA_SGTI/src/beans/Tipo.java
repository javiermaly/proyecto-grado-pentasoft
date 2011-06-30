package beans;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tipo
 *
 */
@Entity

public class Tipo implements Serializable {

	   
	@Id
	private int id;
	private String descripcion;
//	private ColTareas colTareas;
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
