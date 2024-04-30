<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 0

Fent servir el Singleton 'AppData' i una base de dades *sqlite*, desenvolupa una aplicació per a una biblioteca que no només gestioni els llibres sinó també les editorials. 

Cada llibre estarà relacionat amb una editorial amb claus foranes per establir relacions entre taules.

**Taula editorials:**

```sql
id_editorial (INTEGER) : Un identificador únic per a cada editorial.
nom (TEXT) : El nom de l'editorial.
```

**Taula llibres:**

```sql
id_llibre (INTEGER) : Un identificador únic per a cada llibre.
titol (TEXT) : El títol del llibre.
autor (TEXT) : El nom de l'autor del llibre.
any_publicacio (INTEGER) : L'any de publicació del llibre.
id_editorial (INTEGER) : La clau forana que enllaça amb l'id_editorial de la taula editorials.
```

Defineix també les següents funcions:
```text
void crearTaulaEditorials()
void crearTaulaLlibres()
void afegirEditorial(String nom)
void afegirLlibre(String titol, String autor, int anyPublicacio, int idEditorial)
void llistarTaulaEditorials()
void llistarTaulaLlibres()
void llistarInfoLlibre(int idLlibre)
```

Prova-ho amb aquest main:

```java
public class Main {
    public static void main(String[] args) {
        AppData db = AppData.getInstance();

        // Crear taules
        crearTaulaEditorials();
        crearTaulaLlibres();

        // Afegir editorials
        afegirEditorial("Editorial Alpha");
        afegirEditorial("Beta Publishers");
        afegirEditorial("Gamma Books");
        afegirEditorial("Delta Literature");

        // Afegir llibres
        afegirLlibre("El primer llibre", "Autor A", 2020, 1);
        afegirLlibre("Segona obra", "Autor B", 2018, 2);
        afegirLlibre("Tercer volum", "Autor C", 2019, 3);
        afegirLlibre("Quart text", "Autor D", 2021, 4);
        afegirLlibre("Cinquè manuscrit", "Autor E", 2022, 1);
        afegirLlibre("Sisè document", "Autor F", 2023, 2);

        System.out.println("\nEditorials:");
        llistarTaulaEditorials();

        System.out.println("\nLlibres:");
        llistarTaulaLlibres();

        int idLlibre = 5;
        System.out.println("\nInformació del Llibre: " + idLlibre);
        llistarInfoLlibre(idLlibre);

        // Tancar la connexió amb la base de dades (del singleton)
        db.close();
    }
}
```

Ha de donar aquesta sortida:

```text
Editorials:
ID: 1, Nom: Editorial Alpha
ID: 2, Nom: Beta Publishers
ID: 3, Nom: Gamma Books
ID: 4, Nom: Delta Literature

Llibres:
ID: 1, Títol: El primer llibre, Autor: Autor A, Any: 2020, Editorial: Editorial Alpha
ID: 2, Títol: Segona obra, Autor: Autor B, Any: 2018, Editorial: Beta Publishers
ID: 3, Títol: Tercer volum, Autor: Autor C, Any: 2019, Editorial: Gamma Books
ID: 4, Títol: Quart text, Autor: Autor D, Any: 2021, Editorial: Delta Literature
ID: 5, Títol: Cinquè manuscrit, Autor: Autor E, Any: 2022, Editorial: Editorial Alpha
ID: 6, Títol: Sisè document, Autor: Autor F, Any: 2023, Editorial: Beta Publishers

Informació del Llibre: 5
ID: 5, Títol: Cinquè manuscrit, Autor: Autor E, Any de Publicació: 2022, Editorial: Editorial Alpha
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainTables
./runTest.sh com.project.TestMain#testMainCalls
```

