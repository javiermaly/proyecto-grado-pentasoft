package negocio;

import java.util.Calendar;

import stateless.FacadeRemote;
import conexion.ConexionEJB;
import beans.Cliente;

public class ClienteBean {

	private long cedRut;
	private String nombreRazSocial;
	private String direccion;
	private String telefono;
	private Calendar fechaFinGarantia;
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


	public String getNombreRazSocial() {
		return nombreRazSocial;
	}
	public void setNombreRazSocial(String nombreRazSocial) {
		this.nombreRazSocial = nombreRazSocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public Calendar getFechaFinGarantia() {
		return fechaFinGarantia;
	}
	public void setFechaFinGarantia(Calendar fechaFinGarantia) {
		this.fechaFinGarantia = fechaFinGarantia;
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
			//cliSession.setClienteSession(null);
			
			
			System.out.println("cliente nulo!!");
			return "clienteNoEncontrado";
		}	
	}
	
	public String altaCliente(){
		long ceduln=getCedRut();
		System.out.println("veo si llega la cedula: "+getCedRut());
		System.out.println("veo si llega la cedula: "+cedRut);
		Cliente c= new Cliente();
		c.setCedRut(ceduln);
		//c.setCedRut(getCedRut());
		c.setDireccion(getDireccion());
		c.setNombre_RazonSocial(getNombreRazSocial());
		c.setTelefono(getTelefono());
		System.out.println("altacliente en clienteBean"+c.getCedRut());
		System.out.println(c.getNombre_RazonSocial());
		if(statelessFacade.altaCliente(c)){
			return "altaClienteOK";
		}
		else
			return "falloAltaCliente";
	}
	
}
