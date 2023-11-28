

# Executa el test amb
# python "12b TestRecursivitat.py"

"""
Pregunta 0

Fes la funció recursiva 'fraseLletraFinal(frase, lletra)' 
que donada una frase i una lletra, retorna la frase des de la lletra fins al final.
Per exemple:
"Test", "s" = "st"
"""

def fraseLletraFinal(frase, lletra):
    if frase == "" or lletra not in frase:
        return ""
    if lletra == frase[0]:
        return frase
    else:
        return fraseLletraFinal(frase[1:], lletra)

"""
Pregunta 1

Fes la funció recursiva 'fraseLletraInicial(frase, lletra)' 
que donada una frase i una lletra, retorna la frase des del principi fins a la lletra.
Per exemple:
"Test", "e" = "Te"
"""

def fraseLletraInicial(frase, lletra):
    if frase == "" or lletra not in frase:
        return ""
    if lletra == frase[0]:
        return lletra
    else:
        return frase[0] + fraseLletraInicial(frase[1:], lletra)

"""
Pregunta 2

Fes la funció recursiva 'comptaVocals(frase, vocal)' 
que donada una frase i una vocal, retorna el nombre de vegades que apareix la vocal a la frase.
Per exemple:
"Test", "e" = 1
"""

def comptaVocals(frase, vocal):
    vocal = vocal.lower()
    if frase == "":
        return 0
    elif frase[0].lower() == vocal:
        return 1 + comptaVocals(frase[1:], vocal)
    else:
        return comptaVocals(frase[1:], vocal)

"""
Pregunta 3

Fes la funció recursiva 'ordenaVocals(frase)' 
que donada una frase, retorna la mateixa frase amb les vocals al principi i les consonants al final.
"adeu Marianu"), "aeuaiaunrM d"
"""

def ordenaVocals(frase):
    if frase == "":
        return ""
    elif frase[0] in "aeiou":
        return frase[0] + ordenaVocals(frase[1:])
    else:
        return ordenaVocals(frase[1:]) + frase[0]


"""
Pregunta 4

Fes la runció recursiva 'fraseVocalsMayusConsonantsMinus(frase)'
que donada una frase, retorna la mateixa frase amb les vocals en 
majúscules i les consonants en minúscules.
Per exemple:
"adeu Marianu" = "AdEU mArIAnU"
"""

def fraseVocalsMayusConsonantsMinus(frase):
    if frase == "":
        return ""
    elif frase[0].lower() in "aeiou":
        return frase[0].upper() + fraseVocalsMayusConsonantsMinus(frase[1:])
    else:
        return frase[0].lower() + fraseVocalsMayusConsonantsMinus(frase[1:])


"""
Pregunta 5

Fes una funció recursiva sumaLlista(llista) que retorni 
la suma de tots els elements d'una llista d'enters.
Per exemple:
[-1, 1] = 0
"""
def sumaLlista(llista):
    if not llista:
        return 0
    else:
        return llista[0] + sumaLlista(llista[1:])


"""
Pregunta 6

Fes una funció recursiva inverteixLlista(llista) 
que retorni una nova llista amb els elements de l'original però en ordre invers.
Per exemple:
['a', 'b', 'c'] = ['c', 'b', 'a']
"""
def inverteixLlista(llista):
    if not llista:
        return []
    else:
        return inverteixLlista(llista[1:]) + [llista[0]]


"""
Pregunta 7
Fes una funció recursiva comptaElements(llista, element) 
que compti quantes vegades apareix un element donat en una llista.
Per exemple:
['a', 'b', 'a'], 'a' = 2
"""
def comptaElements(llista, element):
    if not llista:
        return 0
    else:
        return (1 if llista[0] == element else 0) + comptaElements(llista[1:], element)


"""
Pregunta 8
Fes una funció recursiva filtraParells(llista) 
que retorni una nova llista només amb els números parells de la llista original.
Per exemple:
[22, 24, 26] = [22, 24, 26]
"""
def filtraParells(llista):
    if not llista:
        return []
    else:
        if llista[0] % 2 == 0:
            return [llista[0]] + filtraParells(llista[1:])
        else:
            return filtraParells(llista[1:])


"""
Pregunta 9
Fes una funció recursiva maximElement(llista) 
que trobi i retorni l'element més gran d'una llista d'enters.
Per exemple:
[1, 2, 3, 4] = 4
"""
def maximElement(llista):
    if len(llista) == 1:
        return llista[0]
    else:
        sub_max = maximElement(llista[1:])
        return llista[0] if llista[0] > sub_max else sub_max

"""
Pregunta 10
Fes una funció recursiva trobaSubllista(llista, subllista) 
que determini si subllista és una subllista consecutiva dins de llista.
Per exemple:
[1, 2, 3, 4], [2, 3] = True
"""
def trobaSubllista(llista, subllista):
    if not subllista:
        return True
    if not llista or len(subllista) > len(llista):
        return False
    if llista[:len(subllista)] == subllista:
        return True
    else:
        return trobaSubllista(llista[1:], subllista)

"""
Pregunta 11
Fes una funció recursiva eliminaDuplicats(llista) 
que retorni una nova llista sense elements duplicats de la llista original.
Per exemple:
[1, 2, 2, 3, 3, 3, 4] = [1, 2, 3, 4]
"""
def eliminaDuplicats(llista):
    if not llista:
        return []
    if llista[0] in llista[1:]:
        return eliminaDuplicats(llista[1:])
    else:
        return [llista[0]] + eliminaDuplicats(llista[1:])

"""
Pregunta 12
Fes una funció recursiva permutacionsLlista(llista) 
que generi totes les possibles permutacions dels elements de la llista.
Per exemple:
permutacionsLlista([1,2,3]) = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
"""
def permutacionsLlista(llista):
    if len(llista) <= 1:
        return [llista]
    else:
        perms = []
        for i in range(len(llista)):
            subperms = permutacionsLlista(llista[:i] + llista[i+1:])
            for subperm in subperms:
                perms.append([llista[i]] + subperm)
        return perms

"""
Pregunta 13
Fes una funció recursiva comptaElementsDicc(dicc) 
que compti quantes claus (keys) té el diccionari, 
incloent les claus dels diccionaris anidats.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

Per exemple:
{"a": 1, "b": {"c": 2, "d": 3}} = 4
"""
def comptaElementsDicc(dicc):
    count = len(dicc)
    for key, value in dicc.items():
        if isinstance(value, dict):
            count += comptaElementsDicc(value)
    return count


"""
Pregunta 14
Fes una funció recursiva sumaValorsDicc(dicc) 
que sumi tots els valors numèrics trobats en el diccionari, 
incloent els valors dels diccionaris anidats.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

{"a": 1, "b": {"c": 2, "d": 3}} = 6
"""
def sumaValorsDicc(dicc):
    suma = 0
    for value in dicc.values():
        if isinstance(value, dict):
            suma += sumaValorsDicc(value)
        elif isinstance(value, (int, float)):
            suma += value
    return suma


"""
Pregunta 15
Fes una funció recursiva buscarReemplaçar(dicc, clau, valorNou) 
que busqui una clau específica en un diccionari (i els seus sub-diccionaris) 
i reemplaçi el seu valor amb valorNou.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

Per exemple:
{"a": 1, "b": {"c": 2, "d": 3}},  "c", 10 = {"a": 1, "b": {"c": 10, "d": 3}}
"""
def buscarReemplaçar(dicc, clau, valorNou):
    if clau in dicc:
        dicc[clau] = valorNou
    for key, value in dicc.items():
        if isinstance(value, dict):
            buscarReemplaçar(value, clau, valorNou)


"""
Pregunta 16
Fes una funció recursiva fusionaDiccionaris(dicc1, dicc2) 
que fusioni dos diccionaris. Si una clau es troba en ambdós, 
el valor del primer diccionari hauria de ser fusionat 
amb el del segon (si els valors també són diccionaris).

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

Per exemple:
{"a": 1, "b": 2}, {"b": 3, "c": 4} = {"a": 1, "b": 3, "c": 4})
"""
def fusionaDiccionaris(dicc1, dicc2):
    for key, value in dicc2.items():
        if key in dicc1 and isinstance(dicc1[key], dict) and isinstance(value, dict):
            fusionaDiccionaris(dicc1[key], value)
        else:
            dicc1[key] = value
    return dicc1


"""
Pregunta 17
Fes una funció recursiva invertirDiccionari(dicc) 
que inverteixi les claus i els valors d'un diccionari. 
Si els valors són també diccionaris, haurien de ser igualment invertits.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

Per exemple:
{"a": 1, "b": 2} = {1: "a", 2: "b"}
"""
def invertirDiccionari(dicc):
    dicc_invertit = {value: key for key, value in dicc.items() if not isinstance(value, dict)}
    for key, value in dicc.items():
        if isinstance(value, dict):
            dicc_invertit[key] = invertirDiccionari(value)
    return dicc_invertit