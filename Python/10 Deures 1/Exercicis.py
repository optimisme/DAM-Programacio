#!/usr/bin/env python3
import os
import random

def clearScreen():
    if os.name == 'nt':  # Si estàs en Windows
        os.system('cls')
    else:  # Si estàs en Linux o macOS
        os.system('clear')
clearScreen()

# Fes un programa que permeti a l'usuari introduir números i operacions. 
# El programa suma aquests números i mostra la suma 
# acumulada després de cada entrada. Si l'usuari escriu "sortir", 
# el programa acaba i mostra la suma final.
def suma_infinit():
    pass

# Escull un número aleatori entre 1 i 25, després fes que el programa multipliqui 
# aquest número per 2 repetidament, mostrant el resultat a cada iteració. 
# El bucle acaba quan el resultat supera 100. 
# Finalment retorna el número d'iteracions que han fet falta.
def multiplica_fins_100():
    pass

# Fes un programa que mostri el següent menú
# Menú:
# 1 Saludar
# 2 Presentar
# 3 Vacilar
# 0 Sortir
# L'usuari ha de poder escriure el número o la opció (ignorant les majúscules)
# La opció 1 escriu "Hola colega"
# La opció 2 escriu "Sóc un programa molón"
# La opció 3 escriu "Pfff" o "De què vas?" de manera aleatòria
# La opció 0 surt del programa
def gestionar_menu():
    pass

# Fes un programa que a partir de dos numeros aleatoris 
# entre 1 i 5 els ordena de major a menor i escriu 
# (X guions pel primer número, separats d'un espai) 
# tantes vegades com el segon número
def guions_ordenats():
    pass

# Fes un programa que esculli una operació a l'atzar 
# (suma, resta, multiplicació i divisió). 
# Esculli dos números entre 1 i 10 a l'atzar i aleshores 
# apliqui la operació sobre el primer número 
# les vegades indicades pel segon número.
# Si la operació és dividir i el divisor és 0, ha de dir:
# No es pot dividir per 0
def operacio_aleatoria():
    pass