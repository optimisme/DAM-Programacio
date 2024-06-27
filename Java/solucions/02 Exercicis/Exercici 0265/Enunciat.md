<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 65

Fes un programa que demana a l'usuari una llista de números enters separats per comes.

A continuació fes una funció (calcula_valors) que retorni aquests valors:

* La suma de tots els elements de la llista
* El valor més gran de la llista
* El valor més petit de la llista
* La mitjana de tots els elements de la llista

Fes les funcions:
```java
    public static int calculaSuma(List<Integer> numeros) {
    // Calcula la suma d'una llista d'enters
    }

    public static int calculaMaxim(List<Integer> numeros) {
    // Retorna el màxim d'una llista d'enters
    }

    public static int calculaMinim(List<Integer> numeros) {
    // Retorna el mínim d'una llista d'enters
    }

    public static double calculaMitjana(List<Integer> numeros) {
    // Retorna la mitjana d'una llista d'enters
    }
```

Comprova:

* "4,8,7,2,5,3,9" > Suma = 38, Màxim = 9, Mínim = 2, Mitjana = 5.43
* "7,2,4,8,4,2" > Suma = 27, Màxim = 8, Mínim = 2, Mitjana = 4.5

Exemple:
```text
Introdueix una llista de números enters separats per comes:
45,23,87,12,5
Suma = 172, Màxim = 87, Mínim = 5, Mitjana = 34.40
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```