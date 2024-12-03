<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Funcions

Les **funcions** són blocs d'instruccions que ajuden a organitzar el codi. Això permet:

- Reutilitzar codi
- Millorar la lectura del codi i el manteniment
- Reduir errors, menys codi a mantenir 
- Dividir un programa complex en parts més senzilles

En **Java** les funciones tenen les següents parts:

- **returnType**: El tipus de variable que retorna el mètode (o *void* si no retorna res)
- **methodName**: El nom del mètode (normalment amb notació *camelCase*)
- **parameters**: Els paràmetres o valors que rep el mètode quan es crida
- **return**: Retorna el resultat del mètode (opcional)

```java
returnType methodName(parameters) {
    // Cos del mètode
    return value; // Opcional si no és `void`
}
```

### Exemple 0400

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0400.Main
```

```java
package com.exemple0400;

public class Main {

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println("Suma 3+4=" + sumar(3, 4));
        System.out.println("Suma -2.5+6=" + sumar(-2.5, 6));
    }
}
```

### Exercici 0400

Modifica el codi de:

```bash
src/main/exercici0400/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0400.Main
```

Demani dues paraules a l'usuari i cridi a la funció **concatenaParaules** que retorna la seva concatenació amb un espai al mig.

```java
public static String concatenaParaules(String a, String b)
```

Exemple de sortida:
```text
Escriu la primera paraula: Hola
Escriu la segona paraula: món
Resultat: Hola món
```

## Sobrecàrrega de funcions

**Java** permet definir diferents funcions amb el mateix nom, però diferents paràmetres. D'això s'en diu **sobrecàrrega**:


### Exemple 0401

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0401.Main
```

```java
package com.exemple0401;

public class Main {

    public static double sumar(double a, double b) {
        return a + b;
    }

    public static double sumar(double a, double b, double c) {
        return a + b;
    }

    public static void main(String[] args) {

        System.out.println("Suma 3+4=" + sumar(3, 4));
        System.out.println("Suma -2.5+6+4=" + sumar(-2.5, 6, 4));
    }
}
```

### Exercici 0401

Modifica el codi de:

```bash
src/main/exercici0401/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0401.Main
```

Tingui dues funcions saludar, que retornen *"Hola, "*i el nom o bé el títol i el nom.

```java
public static String saludar(String nom)
public static String saludar(String titol, String nom)
```

Exemple de crida:
```java
saludar("Erik");
saludar("Sr.", "Toni");
saludar("Sra.", "Eva");
```

Exemple de sortida:
```text
Hola, Erik
Hola, Sr. Toni
Hola, Sra. Eva
```

### Exercici 0402

Modifica el codi de:

```bash
src/main/exercici0402/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0402.Main
```

Calculi el preu d'un producte aplicant un % d'impost. La funció s'ha de dir *calculaPreu* i rep dos paràmetres:

- **preuBase**: preu sense l'impost
- **percentatge**: valor que s'aplica amb l'impost

```java
public static double calcularImpost(double preu, double percentatge)
```

Aquesta és la fórmula del resultat a retornar: **preu * (percentatge / 100)**

Exemple de crida:
```java
calculaPreu(100.0, 21.0);
```

Exemple de sortida:
```text
Preu: 100.0€
Percentatge: 21.0%
Valor de venta: 121.0€
```

### Exercici 0403

Modifica el codi de:

```bash
src/main/exercici0402/Main.java
```

Per fer que quan s'executa el programa amb:

```bash
./run.sh com.exercici0403.Main
```

Calculi l'àrea d'un rectangle a partir d'un *"ample"* i un *"alt"*

```java
public static double calcularAreaRectangle(double ample, double alt)
```

La formúla és: *"ample * alt"*

Exemple de sortida:
```text
Amplada: 5.0 unitats
Alçada: 3.0 unitats
Àrea del rectangle: 15.0 unitats quadrades
```