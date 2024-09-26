#!/usr/bin/env python3
import math
import random

# Fes un programa que permeti a l'usuari introduir números i operacions. 
# El programa suma aquests números i mostra la suma 
# acumulada després de cada entrada. Si l'usuari escriu "sortir", 
# el programa acaba i mostra la suma final.
def suma_infinit(celsius):
    suma_acumulada = 0
    while True:
        entrada = input("Introdueix un número o 'sortir' per acabar: ")
        if entrada.lower() == "sortir":
            break
        try:
            numero = float(entrada)
            suma_acumulada += numero
            print(f"Suma acumulada: {suma_acumulada}")
        except ValueError:
            print("Entrada no vàlida, introdueix un número.")

    print(f"La suma final és: {suma_acumulada}")

# Escull un número aleatori entre 1 i 25, després fes que el programa multipliqui 
# aquest número per 2 repetidament, mostrant el resultat a cada iteració. 
# El bucle acaba quan el resultat supera 100. 
# Finalment retorna el número d'iteracions que han fet falta.
def multiplica_fins_100():
    numero = random.randint(1, 25)
    print(f"El número inicial és: {numero}")
    iteracions = 0
    while numero <= 100:
        numero *= 2
        iteracions += 1
        print(f"Resultat actual: {numero}")
    print(f"Han fet falta {iteracions} iteracions per superar 100.")

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
    while True:
        print("""
        Menú:
        1. Saludar
        2. Presentar
        3. Vacilar
        0. Sortir
        """)
        opcio = input("Escull una opció: ").lower()
        if opcio == "1" or opcio == "saludar":
            print("Hola colega")
        elif opcio == "2" or opcio == "presentar":
            print("Sóc un programa molón")
        elif opcio == "3" or opcio == "vacilar":
            print(random.choice(["Pfff", "De què vas?"]))
        elif opcio == "0" or opcio == "sortir":
            print("Sortint del programa...")
            break
        else:
            print("Opció no vàlida, torna-ho a provar.")

# Fes un programa que a partir de dos numeros aleatoris 
# entre 1 i 5 els ordena de major a menor i escriu 
# (X guions pel primer número, separats d'un espai) 
# tantes vegades com el segon número
def guions_ordenats():
    num1 = random.randint(1, 5)
    num2 = random.randint(1, 5)    
    if num1 > num2:
        major = num1
        menor = num2
    else:
        major = num2
        menor = num1
    for _ in range(menor):
        print("- " * major)

# Fes un programa que esculli una operació a l'atzar 
# (suma, resta, multiplicació i divisió). 
# Esculli dos números entre 1 i 10 a l'atzar i aleshores 
# apliqui la operació sobre el primer número 
# les vegades indicades pel segon número.
# Si la operació és dividir i el divisor és 0, ha de dir:
# No es pot dividir per 0
def operacio_aleatoria():
    operacions = ['suma', 'resta', 'multiplicacio', 'divisio']
    operacio = random.choice(operacions)
    num1 = random.randint(0, 10)
    num2 = random.randint(0, 10)
    resultat = num1
    print(f"Operació: {operacio}, Número inicial: {num1}, Vegades: {num2}")
    if operacio == 'suma':
        for _ in range(num2):
            resultat += num1
    elif operacio == 'resta':
        for _ in range(num2):
            resultat -= num1
    elif operacio == 'multiplicacio':
        for _ in range(num2):
            resultat *= num1
    elif operacio == 'divisio':
        if num1 != 0: 
            for _ in range(num2):
                resultat /= num1
        else:
            print("No es pot dividir per 0.")
            return
    print(f"El resultat final és: {resultat}")

