import os
import platform
import random
import json

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
def diccionari_bonic(dic):
    return json.dumps(dic, indent = 4)
"""
-------------------------------------------------------------------------------
Exercici 0
-------------------------------------------------------------------------------

Fes una funció (genera_cartes) que retorni una llista representant totes les cartes de la baralla Espanyola.

Les cartes han d'estar en un array, on la posició 0 és el número i la 1 el pal:

[1, "espases"]

"""
# Fes aquí el codi de l'exercici 0
def genera_cartes():
    baralla = []
    pals = ["espases", "oros", "bastons", "copes"]
    for cnt_pal in range(0, len(pals)):
        pal = pals[cnt_pal]
        for cnt_num in range(1, 13):
            baralla.append([cnt_num, pal])
    return baralla
"""
-------------------------------------------------------------------------------
Exercici 1
-------------------------------------------------------------------------------

Fes una funció (barreja_cartes) que retorni una baralla de cartes desordenada

"""
# Fes aquí el codi de l'exercici 1
def barreja_cartes(baralla):
    random.shuffle(baralla)
    return baralla

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
# Fes aquí el codi de l'exercici 2
def reparteix_cartes(baralla, num_jugadors, num_cartes_per_jugador):
    if num_jugadors * num_cartes_per_jugador > len(baralla):
        print("No hi ha prou cartes")
        return  baralla, []
    baralla = barreja_cartes(baralla)
    mans = []
    for cnt in range(0, num_jugadors):
        cartes_jugador = []
        for cnt_cartes_jugador in range (0, num_cartes_per_jugador):
            carta = baralla.pop()
            cartes_jugador.append(carta)
        mans.append(cartes_jugador)
    return baralla, mans
baralla = genera_cartes()
baralla, mans = reparteix_cartes(baralla, 4, 12)
print(baralla)
print(mans[2])
print(mans[2][2])
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
# Fes aquí el codi de l'exercici 3
def jugada(comptador, numero_jugador, cartes_jugador, cartes_taula):
    carta = cartes_jugador.pop()
    cartes_taula.append(carta)
    if carta[0] == comptador:
        cartes_jugador = cartes_jugador + cartes_taula
        cartes_taula = []
        print(f"{comptador}: El comptador ({comptador}) coincideix amb la carta, el jugador {numero_jugador} agafa les cartes de la taula (ara en té {len(cartes_jugador)}).")
    else:
        print(f"{comptador}: El jugador {numero_jugador} ha tirat {carta} li queden {len(cartes_jugador)}")
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

- Comença el joc, que no acaba fins que hi ha un guanyador (while)
    - Per cada jugador:
        - Fa una jugada amb la funció (jugada)
        - Si el jugador s'ha quedat sense cartes:
            - Guarda el número del jugador com a guanyador
            - Acaba el joc
        - Incrementa el comptador
        - Si el comptador és més gran que 12, torna a 1
    - Escriu qui ha guanyat

"""
# Fes aquí el codi de l'exercici 4
def joc_del_rellotge():
    baralla = genera_cartes()
    cartes_block, mans_jugadors = reparteix_cartes(baralla, 4, 12)
    cartes_taula = []
    comptador = 1
    guanyador = -1

    while guanyador == -1:
        for cnt_jugador in range(0, len(mans_jugadors)):
            cartes_jugador = mans_jugadors[cnt_jugador]
            cartes_jugador, cartes_taula = jugada(comptador, cnt_jugador, cartes_jugador, cartes_taula)
            if len(cartes_jugador) == 0:
                guanyador = cnt_jugador
                return guanyador
            # Actualitzar el valor original de les mans d'aquest jugador
            mans_jugadors[cnt_jugador] = cartes_jugador
            comptador = comptador + 1
            if comptador > 12:
                comptador = 1

# Cridar aquí la funció per iniciar el joc
guanyador = joc_del_rellotge()
print(f"Ha guanyat el jugador {guanyador}")
