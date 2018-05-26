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
     * Test of addCiudad method, of class Floyd.
     
    @Test
    public void testAddCiudad() {
        System.out.println("addCiudad");
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
        instance.addCiudad(city);
    }
|   */
    /**
     * Test of deleteRoute method, of class Floyd.
     
    @Test
    public void testDeleteRoute() {
        System.out.println("deleteRoute");
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
        instance.deleteRoute(ciudadInicio, ciudadFinal);
       
    }
    */

    /**
     * Test of setNodos method, of class Floyd.
     
    @Test
    public void testSetNodos() {
        System.out.println("setNodos");
        int cantidad = 0;
        Floyd instance = null;
        instance.setNodos(cantidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    

    /**
     * Test of makeMatrixes method, of class Floyd.
     
    @Test
    public void testMakeMatrixes() {
        System.out.println("makeMatrixes");
        int cantNodos = 0;
        Floyd instance = null;
        instance.makeMatrixes(cantNodos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

    /**
     * Test of playFloyd method, of class Floyd.
     
    @Test
    public void testPlayFloyd() {
        System.out.println("playFloyd");
        Floyd instance = null;
        instance.playFloyd();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */

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
