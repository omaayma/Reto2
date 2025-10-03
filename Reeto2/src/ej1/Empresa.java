package ej1;

import java.util.ArrayList; 
import java.util.List;

public class Empresa {
	private String cif;      
    private Producto producto; 
    private String nombre;
    private List<Empleado> empleados; // XStream usará esta lista
    
	public Empresa(String cif, Producto producto, String nombre) {
		super();
		this.cif = cif;
		this.producto = producto;
		this.nombre = nombre;
		this.empleados = new ArrayList<>(); 
	} 
	
	
  
	 public String getCif() {
		return cif;
	}



	public void setCif(String cif) {
		this.cif = cif;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}



	public void addEmpleado(Empleado empleado) {
	        this.empleados.add(empleado);
	    }
	
    public List<Empleado> getEmpleados() {
		return empleados;
	}
}
