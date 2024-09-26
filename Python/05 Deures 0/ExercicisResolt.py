#!/usr/bin/env python3

# Conversió de graus Celsius a Fahrenheit
# Fórmula: Fahrenheit = (Celsius * 9/5) + 32
def celsius_a_fahrenheit(celsius):
    return (celsius * 9/5) + 32

# Conversió de graus Fahrenheit a Celsius
# Fórmula: Celsius = (Fahrenheit - 32) * 5/9
def fahrenheit_a_celsius(fahrenheit):
    return (fahrenheit - 32) * 5/9

# Calcula l'Índex de Massa Corporal (IMC)
# Fórmula: IMC = pes / (altura ** 2)
def calcular_imc(pes, altura):
    return pes / (altura ** 2)

# Calcula la hipotenusa d'un triangle rectangle
# Utilitza el teorema de Pitàgores: hipotenusa = sqrt(catet1^2 + catet2^2)
import math
def calcular_hipotenusa(catet1, catet2):
    return math.sqrt(catet1 ** 2 + catet2 ** 2)

# Comprova si un nombre és parell
# Per fer-ho, fem nombre % 2 i retornem si el resultat és 0
def es_parell(nombre):
    return nombre % 2 == 0

# Calcula l'àrea d'un cercle donat el radi
# Fórmula: Àrea = π * radi^2
def area_cercle(radi):
    return math.pi * radi ** 2

# Converteix minuts a hores i minuts
# Divideix minuts entre 60 per obtenir les hores i els minuts restants
def minuts_a_hores_minuts(minuts):
    hores = minuts // 60
    minuts_restants = minuts % 60
    return hores, minuts_restants

# Calcula el perímetre i l'àrea d'un rectangle
# Perímetre = 2 * (llargada + amplada)
# Àrea = llargada * amplada
def perimetre_i_area_rectangle(llargada, amplada):
    perimetre = 2 * (llargada + amplada)
    area = llargada * amplada
    return perimetre, area

# Calcula el preu final després d'un descompte percentual
# Preu final = preu inicial - (preu inicial * descompte_percent / 100)
def preu_final(preu_inicial, descompte_percent):
    descompte = preu_inicial * (descompte_percent / 100)
    return preu_inicial - descompte

# Calcula l'interès simple
# Fórmula: Interès = capital * (taxa / 100) * temps
def interes_simple(capital, taxa, temps):
    return capital * (taxa / 100) * temps

# Converteix velocitat de km/h a m/s
# Fórmula: m/s = km/h * 1000 / 3600
def kmh_a_ms(velocitat_kmh):
    return velocitat_kmh * 1000 / 3600

# Exercici 1
# Fes un programa amb una variable que tingui el següent text: "La programació és com l'art de resoldre problemes"
# Després manipula aquest text per aconseguir mostrar:
# * La llargada de la frase
# * La subcadena 'art' en majúscules
# * Les lletres inicials de cada paraula concatenades en una cadena
# * La frase completa en majúscules i després en minúscules
# * La frase invertida paraula per paraula

def exercici1():
    frase = "La programació és com l'art de resoldre problemes"
    
    # La llargada de la frase
    llargada = len(frase)
    print("Llargada de la frase:", llargada)
    
    # La subcadena 'art' en majúscules
    subcadena_art = 'art'.upper()
    print("Subcadena 'art' en majúscules:", subcadena_art)
    
    # Les lletres inicials de cada paraula concatenades en una cadena
    inicials = ''.join([paraula[0] for paraula in frase.split()])
    print("Inicials de cada paraula:", inicials)
    
    # La frase completa en majúscules i després en minúscules
    frase_majuscules = frase.upper()
    frase_minuscules = frase.lower()
    print("Frase en majúscules:", frase_majuscules)
    print("Frase en minúscules:", frase_minuscules)
    
    # La frase invertida paraula per paraula
    frase_invertida = ' '.join(frase.split()[::-1])
    print("Frase invertida paraula per paraula:", frase_invertida)

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
    frase = "Python és un llenguatge de programació potent i versàtil"
    
    # La posició de la paraula 'programació' dins la frase
    posicio = frase.find('programació')
    print("Posició de 'programació':", posicio)
    
    # Les paraules 'Python' i 'potent' concatenades en una sola paraula sense espais
    paraules = frase.split()
    python_potent = paraules[0] + paraules[7]
    print("Concatenació de 'Python' i 'potent':", python_potent)
    
    # La subcadena que comprèn des de 'un' fins a 'potent'
    inici = frase.find('un')
    final = frase.find('potent') + len('potent')
    subcadena = frase[inici:final]
    print("Subcadena de 'un' a 'potent':", subcadena)
    
    # La frase amb totes les vocals reemplaçades per '*'
    vocals = 'aeiouàèéíòóúüAEIOUÀÈÉÍÒÓÚÜ'
    frase_sense_vocals = ''.join(['*' if c in vocals else c for c in frase])
    print("Frase amb vocals reemplaçades per '*':", frase_sense_vocals)
    
    # La frase amb la primera lletra de cada paraula en majúscula
    frase_capitalitzada = frase.title()
    print("Frase amb cada paraula capitalitzada:", frase_capitalitzada)

# Exercici 3
# Fes un programa amb una variable que tingui el següent text: "Aprendre a programar és com aprendre un nou idioma"
# Després manipula aquest text per aconseguir mostrar:
# * El nombre de vegades que apareix la paraula 'aprendre'
# * La frase amb la paraula 'idioma' reemplaçada per 'superpoder'
# * Les tres primeres paraules de la frase
# * La frase amb les paraules en ordre invers
# * La frase original però sense espais

def exercici3():
    frase = "Aprendre a programar és com aprendre un nou idioma"
    
    # El nombre de vegades que apareix la paraula 'aprendre'
    comptador = frase.lower().count('aprendre')
    print("Nombre de vegades que apareix 'aprendre':", comptador)
    
    # La frase amb la paraula 'idioma' reemplaçada per 'superpoder'
    frase_nova = frase.replace('idioma', 'superpoder')
    print("Frase amb 'idioma' reemplaçat per 'superpoder':", frase_nova)
    
    # Les tres primeres paraules de la frase
    tres_primeres = ' '.join(frase.split()[:3])
    print("Les tres primeres paraules:", tres_primeres)
    
    # La frase amb les paraules en ordre invers
    frase_inversa = ' '.join(frase.split()[::-1])
    print("Frase amb paraules en ordre invers:", frase_inversa)
    
    # La frase original però sense espais
    frase_sense_espais = frase.replace(' ', '')
    print("Frase sense espais:", frase_sense_espais)

# Exercici 4
# Fes un programa amb una variable que tingui el següent text: "El coneixement és poder"
# Després manipula aquest text per aconseguir mostrar:
# * La llargada de la frase
# * La paraula 'poder' en majúscules
# * La frase repetida tres vegades amb un espai entre elles
# * La frase amb les vocals eliminades
# * La posició de la primera 'e' i de la darrera 'e' en la frase

def exercici4():
    frase = "El coneixement és poder"
    
    # La llargada de la frase
    llargada = len(frase)
    print("Llargada de la frase:", llargada)
    
    # La paraula 'poder' en majúscules
    poder_majuscules = 'poder'.upper()
    print("Paraula 'poder' en majúscules:", poder_majuscules)
    
    # La frase repetida tres vegades amb un espai entre elles
    frase_repetida = (frase + ' ') * 2 + frase
    print("Frase repetida tres vegades:", frase_repetida)
    
    # La frase amb les vocals eliminades
    vocals = 'aeiouàèéíòóúüAEIOUÀÈÉÍÒÓÚÜ'
    frase_sense_vocals = ''.join([c for c in frase if c not in vocals])
    print("Frase sense vocals:", frase_sense_vocals)
    
    # La posició de la primera 'e' i de la darrera 'e' en la frase
    posicio_primera_e = frase.find('e')
    posicio_darrera_e = frase.rfind('e')
    print("Posició de la primera 'e':", posicio_primera_e)
    print("Posició de la darrera 'e':", posicio_darrera_e)

# Exercici 5
# Fes un programa amb una variable que tingui el següent text: "La pràctica fa el mestre"
# Després manipula aquest text per aconseguir mostrar:
# * La frase amb cada paraula separada per un guió '-'
# * La frase amb l'ordre de les lletres de cada paraula invertit
# * La subcadena des del tercer fins al desè caràcter
# * La frase amb totes les consonants en majúscules i les vocals en minúscules
# * El nombre total de lletres sense comptar els espais

def exercici5():
    frase = "La pràctica fa el mestre"
    
    # La frase amb cada paraula separada per un guió '-'
    frase_guions = '-'.join(frase.split())
    print("Frase amb paraules separades per guions:", frase_guions)
    
    # La frase amb l'ordre de les lletres de cada paraula invertit
    paraules_invertides = ' '.join([paraula[::-1] for paraula in frase.split()])
    print("Lletres de cada paraula invertides:", paraules_invertides)
    
    # La subcadena des del tercer fins al desè caràcter
    subcadena = frase[2:10]
    print("Subcadena del tercer al desè caràcter:", subcadena)
    
    # La frase amb totes les consonants en majúscules i les vocals en minúscules
    vocals = 'aeiouàèéíòóúüAEIOUÀÈÉÍÒÓÚÜ'
    frase_transformada = ''.join([c.lower() if c in vocals else c.upper() for c in frase])
    print("Consonants en majúscules i vocals en minúscules:", frase_transformada)
    
    # El nombre total de lletres sense comptar els espais
    total_lletres = len(frase.replace(' ', ''))
    print("Nombre total de lletres sense espais:", total_lletres)

# Exercici 6
# Fes un programa amb una variable que tingui el següent text: "   En un lugar de la Mancha, de cuyo nombre no quiero acordarme   "
# Després manipula aquest text per aconseguir mostrar:
# * La frase original sense espais al principi ni al final
# * La frase amb un ample total de 80 caràcters, centrada, omplint amb '-'
# * La frase amb un ample total de 80 caràcters, alineada a l'esquerra, omplint amb '*'
# * La frase amb un ample total de 80 caràcters, alineada a la dreta, omplint amb '.'
# * La llargada de la frase original i de la frase després d'aplicar strip()

def exercici6():
    frase = "   En un lugar de la Mancha, de cuyo nombre no quiero acordarme   "
    
    # La frase original sense espais al principi ni al final
    frase_strip = frase.strip()
    print("Frase sense espais al principi ni al final:", frase_strip)
    
    # La frase amb un ample total de 80 caràcters, centrada, omplint amb '-'
    frase_centrada = frase_strip.center(80, '-')
    print("Frase centrada amb ample 80:", frase_centrada)
    
    # La frase amb un ample total de 80 caràcters, alineada a l'esquerra, omplint amb '*'
    frase_esquerra = frase_strip.ljust(80, '*')
    print("Frase alineada a l'esquerra amb ample 80:", frase_esquerra)
    
    # La frase amb un ample total de 80 caràcters, alineada a la dreta, omplint amb '.'
    frase_dreta = frase_strip.rjust(80, '.')
    print("Frase alineada a la dreta amb ample 80:", frase_dreta)
    
    # La llargada de la frase original i de la frase després d'aplicar strip()
    llargada_original = len(frase)
    llargada_strip = len(frase_strip)
    print("Llargada original:", llargada_original)
    print("Llargada després de strip():", llargada_strip)

# Exercici 7
# Fes un programa amb una variable que tingui el següent text: "****Benvinguts al curs de Python****"
# Després manipula aquest text per aconseguir mostrar:
# * La frase original sense els asteriscs del principi i del final
# * La frase sense els asteriscs només del principi
# * La frase sense els asteriscs només del final
# * La frase amb un ample total de 50 caràcters, centrada
# * La frase amb un ample total de 50 caràcters, alineada a la dreta

def exercici7():
    frase = "****Benvinguts al curs de Python****"
    
    # La frase original sense els asteriscs del principi i del final
    frase_sense_asteriscs = frase.strip('*')
    print("Frase sense asteriscs al principi i al final:", frase_sense_asteriscs)
    
    # La frase sense els asteriscs només del principi
    frase_sense_asteriscs_inici = frase.lstrip('*')
    print("Frase sense asteriscs al principi:", frase_sense_asteriscs_inici)
    
    # La frase sense els asteriscs només del final
    frase_sense_asteriscs_final = frase.rstrip('*')
    print("Frase sense asteriscs al final:", frase_sense_asteriscs_final)
    
    # La frase amb un ample total de 50 caràcters, centrada
    frase_centrada = frase_sense_asteriscs.center(50)
    print("Frase centrada amb ample 50:", frase_centrada)
    
    # La frase amb un ample total de 50 caràcters, alineada a la dreta
    frase_dreta = frase_sense_asteriscs.rjust(50)
    print("Frase alineada a la dreta amb ample 50:", frase_dreta)

# Exercici 8
# Fes un programa amb una variable que tingui el següent text: "    Python és genial    "
# Després manipula aquest text per aconseguir mostrar:
# * La frase original amb els espais del principi eliminats
# * La frase original amb els espais del final eliminats
# * La frase amb un ample total de 30 caràcters, alineada a l'esquerra, omplint amb '-'
# * La frase amb un ample total de 30 caràcters, alineada a la dreta, omplint amb '+'
# * La frase amb un ample total de 30 caràcters, centrada, omplint amb '*'

def exercici8():
    frase = "    Python és genial    "
    
    # La frase original amb els espais del principi eliminats
    frase_lstrip = frase.lstrip()
    print("Frase sense espais al principi:", frase_lstrip)
    
    # La frase original amb els espais del final eliminats
    frase_rstrip = frase.rstrip()
    print("Frase sense espais al final:", frase_rstrip)
    
    # La frase amb un ample total de 30 caràcters, alineada a l'esquerra, omplint amb '-'
    frase_esquerra = frase.strip().ljust(30, '-')
    print("Frase alineada a l'esquerra amb ample 30:", frase_esquerra)
    
    # La frase amb un ample total de 30 caràcters, alineada a la dreta, omplint amb '+'
    frase_dreta = frase.strip().rjust(30, '+')
    print("Frase alineada a la dreta amb ample 30:", frase_dreta)
    
    # La frase amb un ample total de 30 caràcters, centrada, omplint amb '*'
    frase_centrada = frase.strip().center(30, '*')
    print("Frase centrada amb ample 30:", frase_centrada)

# Exercici 9
# Crea un programa que mostri un menú tipus:
# *********************************Menú Principal*********************************
#             1. Veure perfil                         4. Configuració             
#          2. Canviar contrasenya                         5. Ajuda                
#                3. Sortir                            6. Tancar sessió  
# Sense utilitzar bucles 'for' ni 'while', i fent servir les funcions ljust, center, rjust, etc.
# El programa ha de mostrar el menú amb dues columnes d'opcions una al costat de l'altra.

def exercici9():
    # Títol del menú centrat amb '*' com a caràcter de farciment
    titol = "Menú Principal"
    titol_formatat = titol.center(80, '*')
    
    # Opcions del menú
    opcio1 = "1. Veure perfil"
    opcio2 = "2. Canviar contrasenya"
    opcio3 = "3. Sortir"
    opcio4 = "4. Configuració"
    opcio5 = "5. Ajuda"
    opcio6 = "6. Tancar sessió"
    
    # Ample per a cada columna
    ample_columna = 40
    
    # Formatem cada opció per ajustar-la al centre de la seva columna
    columna1_opcio1 = opcio1.center(ample_columna)
    columna2_opcio4 = opcio4.center(ample_columna)
    fila1 = columna1_opcio1 + columna2_opcio4
    
    columna1_opcio2 = opcio2.center(ample_columna)
    columna2_opcio5 = opcio5.center(ample_columna)
    fila2 = columna1_opcio2 + columna2_opcio5
    
    columna1_opcio3 = opcio3.center(ample_columna)
    columna2_opcio6 = opcio6.center(ample_columna)
    fila3 = columna1_opcio3 + columna2_opcio6
    
    # Imprimim el menú
    print(titol_formatat)
    print(fila1)
    print(fila2)
    print(fila3)
