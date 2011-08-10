package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Usuario;
import manager.ManagerUsuario;



@Stateless
public class ManagerU implements UsuarioRemote{

	@PersistenceContext(unitName ="SGTI_JPA")
	private EntityManager em;
	
	ManagerUsuario mu = new ManagerUsuario();//manager usuario del jpa que maneja los beans	
	private List<Usuario> listaUsuarios;
	
	
	public void agregarUsuario(Usuario u){		
		if(mu.altaUsuario(em, u)){//devuelve un booleano, ver como lo vamos a manejar
			System.out.println(" usuario ingresado en la BD");
		}else{
			System.out.println(" EERRORRR INGRESO DE USUARIO POR ALGUN MOTIVO");
		} 		
	}
	
	public void eliminarUsuario(int ced){
		Usuario u;
		u = mu.encontrarUsuario(em, ced);		
		if (u!=null){			
			mu.eliminarUsuario(em, u);
			System.out.println("USUARIO "+u.getNombre() +" eliminadoo ");
		}else{
			System.out.println("no existe usuario en la BD");
		}		
	}		
	
	public List<Usuario> listarUsuarios() {		
		listaUsuarios= mu.traerTodosUsuarios(em);
		return listaUsuarios;
	}
	
	public void encontrarUsuario(int ced){
		mu.encontrarUsuario(em, ced);
	}
	
	public void actualizarUsuario(Usuario u){
		mu.actualizarUsuario(em, u);		
	}
	
		
}
