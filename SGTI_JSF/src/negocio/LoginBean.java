package negocio;

import beans.Administrador;
import beans.Encargado;

import stateless.FacadeRemote;
import conexion.ConexionEJB;


public class LoginBean {
	private UsuarioBean usuSession;
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

	
	public UsuarioBean getUsuSession() {
		return usuSession;
	}
	public void setUsuSession(UsuarioBean usuSession) {
		this.usuSession = usuSession;
	}
	public String login(){
		
		if(!((statelessFacade.login(cedula, pwd))==null)){
			System.out.println(usuSession.getUsuarioSession().getApellido());
			System.out.println("metodo login");
			System.out.println("pregunto si es administrador");
			return "personaLogueada";
			
			
//			if(usuSession.getUsuarioSession() instanceof Administrador){
//				return "personaLogueadaAdministrador";
//			}
//			System.out.println("pregunto si es Encaragado");
//			if(usuSession.getUsuarioSession() instanceof Encargado){
//				return "personaLogueadaEncargado";
//			}
//			
//			else return "perfil incorrecto";
		}
		else
			return "errorLogin";
		
				
	}
}

