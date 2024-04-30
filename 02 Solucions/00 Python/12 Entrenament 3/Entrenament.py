import random

# Executa el test amb
# python "11i TestEntrenament exàmen.py"

"""
Pregunta 0
Fes una funció 'generaDNI' que generi un DNI vàlid de manera aleatòria
"""
def genera_dni():
    lletres_dni = ["T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"]
    numero = random.randint(0, 99999999)
    lletra = lletres_dni[numero % 23]
    return f"{numero:08d}-{lletra}"

"""
Pregunta 1
Fes una funció 'generaId' que generi un ID aleatòri tenint en compte:

- Comença amb un número entre [0, 9] inclòssos
- Segueix amb una lletra entre [A, Z] inclòssos (la ñ no)
- Sequeix amb 2 números entre [0, 9] inclòssos
- Segueix amb una lletra entre [A, Z] inclòssos (la ñ no)

Per exemple: 3H23J
Ha d'escriure: S'ha generat l'Id: 3H23J
"""
def genera_id():
    numero = str(random.randint(0, 9))
    lletra1 = random.choice('ABCDEFGHIJKLMNOPQRSTUVWXYZ')
    numeros = ''.join(str(random.randint(0, 9)) for _ in range(2))
    lletra2 = random.choice('ABCDEFGHIJKLMNOPQRSTUVWXYZ')
    return numero + lletra1 + numeros + lletra2

"""
Pregunta 2
Tenint en compte el següent diccionari:
{
    'id': '3H23J' ,  
    'nom':  'Andreu',  
    'edat': 25,
    'dni': '32465876-L',
    'acces': ['mati','tarda','nit']
}
Fes una funció 'generaUsuari' que generi usuaris aleatoris. Tingues en compte que:

- L'id ha de fer servir la funció 'generaId' per generar el ID
- El nom ha de ser aleatori d'una llista d'almenys 10 noms
- L'edat ha de ser aleatori entre 18 i 65 anys
- El DNI ha de fer servir la funció 'generaDNI' per generar el DNI
- L'accés ha de ser una llista amb un o més elements: ['mati','tarda','nit'] no repetits
"""
def genera_usuari():
    noms = ["Adrián", "Marc", "Joel", "Pablo", "Albert", "Ainara", "Maria", "Josefa", "Maricarmen", "Montserrat"]
    acces_permesos = ["mati", "tarda", "nit"]
    acces = random.sample(acces_permesos, random.randint(1, len(acces_permesos)))
    return {
        'id': genera_id(),
        'nom': random.choice(noms),
        'edat': random.randint(18, 65),
        'dni': genera_dni(),
        'acces': acces
    }

"""
Pregunta 3
Tenint en compte l'anterior diccionari.

Fes una funció 'afegirUsuari(usuari)' que afegeixi un usuari a una llista d'usuaris global 'usuaris'.
Fes una funció 'afegirUsuaris(n)' que afegeixi 'n' usuaris a la llista d'usuaris global 'usuaris'.
"""
usuaris = []

def afegir_usuari(usuari):
    usuaris.append(usuari)

def afegir_usuaris(n):
    for _ in range(n):
        afegir_usuari(genera_usuari())

"""
Pregunta 4
Tenint en compte l'anterior diccionari.

Fes una funció 'buscaUsuari(id)' que retorna l'índex de l'usuari amb l'id indicat.

- Si no el troba retorna -1
- Si no el troba ha d'escriure: (buscaUsuari) No s'ha trobat l'usuari amb id '3H23J'
"""
def busca_usuari(id_buscat):
    for index, usuari in enumerate(usuaris):
        if usuari["id"] == id_buscat:
            return index
    return -1


"""
Pregunta 6
Fes una funció 'llistaUsuaris' que permeti llistar els usuaris de la llista 'usuaris'
Ha d'escriure la llista d'usuaris, cada un en una línia
"""
def mostra_usuari(id_buscat):
    index = busca_usuari(id_buscat)
    if index != -1:
        print(f"(mostraUsuari) L'usuari amb id '{id_buscat}' és {usuaris[index]}")
    else:
        print(f"No s'ha trobat l'usuari amb id '{id_buscat}'")

"""
Pregunta 5
Tenint en compte l'anterior diccionari.

Fes una funció 'mostraUsuari(id') que mostra la informació de l'usuari amb aquell 'id'

- Si no el troba ha d'escriure: No s'ha trobat l'usuari amb id '3H23J'
- Ha d'escriure: (mostraUsuari) L'usuari amb id '3H23J' és {'id': '3H23J' , 'nom':  'Andreu', 'edat': 25, 'dni': '32465876-L', 'acces': ['mati','tarda','nit']}
"""
def llista_usuaris():
    for usuari in usuaris:
        print(usuari)

"""
Pregunta 7
Fes una funció 'modificaUsuari(id, camp, valor)' que permeti modificar un usuari de la llista 'usuaris'.

Tingues en compte que:

- S'ha de modificar l'usuari amb el qual coincideix l'id
- S'ha de modificar el camp 'camp' amb el nou valor

Si l'usuari no existeix ha d'escriure: (modificaUsuari) Error, l'usuari 'ABCD' no existeix
Si es modifica ha d'escriure: (modificaUsuari) S'ha modificar l'usuari '3H23J', s'ha canviat el camp 'nom': 'Pere' > 'Pau'
"""
def modifica_usuari(id_buscat, camp, valor):
    index = busca_usuari(id_buscat)
    if index != -1:
        usuari = usuaris[index]
        antic_valor = usuari.get(camp)
        usuari[camp] = valor
        print(f"(modificaUsuari) S'ha modificar l'usuari '{id_buscat}', s'ha canviat el camp '{camp}': '{antic_valor}' > '{valor}'")
    else:
        print(f"(modificaUsuari) Error, l'usuari '{id_buscat}' no existeix")

"""
Pregunta 8
Fes una funció 'esborraUsuari(id)' que permeti esborrar un usuari de la llista 'usuaris'.

Tingues en compte que:
- S'ha d'esborrar l'usuari amb el qual coincideix l'id
- Si l'usuari no existeix ha d'escriure: (esborraUsuari) Error, l'usuari 'ABCD' no existeix
- Si s'esborra ha d'escriure: (esborraUsuari) S'ha esborrat l'usuari '3H23J'
"""
def esborra_usuari(id_buscat):
    index = busca_usuari(id_buscat)
    if index != -1:
        del usuaris[index]
        print(f"(esborraUsuari) S'ha esborrat l'usuari '{id_buscat}'")
    else:
        print(f"(esborraUsuari) Error, l'usuari '{id_buscat}' no existeix")

"""
Pregunta 9
Fes una funció 'buscaAcces(tipus)' que busqui tots els usuari que tenen l'acces 'tipus'

Per exemple buscaAcces('mati') ha de tornar tots els usuaris que 
poden accedir de matí retorna la llista amb els ids dels usuaris que tenen aquell accés

Ha d'escriure: (buscaAcces) Els usuaris amb acces 'mati' són: ['3H23J', '4H23J']
"""
def busca_acces(tipus_acces):
    ids = [usuari["id"] for usuari in usuaris if tipus_acces in usuari["acces"]]
    print(f"(buscaAcces) Els usuaris amb acces '{tipus_acces}' són: {ids}")
    return ids

"""
Pregunta 10
Fes una funció 'ordenaUsuaris(camp)' que escrigui la llista d'usuaris ordenada segons el camp indicat.
"""
def ordena_usuaris(camp):
    usuaris_ordenats = sorted(usuaris, key=lambda usuari: usuari.get(camp))
    for usuari in usuaris_ordenats:
        print(usuari)

"""
Pregunta 11

Fes un programa, amb el següent menú, per gestionar la llista d'usuaris anterior:
```text
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
```
El programa demanarà les opcions necessàries en cada cas i permetrà tornar al menú principal
"""
def menu():
    return