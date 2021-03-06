
import java.util.ArrayList;


/**
 *
 * @author anahernandez
 * 
 * Algoritmo modelado con: http://aprendiendo2veces.blogspot.com/2011/08/algoritmo-de-floyd.html
 * y también https://rosettacode.org/wiki/Floyd-Warshall_algorithm#Java
 * 
 */
public class Floyd {

    private int cantNodos;
    private ArrayList<Ciudad> listaCiudades;
    private double[][] ponderaciones; //matriz que muestra los menores kilometros para llegar de una ciudad a otra
    private String[][] recorridos; //matriz que muestra los nombres de las ciudades por las cuales se pasa para llegar de una a otra
    
    public Floyd(int cantNodos, ArrayList<Ciudad> lista)
    {
        this.cantNodos = cantNodos;
        listaCiudades = lista;
        makeMatrixes(cantNodos);
        
    }
    
    public void addCiudad(ArrayList<Ciudad> ciudades)
    {
        listaCiudades = ciudades;
        cantNodos ++;
        makeMatrixes(cantNodos);
    }
    public void deleteRoute(String ciudadInicio, String ciudadFinal)
    {
        for (Ciudad ciudad : listaCiudades)
        {
            for (String destino : ciudad.getDestinos())
            {
                if (ciudad.getNombre().equals(ciudadInicio) && destino.equals(ciudadFinal))
                {
                    int index = ciudad.getDestinos().indexOf(destino);
                    ciudad.setKm(index);
                }
            }
        }
        makeMatrixes(cantNodos);
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
                if (ciudadFinal.equals(listaCiudades.get(j).getNombre()) && ciudadInicio.equals(listaCiudades.get(i).getNombre()))
                {
                    distanciaMinima = ponderaciones[i][j];
                }
            }
        }
        return distanciaMinima;
    }
    public final void makeMatrixes(int cantNodos)
    {
        this.ponderaciones = new double[cantNodos][cantNodos];
        this.recorridos = new String[cantNodos][cantNodos];
        
        //al inicio se crean todas las casillas con infinito, asi las ciudades que no tengan conexion entre si quedaran con este valor en la matriz
        for (int i =0;i<cantNodos; i++)
        {
            for (int j =0;j<cantNodos; j++)
            {
                if (i == j)
                {
                    ponderaciones[i][j] = 0;
                }
                else
                {
                    ponderaciones[i][j] = Double.POSITIVE_INFINITY;
                }
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
                        for (String destino: city.getDestinos())
                        {
                            int indexof = listaCiudades.get(i).getDestinos().indexOf(destino);
                            if (indexof != -1)
                            {
                                if (destino.equals(listaCiudades.get(j).getNombre()) && city.getNombre().equals(listaCiudades.get(i).getNombre()))
                                {
                                    ponderaciones[i][j] = city.getKm().get(indexof);
                                }
                            }
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
                recorridos[i][j] = listaCiudades.get(j).getNombre();
            }
        }
        playFloyd();
    }
    public final void playFloyd()
    {
        for (int k = 0; k < ponderaciones.length; k++)
        {
            for (int i = 0; i < ponderaciones.length; i++)
            {
                for (int j = 0; j < ponderaciones.length; j++)
                {
                    if ((ponderaciones[i][k] != Double.POSITIVE_INFINITY)&&(ponderaciones[k][j] != Double.POSITIVE_INFINITY)&&(Math.min(ponderaciones[i][j], ponderaciones[i][k] + ponderaciones[k][j]) != ponderaciones[i][j]))
                    {
                        ponderaciones[i][j] = ponderaciones[i][k] + ponderaciones[k][j];
                        recorridos[i][j] = recorridos[i][k];
                    }
                }
            }
        }
    }
    public boolean checkDirections(String ciudadInicio, String ciudadDestino)
    {
        boolean hayCamino = true;
        for (int i=0; i<cantNodos; i++)
        {
            for (int j=0; j<cantNodos; j++)
            {
                if (ciudadDestino.equals(listaCiudades.get(j).getNombre()) && ciudadInicio.equals(listaCiudades.get(i).getNombre()))
                {
                    if (ponderaciones[i][j] == Double.POSITIVE_INFINITY)
                    {
                        hayCamino = false;
                    }
                }
            }
        }
        return hayCamino;
    }
    public ArrayList<String> getPath(String ciudadInicio, String ciudadDestino)
    {
        ArrayList<String> stops = new ArrayList<>();
        Ciudad ciudad = null;
        Ciudad ciudadFinal = null;
        for (Ciudad city: listaCiudades)
        {
            if (city.getNombre().equals(ciudadDestino))
            {
                ciudadFinal = city;
            }
            else if (city.getNombre().equals(ciudadInicio))
            {
                ciudad = city;
            }
        }
        int i = listaCiudades.indexOf(ciudad);
        int contador =0;
        boolean loop = true; 
        for (int j = listaCiudades.indexOf(ciudadFinal); j>0; j--)
        {
            if (!recorridos[i][j].equals(ciudadDestino))
            {
                stops.add(recorridos[i][j]);
                ciudadDestino = recorridos[i][j];
                j = searchList(ciudadDestino);
                if (stops.size() > 5)
                {
                    break;
                }
            }   
            else
            {
                break;
            }
        }
        return stops;
    }    
    public int searchList(String nombreCiudad)
    {
        Ciudad ciudad = null;
        int indexof =0;
        for (Ciudad city: listaCiudades)
        {
            if (city.getNombre().equals(nombreCiudad))
            {
                ciudad = city;
            }
        }
        indexof = listaCiudades.indexOf(ciudad);
        return indexof;
    }
    
   
    
}
