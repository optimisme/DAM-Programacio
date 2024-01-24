import os
import platform
import random

"""
Jocs, Tres en ratlla

En aquest apartat, farem una versió del joc del "Tres en ratlla".

- El joc consisteix en marcar tres caselles seguides en línia d'una taula de 3x3

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

Fes una funció "genera_tauler" que retorna un array de 3x3 amb els valors "·"

"""
# Fes aquí el codi de l'exercici 0

"""
-------------------------------------------------------------------------------
Exercici 1
-------------------------------------------------------------------------------

Fes una funció "dibuixa_tauler" que mostra el tauler així:

  0 1 2 
A X · ·
B O X ·
C · · O

- Primer cal esborrar la pantalla amb la funció "clear_screen"

"""
# Fes aquí el codi de l'exercici 1

"""
-------------------------------------------------------------------------------
Exercici 2
-------------------------------------------------------------------------------

Fes una funció "fila_columna" que:

* A partir d'una posició tipus "A0" retorni la fila i la columna
* Si la posició no és vàlida retorna -1,-1

Fes una funció "posicio_valida" que:

* Rep una posició (per exemple A0)
* Retorna True si la posició és vàlida (i no hi ha una "X" o una "O")
* Retorna False si la posició no és vàlida

"""
# Fes aquí el codi de l'exercici 2
    
"""
-------------------------------------------------------------------------------
Exercici 3
-------------------------------------------------------------------------------

Fes una funció "jugada_usuari" que:

* Dibuixa el tauler amb la funció "dibuixa_tauler"
* L'usuari ha d'escriure una posició:
    "Escriu la posició a descobrir (per exemple A0): "
* Si la posició no és vàlida:
  - Es torna a dibuixar el tauler
  - Es torna a demnara la posició
* Si la posició és vàlida, es marca al tauler amb una "X"

"""
# Fes aquí el codi de l'exercici 3

"""
-------------------------------------------------------------------------------
Exercici 4
-------------------------------------------------------------------------------

Fes una funció "jugada_ordinador" que:

* Escull una posició vàlida aleatòriament
* Marca la posició amb una "O"
* Dibuixa el tauler

"""
# Fes aquí el codi de l'exercici 4

"""
-------------------------------------------------------------------------------
Exercici 5
-------------------------------------------------------------------------------

Fes una funció "busca_guanyador" que:

- Mira si s'ha acabat la partida (hi ha tres "X" o tres "O" seguides)
- Retorna "X" si guanya l'usuari o retorna "O" si guanya l'ordinador
- Retorna "·" si encara no hi ha guanyador

"""
# Fes aquí el codi de l'exercici 5

"""
-------------------------------------------------------------------------------
Exercici 6
-------------------------------------------------------------------------------

Fes una funció "joc_del_tres_en_ratlla" que permet fer una partida al:

- Primer sempre juga l'usuari
- Després sempre juga l'ordinador
- Tingues en compte que poden empatar
- Al final mostra el taulell i el guanyador

"""
# Fes aquí el codi de l'exercici 6


# Finalment, crida la funció "joc_del_tres_en_ratlla()" per començar el programa
