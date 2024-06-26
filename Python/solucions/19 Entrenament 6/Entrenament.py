
# Fer anar els testos amb:
# python "Test.py"
# python "Test e5.py"
import pickle
from pprint import pprint

"""

Exercici 0

Fes una funció 'e0_llegir_csv' que llegeix l'arxiu 'E0.csv' linia per linia i mostra la informació per pantalla amb el número de línia al davant (començant per 0).
La funció rep com a paràmetre el nom de l'arxiu a llegir.

Fes una funció 'e0_tranforma_csv' que llegeix l'arxiu 'E0.csv' en un array de dades, on cada camp és un element d'un array, i cada línia també forma part d'un array.
La funció 'e0_transforma_csv' ha de modificar els anys de vida de cada animal incrementant-los en un 10%. Per exemple, si un animal viu 20 anys, després de l'actualització hauria de viure 22 anys (20 * 1.10).
La funció rep dos paràmetres: el nom de l'arxiu a llegir i el percentatge d'increment.
La funció retorna les dades actualitzades.

Fes una funció 'e0_guardar_csv' que fa servir la funció anterior, per guardar l'arxiu 'E0-out.csv' amb les dades actualitzades.
La funció rep com a paràmetres les dades actualitzades i el nom de l'arxiu de sortida.

"""

def e0_llegir_csv(nom_arxiu):
    with open(nom_arxiu, mode='r', encoding='utf-8') as arxiu:
        for i, linea in enumerate(arxiu):
            fila = linea.strip().split(',')  # Divideix cada línia per la coma
            print(f'{i}: {fila}')

def e0_transforma_csv(nom_arxiu, increment_percentatge):
    dades_actualitzades = []
    with open(nom_arxiu, mode='r', encoding='utf-8') as arxiu:
        capçalera = arxiu.readline().strip().split(',')  # Llegeix la primera línia per la capçalera
        dades_actualitzades.append(capçalera)
        for linea in arxiu:
            fila = linea.strip().split(',')
            if fila[2].isdigit():  # Suposem que l'índex de l'any de vida és 2
                fila[2] = str(round(float(fila[2]) * (1 + increment_percentatge / 100)))  # Actualitzem anys de vida
            dades_actualitzades.append(fila)
    return dades_actualitzades

def e0_guardar_csv(dades_actualitzades, nom_arxiu_sortida):
    with open(nom_arxiu_sortida, mode='w', encoding='utf-8') as arxiu:
        for fila in dades_actualitzades:
            linea = ','.join(fila)  # Converteix l'array de la fila en una cadena separada per comes
            arxiu.write(linea + '\n')  # Afegeix un salt de línia al final de cada fila

"""

Exercici 1

Fes una funció 'e1_recorrer_txt' que llegeix l'arxiu 'E1.txt' i:

- Mostra linia a linia el contingut de les 3 primeres línies.

- Torna enrrera a la posició 25 del fitxer i mostra el contingut de les 2 següents línies.

- Salta al final del fixer i mostra les 3 últimer línies.

La funció rep com a paràmetre el nom de l'arxiu a llegir.

"""

def e1_recorrer_txt(file_path):
    # Obrim l'arxiu per llegir
    with open(file_path, 'r') as file:
        # Mostrem linia a linia el contingut de les 3 primeres línies
        for i in range(3):
            print(file.readline().strip())
        
        # Tornem enrere a la posició 25 del fitxer
        file.seek(25)
        # Mostrem el contingut de les 2 següents línies
        for i in range(2):
            print(file.readline().strip())
        
        # Saltem al final del fitxer per mostrar les 3 últimes línies
        # Com que no sabem la longitud del fitxer, llegim tot i agafem les últimes 3 línies
        file.seek(0)
        lines = file.readlines()
        for line in lines[-3:]:
            print(line.strip())


"""

Exercici 2

Fes una funció 'e2_combina_arxius' que llegeixi els arxius 'E2a.txt' i 'E2b.txt' i mostri per pantalla el contingut de tots dos arxius d'aquesta manera:
La funció rep com a paràmetres els noms dels dos arxius a llegir.

primera línia de E2a.txt-última línia de E2b.txt
penúltima línia de E2b.txt-segona línia de E2a.txt

... fins a ...

última línia de E2a.txt-primera línia de E2b.txt
primera línia de E2b.txt-última línia de E2a.txt

segons si són linies parelles o senars.

"""

def e2_combina_arxius(path_a, path_b):
    # Obrim els dos arxius i llegim les seves línies
    with open(path_a, 'r') as file_a, open(path_b, 'r') as file_b:
        lines_a = file_a.readlines()
        lines_b = file_b.readlines()

    # Invertim les línies de l'arxiu B per a facilitar la combinació
    lines_b = lines_b[::-1]

    # Obtenim el nombre màxim de línies entre els dos arxius per a iterar
    max_len = max(len(lines_a), len(lines_b))

    # Iterem sobre el rang del nombre màxim de línies
    for i in range(max_len):
        # Obtenim la línia de cada arxiu segons la posició actual
        # Usant condicionals per evitar errors si un arxiu és més curt
        line_a = lines_a[i].strip() if i < len(lines_a) else ""
        line_b = lines_b[i].strip() if i < len(lines_b) else ""

        # Decidim quina combinació de línies mostrar segons si l'índex és parell o senar
        if i % 2 == 0:
            # Per índexs parells: primera línia de A - última línia de B
            print(f"{line_a}-{line_b}")
        else:
            # Per índexs senars: penúltima línia de B - segona línia de A
            print(f"{line_b}-{line_a}")

"""

Exercici 3

Fes una funció e3_esborra, que esborra un arxiu d'una carpeta i totes les carpetes filles.
Paràmetres: nom de l'arxiu a esborrar, nom de la carpeta.

"""

import os

def e3_esborra(nom_arxiu, directori_inicial='.'):
    arxiu_esborrat = False

    def esborrar_arxiu(directori):
        nonlocal arxiu_esborrat
        for element in os.listdir(directori):
            cami_complet = os.path.join(directori, element)
            if os.path.isdir(cami_complet):
                esborrar_arxiu(cami_complet)
            elif element == nom_arxiu:
                try:
                    os.remove(cami_complet)
                    print(f"L'arxiu '{cami_complet}' ha estat esborrat amb èxit.")
                    arxiu_esborrat = True
                except Exception as e:
                    print(f"S'ha produït un error en intentar esborrar l'arxiu '{cami_complet}': {e}")

    esborrar_arxiu(directori_inicial)

    if not arxiu_esborrat:
        print(f"L'arxiu '{nom_arxiu}' no s'ha trobat en cap carpeta.")


"""

Exercici 4

Fes una funció "e4_busca_arxius" que busca tots els arxius amb una extensió determinada dins d'una carpeta i les seves subcarpetes.
Paràmetres: extensió de l'arxiu a buscar, nom de la carpeta.

"""

import os

def e4_busca_arxius(extensio, carpeta):
    arxius_trobats = []

    def busca_arxius(directori):
        for element in os.listdir(directori):
            cami_complet = os.path.join(directori, element)
            if os.path.isdir(cami_complet):
                busca_arxius(cami_complet)
            elif element.endswith(extensio):
                arxius_trobats.append(cami_complet)

    busca_arxius(carpeta)
    return arxius_trobats

"""

Exercici 5

Fes la funció "e5_genera_carpetes" que a partir d'una cadena de text tipus així:

carpeta1/carpetaA/carpeta3, carpeta4/carpeta5, carpeta6, carpeta1/carpeta8/carpeta9, carpeta6/carpeta7, carpeta1/carpetaA/carpetaB

Generi les carpetes i subcarpetes especificades a la cadena de text.

"""

import os

def e5_genera_carpetes(cadena):
    # Separar les carpetes i subcarpetes per comes
    carpetes = cadena.split(",")
    
    # Crear les carpetes i subcarpetes especificades
    for carpeta in carpetes:
        # Eliminar els espais al principi i final de la cadena
        carpeta = carpeta.strip()
        
        # Crear la carpeta si no existeix
        if not os.path.exists(carpeta):
            os.makedirs(carpeta)

"""

Exercici 6

Fes una funció "e6_guarda_arxiu_bin" que guarda una estructura de dades complexa en un arxiu binari.

Fes una funció "e6_llegeix_arxiu_bin" que llegeix l'arxiu binari i mostra per pantalla el contingut amb el format de l'exemple.

Prova-ho amb una estructura així:

{
    "nom": "Pepito",
    "edat": 25,
    "adreça": {
        "carrer": "Carrer de la Falsa",
        "número": 123,
        "població": "Falsburg"
    },
    aficions: ["futbol", "tennis", "cine"],
    "dades_extra": {
        "altura": 1.75,
        "pes": 70
    }
}

"""

def e6_guarda_arxiu_bin(dades, nom_arxiu):
    with open(nom_arxiu, 'wb') as arxiu:
        pickle.dump(dades, arxiu)

def e6_llegeix_arxiu_bin(nom_arxiu):
    with open(nom_arxiu, 'rb') as arxiu:
        dades = pickle.load(arxiu)
        pprint(dades)
