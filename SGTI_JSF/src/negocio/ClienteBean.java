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



	public String buscarClienteAbrirTarea(){
		
		if(!((statelessFacade.buscarCliente(cedRut))==null)){
			Cliente c = statelessFacade.buscarCliente(cedRut);
			cliSession.setClienteSession(c);
			System.out.println(cliSession.getClienteSession().getNombre_RazonSocial());
			System.out.println("cliente encontrado y puesto en la session");
		
			return "clienteEcontradoAbrirTarea";
		}else{
			return "clienteNoEncontrado";
		}	
	}
	
}
