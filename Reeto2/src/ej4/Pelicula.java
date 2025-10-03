package ej4;

public class Pelicula {
	
    private int id;
    private String titulo;
    private String genero;
    private String fechaEstreno;
    private int duracion;
    private Director director;

    public Pelicula(int id, String titulo, String genero, String fechaEstreno,
                    int duracion, String nombreDirector, Integer edadDirector) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.fechaEstreno = fechaEstreno;
        this.duracion = duracion;
        this.director = new Director(nombreDirector, edadDirector);
        
        
    }

	@Override
	public String toString() {
		return "Id=" + id + ", Titulo=" + titulo + ", Género=" + genero + ", Fecha de Estreno=" + fechaEstreno
				+ ", Duracion=" + duracion + ", Director=" + director;
	}

    
   
}

