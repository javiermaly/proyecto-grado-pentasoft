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

	public void altaTareaRealiza(Tarea t, Realiza r) {
		em.getTransaction().begin();
		em.persist(t);
		em.persist(r);
		em.getTransaction().commit();

	}

	// ASIGNAR TAREA A USUARIO
	public boolean asignaTareaUsuario(Tarea t, Usuario u, Calendar fecIni) {
		boolean retorno = false;
		Realiza r = new Realiza();
		r.setTarea(t);
		r.setUsu(u);
		r.setFechaInicio(fecIni);

		if (t.agregarRealiza(r)) {
			actualizarTarea(t);
			retorno = true;
		}

		return retorno;

	}

	// ALTA GRUPO
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

	// ENCONTRAR GRUPO
	public Grupo encontrarGrupo(int id) {
		Grupo gru = em.find(Grupo.class, id);
		return gru;
	}

	// ACTUALIZAR GRUPO
	public Grupo actualizarGrupo(Grupo gr) {
		em.getTransaction().begin();
		gr = em.merge(gr);
		em.getTransaction().commit();
		return gr;
	}

	// ASIGNAR TAREA A GRUPO
	// pasar un TIENE para que cambie el estado de la tarea
	// seria el caso de cuando se abre la tarea y se la asigna a un grupo
	// se pasa un tiene porque la tarea queda en estado ABIERTA.
	public boolean asignarTareaGrupo(Tarea t, Grupo gr) {
		boolean retorno = false;
		if (gr.asignaTarea(t))
			actualizarGrupo(gr);
		retorno = true;

		return retorno;
	}

	// traer un estado
	public Estado encontrarEstado(int id) {
		Estado e = em.find(Estado.class, id);
		return e;
	}

	// OBTIENE EL TIENE SIN FINALIZAR DE UNA TAREA
	public Tiene tieneDeTarea(Tarea t) {
		List<Tiene> colTiene=t.getColTiene();
		Tiene tiene=null;
		Tiene tieneIt=null;
		Iterator iter = colTiene.iterator();
		while (iter.hasNext()){
			tieneIt=(Tiene)iter.next();
			if(tieneIt.getFechaFin()==null){
				tiene=tieneIt;
			
			}
					  
		}
		return tiene;
	}

	// CAMBIAR ESTADO A TAREA
	public boolean cambiarEstadoTarea(Tarea t, Estado est) {//aca en vez de pasarle el estado podriamos pasarle el id dl estado
		boolean retorno = false;
		Tiene ti=tieneDeTarea(t);
		if(ti!=null){
			ti.setFechaFin(Calendar.getInstance());
			actualizarTarea(t);
			Tiene tiene2 = new Tiene();
			tiene2.setFechaInicio(Calendar.getInstance());
			//tiene2.setEstado(encontrarEstado(1));
			tiene2.setEstado(est);
			t.agregarTiene(tiene2);
			actualizarTarea(t);
			retorno=true;
		}
		
		

		return retorno;
	}

	
	//agregar estado.......PROVISORIO
	 public void agregarEstado(Estado est) {
		em.getTransaction().begin();
		em.persist(est);
		em.getTransaction().commit();
		
	}
	// HABRIA QUE TENER UN METODO QUE RECIBA EL ESTADO ACTUAL DE LA TAREA
	// Y DETERMINE LOS SIGUIENTES ESTADOS POSIBLES DEL FLUJO.
	// HAY QUE TENER UNA TABLA EN LA BASE DONDE ESTE MAPEADO EL POSIBLE FLUJO.
}
