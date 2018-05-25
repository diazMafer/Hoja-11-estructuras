
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
        ArrayList<Ciudad> lista = new ArrayList<>();

        Scanner teclado = new Scanner(System.in);
        int ciclo =0;
        try
        {
            while ((line=br.readLine())!=null) { //lectura del documento
                String ciudadInicio;
                String ciudadDestino;
                double distancia;
                Ciudad ciudad;

                sb.append(line);
                sb.append(System.lineSeparator()); 

                int posNombre = line.indexOf(",");
                ciudadInicio = line.substring(0, posNombre).toUpperCase();
                String resto = line.substring(posNombre+1, line.length()).toUpperCase();
                int posEnf = resto.indexOf(",");
                ciudadDestino = resto.substring(0, posEnf).toUpperCase();
                distancia = Double.parseDouble(resto.substring(posEnf+1, resto.length()));
                ciudad = new Ciudad (ciudadDestino, ciudadInicio, distancia);
                lista.add(ciudad);
            }
            
            
        }
        finally{
            br.close();
        }
    }
    
}
