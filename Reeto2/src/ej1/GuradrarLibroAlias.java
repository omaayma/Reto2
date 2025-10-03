package ej1;

import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class GuradrarLibroAlias {
	public static void main(String[] args) {
		// Creamos un objeto de la clase Libro
        Libro l1 = new Libro("Cien años de soledad", "Gabriel García", 1967, 13.99);
        
        //Instancia de XStream
	    XStream xstream = new XStream(new DomDriver());
	    
	    // alias para la clase
	    xstream.alias("libro", Libro.class);

	    // alias para los atributos
	    xstream.aliasField("año", Libro.class, "ano");

	    // Convertimos el objeto a XML
	    String xml = xstream.toXML(l1);

	    System.out.println("XML con alias:");
	    System.out.println(xml);

	    // Guardamos el XML en un archivo
	    try (FileWriter w = new FileWriter("archivoAlias.xml")) {
	    	w.write(xml);
	        System.out.println("XML guardado");
	        } catch (IOException e) {
	        	e.printStackTrace();
	        }
	}
}

