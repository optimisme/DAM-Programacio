import random

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


"""
Pregunta 18
Fes la funció recursiva 'divisoPerRestesSuccessives(divident, divisor)' que permeti
fer la divisió per restes successives.

L'algoritme és el següent:
- Si el divisor és 0, retorna 0.
- Si el divisor és major que el divident, retorna 0.
- Si el divisor és igual al divident, retorna 1.
- Altrament, retorna 1 + divisoPerRestesSuccessives(divident - divisor, divisor)

Per exemple:
divisoPerRestesSuccessives(10, 3) = 3
divisoPerRestesSuccessives(10, 2) = 5
"""

"""
Pregunta 19
Fes la funció recursiva 'sumaDigits(numero)' que permeti sumar els dígits d’un número.

Per exemple:
sumaDigits(123) = 6
sumaDigits(1234) = 10
"""



"""
Pregunta 20
Fes una funció recursiva 'multiplicaLlista(llista)' que permeti multiplicar els elements d’una llista.

Per exemple:
multiplicaLlista([1, 2, 3]) = 6
multiplicaLlista([1, 2, 3, 4]) = 24
"""


"""
Pregunta 21
Fes una funció recursiva 'indexCoincideix(llista)' que retorna la llista
dels índexs que coincideixen amb el seu valor.

Per exemple:
indexCoincideix([0, 1, 2, 3]) = [0, 1, 2, 3]
indexCoincideix([1, 0, 2, 3]) = [2, 3]
indexCoincideix([0, 2, 1, 3]) = [0, 3]
"""


"""
Pregunta 22
Fes una funció recursiva 'dinsRang(llista, valor)' que retorna cert si 
el valor es troba dins del rang de valors de la llista.

Per exemple:
dinsRang([1, 2, 3], 2) = True
dinsRang([1, 2, 3], 4) = False
"""


"""
Pregunta 23
Fes una funció recursiva 'insereixAleatoris(llista)' que
insereixi valors aleatoris en una llista, sense repetició.

El rang és de 0 a 9 inclusivament.

Per exemple:
insereixAleatoris([1, 2, 3]) = [1, 2, 3, 8, 4]
"""


"""
Pregunta 24
Fes la funció recursiva 'multiplicacioRusa(A,B)' que permeti fer una multiplicació,
utilitzant el mètode Rus. Consisteix en:

- Escriure els números (A i B) que es desitja multiplicar a la part superior de les columnes.
- Dividir A entre 2, successivament, ignorant la resta, fins a arribar a la unitat. Escriure
els resultats en la columna A.
- Multiplicar B per 2 tantes vegades com vegades s’ha dividit A entre 2. Escriure els
resultats successius en la columna B.
- Sumar tots els números de la columna B que estan al costat d’un número senar de la
columna A.
- Per exemple:
multiplicacioRusa(27, 82) = 2214
A   B     SUMES
27  82    82
13  164   164
6   328
3   656   656
1   1312  1312
RESULTAT: 2214
"""


"""
Pregunta 25
Fes una funció recursiva 'separaParaules(frase)' que separi les paraules 
d'una frase i les mostri una a una.
"""


"""
Pregunta 26
Fes una funció recursiva 'generaArbre(paraula)' que generi un arbre
a partir de cada lletra d'una paraula.

Si l’usuari escriu Benvinguts, la funció ha de mostrar:
B
Be
Ben
Benv
Benvi
Benvin
Benving
Benvingu
Benvingut
Benvinguts
"""
