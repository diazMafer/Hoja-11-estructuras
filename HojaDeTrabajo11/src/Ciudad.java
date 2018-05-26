
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author anahernandez
 */
public class Ciudad {
    
    private String NombreCiudad;
    private ArrayList<String> destinos;
    private ArrayList<Double> kilometros;
    
    public Ciudad(String actual, ArrayList<String> destinos, ArrayList<Double> km)
    {
        NombreCiudad = actual;
        this.destinos = destinos;
        kilometros = km;
    }
    public ArrayList<Double> getKm()
    {
        return kilometros;
    }
    public ArrayList<String> getDestinos()
    {
        return destinos;
    }
    public String getNombre()
    {
        return NombreCiudad;
    }
    @Override
    public String toString()
    {
        return NombreCiudad;
    }
    public void setKm(int index)
    {
        kilometros.set(index, Double.POSITIVE_INFINITY);
    }   
}