package stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import manager.ManagerCliente;



@Stateless
public class ManagerC {

	@PersistenceContext(unitName = "SGTI_JPA")
	private EntityManager em;
	ManagerCliente mc= new ManagerCliente();//manager Cliente del jpa que maneja los beans	
	
}
