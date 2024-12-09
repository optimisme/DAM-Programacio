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

- La longitud d'un array s'obté amb: **.length**
- Per escriure el contingut d'un array: **Arrays.toString(nomArrray)**

### Exemple 0600

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0600.Main
```

```java
package com.exemple0600;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Declaració i inicialització d'un array
        int[] numeros = {10, 20, 30, 40, 50};

        // Escriure els elements
        System.out.println("Array: " + Arrays.toString(numeros));

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

**Mètodes d'ArrayList**

- **Afegir elements:** 
    * `.add(valor)` (al final)
    * `.add(index, valor)` (en una posició específica)
- **Treure elements:** 
    * `.remove(index)` (per índex)
    * `.remove(object)` (per valor)
    * `.removeIf(predicate)` (per condició)
- **Modificar elements:** 
    * `.set(index, valor)` (substituir el valor en un índex)
- **Llegir elements:** 
    * `.get(index)` (obtenir el valor en un índex)
- **Obtenir la longitud:** 
    * `.size()` (nombre total d'elements).
- **Comprovar si conté un element:** 
    * `.contains(valor)`
- **Trobar la posició d'un element:** 
    * `.indexOf(valor)` 
    * `.lastIndexOf(valor)`
- **Eliminar tots els elements:** 
    * `.clear()`
- **Comprovar si està buit:** 
    * `.isEmpty()`
- **Obtenir una subllista:** 
    * `.subList(inici, final)` (vista d'una part de la llista).
- **Convertir a array:** 
    * `.toArray()` (per treballar amb arrays).

Un **predicate** en programació és una funció que pren un element com a entrada i retorna un valor booleà (true o false). A **Java**, s'utilitza sovint en col·leccions com a part de funcionalitats de filtratge o eliminació.

Exemple:

```java
public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(10);
        numeros.add(15);
        numeros.add(20);
        numeros.add(25);

        // El predicat ha de tornar 'true' o 'false'
        // Eliminar si és imparell (si el mòdul 2 és != 0)
        numeros.removeIf((n) -> {
            return (n % 2 != 0);
        });

        System.out.println(numeros); // Sortida: [10, 20]
    }
```

**Subllistes**

Per obtenir una porció d'un ArrayList `.subList(inici, final)`

- Inici és inclusiu
- Final és exclusiu (no inclòs)
- S'obté una vista, no una nova llista

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
// Obtenir totes les claus (cal adaptar el tipus String si és diferent)
Set<String> claus = puntuacions.keySet();
ArrayList<String> llistaDeClaus = new ArrayList<>(claus);

// Mostrar l'ArrayList de claus
System.out.println("ArrayList de claus: " + llistaDeClaus);
```

**Obtenir tots els valors**
```java
// Obtenir els valors del HashMap (cal adaptar el tipus Integer si és diferent)
Collection<Integer> valors = puntuacions.values();
ArrayList<Integer> llistaDeValors = new ArrayList<>(valors);

// Mostrar l'ArrayList de valors
System.out.println("ArrayList de valors: " + llistaDeValors);
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

L'estructura és: 
```java
Hashmap<String, Hashmap<String, Object>>
```
```json
{
    "Anna": {
        "edat": 30,
        "esport": "futbol"
    },
    "Joan": {
        "edat": 18,
        "esport": "natació"
    },
    ...
}
```

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

## Ordenació d'ArrayList

A **Java**, es pot ordenar els ArrayList amb la funció **".sort"**, que té com a paràmetre una funció **lambda** amb el resultat d'ordenar dos valors `a` i `b`.

### Exemple 0607

Exemple d'ordenar un ArrayList de tipus *Integer*, l'ArrayList original *numeros* queda modificat.

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0607.Main
```

```java
package com.exemple0607;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        numeros.add(25);
        numeros.add(5);
        numeros.add(15);
        numeros.add(10);

        System.out.println("Abans d'ordenar: " + numeros);

        // Ordenar de menor a major
        numeros.sort((a, b) -> a.compareTo(b));
        System.out.println("De menor a major: " + numeros);

        // Ordenar de major a menor
        numeros.sort((a, b) -> b.compareTo(a));
        System.out.println("De major a menor: " + numeros);
    }
}
```

### Exemple 0608

Exemple d'ordenar un ArrayList de tipus *String*, l'ArrayList original *noms* queda modificat.

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0608.Main
```

```java
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Mario");
        noms.add("Luigi");
        noms.add("Peach");
        noms.add("Bowser");

        System.out.println("Abans d'ordenar: " + noms);

        // Ordenar alfabèticament (ascendent)
        noms.sort((a, b) -> a.compareTo(b));
        System.out.println("De menor a major (alfabètic): " + noms);

        // Ordenar alfabèticament (descendent)
        noms.sort((a, b) -> b.compareTo(a));
        System.out.println("De major a menor (alfabètic): " + noms);
    }
}
```

### Exemple 0609

Exemple d'ordenar un ArrayList que conté un HashMap. Per no modificar l'ArrayList original, en fa una còpia en una nova variable.

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0609.Main
```

```java
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static HashMap<String, Object> createStudent(String name, int age) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("age", age);
        return map;
    }

    public static void showInformation(ArrayList<HashMap<String, Object>> students) {
        for (HashMap<String, Object> student : students) {
            System.out.println("Name: " + student.get("name") + ", " + student.get("age") + " years");
        }
    }

    public static void main(String[] args) {
        ArrayList<HashMap<String, Object>> students = new ArrayList<>();

        students.add(createStudent("Anna", 18));
        students.add(createStudent("Marcos", 19));
        students.add(createStudent("Eva", 17));
        students.add(createStudent("Zahir", 18));

        // Fer la còpia per no modificar l'original
        ArrayList<HashMap<String, Object>> studentsByName = new ArrayList<>(students);
        studentsByName.sort((student1, student2) -> {
            String a = (String) student1.get("name");
            String b = (String) student2.get("name");
            return a.compareTo(b);
        });

        // Fer la còpia per no modificar l'original
        ArrayList<HashMap<String, Object>> studentsByAge = new ArrayList<>(students);
        studentsByAge.sort((student1, student2) -> {
            Integer a = (Integer) student1.get("age");
            Integer b = (Integer) student2.get("age");
            return a.compareTo(b);
        });

        System.out.println("Original List:");
        showInformation(students);

        System.out.println("-".repeat(25));
        System.out.println("Sorted by Name:");
        showInformation(studentsByName);

        System.out.println("-".repeat(25));
        System.out.println("Sorted by Age:");
        showInformation(studentsByAge);
    }
}
```

### Exercici 0610

Modifica el codi de:

```bash
src/main/exercici0610/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0610.Main
```

Fes un programa que guardi la següent informació en una combinació de **ArrayList** i **HashMap** amb les claus: *nom*, *especie*, *pes*, *anysVida*

```text
| Nom      | Espècie  | Pes | A.V |
|----------|----------|-----|-----|
| Simba    | Lleó     | 190 |   15|
| Pelut    | Gos      |   6 |   12|
| Max      | Cavall   | 500 |   30|
| Luna     | Gat      |   4 |   15|
| Rocky    | Tortuga  | 150 |  100|
| Polly    | Loro     |   1 |   50|
```
Finalment, mostra el resultat d'ordenar la llista segons:

- nom
- especie
- pes
- anysVida

Mostra en quatre taules, on:

- Es mostra el títol abans de la taula
- Els noms estàn aliniats a l'esquerra i ocupen 10 caràcters
- Els números ocupen 5 caràcters i s'alinien a la dreta

Per exemple:
```text
> Ordenats per "pes"
| Nom      | Espècie  | Pes | A.V |
|----------|----------|-----|-----|
| Polly    | Loro     |   1 |   50|
| Luna     | Gat      |   4 |   15|
| Pelut    | Gos      |   6 |   12|
| Rocky    | Tortuga  | 150 |  100|
| Simba    | Lleó     | 190 |   15|
| Max      | Cavall   | 500 |   30|
```

## Filtrar

Filtar elements d'una llista és escollir-ne algun subconjunt segons un criteri. 

El tipus **ArrrayList** no permet filtrar elements de manera directe, però es pot fer fàcilment així:

- Obtenir un *stream*
- Escollir els elements amb un *predicat* que retorna *"true"* o *"false"*
- Tornar-ho a *ArrayList* amb un *collect*

Per filtrar els elements d'una llista, s'ha de definir un *predicat* tal i com en aquest exemple:

### Exemple 0610

Exemple de com filtrar els elements d'un *ArrayList*:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0610.Main
```

```java
package com.exemple0610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11));
        
        // Filtrar només els números parells
        ArrayList<Integer> parells = new ArrayList<>(numeros.stream()
            .filter((num) -> {
                // El mòdul de 2 igual a 0 escull els parells
                return (num % 2 == 0);
            })
            .collect(Collectors.toList()));
        
        System.out.println("Números parells: " + parells);
    }
}
```

## Mapejar

Mapejar elements d'una llista és aplicar una funció a cada un dels elements. 

El tipus **ArrrayList** no permet mapejar elements de manera directe, però es pot fer fàcilment així:

- Obtenir un *stream*
- Aplicar el mapping amb un *predicat*
- Tornar-ho a *ArrayList* amb un *collect*

Al mapejar **pot canviar el tipus**, en aquest exemple el *predicat* retorna un **Double** i per això la llista resultant és **"ArrayList<Double>"**:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0611.Main
```

```java
package com.exemple0611;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11));
        
        // Obtenir una llista amb cada valor dividit per 2
        ArrayList<Double> meitats = new ArrayList<>(numeros.stream()
            .map((num) -> {
                Double rst = num / 2.0;
                return rst;
            })
            .collect(Collectors.toList()));
        
        System.out.println("Números parells: " + meitats);
    }
}
```

## Filtrar & Mapejar

L'avantatge de fer servir un *stream* per aplicar filtres i mapejats és que es poden combinar aquestes dues operacions en un mateix *stream*:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0612.Main
```

```java
package com.exemple0612;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        
        ArrayList<Integer> numeros = new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11));
        
        // Obtenir una llista amb cada valor dividit per 2
        ArrayList<Double> senarsDuplicats = new ArrayList<>(numeros.stream()
            .filter((num) -> {
                // El mòdul de 2 diferent de 0 escull els imparells
                return (num % 2 != 0);
            })
            .map((num) -> {
                // Duplica el valor
                Double rst = num * 2.0;
                return rst;
            })
            .collect(Collectors.toList()));
        
        System.out.println("Imparells duplicats: " + senarsDuplicats);
    }
}
```

### Exercici 0611

Modifica el codi de:

```bash
src/main/exercici0611/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0611.Main
```

Fes un programa que guardi la següent informació en una combinació de **ArrayList** i **HashMap** amb les claus: *nom*, *especie*, *pes*, *anysVida*

```text
| Nom      | Espècie  | Pes | A.V |
|----------|----------|-----|-----|
| Simba    | Lleó     | 190 |   15|
| Pelut    | Gos      |   6 |   12|
| Max      | Cavall   | 500 |   30|
| Luna     | Gat      |   4 |   15|
| Rocky    | Tortuga  | 150 |  100|
| Polly    | Loro     |   1 |   50|
```
Finalment:

- Aplica un *filter* per mostrar la taula resultant amb els animals que pesen més de 100Kg.
- Aplica un *map* per mostrar la taula resultant amb els noms dels animals en majúscules.
- Aplica un *filter* i un *map* per mostrar la taula resultant amb els animals que viuen menys o igual a 30 anys, posa-hi un nou atribut *cal* (Columna "Cal") que és el resultat dividir els anys de vida pel pes de l'animal.
