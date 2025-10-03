package ej1;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.PrettyPrintWriter;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Scanner;

public class GuardarAula {
	
	public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nombre del aula: ");
        Aula aula = new Aula(sc.nextLine());

        System.out.print("Número de alumnos:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("Alumno " + (i+1));
            System.out.print("Nombre: "); String nom = sc.nextLine();
            System.out.print("Apellidos: "); String ape = sc.nextLine();
            System.out.print("Fecha nacimiento (dd/MM/yyyy): "); String fecha = sc.nextLine();
            System.out.print("Calle: "); String calle = sc.nextLine();
            System.out.print("Número: "); int num = Integer.parseInt(sc.nextLine());
            aula.addAlumno(new Alumno(nom, ape, fecha, calle, num));
        }

        sc.close();

        XStream xstream = new XStream(new StaxDriver());
        xstream.allowTypesByWildcard(new String[] {"ejercicios.*"});

        xstream.alias("aula", Aula.class);
        xstream.alias("alumno", Alumno.class);

        StringWriter sw = new StringWriter();
        xstream.marshal(aula, new PrettyPrintWriter(sw));
        System.out.println("\nXML generado:\n" + sw.toString());

        try (FileOutputStream fos = new FileOutputStream("Aula.xml")) {
            xstream.toXML(aula, fos);
        }

        System.out.println("");
    }
}

