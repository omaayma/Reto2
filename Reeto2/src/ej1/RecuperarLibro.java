package ej1;

import java.io.FileReader;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class RecuperarLibro {
	public static void main(String[] args) {
		
        //Instancia de XStream
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(new Class[] { Libro.class });//para los permisos

        

        // Leemos el fichero "archivo.xml" y reconstruimos el objeto
        try (FileReader reader = new FileReader("archivo.xml")) {
            Libro l1 = (Libro) xstream.fromXML(reader);

            // Mostramos el objeto restaurado
            System.out.println("Libro restaurado desde XML:");
            System.out.println(l1);
        } catch (Exception e) {
            System.out.println("Error al leer el XML:");
            e.printStackTrace();
        }
    }

}
