package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Encargado;
import beans.Usuario;

@Stateless
@SuppressWarnings(value = "unchecked")
public class ManagerU implements UsuarioRemote {

	@PersistenceContext(unitName = "SGTI_JPA")
	private EntityManager em;

	public boolean agregarUsuario(Usuario u) {
		try {
			em.persist(u);
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean eliminarUsuario(long ced) {
		Usuario u;
		u = encontrarUsuario(ced);
		if (u != null) {
			try {
				em.remove(u);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} else
			return false;
	}

	public List<Usuario> listarUsuarios() {
		List<Usuario> todos = em.createNamedQuery("todosUsuarios")
				.getResultList();
		return todos;
	}

	public Usuario encontrarUsuario(long ced) {
		Usuario u = em.find(Usuario.class, ced);
		return u;
	}

	public boolean actualizarUsuario(Usuario u) {
		try {
			em.merge(u);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public Usuario login(long cedula, String pwd){
        	try{
        	Usuario u = em.find(Usuario.class, cedula);
        	if ((u.getPwd().equals(pwd))&&(u!=null)){
        		System.out.println("usuario encontrado");
        		return u;
        	}
        	else{
        		System.out.println("no valido");
        		return null;
        	}
        	}
        	catch(Exception e){
        		System.out.println("no existe el usuario");
        		return null;
        	}
        	
        	
        }
	
	public List<Encargado> listarEncargadosHabilitados() {
		List<Encargado> todos = em.createNamedQuery("todosEncargadosHabilitados")
				.getResultList();
		return todos;
	}

}