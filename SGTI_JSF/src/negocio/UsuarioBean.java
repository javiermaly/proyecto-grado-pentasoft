package negocio;

import beans.Usuario;

public class UsuarioBean {
	public Usuario usuarioSession;

	public Usuario getUsuarioSession() {
		return usuarioSession;
	}

	public void setUsuarioSession(Usuario usuarioSession) {
		System.out.println("set de usuario session");
		this.usuarioSession = usuarioSession;
	}
	
	
	
	

}
