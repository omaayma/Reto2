package ej2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class PruebaXStreamJSON {
	
    public static void main(String[] args) {
    	
    	/**
    	 * Creamos un GsonBuilder y luego creamos el objeto gsoncon create.
    	 */
    	
    	
        GsonBuilder gb = new GsonBuilder();
        Gson gson=gb.create();
        
        /**
         * He querido guardar y leer varios libros a la vez, 
         * por lo que he creado una  lista de objetos Libro.
         */
        
        List<Libro>lista = new ArrayList<Libro>();
        
        Libro libro1 = new Libro("El Quijote", "Miguel de Cervantes", 19.95, 863);
        Libro libro2 = new Libro("Cien Años de Soledad", "Gabriel García Márquez", 25.50, 417);
        Libro libro3 = new Libro("1984", "George Orwell", 15.75, 328);
        
        lista.add(libro1);
        lista.add(libro2);
        lista.add(libro3);
        
        /**
         * En este bloque escribimos los objetos en un fichero json
         * y le paso la lista entera que hemos creado.
         */

        try{
        	FileWriter fw = new FileWriter("libro.json");
            gson.toJson(lista, fw);
            fw.flush();
            fw.close();            
        } catch (IOException e) {
            e.printStackTrace();
        }

        /**
         * Aquí leemos el fichero Json, he tenido que buscar cómo podía leer la lista entera.
         * El TypeToken sólo es necesario para tipos genéricos como en este caso "List".
         * Para sólo un objeto simple como Libro es más fácil: 
         * Libro libro = gson.fromJson(fr, Libro.class);
         * Por último se imprime por pantalla cada objeto.
         */
        
        try {
        	FileReader fr = new FileReader("libro.json"); 
            List<Libro> libros = gson.fromJson(fr, new TypeToken<List<Libro>>(){}.getType());
            for (Libro l:libros){
            	System.out.println(l);
            }
            
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

