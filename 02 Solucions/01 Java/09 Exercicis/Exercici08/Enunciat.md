<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 8 

##### Puntuació

- Passar els testos 'A': 2 punts
- Passar els testos 'B': 1 punt
- Passar els testos 'A' i 'B': (2 + 1) = 3 punts

S'entén que la puntuació màxima és de 3 punts

##### Enunciat

Fent servir el Singleton 'AppData' i una base de dades *sqlite* anomenada **dades.sqlite**, desenvolupa una aplicació que gestioni expècies, naus i missions.

**Taula species:**

```sql
id (INTEGER): identificador únic
name (TEXT): nom
origin (TEXT): origen
limbs (INTEGER): numero d´extremitats
telepathic (BOOLEAN): té telepatia
```

**Taula spaceships:**

```sql
id (INTEGER): Identificador únic
name (TEXT): nome
type (TEXT): tipus
capacity (INTEGER): capacitat
```

**Taula missions:**

```sql
id (INTEGER): identificador únic
species_id (INTEGER): identificador d´espècie spaceship_id (INTEGER): identificador de nau
date (DATE): data de la missió
duration (REAL): duració de la missió
objective (TEXT): objectiu de la missió
```

Els camps 'species_id' i 'spaceship_id' es relacionen amb les respectives taules.

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```java
// Test A
// Crear les taules (i esborrar les antigues si cal)
createTables() 

// Test A
// Afegir una espècie
addSpecies(String name, String origin, int limbs, boolean telepathic)

// Test A
// Afegir una nau
addSpaceship(String name, String type, int capacity)

// Test A
// Afegir una missió
addMission(int speciesId, int spaceshipId, String date, double duration, String objective)

// Test A
// Llista les espècies
listSpecies()

// Test A
// Llista les naus
listSpaceships()

// Test A
// Llita les missions
listMissions()

// Test B
// Actualitza les dades d´una espècie
void updateSpecies(int id, String newName, String newOrigin, int newLimbs, boolean newTelepathic)

// Test B
// Actualitza les dades d´una missió
updateMission(int missionId, String newObjective)

// Test B
// Esborra un element de la taula de naus
deleteSpaceship(int id)

// Test B
// Esborra un element de la taula d´espècies
deleteSpecies(int id)

// Substitueix els caràcters ' per ''
private static String escapeSQL(String input)
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

