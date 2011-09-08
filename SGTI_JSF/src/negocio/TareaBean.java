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
	private Calendar fechaComprometida;
	private int prioridad;
	private int grupoId;
	
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
	public Calendar getFechaComprometida() {
		return fechaComprometida;
	}
	public void setFechaComprometida(Calendar fechaComprometida) {
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
		
		g=statelessFacade.buscarGrupo(grupoId);
		
		t.setCliente(c);
		t.setDescripcion(descripcion);
		t.setEsExterna(esExterna);
		t.setFechaApertura(Calendar.getInstance());
		//t.setFechaComprometida(fechaComprometida);
		t.setObservacion(observacion);
		t.setPrioridad(prioridad);
		t.setTipo(tip);
		t.agregarTiene(tiene);
		
		g.asignaTarea(t);	
		
		if(statelessFacade.abrirTarea(t, tiene, g)){		
			System.out.println("TAREA DADA DE ALTA");
			return "TareaAbierta";
		}else{
			System.out.println("ERROR AL DAR DE ALTA LA TAREA");
			return "ErrorTareaAbierta";
		}
		
		
	}
	
}
