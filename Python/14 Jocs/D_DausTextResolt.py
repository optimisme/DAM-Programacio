#!/usr/bin/env python3

import os
import platform
import random

"""
Jocs, Daus

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

def clearScreen():
    if os.name == 'nt':
        os.system('cls')
    else:
        os.system('clear')

clearScreen()

def afegir_jugador(ranking_str, nom_jugador, nova_puntuacio):
    """
    Afegeix un nou jugador al rànquing o actualitza la seva puntuació si és més alta que l'actual.

    Paràmetres:
        ranking_str (str): Cadena que conté el rànquing de jugadors en format "nom:puntuació;nom:puntuació;"
        nom_jugador (str): Nom del jugador que s'afegirà o actualitzarà al rànquing.
        nova_puntuacio (int): Puntuació del jugador.

    Retorna:
        str: Retorna el rànquing actualitzat en format de cadena de text.

    Comportament:
        - Comprova si el jugador ja és al rànquing.
        - Si hi és, actualitza la seva puntuació només si la `nova_puntuacio` és més alta que l'actual.
        - Si no hi és, l'afegim amb la `nova_puntuacio`.

    Exemples:
        ranking_str = "pepe:150;Juan:100;"
        afegir_jugador(ranking_str, "Pablo", 50)
        Retorna: "pepe:150;Juan:100;Pablo:50;"

        afegir_jugador(ranking_str, "Juan", 120)
        Retorna: "pepe:150;Juan:120;"
    """
    jugadors = ranking_str.split(";") if ranking_str else []
    ranking_actualitzat = []
    jugador_actualitzat = False
    
    for jugador in jugadors:
        if not jugador: continue
        nom, puntuacio = jugador.split(":")
        puntuacio = int(puntuacio)
        
        if nom == nom_jugador:
            if nova_puntuacio > puntuacio:
                puntuacio = nova_puntuacio
            jugador_actualitzat = True
        ranking_actualitzat.append(f"{nom}:{puntuacio}")
    
    if not jugador_actualitzat:
        ranking_actualitzat.append(f"{nom_jugador}:{nova_puntuacio}")
    
    return ";".join(ranking_actualitzat)

def escollir_jugador(ranking_str):
    """
    Permet a l'usuari escollir un jugador existent del rànquing.

    Paràmetres:
        ranking_str (str): Cadena que conté el rànquing de jugadors en format "nom:puntuació;nom:puntuació;"

    Retorna:
        str: Retorna el nom del jugador escollit.

    Comportament:
        - Mostra una llista amb els noms dels jugadors disponibles.
        - L'usuari pot escollir un jugador introduint el número corresponent o escrivint el nom del jugador.
        - La funció no surt fins que es selecciona un jugador vàlid.
        - Retorna el nom del jugador seleccionat.

    Exemples:
        ranking_str = "pepe:150;Juan:100;"
        escollir_jugador(ranking_str)
        Retorna: "pepe" si l'usuari selecciona la primera opció o escriu "pepe".
    """
    if not ranking_str:
        print("No hi ha jugadors disponibles.")
        return None

    jugadors = [jugador for jugador in ranking_str.split(";") if jugador]  # Filtra elements buits
    while True:
        for i, jugador in enumerate(jugadors):
            nom, puntuacio = jugador.split(":")
            print(f"{i + 1}) {nom}")
        
        eleccio = input("\nEscull un jugador (número o nom): ").strip()

        if eleccio.isdigit():
            index = int(eleccio) - 1
            if 0 <= index < len(jugadors):
                return jugadors[index].split(":")[0]
            else:
                print("Número no vàlid, torna-ho a intentar.")
        else:
            for jugador in jugadors:
                nom, _ = jugador.split(":")
                if nom.lower() == eleccio.lower():
                    return nom
            print("Nom no vàlid, torna-ho a intentar.")

def mostrar_puntuacions(ranking_str):
    """
    Mostra les puntuacions actuals del rànquing de jugadors de manera ordenada.

    Paràmetres:
        ranking_str (str): Cadena que conté el rànquing de jugadors en format "nom:puntuació;nom:puntuació;"

    Retorna:
        None: Aquesta funció no retorna res.

    Comportament:
        - Ordena el rànquing segons les puntuacions de manera descendent.
        - Mostra el rànquing amb els noms dels jugadors i les seves puntuacions en format tabular.

    Exemples:
        ranking_str = "pepe:150;Juan:100;Pablo:50;"
        mostrar_puntuacions(ranking_str)
        Sortida:
        ················ Ranking ················
        NOM                                 PUNTS
        *****************************************
        pepe                                  150
        Juan                                  100
        Pablo                                  50
    """
    print("················ Ranking ················")
    print(f"{'NOM':<20} {'PUNTS':>20}")
    print("*****************************************")
    
    jugadors = ranking_str.split(";")
    ranking = [(j.split(":")[0], int(j.split(":")[1])) for j in jugadors if j]
    for nom, punts in sorted(ranking, key=lambda x: x[1], reverse=True):
        print(f"{nom:<20} {punts:>20}")

def jugar(jugador):
    """
    Simula una partida entre el jugador i l'ordinador. Es tiren dos daus cada torn, 50 vegades.

    Paràmetres:
        jugador (str): Nom del jugador participant a la partida.

    Retorna:
        int: Puntuació final del jugador, o -1 si ha guanyat l'ordinador.

    Comportament:
        - Es tiren dos daus per torn, durant 50 torns per al jugador i l'ordinador.
        - Si la suma dels daus és parell, s'afegeixen els punts del dau major.
        - Si la suma dels daus és imparell, es resten els punts del dau menor.
        - El jugador o l'ordinador amb més punts després de 50 tirades guanya.
        - Al final, es mostra qui ha guanyat i amb quina puntuació.

    Exemples:
        jugador = "pepe"
        jugar(jugador)
        Retorna: 150 si el jugador guanya, -1 si l'ordinador guanya.
    """
    punts_jugador = 0
    punts_ordinador = 0

    for _ in range(50):
        dau1, dau2 = random.randint(1, 6), random.randint(1, 6)
        if (dau1 + dau2) % 2 == 0:
            punts_jugador += max(dau1, dau2)
        else:
            punts_jugador -= min(dau1, dau2)

        dau1, dau2 = random.randint(1, 6), random.randint(1, 6)
        if (dau1 + dau2) % 2 == 0:
            punts_ordinador += max(dau1, dau2)
        else:
            punts_ordinador -= min(dau1, dau2)

    if punts_jugador > punts_ordinador:
        print(f"Ha guanyat el jugador \"{jugador}\" amb {punts_jugador} punts.")
    else:
        punts_jugador = -1
        print(f"Ha guanyat l'ordinador amb {punts_ordinador} punts.")

    return punts_jugador

def mainRun():
    """
    Mostra un menú principal per gestionar el joc de daus i permet interactuar amb les opcions del joc.

    Paràmetres:
        None: Aquesta funció no té paràmetres.

    Retorna:
        None: Aquesta funció no retorna res.

    Comportament:
        - Mostra les opcions disponibles: iniciar una nova partida, afegir un nou jugador, escollir un jugador, jugar, mostrar puntuacions o sortir del joc.
        - Si no hi ha jugadors al rànquing, l'opció d'escollir jugador no està disponible.
        - Si no s'ha escollit un jugador, l'opció de jugar no està disponible.
        - Es poden escollir les opcions del menú per número [0, 1, 2, 3, 4] o per text ['afegir', 'escollir', 'jugar', 'puntuacions', 'ranking', 'sortir'].

    Textos:
        "\nEscull una opció: ": Per escollir la opció del menú.
        "\nIntrodueix el nom del nou jugador: "
        "\nNo hi ha jugadors al rànquing. Afegiu-ne un primer."
        "\nNo s'ha escollit cap jugador."
        "Opció no vàlida."

    Exemples:
        Menú:
        1) Afegir jugador
        X) Escollir jugador
        X) Jugar ()
        4) Mostrar puntuacions
        0) Sortir

        Exemple després d'afegir un jugador:
        1) Afegir jugador
        2) Escollir jugador
        3) Jugar (Pedrito)
        4) Mostrar puntuacions
        0) Sortir
    """
    ranking_str = ""
    jugador_actual = ""
    
    while True:
        opcio_escollir = "2)" if ranking_str else "X)"
        opcio_jugar = "3)" if jugador_actual else "X)"
        
        print(f"\n1) Afegir jugador")
        print(f"{opcio_escollir} Escollir jugador")
        print(f"{opcio_jugar} Jugar ({jugador_actual})")
        print("4) Mostrar puntuacions")
        print("0) Sortir")
        
        opcio = input("\nEscull una opció: ")
        
        if opcio == '1' or opcio.lower() == 'afegir':
            nom_jugador = input("\nIntrodueix el nom del nou jugador: ")
            ranking_str = afegir_jugador(ranking_str, nom_jugador, 0)
        
        elif opcio == '2' or opcio.lower() == 'escollir':
            if ranking_str:
                jugador_actual = escollir_jugador(ranking_str)
            else:
                print("\nNo hi ha jugadors al rànquing. Afegiu-ne un primer.")
        
        elif opcio == '3' or opcio.lower() == 'jugar':
            if jugador_actual:
                punts_jugador = jugar(jugador_actual)
                if punts_jugador != -1:
                    ranking_str = afegir_jugador(ranking_str, jugador_actual, punts_jugador)
            else:
                print("\nNo s'ha escollit cap jugador.")
        
        elif opcio == '4' or opcio.lower() == 'puntuacions' or opcio.lower() == 'ranking':
            mostrar_puntuacions(ranking_str)
        
        elif opcio == '0' or opcio.lower() == 'sortir':
            break
        
        else:
            print("Opció no vàlida.")

if __name__ == "__main__":
    mainRun()