package beans;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Tecnico extends Usuario {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private boolean esExterno;
	
	@ManyToOne
	private Grupo grupo;
	
	
	public Tecnico(){
		
	}
	public Tecnico(long cedula, String ape,String nom,String celular, String direccion ){
		this.setCedula(cedula);
		this.setApellido(ape);
		this.setCelular(celular);
		this.setDireccion(direccion);
		this.setNombre(nom);
		
		
	}

	public boolean isEsExterno() {
		return esExterno;
	}

	public void setEsExterno(boolean esExterno) {
		this.esExterno = esExterno;
	}
	
}
