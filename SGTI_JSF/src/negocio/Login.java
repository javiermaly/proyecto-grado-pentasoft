package negocio;

import stateless.FacadeRemote;
import conexion.ConexionEJB;
import beans.Usuario;

public class Login {
	ConexionEJB con = new ConexionEJB();
	
	FacadeRemote statelessFacade= con.conectar();
	
	
	public String login(long cedula,String pwd){
		if(!((statelessFacade.login(cedula, pwd))==null)){
			return "personaLogueada";
		}
		else
			return "errorLogin";
		
		
	}
}
