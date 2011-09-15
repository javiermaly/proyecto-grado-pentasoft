package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

//ESTA CLASE ES FLOR DE PORONGA
//PROBANDO PARA TORTOISE HG


@Inheritance(strategy=InheritanceType.JOINED)
@NamedQueries(value = { 
		@NamedQuery(name="todasPersonas", query="select p from Persona p")
		})

	
@Entity
public class Persona implements Serializable {
	
	@Id	
	int cedula;
	String nombre;
	String direccion; 
	String telefono;
	
	@OneToMany(mappedBy="persona", cascade=CascadeType.ALL)
	private List<Tarea> tareas= new ArrayList<Tarea>();
	
	
	private static final long serialVersionUID = 1L;
	
	
	public Persona(){
		super();
	}
	
	public Persona(String nombre, int cedula, String direccion, String tel){
		this.nombre=nombre;
		this.cedula=cedula;
		this.direccion=direccion;
		this.telefono=tel;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getCedula() {
		return cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}

	public List<Tarea> getTareas() {
		return tareas;
	}
}
