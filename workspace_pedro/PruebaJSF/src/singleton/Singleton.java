package singleton;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import stateless.PersonaRemote;
import beans.Persona;

public class Singleton {

	public Singleton() {
		// TODO Auto-generated constructor stub
				
		
	}
	
	public PersonaRemote conectar(){
		

		try {
			// Acceso a JNDI
			Properties properties = new Properties();
			properties.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
			properties.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
			properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
			Context ctx = new InitialContext(properties);
			
			// Llamada al Stateless
			System.out.println("########\nVoy a llamar al Stateless EJB.\n########");
					
			PersonaRemote statelessEjb = (PersonaRemote)ctx.lookup("ProyEAR/ManagerPersona/remote");
			return statelessEjb;
		
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		
		}	
		
	}

}
