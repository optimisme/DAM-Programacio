
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

# Resol aquí l'exercici 0

"""

Exercici 1

Fes una funció 'e1_recorrer_txt' que llegeix l'arxiu 'E1.txt' i:

- Mostra linia a linia el contingut de les 3 primeres línies.

- Torna enrrera a la posició 25 del fitxer i mostra el contingut de les 2 següents línies.

- Salta al final del fixer i mostra les 3 últimer línies.

La funció rep com a paràmetre el nom de l'arxiu a llegir.

"""

# Resol aquí l'exercici 1

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

# Resol aquí l'exercici 2

"""

Exercici 3

Fes una funció e3_esborra, que esborra un arxiu d'una carpeta i totes les carpetes filles.
Paràmetres: nom de l'arxiu a esborrar, nom de la carpeta.

"""

# Resol aquí l'exercici 3

"""

Exercici 4

Fes una funció "e4_busca_arxius" que busca tots els arxius amb una extensió determinada dins d'una carpeta i les seves subcarpetes.
Paràmetres: extensió de l'arxiu a buscar, nom de la carpeta.

"""

# Resol aquí l'exercici 4

"""

Exercici 5

Fes la funció "e5_genera_carpetes" que a partir d'una cadena de text tipus així:

carpeta1/carpetaA/carpeta3, carpeta4/carpeta5, carpeta6, carpeta1/carpeta8/carpeta9, carpeta6/carpeta7, carpeta1/carpetaA/carpetaB

Generi les carpetes i subcarpetes especificades a la cadena de text.

"""

# Resol aquí l'exercici 5

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

# Resol aquí l'exercici 6