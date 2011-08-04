package manager;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import conexion.DBConection;

import beans.Grupo;
import beans.Realiza;
import beans.Tarea;
import beans.Tipo;
import beans.Usuario;

public class ManagerTarea {

	DBConection db = new DBConection();
	EntityManager em = db.conectar();

	public boolean altaTarea(Tarea t, Tipo tipo) {
		try {
			em.getTransaction().begin();
			em.persist(t);
			em.persist(tipo);
			em.getTransaction().commit();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Tarea> traerTodasTareas() {
		// para que deje de mostrar advertencia List need unchecked convertion
		@SuppressWarnings(value = "unchecked")
		List<Tarea> todasT = em.createNamedQuery("todosTareas").getResultList();
		return todasT;
	}

	public Tarea encontrarTarea(int id) {
		Tarea t = em.find(Tarea.class, id);
		return t;
	}

	public List<Tarea> tareasPorUsuario(Usuario u) {
		@SuppressWarnings(value = "unchecked")
		List<Tarea> tareas = em.createNamedQuery("tareasPorUsuario")
				.setParameter("Usuario", u).getResultList();
		return tareas;
	}

	// ACTUALIZAR TAREA
	public Tarea actualizarTarea(Tarea t) {
		em.getTransaction().begin();
		t = em.merge(t);
		em.getTransaction().commit();
		return t;
	}

	// ELIMINAR TAREA
	public void eliminarTarea(Tarea t) {
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
	}

	 public void altaTareaRealiza(Tarea t, Realiza r){
	 em.getTransaction().begin();
	 em.persist(t);
	 em.persist(r);
	 em.getTransaction().commit();
	
	 }
	
	//ASIGNAR TAREA A USUARIO
	 public boolean asignaTareaUsuario(Tarea t, Usuario u, Calendar fecIni){
		 boolean retorno=false;
		 Realiza r= new Realiza();
		 r.setTarea(t);
		 r.setUsu(u);
		 r.setFechaInicio(fecIni);
		 
		 if(t.agregarRealiza(r)){
			 actualizarTarea(t);
			 retorno=true;
		 }
		 	 
		 return retorno;
		 
	 }
	 
	 //ALTA GRUPO
	 public boolean altaGrupo(Grupo gr) {
			try {
				em.getTransaction().begin();
				em.persist(gr);
				em.getTransaction().commit();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		}
	 //ENCONTRAR GRUPO
	 public Grupo encontrarGrupo(int id) {
			Grupo gru = em.find(Grupo.class, id);
			return gru;
		}
	 //ACTUALIZAR GRUPO
	 public Grupo actualizarGrupo(Grupo gr) {
			em.getTransaction().begin();
			gr = em.merge(gr);
			em.getTransaction().commit();
			return gr;
		}
	 
	 //ASIGNAR TAREA A GRUPO
	 public boolean asignarTareaGrupo(Tarea t , Grupo gr){
		 boolean retorno=false;
		 if(gr.asignaTarea(t))
			 actualizarGrupo(gr);
			 retorno=true;
		 
		 		 
		 return retorno;
	 }
}
