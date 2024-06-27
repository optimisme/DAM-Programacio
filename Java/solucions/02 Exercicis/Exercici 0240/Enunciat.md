<div style="display: flex; width: 100%;">
    <div style="flex: 1; padding: 0px;">
        <p>© Albert Palacios Jiménez, 2023</p>
    </div>
    <div style="flex: 1; padding: 0px; text-align: right;">
        <img src="../../assets/ieti.png" height="32" alt="Logo de IETI" style="max-height: 32px;">
    </div>
</div>
<hr/>

### Exercici 40

Fes un programa que sumi els números dins d'un rang.

Primer s'ha de demanar els números del rang.

El dos números escrits, s'han d'ordenar de petit a gran.

Per exemple:

- Entre 2 i 5: 2 + 3 + 4 + 5 = 14

- Entre 10 i 15: 10 + 11 + 12 + 13 + 14 + 15 = 75

S'ha de retornar el resultat:

- La suma entre 2 i 5 és 14 

- La suma entre 10 i 15 és 75 

El programa ha de tenir la següent funció:
```java
    public static String calculateSumInRange(int num1, int num2) {
    // Retorna "La suma entre %d i %d és %d" amb la suma dels números dins del rang 'num1' i 'num2'
    }
```

Exemple:
```text
Introdueix el primer número del rang: 4
Introdueix el segon número del rang: 11
La suma entre 4 i 11 és 60
```

Executa el programa:
```bash
./run.sh com.project.Main
```

Valida amb el test:
```bash
./runTest.sh com.project.TestMain
```