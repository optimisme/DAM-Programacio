# Exercici 0200

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
# Codi: src/main/java/com/exercici0200.java

# A la carpeta "Deures02" executar el programa
./run.sh com.exercici0200.Main

# A la carpeta "Deures02" executar el test
./runTest.sh com.exercicis.TestExercici0200

# Testos individuals
./runTest.sh com.exercicis.TestExercici0200#testMaxCapacityExceeded
./runTest.sh com.exercicis.TestExercici0200#testRemainingCapacityCheck
./runTest.sh com.exercicis.TestExercici0200#testNoRemainingCapacity
```

# Exercici 0201

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
# Codi: src/main/java/com/exercici0201.java

# A la carpeta "Deures02" executar el programa
./run.sh com.exercici0201.Main

# A la carpeta "Deures02" executar el test
./runTest.sh com.exercicis.TestExercici0201

# Testos individuals
./runTest.sh com.exercicis.TestExercici0201#testTemperaturaMitjanaInicial
./runTest.sh com.exercicis.TestExercici0201#testCreacioZones
./runTest.sh com.exercicis.TestExercici0201#testAjustarTemperatura
./runTest.sh com.exercicis.TestExercici0201#testTemperaturaMitjanaDespresDeEliminarZones
```

# Exercici 0202

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
# Codi: src/main/java/com/exercici0202.java

# A la carpeta "Deures02" executar el programa
./run.sh com.exercici0202.Main

# A la carpeta "Deures02" executar el test
./runTest.sh com.exercicis.TestExercici0202

# Testos individuals
```

# Exercici 0203

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

El format és: "Configurant sistema amb idioma Francès i zona horària GMT"

Per executar i testejar el programa:

```bash
# Codi: src/main/java/com/exercici0203.java

# A la carpeta "Deures02" executar el programa
./run.sh com.exercici0203.Main

# A la carpeta "Deures02" executar el test
./runTest.sh com.exercicis.TestExercici0203

# Testos individuals
```
