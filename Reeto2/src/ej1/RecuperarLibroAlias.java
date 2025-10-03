package ej1;

import java.io.FileReader;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class RecuperarLibroAlias {
	public static void main(String[] args) {
        XStream xstream = new XStream(new DomDriver());

        //Para deserializar la clase
        xstream.allowTypes(new Class[] { Libro.class });

        //Usamos el mismo alias que al generar el XML
        xstream.alias("libro", Libro.class);
        xstream.aliasField("año", Libro.class, "ano");

        // Leemos el XML y reconstruimos el objeto
        try (FileReader reader = new FileReader("archivoAlias.xml")) {
            Libro libro = (Libro) xstream.fromXML(reader);

            System.out.println("Libro con alias:");
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Autor: " + libro.getAutor());
            System.out.println("Año: " + libro.getAno());
            System.out.println("Precio: " + libro.getPrecio());
        } catch (Exception e) {
            System.out.println("Error al recuperar libro:");
            e.printStackTrace();
        }
    }
}

