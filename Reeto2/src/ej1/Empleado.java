package ej1;

public class Empleado {
	private int nre; 
    private String nombre;
    private String estado; //para saber si está activo o jubilado
	
    public Empleado(int nre, String nombre, String estado) {
		super();
		this.nre = nre;
		this.nombre = nombre;
		this.estado = estado;
	}

	public Empleado() {
	}

	public int getNre() {
		return nre;
	}

	public void setNre(int nre) {
		this.nre = nre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

}
