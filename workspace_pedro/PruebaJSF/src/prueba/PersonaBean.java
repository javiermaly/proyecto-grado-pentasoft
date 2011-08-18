package prueba;


import java.util.List;
import java.util.Properties;

import beans.Persona;
import javax.ejb.EJB;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import singleton.Singleton;
import stateless.PersonaRemote;



public class PersonaBean {


	private int cedula;
	private String nombre;
	private String direccion; 
	private String telefono;
	List<Persona> listarPersonas;

	
	
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public List<Persona> getListarPersonas() {
	    
		try {
			Singleton singleton = new Singleton();
			PersonaRemote statelessEjb= singleton.conectar();
			statelessEjb.toString();		
			
			//listarPersonas= new LinkedList<Persona>();
			listarPersonas=statelessEjb.listarPersonas();	
		
			return listarPersonas;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}
	

	public void setListarPersonas(List<Persona> listarPersonas) {
	      this.listarPersonas = listarPersonas;
	}
	
	
	public String ingresarPersona(){		
						
		try {
			Singleton singleton = new Singleton();
			PersonaRemote statelessEjb= singleton.conectar();
			statelessEjb.toString();		
			
			Persona p = new Persona(nombre,cedula, direccion, telefono);
				 
			statelessEjb.agregarPersona(p);
			return "PersonaIngresada";
		
		} catch (Exception e) {
			e.printStackTrace();
			return "PersonaNoIngresada";
		}	
				
		
	}//ingresar persona
	
		

	public String eliminarPersona(){		
				
		int ced;
		try {
			Singleton singleton = new Singleton();
			PersonaRemote statelessEjb= singleton.conectar();
			statelessEjb.toString();		
			
			ced=this.getCedula();
			statelessEjb.eliminarPersona(ced);
			
			return "PersonaEliminada";
		
		} catch (Exception e) {
			e.printStackTrace();
			return "PersonaNoEliminada";
		}	
				
		
	}//eliminar persona
	
	
		
//	public List<Persona> listarPersonas(){
//		
//		try {
//			// Acceso a JNDI
//			Properties properties = new Properties();
//			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
//			properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
//			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
//			Context ctx = new InitialContext(properties);
//			
//			// Llamada al Stateless
//			System.out.println("########\nVoy a llamar al Stateless EJB.\n########");
//					
//			PersonaRemote statelessEjb = (PersonaRemote)ctx.lookup("ProyEAR/ManagerPersona/remote");
//			statelessEjb.toString();		
//			
//			//listarPersonas= new LinkedList<Persona>();
//			listarPersonas=statelessEjb.listarPersonas();	 		 
//			
////			for (Persona persona : listarPersonas) {
////				
////							System.out.println("NOMBRE: " + persona.getNombre());
////							System.out.println("DIRECCION: " + persona.getDireccion());
////							System.out.println("TELEFONO: " + persona.getTelefono());
////				
////						
////							System.out.println("==============================");
////				
////			}
//		
//			return listarPersonas;
//		
//		} catch (NamingException e) {
//			e.printStackTrace();
//			return null;
//		}		
//				
//	}//cierra listarPersonas
	
}//cierra clase