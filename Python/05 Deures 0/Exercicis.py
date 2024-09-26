#!/usr/bin/env python3
import math

# Conversió de graus Celsius a Fahrenheit
# Fórmula: Fahrenheit = (Celsius * 9/5) + 32
def celsius_a_fahrenheit(celsius):
    pass

# Conversió de graus Fahrenheit a Celsius
# Fórmula: Celsius = (Fahrenheit - 32) * 5/9
def fahrenheit_a_celsius(fahrenheit):
    pass

# Calcula l'Índex de Massa Corporal (IMC)
# Fórmula: IMC = pes / (altura ** 2)
def calcular_imc(pes, altura):
    pass

# Calcula la hipotenusa d'un triangle rectangle
# Utilitza el teorema de Pitàgores: hipotenusa = sqrt(catet1^2 + catet2^2)
def calcular_hipotenusa(catet1, catet2):
    pass

# Comprova si un nombre és parell
# Per fer-ho, fem nombre % 2 i retornem si el resultat és 0
def es_parell(nombre):
    pass

# Calcula l'àrea d'un cercle donat el radi
# Fórmula: Àrea = π * radi^2
def area_cercle(radi):
    pass

# Converteix minuts a hores i minuts
# Divideix minuts entre 60 per obtenir les hores i els minuts restants
def minuts_a_hores_minuts(minuts):
    pass

# Calcula el perímetre i l'àrea d'un rectangle
# Perímetre = 2 * (llargada + amplada)
# Àrea = llargada * amplada
def perimetre_i_area_rectangle(llargada, amplada):
    pass

# Calcula el preu final després d'un descompte percentual
# Preu final = preu inicial - (preu inicial * descompte_percent / 100)
def preu_final(preu_inicial, descompte_percent):
    pass

# Calcula l'interès simple
# Fórmula: Interès = capital * (taxa / 100) * temps
def interes_simple(capital, taxa, temps):
    pass

# Converteix velocitat de km/h a m/s
# Fórmula: m/s = km/h * 1000 / 3600
def kmh_a_ms(velocitat_kmh):
    pass

# Exercici 1
# Fes un programa amb una variable que tingui el següent text: "La programació és com l'art de resoldre problemes"
# Després manipula aquest text per aconseguir mostrar:
# * La llargada de la frase
# * La subcadena 'art' en majúscules
# * Les lletres inicials de cada paraula concatenades en una cadena
# * La frase completa en majúscules i després en minúscules
# * La frase invertida paraula per paraula
def exercici1():
    pass

# Exercici 2
# Fes un programa amb una variable que tingui el següent text: "Python és un llenguatge de programació potent i versàtil"
# Després manipula aquest text per aconseguir mostrar:
# * La posició de la paraula 'programació' dins la frase
# * Les paraules 'Python' i 'potent' concatenades en una sola paraula sense espais
# * La subcadena que comprèn des de 'un' fins a 'potent'
# * La frase amb totes les vocals reemplaçades per '*'
# * La frase amb la primera lletra de cada paraula en majúscula

# Fes servir ''.join(['*' if c in vocals else c for c in frase]) per canviar les vocals per '*'
# per exemple:
# frase = "Hola què tal"
# vocals = 'aeiouàèéíòóúüAEIOUÀÈÉÍÒÓÚÜ'
# fraseSenseVocals = ''.join(['*' if c in vocals else c for c in frase])
# print(fraseSenseVocals)

def exercici2():
    pass

# Exercici 3
# Fes un programa amb una variable que tingui el següent text: "Aprendre a programar és com aprendre un nou idioma"
# Després manipula aquest text per aconseguir mostrar:
# * El nombre de vegades que apareix la paraula 'aprendre'
# * La frase amb la paraula 'idioma' reemplaçada per 'superpoder'
# * Les tres primeres paraules de la frase
# * La frase amb les paraules en ordre invers
# * La frase original però sense espais

def exercici3():
    pass

# Exercici 4
# Fes un programa amb una variable que tingui el següent text: "El coneixement és poder"
# Després manipula aquest text per aconseguir mostrar:
# * La llargada de la frase
# * La paraula 'poder' en majúscules
# * La frase repetida tres vegades amb un espai entre elles
# * La frase amb les vocals eliminades
# * La posició de la primera 'e' i de la darrera 'e' en la frase

def exercici4():
    pass

# Exercici 5
# Fes un programa amb una variable que tingui el següent text: "La pràctica fa el mestre"
# Després manipula aquest text per aconseguir mostrar:
# * La frase amb cada paraula separada per un guió '-'
# * La frase amb l'ordre de les lletres de cada paraula invertit
# * La subcadena des del tercer fins al desè caràcter
# * La frase amb totes les consonants en majúscules i les vocals en minúscules
# * El nombre total de lletres sense comptar els espais

def exercici5():
    pass

# Exercici 6
# Fes un programa amb una variable que tingui el següent text: "   En un lugar de la Mancha, de cuyo nombre no quiero acordarme   "
# Després manipula aquest text per aconseguir mostrar:
# * La frase original sense espais al principi ni al final
# * La frase amb un ample total de 80 caràcters, centrada, omplint amb '-'
# * La frase amb un ample total de 80 caràcters, alineada a l'esquerra, omplint amb '*'
# * La frase amb un ample total de 80 caràcters, alineada a la dreta, omplint amb '.'
# * La llargada de la frase original i de la frase després d'aplicar strip()

def exercici6():
    pass

# Exercici 7
# Fes un programa amb una variable que tingui el següent text: "****Benvinguts al curs de Python****"
# Després manipula aquest text per aconseguir mostrar:
# * La frase original sense els asteriscs del principi i del final
# * La frase sense els asteriscs només del principi
# * La frase sense els asteriscs només del final
# * La frase amb un ample total de 50 caràcters, centrada
# * La frase amb un ample total de 50 caràcters, alineada a la dreta

def exercici7():
    pass

# Exercici 8
# Fes un programa amb una variable que tingui el següent text: "    Python és genial    "
# Després manipula aquest text per aconseguir mostrar:
# * La frase original amb els espais del principi eliminats
# * La frase original amb els espais del final eliminats
# * La frase amb un ample total de 30 caràcters, alineada a l'esquerra, omplint amb '-'
# * La frase amb un ample total de 30 caràcters, alineada a la dreta, omplint amb '+'
# * La frase amb un ample total de 30 caràcters, centrada, omplint amb '*'

def exercici8():
    pass

# Exercici 9
# Crea un programa que mostri un menú tipus:
# *********************************Menú Principal*********************************
#             1. Veure perfil                         4. Configuració             
#          2. Canviar contrasenya                         5. Ajuda                
#                3. Sortir                            6. Tancar sessió  
# Sense utilitzar bucles 'for' ni 'while', i fent servir les funcions ljust, center, rjust, etc.
# El programa ha de mostrar el menú amb dues columnes d'opcions una al costat de l'altra.

def exercici9():
    pass
