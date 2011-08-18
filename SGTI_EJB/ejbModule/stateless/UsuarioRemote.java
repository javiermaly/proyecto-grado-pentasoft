package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.Usuario;

@Remote
public interface UsuarioRemote  {

	public void agregarUsuario(Usuario u);	
	public void eliminarUsuario(int ced);	
	public List<Usuario> listarUsuarios();	
	public void encontrarUsuario(int ced);	
	public void actualizarUsuario(Usuario u);
	
}
