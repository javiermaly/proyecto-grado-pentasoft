package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Usuario;
import manager.ManagerUsuario;



@Stateless
public class ManagerU {

	@PersistenceContext(unitName = "SGTI_JPA")
	private EntityManager em;
	ManagerUsuario mu= new ManagerUsuario();//manager usuario del jpa que maneja los beans	
	private List<Usuario> listaUsuarios;
	
	
	public void agregarUsuario(Usuario u){		
		mu.altaUsuario(u); //devuelve un booleano, ver como lo vamos a manejar		
	}
	
	public void eliminarU(int ced){
		Usuario u;
		u = mu.encontrarUsuario(em, ced);		
		if (u!=null){			
			mu.eliminarUsuario(em, u);
			System.out.println("USUARIO "+u.getNombre() +" eliminadoo ");
		}else{
			System.out.println("no existe usuario en la BD con esta cedula: "+u.getCedula());
		}		
	}	
	
	
	public List<Usuario> listarUsuarios() {		
		listaUsuarios= mu.traerTodosUsuarios(em);
		return listaUsuarios;
	}
	
}
