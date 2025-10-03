package ej1;

public class Alumno {
	public String nombre;
    public String apellidos;
    public String fechaNacimiento;
    public String calle;
    public int numero;

    public Alumno() {}

    public Alumno(String nombre, String apellidos, String fechaNacimiento, String calle, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.calle = calle;
        this.numero = numero;
    }

    public String getResumen() {
        return nombre + " " + apellidos + ", nacido: " + fechaNacimiento + ", domicilio: " + calle + " " + numero;
    }
	

}
