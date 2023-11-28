
# Executa el test amb
# python "12b TestRecursivitat.py"

"""
Pregunta 0

Fes la funció recursiva 'fraseLletraFinal(frase, lletra)' 
que donada una frase i una lletra, retorna la frase des de la lletra fins al final.
Per exemple:
"Test", "s" = "st"
"""


"""
Pregunta 1

Fes la funció recursiva 'fraseLletraInicial(frase, lletra)' 
que donada una frase i una lletra, retorna la frase des del principi fins a la lletra.
Per exemple:
"Test", "e" = "Te"
"""


"""
Pregunta 2

Fes la funció recursiva 'comptaVocals(frase, vocal)' 
que donada una frase i una vocal, retorna el nombre de vegades que apareix la vocal a la frase.
Per exemple:
"Test", "e" = 1
"""


"""
Pregunta 3

Fes la funció recursiva 'ordenaVocals(frase)' 
que donada una frase, retorna la mateixa frase amb les vocals al principi i les consonants al final.
"adeu Marianu"), "aeuaiaunrM d"
"""


"""
Pregunta 4

Fes la runció recursiva 'fraseVocalsMayusConsonantsMinus(frase)'
que donada una frase, retorna la mateixa frase amb les vocals en 
majúscules i les consonants en minúscules.
Per exemple:
"adeu Marianu" = "AdEU mArIAnU"
"""

"""
Pregunta 5

Fes una funció recursiva sumaLlista(llista) que retorni 
la suma de tots els elements d'una llista d'enters.
Per exemple:
[-1, 1] = 0
"""


"""
Pregunta 6

Fes una funció recursiva inverteixLlista(llista) 
que retorni una nova llista amb els elements de l'original però en ordre invers.
Per exemple:
['a', 'b', 'c'] = ['c', 'b', 'a']
"""


"""
Pregunta 7
Fes una funció recursiva comptaElements(llista, element) 
que compti quantes vegades apareix un element donat en una llista.
Per exemple:
['a', 'b', 'a'], 'a' = 2
"""


"""
Pregunta 8
Fes una funció recursiva filtraParells(llista) 
que retorni una nova llista només amb els números parells de la llista original.
Per exemple:
[22, 24, 26] = [22, 24, 26]
"""


"""
Pregunta 9
Fes una funció recursiva maximElement(llista) 
que trobi i retorni l'element més gran d'una llista d'enters.
Per exemple:
[1, 2, 3, 4] = 4
"""


"""
Pregunta 10
Fes una funció recursiva trobaSubllista(llista, subllista) 
que determini si subllista és una subllista consecutiva dins de llista.
Per exemple:
[1, 2, 3, 4], [2, 3] = True
"""



"""
Pregunta 11
Fes una funció recursiva eliminaDuplicats(llista) 
que retorni una nova llista sense elements duplicats de la llista original.
Per exemple:
[1, 2, 2, 3, 3, 3, 4] = [1, 2, 3, 4]
"""


"""
Pregunta 12
Fes una funció recursiva permutacionsLlista(llista) 
que generi totes les possibles permutacions dels elements de la llista.
Per exemple:
permutacionsLlista([1,2,3]) = [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
"""



"""
Pregunta 13
Fes una funció recursiva comptaElementsDicc(dicc) 
que compti quantes claus (keys) té el diccionari, 
incloent les claus dels diccionaris anidats.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

Per exemple:
{"a": 1, "b": {"c": 2, "d": 3}} = 4
"""


"""
Pregunta 14
Fes una funció recursiva sumaValorsDicc(dicc) 
que sumi tots els valors numèrics trobats en el diccionari, 
incloent els valors dels diccionaris anidats.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

{"a": 1, "b": {"c": 2, "d": 3}} = 6
"""


"""
Pregunta 15
Fes una funció recursiva buscarReemplaçar(dicc, clau, valorNou) 
que busqui una clau específica en un diccionari (i els seus sub-diccionaris) 
i reemplaçi el seu valor amb valorNou.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

Per exemple:
{"a": 1, "b": {"c": 2, "d": 3}},  "c", 10 = {"a": 1, "b": {"c": 10, "d": 3}}
"""


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


"""
Pregunta 17
Fes una funció recursiva invertirDiccionari(dicc) 
que inverteixi les claus i els valors d'un diccionari. 
Si els valors són també diccionaris, haurien de ser igualment invertits.

Et farà falta validar que un element és un diccionari amb isinstance(element, dict).

Per exemple:
{"a": 1, "b": 2} = {1: "a", 2: "b"}
"""
