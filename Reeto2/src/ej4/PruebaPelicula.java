package ej4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class PruebaPelicula {

    public static void main(String[] args) {
        Gson gson = new Gson();

        try{
        	BufferedReader br = new BufferedReader(new FileReader("pelis.json"));
        
            // Leer JSON directamente en lista de Pelicula
            List<Pelicula> peliculas = gson.fromJson(br, new TypeToken<List<Pelicula>>(){}.getType());

            // Imprimir por pantalla la lista
            for(Pelicula p : peliculas) {
            	System.out.println(p);
            }
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
