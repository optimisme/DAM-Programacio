<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Llistes, diccionaris i ...

## Arrays

Un array és una estructura de dades que permet emmagatzemar múltiples **elements del mateix tipus**. 

Els arrays **tenen una mida fixa** i els seus elements es poden accedir mitjançant un índex i `[x]`.

La longitud d'un array s'obté amb **.length**

### Exemple 0600

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0600.Main
```

```java
package com.exemple0600;

public class Main {

    public static void main(String[] args) {
        // Declaració i inicialització d'un array
        int[] numeros = {10, 20, 30, 40, 50};

        // Accés a elements
        System.out.println("Element a l'índex [0]: " + numeros[0]);
        System.out.println("Element a l'índex [1]: " + numeros[1]);

        numeros[1] = 25;
        System.out.println("Modificar [1] a 25 ... ");
        System.out.println("Element a l'índex [1]: " + numeros[1]);

        // Obtenir la posició de l'últim element
        int ultimaPosicio = numeros.length - 1;
        System.out.println("Últim element: " + numeros[ultimaPosicio]);
    }
}
```

### Exercici 0600

Modifica el codi de:

```bash
src/main/exercici0600/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0600.Main
```

Sense fer servir bucles, escriu un programa que sumi tots els valors del següent array.

Exemple de sortida:
```text
Array: [10, 25, 30, 40, 50]
La suma dels elements és: 155
```

### Exercici 0601

Modifica el codi de:

```bash
src/main/exercici0601/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0601.Main
```

Sense fer servir bucles, escriu un programa que compari manualment els elements del següent array per trobar el valor més gran (màxim) i el més petit (mínim).

Exemple de sortida:
```text
Array: [10, 25, 30, 40, 50]
Valor màxim: 50
Valor mínim: 10
```

### Exercici 0602

Modifica el codi de:

```bash
src/main/exercici0602/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0602.Main
```

Sense fer servir bucles, calcula la mitjana dels elements del següent array.

Exemple de sortida:
```text
Array: [10, 20, 30, 40]
Mitjana: 25.0
```

## Llistes (ArrayList)

Una llista és una col·lecció dinàmica que permet emmagatzemar **elements del mateix tipus i modificar-ne la mida**.

Maneres d'iniciar un *ArrayList*:
```java
ArrayList<Integer> numeros = new ArrayList<>();
ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(10, 20, 30));
ArrayList<Integer> numeros = new ArrayList<>(List.of(10, 20, 30));
```

Es pot 

- Per afegir elements `.add(valor)`
- Per treure elements `.remove(index)`
- Per treure modificar `.set(index, valor)`

Es pot accedir mitjançant un índex i el mètode `.get(x)`.

La longitud d'un array s'obté amb **.size()**

### Exemple 0601

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0601.Main
```

```java
package com.exemple0601;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // Crear una llista d'enters
        ArrayList<Integer> numeros = new ArrayList<>();

        // Afegir elements
        numeros.add(10);
        numeros.add(20);
        numeros.add(30);

        // Mostrar elements
        System.out.println("Elements: " + numeros);

        // Eliminar un element
        numeros.remove(1); // Elimina el segon element (índex 1)
        System.out.println("Després d'eliminar: " + numeros);

        // Modificar un element
        numeros.set(0, 15);
        System.out.println("Després de modificar: " + numeros);

        // Mostrar elements per separat
        System.out.println("Element a l'índex [0]: " + numeros.get(0));
        System.out.println("Element a l'índex [1]: " + numeros.get(1));
    }
}
```

### Exercici 0603

Modifica el codi de:

```bash
src/main/exercici0603/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0603.Main
```

Sense fer servir bucles, crea una llista **ArrayList** de 4 enters i afegeix manualment valors amb *"add"*. Després, mostra els valors afegits accedint-hi un per un amb *"get"*.

Exemple de sortida:
```text
Afegint elements: [10, 20, 30, 40]
Element a l'índex [0]: 10
Element a l'índex [1]: 20
Element a l'índex [2]: 30
Element a l'índex [3]: 40
```

### Exercici 0604

Modifica el codi de:

```bash
src/main/exercici0604/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0604.Main
```

Sense fer servir bucles, crea una llista **ArrayList** de cadenes de text, afegeix diversos elements manualment i elimina un dels elements per índex. Després, modifica un altre element existent i mostra la llista després de cada operació.

Exemple de sortida:
```text
Llista inicial: ["Hola", "què", "tal"]
Després d'eliminar l'índex [1]: ["Hola", "tal"]
Després de modificar l'índex [0] a "Adeu": ["Adeu", "tal"]
```

## Diccionaris (Hash-Map)

En Java, un diccionari és conegut com un **HashMap**. És una col·lecció que emmagatzema parelles **clau-valor**.

En un HashMap, totes les claus han de ser del mateix tipus i tots els valors han de ser del mateix tipus. Normalment les claus són *"String"* o *"int"*.

Maneres d'iniciar un *HashMap*:
```java
HashMap<String, Integer> puntuacions = new HashMap<>();
puntuacions.put("Anna", 85);
puntuacions.put("Joan", 92);
puntuacions.put("Maria", 78);

HashMap<String, Integer> puntuacions = new HashMap<>(Map.of(
    "Anna", 85,
    "Joan", 92,
    "Maria", 78
));
```

**Obtenir la llista de claus**
```java
// Obtenir totes les claus
Set<String> claus = puntuacions.keySet();

// Mostrar les claus
System.out.println("Les claus són: " + claus);
```

**Obtenir tots els valors**
```java
Collection<Integer> valors = puntuacions.values();
```

**Obtenir un valor a partir d'una clau**
```java
int puntuacioAnna = puntuacions.get("Anna")
```

**Afegir o modificar el valor a partir d'una clau**
```java
// Modifica la puntuació d'Anna a 90 (o l'afegeix si no existeix)
puntuacions.put("Anna", 90); 

// No canvia perquè "Anna" ja existeix (o l'afegeix si no existeix)
puntuacions.putIfAbsent("Anna", 95); 
```

**Eliminar elements**
```java
// Elimina Maria del mapa
puntuacions.remove("Maria"); 

// Només elimina si el valor és 92
puntuacions.remove("Joan", 92); 
```

**Consultar elements**
```java
// Comprova si la clau "Anna" existeix
if (puntuacions.containsKey("Anna")) {
    System.out.println("La puntuació d'Anna és: " + puntuacions.get("Anna"));
}

// Comprova si alguna clau té el valor 85
if (puntuacions.containsValue(85)) {
    System.out.println("Algú té una puntuació de 85.");
}
```

**Altres operacions d'un HashMap**
```java
// Retorna el nombre d'elements
int mida = puntuacions.size(); 

// Buida el mapa
puntuacions.clear(); 

// Comprovar si un HasMap té claus i valors
if (puntuacions.isEmpty()) {
    System.out.println("El mapa està buit.");
}
```

### Exemple 0602

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0602.Main
```

```java
package com.exemple0602;

import java.util.HashMap;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        // Crear un HashMap
        HashMap<String, Integer> puntuacions = new HashMap<>();

        // Afegir parelles clau-valor
        puntuacions.put("Anna", 85);
        puntuacions.put("Joan", 92);
        puntuacions.put("Maria", 78);

        // Accedir a un valor
        System.out.println("Puntuació de Joan: " + puntuacions.get("Joan"));

        // Obtenir totes les claus
        Set<String> claus = puntuacions.keySet();
        System.out.println("Totes les claus: " + claus);

        // Eliminar un element
        puntuacions.remove("Maria");
        System.out.println("Després d'eliminar Maria: " + puntuacions);

        // Obtenir les claus després d'eliminar
        claus = puntuacions.keySet();
        System.out.println("Claus després de l'eliminació: " + claus);
    }
}
```

### Exercici 0605

Modifica el codi de:

```bash
src/main/exercici0605/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0605.Main
```

Sense fer servir bucles, crea un HashMap que emmagatzemi noms d'estudiants com a claus i les seves notes com a valors. Afegeix manualment 3 parelles clau-valor al HashMap. Després, accedeix a cada element per clau i mostra el nom i la nota.

Exemple de sortida:
```text
Nota d'Anna: 8.5
Nota de Joan: 9.0
Nota de Maria: 7.8
```

### Exercici 0606

Modifica el codi de:

```bash
src/main/exercici0606/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0606.Main
```

Sense fer servir bucles, crea un HashMap amb noms de productes com a claus i els seus preus com a valors. Afegeix 3 parelles clau-valor manualment. Després:

- Elimina un dels productes per clau.
- Modifica el preu d'un altre producte.
- Mostra el contingut actual del HashMap després de cada operació.

Exemple de sortida:
```text
Mapa inicial: {Pa=1.2, Llet=0.99, Ous=2.5}
Després d'eliminar 'Llet': {Pa=1.2, Ous=2.5}
Després de modificar el preu de 'Pa': {Pa=1.5, Ous=2.5}
```

### Mixed map

En **Java**, no es pot fer un HashMap amb valors de diferents tipus, ja que necessita que tant les claus com els valors tinguin un tipus fix definit en el moment de la creació.

Es pot fer un HashMap amb un tipus genèric *"Object"*, però cal transformar el valor al seu tipus original cada vegada que es vol fer servir:

### Exemple 0603

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0603.Main
```

```java
package com.exemple0603;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Object> mixedMap = new HashMap<>();

        mixedMap.put("Enter", 42);
        mixedMap.put("Text", "Hola món");
        mixedMap.put("Decimal", 3.14);

        // Accedir als valors amb cast
        int enter = (int) mixedMap.get("Enter");
        String text = (String) mixedMap.get("Text");
        double decimal = (double) mixedMap.get("Decimal");

        System.out.println("Enter: " + enter);
        System.out.println("Text: " + text);
        System.out.println("Decimal: " + decimal);
    }
}
```

### Exercici 0607

Modifica el codi de:

```bash
src/main/exercici0607/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0607.Main
```

Sense fer servir bucles, crea un Mixed-Map que contingui:

- Les claus són noms de persones (String).
- Els valors són "edat" (int), "esport" (String).

Després, accedeix manualment a cadascuna de les claus i mostra el contingut.

Exemple de sortida:
```text
Anna té 30 anys i practica futbol.
Joan té 18 anys i practica natació.
Maria té 14 anys i practica padel.
```

## Records

Els **records** permeten emmagatzemar dades de diferents tipus de valors, en objectes predefinits.

Aquestes dades **no es poden modificar**, en tot cas cal crear una nova instància.

Els *record* es poden definir de dues maneres:

- En el seu propi arxiu .java:

```java
// Persona.java
public record Persona(String nom, int edat) {}
```

- Dins del 'Main', fora dels altres mètodes:

### Exemple 0604

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0604.Main
```

```java
package com.exemple0604;

public class Main {

    public static record Persona(String nom, int edat) {}

    public static void main(String[] args) {

        Persona persona = new Persona("Anna", 25);

        System.out.println("Nom: " + persona.nom());
        System.out.println("Edat: " + persona.edat());

        System.out.println("Crear una nova instància, per modificar l'edat:");

        persona = new Persona(persona.nom(), 28);

        System.out.println("Nom: " + persona.nom());
        System.out.println("Edat: " + persona.edat());
    }
}
```

Al definir el *record* es defineixen també els seus atributs i el tipus de cada un. A l'exemple anterior els atributs són:

- nom (String)
- edat (int)

### Exercici 0608

Modifica el codi de:

```bash
src/main/exercici0608/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0608.Main
```

Sense fer servir bucles, crea un record per emmagatzemar informació sobre una persona, amb els camps:

- nom (String)
- edat (int)
- ciutat (String)

Després, crea manualment dues instàncies del record i mostra la informació de cada persona sense utilitzar bucles.

Exemple de sortida:
```text
Persona 0: Anna, 25 anys, viu a Barcelona.
Persona 1: Joan, 30 anys, viu a Girona.
```

## Split & Join

A **Java**, es pot dividir una cadena de text en un array de textos amb la funció **split**:

### Exemple 0605

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0605.Main
```

```java
package com.exemple0605;

public class Main {

    public static void main(String[] args) {
        String text = "poma,plàtan,maduixa,raïm";

        // Dividir el text en un array de cadenes
        String[] fruits = text.split(",");

        // Mostrar el resultat
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
```

També es poden ajuntar els textos d'un array amb la funció **join**:

### Exemple 0606

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0606.Main
```

```java
package com.exemple0606;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("poma", "plàtan", "maduixa", "raïm");

        // Ajuntar els elements amb una barra '/'
        String result = String.join("/", fruits);

        System.out.println(result);
    }
}
```

### Exercici 0609

Modifica el codi de:

```bash
src/main/exercici0609/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0609.Main
```

Fes que a partir d'una cadena de text escrita per l'usuari, canvii els espais que separen les paraules per guions `-`

Fes-ho amb les funcions **split** i **join**

Exemple de sortida:
```text
Escriu una frase: Hola què tal
Resultat: Hola-què-tal
```