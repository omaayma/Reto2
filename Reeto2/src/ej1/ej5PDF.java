package ej1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class ej5PDF {

    // Función que solo configura atributos, colecciones y alias(sin conversores ya que el enunciado da a elegir entre alias y/o conversores)
    public static XStream configurarXStream(boolean estaBien) {
        XStream xstream = new XStream(new DomDriver("UTF-8"));

        xstream.useAttributeFor(Empresa.class, "cif");

        xstream.useAttributeFor(Empleado.class, "nre"); 

        // Ocultamos la etiqueta de lista 'plantilla' y los empleados irán dentro de empresa
        xstream.addImplicitCollection(Empresa.class, "empleados");

        // El alias correcto es 'empleado'. Usamos 'trabajador' para la prueba de fallo
        xstream.alias(estaBien? "empleado" : "trabajador", Empleado.class); 
        xstream.alias("empresa", Empresa.class);
        
        return xstream;
    }


    public static void main(String[] args) {

        Producto p = new Producto("Banana", 23.0);
        Empleado juan = new Empleado(12, "Juan", "Jubilado");
        
        Empresa em = new Empresa("456", p, "IES");
        em.addEmpleado(juan);


        System.out.println("Se ha podido generar y recuperar");
        XStream xstreamCorrecto = configurarXStream(true);

        // GENERAR XML (SERIALIZAR)
        String xml = xstreamCorrecto.toXML(em);
        System.out.println("\nXML Generado");
        System.out.println(xml);
        
        // RECUPERAR OBJETO (DESERIALIZAR)
        try {
            Empresa empresaRecuperada = (Empresa) xstreamCorrecto.fromXML(xml);
            System.out.println("\n Objeto recuperado");
            
        } catch (Exception e) {
            System.err.println("ERROR: " + e.getMessage());
        }

        System.out.println("\nProbar fallo alias");
        
        //tiene el alias 'trabajador', pero el XML usa 'empleado'.
        XStream xstreamIncorrecto = configurarXStream(false); 

        try {
            System.out.println("Intentando deserializar el XML");
            xstreamIncorrecto.fromXML(xml); 
            System.out.println("La deserialización debería haber fallado");
        } catch (Exception e) {
            System.out.println("\nLa regeneración falló");
            System.out.println("Razón del fallo: " + e.getMessage());
            System.out.println("Falló porque la configuración no reconoce el alias '<empleado>' del XML.");
        }
    }
}