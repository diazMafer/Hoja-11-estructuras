
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
public class MatrizAdyacencia {

    public int cantNodos;
    public Nodo[][] matriz;
    
    public MatrizAdyacencia(int cantNodos)
    {
        this.cantNodos = cantNodos;
        matriz = new Nodo[cantNodos][cantNodos];
        
    }
    public void addNodo(Ciudad city)
    {
        matriz[city.getIDInicio()][city.getIDActual()].addCiudad(city);
    }
    
    public void setNodos(int cantidad)
    {
        cantNodos = cantidad;
    }
    public void getNodo(String ciudadInicio, String ciudadFinal)
    {
        for (int i=0; i<cantNodos; i++)
        {
            /**
            for (int j=0; j<cantNodos; j++)
            {
                if (matriz[i][j].getCiudades())
            }**/
        }
    }
    
}
