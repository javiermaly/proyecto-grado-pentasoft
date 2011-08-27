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
	
	
		
	public boolean agregarTarea(Tarea t, Tipo tipo, Tiene tiene, Grupo gr ) {
		try {
			
			em.persist(tipo);
			em.persist(tiene);
			em.persist(t);
			//em.persist(gr);
			gr=em.merge(gr);
			gr=encontrarGrupo(gr.getId());			
			gr.asignaTarea(t);			
			em.merge(gr);
			
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
		//control: solo se puede eliminar tareas con estado Abierta
		//List<Tarea> TareaAbierta = em.createNamedQuery("todosTareasAbiertas").setParameter("id", t.getId()).setParameter("var", 1).getResultList();
		Tarea ta=encontrarTarea(t.getId());
		System.out.println("HASTA ACAAAAAAAA "+t.getId());
		if(ta!=null){
			if(tareaEstadoAbierta(t)){
				System.out.println("va a eliminarla");
				t=em.merge(t);
				em.remove(t);	
				System.out.println("eliminada");
				return true;
			}else{
				System.out.println("no tiene estado abierta");
				return false;	
			}
		}else{
			System.out.println("no existe la tareaa");
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
	
	//asigna el la tarea a un usuario, en el realiza queda vacia la
	//fecha de inicio, cuando el usuario toma la tarea se completa la fecha
	public boolean asignaTareaUsuario(Tarea t, Usuario u) {
		boolean retorno = false;
		Realiza r = new Realiza();
		Estado estado = encontrarEstado(2);
			
		r.setTarea(t);
		r.setUsu(u);
		
		r=em.merge(r);
		t=em.merge(t);
		
		if (t.agregarRealiza(r)&& avanzarTareaEstado(t, estado)){
			t=em.merge(t);
			retorno = true;
		}

		return retorno;
		
	}
	
	public boolean tomarTarea(Tarea t, Usuario u){//obtiene el realiza de esta tarea le ponemos fecha actual de incio, y avanzamos el estado de la tarea en  #3 En proceso
		boolean retorno = false;		
		t=em.merge(t);
		Realiza r = realizaDeTarea(t);
		Estado estado = encontrarEstado(3);	
		
		r.setFechaInicio(Calendar.getInstance());
		
		r=em.merge(r);	
		
		if (avanzarTareaEstado(t, estado)){
			t=em.merge(t);
			retorno = true;
		}	
		
		return retorno;
	}
	
	public boolean finalizarTarea(Tarea t, Usuario u){//obtiene el realiza de esta tarea le ponemos fecha de fin, y avanzamos el estado de la tarea en  #6 Finalizada
		boolean retorno = false;		
		t=em.merge(t);
		Realiza r = realizaDeTareaFechaFin(t);
		Estado estado = encontrarEstado(6);		
		
		r.setFechaFin(Calendar.getInstance());		
		r=em.merge(r);	
		
		if (avanzarTareaEstado(t, estado)){
			t=em.merge(t);
			retorno = true;
		}	
		
		return retorno;
	}	
	
	public boolean derivarTarea(Tarea t, Usuario u, Grupo gr){//finalizamos el realiza y asignamos esa tarea al grupo, quedando en estado derivada para que el encargado asigne la tarea
		boolean retorno = false;
		t=em.merge(t);
		Estado estado = encontrarEstado(4);	//#4 derivada	
		
		if (avanzarTareaEstado(t, estado)){			
			Realiza r = realizaDeTareaFechaFin(t);
			r.setFechaFin(Calendar.getInstance());//seteamos la fecha fin con la actual, cerrando ese realiza
			r=em.merge(r);
			gr=em.merge(gr);
			gr=encontrarGrupo(gr.getId());
			if(gr!=null){			
				gr.asignaTarea(t);			
				em.merge(gr);										
				retorno=true;
			}else{
				retorno=false;
				System.out.println("no existe el grupo");
			}			
			retorno = true;
		}else{
			retorno=false;
			System.out.println("no se pudo avanzar estado");
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
	
	// OBTIENE EL REALIZA CON FECHA DE INICIO NULA EN TAREA
	public Realiza realizaDeTarea(Tarea t) {
		List<Realiza> colRealiza = t.getListRealiza();
		Realiza r = null;
		Realiza realizaIt = null;
		Iterator iter = colRealiza.iterator();
		while (iter.hasNext()) {
			realizaIt = (Realiza) iter.next();
			if (realizaIt.getFechaInicio() == null) {
				r = realizaIt;

			}

		}
		return r;
	}
	//el realiza de tarea con fecha de fin null 
	public Realiza realizaDeTareaFechaFin(Tarea t) {
		List<Realiza> colRealiza = t.getListRealiza();
		Realiza r = null;
		Realiza realizaIt = null;
		Iterator iter = colRealiza.iterator();
		while (iter.hasNext()) {
			realizaIt = (Realiza) iter.next();
			if (realizaIt.getFechaFin() == null) {
				r = realizaIt;

			}

		}
		return r;
	}
	
	
	// RETORNA TRUE SI LA TAREA TIENE ESTADO ABIERTA 
	public boolean tareaEstadoAbierta(Tarea t) {
		boolean retorno=false;
		List<Tiene> colTiene = t.getColTiene();		
		for(Tiene tiene : colTiene){
			if(tiene.getEstado().getId()==1){
				retorno=true;
			}else{
				retorno=false;
			}			
		}
		return retorno;
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
		est= em.merge(est);

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
