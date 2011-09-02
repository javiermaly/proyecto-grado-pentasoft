package negocio;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

import beans.Administrador;
import beans.Administrativo;
import beans.Encargado;
import beans.Tecnico;
import beans.Usuario;

import stateless.FacadeRemote;
import conexion.ConexionEJB;


public class LoginBean {
	private UsuarioBean usuSession;
	private long cedula;
	private String pwd;
	private int perfil;
	
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
	
	public int getPerfil() {
		return perfil;
	}
	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	public String login(){
		
		if(!((statelessFacade.login(cedula, pwd))==null)){
			Usuario u = statelessFacade.encontrarUsuario(cedula);
			usuSession.setUsuarioSession(u);
			System.out.println(usuSession.getUsuarioSession().getApellido());
			System.out.println("metodo login");
						
			if(usuSession.getUsuarioSession() instanceof Administrador){
				System.out.println("es administrador");
				perfil=1;
				
			}else if(usuSession.getUsuarioSession() instanceof Administrativo){
				System.out.println("es administrativor");
				perfil=2;
				
			}else if(usuSession.getUsuarioSession() instanceof Encargado){
				perfil=3;
				System.out.println("es encargado");
				
			}else if(usuSession.getUsuarioSession() instanceof Tecnico){
				perfil=4;
				System.out.println("tecnico");
				
			}
			return "usuarioLogueado";
			
		}
		else
			System.out.println("error login");
			return "errorLogin";
		
				
	}
	
}

