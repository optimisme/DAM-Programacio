<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Operacions matemàtiques

Les variables poden guardar el resultat d'operacions matemàtiques:

- **`+`**: sumar
- **`-`**: restar
- **`*`**: multiplicar
- **`/`**: dividir
- **`%`**: mòdul (residu d'una divisió)

Exemple d'operació matemàtica:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0200.Main
```

```java
package com.exemple0200;

public class Main {
    public static void main(String[] args) {

        float iva = 20;
        float preu = 200;
        float preuVenda = preu + (preu * iva / 100);

        System.out.println("El preu del producte és " + preu + "€, i amb l'IVA es pot comprar per: " + preuVenda);
    }
}
```

### Exercici 0200

Modifica el codi de:

```bash
src/main/exercici0200/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0200.Main
```

Demani el radi d'un cercle i calculi la seva àrea: 

*Àrea = π * radi^2*

A **Java** pots obtenir el valor de Pi amb:
```java
double pi = Math.PI;
System.out.println("El valor de π és: " + pi);
```

### Exercici 0201

Modifica el codi de:

```bash
src/main/exercici0201/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0201.Main
```

Demani una temperatura i calculi el seu valor en graus Farenheit: 

```text
Fahrenheit = (Celsius * 9/5) + 32
```

### Exercici 0202

Modifica el codi de:

```bash
src/main/exercici0202/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0202.Main
```

Demani el preu original d'un producte, un percentatge de descompte i calculi el preu final:

```text
Preu final = Preu original - (Preu original * % descompte / 100)
```

### Exercici 0203

Modifica el codi de:

```bash
src/main/exercici0203/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0203.Main
```

Demani tres valors i en calcula la mitjana:

```text
Mitjana = (n1 + n2 + n3) / 3
```

### Exercici 0204

Modifica el codi de:

```bash
src/main/exercici0204/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0204.Main
```

Demana a l'usuari que escrigui les hores, minuts i segons d'una hora i escriu el seu valor en segons:

```text
Total segons = (hores * 3600) + (minuts * 60) + segons
```

## Operacions booleanes

En **Java** les operacions booleanes són:

- **&&**: per l'operador AND (i)
- **||**: per l'operador OR (o)
- **!**: per l'operador NOT (no)

**Nota**: Recordatori de les operacions booleanes:

```text
|   x   |   y   |     | x && y | x || y |  !x   |
|-------|-------|     |--------|--------|-------|
| true  | true  |     | true   | true   | false |
| true  | false |     | false  | true   | false |
| false | true  |     | false  | true   | true  |
| false | false |     | false  | false  | true  |
```

Exemples d'operacions booleanes:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0201.Main
```

```java
package com.exemple0201;

public class Main {
    public static void main(String[] args) {

        boolean a = true;
        boolean b = false;

        System.out.println("a=" + a + "; b=" + b);
        
        // Operador AND (i)
        // Només és cert si 'a' i 'b' són 'true'
        boolean resultatAnd = a && b; 
        System.out.println("Resultat de AND: " + resultatAnd);
        
        // Operador OR (o)
        // És cert alguna de les dues 'a' o 'b' és 'true'
        boolean resultatOr = a || b; 
        System.out.println("Resultat de OR: " + resultatOr);
        
        // Operador NOT (no)
        // Inverteix el valor de 'a' (si és true dóna false ...)
        boolean resultatNot = !a; 
        System.out.println("Resultat de NOT: " + resultatNot);
    }
}
```

## Comparacions

En **Java** les comparacions es fan amb:

- **<**: és menor que
- **<=**: és menor o igual que
- **>**: és més gran que
- **>=**: és més gran o igual que
- **==**: és igual que
- **!=**: és diferent que

Exemples de comparacions:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0202.Main
```

```java
package com.exemple0202;

public class Main {
    public static void main(String[] args) {

        int x = 10;
        int y = 5;

        System.out.println("x=" + x + "; y=" + y);
        
        // 10 més gran que 5? Cert
        System.out.println("x > y: "  + (x > y)); 
        
        // 10 més gran o igual a 5? Cert
        System.out.println("x >= y: " + (x >= y));
        
        // 10 més petit que 5? Fals
        System.out.println("x <>> y: "  + (x > y)); 
        
        // 10 més petit o igual a 5? False
        System.out.println("x <>>= y: " + (x >= y));
        
        // 10 és igual a 5? Fals
        System.out.println("x == y: " + (x == y));
        
        // 10 és diferent a 5? Fals
        System.out.println("x != y: " + (x != y));
    }
}
```

### Exercici 0205

Modifica el codi de:

```bash
src/main/exercici0205/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0205.Main
```

Verifica si un número està entre dos valors escrits per l'usuari,  ha de ser 'true' o 'false'

### Exercici 0206

Modifica el codi de:

```bash
src/main/exercici0206/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0206.Main
```

Demana l'edat a l'usuari i dóna una sortida 'true' o 'false' segons si és major o igual a 18 anys

### Exercici 0207

Modifica el codi de:

```bash
src/main/exercici0207/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0207.Main
```

Calcula si un any és de traspàs (bisiesto), és a dir: si és divisible per 4 però no per 100, o si és divisible per 400

```text
((any % 4 == 0 && any % 100 != 0) || any % 400 == 0)
```

### Exercici 0208

Modifica el codi de:

```bash
src/main/exercici0208/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0208.Main
```

Demana a l'usuari dos números i diu si almenys un és negatiu, la sortida és 'true' o 'false'

### Exercici 0209

Modifica el codi de:

```bash
src/main/exercici0209/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0209.Main
```

Demana a l'usuari un número i comprova si no és positiu, és a dir no és negatiu ni tampoc 0. La sortida és 'true' o 'false'
