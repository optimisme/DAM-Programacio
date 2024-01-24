"""
Jocs, Dus

Aquest joc consisteix en:

- Es tiren dos daus cada torn, si la suma és parell, se sumen els punts del dau major i i si són imparells, es resten els del dau menor.

- Es tiren 50 vegades cadascun els daus i el que major puntuació treu, guanya.

- Si guanya l'usuari, s'afegeix el jugador i pa seva puntuació al ranking.

- El ranking haurà d’estar ordenat.

- Al final de cada partida, caldrà resetejar el nom de l'usuari.

En aquesta versió el ranking es guarda en un text d'aquest estil:

"Pedro:1000;Mario:500;Pablo:5;"

No es pot fer servir arrays de cap manera
"""
import os
import platform
import random

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

Fes la funció 'afegir_jugador' que permet afegir un nou jugador a la 
llista del rànking, amb 0 punts

"""

# Fes aquí el codi de l'exercici 0

"""
-------------------------------------------------------------------------------
Exercici 1
-------------------------------------------------------------------------------

Fes la funció 'escollir_jugador' que permet escollir un jugador a partir
de la llista de jugadors que hi ha al ranking del joc
"""

# Fes aquí el codi de l'exercici 1

"""
-------------------------------------------------------------------------------
Exercici 2
-------------------------------------------------------------------------------

Fes la funció 'mostrar_puntuacions' que mostra les puntuacions
del ranking del joc amb aquest estil:

··············· Ranking ···············
NOM                               PUNTS
***************************************
Sebastian                         11400
Bob                                 700

"""

# Fes aquí el codi de l'exercici 2

"""
-------------------------------------------------------------------------------
Exercici 10
-------------------------------------------------------------------------------

Fes una funció "menu_principal" que mostri el següent menú 
(i en permeti el funcionament)

1) Nova partida
2) Nou jugador
3) Escollir jugador
4) Mostrar puntuacions
0) Sortir
Escull una opció:

- S'ha de validar que la opció és valida, i no s'ha de
permetre jugar una nova partida si no s'ha escollir un jugador
o se n'ha afegit un de nou

- Al final de cada partida s'esborra el nom de l'usuari

"""
# Fes aquí el codi de l'exercici 10