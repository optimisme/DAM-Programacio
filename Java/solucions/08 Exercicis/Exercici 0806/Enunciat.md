<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 6

Fent servir el Singleton 'AppData' i una base de dades *MySQL* anomenada **government**, desenvolupa una aplicació que gestioni alumnes, professors, aules i assignatures.

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'government' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < dbGovernment.sql
```

A Windows:
```bash
type dbGovernment.sql | docker exec -i mysqlServer mysql -uroot -ppwd
```

**Important**: Al corregir, els testos han de funcionar amb base de dades 'government', port 3308, usuari 'root' i codi 'pwd'

**Important**: Cada vegada que s'executa el main, s'han d'esborrar i tornar a crear les taules de la base de dades

**Taula Citizens:**

```sql
CitizenID (INTEGER) : Un identificador únic per a cada ciutadà.
FullName (TEXT) : El nom del ciutadà.
Address (TEXT) : Direcció del ciutadà.
DateOfBirth (DATE) : La data de naixement del ciutadà.
NationalID (TEXT) : Número de carnet del ciutadà.
EmploymentStatus (TEXT) : Estat laboral.
PoliticalAffiliation (TEXT) : Afiliació política.
```

**Taula Surveillance:**

```sql
SurveillanceID (INTEGER) : Un identificador únic per cada vigilancia
Location (TEXT) : Lloc on s´ha fet la vigilancia
DateTime (DATETIME) : Data de la vigilancia
Duration (INTEGER) : Duració de la observació
CitizenID (INTEGER) : Id del ciutadà vigilat
TypeOfObservation (TEXT) : Tipus de vigilancia
```

**Taula CensoredMaterials:**

```sql
MaterialID (INTEGER) : Identificador de l´objecte censurat.
Type (TEXT) : Tipus d´objecte.
Title (TEXT) : Nom o descripció de l´objecte.
Author (TEXT) : Autor de l´objecte.
DateOfCensorship (DATE) : Data
ReasonForCensorship (TEXT) : Motiu de la censura.
```

**Taula Detentions:**

```sql
DetentionID (INTEGER) : Un identificador únic per a cada detenció.
CitizenID (INTEGER) : Relació amb la taula de ciutadants.
DateOfDetention (DATE) : Data de la detenció.
LocationOfDetention (TEXT) : Ubicació on es fa la detenció.
Duration (INTEGER) : Duració de la detenció.
Charges (TEXT) : Càrregs del detingut.
```

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```text
void addCitizen(String name, String address, String birth, String nationalId, String employment, String political)
void addSurveillance(String location, String dateTime, int duration, int citizenId, String type)
void addCensoredMaterial(String type, String title, String author, String date, String reason)
void addDetention(int citizenId, String date, String location, int duration, String charges)

// Mostra la llista de ciutadants amb format:
// Citizen ID: 1, Name: John, Address: 123 Main St, Birth: 1980-01-01, National ID: A123, Employment: Employed, Political Affiliation: Party A
void listCitizens()

// Mostra la llista de vigilancies amb format:
// Surveillance ID: 1, Location: Downtown Square, Date/Time: 2024-04-14T14:00, Duration: 30, Citizen ID: 1, Observation Type: Public Movement
void listSurveillance()

// Mostra la llista de material censurat amb format:
// Material ID: 1, Type: Book, Title: 1984, Author: George Orwell, Date of Censorship: 2024-04-01, Reason: Subversive Content
void listCensoredMaterials()

// Mostra la llista de detencions amb format:
// Detention ID: 1, Citizen ID: 1, Date of Detention: 2024-04-02, Location: Capital 
void listDetentions()

// Mostra la durada mitjana de la detenció per una ubicació donada de la base de dades amb format:
// {AverageDuration=25.00, LocationOfDetention=Capital Detention Center}
// Limitar l'AverageDuration a dos decimals
void showAverageDetentionDurationByLocation(String location)

// Compta el nombre de materials censurats per una raó específica i els llista amb format:
// {TotalCount=3, ReasonForCensorship=Subversive Content}
void countCensoredMaterialsByReason(String reason)

// Mostra les detencions filtrades per càrrecs que inclouen el text especificat amb format:
// {DetentionID=1, CitizenID=1, DateOfDetention=2024-04-02, Duration=10, Charges=Subversion, LocationOfDetention=Capital Detention Center}
void listDetentionsByCharges(String charges)

// Mostra les detencions a partir d'una data, relacionades amb les informació del ciutadà amb fomat:
// Citizen Name: John, Detention ID: 5, Date of Detention: 2024-04-11, Location of Detention: Western, Duration: 25, Charges: Disturbance
void listDetentionsFromDate(String date)

// Mostra les vigilàncies entre dues dates (O un missatge de que no n'hi ha cap) amb format:
// Surveillance ID: 1, Location: Downtown Square, Date/Time: 2024-04-14T14:00, Duration: 30, Citizen ID: 1, Observation Type: Public Movement
// O bé, si no n'hi ha cap:
// No surveillance entries found between 2024-04-12 and 2024-04-14.
void listSurveillanceEntries(String startDate, String endDate)
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
./runTest.sh com.project.TestMain#testMainExtra
```

