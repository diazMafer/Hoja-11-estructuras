
import java.util.ArrayList;


/**
 *
 * @author anahernandez
 * 
 * Algoritmo modelado con: http://aprendiendo2veces.blogspot.com/2011/08/algoritmo-de-floyd.html
 * 
 */
public class Floyd {

    public int cantNodos;
    public ArrayList<Ciudad> listaCiudades;
    public double[][] ponderaciones; //matriz que muestra los menores kilometros para llegar de una ciudad a otra
    public String[][] recorridos; //matriz que muestra los nombres de las ciudades por las cuales se pasa para llegar de una a otra
    
    public Floyd(int cantNodos)
    {
        this.cantNodos = cantNodos;
        listaCiudades = new ArrayList<>();
        createLinks(cantNodos);
        makeMatrix();
        
    }
    /**
    public void addNodo(Ciudad city)
    {
        matriz[city.getIDInicio()][city.getIDActual()].addCiudad(city);
    }**/
    
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
    public final void createLinks(int cantNodos)
    {
        this.ponderaciones = new double[cantNodos][cantNodos];
        this.recorridos = new String[cantNodos][cantNodos];
        
        //al inicio se crean todas las casillas con infinito, asi las ciudades que no tengan conexion entre si quedaran con este valor en la matriz
        for (int i =0;i<cantNodos; i++)
        {
            for (int j =0;j<cantNodos; j++)
            {
                ponderaciones[i][j] = Integer.MAX_VALUE;
            }
        }
        
        //realiza la matriz de ponderaciones
        for (int i = 0; i<cantNodos; i++)
        {
            for (int j = 0; j<cantNodos; j++)
            {
                if (i == j)
                {
                    ponderaciones[i][j] = 0;
                }
                else
                {
                    for (Ciudad city: listaCiudades)
                    {
                        if (city.getActual().equals(listaCiudades.get(j).getActual()) && city.getInicio().equals(listaCiudades.get(i).getInicio()))
                        {
                            ponderaciones[i][j] = city.getKm();
                        }
                    }
                }
            }
        }
        //para llenar la matriz de recorridos
        for (int i = 0; i<cantNodos; i++)
        {
            for (int j = 0; j<cantNodos; j++)
            {
                recorridos[i][j] = listaCiudades.get(j).getActual();
            }
        }
    }
    public final void makeMatrix()
    {
        double[][] resultado = new double[ponderaciones.length][ponderaciones.length];
        for (int k = 0; k < ponderaciones.length; k++)
        {
            for (int i = 0; i < ponderaciones.length; i++)
            {
                for (int j = 0; j < ponderaciones.length; j++)
                {
                    if ((ponderaciones[i][k] != Integer.MAX_VALUE)&&(ponderaciones[k][j] != Integer.MAX_VALUE)&&(Math.min(ponderaciones[i][j], ponderaciones[i][k] + ponderaciones[k][j]) != ponderaciones[i][j]))
                    {
                        ponderaciones[i][j] = ponderaciones[i][k] + ponderaciones[k][j];
                        resultado[i][j] = resultado[i][k];
                    }
                }
            }
        }
        ponderaciones = resultado;
    }
    
}
