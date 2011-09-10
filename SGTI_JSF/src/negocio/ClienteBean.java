package negocio;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import stateless.FacadeRemote;
import conexion.ConexionEJB;
import beans.Cliente;

public class ClienteBean {

	private long cedRut;
	private String nombreRazSocial;
	private String direccion;
	private String telefono;
	private Date fechaFinGarantia;
	private ClienteSession cliSession;
	private List<Cliente> listClientes;
	List<ClienteSession> listClienteSession = null;

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

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

	public Date getFechaFinGarantia() {
		return fechaFinGarantia;
	}

	public void setFechaFinGarantia(Date fechaFinGarantia) {
		this.fechaFinGarantia = fechaFinGarantia;
	}
	

	// //buscador para el Abrir Tarea
	// public String buscarClienteAbrirTarea(){
	// Cliente c = new Cliente();
	// c = statelessFacade.buscarCliente(cedRut);
	// if(c!=null){
	// cliSession.setClienteSession(c);
	// System.out.println(cliSession.getClienteSession().getNombre_RazonSocial());
	// System.out.println("cliente encontrado y puesto en la session");
	//
	// return "clienteEcontradoAbrirTarea";
	// }else{
	// System.out.println("cliente nulo!!");
	// return "clienteNoEncontrado";
	// }
	// }

	public List<ClienteSession> getListClienteSession() {
		return listClienteSession;
	}

	public void setListClienteSession(List<ClienteSession> listClienteSession) {
		this.listClienteSession = listClienteSession;
	}

	public List<Cliente> getListClientes() {
		return listClientes;
	}

	public void setListClientes(List<Cliente> listClientes) {
		this.listClientes = listClientes;
	}

	// buscador para Clientes
	public String buscarCliente() {
		Cliente c = new Cliente();
		c = statelessFacade.buscarCliente(cedRut);
		if (c != null) {
			cliSession.setClienteSession(c);
			if(cliSession.getClienteSession().getFechaFinGarantia()!=null){
				Calendar fechG= cliSession.getClienteSession().getFechaFinGarantia();//si tiene fechaGarantia cargada la pasamos a Date
				Date fechaGarant = fechG.getTime();
				cliSession.fechaGarant=fechaGarant;
			}
			System.out.println(cliSession.getClienteSession().getNombre_RazonSocial());
			System.out.println("cliente encontrado y puesto en la session");

			return "clienteEcontrado";
		} else {
			// cliSession.clienteSession=null;
			// Cliente c2=new Cliente();
			// c2.setCedRut(cedRut);
			// cliSession.setClienteSession(c);
			// cliSession.clienteSession.setCedRut(cedRut);
			//
			// cliSession.setClienteSession(c2);
			cliSession.setClienteSession(null);
			System.out.println("cliente nulo!!");
			return "clienteNoEncontrado";
		}
	}

	public String altaCliente() {
		// long ceduln=getCedRut();
		System.out.println("veo si llega la cedula: " + getCedRut());
		System.out.println("veo si llega la cedula: " + cedRut);
		Cliente c = new Cliente();
		// c=cliSession.getClienteSession();
		c.setCedRut(getCedRut());
		c.setDireccion(getDireccion());
		c.setNombre_RazonSocial(getNombreRazSocial());
		c.setTelefono(getTelefono());
		if (!(fechaFinGarantia == null)) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(fechaFinGarantia);
			c.setFechaFinGarantia(cal);
		}
		System.out.println("altacliente en clienteBean" + c.getCedRut());
		System.out.println(c.getNombre_RazonSocial());
		if (statelessFacade.altaCliente(c)) {
			return "altaClienteOK";
		} else
			return "falloAltaCliente";
	}

	public String modificarCliente() {
		System.out.println("modificar cliente");
		Cliente c = statelessFacade.buscarCliente(getCedRut());
		
		if (!(c == null)) {
			c.setCedRut(getCedRut());
			c.setNombre_RazonSocial(getNombreRazSocial());
			c.setTelefono(getTelefono());
			//c.setDireccion(getDireccion());
			if (!(fechaFinGarantia == null)) {
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaFinGarantia);
				c.setFechaFinGarantia(cal);
			}
			cliSession.setClienteSession(c);
			if(!((statelessFacade.modificarCliente(c))==null)){
				return "clienteModificado";
			}
			else
				return "errorModificarCliente";

		}
		else 
			return "clienteNoExiste";

	}
	public String bajaCliente(){
		Cliente c=cliSession.getClienteSession();
		if(statelessFacade.bajaCliente(c)){
			return "bajaClienteOK";
		}
		else
			return "errorBajaCliente";
	}
	public String listadoClientes(){
		System.out.println("listado");
		
		listClientes=statelessFacade.listadoClientes();
			
		
		for (Cliente cliente : listClientes) {
			System.out.println(cliente.getNombre_RazonSocial());
			
		}
		
		return "";
		
	}
}
