package beans;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;


	
@Entity
public class Tarea implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	String descripcion="";
	String observacion="";
	boolean esExterna;
	@ManyToOne
	//@JoinColumn(name = "persona_ced")//crea la fk persona_ced en la tabla Tareas
	private Persona persona;
	
	public Tarea(){
		
	}
	
	public Tarea(String desc, String obs, Boolean esExt){
		this.descripcion=desc;
		this.observacion=obs;
		this.esExterna=esExt;
	}
	
	public Tarea(String desc, String obs, Boolean esExt, Persona p){
		this.descripcion=desc;
		this.observacion=obs;
		this.esExterna=esExt;
		this.persona=p;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
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
	public boolean isEsExterna() {
		return esExterna;
	}
	public void setEsExterna(boolean esExterna) {
		this.esExterna = esExterna;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public Persona getPersona() {
		return persona;
	}
	

}
