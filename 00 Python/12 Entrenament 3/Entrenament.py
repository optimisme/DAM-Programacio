import random

# Executa el test amb
# python "11i TestEntrenament exàmen.py"

"""
Pregunta 0
Fes una funció 'generaDNI' que generi un DNI vàlid de manera aleatòria
"""


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


"""
Pregunta 3
Tenint en compte l'anterior diccionari.

Fes una funció 'afegirUsuari(usuari)' que afegeixi un usuari a una llista d'usuaris global 'usuaris'.
Fes una funció 'afegirUsuaris(n)' que afegeixi 'n' usuaris a la llista d'usuaris global 'usuaris'.
"""


"""
Pregunta 4
Tenint en compte l'anterior diccionari.

Fes una funció 'buscaUsuari(id)' que retorna l'índex de l'usuari amb l'id indicat.

- Si no el troba retorna -1
- Si no el troba ha d'escriure: (buscaUsuari) No s'ha trobat l'usuari amb id '3H23J'
"""



"""
Pregunta 6
Fes una funció 'llistaUsuaris' que permeti llistar els usuaris de la llista 'usuaris'
Ha d'escriure la llista d'usuaris, cada un en una línia
"""


"""
Pregunta 5
Tenint en compte l'anterior diccionari.

Fes una funció 'mostraUsuari(id') que mostra la informació de l'usuari amb aquell 'id'

- Si no el troba ha d'escriure: No s'ha trobat l'usuari amb id '3H23J'
- Ha d'escriure: (mostraUsuari) L'usuari amb id '3H23J' és {'id': '3H23J' , 'nom':  'Andreu', 'edat': 25, 'dni': '32465876-L', 'acces': ['mati','tarda','nit']}
"""


"""
Pregunta 7
Fes una funció 'modificaUsuari(id, camp, valor)' que permeti modificar un usuari de la llista 'usuaris'.

Tingues en compte que:

- S'ha de modificar l'usuari amb el qual coincideix l'id
- S'ha de modificar el camp 'camp' amb el nou valor

Si l'usuari no existeix ha d'escriure: (modificaUsuari) Error, l'usuari 'ABCD' no existeix
Si es modifica ha d'escriure: (modificaUsuari) S'ha modificar l'usuari '3H23J', s'ha canviat el camp 'nom': 'Pere' > 'Pau'
"""


"""
Pregunta 8
Fes una funció 'esborraUsuari(id)' que permeti esborrar un usuari de la llista 'usuaris'.

Tingues en compte que:
- S'ha d'esborrar l'usuari amb el qual coincideix l'id
- Si l'usuari no existeix ha d'escriure: (esborraUsuari) Error, l'usuari 'ABCD' no existeix
- Si s'esborra ha d'escriure: (esborraUsuari) S'ha esborrat l'usuari '3H23J'
"""


"""
Pregunta 9
Fes una funció 'buscaAcces(tipus)' que busqui tots els usuari que tenen l'acces 'tipus'

Per exemple buscaAcces('mati') ha de tornar tots els usuaris que 
poden accedir de matí retorna la llista amb els ids dels usuaris que tenen aquell accés

Ha d'escriure: (buscaAcces) Els usuaris amb acces 'mati' són: ['3H23J', '4H23J']
"""



"""
Pregunta 10
Fes una funció 'ordenaUsuaris(camp)' que escrigui la llista d'usuaris ordenada segons el camp indicat.
"""



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
