package manager;

import java.util.List;

import javax.persistence.EntityManager;

import beans.Persona;
import beans.Tarea;

public class Manager {
	
	public List<Persona> traerTodasPersona(EntityManager em) {
		@SuppressWarnings(value="unchecked")//para que deje de mostrar advertencia List need unchecked convertion
		List<Persona> todos = em.createNamedQuery("todasPersonas").getResultList();
		return todos;
	}
	
	public Persona encontrarPersona(EntityManager em, Integer cedula) {
		Persona p = em.find(Persona.class, cedula);
		return p;
	}
	
	public List<Tarea> tareasPorPersona(EntityManager em,Persona p) {
		@SuppressWarnings(value="unchecked")
		List<Tarea> tareas = em.createNamedQuery("tareasPorPersona").setParameter("persona",p).getResultList();
		return tareas;
	}
	
	//ACTUALIZAR datos persona
	public Persona actualizarPersona(EntityManager em, Persona p) {
		p = em.merge(p);
		return p;
	}
	
	
	//ELIMINAR
	public void eliminarPersona(EntityManager em, Persona p) {
		em.remove(p);
	}


}
