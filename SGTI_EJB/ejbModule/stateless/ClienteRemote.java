package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.Cliente;

@Remote
public interface ClienteRemote {
	
	public void agregarCliente(Cliente c);	
	public void eliminarCliente(int ced);	
	public List<Cliente> listarClientes();	
	public void encontrarCliente(int ced);	
	public void actualizarCliente(Cliente u);
	
}
