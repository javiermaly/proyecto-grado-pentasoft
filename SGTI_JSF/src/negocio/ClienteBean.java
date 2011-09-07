package negocio;

import stateless.FacadeRemote;
import conexion.ConexionEJB;
import beans.Cliente;

public class ClienteBean {

	private long cedRut;
	private ClienteSession cliSession;
	
	ConexionEJB con = new ConexionEJB();	
	FacadeRemote statelessFacade= con.conectar();
	
		
	public long getCedRut() {
		return cedRut;
	}
	public void setCedRut(long cedRut) {
		this.cedRut = cedRut;
	}
	public ClienteSession getCliSession() {
		return cliSession;
	}
	public void setCliSession(ClienteSession cliSession) {
		this.cliSession = cliSession;
	}


	//buscador para el Abrir Tarea
	public String buscarClienteAbrirTarea(){
		Cliente c = new Cliente();
		c = statelessFacade.buscarCliente(cedRut);
		if(c!=null){			
			cliSession.setClienteSession(c);
			System.out.println(cliSession.getClienteSession().getNombre_RazonSocial());
			System.out.println("cliente encontrado y puesto en la session");
		
			return "clienteEcontradoAbrirTarea";
		}else{
			System.out.println("cliente nulo!!");
			return "clienteNoEncontrado";
		}	
	}
	
	//buscador para Clientes
	public String buscarCliente(){
		Cliente c = new Cliente();
		c = statelessFacade.buscarCliente(cedRut);
		if(c!=null){			
			cliSession.setClienteSession(c);
			System.out.println(cliSession.getClienteSession().getNombre_RazonSocial());
			System.out.println("cliente encontrado y puesto en la session");
		
			return "clienteEcontrado";
		}else{
			System.out.println("cliente nulo!!");
			return "clienteNoEncontrado";
		}	
	}
	
	
	
}
