package conexion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import beans.Cliente;
import beans.Tarea;

public class DBConection {

	public EntityManager conectar() {
		EntityManagerFactory emf = javax.persistence.Persistence.createEntityManagerFactory("SGTI_JPA");
		return emf.createEntityManager();
	}
	
	
	public List<Cliente> traerTodasCliente(EntityManager em) {
		em.getTransaction().begin();
		List<Cliente> todos = em.createNamedQuery("todasClientes").getResultList();
		em.getTransaction().commit();
		return todos;
	}
	
	public Cliente encontrarCliente(EntityManager em, Integer cedula) {
		em.getTransaction().begin();
		Cliente p = em.find(Cliente.class, cedula);
		em.getTransaction().commit();
		return p;
	}
	
	public List<Tarea> tareasPorCliente(EntityManager em,Cliente p) {
		em.getTransaction().begin();
		List<Tarea> tareas = em.createNamedQuery("tareasPorCliente").setParameter("Cliente",p).getResultList();
		em.getTransaction().commit();
		return tareas;
	}
	
	//ACTUALIZAR datos Cliente
	public Cliente actualizarCliente(EntityManager em, Cliente p) {
		em.getTransaction().begin();
		p = em.merge(p);
		em.getTransaction().commit();
		return p;
	}
	
	
	//ELIMINAR
	public void eliminarCliente(EntityManager em, Cliente p) {
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
	}

}
