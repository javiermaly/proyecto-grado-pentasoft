package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import manager.ManagerTarea;
import manager.ManagerUsuario;

import conexion.DBConection;
import beans.Administrador;
import beans.Cliente;
import beans.Encargado;
import beans.Estado;
import beans.Grupo;
import beans.Realiza;
import beans.Tarea;
import beans.Tecnico;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

public class MainTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
//		DBConection db = new DBConection();
//		System.out.println(db.toString());
//		EntityManager em = db.conectar();
//		Calendar fecCom=Calendar.getInstance();
//		Calendar horaI=Calendar.getInstance();
//		ManagerUsuario mu = new ManagerUsuario();
//		ManagerTarea mt = new ManagerTarea();
//		
//		Tecnico u = new Tecnico();
//		u.setApellido("tecnicity");
//		u.setCedula(12345678);
//		u.setCelular("099111111");
//		u.setDireccion("sarasa 345 apto 999	");
//		u.setNombre("alfredo");
//		u.setPwd("pass");
//		u.setTelefono("27092835");
//		u.setUsuario("atecnicity");
//		u.setEsExterno(false);
//		
//		
//		Encargado enc = new Encargado();
//		enc.setApellido("encargueti");
//		enc.setCedula(4111111);
//		enc.setCelular("09972545");
//		enc.setDireccion("sarasa / 444");
//		enc.setNombre("alberto");
//		enc.setPwd("albertito");
//		enc.setTelefono("2944333");
//		enc.setUsuario("aencargueti");
//		
//		Administrador adm = new Administrador();
//		adm.setApellido("adm");
//		adm.setCedula(123123);
//		adm.setCelular("09972545");
//		adm.setDireccion("sarasa / 444");
//		adm.setNombre("adm");
//		adm.setPwd("adm");
//		adm.setTelefono("2944333");
//		adm.setUsuario("adm");
//		
//		List<Tecnico> colTecnicos= new ArrayList<Tecnico>();
//		colTecnicos.add(u);
//		colTecnicos.add(enc);
//		Grupo g = new Grupo();
//		g.setDescripcion("soporte tecnico externo");
//		g.setEnc(enc);
//		g.setColTecnicos(colTecnicos);
//		g.setId(1);
//		
//		Cliente cli =new Cliente(1,"asdf","ffff",233333,2222,"ddddd","eeee",horaI);
//		//Grupo gru = new Grupo(1,"grupo",enc);
//		
//		Tipo tip=new Tipo();
//		tip.setDescripcion("Desarrollo");
//		tip.setId(1);
//		
//		Estado e1= new Estado();
//		Estado e2 = new Estado();
//		
//		e1.setId(1);
//		e1.setDescripcion("Abierta");
//		
//		e2.setId(2);
//		e2.setDescripcion("Asignada");
//		
//		
//		//t.setFechaCierre(Calendar.getInstance());
//		//horaI.set(Calendar.HOUR_OF_DAY, 16);
//		//horaI.set(Calendar.MINUTE,44);			
//		//t.setObservacion("OBSERVACION DE TAREA");
////		t.setTipo(tip);
////		t.setCliente(cli);
////		t.setGrupo(g);
//		
//		
////		
////		//Asigna un estado a una tarea
////		Tiene tiene=new Tiene();
////		tiene.setTarea(t);
////		tiene.setFechaInicio(fecCom);
////		tiene.setEstado(e1);
////		
////		//finalizar estado
////		tiene.setFechaFin(horaI);
////		
////		Tiene tiene2 =  new Tiene();
////		tiene2.setTarea(t);
////		tiene2.setFechaInicio(fecCom);
////		tiene2.setEstado(e2);
////		
////		
//		
//
//
//			
////		Realiza r= new Realiza(1,horaI,null,enc,t);
////		List<Realiza> colRealiza= new ArrayList<Realiza>();
////		colRealiza.add(r);
////		//t.setListRealiza(colRealiza);
////		Realiza r2= new Realiza(1,horaI,null,u,t);
////		colRealiza.add(r2);
////		
////		
//		
//		
//		
//		try {
//			
//			em.getTransaction().begin();
//			//INGRESOS:
//			mu.altaUsuario(u); //alta de un tecnico
//			mu.altaUsuario(enc); //alta de un encargado
//			mu.altaUsuario(adm);
//			
//			em.persist(tip);//tipo de tarea
//			em.persist(cli);
//			em.persist(g);
//			
//			em.persist(e1);//alta de estados.
//			em.persist(e2);
//			
//			
//			
////			mt.altaTareaRealiza(em, t, r);//alta tarea con realiza
////			mt.altaTareaRealiza(em, t, r2);//misma tarea realizada por otro usuario
////			//mt.altaTarea(em, t);
////			
////			
////			em.persist(tiene);//asigna un estado a una tarea
////			
////			em.persist(tiene2);//cambia el estado de una tarea
////			
//			//administrativo abre una tarea
//			//mt.altaTarea(em, t);
//			
//			em.getTransaction().commit();
//			
////			em.getTransaction().begin();
////			em.persist(e1); //ESTADOS
////			em.persist(e2);
////			
////			em.persist(u);//USUARIO	Tecnico
////			em.persist(enc);//USUARIO Encargado	
////			em.persist(adm);//USUARIO Administrador	
////			
////			em.persist(g);//GRUPO	
////			
////			em.persist(tip);//tipo de tarea
////			em.persist(t);//TAREA
////			
////							
////			
////			
////			em.getTransaction().commit();
////			//System.out.println("guarde una tarea: "+t.getDescripcion());
////				
////			em.close();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//			
//		}
//		
//
//		
//		/////////LISTADOS//////////////
//		System.out.println("Listo todas las personas guardadas");
//		System.out.println("==============================");
//		System.out.println("==============================");
//		System.out.println("==============================");
//		
//		List<Usuario> listaUsuarios = mu.traerTodosUsuarios(em);
//		//Tecnico tec;
//		for (Usuario usu : listaUsuarios) {
//
//			System.out.println("NOMBRE: " + usu.getNombre());
//			System.out.println("APELLIDO: " + usu.getApellido());
//			System.out.println("CEDULA: " + usu.getCedula());
//			System.out.println("DIRECCION: " + usu.getDireccion());
//			System.out.println("TELEFONO: " + usu.getTelefono());
//
//			if (usu instanceof Encargado) {
//				//tec=(Tecnico)usu;
//				System.out.println("TIPO: Encargado");
//				
//			}else if(usu instanceof Tecnico){
//				System.out.println("TIPO: tecnico");
//			}
//
//			System.out.println("==============================");
//			
//		}
//		
//		System.out.println("==============================");
//		System.out.println("encontrar un usuario");
//		
//		Usuario ubuscado = mu.encontrarUsuario(em, u.getCedula());
//		if (ubuscado instanceof Tecnico) {
//			
//			System.out.println("NOMBRE: " + ubuscado.getNombre());
//			System.out.println("DIRECCION: " + ubuscado.getDireccion());
//			System.out.println("TELEFONO: " + ubuscado.getTelefono());
//		}
//		
//		
//		/////////MODIFICAR/////////////
//		System.out.println("\n### Modifico los datos del encargado ");
//		ubuscado.setTelefono("66666666");
//		ubuscado = mu.actualizarUsuario(em, ubuscado); //hay que buscar antes de actualizar
//				
//		System.out.println(u.getNombre());
//		System.out.println(u.getTelefono());
//		
//		
//		/////////ELIMINAR//////////////
//		System.out.println("\n### Elimino a un usuario");
//		mu.eliminarUsuario(em, ubuscado); 
//		System.out.println("\n### persona eliminada: "+ubuscado.getNombre());
//	
//
//		System.out.println("\n### Busco la persona recien eliminada");
//		ubuscado = mu.encontrarUsuario(em, ubuscado.getCedula());
//		System.out.println(ubuscado);
//		
//		
//		System.out.println("\n### Busco la persona de cedula: " + u.getCedula());
//		ubuscado = mu.encontrarUsuario(em, u.getCedula());
//		System.out.println("NOMBRE: " + u.getNombre());
//		
		
		
		
	}

}
