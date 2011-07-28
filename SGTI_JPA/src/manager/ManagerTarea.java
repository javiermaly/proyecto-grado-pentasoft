package manager;

import java.util.List;

import javax.persistence.EntityManager;

import beans.Realiza;
import beans.Tarea;
import beans.Usuario;

public class ManagerTarea {

	public void altaTarea(EntityManager em, Tarea t){
		em.persist(t);
				
	}
	
	public void altaTareaRealiza(EntityManager em, Tarea t, Realiza r){
		em.persist(t);
		em.persist(r);
		
	}
	
	public List<Tarea> traerTodasTareas(EntityManager em) {
		@SuppressWarnings(value="unchecked")//para que deje de mostrar advertencia List need unchecked convertion
		List<Tarea> todasT = em.createNamedQuery("todosTareas").getResultList();
		return todasT;
	}
	
	public Tarea encontrarTarea(EntityManager em, int id) {
		Tarea t = em.find(Tarea.class, id);
		return t;
	}
	
	public List<Tarea> tareasPorUsuario(EntityManager em,Usuario u) {
		@SuppressWarnings(value="unchecked")
		List<Tarea> tareas = em.createNamedQuery("tareasPorUsuario").setParameter("Usuario",u).getResultList();
		return tareas;
	}
	
	//ACTUALIZAR 
	public Tarea actualizarTarea(EntityManager em, Tarea t) {
		t = em.merge(t);
		return t;
	}
	
	
	//ELIMINAR
	public void eliminarTarea(EntityManager em, Tarea t) {
		em.remove(t);
	}
	
}
