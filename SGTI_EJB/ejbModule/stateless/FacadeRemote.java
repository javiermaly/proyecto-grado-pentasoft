package stateless;

import java.util.List;

import javax.ejb.Remote;

import beans.*;

@Remote
public interface FacadeRemote {
        //TAREAS
		public boolean abrirTarea(Tarea t, Tipo tipo, Tiene tiene);//queda dada de alta y asignada a un grupo con una prioridad determinada
        public boolean tomarTarea(Tarea t, Realiza r, Tipo ti);//cuando el tecnico trabaja sobre la tarea
        public Tarea buscarTarea(int id);
        public Tarea modificarTarea(Tarea t);
        public boolean bajaTarea(Tarea t); //Solo si estado=ABIERTA
        public boolean asignarTareaGrupo(Tarea tar, Grupo gr);//solo Administrativo, administrador
        // asignarTareaTecnico--cuando asigna creamos un realiza sin fecha de inicio, cuando el loco
        //toma la tarea le seteamos la fecha de inicio.
        public boolean asignarTareaTecnico(Tarea tar, Tecnico tec, Usuario usu);//Solo lo puede hacer el encargado y a los tecnicos de su grupo
        public boolean derivarTarea(Tarea tar, Grupo gr); //solo encargado y administrador
        
        
        //CLIENTES
        public boolean altaCliente(Cliente c);
        public boolean modificarCliente(Cliente c);
        public boolean bajaCliente(Cliente c); //Solo si el cliente no tiene tareas asignadas
        
        //GRUPO
        public boolean altaGrupo(Grupo g);
        public boolean modificarGrupo(Grupo g);
        public boolean bajaGrupo(Grupo g);//solo si el grupo no tiene personas o tareas asignadas
        
        //USUARIOS
        public boolean altaAdministrador(Administrador admin);
        public boolean altaAdministrativo(Administrativo ad);
        public boolean altaEncargado(Encargado enc);
        public boolean altaTecnico(Tecnico tec);
        public boolean modifUsuario(Usuario usu);
        public boolean bajaUsu(Usuario usu); //Solo si no trabajo sobre alguna tarea
        public boolean inhabilitarUsuario(Usuario usu);
        public Usuario login(String usu, String pwd);//si existe el usr y si esta habilitado
        
       
        //LISTADOS
        //listado de tareas asignadas por usuario.
        //listado de tareas en proceso por usuario.        
        public List<Tarea> listadoTareasPorUsuario();//Ordenadas por PRIORIDAD, si hay mas de una con la misma prioridad se ordenan por id
       // public boolean avanzarTareaEstado(Tarea tar, Estado est);
        public List<Tarea> listadoTareasPendientesPorGrupo(Encargado enc, Grupo gr);//Tareas sin asignar por grupo y encargado, ordenadas por prioridad, si hay mas de una con la misma prioridad se ordenan por id
        
        
        
        
        
}
