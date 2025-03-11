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
