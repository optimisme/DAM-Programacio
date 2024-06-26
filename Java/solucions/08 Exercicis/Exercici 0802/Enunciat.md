<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 2

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

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
./runTest.sh com.project.TestMain#testMainExtra
```

