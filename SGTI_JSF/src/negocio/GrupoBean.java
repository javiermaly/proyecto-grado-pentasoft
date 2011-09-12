package negocio;

import java.util.List;

import stateless.FacadeRemote;
import conexion.ConexionEJB;
import beans.Encargado;
import beans.Grupo;

public class GrupoBean {
	private int id;
	private String descripcion;
	private Encargado encargado;
	private List<Grupo> listGrupos;
	private int evento=0;
	

	ConexionEJB con = new ConexionEJB();	
	FacadeRemote statelessFacade= con.conectar();
	private List<Encargado> encargadosHabilitados=statelessFacade.listarEncargadosHabilitados();

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Encargado getEncargado() {
		return encargado;
	}
	public void setEncargado(Encargado encargado) {
		this.encargado = encargado;
	}
	public int getEvento() {
		return evento;
	}
	public void setEvento(int evento) {
		this.evento = evento;
	}
	
	public List<Grupo> getListGrupos() {
		return listGrupos;
	}
	public void setListGrupos(List<Grupo> listGrupos) {
		this.listGrupos = listGrupos;
	}
	
	public String altaGrupo(){
		Grupo g = new Grupo();
		g.setDescripcion(getDescripcion());
		if(statelessFacade.altaGrupo(g)){
			evento=1;
		}
		
		return "altaGrupoOK";
	}
	
	public void listarGrupos(){
		System.out.println("listar grupos");
		listGrupos=statelessFacade.listGrupos();
		for (Grupo grupo : listGrupos) {
			System.out.println(grupo.getDescripcion());
			
		}
		
	}
	
	public void setEncargadosHabilitados(List<Encargado> encargadosHabilitados) {
		this.encargadosHabilitados = encargadosHabilitados;
	}
	public List<Encargado> getEncargadosHabilitados() {
		return encargadosHabilitados;
	}
	
	
}
