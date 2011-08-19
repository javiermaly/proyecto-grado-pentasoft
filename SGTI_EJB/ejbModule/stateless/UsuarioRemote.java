package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.Usuario;

@Remote
public interface UsuarioRemote  {

	public boolean agregarUsuario(Usuario u);	
	public boolean eliminarUsuario(int ced);	
	public List<Usuario> listarUsuarios();	
	public Usuario encontrarUsuario(int ced);
	public boolean actualizarUsuario(Usuario u);
	
}
