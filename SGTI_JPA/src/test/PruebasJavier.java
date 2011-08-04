package test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

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
		
		Tiene tiene = new Tiene();		
		tiene.setEstado(mt.encontrarEstado(1));
		tiene.setFechaInicio(Calendar.getInstance());
		
		Tipo tipo= new Tipo();
		tipo.setDescripcion("TIPO DE TAREA");
		t.setEsExterna(true);	
		t.setDescripcion("Soporte tecnico a la Empresa X: revisar maquina en garantía");
		t.setObservacion("Observacion de la tarea");
		t.setFechaApertura(Calendar.getInstance());
		t.setFechaComprometida(Calendar.getInstance());
		t.setTipo(tipo);
		List<Tiene> colTiene = new ArrayList<Tiene>();
		colTiene.add(tiene);
		t.setColTiene(colTiene);
		
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
		//asigno tarea a grupo
		Grupo gr=mt.encontrarGrupo(1);
		mt.asignarTareaGrupo(t, gr);
		
		//asigno tarea a usuario
		mt.asignaTareaUsuario(t, u, Calendar.getInstance());
	}

}
