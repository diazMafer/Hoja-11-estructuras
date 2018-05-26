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
        
def ruta():
    
    Grafo = nx.DiGraph()

    archivo = open("guategrafo.txt", "r")
    contenido = archivo.readlines()
    archivo.close()

    for lineas in contenido:
        string = lineas.split(", ")
        Grafo.add_node(string[0])
        Grafo.add_node(string[1])
        Grafo.add_edge(string[0],string[1],weight=float(string[2]))  #se le agrega un peso el cual sera los kilometros de cada uno 


    path = nx.floyd_warshall_predecessor_and_distance(Grafo) #se obtiene la ruta con el algoritmo de floyd
    Nodos = Grafo.nodes()
    
    print "Los ciudades son: "+"/".join(Nodos)
    
    ciudadO = raw_input("Ingrese la ciudad de la cual desea partir: ")
    while ciudadO not in Grafo.nodes():
        print "La ciudad que ingreso no se encuentra en la base de datos"
        ciudadO = raw_input("Ingrese la ciudad de la cual desea partir: ")

    ciudadF = raw_input("Indique la ciudad de destino: ")

    while ciudadF not in Grafo.nodes():
        print "La ciudad que ingreso no se encuentra en la base de datos"
        ciudadF = raw_input("Indique la ciudad de destino: ")

    

    try:
        predecesor1 = path[0][ciudadO][ciudadF]
        ciudades = []
        ciudades.append(predecesor1)
        #print predecesor1
        cont = 0
        if predecesor1!=ciudadO:
            while cont == 0:
                predecesor = path[0][ciudadO][predecesor1]
                ciudades.append(predecesor)
                predecesor1 = predecesor
                if predecesor1 == ciudadO:
                    cont = 1
                else:
                    predecesor1 = predecesor
                    #print predecesor1

        imprimir = []
        for i in reversed(ciudades):
            if ciudadO!=i:
                imprimir.append(i)
                
        print "La ruta mas corta entre ", ciudadO, " y ", ciudadF, " es pasando por: "
        print ciudadO, "---> "+"---> ".join(imprimir),"--->", ciudadF

        print "La distancia en kilometros es: "
        print path[1][ciudadO][ciudadF]

        bloqueos = input("¿Hay bloqueos en su ruta?\n1.Si\n2.No")
    
        if (bloqueos==1):
            print "Escriba desde donde comienza el bloqueo y hasta donde termina (nombre1, nombre2"
            Edge = raw_input()
            Noditos = Edge.split(", ")
            if Noditos[0] or Noditos[1] not in Grafo.nodes():
                alerta = 1
            while alerta!=1:
                print "Las ciudades no existen porfavor vuelva a ingresar en el formato correcto"
                Edge = raw_input(Grafo.edges)
                Noditos = Edge.split(", ")

            
            Grafo.remove_edge(Noditos[0],Noditos[1])
            newpath = nx.floyd_warshall_predecessor_and_distance(Grafo)
            predecesor1 = newpath[0][ciudadO][ciudadF]
            ciudades2 = []
            ciudades2.append(predecesor1)
            #print predecesor1
            cont = 0
            if predecesor1!=ciudadO:
                while cont == 0:
                    predecesor = newpath[0][ciudadO][predecesor1]
                    ciudades2.append(predecesor)
                    predecesor1 = predecesor
                    if predecesor1 == ciudadO:
                        cont = 1
                    else:
                        predecesor1 = predecesor
                        #print predecesor1

            imprimir2 = []
            for i in reversed(ciudades2):
                if ciudadO!=i:
                    imprimir2.append(i)

            print ciudadO, "---> "+"---> ".join(imprimir2),"--->", ciudadF
            print "Ruta en kilometros: "
            print newpath[1][ciudadO][ciudadF]
            
    except KeyError:
        print "No existen rutas entre esas ciudades"
    

                                
def agregar(ciudadA, ciudadB, km):
    archivo = open("guategrafo.txt", "a")
    archivo.write(ciudadA + ", " + ciudadB + ", " + str(km) + "\n")
    archivo.close()
    
    

def centro():
    #yo se que tiene que ser con dirección pero no funciona porque dice que no esta lo suficientemente conectado
    Grafo = nx.Graph()

    archivo = open("guategrafo.txt", "r")
    contenido = archivo.readlines()
    archivo.close()

    for lineas in contenido:
        string = lineas.split(", ")
        Grafo.add_node(string[0])
        Grafo.add_node(string[1])
        Grafo.add_edge(string[0],string[1],weight=float(string[2]))  #se le agrega un peso el cual sera los kilometros de cada uno 


    #centro del grafo
    centro = nx.center(Grafo, None, False)
    print "Centro del grafo: "+"/".join(centro)


    
