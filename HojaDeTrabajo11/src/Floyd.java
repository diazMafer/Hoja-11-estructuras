
import java.util.ArrayList;


/**
 *
 * @author anahernandez
 * 
 * Algoritmo modelado con: http://aprendiendo2veces.blogspot.com/2011/08/algoritmo-de-floyd.html
 * 
 */
public class Floyd {

    private int cantNodos;
    private ArrayList<Ciudad> listaCiudades;
    private double[][] ponderaciones; //matriz que muestra los menores kilometros para llegar de una ciudad a otra
    private String[][] recorridos; //matriz que muestra los nombres de las ciudades por las cuales se pasa para llegar de una a otra
    
    public Floyd(int cantNodos)
    {
        this.cantNodos = cantNodos;
        listaCiudades = new ArrayList<>();
        createLinks(cantNodos);
        
    }
    
    public void addCiudad(Ciudad city)
    {
        listaCiudades.add(city);
        createLinks(listaCiudades.size());
    }
    
    public void setNodos(int cantidad)
    {
        cantNodos = cantidad;
    }
    public double getDistancia(String ciudadInicio, String ciudadFinal)
    {
        double distanciaMinima = 0.0;
        for (int i=0; i<cantNodos; i++)
        {
            for (int j=0; j<cantNodos; j++)
            {
                if (ciudadFinal.equals(listaCiudades.get(j).getActual()) && ciudadInicio.equals(listaCiudades.get(i).getInicio()))
                {
                    distanciaMinima = ponderaciones[i][j];
                }
            }
        }
        return distanciaMinima;
    }
    public ArrayList<String> getRecorrido(String ciudadInicio, String ciudadFinal)
    {
        ArrayList<String> recorrido = new ArrayList<>();
        for (int i=0; i<cantNodos; i++)
        {
            for (int j=0; j<cantNodos; j++)
            {
                //?? i aint sure anymore
            }
        }
        return recorrido;
        
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
        
        makeMatrixes();
    }
    public final void makeMatrixes()
    {
        double[][] resultado = new double[ponderaciones.length][ponderaciones.length];
        String[][] recorridoFinal = new String[ponderaciones.length][ponderaciones.length];
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
                       // recorridoFinal[i][j] = recorridos[i][k];
                    }
                }
            }
        }
        recorridos = recorridoFinal;
        ponderaciones = resultado;
    }
    
}
