<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="./assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

# Excepcions

Una excepció és **una situació que interromp el flux normal d'execució** d'un programa. 

Controlar les excepcions permet fer que el programa pugui recuperar-se o finalitzar-se de manera controlada.

## Capturar excepcions

Les excepcions es poden capturar, per donar un codi alternatiu en cas que falli l'execució.

Les parts d'una excepció són:

- **try**: el codi susceptible de generar una excepció
- **catch**: captura i gestiona una excepció específica (n'hi pot haver diversos)
- **finally**: s'executa sempre, independentment de si es produeix una excepció o no (és opcional)

### Exemple 0800

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0800.Main
```

```java
package com.exemple0800;

public class Main {

    public static void main(String[] args) {
        try {
            int result = 10 / 0; // Llança ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Divisió per zero");
        } finally {
            System.out.println("Bloc finally executat.");
        }
    }
}
```

Es poden capturar diverses excepcions o bé posar un *catch* genèric per excepcions desconegudes:

### Exemple 0801

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0801.Main
```

```java
package com.exemple0801;

public class Main {

    public static void main(String[] args) {
        try {
            int[] nums = {1, 2, 3};

            System.out.println(nums[5]);

            int result = 10 / 0;

        } catch (ArithmeticException e) {
            // Bloc per divisions per 0
            System.out.println("Error: Divisió per zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            // Bloc per crides fora de rang
            System.out.println("Error: Índex fora de rang.");
        } catch (Exception e) {
            // Bloc per excepcions desconegudes
            System.out.println("Error desconegut: " + e.getMessage());
        } finally {
            System.out.println("Bloc finally executat. Aquí pots alliberar recursos.");
        }
    }
}
```

## Llançar excepcions

També es pot fer, que quan detectem un error, llançem una excepció a quin ha cridat el nostre codi (funció) perquè tractin l'excepció degudament. Per fer-ho:

- Cal indicar **throws** i el tipus d'excepció
- Cal crear i llançar l'excepció amb **throw new**

### Exemple 0802

```bash
# Fes anar l'exemple amb
./run.sh com.exemple0802.Main
```

```java
package com.exemple0802;

public class Main {

    public static void verificarEdat(int edat) throws IllegalArgumentException {
        if (edat < 18) {
            throw new IllegalArgumentException("Edat no vàlida: Cal ser major de 18 anys.");
        }
    }

    public static void main(String[] args) {

        try {
            // Exemple d'una edat no vàlida
            Main.verificarEdat(16);

            // No es mostra perquè falla al '16'
            System.out.println("Edat vàlida."); 
        } catch (IllegalArgumentException e) {

            // Gestiona l'excepció
            System.out.println("Error: " + e.getMessage()); 
        } finally {

            // S'executa sempre
            System.out.println("Verificació completada."); 
        }
    }
}
```