"""

Fes un programa que calcula el número de la sort d'una persona.

Primer demana la data de naixement en format dd/mm/aaaa.

Si el format no és correcte, mostra el missatge "Format incorrecte" i torna a demanar la data.

El número de la sort es calcula sumant tots els números de la data de naixement, 
sumant tots els números d'aquest resultat i així fins que s'obté un número d'un sol dígit.

Per exemple:

29/09/1981 > 2 + 9 + 0 + 9 + 1 + 9 + 8 + 1 = 39
01/07/1979 > 0 + 1 + 0 + 7 + 1 + 9 + 7 + 9 = 34

"""