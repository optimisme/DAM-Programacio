<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 43

Fes un programa que donat un rang determinat, mostri els números imparells.

Hauràs de fer la funció 'esImparell' que retorna 'True' si el número és imparell i 'False' si és parell.

Per exemple:

- Entre 2 i 5: 3, 5

- Entre 10 i 15: 11, 13, 15

Hauràs de fer les següents funcions:
```java
    public static boolean esImparell(int num) {
    // Retorna 'true' si 'num' és imparell
    }

    public static String getOddNumbersInRange(int num1, int num2) {
    // Retorna la cadena de text amb els números imparells del rang entre 'num1' i 'num2'
    }
```

Exemples:
```text
Introdueix el primer número del rang: 2
Introdueix el segon número del rang: 8
3 5 7
```

```text
Introdueix el primer número del rang: 56
Introdueix el segon número del rang: 40
41 43 45 47 49 51 53 55
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```