package ej1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileInputStream;

public class RecuperarAula {
    public static void main(String[] args) throws Exception {
        XStream xstream = new XStream(new StaxDriver());

        // Permitir deserialización de las clases de nuestro paquete
        xstream.allowTypesByWildcard(new String[] {"ejercicios.*"});

        // Alias de clase y campos
        xstream.alias("aula", Aula.class);
        xstream.alias("alumno", Alumno.class);

        // Leer desde fichero
        Aula aula;
        try (FileInputStream fis = new FileInputStream("Aula.xml")) {
            aula = (Aula) xstream.fromXML(fis);
        }

        // Mostrar los datos
        System.out.println("Aula: " + aula.nombreAula);
        System.out.println("Alumnos:");
        for (Alumno a : aula.alumnos) {
            System.out.println("- " + a.getResumen());
        }
    }
}
