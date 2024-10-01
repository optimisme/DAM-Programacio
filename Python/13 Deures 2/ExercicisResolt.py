#!/usr/bin/env python3
import os           # Per netejar la consola
import re           # Per fer expresions regulars
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

llistaJocs = [
    { "nom": "Super Mario Bros", "any": 1985, "tipus": "Plataformes", "preu": 5000 },
    { "nom": "The Legend of Zelda", "any": 1986, "tipus": "Acció-Aventura", "preu": 5000 },
    { "nom": "Pokémon Red i Blue", "any": 1996, "tipus": "RPG (Role-Playing Game)", "preu": 8000 },
    { "nom": "Mario Kart 64", "any": 1996, "tipus": "Carreres", "preu": 10000 },
    { "nom": "Metroid", "any": 1986, "tipus": "Acció-Aventura", "preu": 6000 },
    { "nom": "Pikmin", "any": 2001, "tipus": "Estratègia", "preu": 8000 },
    { "nom": "Donkey Kong", "any": 1981, "tipus": "Plataformes", "preu": 1000 }
]

diccionariFuncions = {
    "infoJoc": {
        "ajuda": "funcio infoJoc nomJoc",
        "exemple": "funcio infoJoc \"Super Mario Bros\"",
        "parametres": 1
    },
    "comptarPerClau": {
        "ajuda": "funcio comptarPerClau clau",
        "exemple": "funcio comptarPerClau tipus",
        "parametres": 1
    },
    "llistarPerClau": {
        "ajuda": "funcio llistarPerClau clau condicio",
        "exemple": "funcio llistarPerClau tipus Plataformes",
        "parametres": 2
    },
    "llistarPerInterval": {
        "ajuda": "funcio llistarPerInterval clau inici fi",
        "exemple": "funcio llistarPerInterval any 1995 2005",
        "parametres": 3
    },
    "modificarJoc": {
        "ajuda": "funcio modificarJoc nomJoc clau nouValor",
        "exemple": "funcio modificarJoc \"Super Mario Bros\" any 1986",
        "parametres": 3
    }
}

llistaAjuda = [
"  Funcions  > infoJoc, comptarPerClau, llistarPerClau",
"              llistarPerInterval, modificarJoc",
"  Més ajuda > ajuda nomFuncio",
"  Sortir    > surt del programa"
""]

def infoJoc(nomJoc):
    """
    Retorna informació sobre un joc específic.
    Paràmetres:
        nomJoc (str): El nom del joc a cercar.
    Retorna:
        list[str]: Una llista amb una única cadena de text que conté la informació del joc.
        Si el joc no es troba, retorna "  Error infoJoc: \"{nomJoc}\" desconegut."

    Exemples:
        infoJoc("The Legend of Zelda")
          ["The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)"]
        
        infoJoc("abc")
          ["Error infoJoc: "abc" desconegut."]
    """
    for joc in llistaJocs:
        if joc["nom"] == nomJoc:
            info = f"  {joc['nom']}: {joc['any']}, {joc['tipus']} ({joc['preu']} pessetes)"
            return [info]
    return [f"  Error infoJoc: \"{nomJoc}\" desconegut."]

def comptarPerClau(clau):
    """
    Compta la freqüència dels valors d'una clau específica en la llista de jocs.
    Paràmetres:
        clau (str): La clau del diccionari per la qual es vol comptar.
    Retorna:
        dict[str, int]: Un diccionari on les claus són els valors únics trobats
                        i els valors són el nombre d'ocurrències de cada un.
    Exemples:
        comptarPerClau("tipus")
        {
            "Plataformes": 2,
            "Acció-Aventura": 2,
            "RPG (Role-Playing Game)": 1,
            "Carreres": 1,
            "Estratègia": 1
        }

        comptarPerClau("any")
        {
            "1985": 1,
            "1986": 2,
            "1996": 2,
            "2001": 1,
            "1981": 1
        }
    """
    comptador = {}
    for joc in llistaJocs:
        tipus = joc[clau]
        if tipus in comptador:
            comptador[tipus] += 1
        else:
            comptador[tipus] = 1
    return comptador

def llistarPerClau(clau, condicio):
    """
    Llista els jocs que compleixen una condició específica per a una clau donada.
    Paràmetres:
        clau (str): La clau del diccionari per la qual es vol filtrar.
        condicio (str): El valor que ha de tenir la clau per seleccionar el joc.
    Retorna:
        list[str]: Una llista de cadenes, on cada cadena conté la informació
                   d'un joc que compleix la condició especificada fent servir 'infoJoc'.
    Exemples:
        llistarPerClau("tipus", "Acció-Aventura")
          The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)
          Metroid: 1986, Acció-Aventura (6000 pessetes)

        llistarPerClau("any", "1990")
          Mario Kart 64: 1996, Carreres (10000 pessetes)
    """
    resultat = []
    for joc in llistaJocs:
        if joc[clau] == condicio:
            resultat.extend(infoJoc(joc["nom"]))
    return resultat


def llistarPerInterval(clau, inici, fi):
    """
    Llista els jocs que tenen un valor dins d'un interval especificat per a una clau donada.
    Paràmetres:
        clau (str): La clau del diccionari per la qual es vol filtrar.
        inici (int): El valor mínim de l'interval (inclòs).
        fi (int): El valor màxim de l'interval (inclòs).
    Retorna:
        list[str]: Una llista de cadenes, on cada cadena conté la informació
                   d'un joc que compleix la condició de l'interval especificat.
    Exemples:
        llistarPerInterval("any", 1980, 1990)
          Super Mario Bros: 1985, Plataformes (2 pessetes)
          The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)
          Metroid: 1986, Acció-Aventura (6000 pessetes)
          Donkey Kong: 1981, Plataformes (1000 pessetes)
    """
    resultat = []
    for joc in llistaJocs:
        if inici <= joc[clau] <= fi:
            resultat.extend(infoJoc(joc['nom']))
    return resultat

def modificarJoc(nomJoc, clau, nouValor):
    global llistaJocs
    """
    Modifica un valor específic d'un joc en la llista global de jocs.
    Paràmetres:
        nomJoc (str): El nom del joc a modificar.
        clau (str): La clau del diccionari que es vol modificar.
        nouValor: El nou valor a assignar a la clau especificada.
    Retorna:
        list[str]: Una llista amb una única cadena que conté la informació 
                actualitzada del joc si s'ha trobat i modificat, o un 
                missatge d'error si el joc no existeix.
        Si el joc no es troba, retorna "  Error modificarJoc: \"{nomJoc}\" desconegut."
    Exemples:
        modificarJoc("Super Mario Bros", "preu", 2)
          Super Mario Bros: 1985, Plataformes (2 pessetes)
    """
    for i, joc in enumerate(llistaJocs):
        if joc['nom'] == nomJoc:
            joc[clau] = nouValor
            llistaJocs[i] = joc # Aquí es modifica realment la llista!
            return infoJoc(joc['nom'])
    return [f"  Error modificarJoc: \"{nomJoc}\" desconegut."]

def ajudaAmpliada(nomFuncio):    
    """
    Proporciona informació detallada sobre una funció específica del programa.
    Paràmetres:
        nomFuncio(str): El nom de la funció sobre la qual es vol obtenir ajuda.
    Retorna:
        list[str]: Una llista de cadenes que contenen:
                 - Una línia d'ajuda general sobre la funció.
                 - (Opcional) Una línia amb les claus disponibles si en té.
                 - Un exemple d'ús de la funció.
        Si la funció no existeix, retorna "  Error ajudaAmpliada: funció \"{nomFuncio}\" desconeguda."
    Exemples:
        ajudaAmpliada("infoJoc")
          Ajuda:   funcio infoJoc nomJoc
          Exemple: funcio infoJoc "Super Mario Bros"
        ajudaAmpliada("llistarPerClau")
          Ajuda:   funcio llistarPerClau clau condicio
          Claus:   nom, any, tipus, preu
          Exemple: funcio llistarPerClau tipus Plataformes
        ajudaAmpliada("abc")
          Error ajudaAmpliada: funció "abc" desconeguda.
    """
    if nomFuncio in diccionariFuncions:
        info = diccionariFuncions[nomFuncio]
        resultat = [f"  Ajuda:   {info['ajuda']}"]
        if 'clau' in info['ajuda']:
            claus = llistaJocs[0].keys() if llistaJocs else []
            if nomFuncio == 'llistarPerInterval':
                resultat.append("  Claus:   any, preu")
            else:
                resultat.append(f"  Claus:   {', '.join(claus)}")
        resultat.append(f"  Exemple: {info['exemple']}")
        return resultat
    else:
        return [f"  Error ajudaAmpliada: funció \"{nomFuncio}\" desconeguda."]

def divideixFrase(frase):
    """
    Divideix una frase en parts, preservant les cadenes entre cometes com una única part.
    Paràmetres:
        frase (str): La frase a dividir.
    Retorna:
        list[str]: Una llista de cadenes on cada element és:
                - Una paraula individual si no està entre cometes.
                - Una frase completa si està entre cometes (sense les cometes).
    Exemples:
        divideixFrase('Hola "Món Cruel" Adéu')
        ['Hola', 'Món Cruel', 'Adéu']
        divideixFrase("llistarPerClau tipus 'Acció-Aventura'")
        ['llistarPerClau', 'tipus', 'Acció-Aventura']
        divideixFrase('Això és una "frase amb espais" i "una altra"')
        ['Això', 'és', 'una', 'frase amb espais', 'i', 'una altra']
    """
    pattern = r'(?:["\'])(.+?)(?:["\'])|(\S+)'
    parts = re.findall(pattern, frase)
    return [part[0] or part[1] for part in parts]

def cridaFuncio(frase):
    """
    Processa i executa comandes de l'usuari, incloent crides a funcions i sol·licituds d'ajuda.
    Paràmetres:
        frase (str): La comanda de l'usuari com a cadena de text.
    Retorna:
        list[str]: Una llista de cadenes que contenen el resultat de l'operació o missatges d'error.
    Errors de retorn:
        1. Si la frase està buida:
        ["  Error cridaFuncio: no hi ha paràmetres"]
        2. Si es demana una funció sense especificar-la:
        ["  Error cridaFuncio: falta el nom de la funció i els paràmetres si en té"]
        3. Si es crida una funció desconeguda:
        ["  Error cridaFuncio: funció \"<nomFuncio>\" desconeguda"]
        4. Si el nombre de paràmetres per a una funció és incorrecte:
        ["  Error cridaFuncio: la funció \"<nomFuncio>\" necessita <num> paràmetre(s)"]
        5. Per a llistarPerInterval, si la clau no és "any" o "preu":
        ["  Error cridaFuncio: la clau \"<clau>\" no és vàlida, la \"llistarPerInterval\" necessita \"any\" o \"preu\""]
        6. Per a llistarPerClau, si la clau és 'any' o 'preu' i el valor no és numèric:
        ["  Error cridaFuncio: la clau \"<clau>\" ha de tenir un valor numèric"]
        7. Per a llistarPerInterval, si l'inici o el final no són numèrics:
        ["  Error cridaFuncio: inici i final han de ser números"]
        8. Si el tipus de petició és desconegut:
        ["  Error cridaFuncio: tipus de petició \"<tipusPeticio>\" desconeguda"]
    Funcionament:
        - Processa comandes d'ajuda ("ajuda" o "ajuda <nomFuncio>").
        - Executa funcions específiques ("funcio <nomFuncio> [paràmetres]").
        - Valida els paràmetres i gestiona els errors per a cada funció.
        - Crida la funció corresponent amb els paràmetres adequats si tot és correcte.
    Exemples:
        cridaFuncio("ajuda")
        ? Retorna la llista d'ajuda general
        cridaFuncio("ajuda infoJoc")
        ? Retorna l'ajuda ampliada per a la funció infoJoc
        cridaFuncio("funcio infoJoc \"The Legend of Zelda\"")
        ? Executa la funció infoJoc amb el paràmetre donat
        cridaFuncio("funcio llistarPerClau tipus \"Acció-Aventura\"")
        ? Executa llistarPerClau amb els paràmetres donats
        cridaFuncio("funcio llistarPerInterval any 1985 1990")
        ? Executa llistarPerInterval amb els paràmetres donats
    """
    parts = divideixFrase(frase)
    if len(parts) == 0:
        return ["  Error cridaFuncio: no hi ha paràmetres"]

    tipusPeticio = parts[0]
    if tipusPeticio == "ajuda":
        if len(parts) == 1:
            return llistaAjuda
        else:
            nomFuncio = parts[1]
            return ajudaAmpliada(nomFuncio)

    elif tipusPeticio == "funcio":
        if len(parts) == 1:
            return ["  Error cridaFuncio: falta el nom de la funció i els paràmetres si en té"]
        else:
            nomFuncio = parts[1]
            if nomFuncio not in diccionariFuncions:
                return [f"  Error cridaFuncio: funció \"{nomFuncio}\" desconeguda"]
            else:
                numParametres = diccionariFuncions[nomFuncio]["parametres"]
                textPluralFix = "paràmetres"
                if len(parts) != (numParametres + 2):
                    if (numParametres == 1):
                        textPluralFix = "paràmetre"
                    return [f"  Error cridaFuncio: la funció \"{nomFuncio}\" necessita {numParametres} {textPluralFix}"]
                elif nomFuncio == "llistarPerInterval" and parts[2] != "any" and parts[2] != "preu":
                    return [f"  Error cridaFuncio: la clau \"{parts[2]}\" no és vàlida, la \"{nomFuncio}\" necessita \"any\" o \"preu\""]
                else:
                    parametres = parts[2:]
                    if nomFuncio == "infoJoc":
                        return infoJoc(parametres[0])
                    elif nomFuncio == "comptarPerClau":
                        resultat = comptarPerClau(parametres[0])
                        return diccionariBonic(resultat, 4).split('\n')
                    elif nomFuncio == "llistarPerClau":
                        clau = parametres[0]
                        condicio = parametres[1]
                        if (clau == 'any' or clau == 'preu') and not(condicio.isnumeric()):
                            return [f"  Error cridaFuncio: la clau \"{clau}\" ha de tenir un valor numèric"]
                        else:
                            return llistarPerClau(clau, condicio)
                    elif nomFuncio == "llistarPerInterval":
                        clau = parametres[0]
                        inici = parametres[1]
                        fi = parametres[2]
                        if not(inici.isnumeric() and fi.isnumeric()):
                            return ["  Error cridaFuncio: inici i final han de ser números"]
                        return llistarPerInterval(clau, int(inici), int(fi))
                    elif nomFuncio == "modificarJoc":
                        nomJoc = parametres[0]
                        clau = parametres[1]
                        nouValor = parametres[2]
                        modificats = modificarJoc(nomJoc, clau, nouValor)
                        return modificats
                    else:
                        return []
    else:
        return [f"  Error cridaFuncio: tipus de petició \"{tipusPeticio}\" desconeguda"]

def limitaFrases(llista):
    """
    Limita una llista a un màxim de 10 elements, eliminant els més antics si és necessari.
    Paràmetres:
        llista (list): La llista d'elements a limitar.
    Retorna:
        list: La llista original si té 10 elements o menys, o una nova llista
            amb els 10 elements més recents si la llista original era més llarga.
    Comportament:
        - Si la llista té més de 10 elements, elimina els primers elements
        (els més antics) fins que quedin exactament 10.
        - Si la llista té 10 elements o menys, la retorna sense modificar.
    Exemples:
        limitaFrases(['a', 'b', 'c', 'd', 'e'])
        ['a', 'b', 'c', 'd', 'e']
        limitaFrases(['a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l'])
        ['c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l']
    """
    while len(llista) > 10:
        llista.pop(0)
    return llista

def mostraFrases(llista):
    """
    Mostra fins a 10 elements d'una llista, omplint amb línies buides si la llista té menys de 10 elements.
    Paràmetres:
        llista (list): La llista d'elements a mostrar.
    Retorna:
        None: Aquesta funció no retorna cap valor, només imprimeix a la consola.
    Comportament:
        - Imprimeix els primers 10 elements de la llista donada.
        - Si la llista té menys de 10 elements, imprimeix tots els elements
        disponibles i omple la resta amb línies buides fins a arribar a 10 línies.
        - Cada element o línia buida s'imprimeix en una línia separada.
    Exemples:
        mostraFrases(['a', 'b', 'c'])
        a
        b
        c
        
        
        
        
        
        
        
        mostraFrases(['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11'])
        0
        1
        2
        3
        4
        5
        6
        7
        8
        9
    Notes:
        - Aquesta funció sempre imprimeix exactament 10 línies, independentment
        de la longitud de la llista d'entrada.
        - S'utilitza típicament per mostrar un historial o una llista de resultats
        de manera consistent en una interfície de consola.
    """
    for i in range(10):
        if i < len(llista):
            print(llista[i])
        else:
            print(f" ")

def mainRun():
    """
    Executa el bucle principal del programa, gestionant l'entrada de l'usuari i mostrant els resultats.
    Paràmetres:
        Cap
    Retorna:
        None: Aquesta funció no retorna cap valor, executa el programa fins que l'usuari decideix sortir.
    Comportament:
        1. Inicialitza una llista buida 'historial' per emmagatzemar les comandes i resultats.
        2. Entra en un bucle infinit que:
            a. Limita l'historial a 10 elements utilitzant la funció limitaFrases.
            b. Neteja la pantalla amb clearScreen.
            c. Mostra l'historial actual utilitzant mostraFrases.
            d. Demana a l'usuari que introdueixi una comanda.
            e. Si l'usuari introdueix "sortir" o "Sortir", surt del bucle.
            f. Afegeix la comanda de l'usuari a l'historial.
            g. Processa la comanda utilitzant cridaFuncio i afegeix els resultats a l'historial.
    Funcionalitats clau:
        - Manté un historial limitat de comandes i resultats.
        - Proporciona una interfície de consola neta i actualitzada.
        - Permet a l'usuari introduir comandes i veure els resultats.
        - Ofereix una manera de sortir del programa.
        - Per cada petició de l'usuari escriu "> Comanda: X" on X és la frase introduida
    Exemples d'ús:
        mainRun()
        Introdueix una comanda ('ajuda' o 'sortir'): ajuda llistarPerClau
        > Comanda: ajuda llistarPerClau
          Ajuda:   funcio llistarPerClau clau condicio
          Claus:   nom, any, tipus, preu
          Exemple: funcio llistarPerClau tipus Plataformes
        Introdueix una comanda ('ajuda' o 'sortir'): funcio infoJoc "The Legend of Zelda"
        > Comanda: funcio infoJoc "The Legend of Zelda"
          The Legend of Zelda: 1986, Acció-Aventura (5000 pessetes)
        Introdueix una comanda ('ajuda' o 'sortir'): sortir
        ? El programa finalitza
    Notes:
        - Aquesta funció utilitza altres funcions com limitaFrases, clearScreen, mostraFrases, i cridaFuncio.
        - L'historial es manté entre iteracions, permetent a l'usuari veure les comandes i resultats anteriors.
        - La funció clearScreen s'espera que netegi la pantalla de la consola per a una millor presentació.
    """
    historial = []
    while True:
        historial = limitaFrases(historial)
        clearScreen()
        mostraFrases(historial)
        frase = input("Introdueix una comanda ('ajuda' o 'sortir'): ")
        if frase == "sortir" or frase == "Sortir":
            break
        historial.extend(["", f"> Comanda: {frase}"])
        missatges = cridaFuncio(frase)
        historial.extend(missatges)

# No canvieu això o no passarà el test
if __name__ == "__main__":
    mainRun()