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

Crea tres classes 'Autor', 'Llibre' i 'Prestec'

*Classe Autor*

**Atributs** privats:

- nom (String): El nom complet de l'autor.
- nacionalitat (String): La nacionalitat de l'autor.

**Constructor**:

Un constructor que inicialitzi el nom i la nacionalitat de l'autor.

**Mètodes**:

Setters i getters per a cada atribut.

*Classe Llibre*

**Atributs**:

- titol (String): El títol del llibre.
- autor (Autor): Una instància de Autor que representa l'autor del llibre.
- anyPublicacio (int): L'any de publicació del llibre.

**Constructor**:

Un constructor que inicialitzi el titol, l'autor, i l'anyPublicacio.

**Mètodes**:

Setters i getters per a cada atribut.

*Classe Préstec*

**Atributs**:

- llibre (Llibre): El llibre que s'ha prestat.
- dataPrestec (String): La data en què es va realitzar el préstec.
- dataRetorn (String): La data en què s'ha de retornar el llibre.

**Constructors**:

Un constructor que inicialitzi el llibre, la dataPrestec, i la dataRetorn.

**Mètodes**:

Setters i getters per a cada atribut.

Un mètode estaEnTermini() que retorni un booleà indicant si el llibre s'ha retornat dins del termini establert (pots simular-ho amb una comprovació simple de la data).

Comprova que el següent Main:

```java
package com.project;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creació d'autors
        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("J.K. Rowling", "Britànica");

        // Creació de llibres
        Llibre llibre1 = new Llibre("Cien años de soledad", autor1, 1967);
        Llibre llibre2 = new Llibre("Harry Potter y la piedra filosofal", autor2, 1997);

        // Creació de Prestecs
        Prestec prestec1 = new Prestec(llibre1, "01/01/2024", "31/01/2024");
        Prestec prestec2 = new Prestec(llibre2, "15/01/2024", "15/02/2024");

        // Llista de Prestecs per gestionar
        List<Prestec> prestecs = new ArrayList<>();
        prestecs.add(prestec1);
        prestecs.add(prestec2);

        // Mostrar informació dels Prestecs i validar si estan en termini
        for (Prestec prestec : prestecs) {
            Llibre llibre = prestec.getLlibre();
            Autor autor = llibre.getAutor();
            System.out.println("Llibre: " + llibre.getTitol() + " - Autor: " + autor.getNom() + " (" + autor.getNacionalitat() + ")");
            System.out.println("Data de Prestec: " + prestec.getDataPrestec() + " - Data de retorn: " + prestec.getDataRetorn());
            System.out.println("Està en termini? " + prestec.estaEnTermini());
            System.out.println("-----");
        }
    }
}
```

Dóna com a resultat:

```text
Llibre: Cien años de soledad - Autor: Gabriel García Márquez (Colombiana)
Data de Prestec: 01/01/2024 - Data de retorn: 31/01/2024
Està en termini? true
-----
Llibre: Harry Potter y la piedra filosofal - Autor: J.K. Rowling (Britànica)
Data de Prestec: 15/01/2024 - Data de retorn: 15/02/2024
Està en termini? true
-----
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainSettersGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes

