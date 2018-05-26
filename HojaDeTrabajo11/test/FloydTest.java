/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mafer
 */
public class FloydTest {
    
    public FloydTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }


    /**
     * Test of getDistancia method, of class Floyd.
     */
    @Test
    public void testGetDistancia() {
        System.out.println("getDistancia");
        String ciudadInicio = "Guatemala";
        String ciudadFinal = "Solola";
        ArrayList<String> destinos = new ArrayList<>();
        ArrayList<Double> km = new ArrayList<>();
        km.add(33.3);
        km.add(52.3);
        km.add(32.3);
        destinos.add("Solola");
        destinos.add("Peten");
        Ciudad ciudad = new Ciudad("Guatemala", destinos, km);
        ArrayList<Ciudad> city = new ArrayList<>();
        city.add(ciudad);
        Floyd instance = new Floyd(3, city);
        double expResult = 33.3;
        double result = instance.getDistancia(ciudadInicio, ciudadFinal);
        assertEquals(expResult, result, 0.0);
       
    }


  
    /**
     * Test of checkDirections method, of class Floyd.
     */
    @Test
    public void testCheckDirections() {
        System.out.println("checkDirections");
        String ciudadInicio = "Guatemala";
        String ciudadDestino = "Solola";
         ArrayList<String> destinos = new ArrayList<>();
        ArrayList<Double> km = new ArrayList<>();
        km.add(33.3);
        km.add(52.3);
        km.add(32.3);
        destinos.add("Solola");
        destinos.add("Peten");
        Ciudad ciudad = new Ciudad("Guatemala", destinos, km);
        ArrayList<Ciudad> city = new ArrayList<>();
        city.add(ciudad);
        Floyd instance = new Floyd(3, city);
        boolean expResult = true;
        boolean result = instance.checkDirections(ciudadInicio, ciudadDestino);
        assertEquals(expResult, expResult);
        
    }

    /**
     * Test of getPath method, of class Floyd.
     */
    @Test
    public void testGetPath() {
        System.out.println("getPath");
        String ciudadInicio = "Guatemala";
        String ciudadDestino = "Solola";
         ArrayList<String> destinos = new ArrayList<>();
        ArrayList<Double> km = new ArrayList<>();
        km.add(33.3);
        km.add(52.3);
        km.add(32.3);
        destinos.add("Solola");
        destinos.add("Peten");
        Ciudad ciudad = new Ciudad("Guatemala", destinos, km);
        ArrayList<Ciudad> city = new ArrayList<>();
        city.add(ciudad);
        Floyd instance = new Floyd(3, city);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Solola");
        ArrayList<String> result = instance.getPath(ciudadInicio, ciudadDestino);
        assertEquals(expResult, expResult);
      
    }

    /**
     * Test of searchList method, of class Floyd.
     */
    @Test
    public void testSearchList() {
        System.out.println("searchList");
        String nombreCiudad = "Guatemala";
        ArrayList<String> destinos = new ArrayList<>();
        ArrayList<Double> km = new ArrayList<>();
        km.add(33.3);
        km.add(52.3);
        km.add(32.3);
        destinos.add("Solola");
        destinos.add("Peten");
        Ciudad ciudad = new Ciudad("Guatemala", destinos, km);
        ArrayList<Ciudad> city = new ArrayList<>();
        city.add(ciudad);
        Floyd instance = new Floyd(3, city);
        int expResult = 40;
        int result = instance.searchList("Guatemala");
        assertEquals(expResult, result);
    }
    
}
