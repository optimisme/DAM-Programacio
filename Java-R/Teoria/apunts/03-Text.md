<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Operacions amb cadenes de text

## Concatenació

**Concatenar** és unir dues cadenes de text, es pot fer amb:

- **`+`**: l'operador de suma
- **concat(String str)**: la funció de concatenar

```java
String nom = "Toni";
String cognom = "Camacho";
String nomComplet = nom + " " + cognom; // Amb +
System.out.println("Nom complet: " + nomComplet);

String salutacio = "Hola, ".concat(nom); // Amb concat
System.out.println(salutacio);
```

## Comparació

Hi ha diversos mètodes per comparar cadenes de text:

- **equals(String str)**: *'True'* si dues cadenes són exactament iguals.
- **equalsIgnoreCase(String str)**: *'True'* si dues cadenes són iguals ignorant majúscules i minúscules.
- **compareTo(String str)**: Retorna 0, un número negatiu o un número positiu segons l'ordenació alfabètica de les cadenes
- **startsWith(String prefix)**: Comprova si la cadena comença amb un prefix determinat.
- **endsWith(String suffix)**: Comprova si la cadena acaba amb un sufix determinat.

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0300.Main
```

```java
package com.exemple0300;

public class Main {
    public static void main(String[] args) {
        // Exemples de cadenes
        String cadena1 = "Hola, món!";
        String cadena2 = "hola, món!";
        String cadena3 = "Adéu, món!";
        String prefix = "Hola";
        String sufix = "món!";

        // equals(String str): Comprova si dues cadenes són exactament iguals
        System.out.println("cadena1.equals(cadena2): " + cadena1.equals(cadena2)); // False
        System.out.println("cadena1.equals(\"Hola, món!\"): " + cadena1.equals("Hola, món!")); // True

        // equalsIgnoreCase(String str): Comprova si dues cadenes són iguals ignorant majúscules i minúscules
        System.out.println("cadena1.equalsIgnoreCase(cadena2): " + cadena1.equalsIgnoreCase(cadena2)); // True

        // compareTo(String str): Compara lexicogràficament les cadenes
        System.out.println("cadena1.compareTo(cadena3): " + cadena1.compareTo(cadena3)); // Positiu (cadena1 > cadena3)
        System.out.println("cadena3.compareTo(cadena1): " + cadena3.compareTo(cadena1)); // Negatiu (cadena3 < cadena1)
        System.out.println("cadena1.compareTo(\"Hola, món!\"): " + cadena1.compareTo("Hola, món!")); // 0

        // startsWith(String prefix): Comprova si comença amb un prefix determinat
        System.out.println("cadena1.startsWith(prefix): " + cadena1.startsWith(prefix)); // True
        System.out.println("cadena3.startsWith(prefix): " + cadena3.startsWith(prefix)); // False

        // endsWith(String suffix): Comprova si acaba amb un sufix determinat
        System.out.println("cadena1.endsWith(sufix): " + cadena1.endsWith(sufix)); // True
        System.out.println("cadena3.endsWith(sufix): " + cadena3.endsWith(sufix)); // True
    }
}
```

## Longitud

Per obtenir la quantitat de caràcters (llargada) d'una cadena es fa servir **.length()**:

```java
String text = "Aquest és un exemple";
System.out.println("Longitud: " + text.length()); // 21
```

## Subcadenes

Per obtenir subcadenes de text es fa servir **substring**: 

- **substring(int start)**: Retorna la subcadena des de la posició indicada fins al final.
- **substring(int start, int end)**: Retorna la subcadena entre les posicions start i end (excloent end).

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0301.Main
```

```java
package com.exemple0301;

public class Main {
    public static void main(String[] args) {

        String text = "Hola, Java";
        System.out.println(text);
        System.out.println("0123456789");
        System.out.println("      " + text.substring(6));    // "Java"
        System.out.println("      " + text.substring(6, 9)); // "Jav"
        System.out.println("      " + text.substring(6, 8)); // "Ja"
    }
}
```

## Cerca dins d'una cadena

Hi ha diferents maneres de buscar dins d'una cadena de text

- **indexOf(String str)**: Retorna la posició de la primera aparició d'un text (o -1 si no existeix).
- **lastIndexOf(String str)**: Retorna la posició de l'última aparició.
- **contains(CharSequence seq)**: Comprova si la cadena conté un text determinat.

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0302.Main
```

```java
package com.exemple0302;

public class Main {
    public static void main(String[] args) {

        String text = "Hola, Laura";

        System.out.println(text);
        System.out.println("0123456789");
        
        int posMariano = text.indexOf("Laura");
        System.out.println("\"Laura\" està a la posició: " + posMariano);

        boolean isHolaInText = text.contains("Hola");
        System.out.println("\"hola\" està a la cadena de text? " + isHolaInText);

        int posLastA = text.lastIndexOf("a");
        System.out.println("La última lletra 'a' està a la posició: " + posLastA);
    }
}
```

## Manipulació de textos

Algunes funcions retornen el valor d'una cadena de text, però manipulada:

- **toUpperCase()**: La cadena a majúscules.
- **toLowerCase()**: La cadena a minúscules.
- **trim()**: Elimina espais en blanc al principi i al final.
- **replace(CharSequence target, CharSequence replacement)**: Substitueix una part de la cadena.

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0303.Main
```

```java
package com.exemple0303;

public class Main {
    public static void main(String[] args) {
        // Cadena d'exemple
        String cadena = "   Hola, món!   ";

        System.out.println("Cadena original: " + cadena);

        // toUpperCase(): Converteix tota la cadena a majúscules
        String majuscules = cadena.toUpperCase();
        System.out.println("Cadena en majúscules: " + majuscules); // "   HOLA, MÓN!   "

        // toLowerCase(): Converteix tota la cadena a minúscules
        String minuscules = cadena.toLowerCase();
        System.out.println("Cadena en minúscules: " + minuscules); // "   hola, món!   "

        // trim(): Elimina espais en blanc al principi i al final
        String senseEspais = cadena.trim();
        System.out.println("Cadena sense espais: '" + senseEspais + "'"); // "Hola, món!"

        // replace(CharSequence target, CharSequence replacement): Substitueix part de la cadena
        String substituida = cadena.replace("món", "univers");
        System.out.println("Cadena substituïda: " + substituida); // "   Hola, univers!   "
    }
}
```

## Mostrar textos

**Java** té diverses maneres de mostrar textos per pantalla, la més habitual és amb un system.out:

```java
System.out.println("Hola, Caracola");
```

Però també permet escriure textos en múltiples linies a través de **`"""`**:
```java
System.out.println("""
    Hola, això
    és un text en
    múltiples línies
    """);
```

## Formatar textos

El mètode **.formatted(Object... args)** permet reservar espais en una cadena de text per posar-hi dades de variables. Cal dir de quin tipus són les variables:

- **`%s`**: cadenes de text
- **`%d`**: números enters
- **`%f`**: números decimals
- **`%n`**: fa un salt de linia

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0304.Main
```

```java
package com.exemple0304;

public class Main {
    public static void main(String[] args) {

        String plantilla = """
            Nom: %s
            Edat: %d
            Salari: %.2f€""";

        String resultat = plantilla.formatted("Toni", 30, 1900.5);
        System.out.println(resultat);
    }
}
```

**Nota**: no hi ha manera de posar directament booleans.

## Alinear textos

El mètode **.formatted(Object... args)** també permet alinear textos definint un número de caràcters:

- **`%ns`**: Amplada de n caràcters, alineat a la dreta.
- **`%-ns`**: Amplada de n caràcters, alineat a l'esquerra.

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0305.Main
```

```java
package com.exemple0305;

public class Main {
    public static void main(String[] args) {

        System.out.println("0123456789");

        String alineaDreta = "%8s".formatted("Hola");
        System.out.println(alineaDreta + "|");

        String alineaEsquerra = "%-8s".formatted("Hola");
        System.out.println(alineaEsquerra + "|");
    }
}
```

La sortida és:

```text
0123456789
    Hola|
Hola    |
```