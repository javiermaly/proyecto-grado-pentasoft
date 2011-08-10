package test;

import java.util.List;

import beans.Cliente;
import beans.Encargado;
import beans.Tecnico;
import beans.Usuario;

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
			
			Encargado enc = new Encargado();
			enc.setCedula(12345678);
			enc.setNombre("Javier");
			enc.setApellido("Maly");
			enc.setUsuario("usu");
			enc.setPwd("pwd");
			enc.setDireccion("Paysandu 1242 / 203");
			enc.setCelular("099722146");
			
			Tecnico t = new Tecnico();
			t.setCedula(41649489);
			t.setApellido("rodriguez");
			t.setNombre("pepe");
			t.setUsuario("pepe09");
			t.setPwd("passssssssss");
			
			//statelessMUsu.agregarUsuario(enc);	
			//statelessMUsu.agregarUsuario(t);
			//statelessMUsu.actualizarUsuario(t);
			statelessMUsu.eliminarUsuario(41649489);
			
			Cliente cli = new Cliente();
			cli.setCedula(1234);
			cli.setEmpresa("La empresa");
			cli.setDireccion("La calle 321");
			cli.setNombre_RazonSocial("La razon social");
						
			//statelessMCli.agregarCliente(cli);			
						
			
			
			//listar
			List<Usuario> listaUsu= statelessMUsu.listarUsuarios();
			for (Usuario usuario : listaUsu) {
				
					System.out.println("NOMBRE: " + usuario.getNombre());
					System.out.println("APELLIDO: " + usuario.getApellido());
					System.out.println("CEDULA: " + usuario.getCedula());
					System.out.println(" ************************************* ");
			}							
			
		
	}	
	
}
