#!/usr/bin/env python3
import os           # Per netejar la consola
import json         # Per dibuixar diccionaris en múltiples linies
import random       # Per generar números aleatoris
import readline     # Per guardar activar les tecles up/down

def diccionariBonic(dic, spaces):
    return json.dumps(dic, indent = spaces, ensure_ascii=False)

def clearScreen():
    if os.name == 'nt':     # Si estàs en Windows
        os.system('cls')
    else:                   # Si estàs en Linux o macOS
        os.system('clear')

clearScreen()

jocs = [
    { "nom": "Super Mario Bros", "any": 1985, "tipus": "Plataformes", "preu": 5000 },
    { "nom": "The Legend of Zelda", "any": 1986, "tipus": "Acció-Aventura", "preu": 5000 },
    { "nom": "Pokémon Red i Blue", "any": 1996, "tipus": "RPG (Role-Playing Game)", "preu": 8000 },
    { "nom": "Mario Kart 64", "any": 1996, "tipus": "Carreres", "preu": 10000 },
    { "nom": "Metroid", "any": 1986, "tipus": "Acció-Aventura", "preu": 6000 },
    { "nom": "Pikmin", "any": 2001, "tipus": "Estratègia", "preu": 8000 },
    { "nom": "Donkey Kong", "any": 1981, "tipus": "Plataformes", "preu": 1000 }
]

funcions = {
    "infoJoc": {
        "ajuda": "infoJoc nomJoc",
        "exemple": "funcio infoJoc Super Mario Bros"
    },
    "llistarNomsDeJocs": {
        "ajuda": "llistarNomsDeJocs",
        "exemple": "funcio llistarNomsDeJocs"
    },
    "llistarJocsPerTipus": {
        "ajuda": "llistarJocsPerTipus",
        "exemple": "funcio llistarJocsPerTipus"
    },
    "llistarInfoClau": {
        "ajuda": "llistarInfoClau clau condicio",
        "exemple": "funcio llistarInfoClau tipus Plataformes"
    },
    "llistarPerInterval": {
        "ajuda": "llistarPerInterval clau inici fi",
        "exemple": "funcio llistarPerInterval any 1995 2005",
    },
    "modificarJocPerNom": {
        "ajuda": "modificarJocPerNom nomJoc atribut nouValor",
        "exemple": "funcio modificarJocPerNom Super Mario Bros any 1986"
    }
}

# Fes una funció 'infoJoc' que:
# - rep una llista de jocs i el nom d'un joc
# - retorna un array amb una sola cadena de text que conté la informació del joc
# Per exemple: infoJoc("The Legend of Zelda") retorna
# ["The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)"]
def infoJoc(jocs, nomJoc):
    for joc in jocs:
        if joc["nom"] == nomJoc:
            info = f"{joc['nom']}: {joc['any']}, {joc['tipus']} ({joc['preu']} pessetes)"
            return [info]
    return [f"El joc '{nomJoc}' no s'ha trobat."]

# Fes una funció 'llistarNomsDeJocs que retorna una llista amb el nom
# de tots els jocs
def llistarNomsDeJocs(jocs):
    noms = []
    for joc in jocs:
        noms.append(joc["nom"])
    return noms

# Fes una funció 'llistarJocsPerTipus' que retorna un objecte 
# amb les llistes de jocs per tipus, on les claus del diccionari són
# els tipus de jocs i els valors la quantitat de jocs de cada tipus
def llistarJocsPerTipus(jocs):
    comptador = {}
    for joc in jocs:
        tipus = joc["tipus"]
        if tipus in comptador:
            comptador[tipus] += 1
        else:
            comptador[tipus] = 1
    return comptador

# Fes una funció 'llistarInfoClau' que: 
# rep una llista de 'jocs', una 'clau' i una condició
# retorna una llista amb els jocs que el valor de clau coincideix amb la condició
# Per exemple: 
# 'llistarInfoClau(jocs, 'any', 1986) retorna una llista amb els jocs del 1996
# 'llistarInfoClau(jocs, 'tipus', 'Plataformes') retorna una llista amb els jocs de "Plataformes"
def llistarInfoClau(jocs, clau, condicio):
    resultat = []
    for joc in jocs:
        if (clau == 'any' or clau == 'preu') and joc[clau] == int(condicio):
            resultat.append(joc)
        elif joc[clau] == condicio:
            resultat.append(joc)
    return resultat

# Fes una funció 'llistarPerInterval' que retorna els jocs en un interval d'anys o preu
# Per exemple:
# llistarPerInterval(jocs, 'any', 1995, 2005) retorna els jocs entre 1995 i 2005
def llistarPerInterval(jocs, clau, inici, fi):
    resultat = []
    for joc in jocs:
        if inici <= joc[clau] <= fi:
            resultat.append(joc)
    return resultat

# Fes una funció 'modificarJoc' que:
# rep una llista de jocs, el nom d'un joc, el nom d'un atribut i el nou valor
# retorna dos paràmetres: la llista modificada i la llista 
#  amb 'infoJoc' de cada joc modificar
def modificarJocPerNom(jocs, nomJoc, atribut, nouValor):
    infoModificats = []
    for joc in jocs:
        if joc['nom'] == nomJoc:
            joc[atribut] = nouValor
            # Obtenim la informació del joc modificat
            info = f"{joc['nom']}: {joc['any']}, {joc['tipus']} ({joc['preu']} pessetes)"
            infoModificats.append(info)
    return jocs, infoModificats

# Fes una funció 'ajuda' que retorna una llista de cadenes de text amb:
# Ajuda:
# Llistar > infoJoc, llistarNomsDeJocs, llistarJocsPerTipus,
#           llistarInfoClau, llistarPerInterval
# Modificar > modificarJocPerNom
# Més ajuda > ajuda nomFuncio
# Sortir    > surt del programa
def ajuda():
    return [
        "Ajuda:",
        "Llistar > infoJoc, llistarNomsDeJocs, llistarJocsPerTipus,",
        "          llistarInfoClau, llistarPerInterval",
        "Modificar > modificarJocPerNom",
        "Més ajuda > ajuda nomFuncio",
        "Sortir    > surt del programa"
    ]

# Fes una funció 'ajudaAmpliada' que:
# - rep l'objecte de funcions i el nom d'una funció com a paràmetres
# - retorna els paràmetres d'aquella funció i un exemple d'ús:
# Per exemple ajudaAmpliada('llistarPerInterval') retorna una llista amb les frases:
# Ajuda:   llistarPerInterval clau  inici  fi
# Exemple: funcio llistarPerInterval preu 2000 7000
# Si no troba la funció diu 'Funció no trobada.'
def ajudaAmpliada(funcions, nom_funcio):    
    if nom_funcio in funcions:
        info = funcions[nom_funcio]
        return [f"Ajuda:   {info['ajuda']}", f"Exemple: {info['exemple']}"]
    else:
        return ["Funció no trobada."]

# Fes una funció 'cridaFuncio' que:
# - rep una frase escrita per l'usuari a l'estil dels exemples d'ajuda
# - si la frase és 'ajuda' crida la funció 'ajuda()'
# - si la frase comença per 'ajuda X' crida la funció 'ajudaAmpliada(funcions, X)'
# - si la frase comença per 'funcio X' crida la funció en questió amb els paràmetre entrats
# - si no reconeix la funció retorna ["Funció no trobada"]
# - si no ha introduit bé els paràmetres retorna ["Error: paràmetres erronis"]
# - retorna una llista de frases amb el resultat de cridar la funció
# - en el cas de 'llistarJocsPerTipus' transforma el diccionari en una llista
#   de frases amb format 'json bonic' de 4 espais
def cridaFuncio(frase):
    global jocs
    parts = frase.split()
    
    if len(parts) == 0:
        return ["Funció no trobada"]
    
    nom_funcio = parts[0]
    
    if nom_funcio == "ajuda":
        if len(parts) == 1:
            return ajuda()
        elif len(parts) == 2:
            nom_funcio_ajuda = parts[1]
            return ajudaAmpliada(funcions, nom_funcio_ajuda)
        else:
            return ["Error: paràmetres erronis"]
    
    elif nom_funcio == "funcio":

        if len(parts) < 2:
            return ["Error: paràmetres erronis"]
        
        nom_funcio_a_executar = parts[1]
        
        if nom_funcio_a_executar not in funcions:
            return ["Funció no trobada"]
    
        if nom_funcio_a_executar == "infoJoc":
            if len(parts) < 3:
                return ["Error: paràmetres erronis"]
            nomJoc = ' '.join(parts[2:])
            return infoJoc(jocs, nomJoc)

        if nom_funcio_a_executar == "llistarNomsDeJocs":
            return llistarNomsDeJocs(jocs)
        
        elif nom_funcio_a_executar == "llistarJocsPerTipus":
            resultat = llistarJocsPerTipus(jocs)
            dic_bonic = diccionariBonic(resultat, 4)
            return dic_bonic.split('\n')
        
        elif nom_funcio_a_executar == "llistarInfoClau":
            if len(parts) < 4:
                return ["Error: paràmetres erronis"]
            clau = parts[2]
            condicio = ' '.join(parts[3:])
            return llistarInfoClau(jocs, clau, condicio)
        
        elif nom_funcio_a_executar == "llistarPerInterval":
            if len(parts) != 5:
                return ["Error: paràmetres erronis"]
            clau = parts[2]
            inici = int(parts[3])
            fi = int(parts[4])
            return llistarPerInterval(jocs, clau, inici, fi)
        
        elif nom_funcio_a_executar == "modificarJocPerNom":
            if len(parts) < 5:
                return ["Error: paràmetres erronis"]
            nomJoc = ' '.join(parts[2:-2])
            atribut = parts[-2]
            nouValor = parts[-1]
            if atribut == "preu" or atribut == "any":
                nouValor = int(nouValor)
            jocs, modificats = modificarJocPerNom(jocs, nomJoc, atribut, nouValor)
            return modificats
        
        else:
            return ["Funció no trobada"]
    
    else:
        return ["Funció no trobada"]

# Fes una funció 'mostraFrases' que:
# - neteja la pantalla amb clearScreen
# - mostra les frases d'una llista de frases
# Si hi ha menys de 5 frases, mostra una linia amb el caràcter "·"
def mostraFrases(llista):
    cnt = 0
    for frase in llista:
        print(frase)
        cnt = cnt + 1
    while cnt < 5:
        print("·")
        cnt = cnt + 1

# Fes una funció 'limitaFrases' que:
# - si la llista té més de 8 elements, elimina els del principi
# - retorna la llista modificada resultant
def limitaFrases(llista):
    while len(llista) > 8:
        llista.pop(0)
    return llista

# Fes una funció 'mainRun' que fins que l'usuari no escriu 'sortir':
# - neteja la pantalla i mostra les 8 últimes frases d'una llista de frases
# - demana a l'usuari: "Introdueix una comanda ('ajuda' o 'sortir'): "
# - identifica la comanda escrita per l'usuari i crida la funció corresponent
# - afegeix la comanda identificada amb "Comanda: X"
def mainRun():
    historial = []
    while True:
        historial = limitaFrases(historial)  # Limita l'historial abans de mostrar-lo
        clearScreen()
        mostraFrases(historial)
        entrada = input("Introdueix una comanda ('ajuda' o 'sortir'): ")
        if entrada == "sortir":
            break
        historial.append(f"Comanda: {entrada}")
        resultat = cridaFuncio(entrada)
        historial.extend(resultat)

mainRun()