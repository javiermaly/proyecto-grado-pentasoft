package negocio;

import stateless.FacadeRemote;
import conexion.ConexionEJB;


public class LoginBean {
	
	private long cedula;
	private String pwd;
	
	ConexionEJB con = new ConexionEJB();	
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

