package negocio;

import java.util.List;

import stateless.FacadeRemote;
import conexion.ConexionEJB;

import beans.Administrador;
import beans.Administrativo;

import beans.Encargado;
import beans.Tecnico;
import beans.Usuario;

public class UsuariosBean {
	public Usuario usuarioRequest;
	private long cedula;
	private String nombre;
	private String apellido;
	private String usuario;
	private String pwd;
	private String telefono;
	private String direccion;
	private String celular;
	private String perfil;
	private boolean habilitado;
	private List<Usuario> listUsuarios;
	int evento = 0;

	ConexionEJB con = new ConexionEJB();
	FacadeRemote statelessFacade = con.conectar();

	public Usuario getUsuarioRequest() {
		return usuarioRequest;
	}

	public void setUsuarioRequest(Usuario usuarioRequest) {
		this.usuarioRequest = usuarioRequest;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public List<Usuario> getListUsuarios() {
		System.out.println("papap");
		listUsuarios=this.listadoUsuarios();
		System.out.println("Cargue:" + listUsuarios.size());
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuario> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public int getEvento() {
		return evento;
	}

	public void setEvento(int evento) {
		this.evento = evento;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public List<Usuario> listadoUsuarios() {
		List<Usuario> listUsuarios = statelessFacade.listarUsuarios();
		System.out.println("usuariosBean listado usuarios");

		for (Usuario usuario : listUsuarios) {
			if (usuario instanceof Administrativo) {
				usuario.setPerfil("Administrativo");
			} else if (usuario instanceof Administrador) {
				usuario.setPerfil("Administrador");
			} else if (usuario instanceof Encargado) {
				usuario.setPerfil("Encargado");
			} else if (usuario instanceof Tecnico) {
				usuario.setPerfil("Técnico");
			}

		}
		return listUsuarios;


	}

	// buscador para usuarios
	public String buscarUsuario() {
		Usuario u = new Usuario();

		u = statelessFacade.encontrarUsuario(cedula);
		if (u != null) {

			this.nombre = u.getNombre();
			this.celular = u.getCelular();

			if (u instanceof Administrativo) {
				System.out.println("es administrativo");
				this.perfil = "Administrativo";
			} else if (u instanceof Administrador) {
				System.out.println("es administrador");
				this.perfil = "Administrador";
			} else if (u instanceof Encargado) {
				this.perfil = "Encargado";
			} else if (u instanceof Tecnico) {
				this.perfil = "Técnico";
			} else
				this.perfil = "basura";

			System.out.println(perfil);

			System.out.println("usuario encontrado y puesto en el request");
			evento = 4;// encontrado
			return "usuarioEncontrado";
		} else {

			System.out.println("usuario nulo!!");
			evento = 3;// noexiste
			return "usuarioNoEncontrado";
		}
	}

}
