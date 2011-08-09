package test;

import beans.Cliente;
import beans.Encargado;

import singleton.Singleton;
import stateless.ClienteRemote;
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
			//statelessMUsu.toString();
			//System.out.println("Llamado... " +mp+ " ID: " );ProyectoEAR/managerPersona/remote
			
			Encargado enc = new Encargado();
			enc.setCedula(12345678);
			enc.setNombre("Javier");
			enc.setApellido("Maly");
			enc.setUsuario("usu");
			enc.setPwd("pwd");
			enc.setDireccion("Paysandu 1242 / 203");
			enc.setCelular("099722146");
			
			statelessMUsu.agregarUsuario(enc);	
			
			Cliente cli = new Cliente();
			cli.setCedula(1234);
			cli.setEmpresa("La empresa");
			cli.setDireccion("La calle 321");
			cli.setNombre_RazonSocial("La razon social");
						
			statelessMCli.agregarCliente(cli);			
						
			
			
//			Programador programador= new Programador("Pedro",120830,"20 de setiembre","27093825","JAVA");
//			statelessEjb.agregarPersona(programador);
//						
//			
//			statelessEjb.listarPersonas();
//			
		
	}	
	
}
