package ej1;

import java.util.Date;

public class Libro_1_4 {
	public String titulo;
    public String autor;
    public int paginas;
    public Date fechaPublicacion;
    public String isbn; // campo que omitiremos en XML


    public Libro_1_4(String titulo, String autor, int paginas, Date fechaPublicacion, String isbn) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.paginas = paginas;
		this.fechaPublicacion = fechaPublicacion;
		this.isbn = isbn;
	}
    public Libro_1_4() {}//para XStream
    


	public String getResumen() {
        return titulo + " de " + autor + ", " + paginas + " páginas";
    }
}

