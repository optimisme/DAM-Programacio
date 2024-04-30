<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 7

SENSE fer servir el Singleton 'AppData', FENT SERVIR *ResultSet* i una base de dades *MySQL* anomenada **astronomy**, desenvolupa una aplicació que gestioni cossos celestials, telescopis i observacions.

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'astronomy' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < dbAstronomy.sql
```

A Windows:
```bash
type dbAstronomy.sql | docker exec -i mysqlServer mysql -uroot -ppwd
```

**Important**: Al corregir, els testos han de funcionar amb base de dades 'astronomy', port 3308, usuari 'root' i codi 'pwd'

**Important**: Cada vegada que s'executa el main, s'han d'esborrar i tornar a crear les taules de la base de dades

**Taula telescopes:**

```sql
telescopeId (INTEGER) : Un identificador únic.
name (VARCHAR 255) : El nom.
location (VARCHAR 255) : Localització.
type (VARCHAR 255) : Tipus.
diameter (DECIMAL 3,1) : El diametre de l´objectiu
```

**Taula celestialBodies:**

```sql
bodyId (INTEGER) : Identificador únic.
name (VARCHAR 255) : El nom.
type (VARCHAR 255) : Tipus.
mass (DECIMAL 60,5) : Massa de lóbjecte.
distance (DECIMAL 10,1) : Distància de la Terra.
```

**Taula observations:**

```sql
observationId (INTEGER) : Un identificador únic.
telescopeId (INTEGER) : Relació amb la taula telescopes.
bodyId (INTEGER) : Relació amb la taula celestialBodies.
dateTime (TIMESTAMP) : Data de la observació.
description (TEXT) : Descripció.
```

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```text
void createTables(Connection conn)
void addTelescope(Connection conn, String name, String location, String type, double diameter)
void addCelestialBody(Connection conn, String name, String type, double mass, double distance)
void addObservation(Connection conn, int telescopeId, int bodyId, Timestamp dateTime, String description)

// Modifica la massa d'un objecte celestial
void updateCelestialBodyMass(Connection conn, int bodyId, double newMass)

// Llista els telescopis de la base de dades fent servir el 'toString' de l'objecte 'Telescope'
void listTelescopes(Connection conn)

// Llista els objectes celestials de la base de dades fent servir el 'toString' de l'objecte 'CelestialBody'
void listCelestialBodies(Connection conn)

// Llista les observacions de la base de dades fent servir el 'toString' de l'objecte 'Observation'
void listObservations(Connection conn)

// Per cada cos celestial imprimeix el seu identificador i el nombre d'observacions associades amb format:
// "  Body ID: 1, Observation Count: 3"
void analyzeObservationFrequency(Connection conn)

// Imprimeix les observacions, que segueixen el criteri especificat al paràmetre 'criteria'
void filterObservationsByCriteria(Connection conn, String criteria)

// Retorna un enter amb el total d'observacions segons el tipus de cos celestial 'bodyType'
int getTotalObservationsByBodyType(Connection conn, String bodyType)
    
// Fa servir la funció 'findHeaviest' per escriure el nom de l'objecte més pesat amb format:
// Heaviest Celestial Body: Earth
void printHeaviestCelestialBody(Connection conn)

// A partir d'una llista amb objectes tipus 'CelestialBody' retorna el més pesat de la llista
CelestialBody findHeaviest(List<CelestialBody> celestialBodies)
```

Per resoldre l'exercici necessiteu crear els següents objectes:

**Objecte Telescope**

Atributs: int telescopeId, String name, String location, String type, double diameter.
Format a mostrar: [telescopeId=1, name='Hubble', location='Low Earth Orbit', type='Optic', diameter=2.4]

**Objecte CelestialBody**

Atributs: int bodyId, String name, String type, double mass, double distance.
Format a mostrar: [bodyId=11, name=Barnard's Star, type=Star, mass=1.5E29, distance=6.0]

**Objecte Observation**

Atributs: int observationId, int telescopeId, int bodyId, Timestamp dateTime, String description.
Format a mostrar: [observationId=1, telescopeId=1, bodyId=1, dateTime=2024-04-12 23:45:00.0, description=Pic of Earth]


Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
./runTest.sh com.project.TestMain#testMainPrivateAttributes
./runTest.sh com.project.TestMain#testMainExtra
```

