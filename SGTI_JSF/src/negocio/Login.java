package negocio;

import stateless.FacadeRemote;
import conexion.ConexionEJB;
import beans.Usuario;

public class Login {
	ConexionEJB con = new ConexionEJB();
	
	private long cedula;
	private String pwd;
	
	FacadeRemote statelessFacade= con.conectar();
	
	
	
	public long getCedula() {
		return cedula;
	}



	public void setCedula(long cedula) {
		this.cedula = cedula;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String login(){
		if(!((statelessFacade.login(cedula, pwd))==null)){
			return "personaLogueada";
		}
		else
			return "errorLogin";
		
		
	}
}
