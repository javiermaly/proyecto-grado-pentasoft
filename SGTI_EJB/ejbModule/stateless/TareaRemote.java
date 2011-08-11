package stateless;

import java.util.Calendar;
import java.util.List;

import javax.ejb.Remote;
import javax.persistence.EntityManager;

import beans.Estado;
import beans.Grupo;
import beans.Realiza;
import beans.Tarea;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

@Remote
public interface TareaRemote {
	public boolean agregarTarea(Tarea t, Tipo tipo, Tiene tiene);
	public List<Tarea> traerTodasTareas( );
	public Tarea encontrarTarea(int id);
	public List<Tarea> tareasPorUsuario(Usuario u);
	public Tarea actualizarTarea(Tarea t);
	public boolean eliminarTarea(Tarea t);
	public boolean altaTareaRealiza(Tarea t, Realiza r);
	public boolean asignaTareaUsuario(Tarea t, Usuario u, Calendar fecIni) ;
	public boolean altaGrupo(Grupo gr);
	public Grupo encontrarGrupo(int id);
	public Grupo actualizarGrupo(Grupo gr) ;
	public boolean asignarTareaGrupo(Tarea t, Grupo gr) ;
	public Estado encontrarEstado(int id);
	public Tiene tieneDeTarea(Tarea t);
	public boolean cambiarEstadoTarea(Tarea t, Estado est) ;
	public boolean agregarEstado(Estado est);
	
}
