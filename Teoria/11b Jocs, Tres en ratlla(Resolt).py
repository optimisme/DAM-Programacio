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
def genera_tauler():
    tauler = []
    for cnt_fila in range(0, 3):
        fila = []
        for cnt_columna in range(0, 3):
            fila.append("·")
        tauler.append(fila)
    return tauler

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
def dibuixa_tauler(tauler):
    clear_screen()
    lletres = ["A", "B", "C"]
    print("  0 1 2 ")
    for cnt_fila in range(0, len(lletres)):
        txt_fila = lletres[cnt_fila] + " "
        for cnt_columna in range(0, 3):
            txt_fila = txt_fila + tauler[cnt_fila][cnt_columna] + " "
        print(txt_fila)

"""
-------------------------------------------------------------------------------
Exercici 2
-------------------------------------------------------------------------------

Fes una funció "fila_columna" que:

* A partir d'una posició tipus "A0" retorni la fila i la columna
* Si la posició no és vàlida retorna -1

Fes una funció "posicio_valida" que:

* Rep una posició (per exemple A0)
* Retorna True si la posició és vàlida (i no hi ha una "X" o una "O")
* Retorna False si la posició no és vàlida

"""
# Fes aquí el codi de l'exercici 2

def fila_columna(posicio):
    lletres = ["A", "B", "C"]
    txt_fila = posicio[0]
    txt_columna = posicio[1]
    if (txt_fila in lletres):
        num_fila = lletres.index(txt_fila)
    else:
        num_fila = -1
    num_columna = int(txt_columna)
    if num_columna < 0 or num_columna > 3:
        num_columna = -1
    return num_fila, num_columna

def posicio_valida(posicio, tauler):
    num_fila, num_columna = fila_columna(posicio)
    if num_fila == -1 or num_columna == -1:
        return False
    valor = tauler[num_fila][num_columna]
    if valor == "X" or valor == "O":
        return False
    return True

"""
-------------------------------------------------------------------------------
Exercici 3
-------------------------------------------------------------------------------

Fes una funció "jugada_usuari" que:

* Dibuixa el tauler de l'oponent amb la funció "dibuixa_tauler"
* L'usuari ha d'escriure una posició:
    "Escriu la posició a descobrir (per exemple A0): "
* Si la posició no és vàlida:
  - Es torna a dibuixar el tauler
  - Es torna a demnara la posició
* Si la posició és vàlida, es marca al tauler amb una "X"

"""
# Fes aquí el codi de l'exercici 3
def jugada_usuari(tauler):
    dibuixa_tauler(tauler)
    while True:
        dibuixa_tauler(tauler)
        posicio = input("Escriu la posició a descobrir (per exemple A0): ")
        if posicio_valida(posicio, tauler):
            break
    num_fila, num_columna = fila_columna(posicio)
    tauler[num_fila][num_columna] = "X"
    return tauler

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
def jugada_ordinador(tauler):
    lletres = ["A", "B", "C"]
    while True:
        num_fila = random.randint(0, 2)
        num_columna = int(random.randint(0, 2))
        posicio = lletres[num_fila] + str(num_columna)
        if posicio_valida(posicio, tauler):
            tauler[num_fila][num_columna] = "O"
            break
 
    dibuixa_tauler(tauler)
    return tauler

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

def busca_guanyador(tauler):
    for cnt_fila in range(0, 3):
        if tauler[cnt_fila][0] != "·" and tauler[cnt_fila][0] == tauler[cnt_fila][1] == tauler[cnt_fila][2]:
            return tauler[cnt_fila][0]
    for cnt_columna in range(0, 3):
        if tauler[0][cnt_columna] != "·" and tauler[0][cnt_columna] == tauler[1][cnt_columna] == tauler[2][cnt_columna]:
            return tauler[0][cnt_columna]
    if tauler[0][0] != "·" and tauler[0][0] == tauler[1][1] and tauler[1][1] == tauler[2][2]:
        return tauler[0][0]
    if tauler[0][2] != "·" and tauler[0][2] == tauler[1][1] and tauler[1][1] == tauler[2][0]:
        return tauler[0][2]
    return "·"

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
def taulell_complet(tauler):
    for cnt_fila in range(0, 3):
        for cnt_columna in range(0, 3):
            if tauler[cnt_fila][cnt_columna] == "·":
                return False
    return True

def joc_del_tres_en_ratlla():
    tauler = genera_tauler()
    while True:
        tauler = jugada_usuari(tauler)
        guanyador = busca_guanyador(tauler)
        if taulell_complet(tauler):
            guanyador = "Empat"
            break
        if guanyador == "X":
            break
        tauler = jugada_ordinador(tauler)
        guanyador = busca_guanyador(tauler)
        if taulell_complet(tauler):
            guanyador = "Empat"
            break
        if guanyador == "O":
            break
    dibuixa_tauler(tauler)
    print("Ha guanyat: " + guanyador)

# Finalment, crida la funció "joc_del_tres_en_ratlla()" per començar el programa
joc_del_tres_en_ratlla()