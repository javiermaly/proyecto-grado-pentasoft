package manager;

import java.util.List;

import javax.persistence.EntityManager;

import conexion.DBConection;

import beans.Realiza;
import beans.Tarea;
import beans.Usuario;

public class ManagerTarea {

	DBConection db = new DBConection();
	EntityManager em = db.conectar();

	public void altaTarea(EntityManager em, Tarea t){
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}
	
//	public void altaTareaRealiza(EntityManager em, Tarea t, Realiza r){
//		em.getTransaction().begin();
//		em.persist(t);
//		em.persist(r);
//		em.getTransaction().commit();
//		
//	}
	
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
	
	//ACTUALIZAR TAREA
	public Tarea actualizarTarea(EntityManager em, Tarea t) {
		em.getTransaction().begin();
		t = em.merge(t);
		em.getTransaction().commit();
		return t;
	}
	
	
	//ELIMINAR TAREA
	public void eliminarTarea(EntityManager em, Tarea t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}
	
}
