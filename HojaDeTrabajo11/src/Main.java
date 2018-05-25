
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anahernandez
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("guategrafo.txt"));    
        StringBuilder sb = new StringBuilder();
        String line;
        ArrayList<Ciudad> documento = new ArrayList<>(); //todo lo que esta en el documento
        ArrayList<Ciudad> listaC = new ArrayList<>();
        ArrayList<String> ciudades = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        int ciclo =0;
        try
        {
            while ((line=br.readLine())!=null) 
            { //lectura del documento
                
                String ciudadInicio;
                String destino;
                double distancia;
                Ciudad ciudad;

                sb.append(line);
                sb.append(System.lineSeparator()); 

                int posNombre = line.indexOf(",");
                ciudadInicio = line.substring(0, posNombre).toUpperCase();
                String resto = line.substring(posNombre+2, line.length()).toUpperCase();
                int posEnf = resto.indexOf(",");
                destino = resto.substring(0, posEnf).toUpperCase();
                distancia = Double.parseDouble(resto.substring(posEnf+1, resto.length()));
                ArrayList<String> destinos = new ArrayList<>();
                destinos.add(destino);
                ArrayList<Double> distancias = new ArrayList<>();
                distancias.add(distancia);
                
                ciudad = new Ciudad (ciudadInicio, destinos, distancias);
                documento.add(ciudad);
                ciudades.add(ciudadInicio);
                ciudades.add(destino);
            } 
            /*********              PARA ASEGURARME QUE SOLO HAYA UNA INSTANCIA DE CADA CIUDAD             *******/
            int size = ciudades.size();
            ArrayList<String> ciudadesTemp = new ArrayList<>();
            for (String ciudad : ciudades) //que todos los elementos de una esten en la otra
            {//se hace porque no puedo eliminar de una lista mientras estoy iterándola
                ciudadesTemp.add(ciudad);
            }
            for (String ciudad : ciudades) //revisar si alguna ciudad se repite
            {
                if (Collections.frequency(ciudades, ciudad) > 1) //si se repite, dejar solo una instancia
                {
                    ciudadesTemp.removeAll(Collections.singleton(ciudad));
                    ciudadesTemp.add(ciudad);
                }
            }
            ciudades = ciudadesTemp; //regreso sustitucion
            for (String ciudad : ciudades)
            {
                ArrayList<String> destinos = new ArrayList<>();
                ArrayList<Double> distancias = new ArrayList<>();
                for (Ciudad delDocumento: documento)
                {
                    if (delDocumento.getNombre().equals(ciudad))
                    {
                        distancias.add(delDocumento.getKm().get(0));
                        destinos.add(delDocumento.getDestinos().get(0));
                    }
                }
                listaC.add(new Ciudad(ciudad, destinos, distancias)); //ahora se agregan a la lista final, que contiene cada ciudad con sus distintos destinos
                
            }
            
            Floyd algoritmo = new Floyd(listaC.size(), listaC);
            while (ciclo ==0)
            {
            
                String exit = "";
                System.out.println("\n ****************\nQué desea hacer? \n\t 1. Encontrar la ruta más corta entre dos ciudades. "
                        + "\n\t 2. Retirar al siguiente paciente de la lista. \n\t 3. Salir\n ********************");

                String entry = teclado.nextLine();
                switch (entry)
                {
                    case ("1"):
                        System.out.println("\nIngrese la ciudad de partida: ");
                        String inicio = teclado.nextLine();
                        System.out.println("\nIngrese la ciudad de destino: ");
                        String end = teclado.nextLine();
                        shortestPath(algoritmo, inicio, end);
                        break;
                    case ("2"):
                        
                        break;
                    case "3":
                        ciclo =1;
                        break;
                }
            }
            
        }
        
        finally{
            br.close();
        }
        
    }
    static public void shortestPath(Floyd algoritmo, String inicio, String end)
    {
            System.out.println("\n >>>>>>>\nRuta más corta: ");
            ArrayList<String> paradas = algoritmo.getPath(inicio, end);
            String hilo = inicio +" -> ";
            for (String stop: paradas)
            {
                hilo += stop + " -> ";
            }
            hilo +=" "+end;
            System.out.println(hilo);
            System.out.println("Con una distancia de: ");
            System.out.println(algoritmo.getDistancia(inicio, end) + "\n>>>>>>>");
    }
    
}
