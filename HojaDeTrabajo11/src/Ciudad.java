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
    
    private String ciudadActual;
    private String ciudadInicio;
    private double kilometros;
    private int IDActual;
    private int IDInicio;
    
    public Ciudad(String actual, String ciudadFrom, double km)
    {
        ciudadActual = actual;
        ciudadInicio = ciudadFrom;
        kilometros = km;
    }
    public double getKm()
    {
        return kilometros;
    }
    public String getInicio()
    {
        return ciudadInicio;
    }
    public String getActual()
    {
        return ciudadActual;
    }
    
}
