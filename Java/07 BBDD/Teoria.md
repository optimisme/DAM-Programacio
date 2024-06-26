<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Bases de dades desde JAVA

JAVA permet connectar-se a bases de dades relacionals a través de la API JDBC (Java Database Connectivity).

Les característiques de JDBC:

* És fàcil de fer servir

* Pot connectar amb casi tots les bases de dades del mercat

* No té utilitats per traduïr de SQL a objectes Java (ni al revés)

## Funcionament de JDBC

JDBC ens ofereix un object **Connection** genèric que permet connectar a diferents tipus de bases de dades relacionals, a través d'una URL i les dades de connexió.

Cal mantenir una connexió oberta a través de l'objecte *Connection*, i tancar-la amb la funció '.close()' quan ja no la fem servir més.

## Tipus de consultes JDBC

JDBC té dos tipus de consultes bàsiques:

* **executeUpdate** per consultes que no retornen dades en format taula, per exemple: DROP, CREATE, INSERT, UPDATE, ...

* **executeQuery** per consultes que retornen objectes en format de taula (és a dir consultes tipus SELECT)

Quan la consulta és de tipus *taula* i s'ha obtingut amb *executeQuery*, l'objecte que obtenim és un **ResultSet**. Per obtenir informació d'aquest objecte, necessitem saber el tipus de dades que estem agafant segons la columna, per exemple:

* Obtenir el valor enter de la columna etiquetada com a "id": **rs.getInt("id")**

* Obtenir el valor de text de la columna etiquetada com a "name": **rs.getString("name")**

**Nota:** Un *ResultSet* està vinculat a la seva connexió i al Statement que el va generar, i aquests recursos s'han de tancar per evitar fuites de memòria. Un cop tancats, el ResultSet ja no és vàlid. Els exemples copien les dades del *ResultSet* a una nova estructura de dades tipus *List<Map<String, Object>>* que no depèn de la connexió oberta.

### Confirmar les operacions

Un cop feta una modificació a la base de dades, aquesta pot trigar una estona a executar-la. Per tal de continuar amb el nostre codi, sabent que la operació s'ha apuntat bé a la base de dades, podem fer un **'commit'**.

És habitual fer-lo abans de tancar el *'ResultSet'*.

```java
    conn.commit(); // Confirma els canvis
```

Per tal de poder gestionar *manualment* els commits, cal configurar la connexió amb la funció **setAutocommit** a false:

```java
conn.setAutoCommit(false);
```

**Nota:** configurar l'auto commit a *true* només és recomanable en aplicacions que:

- Aplicacions que només fan lectures de la base de dades, modificacions molt ocasionals o bé només fan canvis de configuració però no de dades.

- Prototips o aplicacions en les que la consistència de dades no és crítica.

És a dir, normalment l'auto commit està configurat a *'false'*.

### Desfer operacions en cas d'error (rollback)

En cas que es produeixi una excepció durant la modificació de dades, es pot fer un 'rollback' per desfer els canvis de l'últim *commmit*, això ho fem al tractar la pròpia excepció que ha generat la base de dades:

```java
    } catch (SQLException e) {
        try {
            conn.rollback(); // Reverteix els canvis
            System.out.println("Rollback realitzat degut a un error.");
        } catch (SQLException ex) {
            System.out.println("Error en intentar fer rollback.");
            ex.printStackTrace();
        }
        System.out.println(e.getMessage());
    }
```

## Base de dades SQLite

SQLite és un sistema de gestió de base de dades lleuger, que NO segueix el model client-servidor.

És a dir, guarda la informació en un arxiu enlloc de en un servidor tipus MySQL.

Les característiques de SQLite:

* Soporta usuaris simultanis (però no és molt eficient al fer-ho)

* És "zero-configuration", no cal instal·lar-la i treballa amb un sol arxiu de dades en local

* Permet camps de longitud variable

Per connectar a una base de dades SQLite cal configurar l'arxiu *pom.xml* de maven per afegir la llibreria necessaria:

```xml
<dependencies>
    <dependency>
        <groupId>org.xerial</groupId>
        <artifactId>sqlite-jdbc</artifactId>
        <version>3.36.0.3</version> 
        <!-- Comprova la darrera versió disponible -->
    </dependency>
</dependencies>

```

**Nota:** Amb l'extensió de *Visual Studio Code* anomenada *'SQLite Viewer'* d'en *Florian Klampfer* es poden veure els continguts dels arxius que contenen dades tipus *'SQLite'*

### Exemple 0700

Aquest exemple mostra com fer una connexió amb SQLite, i gestionar dades.

La classe **AppData** és un singleton que gestiona una única connexió amb la base de dades, fent-la accessible des de qualsevol punt del codi.

A més, implementa una funció **query** que enlloc de retornar un **ResultSet** retorna un objecte tipus **List<Map<String, Object>>** que és més senzill de gestionar.

```java
public class Main {
    public static void main(String[] args) {

        // Crear el singleton (això es connecta a la base de dades)
        AppData db = AppData.getInstance();

        System.out.println("\nIniciar les dades de la base de dades:");
        initData();

        System.out.println("\nAnimals de l'espècie 'Gos':");
        llistarFiles("SELECT * FROM animals WHERE especie = 'Gos'");

        System.out.println("\nAnimals de quatre potes:");
        llistarFiles("SELECT * FROM animals WHERE numeropotes = 4");

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }

    public static void initData() {

        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Esborrar la taula 'animals' si existeix
        db.update("DROP TABLE IF EXISTS animals");

        // Crear la taula 'animals'
        db.update("CREATE TABLE IF NOT EXISTS animals (" +
                            "especie TEXT NOT NULL," +
                            "longevitat INTEGER," +
                            "numeropotes INTEGER)");

        // Inserir dades a la taula 'animals'
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Gos', 14, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Gat', 15, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Elefant', 70, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Tortuga', 100, 4)");
        db.update("INSERT INTO animals (especie, longevitat, numeropotes) VALUES ('Colom', 6, 2)");
    }

    public static void llistarFiles(String sql) {

        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        List<Map<String, Object>> files = db.query(sql);

        // Llistar el nom i tipus de dades de cada columna (de la fila 0)
        String txt = "Columnes: ";
        Map<String, Object> fila0 = files.get(0);
        for (String key : fila0.keySet()) {
            Object value = fila0.get(key);
            txt += key + " (" + (value != null ? value.getClass().getSimpleName() : "null") + "), ";
        }
        if (files.size() > 0) {
            txt = txt.substring(0, txt.length() -2 );
        }
        System.out.println(txt); 

        // Llistar les files de la query
        System.out.println("Dades:");
        for (Map<String, Object> fila : files) {
            System.out.println(fila.get("especie") + ", " + fila.get("longevitat") + " anys, " + fila.get("numeropotes") + " potes");
        }
    }
}

class AppData {
    private static AppData instance;
    private Connection conn;

    private AppData() {
        // Connecta al crear la primera instància
        connect();
    }

    // Singleton
    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    private void connect() {
        String url = "jdbc:sqlite:dades.sqlite"; // Nom de l'arxiu amb les dades 'dades.sqlite'
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String sql) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Aquesta funció transforma el ResultSet en un Map<String, Object>
    // per fer l'accés a la informació més genèric
    public List<Map<String, Object>> query(String sql) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        // try-with-resources tancarà el ResultSet quan acabi el bloc
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnLabel(i), rs.getObject(i));
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}
```

## Base de dades MySQL

Per connectar a una base de dades MySQL cal configurar l'arxiu *pom.xml* de maven per afegir la llibreria necessaria:

```xml
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.29</version> 
    <!-- Comprova la darrera versió disponible -->
</dependency>
```

### Exemple 0701

Aquest exemple mostra com fer una connexió amb MySQL, i gestionar dades.

La classe **AppData** és un singleton que gestiona una única connexió amb la base de dades, fent-la accessible des de qualsevol punt del codi.

A més, implementa una funció **query** que enlloc de retornar un **ResultSet** retorna un objecte tipus **List<Map<String, Object>>** que és més senzill de gestionar.

```java
public class Main {
    public static void main(String[] args) {

        // Crear el singleton (això es connecta a la base de dades)
        AppData db = AppData.getInstance();

        System.out.println("\nLlistar totes les taules:");
        llistarTaules();

        System.out.println("\nLes 10 últimes ciutats de la taula 'city':");
        llistarUltimesCiutats();

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }

    public static void llistarTaules() {
        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Llistar totes les taules
        List<Map<String, Object>> taules = db.query("SHOW TABLES;");

        for (Map<String, Object> taula : taules) {
            // La clau del mapa depèn del nom de la base de dades, per tant, utilitzem el primer valor del mapa.
            System.out.println(taula.values().toArray()[0]);
        }
    }

    public static void llistarUltimesCiutats() {
        // Obtenir un apuntador al singleton de la base de dades
        AppData db = AppData.getInstance();

        // Llistar les 10 últimes ciutats de la taula 'city'
        List<Map<String, Object>> ciutats = db.query("SELECT * FROM city ORDER BY ID DESC LIMIT 10;");

        System.out.println("Dades de les ciutats:");
        for (Map<String, Object> ciutat : ciutats) {
            System.out.println(ciutat.get("Name") + ", " + ciutat.get("CountryCode") + ", " + ciutat.get("District") + ", " + ciutat.get("Population"));
        }
    }
}

class AppData {
    private static AppData instance;
    private Connection conn;

    private AppData() {
        // Connecta al crear la primera instància
        connect();
    }

    // Singleton
    public static AppData getInstance() {
        if (instance == null) {
            instance = new AppData();
        }
        return instance;
    }

    private void connect() {
        // Canvia aquestes variables per les teves credencials reals
        String url = "jdbc:mysql://localhost:3308/world?useSSL=false"; // Utilitza el port 3308 i la base de dades 'world'
        String user = "root"; // El teu usuari de MySQL
        String password = "pwd"; // La teva contrasenya de MySQL

        try {
            // Assegura't que el controlador JDBC de MySQL estigui carregat
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("No es pot trobar el controlador JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error connectant a la base de dades MySQL.");
            e.printStackTrace();
        }
    }

    public void close() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(String sql) {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Map<String, Object>> query(String sql) {
        List<Map<String, Object>> resultList = new ArrayList<>();

        // try-with-resources tancarà el ResultSet quan acabi el bloc
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (rs.next()) {
                Map<String, Object> row = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    row.put(metaData.getColumnName(i), rs.getObject(i));
                }
                resultList.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultList;
    }
}
```

## Objecte ResultSet

ResultSet és l'objecte que obtenim quan fem un **executeQuery** a una base de dades a través de JDBC.

Quan creem l'objecte *Statement*, amb el que iniciem una consulta a la base de dades, podem decidir el tipus de *ResultSet* que volem obtenir.

### Configuracions del ResultSet

* **ResultSet.TYPE_FORWARD_ONLY**, les dades del resultat només es poden *reseguir* endavant amb el mètode *'next()'*

```java
        Statement stmt = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("select * from tbluser");
```

* **ResultSet.TYPE_SCROLL_INSENSITIVE**, les dades es poden recorrer en qualsevol direcció gràcies a la funció *'absolute()'*, però no actualitza les dades si aquestes canvien.

```java
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("select * from tbluser");
```

* **ResultSet.TYPE_SCROLL_SENSITIVE**, les dades es poden recorrer en qualsevol direcció gràcies a la funció *'absolute()'*, mostrarà les modificacions a les dades si la connexió i l'statement segueixen oberts.

```java
        Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("select * from tbluser");
```
* **ResultSet.CONCUR_READ_ONLY**, només permet operacions de lectura a la base de dades.

* **ResultSet.CONCUR_UPDATABLE**, només permet modificar la base de dades i que s'actualitzin les dades del ResultSet adequadament.


**Nota Important:** SQLite només pot fer servir cursors tipus *TYPE_FORWARD_ONLY*

### Funcions del ResultSet

#### **Funcions de navegació de les dades**

Aquestes funcions permeten 'navegar' per la taula de dades, fila a fila. Les que retornen un boleà, aquest és *'true'* si la operació s'ha pogut completar amb èxit.

- boolean **absolute**(int row): mou el punter del ResultSet a la fila 'row'

- void **afterLast**(): mou el punter del ResultSet després de la última fila de dades.

- void **beforeFirst**(): mou el punter del ResultSet abans de la primera fila de dades.

- boolean **first**(): mou el punter del ResultSet a la primera fila de dades.

- boolean **last**(): mou el punter del ResultSet a la última fila de dades.

- boolean **next**(): mou el punter del ResultSet a la següent fila de dades.

- boolean **previous**(): mou el punter del ResultSet a la fila anterior a l'actual.

#### **Funcions d'obtenció de dades**

Aquestes funcions permeten accedir a les dades de cada fila del ResultSet, és a dir a les columnes de cada fila.

- int **getInt**(int columnIndex): Retorna el valor de la columna especificada per columnIndex com a enter (int). 

- long **getLong**(int columnIndex): Retorna el valor de la columna especificada per columnIndex com a llarg (long).

- String **getString**(int columnIndex): Retorna el valor de la columna especificada per columnIndex com a cadena de text (String).

- java.sql.Date **getDate**(int columnIndex): Retorna el valor de la columna especificada per columnIndex com a data (java.sql.Date).

- int **getInt**(String columnLabel): Retorna el valor de la columna especificada per columnLabel com a enter (int). 

- long **getLong**(String columnLabel): Retorna el valor de la columna especificada per columnLabel com a llarg (long).

- String **getString**(String columnLabel): Retorna el valor de la columna especificada per columnLabel com a cadena de text (String). 

- java.sql.Date **getDate**(String columnLabel): Retorna el valor de la columna especificada per columnLabel com a data (java.sql.Date). 

#### **Funcions d'obtenció de dades**

Aquestes funcions permeten modificar les dades del ResultSet, **però NO modifiquen les dades de la base de dades** si no es combinen amb les funcions *'insertRow'* o *'updateRow'*.

- void **updateInt**(int columnIndex, int x): Actualitza el valor de la columna especificada per columnIndex en la fila actual amb un valor enter (int).

- void **updateLong**(int columnIndex, long x): Actualitza el valor de la columna especificada per columnIndex en la fila actual amb un valor llarg (long).

- void **updateString**(int columnIndex, String x): Actualitza el valor de la columna especificada per columnIndex en la fila actual amb una cadena de text (String).

- void **updateDate**(int columnIndex, java.sql.Date x): Actualitza el valor de la columna especificada per columnIndex en la fila actual amb una data (java.sql.Date).

- void **updateInt**(String columnLabel, int x): Actualitza el valor de la columna identificada per columnLabel en la fila actual amb un valor enter (int).

- void **updateLong**(String columnLabel, long x): Actualitza el valor de la columna identificada per columnLabel en la fila actual amb un valor llarg (long).

- void **updateString**(String columnLabel, String x): Actualitza el valor de la columna identificada per columnLabel en la fila actual amb una cadena de text (String).

- void **updateDate**(String columnLabel, java.sql.Date x): Actualitza el valor de la columna identificada per columnLabel en la fila actual amb una data (java.sql.Date).

#### **Funcions vàries**

- ResultSetMetaData **getMetaData**(): Retorna una instància de ResultSetMetaData, la qual proporciona informació detallada sobre el tipus i propietats de les columnes obtingudes en el resultat de la consulta. Això inclou informació com el nom de la columna, tipus de dada, grandària de columna, i molt més, essent útil per a gestionar dinàmicament les dades sense conèixer els detalls de la taula o consulta prèviament.

- void **commit()**: Envia les modificacions de dades a la base de dades.

- void **close**(): Tanca i allibera els recursos que està utilitzant el ResultSet, com les connexions a la base de dades. Podries pensar en això com a tancar un llibre quan ja no el necessites, per tal que algú altre pugui llegir-lo. 

**Nota:** En programació Java, sovint no necessites cridar el mètode **'close'** si es fa servir un bloc especial anomenat "try-with-resources", el qual s'encarrega de tancar automàticament tot allò que necessita ser tancat. 

## Funcions de modificació de dades

### Mètode insertRow

**insertRow()** s'utilitza per inserir una nova fila en la base de dades. 

Primer, has de moure el cursor del ResultSet a la fila "insertable" especial (anomenada fila de inserció), on pots establir els valors per a cada columna que vols inserir.

Un cop hagis establert tots els valors, crides insertRow() per inserir efectivament la fila a la base de dades.

```java
    resultSet.moveToInsertRow(); // Mou el cursor a la fila d'inserció
    resultSet.updateString("nom", "Joan"); // Estableix el valor de la columna 'nom'
    resultSet.updateInt("edat", 30); // Estableix el valor de la columna 'edat'
    resultSet.insertRow(); // Insereix la fila a la base de dades
    resultSet.moveToCurrentRow(); // Torna el cursor a la posició actual
```

### Mètode updateRow

**updateRow()** s'utilitza per actualitzar els valors de la fila actual en la que el cursor del ResultSet es troba. 

Primer, mou el cursor a la fila que vols actualitzar, llavors utilitza els mètodes updateXxx() (on Xxx és el tipus de dada) per canviar els valors de les columnes que necessites modificar. 

Un cop hagis fet tots els canvis, crides updateRow() per actualitzar la fila a la base de dades.

```java
    resultSet.absolute(3); // Mou el cursor a la tercera fila
    resultSet.updateString("nom", "Maria"); // Canvia el valor de la columna 'nom'
    resultSet.updateInt("edat", 28); // Canvia el valor de la columna 'edat'
    resultSet.updateRow(); // Actualitza la fila a la base de dades
```

**Nota:** En tots dos casos, és important que el ResultSet sigui actualitzable, cosa que depèn de com es crea l'objecte Statement o PreparedStatement que es fa servir per obtenir el ResultSet.

### Exemple 0702

Aquest exemple mostra l'ús de **insertRow** i **updateRow** en un objecte **ResultSet**, aquest exemple **NO** fa ús del *Singleton AppData*.

```java
package com.project;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3308/persones";
        String user = "root"; // El teu usuari de MySQL
        String password = "pwd"; // La teva contrasenya de MySQL

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            // Important per a poder fer insercions i actualitzacions
            conn.setAutoCommit(false); 

            // Inicialitza les dades
            initData(conn); 

            System.out.println("\nDades inicials de la taula 'persones':");
            showData(conn);

            // Actualitza les dades
            updateData(conn);

            System.out.println("\nDades modificades de la taula 'persones':");
            showData(conn);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Forçar la sortida del programa per no esperar a tancar la connexió amb 'MySQL'
        // Assegura't que en aquest punt totes les dades s'han guardat correctament
        System.exit(0);
    }

    public static void initData(Connection conn) {
        try (Statement stmt = conn.createStatement()) {
            // Esborrar la taula 'persones' si existeix
            stmt.execute("DROP TABLE IF EXISTS persones");
    
            // Crear la taula 'persones'
            stmt.execute("CREATE TABLE IF NOT EXISTS persones (" +
                "id INT AUTO_INCREMENT PRIMARY KEY," +
                "nom TEXT NOT NULL," +
                "edat INTEGER)");
    
            // Inserir dades a la taula 'persones'
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Anna', 25)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Marc', 30)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Jordi', 45)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Clara', 22)");
            stmt.execute("INSERT INTO persones (nom, edat) VALUES ('Pau', 35)");
    
            conn.commit(); // Confirma els canvis
            System.out.println("La base de dades ha estat inicialitzada amb èxit.");
        } catch (SQLException e) {
            try {
                conn.rollback(); // Reverteix els canvis
                System.out.println("Rollback realitzat degut a un error.");
            } catch (SQLException ex) {
                System.out.println("Error en intentar fer rollback.");
                ex.printStackTrace();
            }
            System.out.println(e.getMessage());
        }
    }

    public static void updateData(Connection conn) {
        try (Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
    
            ResultSet rs = stmt.executeQuery("SELECT * FROM persones");
    
            // Inserir una nova fila amb 'insertRow'
            rs.moveToInsertRow();
            rs.updateString("nom", "Joan");
            rs.updateInt("edat", 30);
            rs.insertRow();
    
            // Actualitzar la fila de 'Marc' a 'Marc Garcia' amb 'updateRow'
            rs.beforeFirst(); // Torna al principi del ResultSet
            while (rs.next()) {
                if (rs.getString("nom").equals("Marc")) {
                    rs.updateString("nom", "Markus");
                    rs.updateRow();
                }
            }
    
            conn.commit(); // Confirma els canvis
            System.out.println("Les dades han estat actualitzades amb èxit.");
            rs.close();
        } catch (SQLException e) {
            try {
                conn.rollback(); // Reverteix els canvis
                System.out.println("Rollback realitzat degut a un error.");
            } catch (SQLException ex) {
                System.out.println("Error en intentar fer rollback.");
                ex.printStackTrace();
            }
            System.out.println(e.getMessage());
        }
    }
  
    public static void showData(Connection conn) {
        String query = "SELECT * FROM persones";
    
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
     
            // Obtenir metadades del ResultSet per saber el nombre de columnes
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
    
            // Mostrar noms de columnes
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rsmd.getColumnLabel(i) + "\t");
            }
            System.out.println();
    
            // Recorrer i mostrar les files
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String value = rs.getString(i);
                    System.out.print(value + "\t");
                }
                System.out.println(); // Salta a la següent línia després de cada fila
            }

            conn.commit(); // Confirma els canvis
            rs.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
```

