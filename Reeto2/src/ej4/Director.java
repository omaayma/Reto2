package ej4;

/**
 * He creado una clase Director 
 * para que me sirva de objeto anidado en la clase Película.
 */
public class Director {  
	
    private String nombre;
    private Integer edad;

    public Director(String nombre, Integer edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Director=" + nombre+", " + "Edad=" +  edad;
    }

}

