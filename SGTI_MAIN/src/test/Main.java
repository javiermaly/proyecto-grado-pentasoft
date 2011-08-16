package test;

import java.util.Calendar;
import java.util.List;

import beans.Cliente;
import beans.Encargado;
import beans.Estado;
import beans.Realiza;
import beans.Tarea;
import beans.Tecnico;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

import singleton.Singleton;
import stateless.ClienteRemote;
import stateless.TareaRemote;
import stateless.UsuarioRemote;



public class Main {

public static void main(String[] args) {		
					
			Singleton singleton = new Singleton();//acceso al JNDI
			
			// Llamada al Stateless del EJB				
			UsuarioRemote statelessMUsu = null;
			try {
				statelessMUsu = singleton.conectarMU();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			ClienteRemote statelessMCli = null; 
			try {
				statelessMCli = singleton.conectarMC();
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			
			TareaRemote statelessMTar=null;
			try{
				statelessMTar = singleton.conectarMT();
			}catch(Exception e){
				e.printStackTrace();
			}
				
			
			
			Encargado enc = new Encargado();
			enc.setCedula(40434685);
			enc.setNombre("Javier");
			enc.setApellido("Maly");
			enc.setUsuario("usu");
			enc.setPwd("pwd");
			enc.setDireccion("Paysandu 1242 / 203");
			enc.setCelular("099722146");
			
			Tecnico t = new Tecnico();
			t.setCedula(9999);
			t.setApellido("prueba");
			t.setNombre("juan");
			t.setUsuario("juan");
			t.setPwd("passw");
			
			
			//statelessMUsu.agregarUsuario(enc);	
			//statelessMUsu.agregarUsuario(t);
//			//statelessMUsu.actualizarUsuario(t);
//			//statelessMUsu.eliminarUsuario(41649489);
//			
//			Cliente cli = new Cliente();
//			cli.setCedula(1234);
//			cli.setEmpresa("La empresa");
//			cli.setDireccion("La calle 321");
//			cli.setNombre_RazonSocial("La razon social");
//						
//			statelessMCli.agregarCliente(cli);			
//						
//			
//			
//			
			Tarea tar= new Tarea();		
			
			//***************************************************
			//ARMADO DEL FLUJO DE ESTADOS DE LAS TAREAS.
			Estado estado = new Estado();
			estado.setDescripcion("Abierta");		
			Estado estado2 = new Estado();
			estado2.setDescripcion("Asignada");
			Estado estado3=new Estado();
			estado3.setDescripcion("En Proceso");
			Estado estado4=new Estado();
			estado4.setDescripcion("Derivada");
			Estado estado5=new Estado();
			estado5.setDescripcion("Re Abierta");
			Estado estado6=new Estado();
			estado6.setDescripcion("Finalizada");
			Estado estado7=new Estado();
			estado7.setDescripcion("Cerrada");
			
			
			//GUARDO LOS ESTADOS

//			statelessMTar.agregarEstado(estado);
//			statelessMTar.agregarEstado(estado2);
//			statelessMTar.agregarEstado(estado3);
//			statelessMTar.agregarEstado(estado4);
//			statelessMTar.agregarEstado(estado5);
//			statelessMTar.agregarEstado(estado6);
//			statelessMTar.agregarEstado(estado7);
			
			//ASIGNO ESTADOS SIGUIENTES PERMITIDOS POR ESTADO
			
			estado.addEstadoSgte(statelessMTar.encontrarEstado(2));
			estado.addEstadoSgte(statelessMTar.encontrarEstado(7));
			
			estado2.addEstadoSgte(statelessMTar.encontrarEstado(7));
			
			estado3.addEstadoSgte(statelessMTar.encontrarEstado(4));
			estado3.addEstadoSgte(statelessMTar.encontrarEstado(6));
			
			estado4.addEstadoSgte(statelessMTar.encontrarEstado(2));
			
			estado5.addEstadoSgte(statelessMTar.encontrarEstado(2));
			
			estado6.addEstadoSgte(statelessMTar.encontrarEstado(7));
			estado6.addEstadoSgte(statelessMTar.encontrarEstado(5));
			
			//MERGEO LOS ESTADOS PARA QUE TOMEN LOS CAMBIOS
			statelessMTar.actualizarEstado(estado);
			//statelessMTar.actualizarEstado(estado2);
//			statelessMTar.actualizarEstado(estado3);
//			statelessMTar.actualizarEstado(estado4);
//			statelessMTar.actualizarEstado(estado5);
//			statelessMTar.actualizarEstado(estado6);
			
			
			//FIN ARMADO FLUJO ESTADOS
			//****************************************************
			
			Tiene tiene = new Tiene();		
			tiene.setEstado(statelessMTar.encontrarEstado(1));
			tiene.setFechaInicio(Calendar.getInstance());
			//tiene.setFechaFin(Calendar.getInstance());
			
			Tipo tipo= new Tipo();
			tipo.setDescripcion("BASE DE DATOS");
			
			Realiza r= new Realiza();
			r.setId(1);
			r.setFechaInicio(Calendar.getInstance());
			r.setUsu(t);
			
			tar.setEsExterna(true);	
			tar.setDescripcion("Soporte tecnico a la Empresa X: revisar maquina en garantía");
			tar.setObservacion("Tarea 19");
			tar.setFechaApertura(Calendar.getInstance());
			tar.setFechaComprometida(Calendar.getInstance());
			tar.setTipo(tipo);
			tar.agregarTiene(tiene);
			tar.agregarRealiza(r);
			

			
			if (statelessMTar.agregarTarea(tar, tipo, tiene))
				System.out.println("TAREA DADA DE ALTA");
			else
				System.out.println("ERROR AL DAR DE ALTA LA TAREA");
			
			//listar
			List<Usuario> listaUsu= statelessMUsu.listarUsuarios();
			for (Usuario usuario : listaUsu) {
				
					System.out.println("NOMBRE: " + usuario.getNombre());
					System.out.println("APELLIDO: " + usuario.getApellido());
					System.out.println("CEDULA: " + usuario.getCedula());
					System.out.println(" ************************************* ");
			}							
			
			List<Tarea> listaTarea=statelessMTar.traerTodasTareas();
			Tiene tie=null;
			System.out.println(" ****************TAREAS**************** ");
			System.out.println(" ************************************* ");
			for(Tarea tarea : listaTarea){
				tie=statelessMTar.tieneDeTarea(tarea);
				System.out.println(tarea.getDescripcion()+"- Estado: "+tie.getEstado().getDescripcion());
				
			}
			System.out.println(" ************************************* ");
			
			System.out.println("- TODAS LAS TAREAS DEL USUARIO CEDULA 9999-");
			List<Tarea> listaTareaU=statelessMTar.tareasPorUsuario(t);
			
			for(Tarea tarea : listaTareaU){
				
				System.out.println("- Descripcion: "+tarea.getDescripcion()+"- id: "+tarea.getId());
				
			}
		
	}	
	
}
