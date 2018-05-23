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
    
    public String ciudadActual;
    public String ciudadInicio;
    public double kilometros;
    public int IDActual;
    public int IDInicio;
    
    public Ciudad(String actual, String ciudadFrom, double km, int ID1, int ID2)
    {
        ciudadActual = actual;
        ciudadInicio = ciudadFrom;
        kilometros = km;
        this.IDActual = ID1;
        this.IDInicio = ID2;
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
    public int getIDInicio()
    {
        return IDInicio;
    }
    public int getIDActual()
    {
        return IDActual;
    }
    
}
