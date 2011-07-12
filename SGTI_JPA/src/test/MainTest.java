package test;

import javax.persistence.EntityManager;

import conexion.DBConection;
import beans.Usuario;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConection db = new DBConection();
		EntityManager em = db.conectar();
		
		Usuario u = new Usuario();
		u.setApellido("MALY");
		u.setCedula(4043468);
		u.setCelular("099722146");
		u.setDireccion("Paysandu 1242 / 203");
		u.setNombre("JAVIER");
		u.setPwd("pwd");
		u.setTelefono("29287833");
		u.setUsuario("jmaly");
		try {
			
			em.getTransaction().begin();
			
			em.persist(u); 
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		

	}

}
