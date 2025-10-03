package ej1;

import java.util.ArrayList;
import java.util.List;

public class Aula {
	 public String nombreAula;
	    public List<Alumno> alumnos = new ArrayList<>();

	    public Aula() {}

	    public Aula(String nombreAula) {
	        this.nombreAula = nombreAula;
	    }

	    public void addAlumno(Alumno a) {
	        alumnos.add(a);
	    }
	
}
