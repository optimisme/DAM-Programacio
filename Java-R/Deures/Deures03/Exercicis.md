
# TODO: Falta implementar els testos

# Exercici 0300

Utilitzant el patró Singleton 'AppData' i una base de dades sqlite, desenvolupa una aplicació per a un cinema que no només gestioni les pel·lícules i els directors sinó també les sales on es projecten aquestes pel·lícules.

Cada peli estarà relacionada amb un director mitjançant claus foranes per establir relacions entre les taules. A més, hi haurà una relació entre les pel·lícules i les sales on es projecten, permetent saber en quina sala es pot veure cada film.

**Taula directors:**
```sql
id_director (INTEGER) : Un identificador únic per a cada director.
nom (TEXT) : El nom del director.
nacionalitat (TEXT) : La nacionalitat del director.
```

**Taula pelis:**
```sql
id_peli (INTEGER) : Un identificador únic per a cada peli.
titol (TEXT) : El títol de la peli.
any_estrena (INTEGER) : L'any d'estrena de la peli.
durada (INTEGER) : Durada de la peli en minuts.
id_director (INTEGER) : La clau forana que enllaça amb l'id_director de la taula directors.
```


**Taula sales:**
```sql
id_sala (INTEGER) : Un identificador únic per a cada sala.
nom_sala (TEXT) : El nom de la sala.
capacitat (INTEGER) : La capacitat màxima de la sala.
id_peli (INTEGER) : La clau forana que enllaça amb l'id_peli de la taula pel·lícules.
```


Defineix les següents funcions:

**crearTaulaDirectors**: Crea una nova taula 'Directors' (i esborra l'existent si cal)

**crearTaulaPelis**: Crea una nova taula 'Pelis' (i esborra l'existent si cal)

**crearTaulaSales**: Crea una nova taula 'Sales' (i esborra l'existent si cal)

**afegirDirector**: Rep com a paràmetres el nom i la nacionalitat d'un Director i l'afegeix a la taula.

**afegirPeli**: Rep com a paràmetres el títol, l'any d'estrena, la durada i l'identificador del director i l'afegeix a la taula.

**afegirSala**: Rep com a paràmetres el nom de la sala, la capacitat i l'identificador de la peli i l'afegeix a la taula.

**llistarTaulaDirectors**: Que mostra els elements de la taula Directors amb el format "ID: 1, Nom: Director A, Nacionalitat: País X"

**llistarTaulaPelis**: Que mostra els elements de la taula Pelis amb el format "ID: 1, Títol: Film A, Any d'Estrena: 2020, Durada: 120 minuts, Director: Director A"

**llistarTaulaSales**: Que mostra els elements de la taula Sales amb el format "ID: 1, Sala: Sala 1, Capacitat: 150 persones, Peli: Film A"

**llistarInfoPeli**: Que rep com a paràmetre un identificador de peli i mostra la informació d'una peli, el seu director, i en quina sala es projecta amb el format "ID: 5, Títol: Cinquè film, Any d'Estrena: 2022, Durada: 140 minuts, Director: Director E, Sala de Projecció: Sala 1"

Prova-ho amb aquest main:

```java
public class Main {
    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        // Crear taules
        crearTaulaDirectors();
        crearTaulaPelis();
        crearTaulaSales();

        // Afegir directors
        afegirDirector("Director A", "País X");
        afegirDirector("Director B", "País Y");

        // Afegir pel·lícules
        afegirPeli("Film A", 2020, 120, 1);
        afegirPeli("Film B", 2018, 110, 2);

        // Afegir sales
        afegirSala("Sala 1", 150, 1);
        afegirSala("Sala 2", 200, 2);

        System.out.println("\nDirectors:");
        llistarTaulaDirectors();

        System.out.println("\nPelis:");
        llistarTaulaPelis();

        System.out.println("\nSales:");
        llistarTaulaSales();

        int idPeli = 1;
        System.out.println("\nInformació de la Peli: " + idPeli);
        llistarInfoPeli(idPeli);

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }
}
```

Ha de donar aquesta sortida:

```text

Directors:
ID: 1, Nom: Director A, Nacionalitat: País X
ID: 2, Nom: Director B, Nacionalitat: País Y

Pelis:
ID: 1, Títol: Film A, Any d'Estrena: 2020, Durada: 120 minuts, Director: Director A
ID: 2, Títol: Film B, Any d'Estrena: 2018, Durada: 110 minuts, Director: Director B

Sales:
ID: 1, Sala: Sala 1, Capacitat: 150 persones, Peli: Film A
ID: 2, Sala: Sala 2, Capacitat: 200 persones, Peli: Film B

Informació de la Peli: 1
ID: 1, Títol: Film A, Any d'Estrena: 2020, Durada: 120 minuts, Director: Director A, Sala de Projecció: Sala 1
```

# Exercici 0301

Fent servir el Singleton 'AppData' i una base de dades *sqlite* anomenada **dades.sqlite**, desenvolupa una aplicació que gestioni restaurants, clients i serveis.

**Taula restaurants:**

```sql
id (INTEGER) : Un identificador únic per a cada restaurant
name (TEXT) : El nom del restaurant
kind (TEXT) : El tipus de restaurant
tables (INTEGER) : El nombre de taules que hi ha a cada restaurant
pricing (TEXT) : La categoria de preu de cada restaurant
```

**Taula clients:**

```sql
id (INTEGER) : Un identificador únic per a cada client.
name (TEXT) : El nom del client
birth (DATE) : La data de naixament del client
isVIP (BOOLEAN): Si es tracta d´un client VIP
```

**Taula services:**

```sql
id (INTEGER) : Un identificador únic per cada servei.
id_restaurant (INTEGER) : L´identificador del restaurant on es va realitzar el servei
id_client (INTEGER) : L´identificador del client que va pagar el servei
date (DATE) : La data del servei
expenditure (REAL) : El cost del servei
```

Els camps 'id_restaurant' i 'id_client' es relacionen amb les respectives taules.

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```text
void crearTaules()   
addRestaurant(String name, String kind, int tables, String pricing)
void addClient(String name, String birth, boolean isVIP)
void addService(int idRestaurant, int idClient, String date, double expenditure)

// Llista els restaurants de la base de dades amb format:
// ID: 1, Name: The Gourmet Kitchen, Kind: Italian, Tables: 10, Pricing: High
void listRestaurants()

// Llista els clients de la base de dades amb format:
// ID: 1, Name: John Doe, Birth: 1985-02-15, VIP: No
void listClients()

// Llista els serveis de la base de dades amb format:
// Service ID: 1, Restaurant ID: 1, Client ID: 1, Date: 2023-04-01, Expenditure: 120.5
void listServices()

// Llista els serveis d'un client amb id 'clientId' amb format:
// Client ID: 1, Client Name: John Doe, Date: 2023-04-01, Expenditure: 120.5, Restaurant Name: The Gourmet Kitchen, Restaurant Kind: Italian, below PKT average price
listClientServices(int clientId)

// Llista els clients d'un restaurant amb id 'restaurantId' amb format:
// Client ID: 1, Client Name: John Doe, Average expenditure: 127,75
// Mostra la mitjana de gasto que ha fet cada client en aquell restaurant a 'Average expenditure'
void listRestaurantClients(int restaurantId)

// Retorna 'above' o 'below' segons si un preu està per sobre del PKT pricing segons la següent taula:
// (High - 150, Medium - 75, Low - 30, Default - 50)
// | Pricing Level | Average Price | 
// | ------------- | ------------- | 
// | High          | 150           | 
// | Medium        | 75            | 
// | Low           | 30            | 
// | Default       | 50            | 
comparePrice(double expenditure, String pricing)
```

# Exercici 0302

Fent servir el Singleton 'AppData' i una base de dades *MySQL* anomenada **school**, desenvolupa una aplicació que gestioni alumnes, professors, aules i assignatures.

**Nota**: Segueix les instruccions de "./data/Docker HowTo.md" per iniciar la base de dades "dbScool.sql"

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'dbSchool.sql' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < ./data/dbSchool.sql
```

A Windows:
```bash
type ./data/dbSchool.sql | docker exec -i mysqlServer mysql -uroot -ppwd
```

**Important**: Al corregir, els testos han de funcionar amb base de dades 'school', port 3308, usuari 'root' i codi 'pwd'

**Taula alumnes:**

```sql
id_alumne (INTEGER) : Un identificador únic per a cada alumne.
nom (TEXT) : El nom de l'alumne.
cognoms (TEXT) : Els cognoms de l'alumne.
data_naixement (DATE) : La data de naixement de l'alumne.
```

**Taula professors:**

```sql
id_professor (INTEGER) : Un identificador únic per a cada professor.
nom (TEXT) : El nom del professor.
especialitat (TEXT) : L'especialitat del professor.
```

**Taula assignatures:**

```sql
id_assignatura (INTEGER) : Un identificador únic per a cada assignatura.
nom (TEXT) : El nom de l'assignatura.
hores_setmanals (INTEGER) : Les hores setmanals dedicades a l'assignatura.
id_professor (INTEGER) : La clau forana que enllaça amb l'id_professor de la taula professors.
```

**Taula aules:**

```sql
id_aula (INTEGER) : Un identificador únic per a cada aula.
nom (TEXT) : El nom o número de l'aula.
capacitat (INTEGER) : La capacitat màxima de l'aula.
```

**Taula alumne_assignatura:**

```sql
id_alumne (INTEGER) : La clau forana que enllaça amb l'id_alumne de la taula alumnes.
id_assignatura (INTEGER) : La clau forana que enllaça amb l'id_assignatura de la taula assignatures.
```

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```text
void crearTaules()   
void afegirAlumne(String nom, String cognoms, Date dataNaixement)
void afegirProfessor(String nom, String especialitat)
void afegirAssignatura(String nom, int horesSetmanals, int idProfessor) 
void afegirAula(String nom, int capacitat)
void inscriureAlumneAssignatura(int idAlumne, int idAssignatura) 
void llistarAlumnes() 
void llistarProfessors() 
void llistarAssignatures() 
void llistarAules() 
void llistarAssignaturesAlumne(int idAlumne) 
void llistarAlumnesAssignatura(int idAssignatura) 
int obtenirIdAlumnePerNom(String nom, String cognoms)
int obtenirIdAssignaturaPerNom(String nomAssignatura)
int obtenirIdProfessorPerNom(String nomProfessor) 
```

Prova-ho amb aquest main:

```java
public class Main {
    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        // Crear les taules
        crearTaules();

        // Afegir Professors
        afegirProfessor("Maria Garcia", "Matemàtiques");
        int idMaria = obtenirIdProfessorPerNom("Maria Garcia");

        afegirProfessor("Jordi Pozo", "Literatura");
        int idJordi = obtenirIdProfessorPerNom("Jordi Pozo");

        afegirProfessor("Anna Molina", "Ciències");
        int idAnna = obtenirIdProfessorPerNom("Anna Molina");

        // Afegir Aules
        afegirAula("A101", 30);
        afegirAula("A102", 25);
        afegirAula("B201", 20);

        // Afegir Assignatures
        if (idMaria != -1) {
            afegirAssignatura("Algebra", 4, idMaria);
        }
        int idAlgebra = obtenirIdAssignaturaPerNom("Algebra");

        if (idJordi != -1) {
            afegirAssignatura("Literatura Catalana", 3, idJordi);
        }
        int idLiteraturaCatalana = obtenirIdAssignaturaPerNom("Literatura Catalana");

        if (idAnna != -1) {
            afegirAssignatura("Biologia", 5, idAnna);
        }
        int idBiologia = obtenirIdAssignaturaPerNom("Biologia");

        // Afegir Alumnes
        afegirAlumne("Marc", "Soler", Date.valueOf("2005-03-15"));
        int idMarc = obtenirIdAlumnePerNom("Marc", "Soler");

        afegirAlumne("Laura", "Vidal", Date.valueOf("2004-07-22"));
        int idLaura = obtenirIdAlumnePerNom("Laura", "Vidal");

        afegirAlumne("Iván", "Coll", Date.valueOf("2004-06-10"));
        int idIvan = obtenirIdAlumnePerNom("Iván", "Coll");

        // Inscripcions, comprovant que tant els alumnes com les assignatures existeixen
        if (idMarc != -1 && idAlgebra != -1) {
            inscriureAlumneAssignatura(idMarc, idAlgebra);
        }
        if (idLaura != -1 && idLiteraturaCatalana != -1) {
            inscriureAlumneAssignatura(idLaura, idLiteraturaCatalana);
        }
        if (idIvan != -1) {
            if (idAlgebra != -1) inscriureAlumneAssignatura(idIvan, idAlgebra);
            if (idLiteraturaCatalana != -1) inscriureAlumneAssignatura(idIvan, idLiteraturaCatalana);
            if (idBiologia != -1) inscriureAlumneAssignatura(idIvan, idBiologia);
        }


        // Llistar informació
        System.out.println("Professors:");
        llistarProfessors();

        System.out.println("\nAssignatures:");
        llistarAssignatures();

        System.out.println("\nAules:");
        llistarAules();

        System.out.println("\nAssignatures:");
        llistarAssignaturesAlumne(1);
        llistarAssignaturesAlumne(3);

        System.out.println("\nAlumnes per assignatura:");
        llistarAlumnesAssignatura(1);
        llistarAlumnesAssignatura(2);
        llistarAlumnesAssignatura(3);

        // Tancar la connexió amb la base de dades
        db.close();

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("enviroment"))) {
            System.exit(0);
        }
    }
}
```

# Exercici 0303

Fent servir el Singleton 'AppData' i una base de dades *MySQL* anomenada **natura**, desenvolupa una aplicació que gestioni informació de Flora, Fauna i Països.

**Nota**: Segueix les instruccions de "./data/Docker HowTo.md" per iniciar la base de dades "dbNatura.sql"

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'dbNatura.sql' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < ./data/dbNatura.sql
```

A Windows:
```bash
type ./data/dbNatura.sql | docker exec -i mysqlServer mysql -uroot -ppwd
```

**Important**: Al corregir, els testos han de funcionar amb base de dades 'natura', port 3308, usuari 'root' i codi 'pwd'

**Taula paisos:**
```sql
id (INTEGER) : Un identificador únic per a cada país.
nom (TEXT) : El nom del país.
```

**Taula flora:**
```sql
id (INTEGER) : Un identificador únic per a cada espècie de planta.
nom_comu (TEXT) : El nom comú de la planta.
nom_cientific (TEXT) : El nom científic de la planta.
id_pais (INTEGER) : La clau forana que enllaça amb l id_pais de la taula Paisos.
descripcio (TEXT) : Una descripció breu de la planta.
habitat (TEXT) : L habitat on típicament es troba aquesta planta.
```

**Taula fauna:**
```sql
id (INTEGER) : Un identificador únic per a cada espècie animal.
nom_comu (TEXT) : El nom comú de l'animal.
nom_cientific (TEXT) : El nom científic de l'animal.
id_pais (INTEGER) : La clau forana que enllaça amb l'id_pais de la taula Paisos.
descripcio (TEXT) : Una descripció breu de l'animal.
habitat (TEXT) : L'habitat on típicament es troba aquest animal.
```

**Taula ecosistemes:**
```sql
id (INTEGER) : Un identificador únic per a cada ecosistema.
nom (TEXT) : El nom de l'ecosistema.
id_pais (INTEGER) : La clau forana que enllaça amb l'id_pais de la taula Paisos.
caracteristiques (TEXT) : Les característiques principals de l'ecosistema.
```

**Taula floraEcosistema:**
```sql
id_flora (INTEGER) : La clau forana que enllaça amb l'id_flora de la taula Flora.
id_ecosistema (INTEGER) : La clau forana que enllaça amb l'id_ecosistema de la taula Ecosistemes.
```

**Taula faunaEcosistema:**
```sql
id_fauna (INTEGER) : La clau forana que enllaça amb l'id_fauna de la taula Fauna.
id_ecosistema (INTEGER) : La clau forana que enllaça amb l'id_ecosistema de la taula Ecosistemes.
```

Utilitza el singleton AppData per a realitzar totes les operacions de base de dades (insercions, actualitzacions, consultes)

**Important:** Et caldrà una interfície anomenada **Identifiable**, que obliga als objectes que la implementen a definir el mètode **'getId'**. I que és necessària per obtenir un objecte d'una llista genèrica, a partir del seu identificador.

Implementa objectes per contenir la informació de cada taula de la base de dades anterior. Tingues en compte que tots els atributs són privats, i calen Getters i Setters.

**Classe Pais:**

*Atributs:*

* **idPais** (int): Un identificador únic per a cada país. Quan és 0, encara no s'ha afegit l'element a la base de dades.
* **nom** (String): El nom del país.

*Constructor:* Inicialitza idPais i nomPais.

*Mètodes:*

* **getters/setters** dels atributs.
* **save()**: Guarda o actualitza el país a la base de dades fent ús del singleton AppData.
* **toString()**: Retorna una cadena de text que inclou l'id i el nom del país.


**Classe Flora:**

*Atributs:*

* **idFlora** (int): Un identificador únic per a cada espècie de planta. Quan és 0, encara no s'ha afegit l'element a la base de dades.
* **nomComu** (String): El nom comú de la planta.
* **nomCientific** (String): El nom científic de la planta.
* **idPais** (int): La clau forana que enllaça amb l'idPais de la taula Paisos.
* **descripcio** (String): Una descripció breu de la planta.
* **habitat** (String): L'habitat on típicament es troba aquesta planta.

*Constructor:* Inicialitza tots els atributs de l'objecte Flora.

*Mètodes:*

* **getters/setters** dels atributs.
* **save()**: Guarda o actualitza l'espècie de planta a la base de dades utilitzant AppData.
* **toString()**: Retorna una cadena de text amb la informació de l'espècie. 


**Classe Fauna:**

*Atributs:*

* **idFauna** (int): Un identificador únic per a cada espècie animal. Quan és 0, encara no s'ha afegit l'element a la base de dades.
* **nomComu** (String): El nom comú de l'animal.
* **nomCientific** (String): El nom científic de l'animal.
* **idPais** (int): La clau forana que enllaça amb l'idPais de la taula Paisos.
* **descripcio** (String): Una descripció breu de l'animal.
* **habitat** (String): L'habitat on típicament es troba aquest animal.

*Constructor:* Inicialitza tots els atributs de l'objecte Fauna.

*Mètodes:*

* **getters/setters** dels atributs.
* **save()**: Guarda o actualitza l'espècie animal a la base de dades utilitzant AppData.
* **toString()**: Retorna una cadena de text amb la informació de l'espècie. 

**Classe Ecosistema:**

*Atributs:*

* **idEcosistema** (int): Un identificador únic per a cada ecosistema. Quan és 0, indica que encara no s'ha afegit l'element a la base de dades.
* **nom** (String): El nom de l'ecosistema.
* **caracteristiques** (String): Les característiques principals de l'ecosistema.
* **idPais** (int): La clau forana que enllaça amb l'id_pais de la taula Paisos.

*Constructor:* Inicialitza idEcosistema, nom, caracteristiques, i idPais.

*Mètodes:*

* **getters/setters** dels atributs.
* **save**(): Guarda o actualitza l'ecosistema a la base de dades fent ús del singleton AppData. Si idEcosistema és 0, es realitza una inserció. En cas contrari, es realitza una actualització.
* **toString**(): Retorna una cadena de text que inclou l'ID, el nom, les característiques, i l'ID del país de l'ecosistema. Això facilita la visualització de la informació de l'ecosistema.

**Nota:** Per implementar el mètode save() en cada una de les classes, hauràs d'escriure codi que construeixi una consulta SQL basada en els atributs de l'objecte. Aquesta consulta pot ser una inserció (INSERT) si l'objecte és nou, o una actualització (UPDATE) si l'objecte ja existeix a la base de dades. Recorda gestionar les transaccions de manera apropiada amb el *Singleton* de *AppData*. Pots fer servir la següent base:

```java
public void save() {
    String sql;
    if (this.idFauna == 0) { 
        // Suposem que 0 indica un nou objecte
        sql = "INSERT INTO Fauna (nomComu, ...";
    } else {
        sql = "UPDATE Fauna SET nomComu = ...";
    }
    AppData.getInstance().update(sql);
}
```

Aquest és l'esquelet del Main que també heu de programar:

- La informació no només està a la base de dades, també a cada una de les llistes i mapes locals
- La informació local i la de la base de dades han d'estar sincronitzades (coincidir)

```java
public class Main {

    private static List<Pais> paisos = new ArrayList<>();
    private static List<Flora> flora = new ArrayList<>();
    private static List<Fauna> fauna = new ArrayList<>();
    private static List<Ecosistema> ecosistemes = new ArrayList<>();
    private static Map<Integer, Integer> floraEcosistema = new HashMap<>();
    private static Map<Integer, Integer> faunaEcosistema = new HashMap<>();

    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        // Crear les taules necessàries
        crearTaules();

        // Afegir dades
        int idEspanya = afegirPais("xEspanya"); 
        int idCanada = afegirPais("Canadà"); 
        int idBrasil = afegirPais("Brasil"); 
        int idAustralia = afegirPais("Austràlia"); 
        int idSudAfrica = afegirPais("Sud-àfrica"); 
        int idXina = afegirPais("Xina"); 
        int idEUA = afegirPais("Estats Units"); 
        int idAntartida = afegirPais("Antàrtida"); 

        int idSelva = afegirEcosistema("xSelva", idBrasil, "La selva tropical rica en biodiversitat.");
        int idDesert = afegirEcosistema("Desert", idAustralia, "El desert càlid més caracteritzat per extensions de dunes de sorra.");
        int idBosc = afegirEcosistema("Bosc", idCanada, "Extensos boscos de coníferes amb hiverns llargs i freds.");
        int idOcea = afegirEcosistema("Oceà Antàrtic", idAntartida, "Habitat de milers d'espècies marines.");

        int idDalia = afegirFlora("xDàlia", "Dahlia pinnata", idEUA, "Jardins i zones cultivades", "Planta amb flors colorides que varien en forma i mida.", idDesert);
        afegirFlora("Eucaliptus", "Eucalyptus globulus", idAustralia, "Boscos oberts i zones costaneres", "Àrbre alt amb fulles aromàtiques utilitzades en medicina.", idBosc);
        afegirFlora("Orquídia", "Orchidaceae", idEspanya, "Selva tropical, terres baixes humides i muntanyes", "Família extensa de plantes florals amb flors simètriques i variades.", idSelva);
        int idBaobab = afegirFlora("Baobab", "Adansonia", idSudAfrica, "Savanes àrides i terres semiàrides", "Àrbre gros i robust conegut per la seva capacitat de conservar aigua dins del seu tronc.", idDesert);
        afegirFlora("Sequoia", "Sequoiadendron giganteum", idEUA, "Boscos humits temperats", "Un dels arbres més alts i longeus del món", idBosc);
        afegirFlora("Lavanda", "Lavandula", idCanada, "Terrenys assolellats, secs i calcaris", "Arbust conegut per les seves flors aromàtiques i propietats relaxants", idDesert);
        afegirFlora("Safrà", "Crocus sativus", idXina, "Terres semiàrides cultivades", "Conreat per les seves flors de les quals s'extreu l'espècia de safrà", idDesert);
        int idMaple = afegirFlora("Maple", "Acer", idCanada, "Zones humides i planes", "Arbres caducifolis coneguts pel seu sirop dolç", idDesert);

        int idKoala = afegirFauna("xKoala", "Phascolarctos cinereus", idAustralia, "Boscos d'eucaliptus", "Marsupial arborícola conegut per la seva dieta basada en fulles d'eucaliptus.", idBosc);
        int idPanda = afegirFauna("Panda", "Ailuropoda melanoleuca", idXina, "Boscos de muntanya rics en bambú", "Gran mamífer conegut per la seva dieta principalment de bambú i el seu pelatge distintiu blanc i negre", idBosc);
        afegirFauna("Àguila calva", "Haliaeetus leucocephalus", idEUA, "Zones amb llacs i rius", "Gran au de presa, símbol nacional dels Estats Units, reconeguda pel seu cap blanc", idBosc);
        afegirFauna("Lleopard de les neus", "Panthera uncia", idXina, "Terreny rocos muntanyenc", "Felí de muntanya adaptat a viure en l'altitud elevada de les muntanyes de l'Himàlaia", idDesert);
        afegirFauna("Tucà", "Ramphastos", idBrasil, "Selves tropicals i boscos humits", "Ocell tropical conegut pel seu gran bec colorit", idSelva);
        int idPingui = afegirFauna("Pingüí emperador", "Aptenodytes forsteri", idAntartida, "Zones d'aigües fredes", "El més gran i pesat de tots els pingüins vius, conegut per la seva capacitat de reproduir-se durant l'hivern antàrtic més dur", idBosc);

        // Comprovar funcions 'obtenir'
        int idObtenirCanada = obtenirIdPaisPerNom("Canadà");
        int idObtenirDesert = obtenirIdEcosistemaPerNom("Desert");
        int idObtenirBaobab = obtenirIdFloraPerNomComu("Baobab");
        int idObtenirPanda = obtenirIdFaunaPerNomComu("Panda");
        System.out.println("id Canada: " + idCanada + ":" + idObtenirCanada + " > " + (idCanada == idObtenirCanada));
        System.out.println("id Desert: " + idDesert + ":" + idObtenirDesert + " > " + (idDesert == idObtenirDesert));
        System.out.println("id Baobab: " + idBaobab + ":" + idObtenirBaobab + " > " + (idBaobab == idObtenirBaobab));
        System.out.println("id Panda: " + idPanda + ":" + idObtenirPanda + " > " + (idPanda == idObtenirPanda));

        // Modificar dades
        Pais refEspanya = (Pais) obtenirReferencia(idEspanya, paisos);
        refEspanya.setNom("Espanya");
        refEspanya.save();

        Ecosistema refSelva = (Ecosistema) obtenirReferencia(idSelva, ecosistemes);
        refSelva.setNom("Selva");
        refSelva.save();

        Flora refDalia = (Flora) obtenirReferencia(idDalia, flora);
        refDalia.setNomComu("Dàlia");
        refDalia.save();

        Fauna refKoala = (Fauna) obtenirReferencia(idKoala, fauna);
        refKoala.setNomComu("Koala");
        refKoala.save();
        
        // Modificar associacions
        associarFloraAEcosistema(idMaple, idBosc);
        associarFaunaAEcosistema(idPingui, idOcea);
       
        // Mostrar dades dels objectes
        llistarPaisos();
        llistarEcosistemes();
        llistarFlora();
        llistarFauna();
        llistarFloraEcosistema(idSelva);
        llistarFaunaEcosistema(idBosc);

        // Tancar la connexió amb la base de dades
        db.close();

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("enviroment"))) {
            System.exit(0);
        }
    }

    private static void crearTaules() {
        // Fa servir el singleton AppData per crear les taules segons l'explicació de l'enunciat
        // Si les taules ja existeixen, les esborra prèviament
    }

    private static int afegirPais(String nomPais) {
        // Crea un nou objecte 'pais'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'paisos' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdPaisPerNom'
        return -1;
    }

    private static int afegirFlora(String nom, String nomCientific, int idPais, String habitat, String descripcio, int idEcosistema) {
        // Crea un nou objecte 'flora'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'flora' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdFloraPerNomComu'
        return -1;
    }
    
    private static int afegirFauna(String nom, String nomCientific, int idPais, String habitat, String descripcio, int idEcosistema) {
        // Crea un nou objecte 'fauna'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'fauna' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdFaunaPerNomComu'
        return -1;
    }
    
    private static int afegirEcosistema(String nom, int idPais, String caracteristiques) {
        // Crea un nou objecte 'ecosistema'
        // Guarda la informació a la base de dades amb el mètode 'save' del nou objecte
        // Afegeix el nou objecte a la llista de 'ecosistemes' local
        // Retorna l'identificador que la base de dades ha assigntat al nou objecte fent servir la funció 'obtenirIdEcosistemaPerNom'
        return -1;
    }

    private static void associarFloraAEcosistema(int idFlora, int idEcosistema) {
        // Afegeix la nova relació a la taula 'floraEcosistema' i al mapa 'floraEcosistema'
    }
    
    private static void associarFaunaAEcosistema(int idFauna, int idEcosistema) {
        // Afegeix la nova relació a la taula 'faunaEcosistema' i al mapa  'faunaEcosistema'
    }
    
    public static int obtenirIdPaisPerNom(String nomPais) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    public static int obtenirIdFloraPerNomComu(String nomComu) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    public static int obtenirIdFaunaPerNomComu(String nomComu) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    public static int obtenirIdEcosistemaPerNom(String nom) {
        // Fa servir AppData per obtenir l'id a partir del nom, retorna -1 si no existeix aquest nom a la base de dades
        return -1;
    }

    private static void llistarPaisos() {
        System.out.println("Llista de Paisos:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació

        System.out.println("Llista de Paisos de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Pais { Id: " + id + ", Nom: \"" + nom + "\" }");
    }
    
    private static void llistarFlora() {
        System.out.println("Llista de Flora:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació
    
        System.out.println("Llista de Flora de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Flora { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific + "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }");
    }
    
    private static void llistarFauna() {
        System.out.println("Llista de Fauna:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació
    
        System.out.println("Llista de Fauna de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Fauna { Id: " + id + ", Nom Comú: \"" + nomComu + "\", Nom Científic: \"" + nomCientific + "\", Pais: " + idPais + ", Habitat: \"" + habitat + "\" }");
    }
    
    private static void llistarEcosistemes() {
        System.out.println("Llista d'Ecosistemes:");
        // Fa servir el mètode 'toString' de cada Pais per mostrar la informació
    
        System.out.println("Llista d'Ecosistemes de la base de dades:");
        // Obté les dades de paisos amb AppData i mostra la informació amb aquest format:
        // System.out.println("Ecosistema { Id: " + id + ", Nom: \"" + nom + "\", Id Pais: " + idPais + " }");
    }
    
    private static void llistarFloraEcosistema(int idEcosistema) {
        System.out.println("Llista de Flora de l'Ecosistema " + idEcosistema + ":");
        // Mostra la informació del mapa 'floraEcosistema'
    }
    
    private static void llistarFaunaEcosistema(int idEcosistema) {
        System.out.println("Llista de Fauna de l'Ecosistema " + idEcosistema + ":");
        // Mostra la informació del mapa 'faunaEcosistema'
    }

    private static Identifiable obtenirReferencia(int id, List<? extends Identifiable> llista) {
        // Retorna l'objecte de la llista que té aquest identificador
        for (Identifiable item : llista) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }   
}
```

# Exercici 0304

SENSE fer servir el Singleton 'AppData', fes una base de dades MySQL anomenada videogame_park i desenvolupa una aplicació que gestioni les àrees del parc temàtic de videojocs i les tarifes d'accés a aquestes àrees.

Aquest cop però, s'ha de treballar directament amb els *ResourceSet*.

**Nota**: Segueix les instruccions de "./data/Docker HowTo.md" per iniciar la base de dades "dbVideogamePark.sql"

**Nota:** Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'dbVideogamePark.sql' amb:

**Important**: Al corregir, els testos han de funcionar amb base de dades 'dbVideogamePark', port 3308, usuari 'root' i codi 'pwd'

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < ./data/dbVideogamePark.sql
```

A Windows:
```bash
type ./data/dbVideogamePark.sql | docker exec -i mysqlServer mysql -uroot -ppwd
```

**Taula arees**
```sql
id_area (INTEGER) : Un identificador únic per a cada àrea del parc.
nom (TEXT) : El nom de l'àrea.
tematica (TEXT) : La temàtica de l'àrea, relacionada amb un tipus de videojoc.
capacitat_maxima (INTEGER) : La capacitat màxima de visitants de l'àrea.
```


**Taula tarifes**
```sql
id_tarifa (INTEGER) : Un identificador únic per a cada tarifa.
nom (TEXT) : El nom de la tarifa.
preu (DECIMAL) : El preu de la tarifa.
durada (INTEGER) : La durada de la tarifa en dies.
```

**Taula acces_area_tarifa**
```sql
id_area (INTEGER) : La clau forana que enllaça amb l'id_area de la taula arees.
id_tarifa (INTEGER) : La clau forana que enllaça amb l'id_tarifa de la taula tarifes.
```

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```text
void crearTaules()   
void afegirArea(String nom, String tematica, int capacitatMaxima)
void afegirTarifa(String nom, BigDecimal preu, int durada)
void definirAccesAreaTarifa(int idArea, int idTarifa) 
void llistarArees() 
void llistarTarifes() 
void llistarAreesAccesiblesPerTarifa(int idTarifa) 
void llistarTarifesPerAccesArea(int idArea) 
int obtenirIdAreaPerNom(String nomArea)
int obtenirIdTarifaPerNom(String nomTarifa)
```

Prova-ho amb aquest main:

```java
public class Main {
    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            conn.setAutoCommit(false); // Important per controlar manualment les transaccions

            crearTaules(conn);
            afegirArea(conn, "Zona Arcade", "Arcade", 100);
            afegirArea(conn, "Zona VR", "Realitat Virtual", 50);
            afegirTarifa(conn, "Passi Bàsic", new BigDecimal("19.99"), 1);
            afegirTarifa(conn, "Passi Premium", new BigDecimal("39.99"), 3);

            int idZonaArcade = obtenirIdAreaPerNom(conn, "Zona Arcade");
            int idZonaVR = obtenirIdAreaPerNom(conn, "Zona VR");
            int idPassiBasic = obtenirIdTarifaPerNom(conn, "Passi Bàsic");
            int idPassiPremium = obtenirIdTarifaPerNom(conn, "Passi Premium");

            definirAccesAreaTarifa(conn, idZonaArcade, idPassiBasic);
            definirAccesAreaTarifa(conn, idZonaArcade, idPassiPremium);
            definirAccesAreaTarifa(conn, idZonaVR, idPassiPremium);

            conn.commit(); // Confirmar totes les operacions al final

            llistarArees(conn);
            llistarTarifes(conn);
            llistarTarifesPerAccesArea(conn, idZonaArcade);
            llistarAreesAccesiblesPerTarifa(conn, idPassiBasic);
            llistarAreesAccesiblesPerTarifa(conn, idPassiPremium);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        if (!"test".equals(System.getProperty("enviroment"))) {
            System.exit(0);
        }
    }
}
```

# Exercici 0305

Fent servir el Singleton 'AppData' i una base de dades *MySQL* anomenada **government**, desenvolupa una aplicació que gestioni alumnes, professors, aules i assignatures.

**Nota**: Segueix les instruccions de "./data/Docker HowTo.md" per iniciar la base de dades "dbGovernment.sql"

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'dbGovernment' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < ./data/dbGovernment.sql
```

A Windows:
```bash
type ./data/dbGovernment.sql | docker exec -i mysqlServer mysql -uroot -ppwd
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

# Exercici 0306

SENSE fer servir el Singleton 'AppData', FENT SERVIR *ResultSet* i una base de dades *MySQL* anomenada **astronomy**, desenvolupa una aplicació que gestioni cossos celestials, telescopis i observacions.

**Nota**: Segueix les instruccions de "./data/Docker HowTo.md" per iniciar la base de dades "dbAstronomy.sql"

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'dbAstronomy' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < ./data/dbAstronomy.sql
```

A Windows:
```bash
type ./data/dbAstronomy.sql | docker exec -i mysqlServer mysql -uroot -ppwd
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

# Exercici 0307 (originalment d'exàmen)

Fent servir el Singleton 'AppData' i una base de dades *sqlite* anomenada **./data/alienAnimals.sqlite**, desenvolupa una aplicació que gestioni expècies, naus i missions.

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

# Exercici 0308 (originalment d'exàmen)

Fent servir el Singleton 'AppData' i una base de dades *sqlite* anomenada **alienLanguages.sqlite**, desenvolupa una aplicació que gestioni idiomes de signes i verbals.

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

# Exercici 0309 (originalment d'exàmen)

**SENSE** fer servir el Singleton 'AppData' i una base de dades *SQLite* anomenada **alienCode.sqlite**, desenvolupa una aplicació que gestioni taules en un llenguatge abstracte desconegut.

**Taula UOR268:**

```sql
UOR201 (INTEGER): Identificador únic
UOR202 (VARCHAR 255): columna
UOR203 (INT): columna
```

**Taula ZHE524:**

```sql
ZHE301 (INTEGER): Identificador únic
ZHE302 (VARCHAR 255): columna
ZHE303 (DATE): columna
ZHE304 (VARCHAR 255): columna
```

**Nota**: La columna UOR203 fa referència amb ZHE301

Crea els objectes 'UOR268' i 'ZHE524' per tal de guardar la informació de les taules anteriors.

Hauràs de sobreescriure el mètode 'toString' de cada objecte per mostrar la informació en aquest format:

```java
UOR206{UOR201=1, UOR202='123', UOR203=1}
ZHE304{ZHE301=1, ZHE302='abc', ZHE303='2024-04-26', ZHE304='def'}
```

Defineix també les següents funcions, i mira l'exemple de sortida per saber com mostren les dades:

```java
// Test A
// Crea les taules segons les definicions anteriors
createTables()

// Test A
// Afegeix una fila a la taula UOR268 i retorna el valor del nou identificador afegit
int insertUOR268(UOR268 uor268)

// Test A
// Afegeix una fila a la taula ZHE524 i retorna el valor del nou identificador afegit
int insertZHE524(ZHE524 qhe524)

// Test A
// Esborra una fila de la taula UOR268 a partir d'un identificador de fila
boolean deleteUOR268(int id)

// Test A
// Esborra una fila de la taula ZHE524 a partir d'un identificador de fila
boolean deleteZHE524(int id)

// Test A
// Llista totes les files de la taula UOR268
List<UOR268> getAllUOR268()

// Test A
// Llista totes les files de la taula ZHE524
List<ZHE524> getAllZHE524()

// Test B
// Actualitza una fila de la taula UOR268 (no pot actualitzar el camp de l'identificador)
// retorna 'true' si la fila s'ha actualitzat correctament, 'false' en cas contrari
updateUOR268(UOR268 uor268)

// Test B
// Actualitza una fila de la taula ZHE524 (no pot actualitzar el camp de l'identificador)
// retorna 'true' si la fila s'ha actualitzat correctament, 'false' en cas contrari
boolean updateZHE524(ZHE524 zhe524)

// Funció de suport que ajuda a gestionar les excepcions SQL
void handleSQLException(SQLException e)

// Funció de suport que ajuda a imprimir els elements d'una llista
<T> void printList(List<T> list)
```

Fes anar els programes:
```bash
./run.sh com.project.MainA
./run.sh com.project.MainB
```