package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import manager.Manager;

import beans.Persona;
import beans.Programador;


@Stateless
public class ManagerPersona implements PersonaRemote {

	//DBConection db = new DBConection();
	//EntityManager em = db.conectar(); //se va esto y entra a jugar
	// @PersistenceContext

	Manager manager= new Manager();//manager del jpa que maneja los beans
	
	@PersistenceContext(unitName = "practicoJPA")
	private EntityManager em;

	private List<Persona> listaPersonas;
	
	public void agregarPersona(Persona p){
		em.persist(p);		
	}
	
	public void eliminarPersona(int ced){
		Persona p;
		p = manager.encontrarPersona(em, ced);//buscar si existe la persona antes de eliminar
		
		if (p!=null){			
			manager.eliminarPersona(em, p);
			System.out.println("persona"+p.getNombre() +" eliminada ");
		}else{
			System.out.println("no existe la persona en la BD con esta cedula: "+p.getCedula());
		}		
	}
	
	
	
	
	
	
	public List<Persona> listarPersonas() {
		listaPersonas = manager.traerTodasPersona(em);
		return listaPersonas;
	}
	
	
	
//	public void listarPersonas() {
//		List<Persona> listaPersonas = manager.traerTodasPersona(em);
//		//@SuppressWarnings(value="unchecked")
//		//List<Persona> listaPersonas = em.createNamedQuery("todasPersonas").getResultList();
//		System.out.println("la cantidad de personas: "+ listaPersonas.size());
//		
//		Programador prog;
//		for (Persona persona : listaPersonas) {
//
//			System.out.println("NOMBRE: " + persona.getNombre());
//			System.out.println("DIRECCION: " + persona.getDireccion());
//			System.out.println("TELEFONO: " + persona.getTelefono());
//
//			if (persona instanceof Programador) {
//				prog = (Programador) persona;
//				System.out.println("TIPO: PROGRAMADOR");
//				System.out.println("LENGUAJE: " + prog.getLenguaje());
//			}
//
//			System.out.println("==============================");
//
//		}
//
//	}

}
