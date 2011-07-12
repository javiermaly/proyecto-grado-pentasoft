package manager;

import java.util.List;

import javax.persistence.EntityManager;

import beans.Cliente;
import beans.Tarea;

public class Manager {
	
	public List<Cliente> traerTodasCliente(EntityManager em) {
		@SuppressWarnings(value="unchecked")//para que deje de mostrar advertencia List need unchecked convertion
		List<Cliente> todos = em.createNamedQuery("todasClientes").getResultList();
		return todos;
	}
	
	public Cliente encontrarCliente(EntityManager em, Integer cedula) {
		Cliente p = em.find(Cliente.class, cedula);
		return p;
	}
	
	public List<Tarea> tareasPorCliente(EntityManager em,Cliente p) {
		@SuppressWarnings(value="unchecked")
		List<Tarea> tareas = em.createNamedQuery("tareasPorCliente").setParameter("Cliente",p).getResultList();
		return tareas;
	}
	
	//ACTUALIZAR datos Cliente
	public Cliente actualizarCliente(EntityManager em, Cliente p) {
		p = em.merge(p);
		return p;
	}
	
	
	//ELIMINAR
	public void eliminarCliente(EntityManager em, Cliente p) {
		em.remove(p);
	}


}
