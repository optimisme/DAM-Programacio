import os
import platform
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
def clear_screen():
    sistema = platform.system()
    if sistema == "Windows":
        os.system('cls')
    else:
        os.system('clear')

"""
-------------------------------------------------------------------------------
Exercici 0
-------------------------------------------------------------------------------

Fes una funció (genera_cartes) que retorni una llista representant totes les cartes de la baralla Espanyola.

Les cartes han d'estar en un array, on la posició 0 és el número i la 1 el pal:

[1, "espases"]

"""
def genera_cartes():
    cartes = []
    valors = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12]
    pals = ["oros", "copes", "bastos", "espases"]
    for pal in pals:
        for valor in valors:
            cartes.append([valor, pal])
    return cartes

"""
-------------------------------------------------------------------------------
Exercici 1
-------------------------------------------------------------------------------

Fes una funció (barreja_cartes) que retorni una baralla de cartes desordenada

"""
def barreja_cartes(baralla):
    random.shuffle(baralla)

"""
-------------------------------------------------------------------------------
Exercici 2
-------------------------------------------------------------------------------

Fes una funció (reparteix_cartes) que:

Com a paràmetres, rep:

- La baralla de cartes
- El nombre de jugadors
- El nombre de cartes per jugador

Ha de retornar:

- La baralla sense les cartes seleccionades
- Una llista de llistes de cartes, on cada llista representa les cartes de cada jugador

Abans de repartir, ha de barrejar les cartes

"""
def reparteix_cartes(baralla, num_jugadors, num_cartes_per_jugador):
    if num_jugadors * num_cartes_per_jugador > len(baralla):
        print("No hi ha prou cartes a la baralla per al repartiment.")
        return baralla, []
    
    barreja_cartes(baralla)
    mans_jugadors = []
    for i in range(num_jugadors):
        cartes_jugador = []
        for j in range(num_cartes_per_jugador):
            carta = baralla.pop()
            cartes_jugador.append(carta)
        mans_jugadors.append(cartes_jugador)
    return baralla, mans_jugadors

"""
-------------------------------------------------------------------------------
Exercici 3
-------------------------------------------------------------------------------

Fes una funció (jugada) que rep els paràmetres per fer una jugada:

* comptador: el número del comptador
* numero_jugador: la posició del jugador a l'array de mans
* cartes_jugador: la llista de cartes del jugador
* cartes_taula: la llista de cartes que hi ha a la taula

I retorna les cartes un cop feta la jugada:

* cartes_jugador: la llista de cartes del jugador
* cartes_taula: la llista de cartes que hi ha a la taula

La funció ha de:

  - Agafar la última carta de la llista del jugador 
  - Posar-la a la llista de cartes de la taula
  - Si el número de la carta coincideix amb el comptador
      - El jugador agafa totes les cartes de la taula 
      - Les cartes de la taula es queden buides
    

"""
def jugada(comptador, numero_jugador, cartes_jugador, cartes_taula):
    carta_jugador = cartes_jugador.pop(0)
    cartes_taula.append(carta_jugador)
    print(f"{comptador}: Jugador {numero_jugador} posa la carta {carta_jugador} al centre (ara en té {len(cartes_jugador)}).")
    if carta_jugador[0] == comptador:
        cartes_jugador.extend(cartes_taula)
        print(f"{comptador}: El comptador ({comptador}) coincideix amb la carta, el jugador {numero_jugador} agafa les cartes de la taula (ara en té {len(cartes_jugador)}).")
        cartes_taula = []
    return cartes_jugador, cartes_taula

"""
-------------------------------------------------------------------------------
Exercici 4
-------------------------------------------------------------------------------

Fes una funció (joc_del_rellotge) que:

- Genera una baralla de cartes
- Reparteix 12 cartes a 4 jugadors
- Inicialitzi el comptador a 1
- Inicialitzi el guanyador a -1
- Inicialitzi les cartes de la taula a [], perquè no n'hi ha cap

- Comença el joc, que no acaba fins que hi ha un jugador (while)
    - Per cada jugador:
        - Fa una jugada amb la funció (jugada)
        - Si el jugador s'ha quedat sense cartes:
            - Guarda el número del jugador com a guanyador
            - Acaba el joc
        - Incrementa el comptador
        - Si el comptador és més gran que 12, torna a 1
    - Escriu qui ha guanyat

"""
def joc_del_rellotge():
    baralla = genera_cartes()
    cartes_block, mans_jugadors = reparteix_cartes(baralla, 4, 12)
    cartes_taula = []
    comptador = 1
    guanyador = -1

    while guanyador == -1:
        for numero_jugador in range(len(mans_jugadors)):
            cartes_jugador = mans_jugadors[numero_jugador]
            cartes_jugador, cartes_taula = jugada(comptador, numero_jugador, mans_jugadors[numero_jugador], cartes_taula)
            if len(cartes_jugador) == 0:
                guanyador = numero_jugador
                break
            comptador = comptador + 1
            if comptador > 12:
                comptador = 1

    print(f"Jugador {guanyador} guanya la partida!")

# Cridar aquí la funció per iniciar el joc
clear_screen()
joc_del_rellotge()