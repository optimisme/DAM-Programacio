#!/usr/bin/env python3

import os
import platform
import random

nom = ""
cognoms = ""
dni = ""

"""

En aquest exàmen es farà un gestor de dades per una notaria.

Hi haurà diferents tipus de dades, 'clients' i 'operacions'.

Exemples de com han de ser les dades:

clients = {
    "client_0": {
        "nom": "Joan Garcia", 
        "edat": 45, 
        "factors": ["autònom", "risc mitjà"], 
        "descompte": 15
    },
    "client_1": {"nom": "Marta Pérez", "edat": 38, "factors": ["empresa", "risc baix"], "descompte": 10},
    "client_2": {"nom": "Pere López", "edat": 52, "factors": ["autònom", "risc alt"], "descompte": 5}
}

operacions = [
    {
        "id": 0, 
        "tipus": "Declaració d'impostos", 
        "clients": ["client_0", "client_2"], 
        "data": "2024-10-05", 
        "observacions": "Presentació conjunta", 
        "preu": 150.0
    },
    {"id": 1, "tipus": "Gestió laboral", "clients": ["client_2"], "data": "2024-10-04", "observacions": "Contractació de personal", "preu": 200.0},
    {"id": 1, "tipus": "Assessoria fiscal", "clients": ["client_1"], "data": "2024-10-03", "observacions": "Revisió d'informes", "preu": 120.0}
]

"""

# Inicialitzar les dades
clients = {}
operacions = []

# Aquesta funció neteja la pantalla, no la modifiquis
def clearScreen():
    if os.name == 'nt':     # Si estàs a Windows
        os.system('cls')
    else:                   # Si estàs a Linux o macOS
        os.system('clear')

clearScreen()

def validar_nom(nom):
    """
    Valida que un nom sigui vàlid
    Paràmetres:
        nom: el nom que s'ha de validar
    Funcionament:
        Si el nom és una cadena buida, retorna false
        Per cada caràcter dins de nom mira que sigui una lletra o un espai blanc
    Retorn:
        True si el nom és vàlid (no és una cadena buida, només conté lletres o espais)
        False altrament
    Exemples:
        nom("Maria Neures") -> True
        nom("Picachu4") -> False
    """
    if nom == "":
        return False
    for car in nom:
        if not (car.isalpha() or car == ' '):
            return False
    return True

def validar_edat(edat):
    """
    Valida que l'edat sigui un valor vàlid
    Paràmetres:
        edat: l'edat que s'ha de validar
    Funcionament:
        Comprova que l'edat sigui un enter i que estigui dins del rang acceptable (entre 18 i 100, ambdós inclosos).
    Retorn:
        True si l'edat és un enter i es troba entre 18 i 100
        False altrament
    Exemples:
        validar_edat(25) -> True
        validar_edat(17) -> False
    """
    return isinstance(edat, int) and 18 <= edat <= 100

def validar_factors(factors):
    """
    Valida que els factors proporcionats siguin vàlids.
    Paràmetres:
        factors: una llista de dos elements que s'ha de validar.
    Funcionament:
        Comprova que 'factors' sigui una llista amb exactament dos elements. 
        El primer element ha de ser "autònom" o "empresa".
        El segon element ha de ser "risc alt", "risc mitjà" o "risc baix"
        Un "autònom" no pot ser de "risc baix"
    Retorn:
        True si la llista compleix totes les condicions.
        False altrament.
    Exemples:
        validar_factors(["autònom", "risc alt"]) -> True
        validar_factors(["empresa", "risc moderat"]) -> False
    """
    if isinstance(factors, list) and len(factors) == 2:
        if factors[0] == "autònom" and factors[1] == "risc baix":
            return False
        return factors[0] in ["autònom", "empresa"] and factors[1] in ["risc alt", "risc baix", "risc mitjà"]
    return False

def validar_descompte(descompte):
    """
    Valida que el descompte sigui un valor vàlid.
    Paràmetres:
        descompte: el valor del descompte que s'ha de validar.
    Funcionament:
        Comprova que el descompte sigui un número (enter o decimal).
        Verifica que el valor estigui dins del rang acceptable (entre 0 i 20, ambdós inclosos).
    Retorn:
        True si el descompte és un número vàlid i es troba entre 0 i 20.
        False altrament.
    Exemples:
        validar_descompte(15) -> True
        validar_descompte(25) -> False
    """
    return isinstance(descompte, (int, float)) and 0 <= descompte <= 20


def validar_tipus_operacio(tipus):
    """
    Valida que el tipus d'operació sigui vàlid.
    Paràmetres:
        tipus: el tipus d'operació que s'ha de validar.
    Funcionament:
        Comprova que el valor proporcionat coincideixi amb algun dels tipus d'operació vàlids.
        Els tipus d'operació vàlids inclouen: 
            "Declaració d'impostos", "Gestió laboral", "Assessoria fiscal",
            "Constitució de societat", "Modificació d'escriptures", 
            "Testament", "Gestió d'herències", "Acta notarial",
            "Contracte de compravenda", "Contracte de lloguer"
    Retorn:
        True si el tipus d'operació es troba dins de la llista de tipus vàlids.
        False altrament.
    Exemples:
        validar_tipus_operacio("Declaració d'impostos") -> True
        validar_tipus_operacio("Operació desconeguda") -> False
    """
    tipus_valids = [
        "Declaració d'impostos", "Gestió laboral", "Assessoria fiscal",
        "Constitució de societat", "Modificació d'escriptures", 
        "Testament", "Gestió d'herències", "Acta notarial",
        "Contracte de compravenda", "Contracte de lloguer"
    ]
    return tipus in tipus_valids

def validar_clients(clients_llista, clients_globals):
    """
    Valida que la llista de clients sigui vàlida.
    Paràmetres:
        clients_llista: la llista de clients que s'ha de validar.
        clients_globals: una llista o conjunt que conté els clients vàlids globals.
    Funcionament:
        Comprova que 'clients_llista' sigui efectivament una llista.
        Permet que una llista buida sigui vàlida.
        Verifica que tots els elements de 'clients_llista' siguin únics.
        Assegura que tots els clients de 'clients_llista' es trobin dins de la llista 'clients_globals'.
    Retorn:
        True si 'clients_llista' compleix totes les condicions.
        False altrament.
    Exemples:
        validar_clients(['client1', 'client2'], ['client1', 'client2', 'client3']) -> True
        validar_clients(['client1', 'client1'], ['client1', 'client2', 'client3']) -> False
        validar_clients([], ['client1', 'client2', 'client3']) -> True
    """
    if not isinstance(clients_llista, list):
        return False
    return len(clients_llista) == len(set(clients_llista)) and all(client in clients_globals for client in clients_llista)

def validar_data(data):
    """
    Valida que la data sigui en un format vàlid (AAAA-MM-DD) i que representi una data possible.
    Paràmetres:
        data: una cadena de text que representa una data en format 'AAAA-MM-DD'.
    Funcionament:
        1. Comprova que la longitud de la cadena sigui exactament 10 caràcters (format 'AAAA-MM-DD').
        2. Divideix la cadena en tres parts: any, mes i dia, separats per guions.
        3. Comprova que cada part (any, mes i dia) estigui formada només per dígits.
        4. Converteix any, mes i dia en enters.
        5. Verifica que l'any estigui en un rang vàlid (entre 1000 i 9999).
        6. Verifica que el mes estigui en el rang correcte (entre 1 i 12).
        7. Verifica que el dia estigui en el rang correcte (entre 1 i 31).
        8. Simplifica la validació dels dies segons el mes:
            - Els mesos d'abril, juny, setembre i novembre han de tenir un màxim de 30 dies.
            - El mes de febrer ha de tenir un màxim de 29 dies (aquesta simplificació no comprova anys de traspàs).
    Retorn:
        True si la data és vàlida.
        False si la data no compleix alguna de les condicions anteriors.
    Exemples:
        validar_data("2023-04-15") -> True
        validar_data("2023-02-30") -> False
        validar_data("2023-13-01") -> False
    """
    if len(data) != 10:
        return False
    
    parts = data.split('-')
    if len(parts) != 3:
        return False

    any_, mes, dia = parts

    if not (any_.isdigit() and mes.isdigit() and dia.isdigit()):
        return False

    any_, mes, dia = int(any_), int(mes), int(dia)

    if not (1000 <= any_ <= 9999):
        return False
    if not (1 <= mes <= 12):
        return False
    if not (1 <= dia <= 31):
        return False

    if mes in [4, 6, 9, 11] and dia > 30:
        return False
    if mes == 2 and dia > 29:
        return False

    return True

def validar_preu(preu):
    """
    Valida que el preu sigui un número vàlid i superior a 100.
    Paràmetres:
        preu: el valor del preu que s'ha de validar.
    Funcionament:
        Comprova que 'preu' sigui un número, ja sigui enter o decimal.
        Verifica que el valor del preu sigui estrictament superior a 100.
    Retorn:
        True si el preu és un número i és superior a 100.
        False altrament.
    Exemples:
        validar_preu(150) -> True
        validar_preu(99.99) -> False
        validar_preu("100") -> False
    """
    return isinstance(preu, (int, float)) and preu > 100

def afegir_client(clients, nom, edat, factors, descompte):
    """
    Afegeix un nou client al diccionari de clients.
    Paràmetres:
        clients: diccionari que conté els clients existents, on la clau és un identificador de client i el valor és un diccionari amb informació del client.
        nom: el nom del nou client.
        edat: l'edat del nou client.
        factors: llista amb informació sobre el tipus de client i el risc associat.
        descompte: el descompte associat al nou client.
    Funcionament:
        Genera una nova clau única per al client basant-se en la longitud actual del diccionari de clients, amb el format "client_X" (on X és el nombre actual de clients).
        Afegeix una entrada al diccionari de clients, on la clau és la nova clau generada i el valor és un diccionari amb el nom, edat, factors i descompte del nou client.
    Retorn:
        Retorna la nova clau del client afegit.
    Exemples:
        afegir_client(clients, "Maria", 30, ["empresa", "risc baix"], 10) -> "client_0"
    """
    nova_clau = f"client_{len(clients)}"
    clients[nova_clau] = {"nom": nom, "edat": edat, "factors": factors, "descompte": descompte}
    return nova_clau

def modificar_client(clients, clau_client, camp, nou_valor):
    """
    Modifica un camp específic d'un client en el diccionari de clients.
    Paràmetres:
        clients: diccionari que conté els clients existents, on la clau és un identificador de client i el valor és un diccionari amb informació del client.
        clau_client: la clau del client que s'ha de modificar.
        camp: el camp específic dins del diccionari del client que s'ha de modificar (per exemple, 'nom', 'edat', 'factors', o 'descompte').
        nou_valor: el nou valor que es vol assignar al camp especificat.
    Funcionament:
        Comprova si la clau del client existeix al diccionari de clients.
        Si existeix, comprova si el camp que es vol modificar és vàlid (existeix dins del diccionari del client).
        Si el camp existeix, actualitza el valor del camp amb el nou valor.
        Si el camp no existeix, retorna un missatge d'error indicant que el camp no existeix.
        Si la clau del client no existeix, retorna un missatge d'error indicant que el client no es troba.
    Retorn:
        Retorna un missatge d'error si la clau del client o el camp no existeixen.
        Si no hi ha cap error, no retorna res (realitza la modificació directament).
    Exemples:
        modificar_client(clients, "client_0", "edat", 35) -> Modifica l'edat del client amb clau 'client_0' a 35.
        modificar_client(clients, "client_1", "nom", "Anna") -> Modifica el nom del client amb clau 'client_1' a "Anna".
    """
    if clau_client in clients:
        if camp in clients[clau_client]:
            clients[clau_client][camp] = nou_valor
        else:
            return f"El camp {camp} no existeix en el client."
    else:
        return f"Client amb clau {clau_client} no existeix."

def esborrar_client(clients, clau_client):
    """
    Esborra un client del diccionari de clients.
    Paràmetres:
        clients: diccionari que conté els clients existents, on la clau és un identificador de client i el valor és un diccionari amb informació del client.
        clau_client: la clau del client que s'ha d'esborrar.
    Funcionament:
        Comprova si la clau del client existeix dins del diccionari de clients.
        Si la clau del client existeix, elimina el client del diccionari.
        Si la clau del client no existeix, retorna un missatge indicant que el client no es troba.
    Retorn:
        Si el client no existeix, retorna un missatge d'error: "Client amb clau {clau_client} no existeix."
        Si el client existeix, l'elimina i no retorna res.
    Exemples:
        esborrar_client(clients, "client_0") -> Esborra el client amb clau 'client_0' del diccionari.
        esborrar_client(clients, "client_5") -> Retorna: "Client amb clau client_5 no existeix."
    """
    if clau_client in clients:
        del clients[clau_client]
    else:
        return f"Client amb clau {clau_client} no existeix."

def llistar_clients(clients, claus, condicions):
    """
    Llista clients que compleixen determinades condicions.
    Paràmetres:
        clients: diccionari que conté els clients existents, on la clau és un identificador de client i el valor és un diccionari amb informació del client.
        claus: llista de claus de clients que es volen considerar per a la cerca.
        condicions: diccionari de condicions, on la clau és el nom d'un camp i el valor és el valor esperat per a aquell camp.
    Funcionament:
        Inicialitza una llista buida per emmagatzemar els resultats.
        Recorre el diccionari de clients. Per a cada client:
            - Comprova si la clau del client es troba dins de la llista de claus proporcionades.
            - Si la clau no es troba, salta a la següent iteració.
            - Si es troba, inicialitza una variable `coincideix` a True.
            - Comprova, per cada camp de les condicions, si el valor del camp del client coincideix amb el valor esperat.
            - Si alguna condició no es compleix, canvia `coincideix` a False i atura la comprovació per a aquest client.
            - Si totes les condicions es compleixen, afegeix el client als resultats.
        Finalment, retorna la llista de clients que compleixen totes les condicions.
    Retorn:
        Una llista de diccionaris que conté els clients que compleixen totes les condicions proporcionades.
        Cada diccionari té com a clau la clau del client i com a valor un altre diccionari amb les dades del client.
    Exemples:
        llistar_clients(clients, ['client_1', 'client_2'], {'edat': 30}) -> Llista els clients amb claus 'client_1' i 'client_2' que tenen 30 anys.
    """
    resultat = []
    for clau, dades in clients.items():
        if clau not in claus:
            continue
        
        coincideix = True
        for key, valor in condicions.items():
            if dades.get(key) != valor:
                coincideix = False
                break
        
        if coincideix:
            resultat.append({clau: dades})
    
    return resultat

def afegir_operacio(operacions, tipus, clients_implicats, data, observacions, preu):
    """
    Afegeix una nova operació a la llista d'operacions.
    Paràmetres:
        operacions: llista que conté totes les operacions actuals, on cada operació és un diccionari amb informació de l'operació.
        tipus: el tipus d'operació (per exemple, "Declaració d'impostos", "Assessoria fiscal", etc.).
        clients_implicats: llista de clients que participen en l'operació.
        data: la data de l'operació, en format "AAAA-MM-DD".
        observacions: qualsevol informació addicional o comentaris sobre l'operació.
        preu: el preu de l'operació.
    Funcionament:
        Genera un nou identificador per a l'operació basat en la longitud actual de la llista d'operacions.
        Crea un diccionari que representa la nova operació, amb els camps següents:
            - "id": l'identificador de l'operació.
            - "tipus": el tipus d'operació.
            - "clients": la llista de clients implicats en l'operació.
            - "data": la data de l'operació.
            - "observacions": les observacions de l'operació.
            - "preu": el preu associat a l'operació.
        Afegeix aquest diccionari a la llista d'operacions.
    Retorn:
        Retorna l'identificador de la nova operació.
    Exemples:
        afegir_operacio(operacions, "Declaració d'impostos", ["client_1", "client_2"], "2023-10-05", "Operació urgent", 200) -> 0 (si és la primera operació).
    """
    nou_id = len(operacions)
    operacio = {"id": nou_id, "tipus": tipus, "clients": clients_implicats, "data": data, "observacions": observacions, "preu": preu}
    operacions.append(operacio)
    return nou_id

def modificar_operacio(operacions, id_operacio, camp, nou_valor):
    """
    Modifica un camp específic d'una operació dins de la llista d'operacions.
    Paràmetres:
        operacions: llista que conté totes les operacions actuals, on cada operació és un diccionari amb informació de l'operació.
        id_operacio: l'identificador de l'operació que s'ha de modificar.
        camp: el camp específic dins del diccionari de l'operació que s'ha de modificar (per exemple, 'tipus', 'data', 'preu', etc.).
        nou_valor: el nou valor que es vol assignar al camp especificat.
    Funcionament:
        Recorre la llista d'operacions buscant una operació amb l'identificador donat.
        Si troba l'operació amb el 'id_operacio', comprova si el camp que es vol modificar existeix dins de l'operació.
        Si el camp existeix, actualitza el valor del camp amb el nou valor proporcionat.
        Si el camp no existeix, retorna un missatge d'error indicant que el camp no es troba dins de l'operació.
        Si no troba cap operació amb l'identificador proporcionat, retorna un missatge d'error indicant que l'operació no existeix.
    Retorn:
        Retorna un missatge d'error si el camp no existeix o si no troba l'operació.
        Si la modificació es realitza amb èxit, no retorna res (realitza la modificació directament).
    Exemples:
        modificar_operacio(operacions, 0, "preu", 300) -> Modifica el preu de l'operació amb id 0 a 300.
        modificar_operacio(operacions, 1, "data", "2024-01-01") -> Modifica la data de l'operació amb id 1.
    """
    for operacio in operacions:
        if operacio["id"] == id_operacio:
            if camp in operacio:
                operacio[camp] = nou_valor
            else:
                return f"El camp {camp} no existeix en l'operació."
            return
    return f"Operació amb id {id_operacio} no existeix."

def esborrar_operacio(operacions, id_operacio):
    """
    Esborra una operació de la llista d'operacions basada en l'identificador de l'operació.
    Paràmetres:
        operacions: llista que conté totes les operacions actuals, on cada operació és un diccionari amb informació de l'operació.
        id_operacio: l'identificador de l'operació que es vol esborrar.
    Funcionament:
        Recorre la llista d'operacions amb l'índex i la pròpia operació.
        Comprova si l'operació actual té un identificador igual a 'id_operacio'.
        Si troba una coincidència, utilitza el mètode `pop()` per eliminar l'operació de la llista a la posició indicada per l'índex.
        Si l'operació s'elimina amb èxit, la funció acaba i no retorna res.
        Si no es troba cap operació amb l'identificador proporcionat, retorna un missatge d'error indicant que l'operació no existeix.
    Retorn:
        Retorna un missatge d'error si l'operació amb 'id_operacio' no existeix.
        Si l'operació s'esborra correctament, no retorna res.
    Exemples:
        esborrar_operacio(operacions, 0) -> Esborra l'operació amb id 0 de la llista d'operacions.
        esborrar_operacio(operacions, 3) -> Retorna "Operació amb id 3 no existeix" si no troba l'operació.
    """
    for i, operacio in enumerate(operacions):
        if operacio["id"] == id_operacio:
            operacions.pop(i)
            return
    return f"Operació amb id {id_operacio} no existeix."

def llistar_operacions(operacions, ids, condicions):
    """
    Llista les operacions que compleixen determinats criteris basats en identificadors i condicions específiques.
    Paràmetres:
        operacions: llista de diccionaris, on cada diccionari conté informació sobre una operació (amb camps com 'id', 'tipus', 'data', etc.).
        ids: una llista d'identificadors d'operacions que es volen considerar. Si està buida o és None, es consideren totes les operacions.
        condicions: diccionari de condicions, on la clau és el nom d'un camp de l'operació i el valor és el valor que aquest camp ha de tenir per satisfer la condició.
    Funcionament:
        1. Inicialitza una llista buida `resultat` per emmagatzemar les operacions que compleixen els criteris.
        2. Recorre cada operació dins de la llista `operacions`.
        3. Si es proporcionen `ids`, comprova si l'identificador de l'operació està dins de la llista d'ids. Si no hi és, passa a la següent operació.
        4. Si hi ha condicions, verifica per a cada camp de les condicions si el valor de l'operació coincideix amb el valor especificat en les condicions. Si alguna condició no es compleix, es marca `coincideix` com a False i s'abandona la comprovació per a aquesta operació.
        5. Si l'operació compleix totes les condicions i és un dels `ids` especificats (si es donen), l'operació s'afegeix a la llista `resultat`.
    Retorn:
        Retorna la llista de les operacions que compleixen les condicions donades.
    Exemples:
        llistar_operacions(operacions, [1, 2], {'tipus': 'Declaració d'impostos'}) -> Retorna les operacions amb id 1 i 2 que siguin de tipus 'Declaració d'impostos'.
        llistar_operacions(operacions, [], {'preu': 200}) -> Retorna totes les operacions amb un preu de 200.
    """
    resultat = []
    for operacio in operacions:
        if ids and operacio["id"] not in ids:
            continue
        
        coincideix = True
        if condicions:
            for key, valor in condicions.items():
                if operacio.get(key) != valor:
                    coincideix = False
                    break
        
        if coincideix:
            resultat.append(operacio)
    
    return resultat

def llistar_operacions_client(operacions, clau_client):
    """
    Llista les operacions associades a un client específic basant-se en la seva clau.

    Paràmetres:
        operacions: Llista de diccionaris, on cada diccionari conté informació sobre una operació (amb camps com 'id', 'clients', 'tipus', 'data', etc.).
        clau_client: La clau única del client que es vol filtrar. S'utilitza per identificar les operacions relacionades amb aquest client.

    Funcionament:
        1. Inicialitza una llista buida resultat per emmagatzemar les operacions que pertanyen al client especificat.
        2. Recorre cada operació dins de la llista operacions.
        3. Comprova si la clau_client està present en la llista de clients de l'operació.
            - Si està present, afegeix l'operació a la llista resultat.
            - Si no està present, continua amb la següent operació.
        4. Repeteix aquest procés per a totes les operacions de la llista.

    Retorn:
        Retorna la llista de les operacions que estan associades al client amb la clau especificada.

    Exemples:
        llistar_operacions_client(operacions, 'client_123') -> Retorna totes les operacions que inclouen 'client_123' en la seva llista de clients.
        llistar_operacions_client(operacions, 'client_XYZ') -> Retorna les operacions associades al client amb clau 'client_XYZ'.
    """
    resultat = []
    for operacio in operacions:
        if clau_client in operacio.get("clients", []):
            resultat.append(operacio)
    return resultat

def taula_operacions_client(clients, operacions, clau_client, ordre):
    """
    Genera una representació en forma de taula de les operacions associades a un client específic, ordenades segons un criteri determinat.

    Paràmetres:
        clients: Diccionari on les claus són les clau_client i els valors són diccionaris amb informació del client (com 'nom', 'edat', 'factors', 'descompte', etc.).
        operacions: Llista de diccionaris, on cada diccionari conté informació sobre una operació (amb camps com 'id', 'clients', 'tipus', 'data', 'preu', etc.).
        clau_client: La clau única del client pel qual es vol generar la taula d'operacions.
        ordre: La clau pel qual s'ordenaran les operacions (per exemple, 'data', 'preu', etc.).

    Funcionament:
        1. Obté la informació del client a partir del diccionari 'clients' utilitzant la 'clau_client'.
        2. Si el client no existeix, retorna un missatge indicant-ho.
        3. Llista totes les operacions associades al client utilitzant la funció 'llistar_operacions_client'.
        4. Ordena les operacions segons el paràmetre 'ordre'.
        5. Crea les línies de la taula amb la informació del client i les seves operacions.
        6. Calcula la suma dels preus de les operacions, aplica el descompte del client, 
           calcula els impostos i el total final.
        7. Afegeix aquests càlculs a la taula.
    
    Retorn:
        Una llista de cadenes de text que representen les línies de la taula amb 
        la informació del client i les seves operacions ordenades.
        En total hi ha 55 caràcters d'ample

    Exemple:

        clients = { 'client_joan': { 'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc mitjà'], 'descompte': 10 }}
        operacions = [
            { 'id': 1, 'clients': ['client_joan'], 'tipus': 'Gestió laboral', 'data': '2023-09-01', 'preu': 300.00 },
            { 'id': 2, 'clients': ['client_joan'], 'tipus': 'Declaració d\'impostos', 'data': '2023-10-06', 'preu': 150.00 }
        ]

        Joan, 30                      ['autònom', 'risc mitjà']
        -------------------------------------------------------
        Tipus                         Data               Preu
        Gestió laboral                2023-09-01         300.00
        Declaració d'impostos         2023-10-06         150.00
        -------------------------------------------------------
                                                   Suma: 450.00
        Descompte: 10%                             Preu: 405.00
        Impostos:  21% (85.05)                    Total: 490.05
    
    """
    client = clients.get(clau_client)
    
    if not client:
        return [f"Client amb clau {clau_client} no existeix."]
    
    operacions_client = llistar_operacions_client(operacions, clau_client)
    
    # Ordenar operacions segons el paràmetre 'ordre'
    operacions_client.sort(key=lambda x: x[ordre])

    # Crear les línies de la taula
    linies = []
    
    # Encapsular les dades del client
    linies.append(f"{client['nom']}, {client['edat']}".ljust(30) + str(client['factors']).rjust(25))
    linies.append("-" * 55)
    linies.append(f"Tipus".ljust(30) + "Data".ljust(8) + "Preu".rjust(15))

    # Variables per a càlculs totals
    suma_preus = 0.0

    # Afegir les operacions del client a la taula
    for operacio in operacions_client:
        tipus = operacio['tipus'].ljust(30)
        data = operacio['data'].ljust(8)
        preu = f"{operacio['preu']:.2f}".rjust(15)
        linies.append(f"{tipus}{data}{preu}")
        suma_preus += operacio['preu']
    
    linies.append("-" * 55)

    # Càlculs finals
    descompte_percentatge = client['descompte'] / 100.0
    preu_descomptat = suma_preus * (1 - descompte_percentatge)
    impostos = preu_descomptat * 0.21
    total = preu_descomptat + impostos

    # Afegir la suma i els detalls de descompte, impostos i total
    linies.append(f"Suma: {suma_preus:.2f}".rjust(55))
    linies.append(f"Descompte: {client['descompte']}%".ljust(35) + f"Preu: {preu_descomptat:.2f}".rjust(20))
    linies.append(f"Impostos:  21% ({impostos:.2f})".ljust(35) + f"Total: {total:.2f}".rjust(20))

    return linies

def mostrar_menu():
    """
    Genera el menú principal de l'aplicació de Gestió de Notaria.

    Aquesta funció retorna una llista de cadenes de text que representen les opcions disponibles en el menú principal de l'aplicació. Aquest menú permet a l'usuari seleccionar diverses operacions relacionades amb la gestió de clients i operacions en una notaria.

    Retorn:
        Llista de cadenes de text amb les opcions del menú principal.

    Exemples:
        mostrar_menu() ->
            [
                "=== Menú de Gestió de Notaria ===",
                "1. Afegir client",
                "2. Modificar client",
                "3. Esborrar client",
                "4. Llistar clients",
                "5. Afegir operació",
                "6. Modificar operació",
                "7. Esborrar operació",
                "8. Llistar operacions",
                "0. Sortir"
            ]
    """
    return [
        "=== Menú de Gestió de Notaria ===",
        "1. Afegir client",
        "2. Modificar client",
        "3. Esborrar client",
        "4. Llistar clients",
        "5. Afegir operació",
        "6. Modificar operació",
        "7. Esborrar operació",
        "8. Llistar operacions",
        "0. Sortir"
    ]

def obtenir_opcio():
    """
    Demana a l'usuari que seleccioni una opció i retorna l'opció introduïda.

    Aquesta funció mostra un missatge a la consola per sol·licitar a l'usuari que 
    introdueixi una opció, que pot ser un número o una paraula clau. Després de 
    rebre l'entrada, la funció elimina els espais en blanc al principi i al final 
    de la cadena abans de retornar-la.

    Text:
        "Selecciona una opció (número o paraula clau): "

    Retorn:
        str: La cadena introduïda per l'usuari sense espais en blanc al principi i al final.

    Exemples:
        # Suposem que l'usuari introdueix " 1 " ->
        obtenir_opcio()
        '1'

        # Suposem que l'usuari introdueix " sortir " ->
        obtenir_opcio()
        'sortir'
    """
    opcio = input("Selecciona una opció (número o paraula clau): ")
    return opcio.strip()

def afegir_client_menu():
    """
    Gestiona el procés d'afegir un nou client mitjançant interacció amb l'usuari.

    Aquesta funció guia l'usuari a través dels passos per introduir les dades d'un nou client,
    validant cada entrada i demanant reintroducció si no és vàlida. Finalment, afegeix el
    client a la base de dades si totes les dades són correctes.

    Procés:
    1. Sol·licita i valida el nom del client:
       - Només s'accepten lletres i espais.
    2. Sol·licita i valida l'edat del client:
       - Ha de ser un número entre 18 i 100.
    3. Sol·licita i valida els factors del client:
       - Primer factor: 'autònom' o 'empresa'
       - Segon factor: 'risc alt', 'risc baix' o 'risc mitjà'
       - Verifica que la combinació de factors sigui vàlida.
    4. Sol·licita i valida el descompte del client:
       - Ha de ser un número entre 0 i 20 (permet decimals).
    5. Afegeix el nou client a la base de dades si totes les validacions són correctes.

    En cada pas, si l'entrada no és vàlida, es demana a l'usuari que la reintrodueixi
    fins que es proporcioni una entrada correcta.

    Cadenes:
        "Introdueix el nom del client: "
        "Nom no vàlid. Només s'accepten lletres i espais."
        "Introdueix l'edat del client (18-100): "
        "Edat no vàlida. Introdueix un número entre 18 i 100."
        "Introdueix el primer factor ('autònom' o 'empresa'): "
        "Factor no vàlid. Ha de ser 'autònom' o 'empresa'."
        "Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): "
        "Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'."
        "Introdueix el descompte (0-20): "
        "Descompte no vàlid. Ha de ser un número entre 0 i 20."
        "S'ha afegit el client amb clau {nova_clau}."
    
    Retorna:
        list: Una llista de cadenes de text amb missatges sobre l'estat del procés,
              incloent possibles errors i la confirmació de l'afegiment del client.

    Exemple de retorn:
    [
        "=== Afegir Client ===",
        "Nom no vàlid. Només s'accepten lletres i espais.",
        "Edat no vàlida. Introdueix un número entre 18 i 100.",
        "Factor no vàlid. Ha de ser 'autònom' o 'empresa'.",
        "Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'.",
        "Descompte no vàlid. Ha de ser un número entre 0 i 20.",
        "S'ha afegit el client amb clau client_123."
    ]
    """
    linies = ["=== Afegir Client ==="]
    
    nom = input("Introdueix el nom del client: ").strip()
    while not validar_nom(nom):
        linies.append("Nom no vàlid. Només s'accepten lletres i espais.")
        nom = input("Introdueix el nom del client: ").strip()

    edat = input("Introdueix l'edat del client (18-100): ").strip()
    while not edat.isdigit() or not validar_edat(int(edat)):
        linies.append("Edat no vàlida. Introdueix un número entre 18 i 100.")
        edat = input("Introdueix l'edat del client (18-100): ").strip()
    edat = int(edat)

    factors = []
    factor1 = input("Introdueix el primer factor ('autònom' o 'empresa'): ").strip()
    while factor1 not in ["autònom", "empresa"]:
        linies.append("Factor no vàlid. Ha de ser 'autònom' o 'empresa'.")
        factor1 = input("Introdueix el primer factor ('autònom' o 'empresa'): ").strip()
    factors.append(factor1)

    factor2 = input("Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): ").strip()
    while factor2 not in ["risc alt", "risc baix", "risc mitjà"]:
        linies.append("Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'.")
        factor2 = input("Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): ").strip()
    factors.append(factor2)

    if not validar_factors(factors):
        linies.append("Els factors no són vàlids.")
        return linies

    descompte = input("Introdueix el descompte (0-20): ").strip()
    while not descompte.replace('.', '', 1).isdigit() or not validar_descompte(float(descompte)):
        linies.append("Descompte no vàlid. Ha de ser un número entre 0 i 20.")
        descompte = input("Introdueix el descompte (0-20): ").strip()
    descompte = float(descompte)

    nova_clau = afegir_client(clients, nom, edat, factors, descompte)
    linies.append(f"S'ha afegit el client amb clau {nova_clau}.")
    return linies

def modificar_client_menu():
    """
    Gestiona el procés de modificació d'un client existent mitjançant interacció amb l'usuari.

    Aquesta funció guia l'usuari a través dels passos per modificar les dades d'un client
    específic en la base de dades. El procés inclou:
    1. Sol·licitar la clau del client a modificar.
    2. Verificar l'existència del client.
    3. Seleccionar el camp a modificar (nom, edat, factors, descompte).
    4. Introduir i validar el nou valor pel camp seleccionat.
    5. Actualitzar les dades del client.

    Funcionament detallat:
    - Inicia amb el títol "=== Modificar Client ===".
    - Demana la clau del client i verifica la seva existència.
    - Si el client no existeix, retorna un missatge d'error.
    - Mostra els camps disponibles per modificar.
    - Sol·licita el camp a modificar i valida la selecció.
    - Segons el camp seleccionat:
      - Nom: Demana i valida el nou nom (només lletres i espais).
      - Edat: Demana i valida la nova edat (entre 18 i 100).
      - Factors: Demana i valida els nous factors (tipus i risc).
      - Descompte: Demana i valida el nou descompte (entre 0 i 20).
    - Intenta modificar el client utilitzant la funció `modificar_client()`.
    - Retorna missatges d'error si hi ha problemes o confirmació si s'ha modificat correctament.

    Cadenes:
        "Introdueix la clau del client a modificar (per exemple, 'client_0'): "
        "Client amb clau {clau_client} no existeix."
        "Camps disponibles per modificar: nom, edat, factors, descompte"
        "Introdueix el camp que vols modificar: "
        "El camp {camp} no és vàlid."
        "Introdueix el nou nom: "
        "Nom no vàlid. Només s'accepten lletres i espais."
        "Introdueix la nova edat (18-100): "
        "Edat no vàlida. Introdueix un número entre 18 i 100."
        "Introdueix el primer factor ('autònom' o 'empresa'): "
        "Factor no vàlid. Ha de ser 'autònom' o 'empresa'."
        "Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): "
        "Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'."
        "Introdueix el nou descompte (0-20): "
        "Descompte no vàlid. Ha de ser un número entre 0 i 20."
        "S'ha modificat el client {clau_client}."

    Retorna:
        list: Missatges sobre l'estat del procés, incloent errors o confirmació de la modificació.

    Notes:
    - Utilitza funcions auxiliars com `validar_nom()`, `validar_edat()`, 
      `validar_factors()`, i `validar_descompte()` per assegurar la integritat de les dades.
    - La funció `modificar_client()` s'encarrega de l'actualització real de les dades en el diccionari `clients`.
    """
    linies = ["=== Modificar Client ==="]
    
    clau_client = input("Introdueix la clau del client a modificar (per exemple, 'client_0'): ").strip()
    if clau_client not in clients:
        linies.append(f"Client amb clau {clau_client} no existeix.")
        return linies

    linies.append("Camps disponibles per modificar: nom, edat, factors, descompte")
    camp = input("Introdueix el camp que vols modificar: ").strip()
    if camp not in ["nom", "edat", "factors", "descompte"]:
        linies.append(f"El camp {camp} no és vàlid.")
        return linies

    if camp == "nom":
        nou_valor = input("Introdueix el nou nom: ").strip()
        while not validar_nom(nou_valor):
            linies.append("Nom no vàlid. Només s'accepten lletres i espais.")
            nou_valor = input("Introdueix el nou nom: ").strip()
    elif camp == "edat":
        nou_valor = input("Introdueix la nova edat (18-100): ").strip()
        while not nou_valor.isdigit() or not validar_edat(int(nou_valor)):
            linies.append("Edat no vàlida. Introdueix un número entre 18 i 100.")
            nou_valor = input("Introdueix la nova edat (18-100): ").strip()
        nou_valor = int(nou_valor)
    elif camp == "factors":
        factors = []
        factor1 = input("Introdueix el primer factor ('autònom' o 'empresa'): ").strip()
        while factor1 not in ["autònom", "empresa"]:
            linies.append("Factor no vàlid. Ha de ser 'autònom' o 'empresa'.")
            factor1 = input("Introdueix el primer factor ('autònom' o 'empresa'): ").strip()
        factors.append(factor1)

        factor2 = input("Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): ").strip()
        while factor2 not in ["risc alt", "risc baix", "risc mitjà"]:
            linies.append("Factor no vàlid. Ha de ser 'risc alt', 'risc baix' o 'risc mitjà'.")
            factor2 = input("Introdueix el segon factor ('risc alt', 'risc baix' o 'risc mitjà'): ").strip()
        factors.append(factor2)

        if not validar_factors(factors):
            linies.append("Els factors no són vàlids.")
            return linies
        nou_valor = factors
    elif camp == "descompte":
        nou_valor = input("Introdueix el nou descompte (0-20): ").strip()
        while not nou_valor.replace('.', '', 1).isdigit() or not validar_descompte(float(nou_valor)):
            linies.append("Descompte no vàlid. Ha de ser un número entre 0 i 20.")
            nou_valor = input("Introdueix el nou descompte (0-20): ").strip()
        nou_valor = float(nou_valor)

    error = modificar_client(clients, clau_client, camp, nou_valor)
    if error:
        linies.append(error)
    else:
        linies.append(f"S'ha modificat el client {clau_client}.")
    
    return linies

def esborrar_client_menu():
    """
    Gestiona el procés d'esborrar un client existent mitjançant interacció amb l'usuari.

    Aquesta funció guia l'usuari per esborrar un client específic de la base de dades.
    El procés inclou:
    1. Sol·licitar la clau del client a esborrar.
    2. Verificar l'existència del client en el diccionari `clients`.
    3. Esborrar el client si existeix.
    4. Proporcionar feedback sobre l'operació.

    Funcionament:
    - Inicia amb el títol "=== Esborrar Client ===".
    - Demana a l'usuari la clau del client (exemple: 'client_0').
    - Verifica si la clau existeix en `clients`:
      - Si existeix: Esborra el client i confirma l'acció.
      - Si no existeix: Informa que el client no es troba.

    Cadenes:
        "Introdueix la clau del client a esborrar (per exemple, 'client_0'): "
        "S'ha esborrat el client {clau_client}."
        "Client amb clau {clau_client} no existeix."

    Retorna:
        list: Missatges sobre l'estat del procés, incloent errors o confirmacions.

    Exemples de retorn:
    1. Cas de client trobat:
       [
           "=== Esborrar Client ===",
           "S'ha esborrat el client client_1."
       ]
    2. Cas de client no trobat:
       [
           "=== Esborrar Client ===",
           "Client amb clau client_999 no existeix."
       ]
    """
    linies = ["=== Esborrar Client ==="]
    
    clau_client = input("Introdueix la clau del client a esborrar (per exemple, 'client_0'): ").strip()
    if clau_client in clients:
        esborrar_client(clients, clau_client)
        linies.append(f"S'ha esborrat el client {clau_client}.")
    else:
        linies.append(f"Client amb clau {clau_client} no existeix.")
    
    return linies

def llistar_clients_menu():
    """
    Genera una llista de missatges per mostrar els clients registrats.

    Aquesta funció crea una representació textual de tots els clients presents en el 
    diccionari global `clients`.

    Funcionament:
    1. Inicia amb el títol "=== Llistar Clients ===".
    2. Si no hi ha clients, mostra un missatge indicant-ho.
    3. Si hi ha clients, llista cada client amb la seva clau i dades associades.

    Retorna:
        list: Missatges a mostrar, incloent el títol i les dades dels clients si n'hi ha.

    Exemples:
    1. Sense clients:
       ["=== Llistar Clients ===", "No hi ha clients per mostrar."]

    2. Amb clients:
       [
           "=== Llistar Clients ===",
           "client_1: {'nom': 'Joan', 'edat': 30, 'factors': ['autònom', 'risc mitjà'], 'descompte': 10}",
           "client_2: {'nom': 'Maria', 'edat': 45, 'factors': ['empresa', 'risc baix'], 'descompte': 15}"
       ]

    Notes:
    - Requereix un diccionari global `clients` amb les dades dels clients.
    - Cada client es representa per una clau única i un diccionari de dades.
    """
    linies = ["=== Llistar Clients ==="]
    
    if not clients:
        linies.append("No hi ha clients per mostrar.")
        return linies
    
    for clau, dades in clients.items():
        linies.append(f"{clau}: {dades}")
    
    return linies

def dibuixar_llista(llista):
    """
    Imprimeix cada element d'una llista en una línia separada.

    Paràmetres:
        llista (list): La llista d'elements a imprimir.

    Funcionament:
    - Itera sobre cada element de la llista.
    - Imprimeix cada element en una nova línia.

    Nota:
    - Aquesta funció no retorna cap valor, només imprimeix a la consola.
    - Útil per mostrar resultats de menús o llistats d'elements.
    """
    for linia in llista:
        print(linia)

def mainRun():
    """
    Funció principal que gestiona el bucle del menú i l'execució del programa.

    Aquesta funció implementa un bucle infinit que mostra el menú principal, 
    processa les opcions de l'usuari i executa les funcions corresponents.

    Funcionament:
    1. Neteja la pantalla al principi de cada iteració.
    2. Mostra el menú principal.
    3. Obté l'opció seleccionada per l'usuari.
    4. Executa l'acció corresponent segons l'opció escollida:
       - '0' o 'sortir': Finalitza el programa.
       - '1' o 'afegir client': Executa el menú per afegir un client.
       - '2' o 'modificar client': Executa el menú per modificar un client.
       - '3' o 'esborrar client': Executa el menú per esborrar un client.
       - '4' o 'llistar clients': Mostra la llista de clients.
    5. Si l'opció no és vàlida, mostra un missatge d'error.

    Cadenes:
        "Fins aviat!"
        "Opció no vàlida. Si us plau, tria una opció del menú."

    Dependències:
    - clearScreen(): Funció per netejar la pantalla.
    - dibuixar_llista(): Funció per mostrar una llista d'elements.
    - mostrar_menu(): Funció que retorna les opcions del menú principal.
    - obtenir_opcio(): Funció per obtenir l'input de l'usuari.
    - afegir_client_menu(), modificar_client_menu(), esborrar_client_menu(), 
      llistar_clients_menu(): Funcions per gestionar les diferents opcions del menú.

    Notes:
    - El bucle continua fins que l'usuari selecciona l'opció de sortir.
    - Totes les entrades es converteixen a minúscules per facilitar la comparació.
    - Les opcions del menú es poden seleccionar tant pel número com pel nom.
    """
    while True:
        clearScreen()  # Esborrem la pantalla
        dibuixar_llista(mostrar_menu())
        
        opcio = obtenir_opcio()
        
        if opcio.lower() in ['0', 'sortir']:
            dibuixar_llista(["Fins aviat!"])
            break
        elif opcio.lower() in ['1', 'afegir client']:
            dibuixar_llista(afegir_client_menu())
        elif opcio.lower() in ['2', 'modificar client']:
            dibuixar_llista(modificar_client_menu())
        elif opcio.lower() in ['3', 'esborrar client']:
            dibuixar_llista(esborrar_client_menu())
        elif opcio.lower() in ['4', 'llistar clients']:
            dibuixar_llista(llistar_clients_menu())
        else:
            dibuixar_llista(["Opció no vàlida. Si us plau, tria una opció del menú."])

if __name__ == '__main__':
    mainRun()
