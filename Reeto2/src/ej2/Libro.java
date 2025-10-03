package ej2;

public class Libro { 
	
	/**
	 * Creamos una clase Libro con sus atributos, getters y setters y dos constructores. 
	 * Al que le pasaremos los parámetros al crear un objeto y el de por defecto que está vacío.
	 */
	    private String titulo;
	    private String autor;
	    private double precio;
	    private int paginas;
	    
	    public Libro() {}

	    public Libro(String titulo, String autor, double precio, int paginas) {
	        this.titulo = titulo;
	        this.autor = autor;
	        this.precio = precio;
	        this.paginas = paginas;
	    }

	    public String getTitulo() { 
	    	return titulo; 
	    	}
	    public void setTitulo(String titulo) { 
	    	this.titulo = titulo; 
	    	}

	    public String getAutor() { 
	    	return autor; 
	    }
	    public void setAutor(String autor) { 
	    	this.autor = autor; 
	    	}

	    public double getPrecio() { 
	    	return precio; 
	    	}
	    public void setPrecio(double precio) { 
	    	this.precio = precio; 
	    	}

	    public int getPaginas() { 
	    	return paginas; 
	    	}
	    public void setPaginas(int paginas) { 
	    	this.paginas = paginas; 
	    	}

	    @Override
	    public String toString() {
	        return "Titulo= " + titulo +
	                ", autor= " + autor +
	                ", precio= " + precio +
	                ", paginas= " + paginas 
	                ;
	    }
	}
