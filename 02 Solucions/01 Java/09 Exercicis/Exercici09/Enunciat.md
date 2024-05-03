<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 9 (originalment un exercici d'exàmen)

##### Puntuació

- Passar els testos 'A': 2 punts
- Passar els testos 'B': 1 punt
- Passar els testos 'A' i 'B': (2 + 1) = 3 punts

S'entén que la puntuació màxima és de 3 punts

##### Enunciat

Fent servir el Singleton 'AppData' i una base de dades *sqlite* anomenada **dades.sqlite**, desenvolupa una aplicació que gestioni idiomes de signes i verbals.

Defineix les següents tres classes:

**Language:** Classe base

*Atributs:* id (int), name (String), planetOrigin (String), complexity (int), telepathic (boolean)

Té dos consturctors que inicien els atributs, un constructor sense 'id' que es posa a -1 per inidcar que no està establert i un segon constructor amb id.

Té getters i setters per tots els atributs

Mètode sense definició de codi 'String getInsertSQL()'

**LanguageSign:** subclasse

*Atributs adicionals*: usesGestures (boolean)

Té dos constructors, que inicien el pare i l'atribut adicional

Té la definició obligatòria de 'getInsertSQL()' que retorna la cadena de text per fer una query tipus INSERT

Té la definició del mètode 'toString' sobreescrita de la que et dóna JAVA per defecte.

**LanguageVerbal:** subclasse

*Atributs adicionals*: hasSyntax (boolean)

Té dos constructors, que inicien el pare i l'atribut adicional

Té la definició obligatòria de 'getInsertSQL()' que retorna la cadena de text per fer una query tipus INSERT

Té la definició del mètode 'toString' sobreescrita de la que et dóna JAVA per defecte.

**Taula languages:**

```sql
id (INTEGER): identificador d´idioma únic
name (TEXT): nom
planet_origin (TEXT): nom
complexity (INTEGER): complexitat de l´idioma
telepathic (BOOLEAN): si és una llengua telepàtica
has_syntax (BOOLEAN): si té sintaxi
uses_gestures (BOOLEAN): si fa servir gestos
type (TEXT): el tipus (de signes o verbal)
```

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```java
// Test A
// Crear les taules (i esborrar les antigues si cal)
createTables() 

// Test A
// Afegir un idioma
void addLanguage(Language language)

// Test A
// Crea un objecte idioma a partir d'un 'Map<String, Object>' retornat per AppData
// L´objecte creat ha de ser 'LanguageSign' o 'LanguageVerbal' segons el seu paràmetre 'type'
Language createLanguageFromMap(Map<String, Object> map)

// Test A
// Llista els idiomes de la base de dades, fent servir el mètode 'toString' de cada un
void listLanguages()

// Test A
// Transforma els caràcters ' d'una cadena de text en ''
String escapeSQL(String input)

// Test B
// Retorna la mitjana de complexitat dels idiomes de la base de dades
double averageComplexity()

// Test B
// Mostra per pantalla la complexitat mínima i màxima de la base de dades
minMaxComplexity() 

// Test B
// Retorna el percentatge d´idiomes amb gestos
percentageUsingGestures()
```

Fes anar els programes:

```bash
./run.sh com.project.MainA
./run.sh com.project.MainB
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutputA
./runTest.sh com.project.TestMain#testMainTablesA
./runTest.sh com.project.TestMain#testMainCallsA
./runTest.sh com.project.TestMain#testMainExtraA

./runTest.sh com.project.TestMain#testMainOutputB
./runTest.sh com.project.TestMain#testMainCallsB
./runTest.sh com.project.TestMain#testMainExtraB
```

