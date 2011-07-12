package test;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.EntityManager;

import conexion.DBConection;
import beans.Tarea;
import beans.Usuario;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DBConection db = new DBConection();
		System.out.println(db.toString());
		EntityManager em = db.conectar();
		Calendar fecCom=Calendar.getInstance();
		Calendar horaI=Calendar.getInstance();
//		Usuario u = new Usuario();
//		u.setApellido("MALY");
//		u.setCedula(4043468);
//		u.setCelular("099722146");
//		u.setDireccion("Paysandu 1242 / 203");
//		u.setNombre("JAVIER");
//		u.setPwd("pwd");
//		u.setTelefono("29287833");
//		u.setUsuario("jmaly");
		Tarea t= new Tarea();
		t.setDescripcion("ESTA ES UNA TAREA eSterna je");
		t.setEsExterna(true);
		
		fecCom.set(2011, 8, 15);
		t.setFechaComprometida(fecCom);
		
		t.setFechaFin(Calendar.getInstance());
		horaI.set(Calendar.HOUR_OF_DAY, 16);
		horaI.set(Calendar.MINUTE,44);
		t.setFechaInicio(horaI);
		
		t.setHoraInicio(Calendar.getInstance());
		
		t.setObservacion("OBSERVACION DE TAREA");
		t.setTipo(null);
	
		try {
			
			em.getTransaction().begin();
			em.persist(t);
			em.getTransaction().commit();
			System.out.println("guarde una tarea: "+t.getDescripcion());
				
			em.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		

	}

}
