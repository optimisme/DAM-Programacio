import os
import platform
import random

# Solució al projecte de LaOca amb llistes i funcions

idxPosicio = 0
idxEspera = 1
idxColor = 2
idxNom = 3

jugadors = []   # Llista de llistes tipus [posicio, espera, color, nom]
ranking = []    # Llista amb els index ordenats de cada jugador (segons la seva posició a la llista jugadors)
prompt = []     # Llista amb les frases que es dibuixen al prompt   

# Funció per netejar la pantalla
def clearScreen():

    sistema = platform.system()
    if sistema == "Windows":
        os.system('cls')
    else:
        os.system('clear')

# Busca un jugador a partir del color de la fitxa (torna -1 si no juga)
def buscaJugador(color):
    idxJugador = -1
    for cnt in range(0, len(jugadors)):
        if jugadors[cnt][idxColor] == color:
            idxJugador = cnt
            break
    return idxJugador

# Assigna un nom a una fitxa
def assignarColor(color):
    global jugadors
    
    nom = ""
    while True:
        nom = input(f"Escull un jugador per la fitxa '{color}': ")
        nomValid = True
        for cnt in range(0, len(nom)):
            lletra = nom[cnt]
            if not lletra.isalpha() and not lletra == " ":
                nomValid = False
                break # Sortir del for de lletres del nom
        if not nomValid:
            print("El nom escollit no és vàlid.")
        else:
            break # Sortir del while de nom vàlid

    # Busquem aquest color de fitxa a la llista de jugadors
    idxJugador = buscaJugador(color)

    # Assignar el nom al jugador que toca (o afegir-lo si no està a la llista)
    if idxJugador == -1:
        jugadors.append([0, 0, color, nom])
    else:
        jugadors[idxJugador][idxNom] = nom

# Funció per mostrar el menú principal
def menuPrincipalDibuix():
    global jugadors

    # Defineix els textos dels noms i partida
    textos = [ "no assignat", "no assignat", "no assignat", "no assignat"]
    nom = ""

    # Assignar els noms als textos (i justificar-los)
    for cnt in range(0, len(textos)):
        if cnt == 0:
            idxJugador = buscaJugador("Vermella")
            if idxJugador != -1:
                textos[0] = jugadors[idxJugador][idxNom]
        elif cnt == 1:
            idxJugador = buscaJugador("Blava")
            if idxJugador != -1:
                textos[1] = jugadors[idxJugador][idxNom]
        elif cnt == 2:
            idxJugador = buscaJugador("Verda")
            if idxJugador != -1:
                textos[2] = jugadors[idxJugador][idxNom]
        elif cnt == 3:
            idxJugador = buscaJugador("Groga")
            if idxJugador != -1:
                textos[3] = jugadors[idxJugador][idxNom]

    # Afegir els parentesis i alinear a la dreta
    for cnt in range(0, len(textos)):
        textos[cnt] = f"({textos[cnt]})"
        textos[cnt] = textos[cnt].rjust(16)

    # Text de començar la partida
    if len(jugadors) >= 2:
        textComencar = ""
    else:
        textComencar = "(no disponible)"
        
    textComencar = textComencar.rjust(16)

    # Neteja la pantalla
    clearScreen()

    # Dibuixa el menu
    print(f"""
La Oca
----------
1) Assignar jugador Vermell {textos[0]}
2) Assignar jugador Blau    {textos[1]}
3) Assignar jugador Verd    {textos[2]}
4) Assignar jugador Groc    {textos[3]}
5) Començar partida         {textComencar}
0) Sortir
    """)

# Funció per executar el menú principal
def menuPrincipal():
    global jugadors

    menuError = ""
    while True:
        menuPrincipalDibuix()
        
        # Si hi ha un error, mostrar-lo
        if menuError != "":
            print(f"La opció '{menuError}' no és vàlida.")

        # Demanar una opció del menú
        menuOpcioText = input("Escull una opció [0 - 5]: ")
        menuError = ""

        # Comprovar si la opció sel·leccionada és vàlida i escollir-la
        if not menuOpcioText.isdigit():
            menuError = menuOpcioText
        else:
            menuOpcioNum = int(menuOpcioText)
            if len(jugadors) < 2 and menuOpcioNum == 5:
                menuError = menuOpcioText
            elif not (menuOpcioNum in [0, 1, 2, 3, 4, 5]):
                menuError = menuOpcioText
            elif menuOpcioNum == 0:
                # Sortir del menú
                break
            elif menuOpcioNum == 1:
                assignarColor("Vermella")
            elif menuOpcioNum == 2:
                assignarColor("Blava")
            elif menuOpcioNum == 3:
                assignarColor("Verda")
            elif menuOpcioNum == 4:
                assignarColor("Groga")
            elif menuOpcioNum == 5:
                jocJugar()

# Dibuixa el taulell de joc
def taulellDibuixar():
    global jugadors

    # Definir el text que surt a cada casella del joc
    t = []
    for cntCasella in range(0, 54):
        txtCasella = " "
        jugadorsCasella = 0

        # Posar la lletra que correspon el jugador que hi ha a la casella (si n'hi ha)
        for cntJugador in range(0, len(jugadors)):
            if jugadors[cntJugador][idxPosicio] == cntCasella:
                jugadorsCasella = jugadorsCasella + 1
                color = jugadors[cntJugador][idxColor]
                if color == "Verda":
                    txtCasella = "D"
                else:
                    txtCasella = color[0]

        # Si hi ha més d'un jugador apareix el número de jugadors
        if jugadorsCasella > 1:
            txtCasella = str(jugadorsCasella)

        t.append(txtCasella)

    print(f"""
    +------+------+------+------+------+------+------+------+
    |00   {t[0]}|01   {t[1]}|02   {t[2]}|03   {t[3]}|04   {t[4]}|05*  {t[5]}|06P  {t[6]}|07   {t[7]}|
    +------+------+------+------+------+------+------+------+
    |25*  {t[25]}|26   {t[26]}|27   {t[27]}|28   {t[28]}|29U  {t[29]}|30*  {t[30]}|31   {t[31]}|08   {t[8]}|
    +------+------+------+------+------+------+------+------+
    |24D  {t[24]}|43   {t[43]}|44   {t[44]}|45   {t[45]}|46*  {t[46]}|47   {t[47]}|32   {t[32]}|09*  {t[9]}|
    +------+------+------+------+------+------+------+------+
    |23   {t[23]}|42   {t[42]}|53     LaOca       {t[53]}|48   {t[48]}|33   {t[33]}|10D  {t[10]}|
    +------+------+------+------+------+------+------+------+
    |22   {t[22]}|41*  {t[41]}|52C  {t[52]}|51   {t[51]}|50   {t[50]}|49   {t[49]}|34*  {t[34]}|11   {t[11]}|
    +------+------+------+------+------+------+------+------+
    |21*  {t[21]}|40   {t[40]}|39   {t[39]}|38L  {t[38]}|37*  {t[37]}|36   {t[36]}|35   {t[35]}|12   {t[12]}|
    +------+------+------+------+------+------+------+------+
    |20   {t[20]}|19P  {t[19]}|18   {t[18]}|17H  {t[17]}|16*  {t[16]}|15   {t[15]}|14   {t[14]}|13   {t[13]}|
    +------+------+------+------+------+------+------+------+
""")

# Esborra els textos del prompt
def promptEsborrar():
    global prompt
    for cnt in range(0, len(prompt)):
        promptAfegir("")

# Afegeix un text al final del prompt
def promptAfegir(text):
    global prompt
    prompt.append(text)
    if len(prompt) >= 4:
        prompt.pop(0)

# Dibuixa els textos del prompt
def promptDibuixar():
    global prompt
    for cnt  in range(0, len(prompt)):
        print(prompt[cnt])

# Dibuixa el taulell i el prompt
def dibuixar():
    clearScreen()
    taulellDibuixar()
    promptDibuixar()

# Inicialitzar una partida
def jocIniciar():
    global jugadors
    global ranking

    # Esborrar els missatges del prompt
    promptEsborrar()

    # Reinicia posicions, esperes dels jugadors
    for cnt in range(0, len(jugadors)):
        jugadors[cnt][idxPosicio] = 0
        jugadors[cnt][idxEspera] = 0

    # Primer juga la primera fitxa amb nom
    torn = 0

    # Esborra el ranking
    ranking = []

    return torn

# Demanar al jugador quina trampa vol fer (retorna una casella vàlida)
def jocJugarDemanaTrampa(color):
    casella = -1
    while True:
        dibuixar()
        opcio = input("A quina casella vols anar? ")

        # Valida la casella a la que es vol fer trampa i la mou si és vàlida
        if opcio.isdigit():
            posicio = int(opcio)
            if posicio >= 0 and posicio <= 53:
                promptAfegir(f"Trampa '{color}' va a la casella {posicio}")
                casella = posicio
                break # Sortir del while
            else:
                promptAfegir(f"La casella {posicio} no existeix.")
        else:
            promptAfegir(f"Opció '{opcio}' no és vàlida")
    return casella

# Executa l'acció segons la casella, torna dos valors: si s'ha acabat la partida, si repeteix tirada
def jocJugarAccioCasella(tornJugador):
    global jugadors
    global ranking

    posicio = jugadors[tornJugador][idxPosicio]
    espera = jugadors[tornJugador][idxEspera]
    color = jugadors[tornJugador][idxColor]
    nom = jugadors[tornJugador][idxNom]
    repeteixTirada = False

    # Mirar si la fitxa ha arribat al final
    if posicio >= 53:

        # Afegir el jugador al ranking (si cal)
        if not tornJugador in ranking:
            ranking.append(tornJugador)
            
        # Número de jugadors que han acabat
        numeroJugadorsAcabats = len(ranking)

        # Número de jugadors que falten per acabar
        numeroJugadorsJugant = len(jugadors) - numeroJugadorsAcabats

        # Si només queda un jugador jugant, ha acabat la partida, afegir-lo al ranking
        if numeroJugadorsJugant <= 1:
            for cnt in range(0, len(jugadors)):
                jugador = jugadors[cnt]
                if jugador[idxPosicio] < 53:
                    ranking.append(cnt)
                    break
            return True, False # Partida acabada, No repeteix tirada
        
        return False, False # Partida continua, No repeteix tirada

    # Si ha caigut en una casella 'oca'
    llistaOques = [5, 9, 16, 21, 25, 30, 34, 37, 41, 46, 53]
    if posicio in llistaOques:
        idxSeguentOca = llistaOques.index(posicio) + 1
        novaPosicio = llistaOques[idxSeguentOca]
        promptAfegir(f"Casella {posicio}, Oca, la fitxa '{color}' ({nom}) va a la {novaPosicio} i torna a tirar")
        posicio = novaPosicio
        repeteixTirada = True

    elif posicio == 24:
        promptAfegir(f"Casella 24, Daus, la fitxa '{color}' ({nom}) va a la 10 i torna a tirar")
        posicio = 10
        repeteixTirada = True

    elif posicio == 10:
        promptAfegir(f"Casella 10, Daus, la fitxa '{color}' ({nom}) va a la 24 i torna a tirar") 
        posicio = 24
        repeteixTirada = True

    elif posicio == 6:
        promptAfegir(f"Casella 06, Pont, la fitxa '{color}' ({nom}) va a la 19")
        posicio = 19

    elif posicio == 19:
        promptAfegir(f"Casella 19, Pont, la fitxa '{color}' ({nom}) va a la 06")
        posicio = 6

    elif posicio == 17:
        promptAfegir(f"Casella 17, Hotel, la fitxa '{color}' ({nom}) estarà un torn sense jugar")
        jugadors[tornJugador][idxEspera] = 1

    elif posicio == 29:
        promptAfegir(f"Casella 29, Pou, la fitxa '{color}' ({nom}) estarà tres torns sense jugar")
        jugadors[tornJugador][idxEspera] = 3

    elif posicio == 38:
        promptAfegir(f"Casella 38, Laberint, la fitxa '{color}' ({nom}) estarà tres torns sense jugar")
        jugadors[tornJugador][idxEspera] = 3

    elif posicio == 52:
        promptAfegir(f"Casella 52, Calavera, la fitxa '{color}' ({nom}) torna a la casella 0")
        posicio = 0
    
    jugadors[tornJugador][idxPosicio] = posicio

    return False, repeteixTirada

# Escriu els textos del ranking al prompt
def jocJugarEscriuRanking():
    global jugadors
    global ranking
    
    promptAfegir("Final de la partida:")
    if len(ranking) == 2:
        finalPrimer = jugadors[ranking[0]][idxColor]
        nomPrimer = jugadors[ranking[0]][idxNom]
        finalSegon = jugadors[ranking[1]][idxColor]
        nomSegon = jugadors[ranking[1]][idxNom]
        promptAfegir(f"- La fitxa '{finalPrimer}' ({nomPrimer}) ha guanyat la partida")
        promptAfegir(f"- La fitxa '{finalSegon}' ({nomSegon}) ha perdut")
    elif len(ranking) == 3:
        finalPrimer = jugadors[ranking[0]][idxColor]
        nomPrimer = jugadors[ranking[0]][idxNom]
        finalSegon = jugadors[ranking[1]][idxColor]
        nomSegon = jugadors[ranking[1]][idxNom]
        finalTercer = jugadors[ranking[2]][idxColor]
        nomTercer = jugadors[ranking[2]][idxNom]
        promptAfegir(f"- La fitxa '{finalPrimer}' ({nomPrimer}) ha guanyat la partida")
        promptAfegir(f"- La fitxa '{finalSegon}' ({nomSegon}) ha quedat segona")
        promptAfegir(f"- La fitxa '{finalTercer}' ({nomTercer}) ha perdut")
    else:
        finalPrimer = jugadors[ranking[0]][idxColor]
        nomPrimer = jugadors[ranking[0]][idxNom]
        finalSegon = jugadors[ranking[1]][idxColor]
        nomSegon = jugadors[ranking[1]][idxNom]
        finalTercer = jugadors[ranking[2]][idxColor]
        nomTercer = jugadors[ranking[2]][idxNom]
        finalQuart = jugadors[ranking[3]][idxColor]
        nomQuart = jugadors[ranking[3]][idxNom]
        promptAfegir(f"- La fitxa '{finalPrimer}' ({nomPrimer}) ha guanyat la partida")
        promptAfegir(f"- La fitxa '{finalSegon}' ({nomSegon}) ha quedat segona")
        promptAfegir(f"- La fitxa '{finalTercer}' ({nomTercer}) ha quedat segona")
        promptAfegir(f"- La fitxa '{finalQuart}' ({nomQuart}) ha perdut")

# Juga un torn del joc, retorna dos valors: si surt de la partida, si repeteix tirada
def jocJugarTorn(tornJugador):
    global jugadors
    
    repeteixTirada = False

    # Simplificar l'accés a les dades amb variables (només per llegir-les, no modificar-les!)
    posicio = jugadors[tornJugador][idxPosicio]
    espera = jugadors[tornJugador][idxEspera]
    color = jugadors[tornJugador][idxColor]
    nom = jugadors[tornJugador][idxNom]

    if espera > 0:
        # Si el jugador està a l'espera de poder tornar a tirar
        if posicio == 17:
            promptAfegir(f"Casella 17, Hotel, la fitxa '{color}' ({nom}) no pot jugar aquest torn")
        elif posicio == 29:
            promptAfegir(f"Casella 29, Pou, la fitxa '{color}' ({nom}) no pot jugar, ha d'esperar {espera}")
        elif posicio == 38:
            promptAfegir(f"Casella 38, Laberint, la fitxa '{color}' ({nom}) no pot jugar, ha d'esperar {espera}")
        jugadors[tornJugador][idxEspera] = espera - 1

        return False, False # No surt de la partida, no repeteix tirada

    else:
        # Si el jugador pot tirar, escollir opció
        novaPosicio = -1
        while True:
            dibuixar()
            opcio = input(f"Torn de la fitxa '{color}' ({nom}), tirar dau? (si, trampa, sortir): ")
            if opcio == "sortir":
                return True, False # Surt de la partida, No repeteix tirada
            elif opcio == "trampa":
                novaPosicio = jocJugarDemanaTrampa(color)
                break
            elif opcio == "si":
                dau = random.randint(1, 6)
                novaPosicio = posicio + dau
                if novaPosicio > 53:
                    novaPosicio = 53
                promptAfegir(f"La fitxa '{color}' ({nom}) ha tret {dau}, va de la casella {posicio} a la casella {novaPosicio}")
                break
            else:
                promptAfegir(f"L'opció '{opcio}' no és vàlida")
        
        # Assignar la nova posició al jugador
        jugadors[tornJugador][idxPosicio] = novaPosicio
        
        # Executar acció de la cassela
        partidaAcabada, repeteixTirada = jocJugarAccioCasella(tornJugador)

        # Si la partida ha acabat
        if partidaAcabada:
            jocJugarEscriuRanking()
            while True:
                dibuixar()
                opcio = input("Tornar a jugar? (si, no, sortir): ")
                if opcio == "sortir" or opcio == "no":
                    return True, False
                elif opcio == "si":
                    jocIniciar()
                    repeteixTirada = False
                    break
                else:
                    promptAfegir(f"La opció '{opcio}' no és vàlida.")

    # S'ha executat el torn
    return False, repeteixTirada # No surt de la partida, ¿repeteixTirada?

# Retorna el següent jugador a tirar
def jocJugarSeguentTorn(tornActual):
    global jugadors

    cntPosicio = (tornActual + 1) % len(jugadors)

    # Buscar una "volta" completa a l'array
    while cntPosicio != tornActual:
        jugador = jugadors[cntPosicio]
        if jugador[idxPosicio] < 53:
            return cntPosicio
        cntPosicio = (cntPosicio + 1) % len(jugadors)

    # Si no s'ha trobat cap jugador 
    return -1

# Jugar a LaOca
def jocJugar():

    # Inicia el joc i rep el número de jugador que comença
    tornJugador = jocIniciar()
    while True:
        dibuixar()
        sortir, repeteixTirada = jocJugarTorn(tornJugador)
        if sortir:
            break
        elif not repeteixTirada:
            tornJugador = jocJugarSeguentTorn(tornJugador)

menuPrincipal()