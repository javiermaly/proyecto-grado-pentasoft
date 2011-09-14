package negocio;

import java.util.Calendar;
import java.util.Date;

import beans.Cliente;
import beans.Grupo;
import beans.Tarea;
import beans.Tiene;
import beans.Tipo;

import stateless.FacadeRemote;
import conexion.ConexionEJB;

public class TareaBean {

	private boolean esExterna;
	private String descripcion;
	private String observacion;
	private int tipo;
	private Date fechaComprometida;
	private int prioridad;
	private int grupoId;
	private int evento=0;
	
	private ClienteSession cliSession;
	
	ConexionEJB con = new ConexionEJB();	
	FacadeRemote statelessFacade= con.conectar();
	
	public boolean isEsExterna() {
		return esExterna;
	}
	public void setEsExterna(boolean esExterna) {
		this.esExterna = esExterna;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getObservacion() {
		return observacion;
	}
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public Date getFechaComprometida() {
		return fechaComprometida;
	}
	public void setFechaComprometida(Date fechaComprometida) {
		this.fechaComprometida = fechaComprometida;
	}		
	public int getPrioridad() {
		return prioridad;
	}
	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	public int getGrupoId() {
		return grupoId;
	}
	public void setGrupoId(int grupoId) {
		this.grupoId = grupoId;
	}
	public ClienteSession getCliSession() {
		return cliSession;
	}
	public void setCliSession(ClienteSession cliSession) {
		this.cliSession = cliSession;
	}	
	public int getEvento() {
		return evento;
	}
	public void setEvento(int evento) {
		this.evento = evento;
	}
	
	//ABRIR/CREAR LA TAREA
	public String abrirTarea(){
		
		Tarea t = new Tarea();
		Tipo tip = new Tipo();
		Tiene tiene = new Tiene();
		Grupo g = new Grupo();
		Cliente c = new Cliente();
		
		c=cliSession.getClienteSession();//asignar a c el cliente que está en la sesion
		
		tip=statelessFacade.buscarTipo(tipo);//encontrar el tipo pasado para asignarlo a la tarea
		
		tiene.setEstado(statelessFacade.buscarEstado(1));
		tiene.setFechaInicio(Calendar.getInstance());
		
		if (fechaComprometida != null) { //comprueba si no ingresó una fecha
			Calendar cal=Calendar.getInstance();
			cal.setTime(fechaComprometida);
			t.setFechaComprometida(cal);
		}
		
		g=statelessFacade.buscarGrupo(grupoId);
		
		t.setCliente(c);
		t.setDescripcion(descripcion);
		t.setEsExterna(esExterna);
		t.setFechaApertura(Calendar.getInstance());
		t.setObservacion(observacion);
		t.setPrioridad(prioridad);
		t.setTipo(tip);
		t.agregarTiene(tiene);
		
		
		
		if(statelessFacade.abrirTarea(t, tiene, g)){		
			System.out.println("TAREA DADA DE ALTA");
			evento=1;//exito
			return "TareaAbierta";
		}else{
			System.out.println("ERROR AL DAR DE ALTA LA TAREA");
			evento=2;
			return "ErrorTareaAbierta";
		}
		
		
	}
	
}
