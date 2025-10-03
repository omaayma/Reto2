package ej3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ej1.Libro_1_4;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LeerLibroConDom {
    public static void main(String[] args) throws Exception {
        File xmlFile = new File("LibroAlias.xml");

        // Crear parser DOM
        DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = df.newDocumentBuilder();

        // Cargar el documento XML
        Document d = db.parse(xmlFile);
        d.getDocumentElement().normalize();

        // Accedemos al nodo <libro>
        Element lib = (Element) d.getElementsByTagName("libro").item(0);

        // Usamos los nombres del XML
        String titulo = lib.getElementsByTagName("titulo__libro").item(0).getTextContent();
        String autor = lib.getElementsByTagName("autor__libro").item(0).getTextContent();
        int paginas = Integer.parseInt(lib.getElementsByTagName("paginas__libro").item(0).getTextContent());
        String fechaStr = lib.getElementsByTagName("fecha__publicacion").item(0).getTextContent();

        // Convertimos la fecha desde el formato que guarda XStream
        Date fecha;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S z");
            fecha = sdf.parse(fechaStr);
        } catch (Exception e) {
            fecha = new Date(); 
        }

        // Crear objeto Libro
        Libro_1_4 libro = new Libro_1_4(titulo, autor, paginas, fecha, "ISBN_omitido");

        SimpleDateFormat sdfOut = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("Libro leído con DOM:");
        System.out.println(libro.getResumen());
        System.out.println("Fecha de publicación: " + sdfOut.format(libro.fechaPublicacion));
    }
}

