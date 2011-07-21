package test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import conexion.DBConection;
import beans.Administrador;
import beans.Encargado;
import beans.Estado;
import beans.Grupo;
import beans.Tarea;
import beans.Tecnico;
import beans.Tipo;
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
		
		Tecnico u = new Tecnico();
		u.setApellido("MALY");
		u.setCedula(4043468);
		u.setCelular("099722146");
		u.setDireccion("Paysandu 1242 / 203");
		u.setNombre("JAVIER");
		u.setPwd("pwd");
		u.setTelefono("29287833");
		u.setUsuario("jmaly");
		u.setEsExterno(true);
		
		Encargado enc = new Encargado();
		enc.setApellido("encargueti");
		enc.setCedula(4111111);
		enc.setCelular("09972545");
		enc.setDireccion("sarasa / 444");
		enc.setNombre("alberto");
		enc.setPwd("albertito");
		enc.setTelefono("2944333");
		enc.setUsuario("aencargueti");
		
		Administrador adm = new Administrador();
		adm.setApellido("adm");
		adm.setCedula(123123);
		adm.setCelular("09972545");
		adm.setDireccion("sarasa / 444");
		adm.setNombre("adm");
		adm.setPwd("adm");
		adm.setTelefono("2944333");
		adm.setUsuario("adm");
		
		List<Tecnico> colTecnicos= new ArrayList<Tecnico>();
		colTecnicos.add(u);
		Grupo g = new Grupo();
		g.setDescripcion("soporte tecnico externo");
		g.setEnc(enc);
		g.setColTecnicos(colTecnicos);
		g.setId(1);
		
		
		Tipo tip=new Tipo();
		tip.setDescripcion("Desarrollo");
		tip.setId(1);
			
		
		Tarea t= new Tarea();
		t.setDescripcion("ESTA ES UNA TAREA eSterna je");
		t.setEsExterna(true);		
		fecCom.set(2011, 8, 15);
		t.setFechaApertura(horaI);	
		t.setFechaComprometida(fecCom);		
		t.setFechaCierre(Calendar.getInstance());
		//horaI.set(Calendar.HOUR_OF_DAY, 16);
		//horaI.set(Calendar.MINUTE,44);			
		t.setObservacion("OBSERVACION DE TAREA");
		t.setTipo(tip);

		
		Estado e1= new Estado();
		Estado e2 = new Estado();
		
		e1.setId(1);
		e1.setDescripcion("Abierta");
		
		e2.setId(2);
		e2.setDescripcion("Asignada");
		
		
		try {
			
			//INGRESOS:
			
			em.getTransaction().begin();
			em.persist(e1); //ESTADOS
			em.persist(e2);
			
			em.persist(u);//USUARIO	Tecnico
			em.persist(enc);//USUARIO Encargado	
			em.persist(adm);//USUARIO Administrador	
			
			em.persist(g);//GRUPO	
			
			em.persist(tip);//tipo de tarea
			em.persist(t);//TAREA
			
			
					
			
			
			em.getTransaction().commit();
			//System.out.println("guarde una tarea: "+t.getDescripcion());
				
			em.close();
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		

	}

}
