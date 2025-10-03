package ej3;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import ej1.Libro_1_4;

import java.io.File;
import java.text.SimpleDateFormat;

public class CrearLibroConDom {
    public static void main(String[] args) throws Exception {
    	
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Libro_1_4 libro = new Libro_1_4("Don Quijote", "Cervantes", 863, sdf.parse("16/01/1605"), "1234567890");

        // Creamos DocumentBuilder para generar XML
        DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = df.newDocumentBuilder();
        Document doc = db.newDocument();

        // Creamos elemento raíz <libro>
        Element root = doc.createElement("libro");
        doc.appendChild(root);

        // Crear hijos usando los alias de XStream
        Element titulo = doc.createElement("titulo_libro");
        titulo.appendChild(doc.createTextNode(libro.titulo));
        root.appendChild(titulo);

        Element autor = doc.createElement("autor_libro");
        autor.appendChild(doc.createTextNode(libro.autor));
        root.appendChild(autor);

        Element paginas = doc.createElement("paginas_libro");
        paginas.appendChild(doc.createTextNode(String.valueOf(libro.paginas)));
        root.appendChild(paginas);

        Element fecha = doc.createElement("fecha_publicacion");
        fecha.appendChild(doc.createTextNode(sdf.format(libro.fechaPublicacion)));
        root.appendChild(fecha);

        // Guardamos XML en fichero compatible con RecuperarLibro_1_4
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("LibroDOM.xml"));
        transformer.transform(source, result);

        System.out.println("Archivo LibroDOM.xml creado correctamente con DOM.");
    }
}
