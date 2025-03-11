# TODO: Falta implementar els testos

# Exercici 0500

Utilitzant el patró Singleton 'AppData' i una base de dades sqlite, desenvolupa una aplicació per a un cinema que no només gestioni les pel·lícules i els directors sinó també les sales on es projecten aquestes pel·lícules.

S'ha de guardar la informació a l'arxiu **'./data/cinema.sqlite'**

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

Defineix les següents funcions a l'arxiu:

**crearTaulaDirectors**: Crea una nova taula 'Directors' (i esborra l'existent si cal)

**crearTaulaPelis**: Crea una nova taula 'Pelis' (i esborra l'existent si cal)

**crearTaulaSales**: Crea una nova taula 'Sales' (i esborra l'existent si cal)

**afegirDirector**: Rep com a paràmetres el nom i la nacionalitat d'un Director i l'afegeix a la taula. Retorna l'identificador de la fila afegida.

**afegirPeli**: Rep com a paràmetres el títol, l'any d'estrena, la durada i l'identificador del director i l'afegeix a la taula. Retorna l'identificador de la fila afegida.

**afegirSala**: Rep com a paràmetres el nom de la sala, la capacitat i l'identificador de la peli i l'afegeix a la taula. Retorna l'identificador de la fila afegida.

**llistarTaulaDirectors**: Que mostra els elements de la taula Directors amb el format "ID: 1, Nom: Director A, Nacionalitat: País X"

**llistarTaulaPelis**: Que mostra els elements de la taula Pelis amb el format "ID: 1, Títol: Film A, Any d'Estrena: 2020, Durada: 120 minuts, Director: Director A"

**llistarTaulaSales**: Que mostra els elements de la taula Sales amb el format "ID: 1, Sala: Sala 1, Capacitat: 150 persones, Peli: Film A"

**llistarInfoPeli**: Que rep com a paràmetre un identificador de peli i mostra la informació d'una peli, el seu director, i en quina sala es projecta amb el format "ID: 5, Títol: Cinquè film, Any d'Estrena: 2022, Durada: 140 minuts, Director: Director E, Sala de Projecció: Sala 1"

Prova-ho amb l'arxiu **MainDB.java**:

```java
public class MainDB {
    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        // Crear taules
        crearTaulaDirectors();
        crearTaulaPelis();
        crearTaulaSales();

        // Afegir directors
        int id0 = Cinema.afegirDirector("Director A", "País X");
        System.out.println("S'ha afegit un nou director amb id: " + id0);
        int id1 = Cinema.afegirDirector("Director B", "País Y");
        System.out.println("S'ha afegit un nou director amb id: " + id1);

        // Afegir pel·lícules
        int pel0 = Cinema.afegirPeli("Film A", 2020, 120, 1);
        System.out.println("S'ha afegit una nova peli amb id: " + pel0);
        int pel1 = Cinema.afegirPeli("Film B", 2018, 110, 2);
        System.out.println("S'ha afegit una nova peli amb id: " + pel1);

        // Afegir sales
        int salY = Cinema.afegirSala("Sala 1", 150, 1);
        System.out.println("S'ha afegit una nova sala amb id: " + salY);
        int salZ = Cinema.afegirSala("Sala 2", 200, 2);
        System.out.println("S'ha afegit una nova sala amb id: " + salZ);

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

## Guardar dades en un .json

Fes servir la base de dades anterior ('./data/cinema.sqlite') per generar un *.json* amb la informació de totes les películes que hi ha a la base de dades:

```json
[
   { "id": 1, "titol": "Film A", "any_estrena": 2020, "durada": 120, "director": "Director A" },
   { "id": 2, "titol": "Film B", "any_estrena": 2018, "durada": 110, "director": "Director B" }
]
```

Prova-ho amb l'arxiu **MainSaveJSON.java**:

```java
public class MainSaveJSON {
    public static void main(String[] args) {
        
        AppData db = AppData.getInstance();

        Cinema.pelisToJSON("./data/pelis.json");

        db.close();
    }
}
```

# Exercici 0501

Fent servir el Singleton 'AppData' i una base de dades *sqlite*, desenvolupa una aplicació que gestioni restaurants, clients i serveis.

S'ha de guardar la informació a l'arxiu **'./data/restaurants.sqlite'**

**Taula restaurants:**

```sql
id_restaurant (INTEGER) : S´escull manualment sense fer servir autoincrement, ha de ser únic. Fa de clau principal
name (TEXT) : El nom del restaurant
kind (TEXT) : El tipus de restaurant
tables (INTEGER) : El nombre de taules que hi ha a cada restaurant
pricing (TEXT) : La categoria de preu de cada restaurant
```

**Taula clients:**

```sql
id_client (INTEGER) : Un identificador únic per a cada client, escollit amb autoincrement. Fa de clau principal
name (TEXT) : El nom del client
birth (DATE) : La data de naixament del client
isVIP (BOOLEAN): Si es tracta d´un client VIP
```

**Taula services:**

```sql
id_servei (INTEGER) : Un identificador únic per cada servei, escollit amb autoincrement, Fa de clau principal
id_restaurant (INTEGER) : L´identificador del restaurant on es va realitzar el servei
id_client (INTEGER) : L´identificador del client que va pagar el servei
date (DATE) : La data del servei
expenditure (REAL) : El cost del servei
```

Els camps 'id_restaurant' i 'id_client' es relacionen amb les respectives taules.

Defineix també les funcions de l'arxiu **Restaurants.java**.

# Exercici 0502

Utilitzant el patró Singleton 'AppData' i una base de dades sqlite, desenvolupa una aplicació per modelar informació dels *Jocs Olímpics* a l'arxiu: **'./data/olimpiades.sqlite'**

**Taula atletes**
```sql
id_atleta (INTEGER) : Clau primària, autoincrement.
nom (TEXT) : Nom de l’atleta.
edat (INTEGER) : Edat de l’atleta.
pais (TEXT) : País de l’atleta.
equip (BOOLEAN) : `TRUE` si l’atleta competeix en equip, `FALSE` si competeix individualment.
```

**Taula esports**
```sql
id_esport (INTEGER) : Clau primària, autoincrement.
nom (TEXT) : Nom de l’esport.
categoria (TEXT) : Categoria de l’esport (ex: Atletisme, Natació, Gimnàstica, etc.).
```

**Taula competicions**
```sql
id_competicio (INTEGER) : Clau primària, autoincrement.
id_esport (INTEGER) : Clau forana cap a `esports`.
lloc (TEXT) : Lloc on es desenvolupa la competició.
data (DATE) : Data de la competició.
```

**Taula participants**
```sql
id_participant (INTEGER) : Clau primària, autoincrement.
id_atleta (INTEGER) : Clau forana cap a `atletes`.
id_competicio (INTEGER) : Clau forana cap a `competicions`.
posicio (INTEGER) : Posició final de l’atleta/equip en la competició.
medalla (TEXT) : 'Or', 'Plata', 'Bronze' o NULL si no ha guanyat medalla.
```

Cal modelar la informació anterior a *Java* amb les següents classes:

**Atleta**:
```java
// Atributs
protected int id;
protected String nom;
protected int edat;
protected String pais;
protected boolean equip;
```

```java
// Mètodes
public Atleta(int id, String nom, int edat, String pais, boolean equip)
public void updateDB();
public abstract String toString();
```

**AtletaIndividual** (derivada d'Atleta):
```java
// Atributs
protected int id;
protected String nom;
protected int edat;
protected String pais;
protected boolean equip;
```

```java
// Mètodes
public AtletaIndividual(int id, String nom, int edat, String pais)

// Format de les dades: 
// "ID: " + id + ", Nom: " + nom + ", Edat: " + edat + ", País: " + pais + ", Tipus: Individual"
@Override
public String toString();
```

**AtletaEquip** (derivada d'Atleta):
```java
// Atributs
protected int id;
protected String nom;
protected int edat;
protected String pais;
protected boolean equip;
```

```java
// Mètodes
public AtletaEquip(int id, String nom, int edat, String pais)

// Format de les dades: 
// "ID: " + id + ", Nom: " + nom + ", Edat: " + edat + ", País: " + pais + ", Tipus: Equip"
@Override
public String toString();
```

**Esport**:
```java
// Atributs
private int id;
private String nom;
private String categoria;
```

```java
// Mètodes
public Esport(int id, String nom, String categoria)

public void updateDB();

// Format de les dades: 
// "ID: " + id + ", Esport: " + nom + ", Categoria: " + categoria
@Override
public String toString();
```

**Competicio**:
```java
// Atributs
private int id;
private Esport esport;
private String lloc;
private String data;
```

```java
// Mètodes
public Competicio(int id, Esport esport, String lloc, String data)

public void updateDB();

// Format de les dades: 
// "ID: " + id + ", Esport: " + esport.nom + ", Lloc: " + lloc + ", Data: " + data
@Override
public String toString();
```

**Participant**:
```java
// Atributs
private int id;
private Atleta atleta;
private Competicio competicio;
private int posicio;
private String medalla;
```

```java
// Mètodes
public Participant(int id, Atleta atleta, Competicio competicio, int posicio, String medalla)

public void updateDB();

// Format de les dades: 
// "ID: " + id + ", Atleta: " + atleta.nom + ", Competicio: " + competicio.id + ", Posició: " + posicio + ", Medalla: " + medalla
@Override
public String toString();
```

**Olimpiades**:
```java
// Atributs
private ArrayList<Atleta> atletes;
private ArrayList<Esport> esports;
private ArrayList<Competicio> competicions;
private ArrayList<Participant> participants;

// Mètodes
public Olimpiades()
public void crearTaules()
public Atleta afegirAtleta(String nom, int edat, String pais, boolean equip)
public Esport afegirEsport(String nom, String categoria)
public Competicio afegirCompeticio(Esport esport, String lloc, String data)
public void llistarAtletes()
public void mostrarMedaller()
```

Cal provar-ho amb aquest *"Main"*:
```java
public class Main {
    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        Olimpiades olm = new Olimpiades();

        olm.crearTaules();

        Atleta atleta1 = olm.afegirAtleta("Usain Bolt", 34, "Jamaica", false);
        Atleta atleta2 = olm.afegirAtleta("Michael Phelps", 36, "EUA", false);

        Esport atletisme = olm.afegirEsport("Atletisme", "Velocitat");
        Esport natacio = olm.afegirEsport("Natació", "Aigua");

        Competicio competicio1 = olm.afegirCompeticio(atletisme, "Estadi Olímpic", "2024-07-23");
        Competicio competicio2 = olm.afegirCompeticio(natacio, "Piscina Olímpica", "2024-07-24");

        olm.afegirParticipant(atleta1, competicio1, 1, "Or");
        olm.afegirParticipant(atleta2, competicio2, 1, "Or");

        System.out.println("\nAtletes:");
        olm.llistarAtletes();

        System.out.println("\nMedaller:");
        olm.mostrarMedaller();

        db.close();
    }
}
```

Quan es modifiquen dades dels objectes *Java* s'han de modificar també els camps a la base de dades, per mantenir-ho sincronitzat. Fes servir aquest mètode *updateDB* com a exemple:

- S'ha d'executar *updateDB* cada vegada que es fa un 'setter'.
- S'ha de fer un *INSERT* cada vegada que s'afegeix un element a les llistes de *Olimpiades*

```java
public class Atleta {
    protected int id;
    protected String nom;
    protected int edat;
    protected String pais;
    protected boolean equip;

    public Atleta(int id, String nom, int edat, String pais, boolean equip) {
        this.id = id;
        this.nom = nom;
        this.edat = edat;
        this.pais = pais;
        this.equip = equip;
    }
    
    public void updateDB() {
        String sql = String.format(
            "UPDATE atletes SET nom='%s', edat=%d, pais='%s', equip=%b WHERE id_atleta=%d;",
            nom, edat, pais, equip, id
        );
        AppData.getInstance().update(sql);
    }
}
```