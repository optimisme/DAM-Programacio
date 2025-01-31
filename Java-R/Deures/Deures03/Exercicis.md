
# Exercici 0300

Crea la classe 'Estudiant', que és un sistema que permet registrar estudiants en un curs. 

El sistema ha de ser capaç de comptar el total d'estudiants registrats i limitar el nombre de registres segons la capacitat del curs.

**Atributs Privats d'Instància:**

- String nom: El nom de l'estudiant.

- String id: L'ID únic de l'estudiant.

**Atributs Privats Estàtics:**

- int comptadorEstudiants: Un comptador que porta la compte del total d'estudiants registrats.

- final int CAPACITAT_MAXIMA = 5: La capacitat màxima d'estudiants en el curs.

**Constructor:**

Un constructor que accepta nom i id com a paràmetres. Aquest constructor ha de verificar si encara hi ha capacitat en el curs abans de registrar a l'estudiant. Si la capacitat està plena, no ha de permetre la creació d'una nova instància i ha de mostrar un missatge d'error.

Mètodes Públics d'Instància:

**Getters i Setters**

Fes els Getters i Setters de 'nom' i 'id'

**Mètodes Públics Estàtics:**

- getComptadorEstudiants(): Retorna el nombre total d'estudiants registrats.

- hiHaCapacitat(): Retorna true si encara hi ha capacitat per a registrar més estudiants, false en cas contrari.

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercici0300

# A la carpeta "Deures03" executar el programa
./run.sh com.exercici0300.Main

# A la carpeta "Deures03" executar el test
./runTest.sh com.exercicis.TestExercici0300

# Testos individuals
./runTest.sh com.exercicis.TestExercici0300#testMaxCapacityExceeded
./runTest.sh com.exercicis.TestExercici0300#testRemainingCapacityCheck
./runTest.sh com.exercicis.TestExercici0300#testNoRemainingCapacity
```

# Exercici 0301

Crea la classe 'ControlTemperatura' que permet gestionar la temperatura de diferents zones d'un edifici. 

Aquest sistema haurà de poder registrar la temperatura de cada zona i proporcionar la temperatura mitjana de tot l'edifici. 

També permetrà ajustar la temperatura de qualsevol zona i veure l'efecte que això té sobre la temperatura mitjana global.

**Atributs**:

* **temperaturaTotal** Estàtic, privat de tipus double
* **comptadorZones** Estàtic, privat de tipus int
* **nomZona** privat de tipus String
* **temperatura** privat de tipus double

**Constructor**:

El constructor accepta com a paràmetres 'nomZona' i 'temperatura' i actualitza els atributs de la instància.

El constructor també suma la temperatura a la 'temperaturaTotal' estàtica i suma 1 a 'comptadorZones'

**Mètodes d'Instància**:

- Getters per a 'nomZona' i 'temperatura' (no hi ha setters)

- ajustaTemperatura(double novaTemperatura): Un mètode que permeti ajustar la temperatura d'una zona específica. Aquest mètode haurà d'actualitzar la temperatura total registrada per a reflectir el canvi. És a dir:

    * Ha de restar l'antic valor de temperatura de la instància de 'temperaturaTotal'

    * Ha de posar com a valor de temperatura de la instància 'novaTemperatura'

    * Ha de sumar la 'novaTemperatura' a 'temperaturaTotal'

**Mètodes Estàtics**:

- getTemperaturaMitjana(): Un mètode que retorne la temperatura mitjana de l'edifici, calculada a partir de la temperatura total i el nombre de zones registrades.

    És a dir, si no hi ha cap zona retorna 0 i si hi ha zones retorna: temperaturaTotal / comptadorZones

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercici0301

# A la carpeta "Deures03" executar el programa
./run.sh com.exercici0301.Main

# A la carpeta "Deures03" executar el test
./runTest.sh com.exercicis.TestExercici0301

# Testos individuals
./runTest.sh com.exercicis.TestExercici0301#testTemperaturaMitjanaInicial
./runTest.sh com.exercicis.TestExercici0301#testCreacioZones
./runTest.sh com.exercicis.TestExercici0301#testAjustarTemperatura
./runTest.sh com.exercicis.TestExercici0301#testTemperaturaMitjanaDespresDeEliminarZones
```

# Exercici 0302

Crea tres classes 'Autor', 'Llibre' i 'Prestec'

*Classe Autor*

**Atributs** privats:

- nom (String): El nom complet de l'autor.
- nacionalitat (String): La nacionalitat de l'autor.

**Constructor**:

Un constructor que inicialitzi el nom i la nacionalitat de l'autor.

**Mètodes**:

- Setters i getters per a cada atribut.

*Classe Llibre*

**Atributs**:

- titol (String): El títol del llibre.
- autor (Autor): Una instància de Autor que representa l'autor del llibre.
- anyPublicacio (int): L'any de publicació del llibre.

**Constructor**:

Un constructor que inicialitzi el titol, l'autor, i l'anyPublicacio.

**Mètodes**:

- Setters i getters per a cada atribut.

*Classe Préstec*

**Atributs**:

- llibre (Llibre): El llibre que s'ha prestat.
- dataPrestec (String): La data en què es va realitzar el préstec.
- dataRetorn (String): La data en què s'ha de retornar el llibre.

**Constructors**:

Un constructor que inicialitzi el llibre, la dataPrestec, i la dataRetorn.

**Mètodes**:

- Setters i getters per a cada atribut.

- Un mètode estaEnTermini() que retorni un booleà indicant si el llibre s'ha retornat dins del termini establert (pots simular-ho amb una comprovació simple de la data).

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercici0302

# A la carpeta "Deures03" executar el programa
./run.sh com.exercici0302.Main

# A la carpeta "Deures03" executar el test
./runTest.sh com.exercicis.TestExercici0302

# Testos individuals
./runTest.sh com.exercicis.TestExercici0302#testCreacioAutor
./runTest.sh com.exercicis.TestExercici0302#testCreacioLlibre
./runTest.sh com.exercicis.TestExercici0302#testCreacioPrestec
./runTest.sh com.exercicis.TestExercici0302#testEstaEnTermini
./runTest.sh com.exercicis.TestExercici0302#testSortidaMain
```

# Exercici 0303

Crea tres classes 'ConfiguracioGlobal', 'Usuari' i 'Sistema' per desenvolupar un sistema que utilitzi un objecte de configuració global accessible des de diferents parts de l'aplicació, garantint que tots els components utilitzin la mateixa configuració a través d'un Singleton.

*Classe ConfiguracioGlobal*

Aquest serà el Singleton que contindrà les configuracions de l'aplicació.

**Atributs**:

- instancia (private static): La única instància de ConfiguracioGlobal.
- idioma (String): L'idioma predeterminat de l'aplicació.
- zonaHoraria (String): La zona horària predeterminada de l'aplicació.

Els valors predeterminats d'aquesta classe seràn idioma "Anglès" i zonaHoraria "UTC"

**Mètodes**:

- getInstance(): Mètode estàtic que retorna la única instància de la classe.
- getIdioma(), setIdioma(String idioma): Getter i setter per a l'atribut idioma.
- getZonaHoraria(), setZonaHoraria(String zonaHoraria): Getter i setter per a l'atribut zonaHoraria.

*Classe Usuari*

Simula una entitat que necessita accedir a la configuració global per realitzar alguna tasca.

**Mètodes**:

- mostrarPreferencies(): Mostra les preferències de configuració de l'usuari (idioma i zona horària).

El format és: "Idioma: Francès, Zona Horaria: GMT"

*Classe Sistema*

Simula el component del sistema que també necessita accedir a la configuració global, per exemple, per configurar el format de data i hora.

**Mètodes**:

- configurarSistema(): Configura el sistema basant-se en la configuració global.

El format és: "Configurant sistema amb idioma Dothraki i zona horària GMT"

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercici0303

# A la carpeta "Deures03" executar el programa
./run.sh com.exercici0303.Main

# A la carpeta "Deures03" executar el test
./runTest.sh com.exercicis.TestExercici0303

# Testos individuals
./runTest.sh com.exercicis.TestExercici0303#testSingletonInstance
./runTest.sh com.exercicis.TestExercici0303#testDefaultValues
./runTest.sh com.exercicis.TestExercici0303#testSetAndGetIdioma
./runTest.sh com.exercicis.TestExercici0303#testSetAndGetZonaHoraria
./runTest.sh com.exercicis.TestExercici0303#testUsuariMostrarPreferencies
./runTest.sh com.exercicis.TestExercici0303#testSistemaConfigurarSistema
```

# Exercici 0304

Fes la classe 'NumComplex', que permet fer operacions amb números complexes.

*Classe NumComplex*

**Atributs**:

- partReal (private double): Part real del número complex
- partImaginaria (private double): Part imaginaria del número complex

**Getters i Setters**

Fes els Getters i Setters de 'partReal' i 'partImaginaria'

**Mètodes d'instància**:

- modul(): Retorna el mòdul del número complex.
```java
Math.sqrt(partReal * partReal + partImaginaria * partImaginaria);
```

- conjugat(): Retorna un nou NumComplex que és el conjugat d'aquest.
```java
NumComplex(partReal, -partImaginaria);
```

- toString(): Retorna una representació en string del número complex, com "3.0 + 4.0i"

Al fer la cadena que representa el número, sempre s'ha de posar el símbol '+' o '-' davant de la part imaginaria.

**Mètodes estàtics**:

- suma(NumComplex a, NumComplex b): Retorna la suma de dos números complexos.
```java
new NumComplex(a.partReal + b.partReal, a.partImaginaria + b.partImaginaria);
```

- resta(NumComplex a, NumComplex b): Retorna la resta de dos números complexos.
```java
new NumComplex(a.partReal - b.partReal, a.partImaginaria - b.partImaginaria);
```

- multiplica(NumComplex a, NumComplex b): Retorna la multiplicació de dos números complexos.
```java
double real = a.partReal * b.partReal - a.partImaginaria * b.partImaginaria;
double imaginari = a.partReal * b.partImaginaria + a.partImaginaria * b.partReal;
return new NumComplex(real, imaginari)
```

- divideix(NumComplex a, NumComplex b): Retorna la divisió de dos números complexos.
```java
double denominador = b.partReal * b.partReal + b.partImaginaria * b.partImaginaria;
if (denominador == 0) {
    throw new ArithmeticException("No es pot dividir per zero");
}
double real = (a.partReal * b.partReal + a.partImaginaria * b.partImaginaria) / denominador;
double imaginari = (a.partImaginaria * b.partReal - a.partReal * b.partImaginaria) / denominador;
return new NumComplex(real, imaginari);
```

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercici0304

# A la carpeta "Deures03" executar el programa
./run.sh com.exercici0304.Main

# A la carpeta "Deures03" executar el test
./runTest.sh com.exercicis.TestExercici0304

# Testos individuals
./runTest.sh com.exercicis.TestExercici0304#testModul
./runTest.sh com.exercicis.TestExercici0304#testConjugat
./runTest.sh com.exercicis.TestExercici0304#testSuma
./runTest.sh com.exercicis.TestExercici0304#testResta
./runTest.sh com.exercicis.TestExercici0304#testMultiplica
./runTest.sh com.exercicis.TestExercici0304#testDivideix
./runTest.sh com.exercicis.TestExercici0304#testDivideixPerZero
./runTest.sh com.exercicis.TestExercici0304#testMain
```

# Exercici 0305

Crea un sistema per gestionar un **torneig esportiu** on diversos participants competeixen en diferents modalitats esportives. El sistema ha de complir els següents requisits:

*Interfície Esportista*

- mètode 'void entrenar()'

*Interfície Competidor*

- mètode 'void competir()'

*Classe Participant*

**Atributs**:

- protected: nom (text), edat (enter)

**Getters i Setters**

Fes els Getters i Setters de no i edat

**Mètodes d'instància**:

- toString(): que retorna el format "Participant[nom=NomParticipant, edat=EdatParticipant]"

*Classe Jugador* hereta de Participant, implementa Esportista i Competidor

**Atributs**:

- private: equip(text)

**Mètodes**:

- Implementació d'entrenar mostra un missatge "Entrenant com a jugador"
- Implementació de competir mostra un missatge "Competint com a jugador"
- toString(): que retorna el format "Jugador[nom=NomJugador, edat=EdatJugador, equip=EquipJugador]"

*Classe arbitre* hereta de Participant, implementa Competidor

**Atributs**:

- private: nivell(text)

**Mètodes**:

- Implementació de competir mostra un missatge "Supervisant competició"
- toString(): que retorna el format "Arbitre[nom=NomArbitre, edat=EdatArbitre, nivell=NivellArbitre]"

*Classe Torneig* 

**Atributs**:

- private: participants (ArrayList de Participant)

**Mètodes**:

- afegirParticipant(Participant p): Afegeix un participant al torneig
- competir(): Crida el mètode competir de tots els competidors
- entrenar(): Crida el mètode entrenar de tots els esportistes
- getParticipants(): Retorna la llista de participants
- printParticipants(): Mostra per consola la llista de participants

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercici0305

# A la carpeta "Deures03" executar el programa
./run.sh com.exercici0305.Main

# A la carpeta "Deures03" executar el test
./runTest.sh com.exercicis.TestExercici0305

# Testos individuals
./runTest.sh com.exercicis.TestExercici0305#testJugadorConstructorAndGetters
./runTest.sh com.exercicis.TestExercici0305#testJugadorSetters
./runTest.sh com.exercicis.TestExercici0305#testJugadorToString
./runTest.sh com.exercicis.TestExercici0305#testJugadorEntrenar
./runTest.sh com.exercicis.TestExercici0305#testJugadorCompetir
./runTest.sh com.exercicis.TestExercici0305#testArbitreConstructorAndGetters
./runTest.sh com.exercicis.TestExercici0305#testArbitreSetters
./runTest.sh com.exercicis.TestExercici0305#testArbitreToString
./runTest.sh com.exercicis.TestExercici0305#testArbitreCompetir
```

