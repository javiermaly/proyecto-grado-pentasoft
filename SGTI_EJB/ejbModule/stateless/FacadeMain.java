package stateless;

import java.util.List;

import javax.ejb.Stateless;

import singleton.Singleton;

import beans.*;

@Stateless
public class FacadeMain implements FacadeRemote {
	TareaRemote statelessMTar = null;
	ManagerT mt = new ManagerT();
    ManagerU mu=new ManagerU();
    ManagerC mc=new ManagerC();

	
	public boolean abrirTarea(Tarea t, Tipo tipo, Tiene tiene) {// la que realiza el administrativo
		mt.agregarTarea(t, tipo, tiene);
		return true;
	}

	public boolean tomarTarea(Tarea t, Realiza r, Tipo ti) {// cuando un técnico trabaja sobre la tarea
		mt.altaTareaRealiza(t, r);
		return true;
	}

	public Tarea buscarTarea(int id) { // buscar una tarea
		Tarea t = mt.encontrarTarea(id);
		return t;
	}

	@Override
	public Tarea modificarTarea(Tarea tar) { // modificar tarea
		Tarea t = mt.actualizarTarea(tar);
		return t;
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

//	@Override
//	public boolean asignarEncargadoGrupo(Encargado enc, Grupo gr) {
//		// TODO Auto-generated method stub
//		return false;
//	}

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

//	@Override
//	public boolean avanzarTareaEstado(Tarea tar, Estado sigEst) {
//		boolean retorno = false;
//		Tiene tiene = null;
//		tiene = mt.tieneDeTarea(tar);
//		Estado estActual = tiene.getEstado();
//		System.out.println("Estado Actual: " + estActual.getDescripcion());
//		if (!(estActual == sigEst)) {
//			System.out.println("los estados son diferentes");
//			if (mt.validarEstadoSiguiente(estActual, sigEst)) {
//				System.out.println("valide que el sgte estado es posible");
//				if (mt.cambiarEstadoTarea(tar, sigEst)) {
//					retorno = true;
//				}
//			}
//
//		}
//		return retorno;
//	}

	@Override
	public List<Tarea> listadoTareasPendientesPorGrupo(Encargado enc, Grupo gr) {
		// TODO Auto-generated method stub
		return null;
	}

}
