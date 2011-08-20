package stateless;

import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Estado;
import beans.Grupo;
import beans.Realiza;
import beans.Tarea;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;



@Stateless
@SuppressWarnings(value="unchecked")
public class ManagerT implements TareaRemote {
	
	@PersistenceContext(unitName = "SGTI_JPA")
	private EntityManager em;
	//ManagerTarea mt= new ManagerTarea();//manager Tarea del jpa que maneja los beans
	
		
	public boolean agregarTarea(Tarea t, Tipo tipo, Tiene tiene) {
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
	public List<Tarea> traerTodasTareas() {
		List<Tarea> todasT = em.createNamedQuery("todosTareas").getResultList();
		return todasT;
		
	}
	public Tarea encontrarTarea(int id) {
		Tarea t = em.find(Tarea.class, id);
		return t;
	}
	public List<Tarea> tareasPorUsuario(Usuario u) {
		List<Tarea> tareas= em.createNamedQuery("tareasPorUsuario").setParameter(1, em.getReference(Usuario.class, u.getCedula())).getResultList();
		return tareas;
	}
	public Tarea actualizarTarea(Tarea t) {
		t = em.merge(t);

		return t;
	}
	public boolean eliminarTarea(Tarea t) {

		try{
			em.remove(t);
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}
	public boolean altaTareaRealiza(Tarea t, Realiza r) {

		try{
			em.merge(t);
			em.persist(r);
		return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
	public boolean asignaTareaUsuario(Tarea t, Usuario u, Calendar fecIni, Tiene tiene) {
		boolean retorno = false;
		Realiza r = new Realiza();
		r.setTarea(t);
		r.setUsu(u);
		r.setFechaInicio(fecIni);

		if (t.agregarRealiza(r)) {
			actualizarTarea(t, tiene);
			retorno = true;
		}

		return retorno;
		
	}
	public boolean altaGrupo(Grupo gr) {
		try {

			em.persist(gr);

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	public Grupo encontrarGrupo(int id) {
		Grupo gru = em.find(Grupo.class, id);
		return gru;
	}
	public Grupo actualizarGrupo(Grupo gr) {
		gr = em.merge(gr);

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
	public Estado encontrarEstado(int id) {
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
	public boolean cambiarEstadoTarea(Tarea t, Estado est) {
		boolean retorno = false;
		Tiene ti = tieneDeTarea(t);
		if (ti != null) {
			ti.setFechaFin(Calendar.getInstance());
			//em.merge(ti);
			actualizarTarea(t,ti);
			Tiene tiene2 = new Tiene();
			tiene2.setFechaInicio(Calendar.getInstance());
			// tiene2.setEstado(encontrarEstado(1));
			tiene2.setEstado(est);
			em.persist(tiene2);
			t.agregarTiene(tiene2);
			actualizarTarea(t, tiene2);
			retorno = true;
		}

		return retorno;
	}
	
	public boolean agregarEstado(Estado est) {
		try{
			em.persist(est);
			return true;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
		
	}
	
	
	public Tarea actualizarTarea(Tarea t, Tiene ti) {

		t = em.merge(t);
		ti=em.merge(ti);

		return t;
	}
	
	public Estado actualizarEstado(int id) {
		
		Estado est=encontrarEstado(id);
		em.merge(est);

		return est;
	}
	
	public Estado actualizarEstado(Estado est){
		est=em.merge(est);
		return est;
	}
	
	//DEVUELVE LA COLECCION DE ESTADOS POSIBLES A AVANZAR DADO EL ESTADO ACTUAL
	@Override
	public List<Estado> dameEstadosSgtes(Estado est) {
		System.out.println("metodo que ejecuta el jpql pa traer la coleccion.");

		List<Estado> colEstSgtes=em.createNamedQuery("estadosSgtes").setParameter("id",est.getId()).getResultList();
		System.out.println("retorno");
		
		return colEstSgtes;
		
		
	}
	
	//DETERMINA SI EL ESTADO QUE TIENE LA TAREA (PASADO POR PARAMETRO)
	//PUEDE AVANZAR AL SIGUIENTE ESTADO PROPUESTO
	public boolean validarEstadoSiguiente(Estado estadoActual, Estado estadoSgte){
		boolean retorno=false;
	
		System.out.println("estado actual: "+estadoActual.getDescripcion());
		System.out.println("estado sgte: "+estadoSgte.getDescripcion());
		
		
		List<Estado> listSgteEst=dameEstadosSgtes(estadoActual);
		
		System.out.println(" ************************************* ");
		System.out.println(" Tareas posibles desde el estado: ");

		for(Estado esta : listSgteEst){
			
			System.out.println("validarEstadoSiguiente ManagerT - Estado sgte: "+esta.getDescripcion()+"- id: "+esta.getId());
			
		}
		
			
		for(Estado esta : listSgteEst){
			if(esta.getId()==estadoSgte.getId()){
				System.out.println("entro a validar si el estadoSgte ta en la coleccion");
				retorno=true;
				break;
			}
			else{
				System.out.println("el estado actual no es igual al estado siguiente");
				System.out.println("estado de la coleccion "+esta.getDescripcion()+"- estado sigte: "+estadoSgte.getDescripcion());
			}
		
		} 
				
		return retorno;
		
	}
	
	public boolean avanzarTareaEstado(Tarea tar, Estado sigEst) {
		boolean retorno = false;
		Tiene tiene = null;
		tiene =tieneDeTarea(tar);
		Estado estActual = tiene.getEstado();
		System.out.println("Estado Actual: " + estActual.getDescripcion());
		if (!(estActual == sigEst)) {
			System.out.println("los estados son diferentes");
			if (validarEstadoSiguiente(estActual, sigEst)) {
				System.out.println("valide que el sgte estado es posible");
				if (cambiarEstadoTarea(tar, sigEst)) {
					retorno = true;
				}
			}

		}
		return retorno;
	}
	
	
	
	
	
}
