package negocio;

import beans.Usuario;

public class UsuarioBean {
	public Usuario usuarioSession;
	public int perfil;//perfiles de usuario para ver que le mostramos en el header
	
	public Usuario getUsuarioSession() {
		return usuarioSession;
	}

	public void setUsuarioSession(Usuario usuarioSession) {
		System.out.println("set de usuario session");
		this.usuarioSession = usuarioSession;
	}

	public int getPerfil() {
		return perfil;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}
	
	
	
	
	

}
