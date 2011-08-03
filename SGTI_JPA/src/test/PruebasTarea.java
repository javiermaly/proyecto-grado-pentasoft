package test;

import java.util.Calendar;

import beans.Tarea;
import beans.Tipo;

import manager.ManagerTarea;

public class PruebasTarea {
	ManagerTarea mt = new ManagerTarea();
	
	public PruebasTarea(){
		
	}
	
	public void agregarTarea(){
		Tarea t= new Tarea();
		Tipo tipo= new Tipo();
		tipo.setDescripcion("TIPO DE TAREA");
		t.setEsExterna(true);	
		t.setDescripcion("Soporte tecnico a la Empresa X: revisar maquina en garantía");
		t.setObservacion("Observacion de la tarea");
		t.setFechaApertura(Calendar.getInstance());
		t.setFechaComprometida(Calendar.getInstance());
		t.setTipo(tipo);
	}
		

}
