package manager;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import conexion.DBConection;

import beans.Estado;
import beans.Grupo;
import beans.Realiza;
import beans.Tarea;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

public class ManagerTarea {

	DBConection db = new DBConection();
	EntityManager em = db.conectar();

	public boolean altaTarea(Tarea t, Tipo tipo, Tiene tiene) {
		try {
			em.getTransaction().begin();
			em.persist(tipo);
			em.persist(tiene);
			em.persist(t);
			
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
		List<Tarea> tareas = em.createNamedQuery("tareasPorUsuario").setParameter("Usuario", u).getResultList();
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
	 
	 //traer un estado
	 public Estado encontrarEstado(int id) {
			Estado e = em.find(Estado.class, id);
			return e;
	}
	 
	//ENCONTRAR Tiene
	 public Tiene encontrarTiene(Tarea t) {
			Tiene tiene = em.find(Tiene.class, t.getId());
			return tiene;
		}
	 
//	//ENCONTRAR Tiene en ColTienes de Tarea
//	 public Tiene encontrarTieneEnTarea(Tarea t, Tiene tie) {
//			Tiene tiene = em.find( //Tarea.class, t.getColTiene());//(tie.getId()));
//			return tiene;
//		}
	 
	//ACTUALIZAR Tiene
	 public Tiene actualizarTiene(Tiene tiene) {
			em.getTransaction().begin();
			tiene = em.merge(tiene);
			em.getTransaction().commit();
			return tiene;
		}

	
	 //agregar estado.......PROVISORIO
	 public void agregarEstado(Estado est) {
		em.getTransaction().begin();
		em.persist(est);
		em.getTransaction().commit();
		
	}
}
