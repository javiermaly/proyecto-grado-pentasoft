package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.Cliente;

@Remote
public interface ClienteRemote {
	
	public boolean agregarCliente(Cliente c);	
	public boolean eliminarCliente(int ced);	
	public List<Cliente> listarClientes();	
	public Cliente encontrarCliente(int ced);	
	public Cliente actualizarCliente(Cliente u);
	
}
