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
    Grafo.add_edge(string[0],string[1],weight=int(string[2]))  #se le agrega un peso el cual sera los kilometros de cada uno 



path = nx.floyd_warshall_predecessor_and_distance(Grafo) #se obtiene la ruta con el algoritmo de floyd
Nodos = Grafo.nodes()

print "Los nodos son: "+"/".join(Nodos)



#Se pide el ingreso de datos para calcular las rutas entre A y B

ciudadO = raw_input("Ingrese la ciudad de la cual desea partir: ")


while ciudadO not in Grafo.nodes():
    print "La ciudad que ingreso no se encuentra en la base de datos"
    ciudadO = raw_input("Ingrese la ciudad de la cual desea partir: ")

ciudadF = raw_input("Indique la ciudad de destino: ")

while ciudadF not in Grafo.nodes():
    print "La ciudad que ingreso no se encuentra en la base de datos"
    ciudadF = raw_input("Indique la ciudad de destino: ")


cont = 0


print "La ruta mas corta entre ", ciudadO, " y ", ciudadF, " es pasando por: "

predecesor = path[0][ciudadO][ciudadF]

while cont:
    
    predecesor1 = predecesor
    if ciudadO == predecesor:
        cont = 1
    else:
        predecesor = path[1][ciudadO][ciudadF]
        
for i in predecesor:
    print i
    
print "La distancia en kilometros es: "
print path[1][ciudadO][ciudadF]



  

