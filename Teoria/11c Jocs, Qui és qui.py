import os
import platform
import random

"""
Jocs, Qui és qui

En aquest apartat, farem una versió del joc de "Qui és qui".

- El joc consisteix en que cada jugador escull un personatge a l'atzar

- Cada jugador té un tauler amb els personatges

- Cada jugador ha d'endevinar el personatge de l'altre jugador

- Els jugadors es van provant caselles del rival fins que endevinen el personatge

- Qui endevina el personatge de l'altre jugador primer, guanya

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

Fes una funció "genera_noms" que retorna:

* Un array amb els noms: 

  Phillip, Susan, Herman, Anne, Claire, Richard, Tom, Max, Sam, Anita, Joe, Maria

* Els noms han d'estar barrejats aleatòriament
* Retorna la baralla (aleatòria) generada

"""
# Fes aquí el codi de l'exercici 0

"""
-------------------------------------------------------------------------------
Exercici 1
-------------------------------------------------------------------------------

Fes una funció "escull_carta" que:

* Genera una baralla amb la funció "genera_noms"
* Retorna la última carta de la baralla.

"""
# Fes aquí el codi de l'exercici 1

"""
-------------------------------------------------------------------------------
Exercici 2
-------------------------------------------------------------------------------

Fes una funció "genera_tauler" que retorna:

* Recull els noms de la funció "genera_noms"
* Crea un array de 3x4 amb els noms, per exemple: 

    Phillip, Susan, Herman, Anne
    Claire, Richard, Tom, Max
    Sam, Anita, Joe, Maria

(És un exemple, perquè els noms han d'estar barrejats aleatòriament)
"""
# Fes aquí el codi de l'exercici 2

"""
-------------------------------------------------------------------------------
Exercici 3
-------------------------------------------------------------------------------

Fes una funció "genera_partida" que retorna un array amb:

* Posició 0, personatge de l'usuari (segons "escull_carta")
* Posició 1, personatge de l'ordinador (segons "escull_carta")
* Posició 2, tauler de l'usuari (segons "genera_tauler")
* Posició 3, tauler de l'ordinador (segons "genera_tauler")

"""
# Fes aquí el codi de l'exercici 3

"""
-------------------------------------------------------------------------------
Exercici 4
-------------------------------------------------------------------------------

Fes una funció "escriu_nom" que retorna un nom escrit per l'usuari i que:

* Cada vegada que l'usuari fa un intent d'escriure el nom apareix: 
    "Escriu el teu nom: "

* Ho ha de demanar fins que el nom sigui vàlid
* No s'accepten números
* Quan s'ha escollit un nom vàlid, la funció retorna el nom
    
Perquè quedi clar:

* "Albert" és un nom vàlid
* "[Albert!" és un nom vàlid
* "Albert33" no és un nom vàlid

"""
# Fes aquí el codi de l'exercici 4

"""
-------------------------------------------------------------------------------
Exercici 5
-------------------------------------------------------------------------------

Fes una funció "selecciona_oponent" que retorna un oponent escollit per l'usuari:

* Cada vegada que l'usuari fa un intent d'escriure el nom apareix: 
    "Romulus, Tarpeia, Horatius, Cloelia, Brutus, Lucretia"
    "Selecciona l'oponent: "

* Si no s'escull un nom vàlid:
  - Es neteja la pantalla
  - Torna a sortira la llista de noms
  - Surt un missatge d'error
  - Es torna a demanar "Seleciona l'oponent: "

* Ho ha de demanar fins que el nom sigui vàlid
* Quan s'ha escollit un nom vàlid, la funció retorna el nom

"""
# Fes aquí el codi de l'exercici 5

"""
-------------------------------------------------------------------------------
Exercici 6
-------------------------------------------------------------------------------

Fes una funció "dibuixa_tauler_secret" que:

* Mostra el tauler de l'oponent així:
  0 1 2 3 
A X ? ? X
B ? X ? X
C X X ? X

* On X és una posició borrada (que ja s'ha descobert)
* On ? és una posició per descobrir

"""
# Fes aquí el codi de l'exercici 6

"""
-------------------------------------------------------------------------------
Exercici 7
-------------------------------------------------------------------------------

Fes una funció "fila_columna" que:

* A partir d'una posició tipus "A0" retorni la fila i la columna
* Si la posició no és vàlida retorna -1

Fes una funció "posicio_valida" que:

* Rep una posició (per exemple A0)
* Retorna True si la posició és vàlida (i no s'ha descobert/borrat)
* Retorna False si la posició no és vàlida

"""
# Fes aquí el codi de l'exercici 7

"""
-------------------------------------------------------------------------------
Exercici 8
-------------------------------------------------------------------------------

Fes una funció "jugada_usuari" que:

* Dibuixa el tauler de l'oponent amb la funció "dibuixa_tauler_secret"
* L'usuari ha d'escriure una posició:
    "Escriu la posició a descobrir (per exemple A0): "
* Si la posició no és vàlida:
  - Es torna a dibuixar el tauler secret de l'oponent
  - Es torna a demnara la posició
* Si la posició és vàlida, la funció retorna el personatge de la posició
  
"""
# Fes aquí el codi de l'exercici 8

"""
-------------------------------------------------------------------------------
Exercici 9
-------------------------------------------------------------------------------

Fes una funció "jugada_oponent" que:

* Mostra el tauler secret de l'usuari
* Escull aleatòriament una posició del tauler de l'usuari
* Si la posició no és vàlida se n'escull una altre
* Si la posició és vàlida, la funció retorna el personatge de la posició

"""
# Fes aquí el codi de l'exercici 9

"""
-------------------------------------------------------------------------------
Exercici 10
-------------------------------------------------------------------------------

Fes una funció "esborra_del_tauler" que rep un "nom" de personatge, el busca al tauler i el posa a ""

Fes una funció "joc_del_qui_es_qui" que:

- Genera una partida amb la funció "genera_partida"

- Comença el joc, que no acaba fins que hi ha un guanyador (while)
    - Primer jua el jugador
        - Fa una jugada amb la funció (jugada_usuari)
        - Si el jugador ha endevinat el personatge de l'oponent acaba el joc
    - Després juga l'ordinador
        - Fa una jugada amb la funció (jugada_oponent)
        - Si l'ordinador ha endevinat el personatge de l'usuari acaba el joc
- Escriu qui ha guanyat

"""
# Fes aquí el codi de l'exercici 10

"""
-------------------------------------------------------------------------------
Exercici 11
-------------------------------------------------------------------------------

Fes una funció "mostra_menu" que mostra aquest menú:

Qui és qui?
1) Escull el teu nom
2) Escull el nom de l'oponent
3) Juga
0) Sortir
Escull una opció:

* L'opció 0 surt del programa
* L'opció 1 crida la funció "escriu_nom"
* L'opció 2 crida la funció "selecciona_oponent"
* L'opció 3 crida la funció "joc_del_qui_es_qui"

    - Si no s'ha escollit el nom o l'oponent:
        - Es neteja la pantalla
        - Torna a mostrar el menú
        - Mostra un missatge d'error
        - Torna a demanar una opció
    - Si s'ha escollit el nom i l'oponent, comença el joc
* Quan acaba el joc es mostra el guanyador, i el menú

"""
# Fes aquí el codi de l'exercici 11


# Finalment, crida la funció "mostra_menu()" per començar el programa