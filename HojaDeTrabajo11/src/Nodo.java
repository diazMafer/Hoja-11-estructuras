
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mafer
 */
public class Nodo {
    public ArrayList<Ciudad> ciudades;
    
    public Nodo()
    {
        
    }
    
    public void addCiudad(Ciudad newcity)
    {
        ciudades.add(newcity);
    }
    public ArrayList<Ciudad> getCiudades()
    {
        return ciudades;
    }
    
}
