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

idxNom = 0
idxPunts = 1
ranking = ""
jugador = -1

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
def afegir_jugador():
    global ranking

    nom = ""
    while True:
        nom = input(f"Escull un nom: ")
        nomValid = True
        for cnt in range(0, len(nom)):
            lletra = nom[cnt]
            if not lletra.isalpha() and not lletra == " ":
                nomValid = False
                break # Sortir del for de lletres del nom
        if not nomValid:
            print("El nom escollit no és vàlid.")
        else:
            break # Sortir del while de nom vàlid

    rankingAfegir(nom, 0)

"""
-------------------------------------------------------------------------------
Exercici 1
-------------------------------------------------------------------------------

Fes la funció 'escollir_jugador' que permet escollir un jugador a partir
de la llista de jugadors que hi ha al ranking del joc
"""

# Fes aquí el codi de l'exercici 1
def escollir_jugador():
    global jugador

    error = ""
    jugador = -1
    while True:
        clear_screen()

        for i in range(rankingQuantitatJugadors()):
            print(f"{i + 1}: {rankingNom(i)}")

        if error != "":
            print(error)
            error = ""

        jugador = input("Escull un jugador: ")

        if not jugador.isdigit():
            error = f"Error, '{jugador}' no és un número"
        else:
            posicio = int(jugador) - 1
            if posicio < 0 or posicio >= rankingQuantitatJugadors():
                error = f"Error, '{posicio}' no és una posició vàlida"
            else:
                jugador = posicio
                break

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
def mostrar_puntuacions():
    global ranking

    clear_screen()
    print("··············· Ranking ···············")
    print("NOM                               PUNTS")
    print("***************************************")
    for i in range(0, rankingQuantitatJugadors()):
        textE = f"{rankingNom(i)}".ljust(19)
        textR = f"{rankingPuntuacio(i)}".rjust(20)
        print(f"{textE}{textR}")

    input("Prem 'intro' per tornar al menú ...")

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
def menu_principal():
    error = ""
    while True:
        disponibilitatJoc = "(no disponible)".rjust(16)
        nomJugador = "(no definit)".rjust(16)
        if jugador != -1:
            disponibilitatJoc = "".rjust(16)
            nomJugador = f"({rankingNom(jugador)})".rjust(16)

        if rankingQuantitatJugadors() == 0:
            nomJugador = "(no disponible)".rjust(16)

        clear_screen()
        print(f"""
1) Nova partida     {disponibilitatJoc}
2) Nou jugador
3) Escollir jugador {nomJugador}
4) Mostrar puntuacions
0) Sortir
        """)

        if error != "":
            print(error)
            error = ""

        opcio = input("Escull una opció [0, 4]: ")

        if opcio == "0":
            break
        elif opcio == "1":
            if jugador == -1:
                error = "Error, no has escollit cap jugador"
            else:
                jugar()
        elif opcio == "2":
            afegir_jugador()
        elif opcio == "3":
            if rankingQuantitatJugadors() == 0:
                error = "Error, no hi ha cap jugador al ranking"
            else:
                escollir_jugador()
        elif opcio == "4":
            mostrar_puntuacions()
        else:
            error = f"Error, '{opcio}' no és una opció vàlida"

# Funcions per gestionar el ranking en format text
def rankingAfegir(nom, puntuacio):
    global ranking
    ranking += f"{nom}:{puntuacio};"

def rankingQuantitatJugadors():
    global ranking
    count = 0
    i = 0
    for i in range(0, len(ranking)):
        if ranking[i] == ";":
            count += 1
    return count

def rankingNom(index):
    global ranking
    count = 0
    prev_end = -1  # -1 perquè al primer ";" agafi el substring des de 0
    
    for pos in range(len(ranking)):
        if ranking[pos] == ";":
            if count == index:
                start = prev_end + 1
                end = ranking.find(":", start)
                return ranking[start:end]
            prev_end = pos
            count += 1

def rankingPuntuacio(index):
    global ranking
    count = 0
    prev_colon = -1  # -1 perquè al primer ";" agafi el substring des de 0
    
    for pos in range(len(ranking)):
        if ranking[pos] == ";":
            if count == index:
                start = prev_colon + 1
                return int(ranking[start:pos])
            count += 1
        elif ranking[pos] == ":":
            prev_colon = pos


def rankingSetPuntuacio(index, punts):
    global ranking
    nom = rankingNom(index)
    punts_vells = rankingPuntuacio(index)
    ranking = ranking.replace(f"{nom}:{punts_vells}", f"{nom}:{punts}", 1)

def rankingOrdenar():
    global ranking
    # Ordenar la llista amb 'bubble sort'
    n = rankingQuantitatJugadors()
    
    for i in range(n):
        for j in range(0, n-i-1):
            puntuacio_j = rankingPuntuacio(j)
            puntuacio_j1 = rankingPuntuacio(j+1)
            
            if puntuacio_j < puntuacio_j1:
                # Intercanviar jugadors j i j+1 dins de la cadena
                nom_j = rankingNom(j)
                nom_j1 = rankingNom(j+1)
                
                start_j = ranking.find(f"{nom_j}:{puntuacio_j};")
                end_j = start_j + len(f"{nom_j}:{puntuacio_j};")
                
                start_j1 = ranking.find(f"{nom_j1}:{puntuacio_j1};")
                end_j1 = start_j1 + len(f"{nom_j1}:{puntuacio_j1};")
                
                if start_j < start_j1:  # Assegurem-nos d'eliminar i insertar en l'ordre correcte
                    ranking = ranking[:start_j] + ranking[end_j:start_j1] + f"{nom_j1}:{puntuacio_j1};" + ranking[end_j1:]
                    ranking = ranking[:start_j1-len(f"{nom_j}:{puntuacio_j};")] + f"{nom_j}:{puntuacio_j};" + ranking[start_j1:]
                else:
                    ranking = ranking[:start_j1] + ranking[end_j1:start_j] + f"{nom_j}:{puntuacio_j};" + ranking[end_j:]
                    ranking = ranking[:start_j-len(f"{nom_j1}:{puntuacio_j1};")] + f"{nom_j1}:{puntuacio_j1};" + ranking[start_j1:]

# Funcions per jugar

def tirar_daus():
    return random.randint(1, 6), random.randint(1, 6)

def calcular_puntuacio(dau1, dau2):
    if (dau1 + dau2) % 2 == 0:
        return max(dau1, dau2)
    else:
        major = max(dau1, dau2)
        menor = min(dau1, dau2)
        return major - menor

def jugar():
    global jugador
    global ranking

    puntuacio_jugador = 0
    puntuacio_maquina = 0

    for _ in range(50):
        dau1_jugador, dau2_jugador = tirar_daus()
        dau1_maquina, dau2_maquina = tirar_daus()

        puntuacio_jugador += calcular_puntuacio(dau1_jugador, dau2_jugador)
        puntuacio_maquina += calcular_puntuacio(dau1_maquina, dau2_maquina)

    if puntuacio_jugador > puntuacio_maquina:
        print(f"Ha guanyat '{rankingNom(jugador)}' amb {puntuacio_jugador} punts (Màquina: {puntuacio_maquina} punts)")
        punts_totals = rankingPuntuacio(jugador) + puntuacio_jugador
        rankingSetPuntuacio(jugador, punts_totals)

        rankingOrdenar()

    elif puntuacio_jugador < puntuacio_maquina:
        print(f"Ha perdut '{rankingNom(jugador)}' amb {puntuacio_jugador} punts (Màquina: {puntuacio_maquina} punts)")

    else:
        print(f"Empat amb {puntuacio_jugador} punts!")

    input("Prem 'intro' per continuar ...")
    jugador = -1

menu_principal()