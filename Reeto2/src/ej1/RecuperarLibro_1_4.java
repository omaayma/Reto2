package ej1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;

public class RecuperarLibro_1_4 {
    public static void main(String[] args) throws Exception {
    	
        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypes(new Class[] { Libro_1_4.class });//para permisos de instanciar la clase


        xstream.alias("libro", Libro_1_4.class);
        xstream.aliasField("titulo_libro", Libro_1_4.class, "titulo");
        xstream.aliasField("autor_libro", Libro_1_4.class, "autor");
        xstream.aliasField("paginas_libro", Libro_1_4.class, "paginas");
        xstream.aliasField("fecha_publicacion", Libro_1_4.class, "fechaPublicacion");

        // Omitir ISBN en XML
        xstream.omitField(Libro_1_4.class, "isbn");

        // Leer desde fichero
        Libro_1_4 libro;
        try (FileInputStream fis = new FileInputStream("LibroAlias.xml")) {
            libro = (Libro_1_4) xstream.fromXML(fis);
        }

        // Mostrar resumen y fecha formateada
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Libro recuperado:");
        System.out.println(libro.getResumen());
        System.out.println("Fecha de publicación: " + sdf.format(libro.fechaPublicacion));
    }
}
