package stateless;

import java.util.Calendar;
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

import manager.ManagerTarea;


@Stateless
public class ManagerT implements TareaRemote {
	
	@PersistenceContext(unitName = "SGTI_JPA")
	private EntityManager em;
	ManagerTarea mt= new ManagerTarea();//manager Tarea del jpa que maneja los beans
	
		
	public boolean agregarTarea(Tarea t, Tipo tipo, Tiene tiene) {
		return mt.altaTarea(em, t, tipo, tiene);
	}
	public List<Tarea> traerTodasTareas() {
		return mt.traerTodasTareas(em);
		
	}
	public Tarea encontrarTarea(int id) {
		return mt.encontrarTarea(em, id);
	}
	public List<Tarea> tareasPorUsuario(Usuario u) {
		return mt.tareasPorUsuario(em, u);
	}
	public Tarea actualizarTarea(Tarea t) {
		return  mt.actualizarTarea(em, t);
	}
	public boolean eliminarTarea(Tarea t) {
		return mt.eliminarTarea(em, t);		
	}
	public boolean altaTareaRealiza(Tarea t, Realiza r) {
		return mt.altaTareaRealiza(em, t, r);
	}
	public boolean asignaTareaUsuario(Tarea t, Usuario u, Calendar fecIni) {
		return mt.asignaTareaUsuario(em, t, u, fecIni);
		
	}
	public boolean altaGrupo(Grupo gr) {
		return mt.altaGrupo(em, gr);
	}
	public Grupo encontrarGrupo(int id) {
		return mt.encontrarGrupo(em, id);
	}
	public Grupo actualizarGrupo(Grupo gr) {
		return mt.actualizarGrupo(em, gr);
	}
	public boolean asignarTareaGrupo(Tarea t, Grupo gr) {
		return mt.asignarTareaGrupo(em, t, gr);
	}
	public Estado encontrarEstado(int id) {
		return mt.encontrarEstado(em, id);
	}
	public Tiene tieneDeTarea(Tarea t) {
		return mt.tieneDeTarea(t);
	}
	public boolean cambiarEstadoTarea(Tarea t, Estado est) {
		return mt.cambiarEstadoTarea(em, t, est);
	}
	public boolean agregarEstado(Estado est) {
		return mt.agregarEstado(em, est);
		
	}
	
	
}
