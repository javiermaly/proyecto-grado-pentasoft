package beans;

import java.io.Serializable;

import javax.persistence.Entity;




@Entity
public class Programador extends Persona implements Serializable{

	private static final long serialVersionUID = 1L;
	
	
	String lenguaje;

	
	public Programador(String nombre,int cedula, String direccion,String telefono,String lenguaje){
		this.nombre=nombre;
		this.cedula=cedula;
		this.direccion=direccion;
		this.telefono=telefono;
		this.lenguaje=lenguaje;
	}
	public Programador(){
		
	}
	public Programador(Persona p){
	}

	public String getLenguaje() {
		return lenguaje;
	}

	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}
	

}
