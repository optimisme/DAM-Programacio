
# Explicació

Aquests exercicis són alhora exemples d'exàmen

# Exercici0

Resol els mètodes de l'*Exercici0* segons la descripció dels seus comentaris al codi.


# Exercici1

Resol els mètodes de l'*Exercici1* segons la descripció dels seus comentaris al codi.





```python


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
```