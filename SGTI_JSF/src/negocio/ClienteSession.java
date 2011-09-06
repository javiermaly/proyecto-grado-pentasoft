package negocio;

import beans.Cliente;

public class ClienteSession {

	public Cliente clienteSession;

	public Cliente getClienteSession() {
		return clienteSession;
	}

	public void setClienteSession(Cliente clienteSession) {
		System.out.println("set de Cliente session");
		this.clienteSession = clienteSession;
	}
}
