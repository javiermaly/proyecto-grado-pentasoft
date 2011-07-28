package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Cliente
 *
 */
@Entity

public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String empresa;
	private String nombre_RazonSocial;
	private long cedula;
	private long rut;
	private String telefono;
	private String direccion;
	private @Temporal(TemporalType.DATE)Calendar fechaFinGarantia;
		
	@OneToMany(mappedBy="cliente")
	private List<Tarea> tareas= new ArrayList<Tarea>();
	
	private static final long serialVersionUID = 1L;

	public Cliente() {
		super();
	}
	
	
	public Cliente(int id, String empresa, String nombre_RazonSocial,
			long cedula, long rut, String telefono, String direccion,
			Calendar fechaFinGarantia) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nombre_RazonSocial = nombre_RazonSocial;
		this.cedula = cedula;
		this.rut = rut;
		this.telefono = telefono;
		this.direccion = direccion;
		this.fechaFinGarantia = fechaFinGarantia;
	}
	
	public Cliente(int id, String empresa, String nombre_RazonSocial,
			long cedula, long rut, String telefono, String direccion) {
		super();
		this.id = id;
		this.empresa = empresa;
		this.nombre_RazonSocial = nombre_RazonSocial;
		this.cedula = cedula;
		this.rut = rut;
		this.telefono = telefono;
		this.direccion = direccion;
		
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getNombre_RazonSocial() {
		return nombre_RazonSocial;
	}

	public void setNombre_RazonSocial(String nombre_RazonSocial) {
		this.nombre_RazonSocial = nombre_RazonSocial;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public long getRut() {
		return rut;
	}

	public void setRut(long rut) {
		this.rut = rut;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
//
//	public Calendar getFechaFinGarantía() {
//		return fechaFinGarantia;
//	}
//
//	public void setFechaFinGarantía(Calendar fechaFinGarantía) {
//		this.fechaFinGarantia = fechaFinGarantia;
//	}


	public void setTareas(List<Tarea> tareas) {
		this.tareas = tareas;
	}


	public List<Tarea> getTareas() {
		return tareas;
	}


	public void setFechaFinGarantia(Calendar fechaFinGarantia) {
		this.fechaFinGarantia = fechaFinGarantia;
	}


	public Calendar getFechaFinGarantia() {
		return fechaFinGarantia;
	}
	
	
   
}
