# -*- coding: cp1252 -*-
'''
    Universidad del Valle de Guatemala
    Algoritmos y estructura de datos
    Hoja de trabajo 11 - implementacion de algoritmo de Floyd y centro de grafo
    Version: 24/05/2018
    Ana Lucia Hernandez - 17138
    Maria Fernanda Lopez - 17160
'''

from modulo import *

opcion = input("1.Calcular la ruta mas corta\n2.Calcular el centro del grafo\n3.Agregar\n0.Salir\n")
while(opcion!=0):
    if (opcion==1):
        ruta()
    if (opcion==2):
        centro()
    if (opcion==3):
        a = raw_input("Ingrese la ciudad de origin: ")
        b = raw_input("Ingrese la ciudad de destino: ")
        c = input("Ingrese los kilometros entre ruta: ")                      
        agregar(a,b,c)
    opcion = input("1.Calcular la ruta mas corta\n2.Calcular el centro del grafo\n3.Agregar\n0.Salir\n")













  

