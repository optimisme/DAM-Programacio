#!/usr/bin/env python3

import os
import random

"""
Jocs, El Rellotge

En aquest apartat, farem el joc del "Rellotge" amb cartes.

- El joc consisteix en que cada jugador té 12 cartes (48 cartes / 4 jugadors)
- El joc comença amb el comptador a 0
- A cada tirada el jugador posa una carta al centre (sense veure-la, la que té al damunt del seu bloc)
- A cada tirada el jugador compta un número de comptador un més que l'anterior, o 1 si l'anterior era 12
- Si el número del comptador coincideix amb el número de la carta, el jugador agafa totes les cartes del centre (les que s'han tirat abans)
- El joc acaba quan un jugador es queda sense cartes.
"""

# Aquesta funció neteja la pantalla, no la modifiquis
def clearScreen():
    if os.name == 'nt':     # Si estàs a Windows
        os.system('cls')
    else:                   # Si estàs a Linux o macOS
        os.system('clear')

clearScreen()

def genera_cartes():
    """
    Genera una baralla espanyola de 48 cartes.
    
    Retorna:
        cartes (list[list[int, str]]): Una llista amb totes les cartes de la baralla.
    Exemple:
        [[1, 'oros'], [1, 'copes'], [1, 'espases'], [1, 'bastos'], [2, 'oros'], [2, 'copes'], ... ]
    """
    pals = ["oros", "copes", "espases", "bastos"]
    cartes = [[n, pal] for n in range(1, 13) for pal in pals]
    return cartes

def barreja_cartes(cartes):
    """
    Barreja una baralla de cartes.
    
    Paràmetres:
        cartes (list[list[int, str]]): Una llista amb les cartes a barrejar.
        
    Retorna:
        cartes_barrejades (list[list[int, str]]): La llista de cartes barrejades.
    """
    random.shuffle(cartes)
    return cartes

def reparteix_cartes(cartes, nombre_jugadors, cartes_per_jugador):
    """
    Reparteix les cartes entre els jugadors i retorna les cartes restants.
    
    Paràmetres:
        cartes (list[list[int, str]]): La baralla de cartes.
        nombre_jugadors (int): El nombre de jugadors.
        cartes_per_jugador (int): El nombre de cartes per cada jugador.
        
    Retorna:
        cartes_restants (list[list[int, str]]): La baralla restant després de repartir.
        mans_jugadors (list[list[list[int, str]]]): Les cartes de cada jugador.
    """
    cartes = barreja_cartes(cartes)
    mans_jugadors = []
    for i in range(nombre_jugadors):
        mans_jugadors.append(cartes[i*cartes_per_jugador:(i+1)*cartes_per_jugador])
    cartes_restants = cartes[nombre_jugadors*cartes_per_jugador:]
    return cartes_restants, mans_jugadors

def jugada(comptador, numero_jugador, cartes_jugador, cartes_taula):
    """
    Realitza una jugada per al jugador actual i actualitza l'estat del joc.

    El jugador retira la carta superior de la seva mà i la col·loca al centre de la taula. 
    A continuació, es comprova si el valor de la carta coincideix amb el número que indica el comptador. 
    Si coincideix, el jugador recull totes les cartes del centre, incloent-hi la seva pròpia carta jugada. 
    En cas contrari, les cartes es mantenen al centre per a la següent ronda.

    Paràmetres:
        comptador (int): El valor actual del comptador (de 0 a 11), que determina el número a dir.
        numero_jugador (int): La posició del jugador en la llista de jugadors (index).
        cartes_jugador (list[list[int, str]]): Les cartes que el jugador té a la mà.
        cartes_taula (list[list[int, str]]): Les cartes que estan actualment al centre de la taula.

    Retorna:
        tuple: Conté els següents elements:
            - cartes_jugador (list[list[int, str]]): Les cartes restants a la mà del jugador després de la jugada.
            - cartes_taula (list[list[int, str]]): Les cartes actualitzades al centre de la taula.
            - ha_agafat_cartes (bool): Indica si el jugador ha recollit les cartes del centre (True) o no (False).
    """
    if not cartes_jugador:
        return cartes_jugador, cartes_taula, False

    carta = cartes_jugador.pop(0)  
    numero_a_dir = (comptador + 1) % 12 or 12  

    ha_agafat_cartes = False
    if carta[0] == numero_a_dir:  
        cartes_taula.append(carta)
        cartes_jugador.extend(cartes_taula)
        cartes_taula.clear()
        ha_agafat_cartes = True
    else:
        cartes_taula.append(carta) 

    return cartes_jugador, cartes_taula, ha_agafat_cartes

def mostra_estat_joc(mans_jugadors):
    """
    Mostra l'estat actual del joc, indicant quantes cartes té cada jugador.

    Paràmetres:
        mans_jugadors (list[list[list[int, str]]]): Les cartes de cada jugador.

    Exemples:
        Jugador 0: 5 cartes, Jugador 1: 1 carta, Jugador 2: 1 carta, Jugador 3: 41 cartes        
        "Jugador 0: 8 cartes, Jugador 1: 3 cartes, Jugador 2: 19 cartes, Jugador 3: 18 cartes"
    """
    txt = ""
    for i, ma in enumerate(mans_jugadors):
        if i > 0:
            txt = txt + ", "
        numero_cartes = len(ma)
        if (numero_cartes == 1):
            txt = txt + f"Jugador {i}: 1 carta"
        else:
            txt = txt + f"Jugador {i}: {len(ma)} cartes"
    print(txt)

def mainRun():
    """
    Executa el joc del Rellotge.
    
    Aquest mètode implementa la lògica principal del joc, incloent:
    - Inicialització del joc
    - Bucle principal de joc
    - Quan un jugador guanya s'escriu: "\nEl jugador {guanyador} ha guanyat!"
    - Quan un jugador agafa cartes s'escriuen el número de 
      tirades seguides anterior: "\nTirades seguides: {tirades_seguides}"
    - Mostra de l'estat del joc després de cada ronda
    
    Retorna:
        No retorna res, només executa el joc fins que hi ha un guanyador.

    Exemple de sortida:
        Tirades seguides: 2
        Jugador 0: 3 cartes, Jugador 1: 13 cartes, Jugador 2: 22 cartes, Jugador 3: 10 cartes

        Tirades seguides: 3
        Jugador 0: 2 cartes, Jugador 1: 16 cartes, Jugador 2: 21 cartes, Jugador 3: 9 cartes

        El jugador 1 ha guanyat!
    """
    cartes = genera_cartes()
    _, mans_jugadors = reparteix_cartes(cartes, 4, 12)
    comptador = -1  # Comença a -1 perquè s'incrementa abans de cada jugada
    guanyador = -1
    cartes_taula = []

    tirades_seguides = 0
    while guanyador == -1:
        for i, cartes_jugador in enumerate(mans_jugadors):
            comptador = (comptador + 1) % 12
            mans_jugadors[i], cartes_taula, ha_agafat_cartes = jugada(comptador, i, cartes_jugador, cartes_taula)
            
            if len(mans_jugadors[i]) == 0:
                guanyador = i + 1
                print(f"\nEl jugador {guanyador} ha guanyat!")
                break

            if ha_agafat_cartes:
                print(f"\nTirades seguides: {tirades_seguides}")
                tirades_seguides = 0
                mostra_estat_joc(mans_jugadors)
            else:
                tirades_seguides = tirades_seguides + 1             

# No canvieu això o no passarà el test
if __name__ == "__main__":
    mainRun()