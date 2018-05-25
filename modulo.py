# -*- coding: cp1252 -*-
'''
    Universidad del Valle de Guatemala
    Algoritmos y estructura de datos
    Hoja de trabajo 11 - implementacion de algoritmo de Floyd y centro de grafo
    Version: 24/05/2018
    Ana Lucia Hernandez - 17138
    Maria Fernanda Lopez - 17160
'''


import networkx as nx


Grafo = nx.DiGraph()

archivo = open("ciudades.txt", "r")
contenido = archivo.readlines()
archivo.close()

for lineas in contenido:
    string = lineas.split(", ")
    Grafo.add_node(string[0])
    Grafo.add_node(string[1])
    Grafo.add_edge(string[0],string[1],weight=float(string[2]))  #se le agrega un peso el cual sera los kilometros de cada uno 



path = nx.floyd_warshall_predecessor_and_distance(Grafo) #se obtiene la ruta con el algoritmo de floyd
Nodos = Grafo.nodes()


def ruta():
    print "Los ciudades son: "+"/".join(Nodos)
    
    ciudadO = raw_input("Ingrese la ciudad de la cual desea partir: ")
    while ciudadO not in Grafo.nodes():
        print "La ciudad que ingreso no se encuentra en la base de datos"
        ciudadO = raw_input("Ingrese la ciudad de la cual desea partir: ")

    ciudadF = raw_input("Indique la ciudad de destino: ")

    while ciudadF not in Grafo.nodes():
        print "La ciudad que ingreso no se encuentra en la base de datos"
        ciudadF = raw_input("Indique la ciudad de destino: ")

    print "La ruta mas corta entre ", ciudadO, " y ", ciudadF, " es pasando por: "

    predecesor = path[0][ciudadO][ciudadF]
    print predecesor
        
    print "La distancia en kilometros es: "
    print path[1][ciudadO][ciudadF]

    bloqueos = input("¿Hay bloqueos en su ruta?\n1.Si\n2.No")

    if (bloqueos==1):
        print "Escriba desde donde comienza el bloqueo y hasta donde termina (nombre1, nombre2"
        Edge = raw_input(Grafo.edges)
        Noditos = Edge.split(", ")
        if Noditos[0] or Noditos[1] not in Grafo.nodes():
            alerta = 1
        while alerta!=1:
            print "Las ciudades no existen porfavor vuelva a ingresar en el formato correcto"
            Edge = raw_input(Grafo.edges)
            Noditos = Edge.split(", ")

        Grafo.remove_edge(Noditos[0],Noditos[1])
        newpath = nx.floyd_warshall_predecessor_and_distance(Grafo, wight="peso")
        print "El nuevo recorrido a tomar es: "
        print newpath

        print "Ruta en kilometros: "
        print newpath[1][ciudadO][ciudadF]
                                



def centro():
        #yo se que tiene que ser con dirección pero no funciona porque dice que no esta lo suficientemente conectado
    Grafo = nx.Graph()

    archivo = open("ciudades.txt", "r")
    contenido = archivo.readlines()
    archivo.close()

    for lineas in contenido:
        string = lineas.split(", ")
        Grafo.add_node(string[0])
        Grafo.add_node(string[1])
        Grafo.add_edge(string[0],string[1],weight=int(string[2]))  #se le agrega un peso el cual sera los kilometros de cada uno 



    path = nx.floyd_warshall_predecessor_and_distance(Grafo) #se obtiene la ruta con el algoritmo de floyd
    Nodos = Grafo.nodes()
    #centro del grafo
    centro = nx.center(Grafo, None, False)
    print "Centro del grafo: ", centro


    
