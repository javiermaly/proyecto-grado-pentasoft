package stateless;

import java.util.List;

import javax.ejb.Stateless;

import beans.Administrador;
import beans.Administrativo;
import beans.Cliente;
import beans.Encargado;
import beans.Estado;
import beans.Grupo;
import beans.Tarea;
import beans.Tecnico;
import beans.Usuario;

@Stateless
public class FacadeMain  implements FacadeRemote{

	@Override
	public boolean altaTarea(Tarea t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarTarea(Tarea t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaTarea(Tarea t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaCliente(Cliente c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarCliente(Cliente c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaCliente(Cliente c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaGrupo(Grupo g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modificarGrupo(Grupo g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaGrupo(Grupo g) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaAdministrador(Administrador admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaAdministrativo(Administrativo ad) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaEncargado(Encargado enc) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean altaTecnico(Tecnico tec) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean modifUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean bajaUsu(Usuario usu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean inhabilitarUsuario(Usuario usu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Usuario login(String usu, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean asignarTareaGrupo(Tarea tar, Grupo gr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarEncargadoGrupo(Encargado enc, Grupo gr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean asignarTareaTecnico(Tarea tar, Tecnico tec) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean derivarTarea(Tarea tar, Grupo gr) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tarea> listadoTareasPorUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean avanzarTareaEstado(Tarea tar, Estado est) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Tarea> listadoTareasPendientesPorGrupo(Encargado enc, Grupo gr) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
