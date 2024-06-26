<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 1

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

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
```

