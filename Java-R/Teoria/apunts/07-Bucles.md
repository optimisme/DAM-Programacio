<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Iteracions (aka Bucles)

<center>
<img src="./assets/07dowhile.png" height="300" alt="Logo de IETI" style="max-height: 300px;"/>
</center>

## for

Es fa servir quan es coneix quantes vegades s'ha de repetir un bloc de codi.

Les parts del *for* són:

- Valor d'inici (i tipus)
- Condició de sortida del bucle
- Canvi de valor a cada iteració

### Exemple 0700

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0700.Main
```

```java
package com.exemple0700;

public class Main {

    public static void main(String[] args) {

        for (int contador = 0; contador < 5; contador = contador + 1) {

            System.out.println("Iteració: " + contador);
        }
    }
}
```

### Exercici 0700

Modifica el codi de:

```bash
src/main/exercici0700/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0700.Main
```

Escriu un programa que demani números separats per coma a l'usuari, els posi en un array fent servir **split** i faci servir un bucle **for** per sumar tots els valors:

Exemple de sortida:
```text
Escriu numeros separats per ",": 10,25,30,40,50 
Array: [10, 25, 30, 40, 50]
La suma dels elements és: 155
```

### Exercici 0701

Modifica el codi de:

```bash
src/main/exercici0701/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0701.Main
```

Escriu un programa que demani números separats per coma a l'usuari, els posi en un array fent servir **split** i faci servir un bucle **for** per calcular la mitjana:

Exemple de sortida:
```text
Escriu numeros separats per ",": 15,25,30,40,50 
Array: [15, 25, 30, 40, 50]
La mitjana dels números és: 32.0
```

## for-each

Permet iterar sobre col·leccions o arrays sense necessitat de gestionar manualment els índexs.

Dins del bucle tenim disponible cada un dels valors de l'array.

### Exemple 0701

Iterar un **Array**:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0701.Main
```

```java
package com.exemple0701;

public class Main {

    public static void main(String[] args) {

        int[] numeros = {10, 20, 30, 40, 50};

        for (int num : numeros) {

            System.out.println("Número: " + num);
        }
    }
}
```

### Exemple 0702

Iterar un **ArrayList**:

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0702.Main
```

```java
package com.exemple0702;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Crear un ArrayList i afegir elements
        ArrayList<String> noms = new ArrayList<>();
        noms.add("Anna");
        noms.add("Joan");
        noms.add("Maria");
        noms.add("Pere");

        // Iterar pels elements del ArrayList
        for (String nom : noms) {
            System.out.println("Nom: " + nom);
        }
    }
}
```

### Exercici 0702

Modifica el codi de:

```bash
src/main/exercici0702/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0702.Main
```

Escriu un programa que demani una llista de números a l'usuari, separats per coma ',' i compti quants són parells:

Exemple de sortida:
```text
Escriu numeros separats per ",": 15,25,30,40,50 
Números parells: 3
```

### Exercici 0703

Modifica el codi de:

```bash
src/main/exercici0703/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0703.Main
```

Escriu un programa que demani 4 números a l'usuari, els números s'han d'escriure un per un i anar-los afegint a un **ArrayList**. Després, s'han de buscar el valor *màxim* i *mínim* a partir d'un bucle **for-each**.

Exemple de sortida:
```text
Escriu un número: 45
Escriu un número: 12
Escriu un número: 78
Escriu un número: 4
Números: [45, 12, 78, 4]
Valor màxim: 78
Valor mínim: 4
```

### for vs for-each

Es recomana fer servir *for* quan necessitem l'index i el valor, en canvi es recomana fer servir *for-each* quan només necessitem el valor:

**Índex i valor (for):**

```java
int[] numeros = {10, 20, 30, 40, 50};

for (int i = 0; i < numeros.length; i++) {
    System.out.println("Índex: " + i + ", Número: " + numeros[i]);
}
```

**Només valor (for-each):**
```java
for (int num : numeros) {
    System.out.println("Número: " + num);
}
```

## while

Quan vols repetir un bloc de codi mentre es compleix una condició.

En el següent exemple la condició **per executar** el bucle és `(cnt < 5)`

### Exemple 0703

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0703.Main
```

```java
package com.exemple0703;

public class Main {

    public static void main(String[] args) {

        int cnt = 0;
        while (cnt < 5) {
            System.out.println("Iteració: " + cnt);
            cnt++;
        }
    }
}
```

### Exercici 0704

Modifica el codi de:

```bash
src/main/exercici0704/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0704.Main
```

Escriu un programa que demani noms a l'usuari, i anar-los afegint a un **ArrayList** fins que l'usuari escrigui **"sortir"**. Després, s'han de comptar els noms que començen per vocal.

Exemple de sortida:
```text
Escriu un nom (o "sortir"): Anna
Escriu un nom (o "sortir"): Joan
Escriu un nom (o "sortir"): Irene
Escriu un nom (o "sortir"): Eduard
Escriu un nom (o "sortir"): sortir
Noms introduïts: [Anna, Joan, Irene, Eduard]
Noms que comencen per vocal: 3
```

### Exercici 0705

Modifica el codi de:

```bash
src/main/exercici0705/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0705.Main
```

Escriu un programa que demani noms a l'usuari, i anar-los afegint a un **ArrayList** fins que l'usuari escrigui **"sortir"**. Després, utilitza un bucle **for-each** per trobar el nom més llarg de la llista i mostrar-lo.

Exemple de sortida:
```text
Escriu un nom (o "sortir"): Anna
Escriu un nom (o "sortir"): Joan
Escriu un nom (o "sortir"): Irene
Escriu un nom (o "sortir"): Eduard
Escriu un nom (o "sortir"): sortir
Noms introduïts: [Anna, Joan, Irene, Eduard]
El nom més llarg és: Eduard
```

## do-while

Similar al while, però garanteix que el codi dins del bucle s'executarà almenys una vegada, perquè la condició es comprova després de l'execució del bloc de codi.

En el següent exemple la condició **per no tornar a executar** el bucle és `(cnt < 5)`

### Exemple 0704

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0704.Main
```

```java
package com.exemple0704;

public class Main {

    public static void main(String[] args) {

        int cnt = 0;
        do {
            System.out.println("Iteració: " + cnt);
            cnt = cnt + 1;
        } while (cnt < 5);
    }
}
```