<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Sintaxis JAVA

JAVA, com tots els llenguatges de programació, tenen una manera (sintaxi) pròpia que permet definir programes.

<center><img src="../assets/01sintaxis.png" height="256" alt="Logo de IETI" style="max-height: 256px;"></center>

## Cos del programa

Tots els programes JAVA tenen una estructura bàsica:

```java
package com.project;

public class NomClasse {
    public static void main(String[] args) {
        // Funció principal del programa
    }
}
```

* **com.project**: Els projectes JAVA formen part d'un paquet, que conté les llibrerires. En aquest exemple el paquet es diu 'com.project' però enlloc de 'project' podríem posar el nom que volguéssim (com.minecraft, com.netlibs, ...)

* **NomClasse**: Els arxiu JAVA s'organitzen en objectes, en aquest cas l'objecte s'anomena 'NomClasse'. Als exemples es diu 'Main'. Els objectes es poden dir com vulguem, però el nom de l'arxiu .java ha de coincidir amb el nom de l'objecte. En aquest cas, l'arxiu s'hauria d'anomenar 'NomClasse.java'

* **main**: No tots els objectes tenen aquesta funció, però quan la tenen, aquesta és la funció que s'executa per defecte i reb les opcions de la línia de comandes a través de 'args'

## Comentaris

Els comentaris 'inline' (d'una linia) començen a partir de les dues barres //

Els comentaris 'multiline' (múltiples línies) es posen entre /* (per començar el comentari) i */ (per tancar el comentari)

```java
// Comentari d'una sola línia
/*
    Comentari de
    múltiples línies
*/

## Variables

En JAVA cal declarar les variables i amb la declaració, s'informa del tipus de variable que es tracta.

El tipus no pot canviar durant al programa.

Per declarar les variables: primer cal dir el tipus, després el nom de la variable i finalment s'inicia amb un valor.

```java
    boolean varBoleana = true;
    char nomesUnCaracter = 'a';     // Els caràcters es defineixen entre ' simple
    String cadenaText = "Hola";
    int numeroEnter = 45;           // Dedica 4 bytes de memòria a guardar el número
    long numeroEnterGran = 39832L;  // Dedica 8 bytes de memòria a guardar el número
    float numeroDecimalsPetit = 32.5f;
    double numeroDecimalsGran = 1.79769313486231570e+308d;
```


### Exemple00

```java
public static void main(String[] args) {
    // Definició de variables
    boolean varBoleana = true;
    char nomesUnCaracter = 'a';
    String cadenaText = "Hola";
    int numeroEnter = 45;
    long numeroEnterGran = 39832L;
    float numeroDecimalsPetit = (float) 32.5;
    double numeroDecimalsGran = 1.79769313486231570e+308d;

    // Capçaleres de columnes
    System.out.printf("%-10s %-20s %-30s %n", "Tipus", "Nom", "Valor");
    System.out.println("---------------------------------------------------------------");
    
    // Imprimir informació de cada variable amb amplades fixes
    System.out.printf("%-10s %-20s %-30s %n", "boolean", "varBoleana", varBoleana);
    System.out.printf("%-10s %-20s %-30c %n", "char", "nomesUnCaracter", nomesUnCaracter);
    System.out.printf("%-10s %-20s %-30s %n", "String", "cadenaText", cadenaText);
    System.out.printf("%-10s %-20s %-30d %n", "int", "numeroEnter", numeroEnter);
    System.out.printf("%-10s %-20s %-30d %n", "long", "numeroEnterGran", numeroEnterGran);
    System.out.printf("%-10s %-20s %-30f %n", "float", "numeroDecimalsPetit", numeroDecimalsPetit);
    System.out.printf("%-10s %-20s %-30e %n", "double", "numeroDecimalsGran", numeroDecimalsGran);
}
```

## Operacions matemàtiques

En JAVA les operacions matemàtiques són molt semblants a Python.

```java
int sum = 2 + 3;
```

Els operadors += i -= incrementen i decrementen el valor d'una variable

```java
int a = 3;
a += 5; // Ara el valor de 'a' serà 5 + 3, 8
a -= 2; // Ara el valor de 'a' serà 8 - 2, 6
```

L'ordre de les operacions és:

- Parèntesis
- Exponents
- Multiplicació i Divisió (evaluades de dreta a esquerra)
- Mòdul
- Suma i Resta (evaluades de dreta a esquerra)

```java
int b = (2 + 3) * 4;
    // 2 + 3 = 6
    // 6 * 4 = 24
double c = Math.pow(2, 2) + Math.pow(4, 2);
    // Math.pow permet fer l'elevació, exemple 4 elevat a 2
    // 2 elevat a 2 = 4
    // 4 elevat a 2 = 16
    // 4 + 16 = 20
int d = 10 * 2 / 5;
    // 10 * 2 = 20
    // 20 / 5 = 4
int e = 10 % 3 % 2;
    // El residu de dividir 10 entre 3 = 1
    // El residu de dividir 1 entre 2 = 1
int f = 10 + 2 - 5;
    // 10 + 2 = 12
    // 12 - 5 = 7
```

### Exemple01

```java
public static void main(String[] args) {

    int sum = 2 + 3;
    System.out.println("sum = " + sum);

    int a = 3;
    a += 5; // Ara el valor de 'a' serà 5 + 3, 8
    a -= 2; // Ara el valor de 'a' serà 8 - 2, 6
    System.out.println("a = " + a);

    int b = (2 + 3) * 4;
    System.out.println("b = " + b);

    double c = Math.pow(2, 2) + Math.pow(4, 2);
    System.out.println("c = " + c);

    int d = 10 * 2 / 5;
    System.out.println("d = " + d);

    int e = 10 % 3 % 2;
    System.out.println("e = " + e);

    int f = 10 + 2 - 5;
    System.out.println("f = " + f);
}
```

## Operacions de text

JAVA té moltes funcions i objectes per manipular cadenes de text.

### Exemple02

```java
public class Main {
    public static void main(String[] args) {
        // Cadena inicial
        String text = "Hola Món, Món és un lloc bonic.";
        
        // Longitud
        int longitud = text.length();
        System.out.println("Longitud: " + longitud);
        
        // Concatenació
        String salutacio = text + " Des de Java!";
        System.out.println("Concatenació: " + salutacio);
        
        // Indexació
        char lletra = text.charAt(0);
        System.out.println("Caràcter en índex 0: " + lletra);
        
        // Subcadena
        String subcadena = text.substring(0, 4);
        System.out.println("Subcadena: " + subcadena);
        
        // Repetició
        String repetit = "ha".repeat(3);
        System.out.println("Repetició: " + repetit);
        
        // Conversió
        String majuscules = text.toUpperCase();
        System.out.println("A majúscules: " + majuscules);
        
        // Ordenar
        char[] lletres = text.toCharArray();
        java.util.Arrays.sort(lletres);
        String ordenat = new String(lletres);
        System.out.println("Ordenat: " + ordenat);
        
        // Substitució
        String substituit = text.replace("Món", "Java");
        System.out.println("Substitució: " + substituit);
        
        // Cerca
        int index = text.indexOf("Món");
        System.out.println("Índex de 'Món': " + index);
        
        // Invertir
        String invertit = new StringBuilder(text).reverse().toString();
        System.out.println("Invertit: " + invertit);
        
        // Canviar totes les aparicions d'una paraula
        String canviParaula = text.replace("Món", "Terra");
        System.out.println("Canvi de paraules: " + canviParaula);
    }
}
```

## Random, números aleatòris

JAVA té la funció 'random()' de l'objecte Math, que ens dóna números aleatòris entre 0 (inclòs) i 1  (no inclòs)

### Exemple03

```java
public static void main(String[] args) {

    // Generació de nombres aleatoris
    double aleatori = Math.random(); // Genera un número aleatori entre 0.0 i 1.0 (no inclòs)
    
    // Genera un número aleatori entre 0 i 100 tots dos inclosos
    int aleatoriEntre0i100 = (int) (Math.random() * 101); // Cal transformar-lo a enter amb (int)
    
    // Imprimir resultats
    System.out.println("Número aleatori entre 0.0 i 1.0: " + aleatori);
    System.out.println("Número aleatori entre 0 i 100: " + aleatoriEntre0i100);
}
```

## Funcions

En JAVA les funcions pertànyen a objectes, però encara no sabem què són els objectes.

En el nostre exemple l'objecte és 'Main' i la funció principal d'aquest objecte es diu 'main'

Però podem afegir tantes funcions a l'objecte com ens calgui.

Fixeu-vos que amb el pas de paràmtres, cal indicar el tipus al que pertany cada paràmetre.

Igualment cal indicar què retorna la funció, es fa amb el tipus abans del nom de la funció.

En cas que no retorni res, indiquem que el tipus és **void**

### Exemple04

```java
public class Main {
    
    public static void main(String[] args) {
        // Cridar la funció que imprimeix "Hello, World!"
        imprimirSalutacio();

        // Cridar la funció que realitza una suma i imprimir el resultat
        int suma = sumar(5, 7);
        System.out.println("La suma de 5 i 7 és: " + suma);
    }

    // Funció sense paràmetres que imprimeix "Hello, World!" i no retorna res (void)
    public static void imprimirSalutacio() {
        System.out.println("Hello, World!");
    }

    // Funció amb paràmetres que realitza una suma i retorna un 'int' com a resultat
    public static int sumar(int num1, int num2) {
        return num1 + num2;
    }
}
```

## Control de fluxe, if/else

En JAVA el funcionament de 'if' i 'else' és molt semblant a Python, però cal tenir en compte que:

- Si hi ha multiples línies afectades per la condició, es posen totes entre { i }

- Si només hi ha una linia implicada a la condició opcionalment es pot posar al costat de la condició sense claus

**Nota:** Per netedat, us recomano fer servir claus, també per si en un futur cal afegir línies de codi a la condició

### Exemple05

En aquest exemple, fixeu-vos com fa servir l'objecte 'Scanner' per demanar informació a l'usuari. 

I com al final del programa, l'ha de tancar per deixar d'escoltar els events.

```java
package com.project;

public class Main {
    public static void main(String[] args) {
   
        // Posar aquí una edat, per exemple 10, 25 o 81
        int edat = 25;

        // Comprovar si la persona pot conduir basant-se en la seva edat
        if (edat >= 18 && edat <= 80) {
            System.out.println("Pots conduir.");
        } else if (edat > 80) {
            System.out.println("No pots conduir per raons de seguretat.");
        } else {
            System.out.println("No pots conduir perquè no tens l'edat suficient.");
        }
    }
}

```

## Control de fluxe, while i for

JAVA és una eina molt potent per programar, i això implica menys flexibilitat amb la sintaxi.

El bucle 'for' té 3 paràmetres:

- El comptador inicial de la variable que compte en quina posició del bucle ens trobem

- La condició de sortida, és a dir la condició que mentre es compleix executem el codi del bucle

- La operació que apliquem al contador, a cada iteració del bucle (a l'exemple sumem un 1 a i a cada iteració)

### Exemple06

Aquest exemple mostra la sintaxis bàsica de com fer bucles while i for.

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        // Cridar la funció que utilitza un bucle while
        int limit = 4;
        System.out.println("Comptar fins a " + limit + " amb un bucle while:");
        comptarAmbWhile(limit);
        
        // Cridar la funció que utilitza un bucle for
        int inici = 2;
        int fi = 6;
        System.out.println("Imprimir números parells entre " + inici + " i " + fi + " amb un bucle for:");
        imprimirParellsAmbFor(inici, fi);
    }

    // Funció que utilitza un bucle while per comptar fins a un número donat
    public static void comptarAmbWhile(int limit) {
        int i = 1; // Començar a comptar des de 1
        while (i <= limit) {
            System.out.println(i);
            i++; // Incrementar el contador
        }
    }

    // Funció que utilitza un bucle for per imprimir tots els números parells dins d'un rang específic
    public static void imprimirParellsAmbFor(int inici, int fi) {
        for (int i = inici; i <= fi; i++) {
            if (i % 2 == 0) { // Comprovar si el número és parell
                System.out.println(i);
            }
        }
    }
}

```

## Control de fluxe, do while

JAVA té un altre tipus de bucle anomenat 'do while', en aquesta estructura la condició de sortida es posa al final, el què implica que el codi s'executa abans de comprovar la condició.

Perquè s'entengui:

<center><img src="../assets/01doWhile.png" height="256" alt="Logo de IETI" style="max-height: 256px;"></center>

### Exemple07

```java
package com.project;

public class Main {
    public static void main(String[] args) {
        int contador = 1; // Iniciar el comptador

        do {
            System.out.println(contador); // Dibuixar el valor del comptador
            contador++; 
        } while (contador <= 5); 
    }
}

```

## Llistes

JAVA facilita el treball amb llistes a través de l'objecte 'ArrayList'.

Les llistes només poden contenir un mateix tipus de dades, i per aquest motiu el tipus s'indica entre < i > al definir la variable de la llista.

### Exemple08

```java
package com.project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        // EXEMPLE AMB ARRAYS

        // Array numèric
        Integer[] arrayNumeric = new Integer[]{5, 10, 15, 20, 25, 30, 35, 40};

        // Modificar un element d'un array
        arrayNumeric[2] = 100; // Canvia el valor de l'element a la posició 2 per 100
        System.out.println("Array amb element modificat: " + Arrays.toString(arrayNumeric));

        // Longitud de l'array
        System.out.println("Longitud de l'array numèric: " + arrayNumeric.length);

        // Obtenir subarray (això no es pot fer directament com amb subList, cal copiar)
        Integer[] subArrayNumeric = Arrays.copyOfRange(arrayNumeric, 2, 5);
        System.out.println("Subarray numèric: " + Arrays.toString(subArrayNumeric));

        // No es pot "eliminar" elements d'un array directament. Cal crear un nou array sense els elements desitjats.
        // Per aquest exemple, simplificarem el procés i no eliminarem elements per aquest mètode.

        // Dividir en dos
        Integer[] primeraMeitatX = Arrays.copyOfRange(arrayNumeric, 0, arrayNumeric.length / 2);
        Integer[] segonaMeitatX = Arrays.copyOfRange(arrayNumeric, arrayNumeric.length / 2, arrayNumeric.length);
        System.out.println("Primera meitat: " + Arrays.toString(primeraMeitatX));
        System.out.println("Segona meitat: " + Arrays.toString(segonaMeitatX));

        // Afegir elements a un array requereix crear un nou array i copiar els elements existents.
        // Per simplificar, no demostrarem aquesta part aquí.

        // Buscar el màxim número en un array
        Integer maxim = Arrays.stream(arrayNumeric).max(Integer::compare).orElse(null);
        System.out.println("Màxim número: " + maxim);

        // Ordenar l'array
        Arrays.sort(arrayNumeric);
        System.out.println("Array ordenat: " + Arrays.toString(arrayNumeric));

        // Buscar un element en un array
        boolean existeix = Arrays.asList(arrayNumeric).contains(15);
        System.out.println("L'array conté el número 15? " + existeix);

        // Agafar elements de manera aleatòria
        Random rand = new Random();
        Integer elementAleatori = arrayNumeric[rand.nextInt(arrayNumeric.length)];
        System.out.println("Element aleatori de l'array numèric: " + elementAleatori);

        // Array de text
        String[] arrayText = new String[]{"Poma", "Plàtan", "Taronja", "Pinya"};

        // Afegir i treure elements d'un array de text no és directe com amb ArrayList.
        // Ordenar l'array de text
        Arrays.sort(arrayText);
        String fruitaAleatoria = arrayText[rand.nextInt(arrayText.length)]; // Aleatori
        System.out.println("Array de text ordenat: " + Arrays.toString(arrayText));
        System.out.println("Fruita aleatòria de l'array de text: " + fruitaAleatoria);

        // EXEMPLE AMB LLISTES

        // Llista numèrica
        List<Integer> llistaNumericaX = new ArrayList<>(Arrays.asList(5, 10, 15, 20, 25, 30, 35, 40));

        // Modificar un element d'una llista
        llistaNumericaX.set(2, 100); // Canvia el valor de l'element a la posició 2 per 100
        System.out.println("Llista amb element modificat: " + llistaNumericaX);

        // Longitud de la llista
        System.out.println("Longitud de la llista numèrica: " + llistaNumericaX.size());

        // Obtenir subllista
        List<Integer> subllistaNumerica = llistaNumericaX.subList(2, 5);
        System.out.println("Subllista numèrica: " + subllistaNumerica);

        // Escurçar la llista (eliminar elements)
        llistaNumericaX.removeIf(n -> (n > 20)); // Elimina tots els elements majors que 20
        System.out.println("Llista escurçada: " + llistaNumericaX);

        // Dividir en dos (exemple simplificat)
        List<Integer> primeraMeitat = new ArrayList<>(llistaNumericaX.subList(0, llistaNumericaX.size()/2));
        List<Integer> segonaMeitat = new ArrayList<>(llistaNumericaX.subList(llistaNumericaX.size()/2, llistaNumericaX.size()));
        System.out.println("Primera meitat: " + primeraMeitat);
        System.out.println("Segona meitat: " + segonaMeitat);

        // Ajuntar múltiples llistes
        List<Integer> novaLlista = new ArrayList<>(primeraMeitat);
        novaLlista.addAll(segonaMeitat);
        System.out.println("Llista ajuntada: " + novaLlista);

        // Buscar el màxim número en una llista
        Integer maximX = Collections.max(llistaNumericaX);
        System.out.println("Màxim número: " + maximX);

        // Ordenar la llista
        Collections.sort(llistaNumericaX);
        System.out.println("Llista ordenada: " + llistaNumericaX);

        // Afegir i treure elements d'una llista
        llistaNumericaX.add(50); // Afegir al final
        llistaNumericaX.remove(Integer.valueOf(10)); // Treure un element específic
        System.out.println("Llista modificada: " + llistaNumericaX);

        // Buscar un element en una llista
        boolean existeixX = llistaNumericaX.contains(15);
        System.out.println("La llista conté el número 15? " + existeixX);

        // Agafar elements de manera aleatòria
        Integer elementAleatoriX = llistaNumericaX.get(rand.nextInt(llistaNumericaX.size()));
        System.out.println("Element aleatori de la llista numèrica: " + elementAleatoriX);

        // Llista de text
        List<String> llistaTextX = new ArrayList<>(Arrays.asList("Cotxe", "Moto", "Carretó", "Avió"));

        // Operacions similars amb llista de text
        llistaTextX.add("Vaixell"); // Afegir
        llistaTextX.remove("Carretó"); // Treure
        Collections.sort(llistaTextX); // Ordenar
        String fruitaAleatoriaX = llistaTextX.get(rand.nextInt(llistaTextX.size())); // Aleatori
        System.out.println("Llista de text ordenada i modificada: " + llistaTextX);
        System.out.println("Fruita aleatòria de la llista de text: " + fruitaAleatoriaX);
    }
}
```

## Diccionaris

JAVA facilita el treball amb diccionaris a través de l'objecte 'HashMap'.

No és tant immediat ni intuitiu com amb Python, sobretot perquè no pot transformar objectes JSON a HashMap sense llibreries de tercers.

Fixeu-vos que al declarar el 'HashMap' no només posem el tipus de dades que conté, sinó també el tipus de les claus. Així:

```java
Map<int, String> // Les claus només poden ser de tipus 'int' i els valors de tipus 'String'
Map<double, int> // Les claus només poden ser de tipus 'double' i els valors de tipus 'int'
```

Lo més habitual és tenir claus que són cadenes de text, i guarden informació bé sigui numèrica o també de text:

```java
Map<String, int> // Les claus són cadenes de text que guarden informació d'enters
Map<String, double> // Les claus són cadenes de text que guarden informació de decimals
Map<String, String> // Les claus són cadenes de text que guarden altres cadenes de text
```

### Exemple09

```java
package com.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Crear un HashMap
        Map<String, String> diccionari = new HashMap<>();
        diccionari.put("clau1", "valor1");
        diccionari.put("clau2", "valor2");

        // Modificar el valor d'una clau
        diccionari.put("clau1", "valorModificat");

        // Obtenir el valor d'una clau
        String valor = diccionari.get("clau1");
        System.out.println("Valor de 'clau1': " + valor);

        // Afegir i treure elements d'un diccionari
        diccionari.put("clau3", "valor3"); // Afegir
        diccionari.remove("clau2"); // Treure

        // Un diccionari que conté altres elements tipus diccionari
        Map<String, Map<String, String>> diccionariNinot = new HashMap<>();
        diccionariNinot.put("subDiccionari", diccionari);

        // Copiar completament diccionaris a una nova variable
        Map<String, String> diccionariCopia = new HashMap<>(diccionari);

        // Mirar el nombre d'elements d'un diccionari
        System.out.println("Nombre d'elements: " + diccionari.size());

        // Obtenir una llista amb les claus
        Set<String> claus = diccionari.keySet();
        System.out.println("Claus: " + claus);

        // Obtenir una llista amb els valors
        List<String> valors = new ArrayList<>(diccionari.values());
        System.out.println("Valors: " + valors);

        // Buscar una clau a partir d'un valor
        String clauBuscada = diccionari.entrySet().stream()
            .filter(entry -> "valorModificat".equals(entry.getValue()))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);
        System.out.println("Clau que té com a valor 'valorModificat': " + clauBuscada);

        // Obtenir una llista amb totes les claus que compleixen una condició
        List<String> clausAmbValor3 = diccionari.entrySet().stream()
            .filter(entry -> entry.getValue().contains("3"))
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());
        System.out.println("Claus amb valors que contenen '3': " + clausAmbValor3);
    }
}


```

## Excepcions try/catch/finally

Per controlar excepcions en JAVA fem servir estructures try/catch/finally

- El codi que hi ha dins del 'try' és el que pot produir excepcions.

- Per vigilar si es produeixen excepcions específices fem servir 'catch' i el tipus d'excepció que volem controlar

- La excepció tipus 'Exception' és genèrica i capturarà qualsevol tipus d'excepció no controlada

- **finally** és un troç de codi que s'executa sempre tant si hi ha hagut excepció com si no

La informació d'errors de cada excepció està disponible al paràmetre d'aquesta, a l'exemple els paràmetres 'e'

### Exemple10


```java
package com.project;

public class Main {
    public static void main(String[] args) {
        try {
            // Intenta executar aquest codi que pot generar una excepció
            int resultat = divideix(10, 0); // Això generarà una ArithmeticException
            System.out.println("Resultat: " + resultat);
        } catch (ArithmeticException e) {
            // Aquest bloc captura només ArithmeticException
            System.out.println("S'ha capturat una ArithmeticException: " + e.getMessage());
        } catch (Exception e) {
            // Aquest bloc captura qualsevol altra Exception
            System.out.println("S'ha capturat una excepció genèrica: " + e.getMessage());
        } finally {
            // Aquest bloc s'executa sempre
            System.out.println("Bloc finally s'executa sempre, independentment de si es captura una excepció o no.");
        }
    }

    public static int divideix(int numerador, int denominador) {
        return numerador / denominador; // Aquesta línia pot generar una ArithmeticException si denominador és 0
    }
}
```

## Llançar excepcions, throw

Si en canvi el què volem és llançar una excepció, farem servir **throw**

### Exemple11


```java
package com.project;

public class Main {
    public static void main(String[] args) {
        try {
            // Comprova alguna condició i llança una excepció si es compleix
            int edat = -1; // Suposem que aquest valor s'ha obtingut d'algun lloc
            if (edat < 0) {
                throw new IllegalArgumentException("L'edat no pot ser negativa");
            }
        } catch (IllegalArgumentException e) {
            // Captura l'excepció específica llançada anteriorment
            System.out.println("S'ha capturat una excepció: " + e.getMessage());
        }
    }
}
```

## Entrada de dades per consola

JAVA té l'objecte 'Scanner' que ens permet llegir les dades que escriu l'usuari al terminal.

Cada vegada que volem llegir una linia de text escrita per l'usuari hem de fer:

```java
String input = scanner.nextLine();
```

Al final del programa, no ens podem oblidar de tancar l'objecte Scanner adequadament:

```java
scanner.close()
```

### Exemple12


```java
package com.project;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double suma = 0.0;
        System.out.println("Introdueix un número (decimals amb .) o escriu 'sortir' per acabar:");

        while (true) {
            System.out.print("La suma actual és " + suma + "\nIntrodueix un número o 'sortir': ");
            String input = scanner.nextLine();

            if ("sortir".equalsIgnoreCase(input)) {
                System.out.println("Finalitzant l'aplicació. La suma final és " + suma);
                break;
            }

            try {
                double numero = Double.parseDouble(input);
                suma += numero;
                clearScreen();
            } catch (NumberFormatException e) {
                System.out.println("Error, cal escriure un número o 'sortir'");
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        scanner.close();
    }

    public static void clearScreen() {
        try {
            String sistemaOperatiu = System.getProperty("os.name");

            if (sistemaOperatiu.contains("Windows")) {
                // Comanda per a Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Comanda per a Unix/Linux/Mac
                // Aquesta línia pot no netejar la pantalla en alguns terminals o IDEs
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("No es pot netejar la pantalla: " + e.getMessage());
        }
    }
}

```

## Lectura d'arxius JSON

Els arxius JSON cal llegir-los amb la llibreria 'org.json'

- Si a l'arxiu hi ha com a arrel un array amb: **org.json.JSONArray**

- Si a l'arxiu hi ha com a arrel un objecte amb: **oorg.json.JSONObject**

Un cop s'ha carregat la informació de l'arxiu .JSON en aquest tipus d'objecte, es pot accedir a les variables amb:

```java
curs.getInt("id")
```

### Exemple13


```java
package com.project;

import java.io.*;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.IOException;

public class Main {
   public static void main(String[] args) {

        // Els arxius de la carpeta './src/main/resources/assets' s'empaqueten amb el projecte
        // String arxiu = "/assets/cursos.json"; 

        // Els arxius de la carpate './data' són arxius normals del sistema que no s'empaqueten
        String arxiu = "./data/cursos.json"; 
   
        try {

            // Preparar l'stream de lectura
            InputStream is;
            if (arxiu.startsWith("/assets")) {
                is = Main.class.getResourceAsStream(arxiu);
                if (is == null) {
                    throw new FileNotFoundException("El fitxer no s'ha trobat dins del JAR: " + arxiu);
                }
            } else {
                File file = new File(arxiu);
                if (!file.exists()) {
                    throw new FileNotFoundException("El fitxer no s'ha trobat en el sistema de fitxers");
                }
                is = new FileInputStream(file);
            }
            Reader reader = new InputStreamReader(is);

            // Llegir el contingut del fitxer com a String
            StringBuilder contentBuilder = new StringBuilder();
            try (BufferedReader bufferedReader = new BufferedReader(reader)) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    // Afegeix un salt de línia per mantenir el format
                    contentBuilder.append(line).append("\n"); 
                }
            } catch (IOException e) {
                e.printStackTrace();
                // Maneja l'error com consideris necessari
            }
            String content = contentBuilder.toString();

            // Crear un JSONArray a partir del contingut del fitxer
            JSONArray cursos = new JSONArray(content);

            // Iterar sobre els elements de l'JSONArray
            for (int i = 0; i < cursos.length(); i++) {
                JSONObject curs = cursos.getJSONObject(i);
                System.out.println("ID: " + curs.getInt("id") + ", Nom: " + curs.getString("nom"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## Escriptura d'arxius JSON

**Nota:** Tingues en compte que no pots modificar la carpeta d'arxius adjunts 'assets' però si guardar informació als arxius del sistema.

Els arxius JSON també cal escriure'ls amb la llibreria 'org.json'

### Exemple14


```java
package com.project;

import java.io.*;
import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
   public static void main(String[] args) {

        // Els arxius de la carpeta './src/main/resources/assets' s'empaqueten amb el projecte
        // String arxiu = "/assets/cursos.json"; 

        // Els arxius de la carpeta './data' són arxius normals del sistema que no s'empaqueten
        String arxiuOriginal = "./data/cursos.json"; 
        String arxiuModificat = "./data/cursos-modificat.json"; // Ruta per al nou fitxer JSON modificat
   
        try {
            // Llegir el contingut del fitxer original
            String content = new String(Files.readAllBytes(Paths.get(arxiuOriginal)));
            JSONArray cursos = new JSONArray(content);

            // Modificar cada objecte dins del JSONArray
            for (int i = 0; i < cursos.length(); i++) {
                JSONObject curs = cursos.getJSONObject(i);
                int idOriginal = curs.getInt("id");
                curs.put("id", idOriginal + 1000); // Sumar 1000 a l'id actual
            }

            // Guardar el JSONArray modificat en un nou fitxer
            try (FileWriter file = new FileWriter(arxiuModificat)) {
                file.write(cursos.toString(4)); // Escriure el JSON amb indentació per millorar la llegibilitat
                System.out.println("Arxiu JSON modificat guardat a: " + arxiuModificat);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

