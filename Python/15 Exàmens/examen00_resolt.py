import random
import string

usuaris = []

def generaDNI():
    """
    Aquesta funció genera un DNI espanyol aleatori.

    Paràmetres:
    - No té paràmetres d'entrada.

    Funcionament:
    - Genera una seqüència de 8 dígits aleatoris.
    - Calcula la lletra corresponent utilitzant el mòdul 23 del número generat 
      per seleccionar una lletra de la cadena "TRWAGMYFPDXBNJZSQVHLCKE".

    Retorn:
    - Retorna un string amb el número de 8 dígits seguit de la lletra que li correspon.

    Exemple:
    - "12345678Z"
    """
    lletres = "TRWAGMYFPDXBNJZSQVHLCKE"
    numeros = ''.join(random.choices(string.digits, k=8))
    lletra = lletres[int(numeros) % 23]
    return f"{numeros}{lletra}"

def generaId():
    """
    Aquesta funció genera un identificador aleatori.

    Paràmetres:
    - No té paràmetres d'entrada.

    Funcionament:
    - Genera una seqüència composta de:
      - Un dígit aleatori (0-9),
      - Una lletra majúscula aleatòria,
      - Dos dígits aleatoris més (0-9),
      - Una altra lletra majúscula aleatòria.

    Retorn:
    - Retorna un string amb l'identificador generat.

    Exemple:
    - "4A27B"
    """
    id = f"{random.randint(0, 9)}{random.choice(string.ascii_uppercase)}{random.randint(0, 9)}{random.randint(0, 9)}{random.choice(string.ascii_uppercase)}"
    return id

def generaUsuari():
    """
    Aquesta funció genera un usuari aleatori amb diverses dades associades.

    Paràmetres:
    - No té paràmetres d'entrada.

    Funcionament:
    - Selecciona un nom a l'atzar d'una llista de noms predefinits.
    - Genera una edat aleatòria entre 18 i 65 anys.
    - Genera un DNI mitjançant la funció `generaDNI()`.
    - Genera un o més torns d'accés aleatoris entre els valors 'mati', 'tarda' i 'nit'.
    - Genera un identificador únic per a l'usuari amb la funció `generaId()`.

    Retorn:
    - Retorna un diccionari que conté:
      - 'id': Identificador únic generat per l'usuari.
      - 'nom': Nom aleatori seleccionat.
      - 'edat': Edat generada.
      - 'dni': DNI generat.
      - 'acces': Llista de torns d'accés assignats aleatòriament.

    Exemple:
    - {'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati', 'tarda']}
    """
    noms = ['Andreu', 'Pere', 'Joan', 'Maria', 'Laura', 'Anna', 'Carles', 'Marta', 'Jordi', 'Gemma']
    edat = random.randint(18, 65)
    dni = generaDNI()
    acces = random.sample(['mati', 'tarda', 'nit'], k=random.randint(1, 3))
    usuari = {
        'id': generaId(),
        'nom': random.choice(noms),
        'edat': edat,
        'dni': dni,
        'acces': acces
    }
    return usuari

def afegirUsuari(usuari):
    """
    Aquesta funció afegeix un usuari a una llista global de usuaris.

    Paràmetres:
    - usuari: Diccionari que representa un usuari, amb dades com 'id', 'nom', 'edat', 'dni' i 'acces'.

    Funcionament:
    - Afegeix l'usuari passat com a paràmetre a la llista global `usuaris`.

    Retorn:
    - No retorna cap valor.

    Exemple:
    - afegirUsuari({'id': '4A27B', 'nom': 'Joan', 'edat': 45, 'dni': '12345678Z', 'acces': ['mati', 'tarda']})
    """
    usuaris.append(usuari)

def afegirUsuaris(n):
    """
    Aquesta funció genera i afegeix 'n' usuaris a la llista global de usuaris.

    Paràmetres:
    - n: Nombre d'usuaris a generar i afegir.

    Funcionament:
    - Per cada iteració, genera un nou usuari mitjançant la funció `generaUsuari()`.
    - Afegeix cadascun dels usuaris generats a la llista global `usuaris` mitjançant la funció `afegirUsuari()`.

    Retorn:
    - No retorna cap valor.

    Exemple:
    - afegirUsuaris(5) generarà i afegirà 5 usuaris.
    """
    for _ in range(n):
        afegirUsuari(generaUsuari())

def buscaUsuari(id):
    """
    Aquesta funció busca un usuari a la llista global 'usuaris' pel seu identificador 'id'.

    Paràmetres:
    - id: Identificador de l'usuari que es vol cercar (string).

    Funcionament:
    - Recorre la llista de usuaris.
    - Si troba un usuari amb l'identificador coincident, retorna la seva posició a la llista.
    - Si no el troba, imprimeix un missatge indicant que no s'ha trobat l'usuari i retorna -1.

    Retorn:
    - Retorna l'índex de l'usuari dins la llista si es troba.
    - Retorna -1 si l'usuari no es troba.

    Exemple:
    - buscaUsuari('4A27B') pot retornar 2 si l'usuari es troba en la tercera posició de la llista.
    """
    for i, usuari in enumerate(usuaris):
        if usuari['id'] == id:
            return i
    print(f"(buscaUsuari) No s'ha trobat l'usuari amb id '{id}'")
    return -1

def mostraUsuari(id):
    """
    Aquesta funció mostra la informació d'un usuari cercat pel seu identificador 'id'.

    Paràmetres:
    - id: Identificador de l'usuari que es vol mostrar (string).

    Funcionament:
    - Cerca l'usuari mitjançant la funció `buscaUsuari(id)`.
    - Si es troba l'usuari, imprimeix la seva informació.
    - Si no es troba, imprimeix un missatge indicant que l'usuari no existeix.

    Retorn:
    - No retorna cap valor.

    Exemple:
    - mostraUsuari('4A27B') mostrarà les dades de l'usuari amb aquest id.
    """
    index = buscaUsuari(id)
    if index != -1:
        print(f"(mostraUsuari) L'usuari amb id '{id}' és {usuaris[index]}")
    else:
        print(f"No s'ha trobat l'usuari amb id '{id}'")

def llistaUsuaris():
    """
    Aquesta funció mostra la informació de tots els usuaris de la llista global 'usuaris'.

    Paràmetres:
    - No té paràmetres d'entrada.

    Funcionament:
    - Recorre la llista global 'usuaris'.
    - Imprimeix la informació de cada usuari.

    Retorn:
    - No retorna cap valor.

    Exemple:
    - llistaUsuaris() mostrarà tots els usuaris emmagatzemats.
    """
    for usuari in usuaris:
        print(usuari)

def modificaUsuari(id, camp, valor):
    """
    Aquesta funció modifica un camp específic d'un usuari identificat per 'id'.

    Paràmetres:
    - id: Identificador de l'usuari a modificar (string).
    - camp: Nom del camp que es vol modificar (string).
    - valor: Nou valor que es vol assignar al camp (pot ser de qualsevol tipus).

    Funcionament:
    - Cerca l'usuari mitjançant la funció `buscaUsuari(id)`.
    - Si l'usuari existeix, canvia el valor del camp especificat pel nou valor.
    - Imprimeix un missatge indicant que la modificació s'ha realitzat correctament.
    - Si l'usuari no existeix, imprimeix un missatge d'error.

    Retorn:
    - No retorna cap valor.

    Exemple:
    - modificaUsuari('4A27B', 'edat', 30) canviarà l'edat de l'usuari amb aquest id a 30.
    """
    index = buscaUsuari(id)
    if index == -1:
        print(f"(modificaUsuari) Error, l'usuari '{id}' no existeix")
    else:
        usuari = usuaris[index]
        valor_ant = usuari[camp]
        usuari[camp] = valor
        print(f"(modificaUsuari) S'ha modificat l'usuari '{id}', s'ha canviat el camp '{camp}': '{valor_ant}' > '{valor}'")

def esborraUsuari(id):
    """
    Aquesta funció esborra un usuari de la llista global 'usuaris' identificat pel seu 'id'.

    Paràmetres:
    - id: Identificador de l'usuari a esborrar (string).

    Funcionament:
    - Cerca l'usuari mitjançant la funció `buscaUsuari(id)`.
    - Si l'usuari existeix, l'elimina de la llista global 'usuaris'.
    - Imprimeix un missatge indicant que l'usuari s'ha esborrat correctament.
    - Si l'usuari no existeix, imprimeix un missatge d'error.

    Retorn:
    - No retorna cap valor.

    Exemple:
    - esborraUsuari('4A27B') eliminarà l'usuari amb aquest id de la llista.
    """
    index = buscaUsuari(id)
    if index == -1:
        print(f"(esborraUsuari) Error, l'usuari '{id}' no existeix")
    else:
        usuaris.pop(index)
        print(f"(esborraUsuari) S'ha esborrat l'usuari '{id}'")

def buscaAcces(tipus):
    """
    Aquesta funció busca usuaris que tinguin un tipus d'accés específic.

    Paràmetres:
    - tipus: Tipus d'accés que es vol cercar (string), per exemple 'mati', 'tarda' o 'nit'.

    Funcionament:
    - Recorre la llista global 'usuaris' i comprova si el tipus d'accés especificat es troba
      en la llista d'accés de cada usuari.
    - Crea una llista amb els identificadors dels usuaris que tenen l'accés especificat.
    - Imprimeix els identificadors dels usuaris que tenen l'accés.

    Retorn:
    - Retorna una llista amb els identificadors dels usuaris que tenen l'accés especificat.

    Exemple:
    - buscaAcces('mati') retornarà els ids dels usuaris que tenen accés al torn de matí.
    """
    ids = [usuari['id'] for usuari in usuaris if tipus in usuari['acces']]
    print(f"(buscaAcces) Els usuaris amb accés '{tipus}' són: {ids}")
    return ids

def ordenaUsuaris(camp):
    """
    Aquesta funció ordena i mostra els usuaris de la llista global 'usuaris' segons el camp especificat.

    Paràmetres:
    - camp: El camp pel qual es vol ordenar els usuaris (string), com ara 'nom', 'edat', 'dni', etc.

    Funcionament:
    - Utilitza la funció `sorted()` per ordenar la llista 'usuaris' basant-se en el camp especificat.
    - Mostra els usuaris ordenats.

    Retorn:
    - No retorna cap valor.

    Exemple:
    - ordenaUsuaris('edat') mostrarà els usuaris ordenats per edat de menor a major.
    """
    usuaris_ordenats = sorted(usuaris, key=lambda x: x[camp])
    for usuari in usuaris_ordenats:
        print(usuari)

def mainRun():
    """
    Aquesta funció mostra un menú interactiu per gestionar els usuaris del sistema SuperGym.

    Opcions del menú:
    1 - Afegir usuari aleatori: Genera un nou usuari aleatori i l'afegeix a la llista.
    2 - Buscar usuari: Cerca un usuari pel seu identificador.
    3 - Mostrar usuari: Mostra la informació d'un usuari pel seu identificador.
    4 - Llistar usuaris: Llista tots els usuaris actuals.
    5 - Modificar usuari: Modifica un camp específic d'un usuari.
    6 - Esborrar usuari: Esborra un usuari pel seu identificador.
    7 - Buscar accés: Cerca usuaris amb un tipus d'accés específic.
    8 - Ordenar: Ordena els usuaris pel camp indicat.
    0 - Sortir: Surt del menú.

    Funcionament:
    - Requereix l'entrada de l'usuari per seleccionar una opció del menú.
    - Executa la funció corresponent a cada opció.
    """
    while True:
        print("""
        SuperGym
        1 - Afegir usuari aleatori
        2 - Buscar usuari
        3 - Mostrar usuari
        4 - Llistar usuaris
        5 - Modificar usuari
        6 - Esborrar usuari
        7 - Buscar accés
        8 - Ordenar
        0 - Sortir
        """)
        opcio = input("Tria una opció: ")

        if opcio == '1':
            afegirUsuari(generaUsuari())
        elif opcio == '2':
            id = input("Entra l'id de l'usuari: ")
            buscaUsuari(id)
        elif opcio == '3':
            id = input("Entra l'id de l'usuari: ")
            mostraUsuari(id)
        elif opcio == '4':
            llistaUsuaris()
        elif opcio == '5':
            id = input("Entra l'id de l'usuari: ")
            camp = input("Entra el camp que vols modificar: ")
            valor = input(f"Entra el nou valor per a {camp}: ")
            modificaUsuari(id, camp, valor)
        elif opcio == '6':
            id = input("Entra l'id de l'usuari: ")
            esborraUsuari(id)
        elif opcio == '7':
            tipus = input("Entra el tipus d'accés (mati, tarda, nit): ")
            buscaAcces(tipus)
        elif opcio == '8':
            camp = input("Entra el camp pel qual vols ordenar: ")
            ordenaUsuaris(camp)
        elif opcio == '0':
            break

if __name__ == "__main__":
    mainRun()
