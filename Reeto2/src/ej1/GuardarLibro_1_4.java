package ej1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GuardarLibro_1_4 {
    public static void main(String[] args) throws Exception {
        Date fecha = new SimpleDateFormat("dd/MM/yyyy").parse("16/01/1605");
    	Libro_1_4 libro = new Libro_1_4("El Quijote", "Cervantes", 863, fecha, "1234567890");

        XStream xstream = new XStream(new StaxDriver());

        // Alias de clase y campos
        xstream.alias("libro", Libro_1_4.class);
        xstream.aliasField("titulo_libro", Libro_1_4.class, "titulo");
        xstream.aliasField("autor_libro", Libro_1_4.class, "autor");
        xstream.aliasField("paginas_libro", Libro_1_4.class, "paginas");
        xstream.aliasField("fecha_publicacion", Libro_1_4.class, "fechaPublicacion");

        // Omitir ISBN en XML
        xstream.omitField(Libro_1_4.class, "isbn");

        // Generar XML bonito
        StringWriter sw = new StringWriter();
        xstream.marshal(libro, new PrettyPrintWriter(sw));
        System.out.println("XML con alias y omitField:\n" + sw.toString());

        // Guardar en fichero
        try (FileOutputStream fos = new FileOutputStream("LibroAlias.xml")) {
            xstream.toXML(libro, fos);
        }
    }
}

	