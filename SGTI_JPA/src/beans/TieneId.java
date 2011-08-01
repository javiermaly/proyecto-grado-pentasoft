package beans;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class TieneId implements Serializable{
	
	private Tarea tarea;
	private int estado;
	
	
}