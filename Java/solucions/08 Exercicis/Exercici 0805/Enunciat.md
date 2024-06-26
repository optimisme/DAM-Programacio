<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 5

SENSE fer servir el Singleton 'AppData', fes una base de dades MySQL anomenada videogame_park i desenvolupa una aplicació que gestioni les àrees del parc temàtic de videojocs i les tarifes d'accés a aquestes àrees.

Aquest cop però, s'ha de treballar directament amb els *ResourceSet*.

**Nota:** Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'videogame_park.sql' amb:

**Important**: Al corregir, els testos han de funcionar amb base de dades 'videogame_park', port 3308, usuari 'root' i codi 'pwd'

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < dbNatura.sql
```

A Windows:
```bash
type dbNatura.sql | docker exec -i mysqlServer mysql -uroot -ppwd
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

Ha de donar aquesta sortida:

```text
ID: 1, Nom: Zona Arcade, Temàtica: Arcade, Capacitat Màxima: 100
ID: 2, Nom: Zona VR, Temàtica: Realitat Virtual, Capacitat Màxima: 50
ID: 1, Nom: Passi Bàsic, Preu: 19.99, Durada: 1 dies
ID: 2, Nom: Passi Premium, Preu: 39.99, Durada: 3 dies
Tarifa: Passi Bàsic
Tarifa: Passi Premium
Àrea: Zona Arcade
Àrea: Zona Arcade
Àrea: Zona VR
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
./runTest.sh com.project.TestMain#testMainResultSet
```

