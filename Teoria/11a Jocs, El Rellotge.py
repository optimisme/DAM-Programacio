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

"""
-------------------------------------------------------------------------------
Exercici 0
-------------------------------------------------------------------------------

Fes una funció (genera_cartes) que retorni una llista representant totes les cartes de la baralla Espanyola.

Les cartes han d'estar en un array, on la posició 0 és el número i la 1 el pal:

[1, "espases"]

"""
# Fes aquí el codi de l'exercici 0

"""
-------------------------------------------------------------------------------
Exercici 1
-------------------------------------------------------------------------------

Fes una funció (barreja_cartes) que retorni una baralla de cartes desordenada

"""
# Fes aquí el codi de l'exercici 1

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
  - S'escriu la jugada per fer el seguiment pel terminal
    

"""
# Fes aquí el codi de l'exercici 3

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

# Cridar aquí la funció per iniciar el joc