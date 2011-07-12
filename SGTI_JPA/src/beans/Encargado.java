package beans;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Encargado extends Tecnico {
	
	@OneToOne
	private Grupo grupo;
	
	public Encargado(){
		super();
	}

}
