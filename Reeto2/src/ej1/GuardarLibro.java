package ej1;

import com.thoughtworks.xstream.io.xml.DomDriver;

import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;

public class GuardarLibro {
	public static void main(String[] args) {
        // Creamos un objeto Libro
        Libro l1 = new Libro("Cien años de soledad", "Gabriel García", 1967, 13.99);

        // Instanciamos XStream con driver XML
        XStream xstream = new XStream(new DomDriver());

        // Convertimos el objeto a XML
        String xml = xstream.toXML(l1);

        System.out.println("XML:");
        System.out.println(xml);

        // Guardamos el XML en "archivo.xml"
        try (FileWriter writer = new FileWriter("archivo.xml")) {
            writer.write(xml);
            System.out.println("XML guardado");
        } catch (IOException e) {
            System.out.println("Error al guardar el XML");
            e.printStackTrace();
        }
    }
}


