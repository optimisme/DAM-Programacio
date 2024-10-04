#!/usr/bin/env python3

import os
import platform
import random

"""
Jocs, Tres en ratlla

En aquest apartat, farem una versió del joc del "Tres en ratlla".

El joc consisteix en marcar tres caselles seguides en línia d'una taula de 3x3

"""

# Aquesta funció neteja la pantalla, no la modifiquis
def clearScreen():
    if os.name == 'nt':     # Si estàs a Windows
        os.system('cls')
    else:                   # Si estàs a Linux o macOS
        os.system('clear')

clearScreen()

# Exercici 0
def genera_tauler():
    """
    Crea un tauler buit de 3x3 per al joc de Tres en Ratlla.

    Retorna:
        list[list[str]]: Un tauler de 3x3, on cada element és una cadena de text amb el valor "·", 
        que representa una casella buida.

    Exemples:
        genera_tauler()
          [['·', '·', '·'], 
           ['·', '·', '·'], 
           ['·', '·', '·']]
    """
    pass

# Exercici 1
def dibuixa_tauler(tauler):
    """
    Mostra el tauler actual del joc de Tres en Ratlla a la consola.

    Paràmetres:
        tauler (list[list[str]]): Una llista de llistes que representa el tauler de 3x3, 
        on cada element és una cadena de text que pot ser "·", "X" o "O".

    Retorna:
        None: Aquesta funció no retorna cap valor. Es limita a mostrar el tauler per pantalla.

    Comportament:
        - Primer es neteja la pantalla amb la funció clearScreen().
        - Després, es mostra una capçalera amb els números de les columnes (0, 1, 2).
        - Les files del tauler es mostren amb les lletres A, B, C i les corresponents caselles separades per espais.

    Exemples:
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]
        dibuixa_tauler(tauler)
          # Sortida esperada:
          #  0 1 2
          # A X · ·
          # B O X ·
          # C · · O
    """
    pass

# Exercici 2
def fila_columna(posicio):
    """
    Converteix una posició del format 'A0' en índexs numèrics de fila i columna.

    Paràmetres:
        posicio (str): Una cadena de text que representa una posició en el tauler.
                       La primera lletra (A, B, C) representa la fila, 
                       i el segon caràcter (0, 1, 2) representa la columna.

    Retorna:
        tuple[int, int]: Un parell d'enters (fila, columna) que corresponen als índexs del tauler.
                         Si la posició no és vàlida, retorna (-1, -1).

    Exemples:
        fila_columna("A0")
        0, 0
        fila_columna("B1")
        1, 1
        fila_columna("D2")
        -1, -1
    """
    pass

# Exercici 3
def posicio_valida(tauler, posicio):
    """
    Verifica si una posició és vàlida i està disponible al tauler.

    Paràmetres:
        tauler (list[list[str]]): El tauler de joc, una llista de llistes amb dimensions 3x3,
                                  on cada element és una cadena de text que pot ser "·", "X" o "O".
        posicio (str): Una cadena de text que representa una posició en el tauler,
                       en el format 'A0', 'B2', etc.

    Retorna:
        bool: Retorna True si la posició és vàlida (es troba dins els límits del tauler i està lliure, "·").
              Retorna False si la posició no és vàlida o està ocupada per una "X" o "O".

    Exemples:
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]
                  
        posicio_valida(tauler, "A1")
        True
        posicio_valida(tauler, "B1")
        False
    """
    pass


# Exercici 4
def jugada_usuari(tauler):
    """
    Permet que l'usuari faci una jugada, demanant una posició o sortir del joc.

    Paràmetres:
        tauler (list[list[str]]): El tauler de joc, una llista de llistes amb dimensions 3x3,
                                  on cada element és una cadena de text que pot ser "·", "X" o "O".

    Retorna:
        str or None: Retorna "sortir" si l'usuari escriu "SORTIR" per acabar el joc.
                     Retorna None si l'usuari introdueix una posició vàlida i s'ha realitzat la jugada.

    Comportament:
        - Dibuixa el tauler actual cridant la funció `dibuixa_tauler`.
        - Demana a l'usuari que introdueixi una posició en format (ex: "A0") o "SORTIR" per acabar el joc.
        - Si l'usuari escriu "SORTIR", retorna "sortir" per acabar el joc.
        - Si la posició és vàlida, marca la posició amb una "X" al tauler i surt del bucle.
        - Si la posició no és vàlida, torna a demanar una entrada fins que sigui correcta.

    Exemples:
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]
                  
        jugada_usuari(tauler)
          # L'usuari introdueix una posició vàlida com "A1" i la funció marca aquesta casella amb una "X".
          # O l'usuari escriu "SORTIR", i el joc s'atura.
    """
    pass

  
# Exercici 5
def cerca_posicio_guanyadora(tauler, jugador):
    """
    Cerca si el jugador pot guanyar en la següent jugada.

    Paràmetres:
        tauler (list[list[str]]): El tauler de joc, una llista de llistes amb dimensions 3x3,
                                  on cada element és una cadena de text que pot ser "·", "X" o "O".
        jugador (str): Una cadena de text que indica el jugador a comprovar, "X" o "O".

    Retorna:
        tuple[int, int] or None: Retorna una tupla (fila, columna) amb la posició lliure on el jugador pot
                                 completar tres fitxes seguides i guanyar la partida.
                                 Retorna None si no es troba cap posició guanyadora.

    Comportament:
        - Comprova si el jugador té dues fitxes seguides en qualsevol fila, columna o diagonal, amb una
          casella lliure per completar la línia.
        - Si troba una combinació guanyadora, retorna la posició d'aquesta casella lliure.
        - Si no hi ha cap oportunitat de guanyar en la següent jugada, retorna None.

    Exemples:
        tauler = [['X', 'X', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]
                  
        cerca_posicio_guanyadora(tauler, "X")
          (0, 2)  # El jugador "X" pot completar la primera fila per guanyar
        
        cerca_posicio_guanyadora(tauler, "O")
          None    # El jugador "O" no té cap posició guanyadora immediata
    """
    pass

def jugada_ordinador(tauler):
    """
    Realitza la jugada de l'ordinador en el joc de Tres en Ratlla.

    Paràmetres:
        tauler (list[list[str]]): El tauler de joc, una llista de llistes amb dimensions 3x3,
                                  on cada element és una cadena de text que pot ser "·", "X" o "O".

    Retorna:
        None: La funció no retorna res, simplement modifica el tauler actual amb la jugada de l'ordinador.

    Comportament:
        - 1. Comprova si l'ordinador pot guanyar en la seva jugada. Si és possible, completa la línia guanyadora amb una "O".
        - 2. Si no pot guanyar, comprova si l'usuari està a punt de guanyar (dues "X" seguides) i bloqueja aquesta jugada posant una "O".
        - 3. Si no hi ha cap jugada imminent, prioritza les següents opcions:
            a) Posar una "O" al centre del tauler si està lliure.
            b) Posar una "O" en una de les cantonades (triada aleatòriament).
            c) Si no hi ha cantonades lliures, triar una casella lliure aleatòriament dins el tauler.
        - Finalment, actualitza el tauler i el mostra amb `dibuixa_tauler`.

    Exemples:
        tauler = [['X', '·', '·'], 
                  ['O', 'X', '·'], 
                  ['·', '·', 'O']]
                  
        jugada_ordinador(tauler)
          # L'ordinador realitza una jugada seguint la seva estratègia i el tauler es modifica en conseqüència.
    """
    pass

# Exercici 6
def busca_guanyador(tauler):
    """
    Determina si hi ha un guanyador en el joc de Tres en Ratlla.

    Paràmetres:
        tauler (list[list[str]]): El tauler de joc, una llista de llistes amb dimensions 3x3,
                                  on cada element és una cadena de text que pot ser "·", "X" o "O".

    Retorna:
        str: Retorna "X" si l'usuari ha guanyat, "O" si l'ordinador ha guanyat, 
             o "·" si encara no hi ha un guanyador.

    Comportament:
        - Comprova si hi ha tres fitxes iguals seguides en alguna de les files, columnes o diagonals.
        - Si es troba una combinació guanyadora (tres "X" o tres "O"), retorna el símbol corresponent.
        - Si no es troba cap guanyador, retorna "·", indicant que el joc encara continua o que hi ha un empat.

    Exemples:
        tauler = [['X', 'X', 'X'], 
                  ['O', '·', '·'], 
                  ['O', '·', '·']]
        
        busca_guanyador(tauler)
          "X"  # L'usuari amb "X" ha guanyat la partida

        tauler = [['X', 'O', 'X'], 
                  ['O', 'O', 'X'], 
                  ['X', 'X', 'O']]
        
        busca_guanyador(tauler)
          "·"  # No hi ha cap guanyador, és un empat
    """
    pass

# Exercici 7
def mainRun():
    """
    Executa una partida completa de Tres en Ratlla entre l'usuari i l'ordinador.

    Retorna:
        None: Aquesta funció no retorna cap valor. S'encarrega d'executar el flux complet del joc i 
              mostrar el resultat final (guanyador o empat).

    Comportament:
        - Inicialitza el tauler buit mitjançant la funció `genera_tauler`.
        - Alterna els torns entre l'usuari i l'ordinador, començant sempre per l'usuari.
        - L'usuari pot introduir una posició o escriure "sortir" per acabar el joc prematurament.
        - Després de cada torn, es comprova si hi ha un guanyador utilitzant la funció `busca_guanyador`.
        - Si es detecta un guanyador, el joc s'acaba i es mostra el resultat.
        - Si no hi ha guanyador després de 9 torns, es declara un empat.
        - Durant el joc, si l'usuari decideix sortir escrivint "sortir", es mostra un missatge i el joc s'atura.

    Exemples:
        mainRun()
        # Comença una partida on l'usuari i l'ordinador alternen jugades.
        # Si l'usuari guanya, el joc mostrarà "El guanyador és: X".
        # Si l'ordinador guanya, mostrarà "El guanyador és: O".
        # Si cap guanya després de 9 torns, mostrarà "Empat!".
    """
    pass

# No canvieu això o no passarà el test
if __name__ == "__main__":
    mainRun()