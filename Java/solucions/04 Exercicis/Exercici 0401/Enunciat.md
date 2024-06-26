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

Crea la classe 'Llibre' que modeli el comportament bàsic d'un llibre en una biblioteca, permetent establir i obtenir el títol, l'autor, l'any de publicació i si està en préstec o no.

**Atributs Privats:**

String titol: El títol del llibre.

String autor: L'autor del llibre.

int anyPublicacio: L'any de publicació del llibre.

boolean presetec: Indica si el llibre està en préstec o no.

**Constructor:**

Un constructor que accepti el títol, l'autor i l'any de publicació. El llibre hauria de començar no prestat per defecte.

**Mètodes Públics:**

getTitol(): Retorna el títol del llibre.

getAutor(): Retorna l'autor del llibre.

getAnyPublicacio(): Retorna l'any de publicació del llibre.

estaPrestat(): Retorna si el llibre està prestat o no.

prestar(): Marca el llibre com a prestat.

retornar(): Marca el llibre com a no prestat.

toString(): Retorna una cadena de text que representa el llibre, incloent el títol, l'autor, l'any de publicació i l'estat de préstec.

Amb el següent format:

"Titol, Autor; Any - En préstec" o bé "Titol, Autor; Any - Disponible"

Comprova que per aquest codi:

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        // Creació de 3 llibres
        Llibre llibre1 = new Llibre("El Senyor dels Anells", "J.R.R. Tolkien", 1954);
        Llibre llibre2 = new Llibre("1984", "George Orwell", 1949);
        Llibre llibre3 = new Llibre("El Petit Príncep", "Antoine de Saint-Exupéry", 1943);

        // Mostra l'estat inicial dels llibres
        System.out.println(llibre1);
        System.out.println(llibre2);
        System.out.println(llibre3);

        // Modifica l'estat del préstec de cada llibre
        llibre1.prestar();
        llibre2.prestar();
        // El llibre3 es queda disponible

        // Mostra l'estat després dels préstecs
        System.out.println("\nDesprés dels préstecs:");
        System.out.println(llibre1);
        System.out.println(llibre2);
        System.out.println(llibre3);

        // Retornem el llibre1 i el mostrem
        llibre1.retornar();
        System.out.println("\nDesprés de retornar el llibre1:");
        System.out.println(llibre1);
    }
}
````

Otens aquesta sortida:

```bash
El Senyor dels Anells, J.R.R. Tolkien; 1954 - Disponible
1984, George Orwell; 1949 - Disponible
El Petit Príncep, Antoine de Saint-Exupéry; 1943 - Disponible

Després dels préstecs:
El Senyor dels Anells, J.R.R. Tolkien; 1954 - En préstec
1984, George Orwell; 1949 - En préstec
El Petit Príncep, Antoine de Saint-Exupéry; 1943 - Disponible

Després de retornar el llibre1:
El Senyor dels Anells, J.R.R. Tolkien; 1954 - Disponible
```

Assegura't que passa els testos:

```bash
./runTest.sh com.project.TestMain#testMainOutput
./runTest.sh com.project.TestMain#testMainSettersGetters
./runTest.sh com.project.TestMain#testMainPrivateAttributes

