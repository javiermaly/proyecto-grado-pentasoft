package stateless;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import manager.ManagerTarea;


@Stateless
public class ManagerT {
	
	@PersistenceContext(unitName = "SGTI_JPA")
	private EntityManager em;
	ManagerTarea mt= new ManagerTarea();//manager Tarea del jpa que maneja los beans	
	
}
