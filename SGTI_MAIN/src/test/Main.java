package test;

import java.util.Calendar;
import java.util.List;

import beans.Cliente;
import beans.Encargado;
import beans.Estado;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			ClienteRemote statelessMCli = null; 
			try {
				statelessMCli = singleton.conectarMC();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			TareaRemote statelessMTar=null;
			try{
				statelessMTar = singleton.conectarMT();
			}catch(Exception e){
				e.printStackTrace();
			}
				
			
			
			Encargado enc = new Encargado();
			enc.setCedula(12345678);
			enc.setNombre("Javier");
			enc.setApellido("Maly");
			enc.setUsuario("usu");
			enc.setPwd("pwd");
			enc.setDireccion("Paysandu 1242 / 203");
			enc.setCelular("099722146");
			
			Tecnico t = new Tecnico();
			t.setCedula(4164949);
			t.setApellido("prueba");
			t.setNombre("juan");
			t.setUsuario("juan");
			t.setPwd("passw");
			
			
			//statelessMUsu.agregarUsuario(enc);	
			//statelessMUsu.agregarUsuario(t);
			//statelessMUsu.actualizarUsuario(t);
			//statelessMUsu.eliminarUsuario(41649489);
			
			Cliente cli = new Cliente();
			cli.setCedula(1234);
			cli.setEmpresa("La empresa");
			cli.setDireccion("La calle 321");
			cli.setNombre_RazonSocial("La razon social");
						
			//statelessMCli.agregarCliente(cli);			
						
			
			
			
			Tarea tar= new Tarea();		
			
			Estado estado = new Estado();
			estado.setDescripcion("Abierta");		
			statelessMTar.agregarEstado(estado);
			Estado estado2 = new Estado();
			estado2.setDescripcion("Asignada");
			statelessMTar.agregarEstado(estado2);
			
			Tiene tiene = new Tiene();		
			tiene.setEstado(statelessMTar.encontrarEstado(1));
			tiene.setFechaInicio(Calendar.getInstance());
			//tiene.setFechaFin(Calendar.getInstance());
			
			Tipo tipo= new Tipo();
			tipo.setDescripcion("BASE DE DATOS");
			tar.setEsExterna(true);	
			tar.setDescripcion("Soporte tecnico a la Empresa X: revisar maquina en garantía");
			tar.setObservacion("Observacion de la tarea");
			tar.setFechaApertura(Calendar.getInstance());
			tar.setFechaComprometida(Calendar.getInstance());
			tar.setTipo(tipo);
			tar.agregarTiene(tiene);
			

			
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
			for(Tarea tarea : listaTarea){
				tie=statelessMTar.tieneDeTarea(tarea);
				System.out.println(tarea.getDescripcion()+"- Estado: "+tie.getEstado().getDescripcion());
				
			}
			
			
			System.out.println("- TODAS LAS TAREAS DEL USUARIO CEDULA 9999-");
			List<Tarea> listaTareaU=statelessMTar.tareasPorUsuario(t);
			
			for(Tarea tarea : listaTareaU){
				
				System.out.println("- Descripcion: "+tarea.getDescripcion()+"- id: "+tarea.getId());
				
			}
		
	}	
	
}
