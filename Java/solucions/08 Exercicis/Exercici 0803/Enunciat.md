<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 3

Fent servir el Singleton 'AppData' i una base de dades *MySQL* anomenada **school**, desenvolupa una aplicació que gestioni alumnes, professors, aules i assignatures.

**Nota**: Si ja hi ha un contenedor MySQL a docker, anomenat 'mysqlServer', es pot carregar iniciar la base de dades 'school.sql' amb:

A Linux i macOS:
```bash
docker exec -i mysqlServer mysql -uroot -ppwd < dbSchool.sql
```

A Windows:
```bash
type dbSchool.sql | docker exec -i mysqlServer mysql -uroot -ppwd
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

Ha de donar aquesta sortida:

```text
Professors:
ID: 1, Nom: Maria Garcia, Especialitat: Matemàtiques
ID: 2, Nom: Jordi Pozo, Especialitat: Literatura
ID: 3, Nom: Anna Molina, Especialitat: Ciències

Assignatures:
ID: 1, Nom: Maria Garcia, Hores Setmanals: 4, Professor: null
ID: 2, Nom: Jordi Pozo, Hores Setmanals: 3, Professor: null
ID: 3, Nom: Anna Molina, Hores Setmanals: 5, Professor: null

Aules:
ID: 1, Nom: A101, Capacitat: 30
ID: 2, Nom: A102, Capacitat: 25
ID: 3, Nom: B201, Capacitat: 20

Assignatures:
Assignatures per l'alumne ID 1:
- Algebra
Assignatures per l'alumne ID 3:
- Algebra
- Literatura Catalana
- Biologia

Alumnes per assignatura:
Alumnes inscrits a l'assignatura ID 1:
- Marc Soler
- Iván Coll
Alumnes inscrits a l'assignatura ID 2:
- Laura Vidal
- Iván Coll
Alumnes inscrits a l'assignatura ID 3:
- Iván Coll
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
```

