package test;


import java.util.Calendar;

import manager.ManagerTarea;
import manager.ManagerUsuario;
import beans.Estado;
import beans.Grupo;
import beans.Tarea;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

public class PruebasJavier {
	
	public static void main(String[] args) {
	
		ManagerTarea mt = new ManagerTarea();
		Tarea t= new Tarea();		
		Tarea t2= new Tarea();
		
		Estado estado = new Estado();
		estado.setId(1);
		estado.setDescripcion("Abierta");		
		mt.agregarEstado(estado);
		Estado estado2 = new Estado();
		estado2.setId(2);
		estado2.setDescripcion("Asignada");
		mt.agregarEstado(estado2);
		
		
		Tiene tiene = new Tiene();		
		tiene.setEstado(mt.encontrarEstado(1));
		tiene.setFechaInicio(Calendar.getInstance());
		tiene.setTarea(t);
		
	
		
		Tipo tipo= new Tipo();
		tipo.setDescripcion("TIPO DE TAREA");
		t.setEsExterna(true);	
		t.setDescripcion("Soporte tecnico a la Empresa X: revisar maquina en garantía");
		t.setObservacion("Observacion de la tarea");
		t.setFechaApertura(Calendar.getInstance());
		t.setFechaComprometida(Calendar.getInstance());
		t.setTipo(tipo);
		t.agregarTiene(tiene);		
		
		if (mt.altaTarea(t,tipo,tiene))
			System.out.println("TAREA DADA DE ALTA");
		else
			System.out.println("ERROR AL DAR DE ALTA LA TAREA");
		
		ManagerUsuario mu= new ManagerUsuario();
		Usuario u = new Usuario();
		u.setCedula(40434685);
		u.setNombre("Javier");
		u.setApellido("Maly");
		u.setUsuario("usu");
		u.setPwd("pwd");
		u.setDireccion("Paysandu 1242 / 203");
		u.setCelular("099722146");
		mu.altaUsuario(u);
		
		
		Grupo grupo= new Grupo();
		grupo.setDescripcion("Grupo 1");
		mt.altaGrupo(grupo);
		
		t2.setEsExterna(true);	
		t2.setDescripcion("Soporte tecnico a la Empresa X: revisar maquina en garantía");
		t2.setObservacion("Observacion de la tarea");
		t2.setFechaApertura(Calendar.getInstance());
		t2.setFechaComprometida(Calendar.getInstance());
		t2.setTipo(tipo);
		
		//asigno tarea a grupo
		Grupo gr=mt.encontrarGrupo(1);
		mt.asignarTareaGrupo(t, gr);
		mt.asignarTareaGrupo(t2, gr);
		
		//asigno tarea a usuario
		mt.asignaTareaUsuario(t, u, Calendar.getInstance());
		
		
		//cambiar de estado una tarea
		//1ro encontrar el tiene de esta tarea
		tiene = mt.encontrarTiene(t);
		tiene.setFechaFin(Calendar.getInstance());//poner fecha de fin al último tiene de esta tarea
		mt.actualizarTiene(tiene);
		Tiene tiene2 = new Tiene();
		tiene2.setEstado(mt.encontrarEstado(2));//pone el nuevo estado de esta tarea en tiene
		tiene2.setFechaInicio(Calendar.getInstance());
		tiene2.setTarea(t);
		mt.actualizarTiene(tiene2);
	}

}
