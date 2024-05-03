<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>



### Exercici 10 

##### Puntuació

- Passar els testos 'A': 2 punts
- Passar els testos 'B': 1 punt
- Passar els testos 'A' i 'B': (2 + 1) = 3 punts

S'entén que la puntuació màxima és de 3 punts

##### Enunciat

**SENSE** fer servir el Singleton 'AppData' i una base de dades *SQLite* anomenada **dades.sqlite**, desenvolupa una aplicació que gestioni taules en un llenguatge abstracte desconegut.

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

