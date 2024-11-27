<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Condicions

Les condicions permeten decidir si un troç de codi s'executa en funció d'una condició.

## If/else

Un **if** comprova si una condició és certa o no. 

- Si és certa, s'executa el codi dins del bloc if. 
- Si no és certa, el programa pot passar al següent bloc opcional
- El bloc sense condició **else** s'executa quan la condició inicial és falsa

```java
if (numero > 0) {
    System.out.println("El número és positiu.");
} else if (numero < 0) {
    System.out.println("El número és negatiu.");
} else {
    System.out.println("El número és igual a zero.");
}
```

### Exercici 0300

Modifica el codi de:

```bash
src/main/exercici0300/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0300.Main
```

Demani els valors numèrics de 'a' i 'b', i faci l'algorisme del següent diagrama:

<center>
<img src="./assets/03condicions0.png" style="max-height: 450px;"/>
</center>

### Exercici 0301

Modifica el codi de:

```bash
src/main/exercici0301/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0301.Main
```

Demani el valor numèric de 'n' i faci l'algorisme del següent diagrama:

<center>
<img src="./assets/03condicions1.png" style="max-height: 450px;"/>
</center>

### Exercici 0302

Modifica el codi de:

```bash
src/main/exercici0302/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0302.Main
```

Demani els valors de 'a', 'b', 'c' i faci l'algorisme del següent diagrama:

<center>
<img src="./assets/03condicions2.png" style="max-height: 450px;"/>
</center>

### Exercici 0303

Modifica el codi de:

```bash
src/main/exercici0303/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0303.Main
```

Demani el valor numèric de 'n' i faci l'algorisme del següent diagrama:

<center>
<img src="./assets/03condicions2.png" style="max-height: 450px;"/>
</center>

## Operador ternari

L'**operador ternari** és un tipus de condició similar a **if/else** però que s'escriu en una sola linia amb aquesta estructura:

```text
condició ? valorSiCert : valorSiFals;
````

Això permet estalviar codi per condicions senzilles.

Exemple:

```java
int edat = 20;
String resultat = (edat >= 18) ? "Major d'edat" : "Menor d'edat";
System.out.println(resultat);
```

### Exemple 0300

Fes anar aquest exemple amb:

```bash
./run.sh com.exemple0300.Main
```

```java
package com.exemple0300;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Demanar tres números a l'usuari
        System.out.print("Escriu el primer número: ");
        int num1 = scanner.nextInt();

        System.out.print("Escriu el segon número: ");
        int num2 = scanner.nextInt();

        System.out.print("Escriu el tercer número: ");
        int num3 = scanner.nextInt();

        // Determinar el més gran amb operadors ternaris
        int max = (num1 > num2) ? 
                     ((num1 > num3) ? num1 : num3) : 
                     ((num2 > num3) ? num2 : num3);

        // Mostrar el resultat
        System.out.println("El número més gran és: " + max);

        scanner.close();
    }
}
```

### Exercici 0304

Modifica el codi de:

```bash
src/main/exercici0304/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0304.Main
```

Retorni el número més petit fent servir **l'operador ternari**

```text
Escriu el primer número: 4
Escriu el segon número: 1
Escriu el tercer número: 2
El número més petit és: 1
```

## Switch

L'estructura **switch** és una eina que permet prendre decisions basades en el valor d'una variable o expressió. 

És útil quan hi ha múltiples opcions possibles, perquè fa el codi més net i llegible:

Les parts de l'estructura **switch** són:

- **expressió**: Pot ser un valor enter, caràcter (char), String, o un enum.
- **case**: Defineix un valor específic a comparar amb l'expressió.
- **break**: Surt del switch després d'executar el codi d'un cas 
- **default**: Opcional, s'executa si cap cas coincideix.

```java
switch (expressió) {
    case valor1:
        // Codi a executar si expressió == valor1
        break;
    case valor2:
        // Codi a executar si expressió == valor2
        break;
    default:
        // Codi a executar si cap cas coincideix
        break;
}
```

**Important**: En **Java** si no es posa **break**, el programa continuarà pel següent **case** com si el valor també coincidís.

### Exemple 0301

Fes anar aquest exemple amb:

```bash
./run.sh com.exemple0301.Main
```

```java
package com.exemple0301;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Demanar el número del dia a l'usuari
        System.out.print("Escriu un número del 1 al 7 per representar un dia de la setmana: ");
        int dia = scanner.nextInt();

        // Determinar el dia de la setmana amb un switch
        switch (dia) {
            case 1:
                System.out.println("Dilluns");
                break;
            case 2:
                System.out.println("Dimarts");
                break;
            case 3:
                System.out.println("Dimecres");
                break;
            case 4:
                System.out.println("Dijous");
                break;
            case 5:
                System.out.println("Divendres");
                break;
            case 6:
            case 7:
                System.out.println("Cap de setmana");
                break;
            default:
                System.out.println("Número no vàlid. Has d'escriure un valor entre 1 i 7.");
                break;
        }

        scanner.close();
    }
}
```

### Exercici 0305

Modifica el codi de:

```bash
src/main/exercici0305/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0305.Main
```

Demani un mes de l'any i retorni el seu número.

```text
Escri un mes de l'any: Febrer
"Febrer" és el mes número 2
```

### Exercici 0306

Modifica el codi de:

```bash
src/main/exercici0306/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0306.Main
```

Demani dos números a l'usuari i una operació matemàtica (suma, resta, multiplicació o divisió).

- El programa ha d'utilitzar un switch per executar l'operació i mostrar el resultat.

Requisits:
- L'operació s'indica amb un símbol (+, -, *, /).
- Gestiona la divisió per zero mostrant un missatge d'error.
- Mostra un missatge d'error si l'operació no és vàlida.

Exemples de sortida:

```text
Escriu el primer número: 10
Escriu el segon número: 5
Escriu l'operació (+, -, *, /): *
El resultat és: 50
```

```text
Escriu el primer número: 10
Escriu el segon número: 0
Escriu l'operació (+, -, *, /): /
Error: No es pot dividir per zero.
```

```text
Escriu el primer número: 10
Escriu el segon número: 5
Escriu l'operació (+, -, *, /): ^
Error: Operació no vàlida.
```

### Exercici 0307

Modifica el codi de:

```bash
src/main/exercici0307/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0307.Main
```

Demani a l'usuari la seva edat i la classifica segons:

```text
0-12 anys: Nen
13-17 anys: Adolescent
18-64 anys: Adult
65 anys o més: Jubilat
```

- Si l'edat no és positiva, mostra un missatge d'error.
