package manager;

import java.util.List;

import javax.persistence.EntityManager;

import conexion.DBConection;

import beans.Cliente;
import beans.Tarea;
import beans.Usuario;

public class ManagerCliente {
	
	
//	DBConection db = new DBConection();
//	EntityManager em = db.conectar();

	public boolean altaCliente(EntityManager em, Cliente c){
		try {
			em.persist(c);	
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}	
	
	public List<Cliente> traerTodosCliente(EntityManager em) {
		@SuppressWarnings(value="unchecked")//para que deje de mostrar advertencia List need unchecked convertion
		List<Cliente> todos = em.createNamedQuery("todosClientes").getResultList();
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
