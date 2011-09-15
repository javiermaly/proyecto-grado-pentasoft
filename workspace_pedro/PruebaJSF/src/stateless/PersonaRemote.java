package stateless;


import java.util.List;

import javax.ejb.Remote;

import beans.Persona;

@Remote
public interface PersonaRemote {

	public void agregarPersona(Persona p);
	public List<Persona> listarPersonas();
	public void eliminarPersona(Persona p);
}
