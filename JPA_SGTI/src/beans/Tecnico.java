package beans;

import beans.Usuario;
import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tecnico
 *
 */
@Entity

public class Tecnico extends Usuario implements Serializable {

	
	private boolean esExterno;
	private static final long serialVersionUID = 1L;

	public Tecnico() {
		super();
	}   
	public boolean getEsExterno() {
		return this.esExterno;
	}

	public void setEsExterno(boolean esExterno) {
		this.esExterno = esExterno;
	}
   
}
