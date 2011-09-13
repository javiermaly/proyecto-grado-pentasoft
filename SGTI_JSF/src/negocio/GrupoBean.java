package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

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
	
	private ArrayList encargadosHabilitados= new ArrayList();

	
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
	public void setEncargadosHabilitados(ArrayList encargadosHabilitados) {
		this.encargadosHabilitados = encargadosHabilitados;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList getEncargadosHabilitados() {
		

	        List<Encargado> encargados = statelessFacade.listarEncargadosHabilitados();
	        encargadosHabilitados.clear();
	        for(int i=0; i<encargados.size(); i++)
	        {
	            Encargado enc = new Encargado();
	            enc = (Encargado)encargados.get(i);
	            
	           encargadosHabilitados.add(new SelectItem(enc, enc.getApellido()));
	        }       
	        
	        return encargadosHabilitados;
	    }
	
	
	
	public String altaGrupo(){
		Grupo g = new Grupo();
		g.setDescripcion(getDescripcion());
		System.out.println(encargado.getApellido());
		g.setEnc(getEncargado());
		
		if(statelessFacade.altaGrupo(g)){
			evento=1;
		}
		
		return "altaGrupoOK";
	}
	
	public String listarGrupos(){
		System.out.println("listar grupos");
		listGrupos=statelessFacade.listGrupos();
		for (Grupo grupo : listGrupos) {
			System.out.println(grupo.getDescripcion());
			
		}
		return "";
		
	}
	
	
		
		
	
	
//	public List<Encargado> traerEncargados(){
//		encargadosHabilitados=statelessFacade.listarEncargadosHabilitados();
//		
//		return encargadosHabilitados;
//	}
	
	
	
}
