<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Variables

<center>
<img src="./assets/01variables.png" height="128" style="max-height: 128px;"/>
</center>

Les variables són com **caixes** on podem guardar informació per fer-la servir més endavant. Cada variable té:

- Un **nom** (etiqueta que la identifica) 
- Un **valor** (la informació que hi posem a dins)

El següent exemple assigna el nom d'un mes a la variable 'mes' i després li canvia el valor:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0100.Main
```

```java
package com.exemple0100;

public class Main {
    public static void main(String[] args) {

        String mes = "Gener";
        System.out.println("Contingut de 'mes': " + mes);

        mes = "Febrer";
        System.out.println("Contingut de 'mes': " + mes);

        mes = "Març";
        System.out.println("Contingut de 'mes': " + mes);
    }
}
```

Sortida de l'exemple:
```text
Contingut de 'mes': Gener
Contingut de 'mes': Febrer
Contingut de 'mes': Març
```

### Exercici 0100

Modifica el codi de:

```bash
src/main/exercici0100/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0100.Main
```

Faci els següents passos:

- Guardi la paraula **"Dilluns"** en una variable **"nomDia"**
- Mostri el valor de la variable **"nomDia"** per pantalla
- Vagi modificant i mostrant el seu valor amb tots els dies de la setmana

La sortida ha de ser:

```text
Contingut de 'nomDia': Dilluns
Contingut de 'nomDia': Dimarts
Contingut de 'nomDia': Dimecres
Contingut de 'nomDia': Dijous
Contingut de 'nomDia': Divendres
```

## Entrada de text

A **Java** quan volem agafar informació a través del teclat, necessitem la llibreria **"Scanner"**.

Per carregar aquesta llibreria fem un **import**

```java
import java.util.Scanner;
```

Un cop hem carregat la llibreria ja es pot fer servir.

- Al inici del programa iniciarem un **scanner**
```java
Scanner scanner = new Scanner(System.in);
```

- Quan volem llegir la informació que escriu l'usuari per teclat fem:
```java
String informacio = scanner.nextLine();
```

- Quan acaba el programa **tanquem l'scanner**:
```java
scanner.close();
```

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0101.Main
```

```java
package com.exemple0101;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Iniciar la capacitat de 
        // llegir informació del teclat
        Scanner scanner = new Scanner(System.in);

        // Llegir informació del teclat
        // i guardar-la en una variable 'nom'
        System.out.print("Escriu el teu nom: ");
        String nom = scanner.nextLine();

        System.out.println("Hola, " + nom + "!");
        
        // Tancar la lectura del teclat
        scanner.close();
    }
}
```

## Tipus de variables

En **Java** però, cal indicar quin tipus d'informació guardarem a les variables:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0102.Main
```

```java
package com.exemple0102;

public class Main {
    public static void main(String[] args) {
        // Boolean: només pot ser "true" o "false"
        boolean esDilluns = true;
        System.out.println("Boolean: " + esDilluns);
        
        // Char: Guarda un sol caràcter 
        // (lletra, número o símbol).
        char lletra = 'a';
        System.out.println("Char: " + lletra);
        
        // String: Guarda una cadena de text
        // (més d'un caràcter).
        String text = "Hola";
        System.out.println("String: " + text);
        
        // Int: Guarda números enters.
        int numero = 45;
        System.out.println("Int: " + numero);
        
        // Float: Guarda números decimals
        float preu = 32.5f;
        System.out.println("Float: " + preu);
    }
}
```

Sortida de l'exemple:
```text
Boolean: true
Char: a
String: Hola
Int: 45
Float: 32.5
```

## Canvi de tipus

A vegades necessitem canviar el tipus d'una variable, per exemple:

- Quan algú escriu al teclat, rebem un text **"String"**
- Si el què escriu és un número l'hem de passar a **"int"** o **"float"**

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0103.Main
```

```java
package com.exemple0103;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Iniciar la capacitat de llegir informació del teclat
        Scanner scanner = new Scanner(System.in);

        // Demanar l'edat com un String
        System.out.print("Escriu la teva edat: ");
        String edatString = scanner.nextLine();

        // Convertir el String a un enter
        int edat = Integer.parseInt(edatString);

        // Mostrar el resultat
        System.out.println("Hola, " + nom + "! Tens " + edat + " anys.");

        // Tancar la lectura del teclat
        scanner.close();
    }
}
```

### Exercici 0101

Modifica el codi de:

```bash
src/main/exercici0101/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0101.Main
```

Demani la teva edati calculi l'edat entrada *7

La sortida ha de ser:

```text
Escriu la teva edat: 10
La teva edat en anys de gos són 70 anys.
```

### Exercici 0102

Modifica el codi de:

```bash
src/main/exercici0102/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0102.Main
```

Demani un número i calculi *el doble*, *el triple*, *la meitat*

La sortida ha de ser:

```text
Escriu un nombre: 50
El doble és: 100
El triple és: 150
La meitat és: 25.0
```

### Exercici 0103

Modifica el codi de:

```bash
src/main/exercici0103/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0103.Main
```

Demani un país, una ciutat i un número d'habitants.

La sortida ha de ser:

```text
Escriu el nom d'un país: Espanya
Escriu el nom d'una ciutat: La Corunya
Escriu el número d'habitants: 247.376
"La Corunya" és una ciutat situada a "Espanya" amb 247.376 habitants.
```

**Nota**: Recorda que dins d'una cadena de text, pots posar el caràcter `"` amb `\"`

### Exemples de transformació entre tipus

```bash
./run.sh com.exemple0104.Main
```

```java
package com.exemple0104;

public class Main {

    public static void main(String[] args) {
        // Exemples de transformació des d'un String:
        String textNumero = "123";
        int numeroInt = Integer.parseInt(textNumero); // String a int
        float numeroFloat = Float.parseFloat(textNumero); // String a float
        System.out.println("String a Int: " + numeroInt);
        System.out.println("String a Float: " + numeroFloat);

        // Exemples de transformació des d'un Int:
        int numero = 45;
        float numeroFloat2 = numero; // Int a float (promoció automàtica)
        String numeroString = Integer.toString(numero); // Int a String
        System.out.println("Int a Float: " + numeroFloat2);
        System.out.println("Int a String: " + numeroString);

        // Exemples de transformació des d'un Float:
        float preu = 32.5f;
        int preuInt = (int) preu; // Float a Int (càsting explícit, truncament)
        String preuString = Float.toString(preu); // Float a String
        System.out.println("Float a Int: " + preuInt);
        System.out.println("Float a String: " + preuString);

        // Exemples de transformació des d'un Char:
        char caracter = '7';
        int caracterInt = Character.getNumericValue(caracter); // Char a Int (si és un dígit)
        String caracterString = Character.toString(caracter); // Char a String
        System.out.println("Char a Int: " + caracterInt);
        System.out.println("Char a String: " + caracterString);
    }
}
```

### Exercici 0104

Modifica el codi de:

```bash
src/main/exercici0104/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0104.Main
```

Faci els següents passos:

- Demani un float a l'usuari, per exemple: *"45.78f"*.
- Converteixi el float a "int" anomenat **"valor0"**
- Converteixi l'enter a "String"
- Demani un sol caràcter numèric a l'usuari, per exemple: '9'
- El transformi a tipus "char" anomenat **"caracter"**
- Transformi el "char" anterior a "int" i l'anomeni **valor1**
- Sumi **"valor0"** i **"valor1** i mostri el resultat

La sortida ha de ser:

```text
Escriu un número decimal: 45.78
Float convertit a Int (valor0): 45
Int convertit a String: "45"
Escriu un sol caràcter numèric: 9
Caràcter llegit: '9'
Char convertit a Int: 9
La suma de valor0 i valor1 és: 54
```