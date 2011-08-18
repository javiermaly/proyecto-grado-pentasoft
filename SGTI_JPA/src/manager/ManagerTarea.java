package manager;

import java.util.Calendar;
import java.util.Iterator;
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

	// DBConection db = new DBConection();
	// EntityManager em = db.conectar();

	public boolean altaTarea(EntityManager em, Tarea t, Tipo tipo, Tiene tiene) {
		try {

			em.persist(tipo);
			em.persist(tiene);
			em.persist(t);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public List<Tarea> traerTodasTareas(EntityManager em) {
		// para que deje de mostrar advertencia List need unchecked convertion
		@SuppressWarnings(value = "unchecked")
		List<Tarea> todasT = em.createNamedQuery("todosTareas").getResultList();
		return todasT;
	}

	public Tarea encontrarTarea(EntityManager em, int id) {
		Tarea t = em.find(Tarea.class, id);
		return t;
	}

	public List<Tarea> tareasPorUsuario(EntityManager em, Usuario u) {
		@SuppressWarnings(value = "unchecked")
		List<Tarea> tareas = em.createNamedQuery("tareasPorUsuario")
				.setParameter("Usuario", u).getResultList();
		return tareas;
	}

	// ACTUALIZAR TAREA
	public Tarea actualizarTarea(EntityManager em, Tarea t) {

		t = em.merge(t);

		return t;
	}

	// ELIMINAR TAREA
	public boolean eliminarTarea(EntityManager em , Tarea t) {
		
		try{
			em.remove(t);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public boolean altaTareaRealiza(EntityManager em, Tarea t, Realiza r) {

		try{
		em.persist(t);
		em.persist(r);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	// ASIGNAR TAREA A USUARIO
	public boolean asignaTareaUsuario(EntityManager em, Tarea t, Usuario u,
			Calendar fecIni) {
		boolean retorno = false;
		Realiza r = new Realiza();
		r.setTarea(t);
		r.setUsu(u);
		r.setFechaInicio(fecIni);

		if (t.agregarRealiza(r)) {
			actualizarTarea(em, t);
			retorno = true;
		}

		return retorno;

	}

	// ALTA GRUPO
	public boolean altaGrupo(EntityManager em, Grupo gr) {
		try {

			em.persist(gr);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// ENCONTRAR GRUPO
	public Grupo encontrarGrupo(EntityManager em, int id) {
		Grupo gru = em.find(Grupo.class, id);
		return gru;
	}

	// ACTUALIZAR GRUPO
	public Grupo actualizarGrupo(EntityManager em, Grupo gr) {

		gr = em.merge(gr);

		return gr;
	}

	// ASIGNAR TAREA A GRUPO
	// pasar un TIENE para que cambie el estado de la tarea
	// seria el caso de cuando se abre la tarea y se la asigna a un grupo
	// se pasa un tiene porque la tarea queda en estado ABIERTA.
	public boolean asignarTareaGrupo(EntityManager em, Tarea t, Grupo gr) {
		boolean retorno = false;
		if (gr.asignaTarea(t))
			actualizarGrupo(em, gr);
		retorno = true;

		return retorno;
	}

	// traer un estado
	public Estado encontrarEstado(EntityManager em, int id) {
		Estado e = em.find(Estado.class, id);
		return e;
	}

	// OBTIENE EL TIENE SIN FINALIZAR DE UNA TAREA
	public Tiene tieneDeTarea(Tarea t) {
		List<Tiene> colTiene = t.getColTiene();
		Tiene tiene = null;
		Tiene tieneIt = null;
		Iterator iter = colTiene.iterator();
		while (iter.hasNext()) {
			tieneIt = (Tiene) iter.next();
			if (tieneIt.getFechaFin() == null) {
				tiene = tieneIt;

			}

		}
		return tiene;
	}

	// CAMBIAR ESTADO A TAREA
	public boolean cambiarEstadoTarea(EntityManager em, Tarea t, Estado est) {// aca
																				// en
																				// vez
																				// de
																				// pasarle
																				// el
																				// estado
																				// podriamos
																				// pasarle
																				// el
																				// id
																				// dl
																				// estado
		boolean retorno = false;
		Tiene ti = tieneDeTarea(t);
		if (ti != null) {
			ti.setFechaFin(Calendar.getInstance());
			actualizarTarea(em, t);
			Tiene tiene2 = new Tiene();
			tiene2.setFechaInicio(Calendar.getInstance());
			// tiene2.setEstado(encontrarEstado(1));
			tiene2.setEstado(est);
			t.agregarTiene(tiene2);
			actualizarTarea(em, t);
			retorno = true;
		}

		return retorno;
	}

	// agregar estado.......PROVISORIO
	public boolean agregarEstado(EntityManager em, Estado est) {
		try{
		em.persist(est);
		return true;
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	// HABRIA QUE TENER UN METODO QUE RECIBA EL ESTADO ACTUAL DE LA TAREA
	// Y DETERMINE LOS SIGUIENTES ESTADOS POSIBLES DEL FLUJO.
	// HAY QUE TENER UNA TABLA EN LA BASE DONDE ESTE MAPEADO EL POSIBLE FLUJO.
}
