package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import manager.ManagerTarea;
import manager.ManagerUsuario;
import beans.Encargado;
import beans.Estado;
import beans.Grupo;
import beans.Tarea;
import beans.Tiene;
import beans.Tipo;
import beans.Usuario;

public class PruebasJavier {
	
	public static void main(String[] args) {
	
//		ManagerTarea mt = new ManagerTarea();
//		Tarea t= new Tarea();		
//		
//		Estado estado = new Estado();
//		estado.setId(1);
//		estado.setDescripcion("Abierta");		
//		mt.agregarEstado(estado);
//		Estado estado2 = new Estado();
//		estado2.setId(2);
//		estado2.setDescripcion("Asignada");
//		mt.agregarEstado(estado2);
//		
//		Tiene tiene = new Tiene();		
//		tiene.setEstado(mt.encontrarEstado(1));
//		tiene.setFechaInicio(Calendar.getInstance());
//		//tiene.setFechaFin(Calendar.getInstance());
//		
//		Tipo tipo= new Tipo();
//		tipo.setDescripcion("BASE DE DATOS");
//		t.setEsExterna(true);	
//		t.setDescripcion("Soporte tecnico a la Empresa X: revisar maquina en garantía");
//		t.setObservacion("Observacion de la tarea");
//		t.setFechaApertura(Calendar.getInstance());
//		t.setFechaComprometida(Calendar.getInstance());
//		t.setTipo(tipo);
//		t.agregarTiene(tiene);
//		
////		List<Tiene> colTiene = new ArrayList<Tiene>();
////		colTiene.add(tiene);
////		t.setColTiene(colTiene);
//		
//		if (mt.altaTarea(t,tipo,tiene))
//			System.out.println("TAREA DADA DE ALTA");
//		else
//			System.out.println("ERROR AL DAR DE ALTA LA TAREA");
//		
//		ManagerUsuario mu= new ManagerUsuario();
//		Encargado u = new Encargado();
//		u.setCedula(11);
//		u.setNombre("Javier");
//		u.setApellido("Maly");
//		u.setUsuario("usu");
//		u.setPwd("pwd");
//		u.setDireccion("Paysandu 1242 / 203");
//		u.setCelular("099722146");
//		//no lo persisto porque ya lo tengo en la base
//		//mu.altaUsuario(u);
//		
//		//alta de un grupo
//		Grupo grupo= new Grupo();
//		grupo.setDescripcion("Grupo 1");
//		mt.altaGrupo(grupo);
//		
//		//asignar encargado a grupo
//		//grupo.setEnc(u);
//		
//		//asigno tarea a grupo
//		Grupo gr=mt.encontrarGrupo(1);
//		mt.asignarTareaGrupo(t, gr);
//		
//		//asigno tarea a usuario
//		mt.asignaTareaUsuario(t, u, Calendar.getInstance());
//		
//		//cambio estado a tarea
//		mt.cambiarEstadoTarea(t, mt.encontrarEstado(2));
	}

}
