package stateless;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import beans.Cliente;
import beans.Usuario;

import manager.ManagerCliente;



@Stateless
public class ManagerC implements ClienteRemote {

	@PersistenceContext(unitName = "SGTI_JPA")
	private EntityManager em;
	
	ManagerCliente mc= new ManagerCliente();//manager Cliente del jpa que maneja los beans	
	private List<Cliente> listaClientes;
	
	public void agregarCliente(Cliente c){		
			
		if(mc.altaCliente(em, c)){//devuelve un booleano, ver como lo vamos a manejar
			System.out.println(" CLIENTE ingresado en la BD");
		}else{
			System.out.println(" EERRORRR INGRESO DE CLIENTE POR ALGUN MOTIVO");
		} 		
	}
	
	public void eliminarCliente(int ced){
		Cliente c;
		c = mc.encontrarCliente(em, ced);		
		if (c!=null){			
			mc.eliminarCliente(em, c);
			System.out.println("Cliente "+c.getNombre_RazonSocial() +" eliminadoo ");
		}else{
			System.out.println("no existe Cliente en la BD");
		}		
	}		
	
	public List<Cliente> listarClientes() {		
		listaClientes= mc.traerTodosCliente(em);
		return listaClientes;
	}
		
	public void encontrarCliente(int ced){
		mc.encontrarCliente(em, ced);
	}
	
	public void actualizarCliente(Cliente u){
		mc.actualizarCliente(em, u);		
	}
	
}
